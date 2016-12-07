<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-pharmacist.jspf"%>

<div class="container-fluid">

<table class="table">
<c:if test="${prescriptionHistorys.size() > 0}">
<thead>
		<tr>
			<th>ID </th>
			<th>PrescriptionID </th>
			<th>Instruction</th>
			<th>Medicine</th>
			<th>Dose</th>
		</tr>
	</thead>
	
<c:forEach items="${prescriptionHistorys}" var="prescriptionHistory">
   <tr>
       <td>${prescriptionHistory.userid}</td>
       <td>${prescriptionHistory.prescriptionId}</td>
       <td>${prescriptionHistory.instruction}</td>
       <td>${prescriptionHistory.medicinename}</td>
       <td>${prescriptionHistory.amount}</td>
    </tr>
</c:forEach>
</c:if>
<c:if test="${prescriptionHistorys.size() == 0}">
 <div class="alert alert-info">
  No prescription found.
</div>
</c:if>
</table>
</div>



<%@ include file="common/footer.jspf"%>
