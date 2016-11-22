<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>MyDoctor Application</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="webjars/eonasdan-bootstrap-datetimepicker/4.17.43/build/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">

</head>

<body>
	<%@ include file="common/navigation-doctor.jspf"%>

	<div class="container">
		<h2>New diagnosis</h2>
		<form:form id="diagnosisForm" method="post" action="diagnose"
			commandName="diagnosis" >
			<fieldset class="form-group">
				<form:label path="symptom">Symptom</form:label>
				<form:textarea path="symptom" type="text" class="form-control" />
				<form:errors path="symptom" cssClass="text-warning" />
			</fieldset>
		
			<fieldset class="form-group">
				<form:label path="disease_id" class="control-label">Disease Code</form:label>
				<form:input path="disease_id" type="text" class="form-control" />
				<form:errors path="disease_id" cssClass="text-warning" />
			</fieldset>
			<button type="submit" class="btn btn-success">Submit</button>

		</form:form>
	</div>



	

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="webjars/momentjs/2.16.0/min/moment.min.js"></script>
	<script
		src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
	<script
		src="webjars/eonasdan-bootstrap-datetimepicker/4.17.43/build/js/bootstrap-datetimepicker.min.js"></script>

</body>
</html>
