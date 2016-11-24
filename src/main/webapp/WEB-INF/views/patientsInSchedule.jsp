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
			
		</tr>
	</thead>
<c:if test="${currentSchedule!=null}">
   <tr class="success">
       <td>${currentSchedule.id}</td>
       <td>${currentSchedule.printStart()}</td>
       <td>${currentSchedule.printEnd()}</td>

    </tr>
 </c:if>
 <c:if test="${currentSchedule==null}">
   <tr class="warning">
       <td>none</td>
       <td>none</td>
       <td>none</td>
    </tr>
 </c:if>


</table>

<h2>Patients in schedule <i class="fa fa-calendar-check-o" aria-hidden="true"></i></h2>
<table class="table">
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
<c:if test="${appointments.size() > 0}">
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
	   <tr>
       <td>none</td>
        <td>none</td>
         <td>none</td>
          <td>none</td>
           <td>none</td>
            <td>none</td>
             <td>none</td>
  
        <td></td>
    </tr>
</c:if>

</table>

<h2>Next Appointment <i class="fa fa-calendar-check-o" aria-hidden="true"></i></h2>
<table class="table">
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
<c:if test="${appointmentInComings.size() > 0}">
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
	   <tr>
       <td>none</td>
        <td>none</td>
         <td>none</td>
          <td>none</td>
           <td>none</td>
            <td>none</td>
             <td>none</td>
  
        <td></td>
    </tr>
</c:if>

</table>

</div>

<%@ include file="common/footer.jspf"%>
