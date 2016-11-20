<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-pharmacist.jspf"%>

<div class="container-fluid">
<div class="container">
	<table class="table table-reflow">
	  <thead>
	    <tr>
	      <th>NO.</th>
	      <th>Prescription ID</th>
	      <th>Patients</th>
	   	  <th>Status</th>
	    </tr>
	  </thead>
	  <tbody>
		<c:set var="no"  value="0" scope="page"/>
		<c:forTokens items="${patient}" delims="," var="patient">
		<c:set var="no"  value="${no + 1}" scope="page"/>
		<tr>
		   <td><c:out value="${no}"/></td>
		   <td><c:out value="${prescription_id}"/></td>
		   <td><c:out value="${patient.name}"/></td>
		   <td></td>
		   <td></td>
		 </tr>
		</c:forTokens>

	  </tbody>
	</table>
</div>
</div>

<%@ include file="common/footer.jspf"%>