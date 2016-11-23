<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-doctor.jspf"%>

<div class="container-fluid">
<h2>Profile</h2>
<table class="table table-reflow">
  <thead>
    <tr>
   	<th>Name</th>
   	<th>Surname</th>
   	<th>Department</th>
   	<th>Tel</th>

    </tr>
  </thead>
  <tbody>
    <tr>
      <td>${doctor.name}</td>
      <td>${doctor.surname}</td>
      <td>${doctor.department}</td>
      <td>${doctor.tel}</td>

    </tr>
  
  </tbody>
</table>
</div>

<%@ include file="common/footer.jspf"%>