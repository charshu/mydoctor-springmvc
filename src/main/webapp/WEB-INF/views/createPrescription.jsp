<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-doctor.jspf"%>

<div class="container-fluid">


<div class="container">

	<div class="panel panel-default">
		<div class="panel-heading">
			<h1>Prescription</h1>
		</div>
		<div class="panel-body">
      		<p>Prescription Id :</p>
	  		<p>Patient Id : </p>
	  		<p>Patient Name : </p>
	  		<p>Doctor Name : </p>
		</div>
	</div>
	 
</div>

<div class="container">

<table class="table">
<thead>
		<tr>
			<th>Medicine ID </th>
			<th>Medicine Name </th>
			<th>Amount</th>
		</tr>
	</thead>
<c:forEach items="${schedules}" var="schedule">
   <tr>
       <td>${schedule.id}</td>
       <td>${schedule.printStart()}</td>
       <td>${schedule.printEnd()}</td>
    </tr>
</c:forEach>
</table>
</div>


</div>
<%@ include file="common/footer.jspf"%>
