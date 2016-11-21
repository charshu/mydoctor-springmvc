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
import com.mydoctor.model.Patient;
import com.mydoctor.model.Schedule;
import com.mydoctor.model.ViewInfo;
import com.mydoctor.service.AppointmentServiceImpl;
import com.mydoctor.service.DoctorServiceImpl;
import com.mydoctor.service.PatientServiceImpl;



@Controller
@SessionAttributes("username")
public class PatientController
{
		@Autowired
		private PatientServiceImpl patientServiceImpl;
		@Autowired
		private AppointmentServiceImpl appointmentServiceImpl;
		@Autowired
		private DoctorServiceImpl doctorServiceImpl;
		
		@RequestMapping(value="/welcomePatient",method=RequestMethod.GET)
		public String welcomeNurse(ModelMap model) throws SQLException 
		{
				
				return "welcomePatient";
		}
		
		@RequestMapping(value="/patient-profile",method=RequestMethod.GET)
		public String profile(ModelMap model) throws SQLException 
		{
			Patient patient = patientServiceImpl.retrievePatient((String)model.get("username"));
				model.addAttribute("patient",patient);
				model.addAttribute("new_patient",patient);
				return "patientProfile";
		}
		
		/*@RequestMapping(value="/edit-info",method=RequestMethod.GET)
		public String editProfileInfo(ModelMap model) throws SQLException 
		{
				model.addAttribute("patient",patientServiceImpl.retrievePatient((String)model.get("username")));
				model.addAttribute("new_patient",new Patient());
				return "patientProfile";
		}		*/
		
		@RequestMapping(value="/edit-info",method=RequestMethod.POST)
		public String editProfile(ModelMap model,@Valid Patient new_patient, BindingResult result) throws SQLException 
		{
			System.out.println("[Request]" + new_patient.toString());
			if(result.hasErrors()){
				return "patientProfile";
			}
			int updateCount = patientServiceImpl.edit_info((String)model.get("username"),new_patient);
		   if(updateCount > 0) {
			   return "redirect:/patient-profile";
		   }
		   return "redirect:/patient-profile";
			}
		
		
		@RequestMapping(value="/list-appointment",method=RequestMethod.GET)
		public String showAppointmentList(ModelMap model) throws SQLException 
		{
				System.out.println((String)model.get("username"));
				model.addAttribute("appointments",patientServiceImpl.retrieveAllAppointments((String)model.get("username")));
				return "patientAppointment";
		}
		@RequestMapping(value="/choose-doctor",method=RequestMethod.GET)
		public String showDoctorListPage(ModelMap model) throws SQLException 
		{
				System.out.println((String)model.get("username"));
				System.out.println("[REQUEST] retrieve all doctors");
				model.addAttribute("doctors",doctorServiceImpl.retrieveAllDoctors());
				return "chooseDoctor";
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
		
		@RequestMapping(value="/new-appointment",method=RequestMethod.GET)
		public String addSchedule(@RequestParam("doctorId") String doctor_id,ModelMap model) throws SQLException 
		{
				model.addAttribute("suggestDateTimes", appointmentServiceImpl.findDoctorAllAvailableTime(Integer.parseInt(doctor_id)));
				model.addAttribute("doctor", doctorServiceImpl.retrieveDoctor(Integer.parseInt(doctor_id)));
				
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
