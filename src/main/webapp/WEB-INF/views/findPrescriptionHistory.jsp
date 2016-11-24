<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-pharmacist.jspf"%>
	<h1></h1>
	<h3></h3>
	<div class="container">
		<div class="row" >
		<div class="col-md-3"></div>
		<div class="col-md-6">
		<form:form id="findPrescriptionHistoryForm" method="post" action="findPrescriptionHistoryForm" commandName="Prescription">
			<fieldset class="form-group">
				<form:label path="hospitalNumber"><h3>Enter Hospital Number</h3></form:label>
				<form:input path="hospitalNumber" type="int" class="form-control" required="required"/><br>
				<form:errors path="hospitalNumber" cssClass="text-warning" />
			</fieldset>
			<div class="background-align:right ">
			 <button type="submit" class="btn btn-success">Submit</button>
			</div>
		</form:form>
		</div>
		<div class="col-md-3"></div>
		</div>
		
		
	</div>
		
<%@ include file="common/footer.jspf"%>