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

import com.mydoctor.model.GeneralInfo;
import com.mydoctor.model.LoginBean;
import com.mydoctor.model.ViewInfo;
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
		public String showPatientInfoForm(ModelMap model) throws SQLException 
		{
				GeneralInfo generalInfo = new GeneralInfo();
				model.addAttribute("generalInfo",generalInfo);
				return "addPatientInfo";
		}
		
		@RequestMapping(value="/add-info",method=RequestMethod.POST)
		public String addInfo(ModelMap model, @Valid GeneralInfo generalInfo, BindingResult result) throws SQLException 
		{
			System.out.println("[Request]" + generalInfo.toString());
			if(result.hasErrors()){
				return "addPatientInfo";
			}
			int updateCount = nurseServiceImpl.add_info((String)model.get("username"),generalInfo);
			if(updateCount > 0){
				model.clear();
				return "redirect:/add-info";
			} 
			
			
			return "addPatientInfo";

			
		}
		
		@RequestMapping(value="/view-info2",method=RequestMethod.GET)
		public String getPatient(ModelMap model) throws SQLException 
		{
			model.addAttribute("viewInfo",new ViewInfo());
			return "viewPatientInfo";
		}
		
		@RequestMapping(value="/view-info2",method=RequestMethod.POST)
		public String viewPatientInfo(ModelMap model,@Valid ViewInfo viewInfo, BindingResult result) throws SQLException 
		{
			System.out.println("[Request]" + viewInfo.toString());
			if(result.hasErrors()){
				return "viewPatientInfo";
			}
		    GeneralInfo generalInfo = nurseServiceImpl.findPatientInfo((String)model.get("username"),viewInfo);
		   // System.out.println(generalInfo.getCongemital());
		    model.addAttribute("generalInfo",generalInfo);
			return "showPatientInfoAfterFind";	
		}
		
		
		
		
}
