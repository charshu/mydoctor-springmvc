<%@ include file="common/header.jspf"%>

<%@ include file="common/navigation-pharmacist.jspf"%>
<div class="container-fluid">

	
<div class="container">
	
		<table class="table ">
		  <thead style="background:#FBB917 !important">
		    <tr style="color:white">
		      <th>NO.</th>
		      <th>Patient Name</th>
		   	  <th>Status</th>
		    </tr>
		  </thead>
		  <tbody>
			<c:set var="no"  value="0" scope="page"/>
			<c:forEach items="${prescripts}"  var="prescript">
			<c:set var="no"  value="${no + 1}" scope="page"/>
			<tr>
			   <td><c:out value="${no}"/></td>
			   <td><c:out value="${prescript.patientName}"/> <c:out value="${prescript.patientSurname}"/></td>
			   <td><a href="/detail?prescription_id=${prescript.prescriptionId}" class="btn btn-danger"><c:out value="Waiting"/></a></td>
			 </tr>
			</c:forEach>
	
		  </tbody>
		</table>
	
</div>
</div>

<%@ include file="common/footer.jspf"%>