<%@ include file="common/header.jspf"%>
<nav role="navigation" class="navbar navbar-default">

	<div class="">
		<a href="/" class="navbar-brand">MyHospital <i
			class="fa fa-hospital-o" aria-hidden="true"></i></a>
	</div>
</nav>

<div class="container-fluid">
 <div class="alert alert-info">
 	Your Hospital Number is ${hospitalNumber}, check your mail at ('${email}') for more information.
</div>
	
	<br>



</div>



<div class="col-sm-offset-5 col-sm-2 text-center">
	<a href="/" class="btn btn-success">Back to Home Page</a>
</div>


<%@ include file="common/footer.jspf"%>