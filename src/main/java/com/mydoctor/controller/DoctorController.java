package com.mydoctor.controller;



import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mydoctor.model.LoginBean;
import com.mydoctor.model.Prescription;
import com.mydoctor.service.DoctorServiceImpl;
import com.mydoctor.service.PrescriptionServiceImpl;



@Controller
@SessionAttributes("username")
public class DoctorController
{
		@Autowired
		private DoctorServiceImpl doctorServiceImpl;
		private PrescriptionServiceImpl prescriptionServiceImpl;

		@RequestMapping(value="/doctor-profile",method=RequestMethod.GET)
		public String profile(ModelMap model) throws SQLException 
		{
				System.out.println((String)model.get("username"));
				model.addAttribute("doctor",doctorServiceImpl.retrieveDoctor((String)model.get("username")));
				return "doctorProfile";
		}
		
		@RequestMapping(value="/list-schedule",method=RequestMethod.GET)
		public String showDoctorSchedule(ModelMap model) throws SQLException 
		{
				System.out.println((String)model.get("username"));
				model.addAttribute("schedules",doctorServiceImpl.retriveAllSchedules((String)model.get("username")));
				
				return "schedules";
		}
		
		
		
		@RequestMapping(value="/create_prescription",method=RequestMethod.GET)
		public String showCreatePrescriptionPage(ModelMap model)
		{
			
			Prescription prescription = new Prescription();
			model.addAttribute("prescription", prescription);
			return "createPrescription";
		}
		
		
		@RequestMapping(value="/create_prescription",method=RequestMethod.POST)
		public String addPrescription(ModelMap model, @Valid Prescription prescription, BindingResult result) throws SQLException
		{
				
				if(result.hasErrors()){
					return "prescription";
				}
				// prescriptionId, medicineId, instruction, amount
				String medicineId = prescription.getMedicineId();
				//String medicine = prescription.
				String instruction = prescription.getInstruction();
				String amount = prescription.getAmount();
//				boolean isValidUser = loginServiceImpl.isValidUser(username, password);
//				if(isValidUser)
//				{
//					String role = loginServiceImpl.getUserRole(username);
//					model.put("username",username);
//					model.remove("loginBean");
//						if("patient".equals(role)){
//							return "welcomePatient";
//						}
//						else if("doctor".equals(role)){
//							return "welcomeDoctor";
//						}
//						else if("staff".equals(role)){
//							return "welcomeStaff";
//						}
//						else if("nurse".equals(role)){
//							return "welcomeNurse";
//						}
//						else if("pharmacist".equals(role)){
//							return "welcomePharmacist";
//						}
//				}
//				else
//				{
//						model.put("message", "Invalid credentials!!");
//						return "login";
//				}

				
				return "prescription";
		}
		
		
		
}
