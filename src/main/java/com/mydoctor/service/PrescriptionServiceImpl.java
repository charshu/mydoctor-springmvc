package com.mydoctor.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Service;

import com.mydoctor.dao.PrescriptionDaoImpl;
import com.mydoctor.model.MedicineBean;

@Service
public class PrescriptionServiceImpl {

	private PrescriptionDaoImpl prescriptionDaoImpl;
	private static List<MedicineBean> medicineBeans = new ArrayList<MedicineBean>();


	static {
		medicineBeans.add(new MedicineBean(1, "Paracetamon", "2", "dont use"));
		medicineBeans.add(new MedicineBean(2, "Paracetamon", "2", "dont use"));
		medicineBeans.add(new MedicineBean(3, "Paracetamon", "2", "dont use"));
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

}
