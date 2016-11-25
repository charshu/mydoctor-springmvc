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

import com.mydoctor.model.Appointment;
import com.mydoctor.model.Doctor;
import com.mydoctor.model.GeneralInfo;
import com.mydoctor.model.Patient;
import com.mydoctor.model.ViewInfo;
import com.mydoctor.service.AppointmentServiceImpl;
import com.mydoctor.service.DoctorServiceImpl;
import com.mydoctor.service.NurseServiceImpl;
import com.mydoctor.service.PatientServiceImpl;
import com.mydoctor.service.StaffServiceImpl;


@Controller
@SessionAttributes(value={"username","viewInfo"})
public class StaffController
{
	@Autowired
	private StaffServiceImpl staffServiceImpl;
	@Autowired
	private PatientServiceImpl patientServiceImpl;
	@Autowired
	private DoctorServiceImpl doctorServiceImpl;
	@Autowired
	private AppointmentServiceImpl appointmentServiceImpl;
		
	@RequestMapping(value="/welcomeStaff",method=RequestMethod.GET)
	public String profile(ModelMap model) throws SQLException 
	{
			//model.addAttribute("staff",staffServiceImpl.retrieveStaff((String)model.get("username")));
			return "welcomeStaff";
	}
	
	@RequestMapping(value="/register-patient",method=RequestMethod.GET)
	public String registerPatient(ModelMap model) throws SQLException 
	{
			Patient patient = new Patient();
			model.addAttribute("patient",patient);
			return "registerPatient_staff";
	}
	

	@RequestMapping(value="/register-patient",method=RequestMethod.POST)
	public String addPatient(ModelMap model, @Valid Patient patient, BindingResult result) throws SQLException 
	{
		System.out.println("[Request]" + patient.toString());
		if(result.hasErrors()){
			return "registerPatient_staff";
		}
		String hospitalNumber = staffServiceImpl.registerPatient((String)model.get("username"),patient);
		if(hospitalNumber != ""){
			model.clear();
			//model.addAttribute("patient",patient);
			model.addAttribute("hospitalNumber", hospitalNumber);
			return "showHospitalNumber";
		} 
		
		
		return "registerPatient_staff";

		
	}
	
	@RequestMapping(value="/view-info3",method=RequestMethod.GET)
	public String getPatient(ModelMap model) throws SQLException 
	{
		model.put("viewInfo",new ViewInfo());
		return "viewPatientInfo_staff";
	}
	
	@RequestMapping(value="/view-info3",method=RequestMethod.POST)
	public String viewPatientInfo(ModelMap model,@Valid ViewInfo viewInfo, BindingResult result) throws SQLException 
	{
		System.out.println("[Request]" + viewInfo.toString());
		if(result.hasErrors()){
			return "viewPatientInfo_staff";
		}
	    GeneralInfo generalInfo = staffServiceImpl.findPatientGenInfo(viewInfo);
	    Patient patientInfo = staffServiceImpl.findPatientInfo(viewInfo);

	    model.addAttribute("generalInfo",generalInfo);
	    model.addAttribute("patientInfo",patientInfo);
		return "showPatientInfoAfterFind_staff";	
	}
	
	@RequestMapping(value="/edit-info3",method=RequestMethod.POST)
	public String editPatientinfo(ModelMap model,@ModelAttribute("patientInfo")Patient patientInfo,
			@ModelAttribute("viewInfo")ViewInfo viewInfo, BindingResult result) 
			throws SQLException
	{
		System.out.println("[Request]" + patientInfo.toString());
		if(result.hasErrors()){
			return "showPatientInfoAfterFind_staff";
		}
		System.out.print(viewInfo.getHospitalNumber());
		int updateCount = patientServiceImpl.edit_info2(viewInfo.getHospitalNumber(),patientInfo);
	    if(updateCount > 0) {
		   model.addAttribute("patientInfo",patientInfo);
		   model.remove(viewInfo);
		   return "showPatientInfoAfterEdit_staff";
	   }
	   return "showPatientInfoAfterFind_staff";
		}
	
	@RequestMapping(value="/staffMakeAppointment",method=RequestMethod.GET)
	public String getPatientMakeAppointment(ModelMap model) throws SQLException 
	{
		model.put("viewInfo",new ViewInfo());
		return "viewMakeAppointment_staff";
	}
	
	@RequestMapping(value="/staffMakeAppointment",method=RequestMethod.POST)
	public String staffMakeAppointmentPatient(ModelMap model,@Valid ViewInfo viewInfo, BindingResult result) throws SQLException 
	{
		System.out.println("[Request]" + viewInfo.toString());
		if(result.hasErrors()){
			return "viewMakeAppointment_staff";
		}
	    GeneralInfo generalInfo = staffServiceImpl.findPatientGenInfo(viewInfo);
	    Patient patientInfo = staffServiceImpl.findPatientInfo(viewInfo);

	    model.addAttribute("generalInfo",generalInfo);
	    model.addAttribute("patientInfo",patientInfo);
		return "staffPatientAppointment";	
	}@RequestMapping(value="/staff-list-appointment",method=RequestMethod.GET)
	public String showAppointmentList(ModelMap model,@ModelAttribute("viewInfo")ViewInfo viewInfo) throws SQLException 
	{
			
			System.out.println((String)model.get("username"));
			model.addAttribute("appointments",patientServiceImpl.retrieveAllAppointments(viewInfo.getHospitalNumber()));
			return "staffPatientAppointment";
	}
	@RequestMapping(value="/staff-choose-doctor",method=RequestMethod.GET)
	public String showDoctorListPage(ModelMap model,@ModelAttribute("viewInfo")ViewInfo viewInfo) throws SQLException 
	{
			System.out.println(viewInfo.getHospitalNumber());
			System.out.println("[REQUEST] retrieve all doctors");
			model.addAttribute("doctors",doctorServiceImpl.retrieveAllDoctors());
			return "chooseDoctor";
	}
}
