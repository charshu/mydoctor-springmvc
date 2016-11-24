package com.mydoctor.service;

import java.sql.SQLException;
import java.util.ArrayList;
import com.mydoctor.dao.DoctorDaoImpl;
import com.mydoctor.model.Appointment;
import com.mydoctor.model.DiagnosisBean;
import com.mydoctor.model.Doctor;
import com.mydoctor.model.GeneralInfo;
import com.mydoctor.model.Patient;
import com.mydoctor.model.Schedule;
import com.mydoctor.model.ViewInfo;

public class DoctorServiceImpl {

	private DoctorDaoImpl doctorDaoImpl;
	private static ArrayList<Doctor> doctors = new ArrayList<Doctor>();

	public DoctorDaoImpl getDoctorDaoImpl() {
		return doctorDaoImpl;
	}

	public void setDoctorDaoImpl(DoctorDaoImpl doctorDaoImpl) {
		this.doctorDaoImpl = doctorDaoImpl;
	}

	public static ArrayList<Doctor> getDoctors() {
		return doctors;
	}

	public static void setDoctors(ArrayList<Doctor> doctors) {
		DoctorServiceImpl.doctors = doctors;
	}

	public Doctor retrieveDoctor(String username) throws SQLException {
		int doctor_id = retrieveId(username);
		return doctorDaoImpl.retrieveDoctor(doctor_id);
	}

	public Doctor retrieveDoctor(int doctor_id) throws SQLException {
		return doctorDaoImpl.retrieveDoctor(doctor_id);
	}

	public String retrieveDoctorNameByID(int doctor_id) throws SQLException {
		return doctorDaoImpl.retrieveDoctorNameByID(doctor_id);
	}

	public ArrayList<Doctor> retrieveAllDoctors() throws SQLException {
		setDoctors(doctorDaoImpl.retrieveAllDoctors());
		return doctors;
	}

	public int retrieveId(String username) throws SQLException {
		return doctorDaoImpl.retrieveId(username);
	}

	public ArrayList<Schedule> retriveAllSchedules(String username) throws SQLException {
		int doctor_id = retrieveId(username);
		return doctorDaoImpl.retriveAllDoctorSchedules(doctor_id);
	}
	public ArrayList<Schedule> retriveAllSchedulesStatus(String username,String status) throws SQLException {
		int doctor_id = retrieveId(username);
		return doctorDaoImpl.retriveAllSchedulesStatus(doctor_id,status);
	}
	public ArrayList<Schedule> retriveAllSchedulesStatus(String status) throws SQLException {
		
		return doctorDaoImpl.retriveAllSchedulesStatus(status);
	}
	

	public ArrayList<Schedule> retriveAllDepartmentSchedules(String department) throws SQLException {
		return doctorDaoImpl.retriveAllDepartmentSchedules(department);
	}
	public Schedule retrieveSchedule(int schedule_id)throws SQLException {
		return doctorDaoImpl.retrieveSchedule(schedule_id);
	}
	public ArrayList<Schedule> retriveAllSchedules() throws SQLException {

		return doctorDaoImpl.retriveAllSchedules();
	}

	public int saveSchedule(String username, Schedule schedule) throws SQLException {

		int schedule_id = doctorDaoImpl.insertSchedule(schedule);
		if (schedule_id == -1) {
			System.out.println("[ERROR] cannot retrieve schedule_id");
			return 0;
		}
		int doctor_id = doctorDaoImpl.retrieveId(username);
		if (doctor_id == -1) {
			System.out.println("[ERROR] cannot retrieve doctor_id");

			return 0;
		}
		if (doctorDaoImpl.insertDoctorSchedule(doctor_id, schedule_id) > 0)
			return 1;

		return 0;
	}

	public GeneralInfo findPatientGenInfo(ViewInfo viewinfo) throws SQLException {
		int record_id = doctorDaoImpl.retrieveRecordId(viewinfo.getHospitalNumber());
		System.out.println(record_id);
		return doctorDaoImpl.retriveGenInfo(record_id);
	}

	public Patient findPatientInfo(ViewInfo viewinfo) throws SQLException {
		int patient_id = doctorDaoImpl.retrievePatientId(viewinfo.getHospitalNumber());
		System.out.println(patient_id);
		return doctorDaoImpl.retriveInfo(patient_id);
	}
	public int setStatusSchedule(Schedule schedule,String status)throws SQLException{
		return doctorDaoImpl.setStatusSchedule(schedule.getId(),status);
	}
	public int deleteSchedule(String username, int schedule_id) throws SQLException {
		int doctor_id = doctorDaoImpl.retrieveId(username);

		int updateCount = doctorDaoImpl.deleteDoctorSchedule(doctor_id, schedule_id);
		if (updateCount == 0) {
			System.out.println("[ERROR] cannot delete doctor_schedule " + "(doctor_id:" + doctor_id + ",schedule_id:"
					+ schedule_id + ")");
		}

		updateCount = doctorDaoImpl.deleteSchedule(schedule_id);
		if (updateCount == 0) {
			System.out.println("[ERROR] cannot delete schedule, schedule_id:" + schedule_id);
		}

		System.out.println(
				"[SUCCESS] delete doctor_schedule " + "(doctor_id:" + doctor_id + ",schedule_id:" + schedule_id + ")");
		return 1;
	}
	
	public Schedule retrieveCurrentSchedule(String username)throws SQLException{
		int doctor_id = doctorDaoImpl.retrieveId(username);
		return doctorDaoImpl.retrieveCurrentSchedule(doctor_id);
		 
	}
	public ArrayList<Appointment> retrieveAllAppointmentInSchedule(String username) throws SQLException {
		int doctor_id = doctorDaoImpl.retrieveId(username);
		Schedule currentSchedule = retrieveCurrentSchedule(username);
		if (currentSchedule == null)
			return new ArrayList<Appointment>();
	
		return doctorDaoImpl.retrieveAllAppointmentInSchedule(doctor_id, currentSchedule);
	}

	public int saveDiagnosis(DiagnosisBean diagnosisBean) throws SQLException {

		int diagnosis_id = doctorDaoImpl.insertDiagnosis(diagnosisBean.getDisease_id(),diagnosisBean.getSymptom());
		if (doctorDaoImpl.insertDiagnose(diagnosisBean.getDoctorId(), diagnosisBean.getPatientId(), diagnosis_id) > 0)
			return 1;
		return 0;

	}

}
