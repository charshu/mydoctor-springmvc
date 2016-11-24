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
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-6">
	
		<h2>Add new schedule</h2>
		<form:form id="scheduleForm" method="post" action="add-schedule"
			commandName="schedule" >
			<fieldset class="form-group">
				<form:label path="start">Start Date</form:label>
				<div class="input-group date" id="datetimepicker1">
				
					<form:input path="start" type="text" class="form-control" />
					<span class="input-group-addon"><span
						class="glyphicon-calendar glyphicon"></span></span>
				</div>
				<form:errors path="start" cssClass="text-warning" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="end" class="control-label">End Date</form:label>
				<div class="input-group date" id="datetimepicker2">
					<form:input path="end" type="text" class="form-control" />
					<span class="input-group-addon"><span
						class="glyphicon-calendar glyphicon"></span></span>
				</div>
				<form:errors path="end" cssClass="text-warning" />
			</fieldset>
			<button type="submit" class="btn btn-success">Submit</button>

		</form:form>
	</div>
</div>
<div class="col-md-3"></div>
</div>

	

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="webjars/momentjs/2.16.0/min/moment.min.js"></script>
	<script
		src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
	<script
		src="webjars/eonasdan-bootstrap-datetimepicker/4.17.43/build/js/bootstrap-datetimepicker.min.js"></script>
	<script>
		$('#datetimepicker1').datetimepicker({
			format : 'ddd DD-MM-YYYY HH:mm',
			sideBySide : true,
			stepping : 10,
			maxDate : moment().add(5, 'day'),
			minDate : moment()

		});
		$('#datetimepicker2').datetimepicker({
			format : 'ddd DD-MM-YYYY HH:mm',
			sideBySide : true,
			stepping : 10,
			maxDate : moment().add(5, 'day'),
			minDate : moment()
		});
	</script>
</body>
</html>
