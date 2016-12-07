package com.mydoctor.controller;



import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mydoctor.model.GeneralInfo;
import com.mydoctor.model.Patient;
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
		
		
		
		@RequestMapping(value="/welcomeNurse",method=RequestMethod.GET)
		public String welcomeNurse(ModelMap model) throws SQLException 
		{
				
				return "welcomeNurse";
		}
		
		@RequestMapping(value="/add-info",method=RequestMethod.GET)
		public String showPatientInfoForm(@RequestParam(required = false) String msg,ModelMap model) throws SQLException 
		{
				GeneralInfo generalInfo = new GeneralInfo();
				model.addAttribute("generalInfo",generalInfo);
				System.out.println(msg);
				model.addAttribute("msg", msg);
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
				model.put("msg", "success");
				return "redirect:/add-info";
			}else{
				model.clear();
				model.put("msg", "fail");
				return "redirect:/add-info";
			}
			

			
		}
		
		@RequestMapping(value="/view-info2",method=RequestMethod.GET)
		public String getPatient(ModelMap model) throws SQLException 
		{
			model.addAttribute("viewInfo",new ViewInfo());
			return "viewPatientInfo_nurse";
		}
		
		@RequestMapping(value="/view-info2",method=RequestMethod.POST)
		public String viewPatientInfo(ModelMap model,@Valid ViewInfo viewInfo, BindingResult result) throws SQLException 
		{
			System.out.println("[Request]" + viewInfo.toString());
			if(result.hasErrors()){
				return "viewPatientInfo_nurse";
			}
			
		    GeneralInfo generalInfo = nurseServiceImpl.findPatientGenInfo(viewInfo);
		    Patient patientInfo = nurseServiceImpl.findPatientInfo(viewInfo);

		   // System.out.println(generalInfo.getCongemital());
		    model.addAttribute("generalInfo",generalInfo);
		    model.addAttribute("patientInfo",patientInfo);

			return "showPatientInfoAfterFind_nurse";	
		}
		
		
		
		
}
