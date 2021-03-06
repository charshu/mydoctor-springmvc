<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-nurse.jspf"%>


<div class="container">

		<c:if test="${msg =='success'}">
		<div class="alert alert-success">Data have been saved.</div>
		</c:if>
		<c:if test="${msg =='fail'}">
		<div class="alert alert-danger">Failed to save</div>
		</c:if>
		<form:form id="add-info" method="post" action="add-info" commandName="generalInfo" class="form-horizontal">
			<fieldset class="form-group row">
				<form:label path="hospitalNumber" class="col-sm-4 control-label" >Patient Hospital Number </form:label>
				<div class="col-sm-14">
				<form:input path="hospitalNumber" type="text" required="required" placeholder="Patient hospital number"/><br>
				<form:errors path="hospitalNumber" cssClass="text-warning" />
				</div>
			</fieldset>
			
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
				<form:input path="height" type="int" required="required" placeholder=" please fill in m"/> cm<br>
				<form:errors path="height" cssClass="text-warning" />
				</div>
			</fieldset>
			
			<fieldset class="form-group row">
				<form:label path="heart_rate" class="col-sm-4 control-label" >Heart Rate</form:label>
				<div class="col-sm-14">
				<form:input path="heart_rate" type="int" required="required" placeholder=" please fill in mmHg"/> bpm<br>
				<form:errors path="heart_rate" cssClass="text-warning" />
				</div>
			</fieldset>
			
			<fieldset class="form-group row">
				<form:label path="pressureH"  class="col-sm-4 control-label" >Systolic Pressure</form:label>
				<div class="col-sm-14">
				<form:input path="pressureH" type="int"  required="required" placeholder=" please fill in mmHg"/> mmHg<br>
				<form:errors path="pressureH" cssClass="text-warning" />
				</div>
			</fieldset>
			
			<fieldset class="form-group row">
				<form:label path="pressureL"  class="col-sm-4 control-label" >Diastolic Pressure</form:label>
				<div class="col-sm-14">
				<form:input path="pressureL" type="int" class="form" required="required" placeholder=" please fill in mmHg"/> mmHg<br>
				<form:errors path="pressureL" cssClass="text-warning" />
				</div>
			</fieldset>
			
			<fieldset class="form-group row">
				<form:label path="congemital"  class="col-sm-4 control-label" >Congemital</form:label>
				<div class="col-sm-14">
				<form:textarea path="congemital" type="text" rows="5" cols="40"  placeholder=" fill if needed"/><br>
				<form:errors path="congemital" cssClass="text-warning" />
				</div>
			</fieldset>
			
			<fieldset class="form-group row">
				<form:label path="med_allergy"  class="col-sm-4 control-label" >Medicine Allergy</form:label>
				<div class="col-sm-14">
				<form:textarea path="med_allergy" type="text" rows="5" cols="40"  placeholder=" fill if needed"/><br>
				<form:errors path="med_allergy" cssClass="text-warning" />
				</div>
			</fieldset>
			
			<fieldset class="form-group row">
				<form:label path="symptom"  class="col-sm-4 control-label" >Basic Symptoms</form:label>
				<div class="col-sm-14">
				<form:textarea path="symptom" type="text" rows="5" cols="40"  placeholder=" fill if needed"/><br>
				<form:errors path="symptom" cssClass="text-warning" />
				</div>
			</fieldset>
			    <div class="col-sm-offset-5 col-sm-2 text-center">
					<button type="submit" class="btn btn-success" >Submit</button>		
				</div>
		</form:form>
		
</div>




<%@ include file="common/footer.jspf"%>
