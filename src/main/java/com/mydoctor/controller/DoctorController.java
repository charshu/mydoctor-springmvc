package com.mydoctor.controller;



import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.DateTimeFormatterFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mydoctor.dao.DoctorDaoImpl;
import com.mydoctor.model.Appointment;
import com.mydoctor.model.DiagnosisBean;
import com.mydoctor.model.GeneralInfo;
import com.mydoctor.model.Patient;
import com.mydoctor.model.Prescription;

import com.mydoctor.model.Schedule;
import com.mydoctor.model.ViewInfo;
import com.mydoctor.service.AppointmentServiceImpl;
import com.mydoctor.service.DoctorServiceImpl;
import com.mydoctor.service.NurseServiceImpl;
import com.mydoctor.service.PatientServiceImpl;

import com.mydoctor.service.PrescriptionServiceImpl;


@Controller
@SessionAttributes(value={"username","diagnosis"})
public class DoctorController
{
		@Autowired
		private DoctorServiceImpl doctorServiceImpl;
		@Autowired
		private NurseServiceImpl nurseServiceImpl;
		@Autowired
		private PrescriptionServiceImpl prescriptionServiceImpl;
		@Autowired
		private PatientServiceImpl patientServiceImpl;


		
		@InitBinder
		public void binder(WebDataBinder binder) {
			binder.registerCustomEditor(Timestamp.class,
		    new PropertyEditorSupport() {
		        public void setAsText(String value) {
		            try {
		            	//System.out.println("value: "+value);
		            	DateTimeFormatter dtf = DateTimeFormat.forPattern("E dd-MM-YYYY HH:mm");
		                DateTime parsedDate = dtf.parseDateTime(value);
		            //    Calendar c = Calendar.getInstance(); 
		             //   c.setTime(parsedDate); 
		             //   c.add(Calendar.DATE, 7);
		             //   c.add(Calendar.MONTH, 1);
		            //    c.add(Calendar.YEAR, 1);
		             //   parsedDate = c.getTime();
		             //  System.out.println("parsed Timestamp :"+ parsedDate);
		                setValue(new Timestamp(parsedDate.getMillis()));
		            } catch (Exception e) {
		                setValue(null);
		            }
		        }
		    });
		}

		
		@RequestMapping(value="/welcomeDoctor",method=RequestMethod.GET)
		public String welcomeNurse(ModelMap model) throws SQLException 
		{
				
				return "welcomeDoctor";
		}
		

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
				ArrayList<Schedule> requestCancelSchedules = doctorServiceImpl.retriveAllSchedulesStatus((String)model.get("username"),"request cancel");
				model.addAttribute("requestCancelSchedules", requestCancelSchedules);
				// schedules -> key , doctor -> object
				return "showSchedules";
		}
		@RequestMapping(value="/add-schedule",method=RequestMethod.GET)
		public String showAddSchedulePage(ModelMap model) throws SQLException 
		{
				System.out.println((String)model.get("username"));
				model.addAttribute("schedule",new Schedule());
				
				return "addSchedule";
		}
		
		
		@RequestMapping(value="/add-schedule",method=RequestMethod.POST)
		public String addSchedule(ModelMap model,@Valid Schedule schedule, BindingResult result) throws SQLException 
		{
				System.out.println("[Request]" + schedule.toString());
				
				if(result.hasErrors()){
					return "addSchedule";
				}
				int updateCount = doctorServiceImpl.saveSchedule((String)model.get("username"), schedule);
				if(updateCount > 0){
					model.clear();
					return "redirect:/list-schedule";
				} 
				model.addAttribute("error", "Fail to save a schedule, Please check overlapping time.");
				return "addSchedule";
				
		}
		@RequestMapping(value="/cancel-schedule",method=RequestMethod.GET)
		public String cancelSchedule(ModelMap model,@RequestParam String schedule_id) throws SQLException 
		{
				//System.out.println("[Request Delete]" + schedule_id);
				Schedule schedule = doctorServiceImpl.retrieveSchedule(Integer.parseInt(schedule_id));
				doctorServiceImpl.setStatusSchedule(schedule,"request cancel");
				//patientServiceImpl.postponeAppointmentInSchedule(schedule);
	
				return "redirect:/list-schedule";
				
		}
		@RequestMapping(value="/available-schedule",method=RequestMethod.GET)
		public String availableSchedule(ModelMap model,@RequestParam String schedule_id) throws SQLException 
		{
				//System.out.println("[Request Delete]" + schedule_id);
				Schedule schedule = doctorServiceImpl.retrieveSchedule(Integer.parseInt(schedule_id));
				doctorServiceImpl.setStatusSchedule(schedule,"available");
				//patientServiceImpl.postponeAppointmentInSchedule(schedule);
	
				return "redirect:/list-schedule";
				
		}
		
		
		@RequestMapping(value="/view-info",method=RequestMethod.GET)
		public String getPatient(ModelMap model) throws SQLException 
		{
			model.addAttribute("viewInfo",new ViewInfo());
			return "viewPatientInfo_doctor";
		}
		
		@RequestMapping(value="/view-info",method=RequestMethod.POST)
		public String viewPatientInfo(ModelMap model,@Valid ViewInfo viewInfo, BindingResult result) throws SQLException 
		{
			//System.out.println("[Request]" + viewInfo.toString());
			if(result.hasErrors()){
				return "viewPatientInfo_doctor";
			}
		    GeneralInfo generalInfo = doctorServiceImpl.findPatientGenInfo(viewInfo);
		    Patient patientInfo = doctorServiceImpl.findPatientInfo(viewInfo);

		    model.addAttribute("generalInfo",generalInfo);
		    model.addAttribute("patientInfo",patientInfo);

			return "showPatientInfoAfterFind_doctor";	
		}
		


		@RequestMapping(value="/patient-in-schedule",method=RequestMethod.GET)
		public String showPatientInSlot(ModelMap model) throws SQLException 
		{
			Schedule currentSchedule = doctorServiceImpl.retrieveCurrentSchedule((String)model.get("username"));
			model.addAttribute("currentSchedule",currentSchedule);
			ArrayList<Appointment> appointments = doctorServiceImpl.retrieveAllAppointmentInSchedule((String)model.get("username"));
			model.addAttribute("appointments",appointments);
			ArrayList<Appointment> appointmentInComings = doctorServiceImpl.retrieveAllInComingAppointmentSchedule((String)model.get("username"));
			model.addAttribute("appointmentInComings", appointmentInComings);
			return "patientsInSchedule";
		}

		
		@RequestMapping(value="/diagnose",method=RequestMethod.GET)
		public String showDiagnosePage(@RequestParam("patientId")String patient_id
				,@ModelAttribute("appointments")ArrayList<Appointment> appointments
				,ModelMap model) throws SQLException 
		{
			DiagnosisBean diagnosis = new DiagnosisBean();
			diagnosis.setPatientId(Integer.parseInt(patient_id));
			diagnosis.setDoctorId(doctorServiceImpl.retrieveId((String)model.get("username")));
			String patient_hospitalNumber = patientServiceImpl.retrieveHospitalNumberById(Integer.parseInt(patient_id));
			GeneralInfo generalInfo = nurseServiceImpl.findPatientGenInfoByHospitalNumber(patient_hospitalNumber);
			model.addAttribute("diagnosis",diagnosis);
			
			model.addAttribute("generalInfo", generalInfo);
			return "addDiagnosis";
		}
		
		@RequestMapping(value="/diagnose",method=RequestMethod.POST)
		public String saveDiagnosis(ModelMap model,@ModelAttribute("diagnosis")DiagnosisBean diagnosisBean) throws SQLException 
		{
			if(diagnosisBean.getPatientId() == 0 || diagnosisBean.getDoctorId() == 0){
				System.out.println("back");
				return "redirect:/patient-in-schedule";
			}
			if(doctorServiceImpl.saveDiagnosis(diagnosisBean) > 0){
				System.out.print("go add prescription");
				return "redirect:/add-prescription";
			}
			System.out.print("error");
			return "redirect:/patient-in-schedule";
			
		}
		

		@RequestMapping(value="/create_prescription",method=RequestMethod.GET)
		public String showCreatePrescriptionPage(ModelMap model)
		{
			
			Prescription prescription = new Prescription();
			model.addAttribute("prescription", prescription);
			return "createPrescription";
		}
		
		
		@RequestMapping(value="/create_prescription",method=RequestMethod.POST)
		public String addPrescription(ModelMap model, @Valid Prescription prescription, BindingResult result) throws SQLException
		{
				
				if(result.hasErrors()){
					return "prescription";
				}
				// prescriptionId, medicineId, instruction, amount
				int medicineId = prescription.getMedicineId();
				//String medicine = prescription.
				String instruction = prescription.getInstruction();
				int amount = prescription.getAmount();

				
				return "prescription";
		}
		@RequestMapping(value="/DoctorFindPrescriptionHistoryForm", method=RequestMethod.GET)
		public String doctorFindPrescriptionHistoryForm(ModelMap model)
		{
			Prescription findprescriptionh = new Prescription();
			model.addAttribute("Prescription", findprescriptionh);
			return "DoctorFindPrescriptionHistory";
		}


		@RequestMapping(value="/DoctorFindPrescriptionHistoryForm",method=RequestMethod.POST)
		public String doctorShowPrescriptionHistoryForm(ModelMap model, @Valid Prescription findprescriptionh, BindingResult result) throws SQLException
		{
			System.out.println("[Request]" + findprescriptionh.toString());
			if(result.hasErrors()){
				return "DoctorFindPrescriptionHistory";
			}
			ArrayList<Prescription> prescriptionHistorys = prescriptionServiceImpl.findPrescriptionHistory(findprescriptionh);
			model.addAttribute("prescriptionHistorys", prescriptionHistorys);
			return "DoctorViewPrescriptionHistory";
		}


}
