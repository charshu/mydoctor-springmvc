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
import com.mydoctor.model.NewUserBean;
import com.mydoctor.model.Nurse;
import com.mydoctor.model.Patient;
import com.mydoctor.model.Schedule;
import com.mydoctor.model.ViewInfo;
import com.mydoctor.service.AppointmentServiceImpl;
import com.mydoctor.service.DoctorServiceImpl;
import com.mydoctor.service.LoginServiceImpl;
import com.mydoctor.service.PatientServiceImpl;
import com.mydoctor.service.StaffServiceImpl;
import com.mydoctor.util.EmailService;

@Controller
@SessionAttributes(value = { "username", "viewInfo","hn","appointment","suggestDateTimes","chosenDoctor","requestCancelSchedules" })
public class StaffController {
	@Autowired
	private StaffServiceImpl staffServiceImpl;
	@Autowired
	private PatientServiceImpl patientServiceImpl;
	@Autowired
	private DoctorServiceImpl doctorServiceImpl;
	@Autowired
	private LoginServiceImpl loginServiceImpl;
	@Autowired
	private AppointmentServiceImpl appointmentServiceImpl;
	
	private static ArrayList<Schedule> requestCancelSchedules = new ArrayList<Schedule>();

	@RequestMapping(value = "/welcomeStaff", method = RequestMethod.GET)
	public String profile(ModelMap model) throws SQLException {
		// model.addAttribute("staff",staffServiceImpl.retrieveStaff((String)model.get("username")));
		requestCancelSchedules = doctorServiceImpl.retriveAllSchedulesStatus("request cancel");
		model.put("requestCancelSchedules", requestCancelSchedules);
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
		GeneralInfo generalInfo = staffServiceImpl.findPatientGenInfo(viewInfo.getHospitalNumber());
		Patient patientInfo = staffServiceImpl.findPatientInfo(viewInfo.getHospitalNumber());

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
	public String showRequestCancelSchedule(ModelMap model,@RequestParam(value="msg",required=false,defaultValue = "")String msg) throws SQLException {

		ArrayList<Schedule> requestCancelSchedules = doctorServiceImpl.retriveAllSchedulesStatus("request cancel");
		model.addAttribute("requestCancelSchedules", requestCancelSchedules);
		model.addAttribute("msg", msg);
		return "showRequestCancelSchedule";
	}

	@RequestMapping(value = "/approve-cancel-schedule", method = RequestMethod.GET)
	public String cancelSchedule(@RequestParam("scheduleId") String schedule_id, ModelMap model) throws SQLException {
		Schedule schedule = doctorServiceImpl.retrieveSchedule(Integer.parseInt(schedule_id));
		doctorServiceImpl.setStatusSchedule(schedule, "cancel");
		patientServiceImpl.postponeAppointmentInSchedule(schedule);
		return "redirect:/approve-schedule?msg=1";
	}
	
	@RequestMapping(value = "/add-user", method = RequestMethod.GET)
	public String showAddUser(ModelMap model,@RequestParam(value="msg",required=false,defaultValue = "")String msg) throws SQLException {
		model.addAttribute("msg", msg);
		return "addHospitalUser";
	}
	@RequestMapping(value = "/add-nurse", method = RequestMethod.GET)
	public String showAddNurse(ModelMap model) throws SQLException {
		Nurse nurse = new Nurse();
		model.addAttribute("nurse", nurse);
		return "addNurse";
	}
	@RequestMapping(value = "/add-nurse", method = RequestMethod.POST)
	public String addNurse(ModelMap model,@Valid Nurse nurse) throws SQLException {
		int code = loginServiceImpl.addNurse(nurse);
		if(code < 0){
			return "redirect:/add-user?msg=err";
		}
		return "redirect:/add-user?msg=nursedone";
	}
	@RequestMapping(value = "/add-doctor", method = RequestMethod.GET)
	public String showAddDoctor(ModelMap model) throws SQLException {
		Doctor doctor = new Doctor();
		model.addAttribute("doctor", doctor);
		return "addDoctor";
	}
	@RequestMapping(value = "/add-doctor", method = RequestMethod.POST)
	public String addDoctor(ModelMap model,@Valid Doctor doctor) throws SQLException {
		int code = loginServiceImpl.addDoctor(doctor);
		if(code < 0){
			return "redirect:/add-user?msg=err";
		}
		return "redirect:/add-user?msg=doctordone";
		
	}
	@RequestMapping(value = "/add-staff", method = RequestMethod.GET)
	public String showAddStaff(ModelMap model) throws SQLException {
		NewUserBean newUserBean = new NewUserBean();
		model.addAttribute("newUserBean", newUserBean);
		return "addStaff";
	}
	@RequestMapping(value = "/add-staff", method = RequestMethod.POST)
	public String addStaff(ModelMap model,@Valid NewUserBean newUserBean) throws SQLException {
		int code = loginServiceImpl.registerUserId(newUserBean.getUsername(),newUserBean.getPassword(),"staff");
		if(code < 0){
			return "redirect:/add-user?msg=err";
		}
		return "redirect:/add-user?msg=staffdone";
		
	}
	@RequestMapping(value = "/add-pharmacist", method = RequestMethod.GET)
	public String showAddPharmacist(ModelMap model) throws SQLException {
		NewUserBean newUserBean = new NewUserBean();
		model.addAttribute("newUserBean", newUserBean);
		return "addPharmacist";
	}
	@RequestMapping(value = "/add-pharmacist", method = RequestMethod.POST)
	public String addPharmacist(ModelMap model,@Valid NewUserBean newUserBean) throws SQLException {
		int code = loginServiceImpl.registerUserId(newUserBean.getUsername(),newUserBean.getPassword(),"pharmacist");
		if(code < 0){
			return "redirect:/add-user?msg=err";
		}
		return "redirect:/add-user?msg=pharmacistdone";
		
	}
	@RequestMapping(value="/make-appointment",method=RequestMethod.GET)
	public String showDoctorListPage(ModelMap model,@RequestParam(value="hn",required=false,defaultValue = "")String hn) throws SQLException 
	{
			model.clear();
			model.put("hn",hn);
			return "redirect:/staff-choose-doctor";
	}
	
	@RequestMapping(value="/staff-choose-doctor",method=RequestMethod.GET)
	public String showDoctorListPage(ModelMap model) throws SQLException 
	{
			model.addAttribute("doctors",doctorServiceImpl.retrieveAllDoctors());
			return "chooseDoctorStaff";
	}
	
	
	@RequestMapping(value="/staff-list-doctor-time",method=RequestMethod.GET)
	public String showAvailableTime(@RequestParam("doctorId") String doctor_id,ModelMap model) throws SQLException 
	{
			System.out.println("hn: "+(String)model.get("hn"));
			int patient_id = patientServiceImpl.retrieveIdByHn((String)model.get("hn"));
			Appointment appointment =  new Appointment();
			appointment.setDoctorId(Integer.parseInt(doctor_id));
			appointment.setPatientId(patient_id);
			model.put("appointment", appointment);
			System.out.println("pid:"+patient_id+" did: "+doctor_id);
			ArrayList<Timestamp> suggestDateTimes = appointmentServiceImpl.findDoctorAllAvailableTime(Integer.parseInt(doctor_id));
			ArrayList<Appointment> patientAppointment = patientServiceImpl.retrieveAllAppointmentsByPatientId(patient_id);
			System.out.println("sdt: "+suggestDateTimes);
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
			
			return "showAvailableTimeStaff";
			
	}
	@RequestMapping(value="/staff-confirm-time",method=RequestMethod.GET)
	public String confirmDoctorAndTimePage(@ModelAttribute("appointment")Appointment appointment,
			@ModelAttribute("suggestDateTimes")ArrayList<Timestamp> availableTimes,
			@ModelAttribute("chosenDoctor")Doctor choosenDoctor,
			@RequestParam("index") String index,ModelMap model) throws SQLException 
	{
			if(appointment == null){
				model.clear();
				return "redirect:/view-info-direct?msg=error&hn="+(String)model.get("hn");
			}
			appointment.setDate(availableTimes.get(Integer.parseInt(index)));
			return "addAppointmentStaff";
			
	}
	
	@RequestMapping(value="/staff-confirm-time",method=RequestMethod.POST)
	public String saveAppointment(
			ModelMap model,@Valid Appointment validAppointment,BindingResult result) throws SQLException 
	{
		String hn = (String)model.get("hn");
		int code = appointmentServiceImpl.saveAppointment(validAppointment);
		if(code<0){
			model.clear();
			return "redirect:/view-info-direct?msg=error&hn="+hn;
		}
		//send email
		Patient patient = patientServiceImpl.retrievePatientByHN((String)model.get("hn"));
		Doctor doctor = doctorServiceImpl.retrieveDoctor(validAppointment.getDoctorId());		
		EmailService.emailNewAppointmentByStaff(validAppointment,patient,doctor);
		//
		model.remove("suggestDateTimes");
		model.remove("chosenDoctor");
		model.remove("appointment");
		model.clear();
		return "redirect:/view-info-direct?msg=done&hn="+hn;
			
	}
	@RequestMapping(value = "/view-info-direct", method = RequestMethod.GET)
	public String viewPatientInfoDirect(ModelMap model,@RequestParam(value="hn",required=false,defaultValue = "")String hn
			,@RequestParam(value="msg",required=false,defaultValue = "")String msg) throws SQLException {
		
		if (hn.isEmpty()) {
			return "redirect:/view-info3";
		}
		GeneralInfo generalInfo = staffServiceImpl.findPatientGenInfo(hn);
		Patient patientInfo = staffServiceImpl.findPatientInfo(hn);

		model.addAttribute("generalInfo", generalInfo);
		model.addAttribute("patientInfo", patientInfo);
		model.addAttribute("msg", msg);
		model.addAttribute("hn", hn);
		return "showPatientInfoAfterFind_staff";
	}

}
