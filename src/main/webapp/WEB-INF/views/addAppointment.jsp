<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-patient.jspf"%>
<h2>Your Doctor <i class="fa fa-user-md" aria-hidden="true"></i></i></h2>
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
<div class="container">
	<h2>Add Appointment</h2>
	<form:form id="appointForm" method="post" action="confirm-time"
		commandName="appointment">
		<fieldset class="form-group">

			
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