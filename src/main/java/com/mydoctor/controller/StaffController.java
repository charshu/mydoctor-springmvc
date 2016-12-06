package com.mydoctor.controller;

import java.sql.SQLException;
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
import com.mydoctor.model.GeneralInfo;
import com.mydoctor.model.Patient;
import com.mydoctor.model.Schedule;
import com.mydoctor.model.ViewInfo;
import com.mydoctor.service.DoctorServiceImpl;
import com.mydoctor.service.NurseServiceImpl;
import com.mydoctor.service.PatientServiceImpl;
import com.mydoctor.service.StaffServiceImpl;
import com.mydoctor.util.EmailService;

@Controller
@SessionAttributes(value = { "username", "viewInfo" })
public class StaffController {
	@Autowired
	private StaffServiceImpl staffServiceImpl;
	@Autowired
	private PatientServiceImpl patientServiceImpl;
	@Autowired
	private DoctorServiceImpl doctorServiceImpl;

	@RequestMapping(value = "/welcomeStaff", method = RequestMethod.GET)
	public String profile(ModelMap model) throws SQLException {
		// model.addAttribute("staff",staffServiceImpl.retrieveStaff((String)model.get("username")));
		return "welcomeStaff";
	}

	@RequestMapping(value = "/register-patient", method = RequestMethod.GET)
	public String registerPatient(ModelMap model,@RequestParam(value="error",required=false,defaultValue = "")String error) throws SQLException {
		Patient patient = new Patient();
		model.addAttribute("patient", patient);
		model.addAttribute("error",error);
		return "registerPatient_staff";
	}

	@RequestMapping(value = "/register-patient", method = RequestMethod.POST)
	public String addPatient(ModelMap model, @Valid Patient patient, BindingResult result) throws SQLException {
		//System.out.println("[Request]" + patient.toString());
		if (result.hasErrors()) {
			return "registerPatient_staff";
		}
		String hospitalNumber = staffServiceImpl.registerPatient((String) model.get("username"), patient);
		if(hospitalNumber.equals("-2")){
			return "redirect:/register-patient?error=-2";
		}
		if(hospitalNumber.equals("-3")){
			return "redirect:/register-patient?error=-3";
		}
		if(hospitalNumber.equals("-4")){
			return "redirect:/register-patient?error=-4";
		}
		
		
		if (hospitalNumber != "") {
			model.clear();
			patient.setHospitalNumber(hospitalNumber);
			EmailService.emailNewUserByStaff(patient);
			model.addAttribute("email", patient.getEmail());
			model.addAttribute("hospitalNumber", hospitalNumber);
			return "showHospitalNumber";
		}

		return "registerPatient_staff";

	}

	@RequestMapping(value = "/view-info3", method = RequestMethod.GET)
	public String getPatient(ModelMap model) throws SQLException {
		model.put("viewInfo", new ViewInfo());
		return "viewPatientInfo_staff";
	}

	@RequestMapping(value = "/view-info3", method = RequestMethod.POST)
	public String viewPatientInfo(ModelMap model, @Valid ViewInfo viewInfo, BindingResult result) throws SQLException {
		System.out.println("[Request]" + viewInfo.toString());
		if (result.hasErrors()) {
			return "viewPatientInfo_staff";
		}
		GeneralInfo generalInfo = staffServiceImpl.findPatientGenInfo(viewInfo);
		Patient patientInfo = staffServiceImpl.findPatientInfo(viewInfo);

		model.addAttribute("generalInfo", generalInfo);
		model.addAttribute("patientInfo", patientInfo);
		return "showPatientInfoAfterFind_staff";
	}

	@RequestMapping(value = "/edit-info3", method = RequestMethod.POST)
	public String editPatientinfo(ModelMap model, @ModelAttribute("patientInfo") Patient patientInfo,
			@ModelAttribute("viewInfo") ViewInfo viewInfo, BindingResult result) throws SQLException {
		System.out.println("[Request]" + patientInfo.toString());
		if (result.hasErrors()) {
			return "showPatientInfoAfterFind_staff";
		}
		System.out.print(viewInfo.getHospitalNumber());
		int updateCount = patientServiceImpl.edit_info2(viewInfo.getHospitalNumber(), patientInfo);
		if (updateCount > 0) {
			model.addAttribute("patientInfo", patientInfo);
			model.remove(viewInfo);
			return "showPatientInfoAfterEdit_staff";
		}
		return "showPatientInfoAfterFind_staff";
	}

	@RequestMapping(value = "/approve-schedule", method = RequestMethod.GET)
	public String showRequestCancelSchedule(ModelMap model) throws SQLException {

		ArrayList<Schedule> requestCancelSchedules = doctorServiceImpl.retriveAllSchedulesStatus("request cancel");
		model.addAttribute("requestCancelSchedules", requestCancelSchedules);
		return "showRequestCancelSchedule";
	}

	@RequestMapping(value = "/approve-cancel-schedule", method = RequestMethod.GET)
	public String cancelSchedule(@RequestParam("scheduleId") String schedule_id, ModelMap model) throws SQLException {
		Schedule schedule = doctorServiceImpl.retrieveSchedule(Integer.parseInt(schedule_id));
		doctorServiceImpl.setStatusSchedule(schedule, "cancel");
		patientServiceImpl.postponeAppointmentInSchedule(schedule);
		return "redirect:/approve-schedule";
	}

}
