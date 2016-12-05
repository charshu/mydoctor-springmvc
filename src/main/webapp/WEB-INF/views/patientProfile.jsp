<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>MyDoctor Application</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="webjars/eonasdan-bootstrap-datetimepicker/4.17.43/build/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">

</head>

<%@ include file="common/navigation-patient.jspf"%>

<div class="container-fluid">
<div class="well" >
	<h2>Your profile</h2>
</div>
<div class = "container">

<div class="row">
<div class="col-md-3"></div>
<div class="col-md-6">
<table class="table table-reflow">
     <tr>
     	<th>Username</th><td>${username}</td>
     </tr>
    <tr>
		<th>HospitalNumber</th><td>${patient.hospitalNumber}</td>
	</tr>
	
     <form:form id="edit-info" method="post" action="edit-info" commandName="new_patient" class="form-horizontal"> 
     
     <tr>
     	<th>Name</th>
       <td><fieldset class="form-group">
				<form:input path="name" type="text" class="form-control"  required="required" style="height:40px;"/><br>
				<form:errors path="name" cssClass="text-warning" />
	   </fieldset></td>
	</tr>
	<tr>	
		<th>Surname</th>
		  <td><fieldset class="form-group">
				<form:input path="surname" type="text" class="form-control" required="required" style="height:40px;"/><br>
				<form:errors path="surname" cssClass="text-warning" />
		</fieldset></td>
	</tr>
	<tr>	
		<th>Gender</th>
		  <td><form:radiobutton path="gender" value="M" /> Male <form:radiobutton
					path="gender" value="F" style="margin-left:20px;" /> Female</td>
				<td><form:errors path="gender" cssClass="error" /></td>
	</tr>
	<tr>	
		  <th>ID card number</th><td>${patient.ssn}</td>
	</tr>
	<tr>	
		<th>Birthdate</th>
		  <td>
		<fieldset class="form-group">
			
				<div class="input-group date" id="datetimepicker1">
					<form:input path="birthdate" class="form-control" />
					<span class="input-group-addon"><span
						class="glyphicon-calendar glyphicon"></span></span>
				</div>
				<form:errors path="birthdate" cssClass="text-warning" />
			</fieldset>
			</td>
	</tr>
	<tr>	
		<th>Address</th>
		<td><fieldset class="form-group">
				<form:textarea path="address" type="text" class="form-control" required="required" style="height:80px;"/><br>
				<form:errors path="address" cssClass="text-warning" />
		</fieldset></td>
	</tr>
	<tr>	
		<th>Tel</th>
		<td><fieldset class="form-group">
				<form:input path="tel" type="text" class="form-control" required="required" style="height:40px;"/><br>
				<form:errors path="tel" cssClass="text-warning" />
		</fieldset></td>
	</tr>
	<tr>	
		<th>E-mail</th>
		<td><fieldset class="form-group">
				<form:input path="email" type="text" class="form-control" required="required" style="height:40px;"/><br>
				<form:errors path="email" cssClass="text-warning" />
		</fieldset></td>
	</tr>
	<tr>
	<th></th>
	<td><button class="btn btn-success">Confirm Edit Profile</button></td>
	</tr>
		</form:form>
</table>		
</div>       
</div>  
</div>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="webjars/momentjs/2.16.0/min/moment.min.js"></script>
	<script
		src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
	<script
		src="webjars/eonasdan-bootstrap-datetimepicker/4.17.43/build/js/bootstrap-datetimepicker.min.js"></script>
	<script>
	 $(function () {
		 $('#datetimepicker1').datetimepicker({
				format : 'YYYY-MM-DD',
				viewMode: 'years'

			});
     });
		
	
	</script>
</body>
</html>
