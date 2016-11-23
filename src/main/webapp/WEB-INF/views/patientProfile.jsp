<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-patient.jspf"%>

<div class="container-fluid">
<h2>Your profile</h2>
<table class="table table-reflow">

  <thead>
    <tr>
      <th>username</th>
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
     <td>${username}</td>
     <form:form id="edit-info" method="post" action="edit-info" commandName="new_patient" class="form-horizontal"> 
    
       	
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
		
		  <td>${patient.ssn}</td>
		
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
		<td>${patient.hospitalNumber}</td>
		<button class="btn btn-success">Confirm Edit Profile</button>
		</form:form>
     </tr>
  
  
  </tbody>
</table>
</div>

<%@ include file="common/footer.jspf"%>