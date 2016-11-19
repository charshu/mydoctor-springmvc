<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-doctor.jspf"%>

<div class="container-fluid">

	<h1>Prescription</h1>
	<table class="table">
		<thead>
			<tr>
				<th>Patient Name</th>
				<th>Doctor Name</th>
			</tr>
		</thead>
		<tr>
			<td>${patientName}</td>
			<td>${doctorName}</td>
		</tr>
	</table>

	<h1>Medicine list</h1>
	<table class="table">
		<thead>
			<tr>
				<th>Medicine ID</th>
				<th>Medicine Name</th>
				<th>Medicine Amount</th>
				<th>Medicine Instruction</th>
			</tr>
		</thead>
		<c:forEach items="${medicineBeans}" var="medicineBean">
			<tr>
				<td>${medicineBean.id}</td>
				<td>${medicineBean.name}</td>
				<td>${medicineBean.amount}</td>
				<td>${medicineBean.instruction}</td>
			</tr>
		</c:forEach>

	</table>

</div>
<a href="/add-medicine" class="btn btn-success">Add Medicine</a>



<%@ include file="common/footer.jspf"%>
