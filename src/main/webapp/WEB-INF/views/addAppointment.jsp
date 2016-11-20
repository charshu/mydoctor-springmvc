<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-patient.jspf"%>

<div class="container-fluid">

<table class="table">
<thead>
		<tr>
			<th>ID </th>
			<th>Appointment Date </th>
			<th>Symptom</th>
		</tr>
	</thead>
<c:forEach items="${doctors}" var="doctor">
   <tr>
       <td>${doctor.name}</td>
       <td>${doctor.surname}</td>
       <td>${doctor.department}</td>
       <td><a href="/add-appointment?doctorId=${doctor.id}" class="btn btn-danger">Cancel</a></td>
    </tr>
</c:forEach>

</table>
<a href="/add-schedule" class="btn btn-success">Add</a>
</div>



<%@ include file="common/footer.jspf"%>
