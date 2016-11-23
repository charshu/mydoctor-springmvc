<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-pharmacist.jspf"%>

<div class="container-fluid">
<div class="container">
	<table class="table table-reflow">
	  <thead>
	    <tr>
	      <th>Prescription ID</th>
	      <th>amount</th>
	      <th>Instruction</th>
	    </tr>
	  </thead>
	  <tbody>
		<c:forEach items="${medicines}"  var="medicine">
		<tr>
		   <td><c:out value="${medicine.medicine}"/></td>
		   <td><c:out value="${medicine.amount}"/></td>
		   <td><c:out value="${medicine.instruction}"/></td>
		</tr>
		</c:forEach>		

	  </tbody>
	</table>
	<a href="/complete-prescription?prescript_id=${prescript_id}" class="btn btn-success">Complete</a>
</div>
</div>

<%@ include file="common/footer.jspf"%>