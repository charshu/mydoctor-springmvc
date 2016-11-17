package com.mydoctor.controller;



import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mydoctor.model.GeneralInfo;
import com.mydoctor.service.NurseServiceImpl;



@Controller
@SessionAttributes("username")
public class NurseController
{
		@Autowired
		private NurseServiceImpl nurseServiceImpl;

		@RequestMapping(value="/nurse-profile",method=RequestMethod.GET)
		public String profile(ModelMap model) throws SQLException 
		{
				model.addAttribute("nurse",nurseServiceImpl.retrieveNurse((String)model.get("username")));
				return "nurseProfile";
		}
		
		
		
		@RequestMapping(value="/welocomeNurse",method=RequestMethod.GET)
		public String welcomeNurse(ModelMap model) throws SQLException 
		{
				
				return "welcomeNurse";
		}
		
		@RequestMapping(value="/add-info",method=RequestMethod.GET)
		public String addPatientInfo(ModelMap model) throws SQLException 
		{
				GeneralInfo generalInfo = new GeneralInfo();
				model.addAttribute("generalInfo",generalInfo);
				return "addPatientInfo";
		}
		@RequestMapping(value="/add-info",method=RequestMethod.POST)
		public String addInfo(ModelMap model) throws SQLException 
		{
				
				return "welcomeNurse";
		}
		
		
		
		
		
}
