<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-pharmacist.jspf"%>

<div class="container-fluid">
<div class = "well" style=" background:#FBB917" >
 		<div style="font-weight:bold"><h2>Your profile</h2></div>
</div>

	<div class="row">
	<div class="col-md-3"></div>
	<div class="col-md-6">
	<table class="table borderless">
	  
	    <tr>
	      <th>username</th><td>${username}</td>
	    </tr>
	    <tr>
	      <th>password</th><td>${patient.password}</td>
	    </tr>
	    <tr>
	      <th>name</th><td>${patient.name}</td>
	    </tr>
	    <tr>
	      	<th>surname</th><td>${patient.surname}</td>
	    </tr>  
	  
	</table>
	</div>
	<div class="col-md-3"></div>
	</div>


</div>
<%@ include file="common/footer.jspf"%>