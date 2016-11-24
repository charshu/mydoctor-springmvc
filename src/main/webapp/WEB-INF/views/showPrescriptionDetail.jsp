<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-pharmacist.jspf"%>

<div class="container-fluid">
<div class="container">
	<table class="table table-hover">
	  <thead style="background:#F75D59">
	    <tr>
	      <th>Medicines List</th>
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
	<a href="/complete-prescription?prescription_id=${prescription_id}" class="btn btn-success">Complete</a>
</div>
</div>

<%@ include file="common/footer.jspf"%>