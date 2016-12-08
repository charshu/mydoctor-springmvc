<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
<title>MyHospital Application</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="webjars/eonasdan-bootstrap-datetimepicker/4.17.43/build/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<link href="webjars/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>

<body>
	<%@ include file="common/navigation-doctor.jspf"%>

	<div class="container">
		<h2>New diagnosis <i class="fa fa-stethoscope" aria-hidden="true"></i></h2>
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
				<a href="http://apps.who.int/classifications/icd10/browse/2010/en#/IV" target="_blank">ICD-10 reference</a>
				<form:errors path="disease_id" cssClass="text-warning" />
			</fieldset>
			<button type="submit" class="btn btn-success">Submit</button>

		</form:form>
<h2>Patient General Information</h2>
			<table class="table table-condensed">
				<c:if test="${generalInfo.hospitalNumber!=null}">
					<tr>
						<th>Hospital Number</th>
						<td>${generalInfo.hospitalNumber}</td>
					</tr>
					<tr>
						<th>Weight (kg)</th>
						<td>${generalInfo.weight}</td>
					</tr>
					<tr>
						<th>Height (m)</th>
						<td>${generalInfo.height}</td>
					</tr>
					<tr>
						<th>Heart Rate (bpm)</th>
						<td>${generalInfo.heart_rate}</td>
					</tr>
					<tr>
						<th>Systolic Blood Pressure (mmHg)</th>
						<td>${generalInfo.pressureH}</td>
					</tr>
					<tr>
						<th>Diastolic Blood Pressure (mmHg)</th>
						<td>${generalInfo.pressureL}</td>
					</tr>
					<tr>
						<th>Congemital</th>
						<td>${generalInfo.congemital}</td>
					</tr>
					<tr>
						<th>Med Allergy</th>
						<td>${generalInfo.med_allergy}</td>
					</tr>
					<tr>
						<th>Symptom</th>
						<td>${generalInfo.symptom}</td>
					</tr>

					<tr>
						<th>Record Date</th>
						<td>${generalInfo.date}</td>
					</tr>
				</c:if>
				<c:if test="${generalInfo.hospitalNumber==null}">
					<div class="alert alert-danger">Patient has no general
						information.</div>
				</c:if>
			</table>
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
