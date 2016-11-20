package com.mydoctor.service;

import java.util.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Interval;
import org.springframework.stereotype.Service;

import com.mydoctor.dao.DoctorDaoImpl;
import com.mydoctor.dao.PatientDaoImpl;
import com.mydoctor.model.Appointment;
import com.mydoctor.model.Patient;
import com.mydoctor.model.Schedule;

@Service
public class AppointmentServiceImpl {

	private PatientDaoImpl patientDaoImpl;
	private DoctorDaoImpl doctorDaoImpl;

	// private static String department;
	// private static int doctor_id;
	private static List<Schedule> schedules = new ArrayList<Schedule>();
	private static List<Appointment> appointments = new ArrayList<Appointment>();
	private static final int APPOINTMENT_LIMIT = 15;
	private static final int WALK_IN_LIMIT = 5;

	static {

	}

	public DoctorDaoImpl getDoctorDaoImpl() {
		return doctorDaoImpl;
	}

	public void setDoctorDaoImpl(DoctorDaoImpl doctorDaoImpl) {
		this.doctorDaoImpl = doctorDaoImpl;
	}

	public PatientDaoImpl getPatientDaoImpl() {
		return patientDaoImpl;
	}

	public void setPatientDaoImpl(PatientDaoImpl patientDaoImpl) {
		this.patientDaoImpl = patientDaoImpl;
	}

	public void loadAllSchedule() throws SQLException {
		schedules = doctorDaoImpl.retriveAllSchedules();

	}

	public void loadAllDoctorSchedule(int doctor_id) throws SQLException {
		schedules = doctorDaoImpl.retriveAllDoctorSchedules(doctor_id);

	}

	public void loadDepartmentSchedule(String department) throws SQLException {
		schedules = doctorDaoImpl.retriveAllDepartmentSchedules(department);
	}

	public void loadAllDoctorAppointment(int doctor_id) throws SQLException {
		appointments = patientDaoImpl.retrieveAllDoctorAppointments(doctor_id);

	}

	public ArrayList<Appointment> filterAppointment(DateTime startTime, DateTime endTime) {
		ArrayList<Appointment> appointmentsInSchedule = new ArrayList<Appointment>();
		for (Appointment appointment : appointments) {
			DateTime appointmentTime = new DateTime(appointment.getDate(), DateTimeZone.forID("Asia/Bangkok"));
			if (appointmentTime.isAfter(startTime) && appointmentTime.isBefore(endTime)) {
				appointmentsInSchedule.add(appointment);

			}
		}
		return appointmentsInSchedule;
	}

	public Timestamp findDoctorAvailableTime(int doctor_id) throws SQLException {
		loadAllDoctorSchedule(doctor_id);
		loadAllDoctorAppointment(doctor_id);

		DateTimeZone timeZone = DateTimeZone.forID("Asia/Bangkok");
		DateTime now = DateTime.now(timeZone);
		DateTime minDateTime = now.plusDays(1).withTimeAtStartOfDay(); // tomorrow
		DateTime maxDateTime = now.plusDays(7).withTimeAtStartOfDay(); // tomorrow +6
		for (Schedule schedule : schedules) {

			DateTime startTime = new DateTime(schedule.getStart(), DateTimeZone.forID("Asia/Bangkok"));
			DateTime endTime = new DateTime(schedule.getEnd(), DateTimeZone.forID("Asia/Bangkok"));
			if (!startTime.isBefore(minDateTime) || !endTime.isAfter(maxDateTime))
				continue; // skip if cannot make appointment in schedule

			ArrayList<Appointment> appointmentsInSchedule = filterAppointment(startTime, endTime); // filter
			// init slot time
			DateTime startTimeSlot = startTime;
			DateTime endTimeSlot = startTime.plusMillis(7500 * 60); // +7.5mins
			while (startTimeSlot.isBefore(endTime)) {
				for (Appointment appointment : appointmentsInSchedule) {
					DateTime appointmentTime = new DateTime(appointment.getDate(), DateTimeZone.forID("Asia/Bangkok"));
					if (appointmentTime.isAfter(startTimeSlot) && appointmentTime.isBefore(endTimeSlot)) {
						continue;

					} else {
						// slot is available
						return new Timestamp(startTimeSlot.toDate().getTime());
					}
				}
				startTimeSlot.plusMillis(7500 * 60);//+ 7.5 minutes
				endTimeSlot.plusMillis(7500 * 60);//+ 7.5 minutes
			}

		}
		return new Timestamp(1);
	}

	public int cancelAppointment(String username, int appointment_id) throws SQLException {

		return 0;
	}

}
