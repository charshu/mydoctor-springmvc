<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-doctor.jspf"%>

<div class="container-fluid">


		<form:form id="view-info" method="post" action="view-info" commandName="viewInfo">
			<fieldset class="form-group">
				<form:label path="hospitalNumber">Enter Patient Hospital Number (8 digits)</form:label>
				<form:input path="hospitalNumber" type="text" class="form-control" required="required"/><br>
				<form:errors path="hospitalNumber" cssClass="text-warning" />
			 <button type="submit" class="btn btn-success">Submit</button>
			</fieldset>		
		</form:form>
		

</div>



<%@ include file="common/footer.jspf"%>
