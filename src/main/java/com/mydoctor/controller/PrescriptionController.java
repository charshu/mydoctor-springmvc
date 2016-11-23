package com.mydoctor.controller;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mydoctor.model.MedicineBean;
import com.mydoctor.model.Schedule;
import com.mydoctor.service.DoctorServiceImpl;
import com.mydoctor.service.MedicineServiceImpl;
import com.mydoctor.service.PatientServiceImpl;
import com.mydoctor.service.PrescriptionServiceImpl;



@Controller
@SessionAttributes(value={"username","medName"})
public class PrescriptionController
{
		@Autowired
		private PrescriptionServiceImpl prescriptionServiceImpl;
		@Autowired
		private DoctorServiceImpl doctorServiceImpl;
		@Autowired
		private PatientServiceImpl patientServiceImpl;
		@Autowired
		private MedicineServiceImpl medicineServiceImpl;
		
		
		
		@RequestMapping(value = "/add-prescription", method = RequestMethod.GET)
	    public String showPrescription(ModelMap model) throws SQLException {
			//PrescriptionServiceImpl.setDoctor_id(1);
			//PrescriptionServiceImpl.setPatient_id(1);
			int doctor_id = prescriptionServiceImpl.getDoctor_id();
			int patient_id = prescriptionServiceImpl.getPatient_id();
			String doctor_name = doctorServiceImpl.retrieveDoctorNameByID(doctor_id);
			String patient_name = patientServiceImpl.retrievePatientNameByID(patient_id);
			model.addAttribute("patientName",patient_name);
			model.addAttribute("doctorName",doctor_name);
	        model.addAttribute("medicineBeans", prescriptionServiceImpl.retrieveAllMedicineBeans());
	        return "addPrescription";
	    }

	    @RequestMapping(value = "/add-medicine", method = RequestMethod.GET)
	    public String showAddMedicinePage(ModelMap model) throws SQLException {
	    	ArrayList<MedicineBean> medicineBeanOption = medicineServiceImpl.retrieveAllMedicine();
	    	
//	    	ArrayList<String> medName = new ArrayList<String>();
//	    	for(int i=0; i<medicineBean.size(); i++){
//	    		medName.add(medicineBean.get(i).getName());
//	    		System.out.println(medicineBean.get(i).getName());
//	    		System.out.println(medName.get(i));
//	    	}

	    	MedicineBean medicineBean = new MedicineBean();
	    	model.addAttribute("medicineBean", medicineBean);
	        model.addAttribute("medicineBeanOption", medicineBeanOption);
	        //model.addAttribute("medName", medName);
	        return "addMedicine";
	    }

	    @RequestMapping(value = "/add-medicine", method = RequestMethod.POST)
	    public String addMedicine(ModelMap model, @ModelAttribute("medicineBean")MedicineBean medicineBean, BindingResult result) throws SQLException {

	        if (result.hasErrors())
	            return "addMedicine";

	        prescriptionServiceImpl.addMedicineBean(medicineBean);
	        model.clear();// to prevent request parameter "name" to be passed
	        return "redirect:/add-prescription";
	    }
	    
	    @RequestMapping(value="/save-prescription",method=RequestMethod.GET)
		public String savePrescription(ModelMap model) throws SQLException 
		{	
	    	int doctor_id = prescriptionServiceImpl.getDoctor_id();
	    	int patient_id = prescriptionServiceImpl.getPatient_id();
	    	List<MedicineBean> medicineBean = prescriptionServiceImpl.retrieveAllMedicineBeans();
	    	int updateCount = -1;
	    	for(MedicineBean medicine : medicineBean ) {
	    		int medicine_id = medicine.getId();
	    	    String medicine_name = medicine.getName();
	    	    String medicine_amount = medicine.getAmount();
	    	    String medicine_instruction = medicine.getInstruction();
	    	    updateCount = prescriptionServiceImpl.savePrescription(doctor_id, patient_id, medicine_id, medicine_amount, medicine_instruction);
	    	}
			//int updateCount = prescriptionServiceImpl.savePrescription(doctor_id, patient_id);
			//System.out.println("pass4");
			if(updateCount > 0){
				System.out.println("pass");
				model.clear();
				return "welcomeDoctor";
			} 
				//save method
				return "welcomeDoctor";	
		}
	    
	    
	    @RequestMapping(value = "/see-medicine-list", method = RequestMethod.GET)
	    public String SeeMedicineList(ModelMap model) throws SQLException {

	        model.addAttribute("medicineBean", medicineServiceImpl.retrieveAllMedicine());
	        
	        return "seeMedicineList";
	    }
		
}
