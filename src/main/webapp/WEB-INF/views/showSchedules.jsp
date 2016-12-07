<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-doctor.jspf"%>

<div class="container-fluid">
 <h2>Schedule <a href="/add-schedule" class="btn btn-success"><i class="fa fa-calendar-plus-o" aria-hidden="true"></i> Add</a></h2>
 <c:if test="${schedules.size()>0}">
<table class="table">
<thead>
		<tr>
			<th>ID </th>
			<th>Start Date </th>
			<th>End Date</th>
			<th></th>
		</tr>
	</thead>
<c:forEach items="${schedules}" var="schedule">
   <tr>
       <td>${schedule.id}</td>
       <td>${schedule.printStart()}</td>
       <td>${schedule.printEnd()}</td>
       <td><a href="/cancel-schedule?schedule_id=${schedule.id}" class="btn btn-danger"><i class="fa fa-calendar-times-o" aria-hidden="true"></i> Cancel</a></td>
    </tr>
</c:forEach>

</table>
</c:if>
<c:if test="${schedules.size()==0}">
	<div class="alert alert-info">No schedules.</div>
</c:if>

<h2>Request for cancel <small>(waiting for approval from staff)</small></h2>
<table class="table">
<c:if test="${requestCancelSchedules.size()>0}">
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
</c:if>
<c:if test="${requestCancelSchedules.size()==0}">
	<div class="alert alert-info">No request.</div>
</c:if>
</table>
</div>



<%@ include file="common/footer.jspf"%>
