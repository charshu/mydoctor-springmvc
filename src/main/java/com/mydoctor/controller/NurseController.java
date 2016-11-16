package com.mydoctor.controller;



import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mydoctor.service.NurseServiceImpl;
import com.mydoctor.service.UserService;



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
		
		
		
		
}
