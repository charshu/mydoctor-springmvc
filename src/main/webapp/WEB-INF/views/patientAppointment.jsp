<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-patient.jspf"%>

<div class="container-fluid">

<h2>Appointment Lists <i class="fa fa-calendar-check-o" aria-hidden="true"></i></h2>
<div class="container">
<table class="table">
<thead style="background:#E56717 !important">
		<tr>
			<th>ID </th>
			<th>Appointment Date </th>
			<th>Doctor</th>
			<th>Symptom</th>
			<th></th>
		</tr>
	</thead>
<c:forEach items="${appointments}" var="appointment">
   <tr>
       <td>${appointment.id}</td>
       <td>${appointment.printDate()}</td>
       <td>${appointment.doctorName}</td>
       <td>${appointment.symptom}</td>
       <td><a href="/cancel-appointment?appointmentId=${appointment.id}" class="btn btn-danger">Cancel</a></td>
    </tr>
</c:forEach>

</table>
<a href="/choose-doctor" class="btn btn-success">New appointment</a>
</div>
</div>


<%@ include file="common/footer.jspf"%>
