<%@ include file="common/header.jspf"%>

	<div class="container">
		<form:form id="loginForm" method="post" action="login" commandName="loginBean">
			<fieldset class="form-group">
				<form:label path="username">Enter your user-name</form:label>
				<form:input path="username" type="text" class="form-control" required="required"/><br>
				<form:errors path="username" cssClass="text-warning" />
				</fieldset>
				
			<fieldset class="form-group">
				<form:label path="password">Please enter your password</form:label>
				<form:password path="password" class="form-control" /><br>
				<form:errors path="password" cssClass="text-warning" />
			</fieldset>
			 <button type="submit" class="btn btn-success">Submit</button>
		</form:form>
	</div>
		
<%@ include file="common/footer.jspf"%>