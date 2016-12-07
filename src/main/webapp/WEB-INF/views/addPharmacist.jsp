<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-staff.jspf"%>

<div class="container">
	<h2>Add User</h2>
	<form:form id="addHospitalUser" method="post" action="add-pharmacist"
		commandName="newUserBean">


		<fieldset class="form-group">

			<form:label path="username">Username</form:label>
			<form:input path="username" type="text" class="form-control"
				required="required" />
			<br>
			<form:errors path="username" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">

			<form:label path="password">Password</form:label>
			<form:input path="password" type="text" class="form-control"
				required="required" />
			<br>
			<form:errors path="password" cssClass="text-warning" />
		</fieldset>
		
<!-- 		<fieldset class="form-group"> -->

<%-- 			<form:label path="name">Name</form:label> --%>
<%-- 			<form:input path="name" type="text" class="form-control" --%>
<%-- 				required="required" /> --%>
<!-- 			<br> -->
<%-- 			<form:errors path="name" cssClass="text-warning" /> --%>
<!-- 		</fieldset> -->
		
<!-- 		<fieldset class="form-group"> -->

<%-- 			<form:label path="surname">Surname</form:label> --%>
<%-- 			<form:input path="surname" type="text" class="form-control" --%>
<%-- 				required="required" /> --%>
<!-- 			<br> -->
<%-- 			<form:errors path="surname" cssClass="text-warning" /> --%>
<!-- 		</fieldset> -->


		<button type="submit" class="btn btn-success">Submit</button>
	</form:form>
</div>

<%@ include file="common/footer.jspf"%>