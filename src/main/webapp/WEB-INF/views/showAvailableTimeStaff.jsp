<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-staff.jspf"%>

<div class="container-fluid">

<h2>Doctor <i class="fa fa-user-md" aria-hidden="true"></i></h2>
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
      <td>${chosenDoctor.name}</td>
      <td>${chosenDoctor.surname}</td>
      <td>${chosenDoctor.department}</td>
      <td>${chosenDoctor.tel}</td>
    </tr>
  
  </tbody>
</table>

<h2>Available time <i class="fa fa-clock-o" aria-hidden="true"></i></h2>
<table class="table table-striped">
<thead>
	<tr>
		<th>Time</th>
		<th></th>
	</tr>
</thead>
<c:forEach items="${suggestDateTimes}" var="suggestDateTime" varStatus="loop">
   <tr>
   <td><fmt:formatDate value="${suggestDateTime}" pattern="E dd/MM/yyyy HH:mm"/></td>
       
       <td><a href="/staff-confirm-time?index=${loop.index}" class="btn btn-success">select</a></td>
    </tr>
</c:forEach>

</table>

</div>



<%@ include file="common/footer.jspf"%>
