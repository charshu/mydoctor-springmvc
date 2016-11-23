<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-doctor.jspf"%>

<div class="container-fluid">
<h2>Schedule</h2>
<table class="table">
<thead>
		<tr>
			<th>ID </th>
			<th>Start Date </th>
			<th>End Date</th>
		</tr>
	</thead>
<c:forEach items="${schedules}" var="schedule">
   <tr>
       <td>${schedule.id}</td>
       <td>${schedule.printStart()}</td>
       <td>${schedule.printEnd()}</td>
       <td><a href="/delete-schedule?schedule_id=${schedule.id}" class="btn btn-danger"><i class="fa fa-calendar-times-o" aria-hidden="true"></i> Delete</a></td>
    </tr>
</c:forEach>

</table>
<a href="/add-schedule" class="btn btn-success"><i class="fa fa-calendar-plus-o" aria-hidden="true"></i> Add</a>
</div>



<%@ include file="common/footer.jspf"%>
