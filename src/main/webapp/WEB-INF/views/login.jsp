<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>MyHospital Application</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link href="webjars/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">

<style>
.background {
	position: relative;
	height: 100%;
	width: 100%;
	top: 0;
	left: 0;
	background-image: url("images/bg.jpg");
	background-size: cover;
	top: 0;
}
#txt{
	font-size:40px;
	color:white;
	position:relative;
	left:10px;
	text-shadow: 2px 2px 2px #212121;
}
.logo{
	width:100%;
	height:200px;
	background-image: url("images/logo.svg");
	background-repeat: no-repeat;
	background-position: center;
	
	
}
</style>
</head>

<body onload="startTime()">
	<!-- <nav role="navigation" class="navbar navbar-default"
		style="margin-bottom: 0px;">

		<div class="">
			<a href="/login" class="navbar-brand">MyHospital <i
				class="fa fa-hospital-o" aria-hidden="true"></i></a>
		</div>
	</nav> -->
	<div class="background">
	<div id="txt" ></div>
		<div class="container">
		
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
				<div class="logo"></div>
					<form:form id="loginForm" method="post" action="login"
						commandName="loginBean">
						<fieldset class="form-group">

							<form:label path="username" style="color:white;">Enter your username</form:label>
							<br>
							<form:input path="username" type="text" class="form-control "
								required="required" />
							<form:errors path="username" cssClass="text-warning" />

						</fieldset>

						<fieldset class="form-group">

							<form:label path="password" style="color:white;">Enter your password</form:label>
							<form:password path="password" class="form-control" />
							<br>
							<form:errors path="password" cssClass="text-warning" />

						</fieldset>


						<button type="submit" class="btn btn-success"
							style="width: 120px;">
							<i class="fa fa-sign-in" aria-hidden="true"></i> Login
						</button>

						<a href="/register" class="btn btn-primary" style="width: 120px;"><i
							class="fa fa-user-plus" aria-hidden="true"></i> Register</a>


						<br>
					</form:form>
				</div>
				<div class="col-md-3"></div>
			</div>
		</div>

	</div>
	<script>
		function startTime() {
			var today = new Date();
			var h = today.getHours();
			var m = today.getMinutes();
			var s = today.getSeconds();
			m = checkTime(m);
			s = checkTime(s);
			document.getElementById('txt').innerHTML = h + ":" + m + ":" + s;
			var t = setTimeout(startTime, 500);
		}
		function checkTime(i) {
			if (i < 10) {
				i = "0" + i
			}
			; // add zero in front of numbers < 10
			return i;
		}
	</script>
	<%@ include file="common/footer.jspf"%>