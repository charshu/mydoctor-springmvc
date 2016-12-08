package com.mydoctor.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;



import com.mydoctor.model.LoginBean;
import com.mydoctor.model.Patient;
import com.mydoctor.service.LoginServiceImpl;
import com.mydoctor.service.PatientServiceImpl;
import com.mydoctor.util.EmailService;

@Controller
@SessionAttributes("username")
public class LoginController {

	@Autowired
	private LoginServiceImpl loginServiceImpl;
	@Autowired
	private PatientServiceImpl patientServiceImpl;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		
		LoginBean loginBean = new LoginBean();
		model.addAttribute("loginBean", loginBean);
		return "login";
	}
		
		
		@RequestMapping(value="/",method=RequestMethod.POST)
		public String executeLogin(ModelMap model, @Valid LoginBean loginBean, BindingResult result) throws SQLException
		{
				
				if(result.hasErrors()){
					return "login";
				}
				String username = loginBean.getUsername();
				String password = loginBean.getPassword();
				boolean isValidUser = loginServiceImpl.isValidUser(username, password);
				if(isValidUser)
				{
					String role = loginServiceImpl.getUserRole(username);
					model.put("username",username);
					model.remove("loginBean");
						if("patient".equals(role)){
							return "welcomePatient";
						}
						else if("doctor".equals(role)){
							return "redirect:/welcomeDoctor";
						}
						else if("staff".equals(role)){
							return "redirect:/welcomeStaff";
						}
						else if("nurse".equals(role)){
							return "redirect:/welcomeNurse";
						}

						else if("staff".equals(role)){
							return "redirect:/welcomeStaff";
						}
						else if("pharmacist".equals(role)){
							return "redirect:/welcomePharmacist";

						}
				}
				else
				{
						model.put("message", "Invalid credentials!!");
						return "login";
				}
				return "login";
		}



	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model, SessionStatus status) {
		model.clear();
		status.setComplete();
		return "redirect:/";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String clickRegister(ModelMap model) {
		return "chooseRegister";
	}
	
	@RequestMapping(value = "/register-new", method = RequestMethod.GET)
	public String showRegisterNew(ModelMap model,@RequestParam(value="error",required=false,defaultValue = "")String error) throws SQLException{
		Patient patient = new Patient();
		model.addAttribute("patient",patient);
		model.addAttribute("error",error);
		return "registerNewPatient";
	}
	
	@RequestMapping(value = "/register-new", method = RequestMethod.POST)
	public String RegisterNew(ModelMap model, @Valid Patient patient, BindingResult result) throws SQLException {
		System.out.println("[Request]" + patient.toString());
		if(result.hasErrors()){
			return "registerNewPatient";
		}
		
		String hospitalNumber = loginServiceImpl.registerPatient(patient);
		if(hospitalNumber.equals("-2")){
			return "redirect:/register-new?error=-2";
		}
		if(hospitalNumber.equals("-3")){
			return "redirect:/register-new?error=-3";
		}
		if(hospitalNumber.equals("-4")){
			return "redirect:/register-new?error=-4";
		}
		
		System.out.println(hospitalNumber);
		if(hospitalNumber != ""){
			model.clear();
			patient.setHospitalNumber(hospitalNumber);
			EmailService.emailNewUser(patient);
			model.addAttribute("email", patient.getEmail());
			model.addAttribute("hospitalNumber", hospitalNumber);
			return "showHospitalNumber_new";
		} 
		return "registerNewPatient";
	}

	@RequestMapping(value = "/register-old", method = RequestMethod.GET)
	public String showRegisterOld(ModelMap model,@RequestParam(value="error",required=false,defaultValue = "")String error) throws SQLException{
		Patient patient = new Patient();
		model.addAttribute("error", error);
		model.addAttribute("patient",patient);
		return "registerOldPatient";
	}
	
	@RequestMapping(value = "/register-old", method = RequestMethod.POST)
	public String RegisterOld(ModelMap model,@ModelAttribute("patient")Patient patient
			,BindingResult result) throws SQLException {
		//System.out.println("[Request]" + patient.toString());
		if(result.hasErrors()){
			return "registerOldPatient";
		}
		String hospitalNumber = patient.getHospitalNumber();
		String ssn = patient.getSsn();
		if(hospitalNumber != ""){
			int code = loginServiceImpl.createUserIdByHN(patient);
			if(code ==-2)return "redirect:/register-old?error=-2";
			if(code ==-5)return "redirect:/register-old?error=-5";
			String username = patient.getUsername1();
			String password = patient.getPassword1();
			patient = patientServiceImpl.retrievePatientByHN(hospitalNumber);
			patient.setUsername1(username);
			patient.setPassword1(password);
			EmailService.emailOldUser(patient);
			model.clear();
			model.addAttribute("email", patient.getEmail());
			return "success";
		}
		else if(ssn != ""){
			int code = loginServiceImpl.createUserIdBySSN(patient);
			if(code ==-2)return "redirect:/register-old?error=-2";
			if(code ==-6)return "redirect:/register-old?error=-6";
			String username = patient.getUsername1();
			String password = patient.getPassword1();
			patient = patientServiceImpl.retrievePatientBySSN(ssn);
			EmailService.emailOldUser(patient);
			patient.setUsername1(username);
			patient.setPassword1(password);
			model.clear();
			model.addAttribute("email", patient.getEmail());
			return "success";
		}
		return "registerOldPatient";
	}
	
	
	
	
}
