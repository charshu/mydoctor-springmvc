<%@ include file="common/header.jspf"%>

<%@ include file="common/navigation-doctor.jspf"%>

	<div class="container">
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-6">
		<form:form id="DcotorFindPrescriptionHistoryForm" method="post" action="DoctorFindPrescriptionHistoryForm" commandName="Prescription">
			<fieldset class="form-group">
			
				<form:label path="userid">EnterUserID</form:label>
				<form:input path="userid" type="int" class="form-control" required="required"/><br>
				<form:errors path="userid" cssClass="text-warning" />
				</fieldset>
				
			
			 <button type="submit" class="btn btn-success">Submit</button>
		</form:form>
</div>
<div class="col-md-3"></div>
</div>
	</div>
		
<%@ include file="common/footer.jspf"%>