package com.mydoctor.controller;



import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mydoctor.service.PatientServiceImpl;



@Controller
@SessionAttributes("username")
public class PatientController
{
		@Autowired
		private PatientServiceImpl patientServiceImpl;

		@RequestMapping(value="/patient-profile",method=RequestMethod.GET)
		public String profile(ModelMap model) throws SQLException 
		{
				model.addAttribute("patient",patientServiceImpl.retrievePatient((String)model.get("username")));
				return "patientProfile";
		}
		
		@RequestMapping(value="/list-appointment",method=RequestMethod.GET)
		public String showAppointmentPage(ModelMap model) throws SQLException 
		{
				model.addAttribute("appointments",patientServiceImpl.retrieveAllAppointments((String)model.get("username")));
				return "patientProfile";
		}
		
		
		
}
