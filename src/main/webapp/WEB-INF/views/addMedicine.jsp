<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-doctor.jspf"%>

<div class="container fluid">
   <h1>Add Medicine</h1>
<form:form id="addMedicineForm" method="post" action="add-medicine"
			commandName="medicineBean" >
			<fieldset class="form-group">
				<form:label path="id">Medicine ID or Medicine Name</form:label>
				<form:input path="id" type="text" class="form-control" />	
				<form:errors path="id" cssClass="text-warning" />
			</fieldset>
			
			<fieldset class="form-group">
				<form:label path="amount" class="control-label">Amount</form:label>
				<form:input path="amount" type="text" class="form-control" />
				<form:errors path="amount" cssClass="text-warning" />
			</fieldset>
			
			<fieldset class="form-group">
				<form:label path="instruction" class="control-label">Instruction</form:label>
				<form:textarea path="instruction" type="text" class="form-control" />
				<form:errors path="instruction" cssClass="text-warning" />
			</fieldset>
			
			
			
			<button type="submit" class="btn btn-success">Submit</button>

		</form:form>
</div>

<%@ include file="common/footer.jspf"%>
