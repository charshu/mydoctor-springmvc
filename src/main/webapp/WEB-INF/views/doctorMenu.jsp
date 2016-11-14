<%@page import="com.mydoctor.model.Patient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>myDoctor Easy doctor appointment</title>
  <link rel="stylesheet" href="../../bower_components/bootstrap/dist/css/bootstrap.css" />
  <link rel="stylesheet" href="../../bower_components/font-awesome/css/font-awesome.css" />

  <link rel="stylesheet" href="styles/main.css">
</head>
<body>


Welcome ${loggedInUser}<br>
HospitalNumber ${hospitalNumber}<br>
<a href='logout.html'>Log out</a><br>

    <a class="navbar-brand" href="profile.html"><i class="fa fa-hospital-o" aria-hidden="true"></i> Profile</a><br>
    <a class="navbar-brand" href="schedule.html"><i class="fa fa-hospital-o" aria-hidden="true"></i>Schedule</a>


</body>
</html>
