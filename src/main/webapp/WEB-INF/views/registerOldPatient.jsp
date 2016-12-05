<%@ include file="common/header.jspf"%>
<nav role="navigation" class="navbar navbar-default">

    <div class="">
        <a href="/" class="navbar-brand">MyHospital    <i class="fa fa-hospital-o" aria-hidden="true"></i></a>
    </div>
   </nav>
   
  <div class="container-fluid">
<div class="text-center">
					<h2>Old Patient Registration</h2><br>		
				</div>	
 <div class="col-sm-4 col-md-offset-4">
  			
	<form:form id="register-patient-old" method="post" action="register-old" commandName="patient" class="form-horizontal"> 
		  
 		  <br><h4> Please Fill at least one in SSN or Hostpital Number </h4> 
		  
		 <fieldset class="form-group inline">
		  <br>
		  <div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">SSN</span>
			<form:input path="ssn" type="text" class="form-control" placeholder="SSN" aria-describedby="basic-addon1" /><br>
			<form:errors path="ssn" cssClass="text-warning" />
		  </div>
		  </fieldset>
		  
		  
		    <fieldset class="form-group inline">
		  <div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">Hospital Number</span>
			<form:input path="hospitalNumber" type="text" class="form-control" placeholder="Hospital Number" aria-describedby="basic-addon1" /><br>
		  </div>
		  </fieldset>
		  <div class="text-center">
		<br><h4> Set Username and Password </h4> 
		  </div>
 		
 		<fieldset class="form-group inline">
 		<br>
		  <div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">Username</span>
			<form:input path="username1" type="text" class="form-control" placeholder="Set Username" aria-describedby="basic-addon1" required="required" /><br>
			<form:errors path="username1" cssClass="text-warning" />
		  </div>
		  </fieldset>
		  
		  <fieldset class="form-group inline">
		  <div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">Password</span>
			<form:password path="password1"  class="form-control" placeholder="Set Password" aria-describedby="basic-addon1" /><br>
			<form:errors path="password1" cssClass="text-warning" />
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
  
  
  <%@ include file="common/footer.jspf"%>