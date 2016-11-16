package com.mydoctor.controller;



import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mydoctor.service.DoctorServiceImpl;
import com.mydoctor.service.HospitalService;
import com.mydoctor.service.UserService;



@Controller
@SessionAttributes("username")
public class DoctorController
{
		@Autowired
		private DoctorServiceImpl doctorServiceImpl;

		@RequestMapping(value="/doctor-profile",method=RequestMethod.GET)
		public String profile(ModelMap model) throws SQLException 
		{
				model.addAttribute("doctor",doctorServiceImpl.retrieveDoctor((String)model.get("username")));
				return "patientProfile";
		}
		@RequestMapping(value="/list-schedule",method=RequestMethod.GET)
		public String showDoctorSchedule(ModelMap model) throws SQLException 
		{
				model.addAttribute("doctor",doctorServiceImpl.retriveAllSchedules((String)model.get("username")));
				
				return "patientProfile";
		}
		
		
		
}
