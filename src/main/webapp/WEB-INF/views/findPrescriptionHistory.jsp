<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-pharmacist.jspf"%>

	<div class="container">
		<form:form id="findPrescriptionHistoryForm" method="post" action="findPrescriptionHistoryForm" commandName="Prescription">
			<fieldset class="form-group">
			
				<form:label path="userid">EnterUserID</form:label>
				<form:input path="userid" type="int" class="form-control" required="required"/><br>
				<form:errors path="userid" cssClass="text-warning" />
				</fieldset>
				
			
			 <button type="submit" class="btn btn-success">Submit</button>
		</form:form>
	</div>
		
<%@ include file="common/footer.jspf"%>