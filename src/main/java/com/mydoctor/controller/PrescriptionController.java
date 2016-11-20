package com.mydoctor.controller;



import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mydoctor.model.MedicineBean;
import com.mydoctor.model.Schedule;
import com.mydoctor.service.PrescriptionServiceImpl;



@Controller
@SessionAttributes("username")
public class PrescriptionController
{
		@Autowired
		private PrescriptionServiceImpl prescriptionServiceImpl;
		 
		
		@RequestMapping(value = "/add-prescription", method = RequestMethod.GET)
	    public String showPrescription(ModelMap model) {
			
			String doctor_name = "dummy doctor";
			String patient_name = "dummy patient";
			model.addAttribute("patientName",patient_name);
			model.addAttribute("doctorName",doctor_name);
	        model.addAttribute("medicineBeans", prescriptionServiceImpl.retrieveAllMedicineBeans());
	        return "addPrescription";
	    }

	    @RequestMapping(value = "/add-medicine", method = RequestMethod.GET)
	    public String showAddTodoPage(ModelMap model) {
	        model.addAttribute("medicineBean", new MedicineBean());
	        return "addMedicine";
	    }

	    @RequestMapping(value = "/add-medicine", method = RequestMethod.POST)
	    public String addTodo(ModelMap model, @Valid MedicineBean medicineBean, BindingResult result) {

	        if (result.hasErrors())
	            return "addMedicine";

	        prescriptionServiceImpl.addMedicineBean(medicineBean.getId(), medicineBean.getName(), medicineBean.getAmount(), medicineBean.getInstruction());
	        model.clear();// to prevent request parameter "name" to be passed
	        return "redirect:/add-prescription";
	    }
	    
	    @RequestMapping(value="/add-prescription",method=RequestMethod.POST)
		public String savePrescription(ModelMap model, BindingResult result) throws SQLException 
		{				
				if(result.hasErrors()){
					return "addPrescription";
				}
				int updateCount = prescriptionServiceImpl.savePrescription();
				if(updateCount > 0){
					model.clear();
					return "welcomeDoctor";
				} 
				
				return "addPrescription";
				
		}
		
		
}
