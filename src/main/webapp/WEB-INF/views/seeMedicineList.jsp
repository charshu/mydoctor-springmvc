<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-doctor.jspf"%>

<style>
	th,td{
	text-align: center;}
	
</style>

<div style="text-align:center; margin:10px" class="container-fluid">
<h2>Medicine List</h2>
<div class="container">
<table class="table">
<thead>
		<tr>
			<th>Medicine ID </th>
			<th>Medicine Name </th>
		</tr>
	</thead>
<c:forEach items="${medicineBean}" var="medicineBean">
   <tr>
       <td>${medicineBean.id}</td>
       <td>${medicineBean.name}</td>
    </tr>
</c:forEach>

</table>
<a href="/add-medicine" class="btn btn-success pull right">Back</a>
</div>



</div>

<%@ include file="common/footer.jspf"%>
