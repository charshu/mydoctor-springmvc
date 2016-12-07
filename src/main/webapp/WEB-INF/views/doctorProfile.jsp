<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-doctor.jspf"%>

<div class="container-fluid">

<div class = "well">
 		<h3>Profile</h3>
</div>

<div class="row">
	<div class="col-md-3"></div>
	<div class="col-md-6">
	<table class="table ">
	  
	<tr>
      <th>Name</th><td>${doctor.name}</td>
    </tr>
    <tr>
      <th>Surname</th><td>${doctor.surname}</td>
    </tr>
    <tr>
      <th>Department</th><td>${doctor.department}</td>
    </tr>
    <tr>
      <th>Tel</th><td>${doctor.tel}</td>
    </tr>
	  
	</table>
	</div>
	<div class="col-md-3"></div>
	</div>

</div>

<%@ include file="common/footer.jspf"%>