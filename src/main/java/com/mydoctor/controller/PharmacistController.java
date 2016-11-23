package com.mydoctor.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.mydoctor.dao.MedicineDaoImpl;
import com.mydoctor.dao.PharmacistDaoImpl;
import com.mydoctor.model.LoginBean;
import com.mydoctor.model.Prescription;
import com.mydoctor.service.MedicineServiceImpl;
import com.mydoctor.service.NurseServiceImpl;

import com.mydoctor.service.PharmacistServiceImpl;
import com.mydoctor.service.PrescriptionServiceImpl;



@Controller
@SessionAttributes("username")
public class PharmacistController
{
		@Autowired
		private PharmacistServiceImpl pharmacistServiceImpl;
		@Autowired
		private PrescriptionServiceImpl prescriptionServiceImpl;
		@Autowired
		private MedicineServiceImpl medicineServiceImpl;

	
		
		@RequestMapping(value="/show-prescription",method=RequestMethod.GET)
		public String showPrescription(ModelMap model) throws SQLException
		{
			model.addAttribute("prescripts", prescriptionServiceImpl.retrieveAllPrescription() );
			return "showPrescription";
		}

		@RequestMapping(value="/detail",method=RequestMethod.GET)
		public String showPrescriptionDetail(ModelMap model ,@RequestParam int prescription_id ) throws SQLException
		{	
			
			model.addAttribute("medicines", medicineServiceImpl.retrieveAllMedicine(prescription_id) );
			model.addAttribute("prescription_id", prescription_id);
			return "showPrescriptionDetail";
		}

		@RequestMapping(value="/complete-prescription",method=RequestMethod.GET)
		public String changeStatusPrescription(ModelMap model, @RequestParam int prescription_id) throws SQLException
		{
			prescriptionServiceImpl.changeStatusToCompete(prescription_id);
			model.addAttribute("prescripts", prescriptionServiceImpl.retrieveAllPrescription() );
			model.addAttribute("prescription_id", prescription_id);
			return "showPrescription";
		}
	

		@RequestMapping(value="/findPrescriptionHistoryForm",method=RequestMethod.POST)
		public String ShowPrescriptionHistoryForm(ModelMap model, @Valid Prescription findprescriptionh, BindingResult result) throws SQLException
		{
			System.out.println("[Request]" + findprescriptionh.toString());
			if(result.hasErrors()){
				return "findPrescriptionHistory";
			}
			ArrayList<Prescription> prescriptionHistorys = prescriptionServiceImpl.findPrescriptionHistory((String)model.get("username"),findprescriptionh);
			model.addAttribute("prescriptionHistorys", prescriptionHistorys);
			return "viewPrescriptionHistory";
		}



		@RequestMapping(value="/findPrescriptionHistoryForm", method=RequestMethod.GET)
		public String findPrescriptionHistoryForm(ModelMap model)
		{
			Prescription findprescriptionh = new Prescription();
			model.addAttribute("Prescription", findprescriptionh);
			return "findPrescriptionHistory";
		}




		@RequestMapping(value="/pharmacist-profile",method=RequestMethod.GET)
		public String profile(ModelMap model) throws SQLException 
		{
				model.addAttribute("pharmacist",pharmacistServiceImpl.retrievePharmacist((String)model.get("username")));
				return "pharmacistProfile";
		}
		
		@RequestMapping(value="/welocomePharmacist",method=RequestMethod.GET)
		public String welcomePharmacist(ModelMap model) throws SQLException 
		{				
				return "welcomePharmacist";
		}

		
		

}

