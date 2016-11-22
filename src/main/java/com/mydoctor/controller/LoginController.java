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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.mydoctor.model.LoginBean;
import com.mydoctor.model.Patient;
import com.mydoctor.service.LoginServiceImpl;

@Controller
@SessionAttributes("username")
public class LoginController {

	@Autowired
	private LoginServiceImpl loginServiceImpl;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {

		LoginBean loginBean = new LoginBean();
		model.addAttribute("loginBean", loginBean);
		return "login";
	}
		
		
		@RequestMapping(value="/login",method=RequestMethod.POST)
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
							return "welcomeDoctor";
						}
						else if("staff".equals(role)){
							return "welcomeStaff";
						}
						else if("nurse".equals(role)){
							return "welcomeNurse";
						}

						else if("staff".equals(role)){
							return "welcomeStaff";
						}
						else if("pharmacist".equals(role)){
							return "welcomePharmacist";

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
		status.setComplete();
		return "redirect:/login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String clickRegister(ModelMap model) {
		return "chooseRegister";
	}
	
	@RequestMapping(value = "/register-new", method = RequestMethod.GET)
	public String showRegisterNew(ModelMap model) throws SQLException{
		Patient patient = new Patient();
		model.addAttribute("patient",patient);
		return "registerNewPatient";
	}
	
	@RequestMapping(value = "/register-new", method = RequestMethod.POST)
	public String RegisterNew(ModelMap model, @Valid Patient patient, BindingResult result) throws SQLException {
		System.out.println("[Request]" + patient.toString());
		if(result.hasErrors()){
			return "registerNewPatient";
		}
		
		String hospitalNumber = loginServiceImpl.registerPatient(patient);
		
		System.out.println(hospitalNumber);
		if(hospitalNumber != ""){
			model.clear();
			//model.addAttribute("patient",patient);
			model.addAttribute("hospitalNumber", hospitalNumber);
			return "showHospitalNumber_new";
		} 
		return "registerNewPatient";
	}

	@RequestMapping(value = "/register-old", method = RequestMethod.GET)
	public String showRegisterOld(ModelMap model) throws SQLException{
		Patient patient = new Patient();
		model.addAttribute("patient",patient);
		return "registerOldPatient";
	}
	
	@RequestMapping(value = "/register-old", method = RequestMethod.POST)
	public String RegisterOld(ModelMap model,@ModelAttribute("patient")Patient patient, BindingResult result) throws SQLException {
		System.out.println("[Request]" + patient.toString());
		if(result.hasErrors()){
			return "registerOldPatient";
		}
		String hospitalNumber = patient.getHospitalNumber();
		String ssn = patient.getSsn();
		if(hospitalNumber != ""){
			loginServiceImpl.createUserIdByHN(patient);
			model.clear();
			return "success";
		}
		else if(ssn != ""){
			loginServiceImpl.createUserIdBySSN(patient);
			model.clear();
			return "success";
		}
		return "registerOldPatient";
	}
	
	
}
