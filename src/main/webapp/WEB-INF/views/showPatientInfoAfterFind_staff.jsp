<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-staff.jspf"%>


<div class="container-fluid">

	<a href="/view-info3" class="btn btn-success">Back to search</a>

	


	<div class="row">
		<div class="col-md-6">
			<h2>Patient Personal Information</h2>
			<table class="table table-reflow">
		
				<tr>
					<th>HospitalNumber</th>
					<td>${patientInfo.hospitalNumber}</td>
				</tr>

				<form:form id="edit-info" method="post" action="edit-info3"
					commandName="patientInfo" class="form-horizontal">

					<tr>
						<th>Name</th>
						<td><fieldset class="form-group">
								<form:input path="name" type="text" class="form-control"
									required="required" style="height:40px;" />
								<br>
								<form:errors path="name" cssClass="text-warning" />
							</fieldset></td>
					</tr>
					<tr>
						<th>Surname</th>
						<td><fieldset class="form-group">
								<form:input path="surname" type="text" class="form-control"
									required="required" style="height:40px;" />
								<br>
								<form:errors path="surname" cssClass="text-warning" />
							</fieldset></td>
					</tr>
					<tr>
						<th>Gender</th>
						<td><form:radiobutton path="gender" value="M" /> Male <form:radiobutton
								path="gender" value="F" style="margin-left:20px;" /> Female</td>
						<td><form:errors path="gender" cssClass="error" /></td>
					</tr>
					<tr>
						<th>ID card number</th>
						<td>${patientInfo.ssn}</td>
					</tr>
					<tr>
						<th>Birthdate</th>
						<td>
							<fieldset class="form-group">

								<div class="input-group date" id="datetimepicker1">
									<form:input path="birthdate" class="form-control" />
									<span class="input-group-addon"><span
										class="glyphicon-calendar glyphicon"></span></span>
								</div>
								<form:errors path="birthdate" cssClass="text-warning" />
							</fieldset>
						</td>
					</tr>
					<tr>
						<th>Address</th>
						<td><fieldset class="form-group">
								<form:textarea path="address" type="text" class="form-control"
									required="required" style="height:80px;" />
								<br>
								<form:errors path="address" cssClass="text-warning" />
							</fieldset></td>
					</tr>
					<tr>
						<th>Tel</th>
						<td><fieldset class="form-group">
								<form:input path="tel" type="text" class="form-control"
									required="required" style="height:40px;" />
								<br>
								<form:errors path="tel" cssClass="text-warning" />
							</fieldset></td>
					</tr>
					<tr>
						<th>E-mail</th>
						<td><fieldset class="form-group">
								<form:input path="email" type="text" class="form-control"
									required="required" style="height:40px;" />
								<br>
								<form:errors path="email" cssClass="text-warning" />
							</fieldset></td>
					</tr>

					<th></th>
					<td><button class="btn btn-success">Confirm Edit
							Profile</button></td>

				</form:form>
			</table>
		</div>


		<div class="col-md-5">
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
	</div>

</div>


<%@ include file="common/footer.jspf"%>
