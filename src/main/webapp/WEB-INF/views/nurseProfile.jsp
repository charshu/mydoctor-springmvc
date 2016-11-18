<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-nurse.jspf"%>

<div class="container-fluid">
<table class="table table-reflow">
  <thead>
    <tr>
      <th>Your profile</th>
      <th>username</th>
      <th>password</th>
   	<th>name</th>
   	<th>surname</th>

    </tr>
  </thead>
  <tbody>
    <tr>
    	<th></th>
      <td>${username}</td>
      <td>${patient.password}</td>
      <td>${patient.name}</td>
      <td>${patient.surname}</td>

         </tr>
  
  </tbody>
</table>
</div>

<%@ include file="common/footer.jspf"%>