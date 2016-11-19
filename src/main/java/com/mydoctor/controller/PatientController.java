package com.mydoctor.controller;



import java.beans.PropertyEditorSupport;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mydoctor.model.Appointment;
import com.mydoctor.model.Schedule;
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
		public String showAppointmentList(ModelMap model) throws SQLException 
		{
				System.out.println((String)model.get("username"));
				model.addAttribute("appointments",patientServiceImpl.retrieveAllAppointments((String)model.get("username")));
				return "patientAppointment";
		}
		@RequestMapping(value="/add-appointment",method=RequestMethod.GET)
		public String showAddAppointmentPage(ModelMap model) throws SQLException 
		{
				System.out.println((String)model.get("username"));
				model.addAttribute("appointment",new Appointment());
				return "addAppointment";
		}
		
		@InitBinder
		public void binder(WebDataBinder binder) {
			binder.registerCustomEditor(Timestamp.class,
		    new PropertyEditorSupport() {
		        public void setAsText(String value) {
		            try {
		            	DateFormat df = new SimpleDateFormat("E dd-MM-YYYY HH:mm");
		                Date parsedDate = df.parse(value);
		                Calendar c = Calendar.getInstance(); 
		                c.setTime(parsedDate); 
		                c.add(Calendar.DATE, -7);
		                c.add(Calendar.MONTH, -1);
		                c.add(Calendar.YEAR, 1);
		                parsedDate = c.getTime();
		               System.out.println(df.format(parsedDate));
		                setValue(new Timestamp(parsedDate.getTime()));
		            } catch (ParseException e) {
		                setValue(null);
		            }
		        }
		    });
		}
		
		@RequestMapping(value="/add-appointment",method=RequestMethod.POST)
		public String addSchedule(ModelMap model,@Valid Appointment appointment, BindingResult result) throws SQLException 
		{
				System.out.println("[Request]" + appointment.toString());
				
				if(result.hasErrors()){
					return "addAppointment";
				}
				
				Timestamp suggestDateTime = patientServiceImpl.findNearestTime((String)model.get("username"), appointment);		
				return "confirmAppointment";
				
		}
		@RequestMapping(value="/cancel-appointment",method=RequestMethod.GET)
		public String cancelAppointment(ModelMap model,@RequestParam String appointment_id) throws SQLException 
		{
				System.out.println((String)model.get("username"));
				patientServiceImpl.cancelAppointment((String)model.get("username"),Integer.parseInt(appointment_id));
				return "redirect:/list-appointment";
		}
		
		
		
}
