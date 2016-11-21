<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-pharmacist.jspf"%>

<div class="container-fluid">
<div class="container">
	<table class="table table-reflow">
	  <thead>
	    <tr>
	      <th>NO.</th>
	      <th>Prescription ID</th>
	   	  <th>Status</th>
	    </tr>
	  </thead>
	  <tbody>
		<c:set var="no"  value="0" scope="page"/>
		<c:forEach items="${prescripts}"  var="prescript">
		<c:set var="no"  value="${no + 1}" scope="page"/>
		<tr>
		   <td><c:out value="${no}"/></td>
		   <td><c:out value="${prescript.prescriptionId}"/></td>
		   <td><a href="/show-prescription-detail" class="btn btn-success"><c:out value="${prescript.status}"/></a></td>
		 </tr>
		</c:forEach>

	  </tbody>
	</table>
</div>
</div>

<%@ include file="common/footer.jspf"%>