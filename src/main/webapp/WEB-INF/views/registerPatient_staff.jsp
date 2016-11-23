<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-staff.jspf"%>

<div class="container-fluid">
<div class="text-center">
					<h2>Register Patient By Staff</h2><br>	
				</div>	
 <div class="col-sm-4 col-md-offset-4">
  			
	<form:form id="register-patient" method="post" action="register-patient" commandName="patient" class="form-horizontal">
		
		   <fieldset class="form-group inline">
		  <div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">SSN</span>
			<form:input path="ssn" type="text" class="form-control" placeholder="SSN" aria-describedby="basic-addon1" /><br>
			<form:errors path="ssn" cssClass="text-warning" />
		  </div>
		  </fieldset>
		  
		  <fieldset class="form-group inline">
		  <div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">Name</span>
			<form:input path="name" type="text" class="form-control" placeholder="Name" aria-describedby="basic-addon1" /><br>
			<form:errors path="name" cssClass="text-warning" />
		  </div>
		  </fieldset>
		  
		  <fieldset class="form-group inline">
		  <div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">Surname</span>
			<form:input path="surname" type="text" class="form-control" placeholder="Surname" aria-describedby="basic-addon1" /><br>
			<form:errors path="surname" cssClass="text-warning" />
		  </div>
		  </fieldset>
		  
		   <fieldset class="form-group inline">
		  <div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">Gender</span>
			<form:input path="gender" type="text" class="form-control" placeholder="Gender" aria-describedby="basic-addon1" /><br>
			<form:errors path="gender" cssClass="text-warning" />
		  </div>
		  </fieldset>
		  
		  	<fieldset class="form-group inline">
				<form:label path="birthdate">Birth Date</form:label>
				<div class="input-group date" id="datetimepicker1">
					<form:input path="birthdate" type="text" class="form-control" />
					<span class="input-group-addon"><span
						class="glyphicon-calendar glyphicon"></span></span>
				</div>
				<form:errors path="birthdate" cssClass="text-warning" />
			</fieldset>
		  	  
		  <fieldset class="form-group inline">
		  <div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">Address</span>
			<form:input path="address" type="text" class="form-control" placeholder="Address" aria-describedby="basic-addon1" /><br>
			<form:errors path="address" cssClass="text-warning" />
		  </div>
		  </fieldset>
		  
		   <fieldset class="form-group inline">
		  <div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">Telephone Number</span>
			<form:input path="tel" type="text" class="form-control" placeholder="Tel." aria-describedby="basic-addon1" /><br>
			<form:errors path="tel" cssClass="text-warning" />
		  </div>
		  </fieldset>
		  
		    <fieldset class="form-group inline">
		  <div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">Email</span>
			<form:input path="email" type="text" class="form-control" placeholder="Email" aria-describedby="basic-addon1" /><br>
		  </div>
		  </fieldset>
		  
		   <div class="col-sm-offset-5 col-sm-2 text-center">
					<button type="submit" class="btn btn-success" >Submit</button>		
				</div>	
		  
	</form:form>
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
		$('#datetimepicker1').datetimepicker({
			format : 'YYYY-MM-DD'
		});
		
	</script>
</body>
</html>
<%@ include file="common/footer.jspf"%>
