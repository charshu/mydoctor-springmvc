<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-patient.jspf"%>

<div class="container-fluid">

<h2>Doctor <i class="fa fa-user-md" aria-hidden="true"></i></i></h2>
<table class="table">
  <thead>
    <tr>
   	<th>Name</th>
   	<th>Surname</th>
   	<th>Department</th>
   	<th>Tel</th>
    </tr>
  </thead>
  <tbody>
    <tr class="info">
      <td>${doctor.name}</td>
      <td>${doctor.surname}</td>
      <td>${doctor.department}</td>
      <td>${doctor.tel}</td>
    </tr>
  
  </tbody>
</table>

<h2>Available time <i class="fa fa-clock-o" aria-hidden="true"></i></h2>
<table class="table table-striped">
<thead>
	<tr>
		<th>Time</th>
	</tr>
</thead>
<c:forEach items="${suggestDateTimes}" var="suggestDateTime">
   <tr>
   <td><fmt:formatDate value="${suggestDateTime}" pattern="E dd/MM/yyyy HH:mm"/></td>
       
       <td><a href="/add-appointment?doctorId=${doctor.id}" class="btn btn-success">select</a></td>
    </tr>
</c:forEach>

</table>

</div>



<%@ include file="common/footer.jspf"%>
