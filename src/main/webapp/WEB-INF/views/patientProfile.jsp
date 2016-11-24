<%@ include file="common/header.jspf"%>
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
     	<th>username</th><td>${username}</td>
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
		  <td><fieldset class="form-group">
				<form:input path="gender" type="text" class="form-control" required="required" style="height:40px;"/><br>
				<form:errors path="gender" cssClass="text-warning" />
		</fieldset></td>
	</tr>
	<tr>	
		  <th>SSN</th><td>${patient.ssn}</td>
	</tr>
	<tr>	
		<th>Birthdate</th>
		  <td><fieldset class="form-group">
				<form:input path="birthdate" type="text" class="form-control" required="required" style="height:40px;" /><br>
				<form:errors path="birthdate" cssClass="text-warning" />
		</fieldset></td>
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
				<form:textarea path="email" type="text" class="form-control" required="required" style="height:80px;" /><br>
				<form:errors path="email" cssClass="text-warning" />
		</fieldset></td>
	</tr>
	<tr>
		<th>HospitalNumber</th><td>${patient.hospitalNumber}</td>
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

<%@ include file="common/footer.jspf"%>