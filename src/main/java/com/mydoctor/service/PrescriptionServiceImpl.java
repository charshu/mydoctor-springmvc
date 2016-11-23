package com.mydoctor.service;

import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Iterator;
import org.springframework.stereotype.Service;

import com.mydoctor.dao.MedicineDaoImpl;
import com.mydoctor.dao.PrescriptionDaoImpl;

import com.mydoctor.model.Doctor;
import com.mydoctor.model.Pharmacist;
import com.mydoctor.model.Prescription;

import com.mydoctor.model.MedicineBean;
import com.mydoctor.model.Schedule;

public class PrescriptionServiceImpl {

	private PrescriptionDaoImpl prescriptionDaoImpl;
	private MedicineDaoImpl medicineDaoImpl;
	private static ArrayList<Prescription> prescriptionHistory = new ArrayList<Prescription>();
	private static List<MedicineBean> medicineBeans = new ArrayList<MedicineBean>();

	private static int patient_id, doctor_id;

//	 static {
//	 medicineBeans.add(new MedicineBean(111, "Paracetamon", "2", "dont use"));
//	 medicineBeans.add(new MedicineBean(222, "Paracetamon", "2", "dont use"));
//	 medicineBeans.add(new MedicineBean(333, "Paracetamon", "2", "dont use"));
//	 }

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

	public void addMedicineBean(MedicineBean medicineBean) throws SQLException {
		//medicineBean.setName(medicineDaoImpl.getMedicineName(medicineBean.getId()));
		medicineBeans.add(new MedicineBean(medicineBean.getId(), medicineBean.getName(), medicineBean.getAmount(), medicineBean.getInstruction()));
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


//	public Prescription retrievePrescription(String username) throws SQLException {
//
//		return prescriptionDaoImpl.retrievePrescription(username);
//	}

	public ArrayList<Prescription> retrieveAllPrescription() throws SQLException {
		return prescriptionDaoImpl.retriveAllwaitPrescription();

	}

	public ArrayList<Prescription> findPrescriptionHistory(String username, Prescription findprescriptionh)
			throws SQLException {
		int userid = findprescriptionh.getUserid();
		System.out.println(userid);
		return prescriptionDaoImpl.retrievePrescriptionHistory(userid);
	}

	public void changeStatusToCompete(int prescript_id) throws SQLException {

		prescriptionDaoImpl.updateStatus(prescript_id);

	}

	// public Prescription createPrescription(String prescriptionId,String
	// medicineId,String medicine,String instruction, String amount) {
	// return new Prescription(prescriptionId, medicineId, medicine,
	// instruction, amount);
	// }


	public int savePrescription(int doctor_id, int patient_id, int med_id, String amount, String instruction) throws SQLException{
		System.out.println("pass1");
		int prescription_id = prescriptionDaoImpl.insertPrescription(med_id, amount, instruction);
		//System.out.println("pass1");
		if(prescription_id == -1){
			System.out.println("[ERROR] cannot retrieve schedule_id");
			return 0;
		}
		//doctor_id = doctorServiceImpl.retrieveDoctorNameByID(id);
		prescriptionDaoImpl.insertCreatePrescription(doctor_id, patient_id, prescription_id);
		//System.out.println("pass2");
		if(prescriptionDaoImpl.insertPrescription(med_id, amount, instruction) > 0)return 1;
		
		return 0;
	}

}
