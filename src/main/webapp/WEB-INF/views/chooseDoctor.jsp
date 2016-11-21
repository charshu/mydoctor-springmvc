<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-patient.jspf"%>

<div class="container-fluid">

<table class="table">
<thead>
		<tr>
			<th>Name </th>
			<th>Surname </th>
			<th>Department</th>
		</tr>
	</thead>
<c:forEach items="${doctors}" var="doctor">
   <tr>
       <td>${doctor.name}</td>
       <td>${doctor.surname}</td>
       <td>${doctor.department}</td>
       <td><a href="/list-doctor-time?doctorId=${doctor.id}" class="btn btn-success">select</a></td>
    </tr>
</c:forEach>

</table>

</div>



<%@ include file="common/footer.jspf"%>
