<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-doctor.jspf"%>

<div class="container fluid">
   <h1>Add Medicine</h1>
<form:form id="addMedicineForm" method="post" action="add-medicine"
			commandName="medicineBean" >
			<fieldset class="form-group">
				<form:label path="id" class="control-label">Medicine ID</form:label>
				<form:input path="id" type="text" class="form-control" />
				<form:errors path="id" cssClass="text-warning" />
			</fieldset>
			
			<fieldset class="form-group">
				<form:label path="name" class="control-label">Medicine Name</form:label>
				<form:input path="name" type="text" class="form-control" />
				<form:errors path="name" cssClass="text-warning" />
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
			
			
			<div class="row pad pull-right">
				  <div class="col-xs-3 ">
				    <a href="/see-medicine-list" class="btn btn-success pull-right">See Medicine List</a>
				  </div>
				  
				  <div class="col-xs-3 ">
				    <button type="submit" class="btn btn-success">Submit</button>
				  </div>
			</div>
			

		</form:form>
</div>

<%@ include file="common/footer.jspf"%>