<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-doctor.jspf"%>

<div class="container">
<div class="container-fluid">

	<h1> <i class="fa fa-file-text-o fa-2x" aria-hidden="true"></i> Prescription</h1>
	<table class="table">
		<thead  style="background:#008181 !important">
			<tr>
				<th> <i class="fa fa-male  fa-2x" aria-hidden="true"></i> Patient Name </th>
				<th> <i class="fa fa-user-md fa-2x" aria-hidden="true"></i> Doctor Name </th>
			</tr>
		</thead>
		<tr>
			<td>${patientName}</td>
			<td>${doctorName}</td>
		</tr>
	</table>
</div>
<div class="container-fluid">
	<h1> <i class="fa fa-medkit fa-2x" aria-hidden="true"></i> Medicine list</h1>
	<table class="table">
		<thead  style="background:#008181!important">
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

<div class="row pad pull-right">
  <div class="col-xs-3 ">
    <a href="/add-medicine" class="btn btn-success pull-right">Add Medicine</a>
  </div>
  
  <div class="col-xs-3 ">
    <a href="/save-prescription" type="submit" class="btn btn-success ">Submit</a>
  </div>
</div>

</div>

<%@ include file="common/footer.jspf"%>
