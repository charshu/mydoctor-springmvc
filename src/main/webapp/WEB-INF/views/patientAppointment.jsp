<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-patient.jspf"%>

<div class="container-fluid">


<h2>Appointment Lists <a href="/choose-doctor" class="btn btn-success"><i class="fa fa-plus" aria-hidden="true"></i> New appointment</a></h2>

<table class="table">
<thead >
		<tr>
			<th>ID </th>
			<th>Appointment Date </th>
			<th>Doctor</th>
			<th>Symptom</th>
			<!-- <th>Status</th> -->

			<th></th>
		</tr>
	</thead>
<c:forEach items="${appointments}" var="appointment">
   <tr>
       <td>${appointment.id}</td>
       <td>${appointment.printDate()}</td>
       <td>${appointment.doctorName}</td>
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
    </tr>
</c:forEach>

</table>

</div>



<%@ include file="common/footer.jspf"%>
