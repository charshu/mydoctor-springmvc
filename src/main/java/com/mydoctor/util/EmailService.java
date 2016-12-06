package com.mydoctor.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.mydoctor.model.Appointment;
import com.mydoctor.model.Doctor;
import com.mydoctor.model.Patient;
import com.mydoctor.model.Schedule;

public class EmailService {
	private static final String usernameServer = "smile.shojea@gmail.com";
	private static final String passwordServer = "uuqlfvzdqinelrsy";
	
	
	public static void emailNewUser(Patient patient){
		
		
		String username = patient.getUsername1();
		String password = patient.getPassword1();
		password = new String(new char[password.length()]).replace("\0", "*");
		String ssn = patient.getSsn();
		String name = patient.getName();
		String surname = patient.getSurname();
		String gender = patient.getGender();
		if("F".equals(gender))gender = "Female";
		else gender = "Male";
		String birth_date = patient.getBirthdate();
		String address = patient.getAddress();
		String tel = patient.getTel();
		String email = patient.getEmail();
		String hospitalNumber = patient.getHospitalNumber();
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(usernameServer, passwordServer);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("smile.shojea@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			message.setSubject("You have been registered to myHospital");
			message.setText("Dear, "+username
				+ "\n\nThank you for your trust in our services"
				+ "\nYour patient information:"
				+ "\nHospital Number : "+hospitalNumber
				+ "\nUsername : "+username
				+ "\nPassword : "+password
				+ "\nID card : "+ssn
				+ "\nName : "+name
				+ "\nSurname : "+surname
				+ "\nGender : "+gender
				+ "\nBirth date : "+birth_date
				+ "\nAddress : "+address
				+ "\nTel : "+tel
				+ "\nE-mail : "+email);
				

			Transport.send(message);

			System.out.println("Email has successfully sent !");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void emailNewUserByStaff(Patient patient){
		
		
//		String username = patient.getUsername1();
//		String password = patient.getPassword1();
//		password = new String(new char[password.length()]).replace("\0", "*");
		String ssn = patient.getSsn();
		String name = patient.getName();
		String surname = patient.getSurname();
		String gender = patient.getGender();
		if("F".equals(gender))gender = "Female";
		else gender = "Male";
		String birth_date = patient.getBirthdate();
		String address = patient.getAddress();
		String tel = patient.getTel();
		String email = patient.getEmail();
		String hospitalNumber = patient.getHospitalNumber();
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(usernameServer, passwordServer);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("smile.shojea@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			message.setSubject("You have been registered to myHospital");
			message.setText("Dear, "+name
				+ "\n\nThank you for your trust in our services"
				+ "\nYour patient information:"
				+ "\nHospital Number : "+hospitalNumber
				+ "\nID card : "+ssn
				+ "\nName : "+name
				+ "\nSurname : "+surname
				+ "\nGender : "+gender
				+ "\nBirth date : "+birth_date
				+ "\nAddress : "+address
				+ "\nTel : "+tel
				+ "\nE-mail : "+email);
				

			Transport.send(message);

			System.out.println("Email has successfully sent !");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void emailOldUser(Patient patient){
		
		String username = patient.getUsername1();
		String password = patient.getPassword1();
		password = new String(new char[password.length()]).replace("\0", "*");
		String ssn = patient.getSsn();
		String name = patient.getName();
		String surname = patient.getSurname();
		String gender = patient.getGender();
		if("F".equals(gender))gender = "Female";
		else gender = "Male";
		String birth_date = patient.getBirthdate();
		String address = patient.getAddress();
		String tel = patient.getTel();
		String email = patient.getEmail();
		String hospitalNumber = patient.getHospitalNumber();
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(usernameServer, passwordServer);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("smile.shojea@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			message.setSubject("You have been registered to myHospital");
			message.setText("Dear, "+username
				+ "\n\nThank you for your trust in our services"
				+ "\nYour patient information:"
				+ "\nHospital Number : "+hospitalNumber
				+ "\nUsername : "+username
				+ "\nPassword : "+password
				+ "\nID card : "+ssn
				+ "\nName : "+name
				+ "\nSurname : "+surname
				+ "\nGender : "+gender
				+ "\nBirth date : "+birth_date
				+ "\nAddress : "+address
				+ "\nTel : "+tel
				+ "\nE-mail : "+email);
				

			Transport.send(message);

			System.out.println("Email has successfully sent !");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void emailNewAppointment(Appointment appointment,Patient patient,Doctor doctor) {
		
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(usernameServer, passwordServer);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("smile.shojea@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(patient.getEmail()));
			message.setSubject("You have been registered to myHospital");
			message.setText("Dear, "+patient.getUsername1()
				+ "\n\nYour have made a new appointment."
				+ "\nAppointment ID : "+appointment.getId()
				+ "\nDoctor : "+doctor.getName()+" "+doctor.getSurname()
				+ "\nPatient : "+patient.getName()+" "+patient.getSurname()
				+ "\nSymptom : "+appointment.getSymptom()
				+ "\nAppointment Date : "+appointment.getDate()
				+ "\n\nPlease come in 20 minutes before your appointment");

			Transport.send(message);

			System.out.println("Email has successfully sent !");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}
public static void emailPostponeAppointment(Appointment appointment,String email,Schedule schedule) {
		
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(usernameServer, passwordServer);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("smile.shojea@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			message.setSubject("Dr. "+ appointment.getDoctorName()+" "+appointment.getDoctorSurname()+" cancel his schedule at "+schedule.getStart()+" to " + schedule.getEnd() );
			message.setText("Dear, "+appointment.getPatientName()
				+ "\n\nThis appointment was postponed."
				+ "\nAppointment ID : "+appointment.getId()
				+ "\nDoctor : "+appointment.getDoctorName()+" "+appointment.getDoctorSurname()
				+ "\nPatient : "+appointment.getPatientName()+" "+appointment.getPatientSurname()
				+ "\nSymptom : "+appointment.getSymptom()
				+ "\nAppointment Date : "+appointment.getDate()
				+ "\n\nWe apologize for any inconvenience");

			Transport.send(message);

			System.out.println("Email has successfully sent !");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}
}
