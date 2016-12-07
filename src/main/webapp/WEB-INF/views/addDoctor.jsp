<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-staff.jspf"%>

<div class="container">
	<h2>Add User</h2>
	<form:form id="addHospitalUser" method="post" action="add-doctor"
		commandName="doctor">


		<fieldset class="form-group">

			<form:label path="username1">Username</form:label>
			<form:input path="username1" type="text" class="form-control"
				required="required" />
			<br>
			<form:errors path="username1" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">

			<form:label path="password1">Password</form:label>
			<form:input path="password1" type="text" class="form-control"
				required="required" />
			<br>
			<form:errors path="password1" cssClass="text-warning" />
		</fieldset>
		
		<fieldset class="form-group">

			<form:label path="name">Name</form:label>
			<form:input path="name" type="text" class="form-control"
				required="required" />
			<br>
			<form:errors path="name" cssClass="text-warning" />
		</fieldset>
		
		<fieldset class="form-group">

			<form:label path="surname">Surname</form:label>
			<form:input path="surname" type="text" class="form-control"
				required="required" />
			<br>
			<form:errors path="surname" cssClass="text-warning" />
		</fieldset>
		
		<fieldset class="form-group">

			<form:label path="department">Department</form:label>
			<form:input path="department" type="text" class="form-control"
				required="required" />
			<br>
			<form:errors path="department" cssClass="text-warning" />
		</fieldset>
		
		<fieldset class="form-group">

			<form:label path="tel">Tel</form:label>
			<form:input path="tel" type="text" class="form-control"
				required="required" maxlength="10" />
			<br>
			<form:errors path="tel" cssClass="text-warning" />
		</fieldset>

		<button type="submit" class="btn btn-success">Submit</button>
	</form:form>
</div>

<%@ include file="common/footer.jspf"%>