<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-doctor.jspf"%>


<div class="container-fluid">

	<a href="/view-info" class="btn btn-success">Back to search</a>

	


	<div class="row">
		<div class="col-md-6">
			<table class="table table-reflow">
			<h2>Patient Personal Information</h2>
				<tr>
					<th>HospitalNumber</th>
					<td>${patientInfo.hospitalNumber}</td>
				</tr>

					<tr>
						<th>Name</th>
					<td>${patientInfo.name}</td>
					</tr>
					<tr>
						<th>Surname</th>
					<td>${patientInfo.surname}</td>
					</tr>
					<tr>
						<th>Gender</th>
						<c:if test="${patientInfo.gender=='M'}">
						<td>Male</td>
						</c:if>
						<c:if test="${patientInfo.gender=='F'}">
						<td>Female</td>
						</c:if>
					</tr>
					<tr>
						<th>ID card number</th>
						<td>${patientInfo.ssn}</td>
					</tr>
					<tr>
						<th>Birthdate</th>
						<td>${patientInfo.birthdate}</td>
					</tr>
					<tr>
						<th>Address</th>
						<td>${patientInfo.address}</td>
					</tr>
					<tr>
						<th>Tel</th>
						<td>${patientInfo.tel}</td>
					</tr>
					<tr>
						<th>E-mail</th>
						<td>${patientInfo.email}</td>
					</tr>
					
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
