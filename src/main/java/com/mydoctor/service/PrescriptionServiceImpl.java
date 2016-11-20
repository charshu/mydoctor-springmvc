package com.mydoctor.service;

import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Service;

import com.mydoctor.dao.PrescriptionDaoImpl;
import com.mydoctor.model.MedicineBean;
import com.mydoctor.model.Schedule;

@Service
public class PrescriptionServiceImpl {

	private PrescriptionDaoImpl prescriptionDaoImpl;
	private static List<MedicineBean> medicineBeans = new ArrayList<MedicineBean>();
	
	private DoctorServiceImpl doctorServiceImpl;
	private PatientServiceImpl patientServiceImpl;

	private static int patient_id, doctor_id;

//	static {
//		medicineBeans.add(new MedicineBean(1, "Paracetamon", "2", "dont use"));
//		medicineBeans.add(new MedicineBean(2, "Paracetamon", "2", "dont use"));
//		medicineBeans.add(new MedicineBean(3, "Paracetamon", "2", "dont use"));
//	}

	public static int getPatient_id() {
		return patient_id;
	}

	public static void setPatient_id(int patient_id) {
		PrescriptionServiceImpl.patient_id = patient_id;
	}

	public static int getDoctor_id() {
		return doctor_id;
	}

	public static void setDoctor_id(int doctor_id) {
		PrescriptionServiceImpl.doctor_id = doctor_id;
	}

	public PrescriptionDaoImpl getPrescriptionDaoImpl() {
		return prescriptionDaoImpl;
	}

	public void setPrescriptionDaoImpl(PrescriptionDaoImpl prescriptionDaoImpl) {
		this.prescriptionDaoImpl = prescriptionDaoImpl;
	}

	public List<MedicineBean> retrieveAllMedicineBeans() {
		return medicineBeans;
	}

	public void addMedicineBean(int id, String name, String amount, String instruction) {
		medicineBeans.add(new MedicineBean(id, name, amount, instruction));
	}

	public void deleteMedicineBean(int id) {
		Iterator<MedicineBean> iterator = medicineBeans.iterator();
		while (iterator.hasNext()) {
			MedicineBean medicineBean = iterator.next();
			if (medicineBean.getId() == id) {
				iterator.remove();
			}
		}
	}
	
	public int savePrescription()throws SQLException{
		
		int prescription_id = prescriptionDaoImpl.insertPrescription();
		if(prescription_id == -1){
			System.out.println("[ERROR] cannot retrieve schedule_id");
			return 0;
		}
		//doctor_id = doctorServiceImpl.retrieveDoctorNameByID(id);
		prescriptionDaoImpl.insertCreatePrescription(doctor_id, patient_id, prescription_id);
		if(prescriptionDaoImpl.insertPrescription() > 0)return 1;
		
		return 0;
	}
	
	

}
