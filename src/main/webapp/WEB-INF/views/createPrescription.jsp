<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation-doctor.jspf"%>

<div class="container-fluid">


<div class="container">

	<div class="panel panel-default">
		<div class="panel-heading">
			<h1>Prescription</h1>
		</div>
		<div class="panel-body">
      		<p>Prescription Id :</p>
	  		<p>Patient Id : </p>
	  		<p>Patient Name : </p>
	  		<p>Doctor Name : </p>
		</div>
	</div>
	 
</div>

<div class="container">


<form class="form-horizontal">
    <div class="table-responsive">
        <table class="table table-bordered table-striped table-highlight">
			<thead>
					<tr>
						<th>Medicine ID </th>
						<th>Medicine Name </th>
						<th>Amount</th>
						<th>Instruction</th>
						<th>Add</th>
						<th>Delete</th>
					</tr>
            </thead>
            <tbody>
                <tr>
                    <td><input type="text" class="form-control" value="Medicine Id"/></td>
                    <td><input type="text" class="form-control" value="Medicine Name"/></td>
                    <td><input type="text" class="form-control" value="Amount"/></td>
                    <td><input type="text" class="form-control" value="Instruction"/></td>
                    <td class="input-group-btn">
                            <button class="btn btn-success btn-add" type="button">
                                <span class="glyphicon glyphicon-plus"></span>
                            </button>
                    </td>
                    <td class="input-group-btn">
                            <button class="btn btn-success btn-add" type="button">
                                <span class="glyphicon glyphicon-minus"></span>
                            </button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</form>    
	<div class="pull-right">
		<button type="submit" class="btn btn-success" >Submit</button>
    </div>
</div>


</div>
<%@ include file="common/footer.jspf"%>
