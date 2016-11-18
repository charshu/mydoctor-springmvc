package com.mydoctor.controller;



import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mydoctor.model.Schedule;
import com.mydoctor.service.DoctorServiceImpl;



@Controller
@SessionAttributes("username")
public class DoctorController
{
		@Autowired
		private DoctorServiceImpl doctorServiceImpl;
		
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
		@RequestMapping(value="/add-schedule",method=RequestMethod.GET)
		public String showAddSchedulePage(ModelMap model) throws SQLException 
		{
				System.out.println((String)model.get("username"));
				model.addAttribute("schedule",new Schedule());
				return "addSchedule";
		}
		
		@InitBinder
		public void binder(WebDataBinder binder) {
			binder.registerCustomEditor(Timestamp.class,
		    new PropertyEditorSupport() {
		        public void setAsText(String value) {
		            try {
		                Date parsedDate = new SimpleDateFormat("dd-MM-YYYY HH:mm").parse(value);
		               
		                setValue(new Timestamp(parsedDate.getTime()));
		            } catch (ParseException e) {
		                setValue(null);
		            }
		        }
		    });
		}
		
		@RequestMapping(value="/add-schedule",method=RequestMethod.POST)
		public String addSchedule(ModelMap model,@Valid Schedule schedule, BindingResult result) throws SQLException 
		{
				//System.out.println(schedule.toString());
				System.out.println(schedule.toString());
				model.clear();
				return "redirect:/list-schedule";
		}
		
		
		
}
