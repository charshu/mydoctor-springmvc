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
<c:forEach items="${appointments}" var="appointment">
   <tr>
       <td>${appointment.id}</td>
       <td>${appointment.printDate()}</td>
       <td>${appointment.symptom}</td>
       <td><a href="/cancel-appointment?appointment=${appointment.id}" class="btn btn-danger">Cancel</a></td>
    </tr>
</c:forEach>

</table>
<a href="/add-schedule" class="btn btn-success">Add</a>
</div>



<%@ include file="common/footer.jspf"%>
