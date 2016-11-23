<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-staff.jspf"%>


<div class="container-fluid">

<a href="/view-info3" class="btn btn-success">Back to search</a>

<h2>Patient Personal Information</h2>

<table class="table table-reflow">

  <thead>
    <tr>
   	<th>name</th>
   	<th>surname</th>
   	<th>gender</th>
   	<th>ssn</th>
   	<th>birthdate</th>
   	<th>address</th>
   	<th>tel</th>
   	<th>email</th>
   	<th>HospitalNumber</th>
    </tr>
  </thead>
  <tbody>
     <tr>
     <form:form id="edit-info3" method="post" action="edit-info3" commandName="patientInfo" class="form-horizontal">  	
       <td><fieldset class="form-group">
				<form:input path="name" type="text" class="form-control"  required="required" style="height:40px;"/><br>
				<form:errors path="name" cssClass="text-warning" />
		</fieldset></td>
		
		  <td><fieldset class="form-group">
				<form:input path="surname" type="text" class="form-control" required="required" style="height:40px;"/><br>
				<form:errors path="surname" cssClass="text-warning" />
		</fieldset></td>
		
		  <td><fieldset class="form-group">
				<form:input path="gender" type="text" class="form-control" required="required" style="height:40px;"/><br>
				<form:errors path="gender" cssClass="text-warning" />
		</fieldset></td>
		
		  <td>${patientInfo.ssn}</td>
		
		  <td><fieldset class="form-group">
				<form:input path="birthdate" type="text" class="form-control" required="required" style="height:40px;" /><br>
				<form:errors path="birthdate" cssClass="text-warning" />
		</fieldset></td>
		
		<td><fieldset class="form-group">
				<form:textarea path="address" type="text" class="form-control" required="required" style="height:80px;"/><br>
				<form:errors path="address" cssClass="text-warning" />
		</fieldset></td>
		
		<td><fieldset class="form-group">
				<form:input path="tel" type="text" class="form-control" required="required" style="height:40px;"/><br>
				<form:errors path="tel" cssClass="text-warning" />
		</fieldset></td>
		
		<td><fieldset class="form-group">
				<form:textarea path="email" type="text" class="form-control" required="required" style="height:80px;" /><br>
				<form:errors path="email" cssClass="text-warning" />
		</fieldset></td>
		<td>${patientInfo.hospitalNumber}</td>
		<button class="btn btn-success">Confirm Edit Profile</button>
		</form:form>
     </tr>
  
  
  </tbody>
</table>



  
</div>


<%@ include file="common/footer.jspf"%>
