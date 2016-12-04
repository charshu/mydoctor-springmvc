<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-doctor.jspf"%>

<div class="container-fluid">


<h2>Current schedule</h2>
<table class="table">

<c:if test="${currentSchedule!=null}">
 <div class="alert alert-success" style="text-align: center;">
  <h1><i class="fa fa-clock-o" aria-hidden="true"></i>${currentSchedule.printStart()}  ~  <i class="fa fa-clock-o" aria-hidden="true"></i>${currentSchedule.printEnd()}</h1>
</div>

 </c:if>
 <c:if test="${currentSchedule==null}">
 <div class="alert alert-info">
  You have no schedule now.
</div>

 </c:if>


</table>

<h2>Patients in schedule </h2>
<table class="table">
<c:if test="${appointments.size() > 0}">
<thead >
		<tr>
			<th>Appointment ID </th>
			<th>Appointment date </th>
			<th>Patient Name</th>
			<th>Patient Surname</th>
			<th>Patient Gender</th>
			<th>Hospital Number</th>
			<th>Symptom</th>
			<th></th>
		</tr>
	</thead>

<c:forEach items="${appointments}" var="appointment">
   <tr>
       <td>${appointment.id}</td>
       <td>${appointment.printDate()}</td>
       <td>${appointment.patientName}</td>
       <td>${appointment.patientSurname}</td>
       <td>${appointment.patientGender}</td>
       <td>${appointment.patientHospitalNumber}</td>
       <td>${appointment.symptom}</td>
       <td><a href="/diagnose?patientId=${appointment.patientId}" class="btn btn-success">Diagnose</a></td>
    </tr>
</c:forEach>
</c:if>
<c:if test="${appointments.size() == 0}">
 <div class="alert alert-info">
  There are no waiting patient now.
</div>
</c:if>

</table>

<h2>Your next appointments </h2>
<table class="table">
<c:if test="${appointmentInComings.size() > 0}">
<thead >
		<tr>
			<th>Appointment ID </th>
			<th>Appointment date </th>
			<th>Patient Name</th>
			<th>Patient Surname</th>
			<th>Patient Gender</th>
			<th>Hospital Number</th>
			<th>Symptom</th>
			<th></th>
		</tr>
	</thead>

<c:forEach items="${appointmentInComings}" var="appointmentInComing">
   <tr>
       <td>${appointmentInComing.id}</td>
       <td>${appointmentInComing.printDate()}</td>
       <td>${appointmentInComing.patientName}</td>
       <td>${appointmentInComing.patientSurname}</td>
       <td>${appointmentInComing.patientGender}</td>
       <td>${appointmentInComing.patientHospitalNumber}</td>
       <td>${appointmentInComing.symptom}</td>
       <td></td>
    </tr>
</c:forEach>
</c:if>
<c:if test="${appointmentInComings.size() == 0}">
 <div class="alert alert-info">
  There are no incoming appointments.
</div>
</c:if>

</table>

</div>

<%@ include file="common/footer.jspf"%>
