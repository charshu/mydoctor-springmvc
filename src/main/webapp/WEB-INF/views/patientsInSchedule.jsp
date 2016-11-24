<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-doctor.jspf"%>

<div class="container-fluid">


<h2>Current schedule <i class="fa fa-calendar-check-o" aria-hidden="true"></i></h2>
<table class="table">
<thead>
		<tr>
			<th>Schedule ID </th>
			<th>Start</th>
			<th>End</th>
			<th></th>
		</tr>
	</thead>

   <tr class="success">
       <td>${currentSchedule.id}</td>
       <td>${currentSchedule.printStart()}</td>
       <td>${currentSchedule.printEnd()}</td>
 <td><a href="/delete-schedule?schedule_id=${currentSchedule.id}" class="btn btn-danger">Delete</a></td>
    </tr>


</table>

<h2>Patients in schedule <i class="fa fa-calendar-check-o" aria-hidden="true"></i></h2>
<table class="table">
<thead>
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

</table>

</div>

<%@ include file="common/footer.jspf"%>
