<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-doctor.jspf"%>


<div class="container-fluid">
  <h2>Patient General Information</h2>

<table class="table table-condensed">
<thead>
		<tr>
			<th>Hospital Number </th>
			<th>Weight (kg) </th>
			<th>Height (m)</th>
			<th>Heart Rate (bpm)</th>
			<th>Systolic Blood Pressure (mmHg)</th>
			<th>Diastolic Blood Pressure (mmHg)</th>
			<th>Congemital</th>
			<th>Med Allergy</th>
			<th>Symptom</th>
			<th>Record Date</th>
		</tr>
	</thead>
   <tr>
       	<td>${generalInfo.hospitalNumber}</td>
       	<td>${generalInfo.weight}</td>
       	<td>${generalInfo.height}</td>
       	<td>${generalInfo.heart_rate}</td>
       	<td>${generalInfo.pressureH}</td>
       	<td>${generalInfo.pressureL}</td>
       	<td>${generalInfo.congemital}</td>
       	<td>${generalInfo.med_allergy}</td>
       	<td>${generalInfo.symptom}</td>
       	<td>${generalInfo.date}</td>
    </tr>

</table>
<a href="/view-info" class="btn btn-success">Back to search</a>
</div>


<%@ include file="common/footer.jspf"%>
