<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-nurse.jspf"%>


<div class="container">
		<form:form id="add-info" method="post" action="add-info" commandName="generalInfo" class="form-horizontal">
			<fieldset class="form-group row">
				<form:label path="weight" class="col-sm-4 control-label" >Weight</form:label>
				<div class="col-sm-14">
				<form:input path="weight" type="double" required="required" placeholder=" please fill in kg"/> kg<br>
				<form:errors path="weight" cssClass="text-warning" />
				</div>
			</fieldset>
			
			<fieldset class="form-group row">
				<form:label path="height"  class="col-sm-4 control-label" >Height</form:label>
				<div class="col-sm-14">
				<form:input path="height" type="double" required="required" placeholder=" please fill in m"/> m<br>
				<form:errors path="height" cssClass="text-warning" />
				</div>
			</fieldset>
			
			<fieldset class="form-group row">
				<form:label path="pressureH"  class="col-sm-4 control-label" >Systolic Pressure</form:label>
				<div class="col-sm-14">
				<form:input path="height" type="int"  required="required" placeholder=" please fill in mmHg"/> mmHg<br>
				<form:errors path="height" cssClass="text-warning" />
				</div>
			</fieldset>
			
			<fieldset class="form-group row">
				<form:label path="pressureL"  class="col-sm-4 control-label" >Diastolic Pressure</form:label>
				<div class="col-sm-14">
				<form:input path="height" type="int" class="form" required="required" placeholder=" please fill in mmHg"/> mmHg<br>
				<form:errors path="height" cssClass="text-warning" />
				</div>
			</fieldset>
			
			<fieldset class="form-group">
				<form:label path="congemital"  class="col-sm-4 control-label" >Congemital</form:label>
				<div class="col-sm-14">
				<form:input path="congemital" type="text" style="height:120px"  placeholder=" fill if needed"/><br>
				<form:errors path="congemital" cssClass="text-warning" />
				</div>
			</fieldset>
			
			<fieldset class="form-group">
				<form:label path="med_allergy"  class="col-sm-4 control-label" >Medicine Allergy</form:label>
				<div class="col-sm-14">
				<form:input path="med_allergy" type="text" style="height:120px"  placeholder=" fill if needed"/><br>
				<form:errors path="med_allergy" cssClass="text-warning" />
				</div>
			</fieldset>
			
			<fieldset class="form-group">
				<form:label path="symptom"  class="col-sm-4 control-label" >Basic Symptoms</form:label>
				<div class="col-sm-14">
				<form:input path="symptom" type="text" style="height:120px"  placeholder=" fill if needed"/><br>
				<form:errors path="symptom" cssClass="text-warning" />
				</div>
			</fieldset>
			
				 	
		</form:form>
		
</div>




<%@ include file="common/footer.jspf"%>
