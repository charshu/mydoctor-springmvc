<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-staff.jspf"%>


<div class="container">
 <c:if test="${msg=='nursedone'}">
 <div class="alert alert-success">
 	Nurse is added.
</div>
 </c:if>
  <c:if test="${msg=='doctordone'}">
 <div class="alert alert-success">
 	Doctor is added.
</div>
 </c:if>
  <c:if test="${msg=='staffdone'}">
 <div class="alert alert-success">
 	Staff is added.
</div>
 </c:if>
  <c:if test="${msg=='pharmacistdone'}">
 <div class="alert alert-success">
 	Pharmacist is added.
</div>
 </c:if>
 <c:if test="${msg=='err'}">
 <div class="alert alert-danger">
  Fail to add.
</div>
 </c:if>
 
	<div class="col-sm-4 col-md-offset-5"> <br>
			 <a href="/add-nurse" type="submit" class="btn btn-primary col-xs-7" > <i class="fa fa-user-plus" aria-hidden="true"></i>
			  Nurse</a><br>	
	</div>


	<div class="col-sm-4 col-md-offset-5"> <br>
			 <a href="/add-doctor" type="submit" class="btn btn-primary col-xs-7"><i class="fa fa-user-plus" aria-hidden="true"></i>
			  Doctor</a><br>	
	</div>
	
	<div class="col-sm-4 col-md-offset-5"> <br>
			 <a href="/add-staff" type="submit" class="btn btn-primary col-xs-7"><i class="fa fa-user-plus" aria-hidden="true"></i>
			  Staff</a><br>	
	</div>
	<div class="col-sm-4 col-md-offset-5"> <br>
			 <a href="/add-pharmacist" type="submit" class="btn btn-primary col-xs-7"><i class="fa fa-user-plus" aria-hidden="true"></i>
			  Pharmacist</a><br>	
	</div>
</div>

<%@ include file="common/footer.jspf"%>