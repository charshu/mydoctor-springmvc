<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-staff.jspf"%>

<div class="container-fluid">
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-6">

		<form:form id="view-info3" method="post" action="view-info3" commandName="viewInfo">
			<fieldset class="form-group">
				<form:label path="hospitalNumber">Enter Patient Hospital Number (8 digits)</form:label>
				<form:input path="hospitalNumber" type="text" class="form-control" required="required"/><br>
				<form:errors path="hospitalNumber" cssClass="text-warning" />
			 <button type="submit" class="btn btn-success">Submit</button>
			</fieldset>		
		</form:form>
</div>
<div class="col-md-3"></div>	
</div>		

</div>



<%@ include file="common/footer.jspf"%>
