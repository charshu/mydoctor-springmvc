<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-staff.jspf"%>


<div class="container">
<h2>Your Doctor <i class="fa fa-user-md" aria-hidden="true"></i></h2>
	<table class="table table-bordered">

      <tr><th>Name</th><td>${chosenDoctor.name}</td></tr>
      <tr><th>Surname</th><td>${chosenDoctor.surname}</td></tr>
      <tr><th>Department</th><td>${chosenDoctor.department}</td></tr>
      <tr><th>Tel</th><td>${chosenDoctor.tel}</td></tr>

</table>
	<h2>Add Appointment</h2>
	<form:form id="appointForm" method="post" action="staff-confirm-time"
		commandName="appointment">
	
			
		<fieldset class="form-group">

			<form:label path="symptom">Symptom</form:label>
			<form:input path="symptom" type="text" class="form-control"
				required="required" />
			<br>
			<form:errors path="symptom" cssClass="text-warning" />
		</fieldset>

		<button type="submit" class="btn btn-success">Submit</button>
	</form:form>
</div>

<%@ include file="common/footer.jspf"%>