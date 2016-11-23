<%@ include file="common/header.jspf"%>
<nav role="navigation" class="navbar navbar-default">

    <div class="">
        <a href="/login" class="navbar-brand">MyHospital    <i class="fa fa-hospital-o" aria-hidden="true"></i></a>
    </div>
   </nav>
    <div class="col-sm-4 col-md-offset-3 ">
	<div class="container">
		<form:form id="loginForm" method="post" action="login" commandName="loginBean">
			<fieldset class="form-group">
			<div class="col-xs-8">
				<form:label path="username">Enter your username</form:label><br>
				<form:input path="username" type="text" class="form-control " required="required"/>	
				<form:errors path="username" cssClass="text-warning" />
				</div>
				</fieldset>
				
			<fieldset class="form-group">
			<div class="col-xs-8">
				<form:label path="password">Please enter your password</form:label>
				<form:password path="password" class="form-control" /><br>
				<form:errors path="password" cssClass="text-warning" />
				</div>
			</fieldset>
			<div class="col-sm-4 ">
			 <button type="submit" class="btn btn-success col-xs-4"><i class="fa fa-sign-in" aria-hidden="true"></i>
			  Login</button><br>
			 </div>
			 <br>
		</form:form>
					<div class="col-sm-4  "> <br>
			 <a href="/register" type="submit" class="btn btn-primary col-xs-4"><i class="fa fa-user-plus" aria-hidden="true"></i>
			  Register</a><br>
		
	</div>
	</div>
		
<%@ include file="common/footer.jspf"%>