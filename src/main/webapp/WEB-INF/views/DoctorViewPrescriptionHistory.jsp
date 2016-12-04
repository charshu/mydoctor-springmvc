<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-doctor.jspf"%>

<div class="container-fluid">

<table class="table">
<c:if test="${prescriptionHistory.hospitalNumber!=null}">
<thead>
		<tr>
			<th>Hospital Number</th>
			<th>PrescriptionID </th>
			<th>Instruction</th>
			<th>Medicine</th>
			<th>Dose</th>
		</tr>
	</thead>
	
<c:forEach items="${prescriptionHistorys}" var="prescriptionHistory">
   <tr>
       <td>${prescriptionHistory.hospitalNumber}</td>
       <td>${prescriptionHistory.prescriptionId}</td>
       <td>${prescriptionHistory.instruction}</td>
       <td>${prescriptionHistory.medicinename}</td>
       <td>${prescriptionHistory.amount}</td>
    </tr>
</c:forEach>
</c:if>
<c:if test="${prescriptionHistory.hospitalNumber==null}">
 <div class="alert alert-danger">
  Patient has no prescription histories.
</div>
</c:if>
</table>
</div>



<%@ include file="common/footer.jspf"%>
