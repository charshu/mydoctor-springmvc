package com.mydoctor.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.mydoctor.model.Patient;

public class EmailService {
	
	public static void emailNewUser(Patient patient){
		final String usernameServer = "smile.shojea@gmail.com";
		final String passwordServer = "uuqlfvzdqinelrsy";
		
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
				InternetAddress.parse("smile.shojea@gmail.com"));
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
}
