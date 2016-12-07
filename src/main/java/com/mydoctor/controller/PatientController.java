package com.mydoctor.controller;



import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import com.mydoctor.model.Appointment;

import com.mydoctor.model.Doctor;

import com.mydoctor.model.Patient;
import com.mydoctor.service.AppointmentServiceImpl;
import com.mydoctor.service.DoctorServiceImpl;
import com.mydoctor.service.PatientServiceImpl;
import com.mydoctor.util.EmailService;



@Controller
@SessionAttributes(value = {"username","appointment","suggestDateTimes","chosenDoctor"})
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
		public String profile(ModelMap model,@RequestParam(value="msg",required=false,defaultValue = "")String msg) throws SQLException 
		{
			Patient patient = patientServiceImpl.retrievePatient((String)model.get("username"));
				model.addAttribute("msg", msg);
				model.addAttribute("patient",patient); //for ssn,hospitalNumber
				model.addAttribute("new_patient",patient);
				return "patientProfile";
		}

		
		@RequestMapping(value="/edit-info",method=RequestMethod.POST)
		public String editProfile(ModelMap model,@Valid Patient new_patient, BindingResult result) throws SQLException 
		{
			//System.out.println("[Request]" + new_patient.toString());
			if(result.hasErrors()){
				return "patientProfile";
			}
			System.out.println(new_patient.getBirthdate());
			int updateCount = patientServiceImpl.edit_info((String)model.get("username"),new_patient);
		   if(updateCount > 0) {
			   model.clear();
			   return "redirect:/patient-profile?msg=save";
		   }
		   return "redirect:/patient-profile?msg=err";
			}
		
		

		@RequestMapping(value="/list-appointment",method=RequestMethod.GET)
		public String showAppointmentList(ModelMap model,@RequestParam(value="msg",required=false,defaultValue = "")String msg) throws SQLException 
		{
				appointmentServiceImpl.cleanAppointments();		
				model.addAttribute("appointments",patientServiceImpl.retrieveAllAppointments((String)model.get("username")));
				model.addAttribute("msg", msg);
				return "patientAppointment";
		}
		@RequestMapping(value="/choose-doctor",method=RequestMethod.GET)
		public String showDoctorListPage(ModelMap model) throws SQLException 
		{
				model.addAttribute("doctors",doctorServiceImpl.retrieveAllDoctors());
				return "chooseDoctor";
		}
		
		
		@RequestMapping(value="/list-doctor-time",method=RequestMethod.GET)
		public String showAvailableTime(@RequestParam("doctorId") String doctor_id,ModelMap model) throws SQLException 
		{
				Appointment appointment =  new Appointment();
				appointment.setDoctorId(Integer.parseInt(doctor_id));
				appointment.setPatientId(patientServiceImpl.retrieveId((String)model.get("username")));
				model.put("appointment", appointment);
				
				ArrayList<Timestamp> suggestDateTimes = appointmentServiceImpl.findDoctorAllAvailableTime(Integer.parseInt(doctor_id));
				ArrayList<Appointment> patientAppointment = patientServiceImpl.retrieveAllAppointments((String)model.get("username"));
				
				for(Appointment apt:patientAppointment){
					Timestamp start = apt.getDate();
					for(int i=0;i<suggestDateTimes.size();i++){
						
						if(start.equals(suggestDateTimes.get(i))){
							suggestDateTimes.remove(i);
							System.out.println("you have another appointment in this time: "+start);
						}
					}
					
				}
				model.addAttribute("suggestDateTimes",suggestDateTimes);
				model.put("chosenDoctor", doctorServiceImpl.retrieveDoctor(Integer.parseInt(doctor_id)));
				
				return "showAvailableTime";
				
		}
		@RequestMapping(value="/confirm-time",method=RequestMethod.GET)
		public String confirmDoctorAndTimePage(@ModelAttribute("appointment")Appointment appointment,
				@ModelAttribute("suggestDateTimes")ArrayList<Timestamp> availableTimes,
				@ModelAttribute("chosenDoctor")Doctor choosenDoctor,
				@RequestParam("index") String index,ModelMap model) throws SQLException 
		{
				if(appointment == null){
					return "redirect:/list-appointment";
				}
				appointment.setDate(availableTimes.get(Integer.parseInt(index)));
				return "addAppointment";
				
		}
		
		@RequestMapping(value="/confirm-time",method=RequestMethod.POST)
		public String saveAppointment(
				ModelMap model,@Valid Appointment validAppointment,BindingResult result) throws SQLException 
		{

			appointmentServiceImpl.saveAppointment(validAppointment);
			//send email
			Patient patient = patientServiceImpl.retrievePatient((String)model.get("username"));
			Doctor doctor = doctorServiceImpl.retrieveDoctor(validAppointment.getDoctorId());
			patient.setUsername1((String)model.get("username"));
			EmailService.emailNewAppointment(validAppointment,patient,doctor);
			
			//
			model.remove("suggestDateTimes");
			model.remove("chosenDoctor");
			model.remove("appointment");
			model.clear();
			return "redirect:/list-appointment?msg=done";
				
		}
		@RequestMapping(value="/cancel-appointment",method=RequestMethod.GET)
		public String cancelAppointment(ModelMap model,@RequestParam("appointmentId") String appointment_id,
				SessionStatus status) throws SQLException 
		{
			 
				System.out.println(appointment_id);
				int updateCount = patientServiceImpl.cancelAppointment((String)model.get("username"),Integer.parseInt(appointment_id));
				if(updateCount > 0){
					model.remove("suggestDateTimes");
					model.remove("chosenDoctor");
					model.remove("appointment");
					model.clear();
					return "redirect:/list-appointment";
				}
				else{
//					model.addAttribute("error", "Delete error please try again.");
					model.clear();
					return "redirect:/list-appointment";
				}
				
		}
		
	
		
}
