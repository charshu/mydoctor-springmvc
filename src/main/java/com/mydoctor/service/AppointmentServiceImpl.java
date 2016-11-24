package com.mydoctor.service;

import java.util.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import com.mydoctor.dao.DoctorDaoImpl;
import com.mydoctor.dao.PatientDaoImpl;
import com.mydoctor.model.Appointment;
import com.mydoctor.model.Schedule;

public class AppointmentServiceImpl {

	private PatientDaoImpl patientDaoImpl;
	private DoctorDaoImpl doctorDaoImpl;

	// private static String department;
	// private static int doctor_id;
	private static List<Schedule> schedules = new ArrayList<Schedule>();
	private static List<Appointment> appointments = new ArrayList<Appointment>();
	private static ArrayList<Timestamp> availableTimes = new ArrayList<Timestamp>();
	private static final int APPOINTMENT_LIMIT = 15;
	private static final int WALK_IN_LIMIT = 5;

	static {
		schedules.add(new Schedule(4, new Timestamp(new Date().getTime()), new Timestamp(new Date().getTime())));
	}

	public DoctorDaoImpl getDoctorDaoImpl() {
		return doctorDaoImpl;
	}

	public void setDoctorDaoImpl(DoctorDaoImpl doctorDaoImpl) {
		this.doctorDaoImpl = doctorDaoImpl;
	}
	
	public static List<Schedule> getSchedules() {
		return schedules;
	}

	public static void setSchedules(List<Schedule> schedules) {
		AppointmentServiceImpl.schedules = schedules;
	}

	public static List<Appointment> getAppointments() {
		return appointments;
	}

	public static void setAppointments(List<Appointment> appointments) {
		AppointmentServiceImpl.appointments = appointments;
	}

	public PatientDaoImpl getPatientDaoImpl() {
		return patientDaoImpl;
	}

	public void setPatientDaoImpl(PatientDaoImpl patientDaoImpl) {
		this.patientDaoImpl = patientDaoImpl;
	}

	public void loadAllSchedules() throws SQLException {
		setSchedules(doctorDaoImpl.retriveAllSchedules());
	}

	public void loadAllDoctorSchedules(int doctor_id) throws SQLException {
		setSchedules(doctorDaoImpl.retriveAllDoctorSchedules(doctor_id));
		//System.out.println("schedules: " + schedules.toString());
	}

	public void loadAllDepartmentSchedules(String department) throws SQLException {
		setSchedules(doctorDaoImpl.retriveAllDepartmentSchedules(department));
	}

	public void loadAllDoctorAppointment(int doctor_id) throws SQLException {
		setAppointments(patientDaoImpl.retrieveAllDoctorAppointments(doctor_id)); 
		//System.out.println("appointments: " + appointments.toString());
	}

	public ArrayList<Appointment> filterAppointment(DateTime startTime, DateTime endTime) {
		ArrayList<Appointment> appointmentsInSchedule = new ArrayList<Appointment>();
		for (Appointment appointment : appointments) {
			DateTime appointmentTime = new DateTime(appointment.getDate(), DateTimeZone.forID("Asia/Bangkok"));
			System.out.println("filter time : "+appointmentTime);
			if (appointmentTime.isAfter(startTime) || appointmentTime.isEqual(startTime) && appointmentTime.isBefore(endTime)) {
				appointmentsInSchedule.add(appointment);

			}
		}
		return appointmentsInSchedule;
	}
	
	public void clearOldAvailableTimes(){
		availableTimes.clear();
	}
	
	public ArrayList<Timestamp> getAvailableTimes() {
		return availableTimes;
	}
	public Timestamp getAvailableTime(int index) {
		return availableTimes.get(index);
	}

	public static void setAvailableTimes(ArrayList<Timestamp> availableTimes) {
		AppointmentServiceImpl.availableTimes = availableTimes;
	}

	public int saveAppointment(Appointment appointment)throws SQLException {
		int appointment_id = patientDaoImpl.insertAppointment(appointment.getDate(), appointment.getSymptom(),"waiting");
		if(appointment_id<0){
			System.out.println("[ERROR] cannot insert appointment");
			return -1;
		}
		return patientDaoImpl.insertCreateAppointment(appointment.getPatientId(),appointment.getDoctorId(),appointment_id);
		
		
	}
	
	public ArrayList<Timestamp> findDoctorAllAvailableTime(int doctor_id) throws SQLException {
		clearOldAvailableTimes();
		loadAllDoctorSchedules(doctor_id);
		loadAllDoctorAppointment(doctor_id);
		System.out.println("All appointment: " + appointments);
		DateTimeZone timeZone = DateTimeZone.forID("Asia/Bangkok");
		DateTime now = DateTime.now(timeZone);
		System.out.println("Now: " + now.toString());
		DateTime minDateTime = now.plusDays(1).withTimeAtStartOfDay(); // tomorrow
		DateTime maxDateTime = now.plusDays(7).withTimeAtStartOfDay(); // tomorrow
		int count = 0;		
		DateTime startTime;
		DateTime endTime;
		DateTime startTimeSlot;
		DateTime endTimeSlot;
		DateTime appointmentTime;
		
		ArrayList<Appointment> appointmentsInSchedule;
		for (Schedule schedule : schedules) {
			System.out.println("consider schedule: " + schedule.toString());
			startTime = new DateTime(schedule.getStart(), DateTimeZone.forID("Asia/Bangkok"));
			endTime = new DateTime(schedule.getEnd(), DateTimeZone.forID("Asia/Bangkok"));
			System.out.println("start time is : " + startTime);
			System.out.println("end time is : " + endTime);
			if (!startTime.isBefore(endTime) || startTime.isBefore(minDateTime) || endTime.isAfter(maxDateTime))
				continue; // skip if cannot make appointment in schedule

			System.out.println("This schedule is in range");
			appointmentsInSchedule = filterAppointment(startTime, endTime); // filter
			if (appointmentsInSchedule.size() > 15)continue;
			System.out.println("filtered appointments : " + appointmentsInSchedule.toString());
			
			// init slot time
			startTimeSlot = startTime;
			endTimeSlot = startTime.plusMinutes(30); // +30mins

			System.out.println("checking available slot");
			while (startTimeSlot.isBefore(endTime)) {
				System.out.println("start time slot = " + startTimeSlot);
				System.out.println("end time slot = " + endTimeSlot);
				count = 0;
				
				for (Appointment appointment : appointmentsInSchedule) {
					appointmentTime = new DateTime(appointment.getDate(), DateTimeZone.forID("Asia/Bangkok"));
					if ( (appointmentTime.isAfter(startTimeSlot) ||appointmentTime.isEqual(startTimeSlot) )
							&& appointmentTime.isBefore(endTimeSlot) ) {
						count++;
					}
					System.out.println("count = " + count);
				}
				if (count <= 4) {
					System.out.println("This slot is available !");
					availableTimes.add(new Timestamp(startTimeSlot.toDate().getTime()));
				}
				count = 0;
				startTimeSlot = startTimeSlot.plusMinutes(30); // +30mins
				endTimeSlot = endTimeSlot.plusMinutes(30); // +30mins
			}
		}
		return availableTimes;
		
	}

	public int cancelAppointment(String username, int appointment_id) throws SQLException {

		return 0;
	}

}
