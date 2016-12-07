<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-doctor.jspf"%>

<div class="container-fluid">
 <div class="alert alert-success">
  หมายเหตุ : เนื่องจากการเข้าสู่ขั้นตอนการตรวจผู้ป่วยสามารถทำได้เฉพาะในช่วงเวลาที่แพทย์อยู่ในเวลาออกตรวจจริงๆเท่านั้น และผู้ป่วยไม่สามารถกดจองนัดแพทย์ได้ภายในวันเดียวกัน ทำให้เกิดปัญหาไม่สามารถทดสอบระบบได้จนกว่าจะถึงเวลานัดแพทย์ซึ่งต้องใช้เวลานาน ผู้จัดทำจึงใส่ข้อมูลช่วงเวลาการออกตรวจเพื่อการทดสอบ ซึ่งจบวันที่ 31 มกราคม 2017 ไว้เพื่อประโยชน์ในการทดสอบระบบ (เฉพาะแพทย์สูติ-นรีเวชกรรม username:doctor1 password:doctor1)
  ผู้ทดสอบสามารถนัดหมายแพทย์ในช่วงเวลาดังกล่าวเพื่อทำการทดสอบระบบตรวจผู้ป่วย
</div>
 <c:if test="${msg=='done'}">
 <div class="alert alert-success">
  ${hn}'s diagnosis was successfully saved. A Prescription has been sent to pharmacist.
</div>
 </c:if>
 <c:if test="${msg=='err'}">
 <div class="alert alert-info">
  Fail to save ${hn}'s diagnosis.
</div>
 </c:if>
<h2>Current schedule</h2>
<table class="table">

<c:if test="${currentSchedule!=null}">
 <div class="alert alert-warning" style="text-align: center;">
  <h1><i class="fa fa-clock-o" aria-hidden="true"></i>${currentSchedule.printStart()}  ~  <i class="fa fa-clock-o" aria-hidden="true"></i>${currentSchedule.printEnd()}</h1>
</div>

 </c:if>
 <c:if test="${currentSchedule==null}">
 <div class="alert alert-info">
  You have no schedule now.
</div>

 </c:if>


</table>

<h2>Patients in schedule </h2>
<table class="table">
<c:if test="${appointments.size() > 0}">
<thead >
		<tr>
			<th>Appointment ID </th>
			<th>Appointment date </th>
			<th>Patient Name</th>
			<th>Patient Surname</th>
			<th>Patient Gender</th>
			<th>Hospital Number</th>
			<th>Symptom</th>
			<th></th>
		</tr>
	</thead>

<c:forEach items="${appointments}" var="appointment">
   <tr>
       <td>${appointment.id}</td>
       <td>${appointment.printDate()}</td>
       <td>${appointment.patientName}</td>
       <td>${appointment.patientSurname}</td>
       <td>${appointment.patientGender}</td>
       <td>${appointment.patientHospitalNumber}</td>
       <td>${appointment.symptom}</td>
       <c:if test="${appointment.status =='waiting'}"> <td><a href="/diagnose?appointmentId=${appointment.id}" class="btn btn-success">Diagnose</a></td></c:if>
       <c:if test="${appointment.status =='done'}"> <td><button class="btn btn-default" disabled="disabled">Done</button></td></c:if>
       
    </tr>
</c:forEach>
</c:if>
<c:if test="${appointments.size() == 0}">
 <div class="alert alert-info">
  There are no waiting patient now.
</div>
</c:if>

</table>

<h2>Your next appointments </h2>
<table class="table">
<c:if test="${appointmentInComings.size() > 0}">
<thead >
		<tr>
			<th>Appointment ID </th>
			<th>Appointment date </th>
			<th>Patient Name</th>
			<th>Patient Surname</th>
			<th>Patient Gender</th>
			<th>Hospital Number</th>
			<th>Symptom</th>
			<th></th>
		</tr>
	</thead>

<c:forEach items="${appointmentInComings}" var="appointmentInComing">
   <tr>
       <td>${appointmentInComing.id}</td>
       <td>${appointmentInComing.printDate()}</td>
       <td>${appointmentInComing.patientName}</td>
       <td>${appointmentInComing.patientSurname}</td>
       <td>${appointmentInComing.patientGender}</td>
       <td>${appointmentInComing.patientHospitalNumber}</td>
       <td>${appointmentInComing.symptom}</td>
       <td></td>
    </tr>
</c:forEach>
</c:if>
<c:if test="${appointmentInComings.size() == 0}">
 <div class="alert alert-info">
  There are no incoming appointments.
</div>
</c:if>

</table>

</div>

<%@ include file="common/footer.jspf"%>
