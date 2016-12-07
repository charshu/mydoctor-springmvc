<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-patient.jspf"%>

<div class="container-fluid">
<c:if test="${appointments.size()>0}">
<div class="alert alert-warning"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i> Please come in 20 minutes before your appointment.</div>
</c:if>
<c:if test="${msg == 'done'}">
<div class="alert alert-success">New appointment is added. For more information, please check in your inbox.</div>
</c:if>
<h2>Appointment Lists <a href="/choose-doctor" class="btn btn-success"><i class="fa fa-plus" aria-hidden="true"></i> New appointment</a></h2>
<c:if test="${appointments.size()>0}">

<table class="table">
<thead >
		<tr>
			<th>ID </th>
			<th>Appointment Date </th>
			<th>Doctor</th>
			<th>Department</th>
			<th>Symptom</th>
			<!-- <th>Status</th> -->

			<th></th>
		</tr>
	</thead>
	
<c:forEach items="${appointments}" var="appointment">
   <tr>
       <td>${appointment.id}</td>
       <td>${appointment.printDate()}</td>
       <td>${appointment.doctorName} ${appointment.doctorSurname}</td>
       <td>${appointment.department} </td> 
       <td>${appointment.symptom}</td>
      <!--   <td>${appointment.status}</td> -->
       <c:if test="${(appointment.status == 'waiting')}">
       <td><a href="/cancel-appointment?appointmentId=${appointment.id}" class="btn btn-danger">Cancel</a></td>
       </c:if>
       <c:if test="${(appointment.status == 'done')}">
       <td><button  class="btn btn-default" disabled="disabled">Done</button></td>
       </c:if>
       <c:if test="${(appointment.status == 'timeout')}">
       <td><button  class="btn btn-default" disabled="disabled">Abandoned</button></td>
       </c:if>
       <c:if test="${(appointment.status == 'postpone')}">
       <td><button  class="btn btn-default" disabled="disabled">Postponed</button></td>
       </c:if>
       <c:if test="${(appointment.status == 'cancel')}">
       <td><button  class="btn btn-default" disabled="disabled">Cancel</button></td>
       </c:if>
    </tr>
</c:forEach>

</table>
</c:if>
<c:if test="${appointments.size()==0}">
	<div class="alert alert-info">you have no appointment.</div>
</c:if>
</div>



<%@ include file="common/footer.jspf"%>
