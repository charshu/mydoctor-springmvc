<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-doctor.jspf"%>

<div class="container-fluid">

<table class="table">
<thead>
		<tr>
			<th>Hospital Number</th>
			<th>PrescriptionID </th>
			<th>Instruction</th>
			<th>Medicine</th>
			<th>Quantity</th>
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

</table>
</div>



<%@ include file="common/footer.jspf"%>
