<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-staff.jspf"%>

<div class="container-fluid">
<h2>Request for cancel</h2>
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
      <td><a href="/approve-cancel-schedule?scheduleId=${requestCancelSchedule.id}" class="btn btn-warning"> Approve cancel</a></td>
 
    </tr>
</c:forEach>
</c:if>
<c:if test="${requestCancelSchedules.size()==0}">
<div class="alert alert-info">No request.</div>
</c:if>
</table>
</div>


<%@ include file="common/footer.jspf"%>
