<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-doctor.jspf"%>

<div class="container-fluid">
<table class="table table-striped">
  <thead>
    <tr>
      <th>Your profile</th>
      <th>username</th>
   	<th>name</th>
   	<th>surname</th>
   	<th>department</th>
   	<th>tel</th>

    </tr>
  </thead>
  <tbody>
    <tr>
    	<th></th>
      <td>${username}</td>
      <td>${patient.name}</td>
      <td>${patient.surname}</td>
      <td>${patient.department}</td>
      <td>${patient.tel}</td>

    </tr>
  
  </tbody>
</table>
</div>

<%@ include file="common/footer.jspf"%>