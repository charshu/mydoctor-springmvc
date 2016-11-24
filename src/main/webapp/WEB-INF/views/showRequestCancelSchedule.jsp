<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-doctor.jspf"%>

<div class="container-fluid">
<h2>Request for cancel</h2>
<table class="table">
<thead>
		<tr>
			<th>ID </th>
			<th>Start Date </th>
			<th>End Date</th>
			<th></th>
		</tr>
	</thead>
<c:forEach items="${requestCancelSchedules}" var="requestCancelSchedule">
   <tr>
       <td>${requestCancelSchedule.id}</td>
       <td>${requestCancelSchedule.printStart()}</td>
       <td>${requestCancelSchedule.printEnd()}</td>
      <td><a href="/available-schedule?schedule_id=${requestCancelSchedule.id}" class="btn btn-warning"> Stop pending</a></td>
 
    </tr>
</c:forEach>

</table>
</div>



<%@ include file="common/footer.jspf"%>
