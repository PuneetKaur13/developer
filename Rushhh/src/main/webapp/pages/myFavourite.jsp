
<style type="text/css">
th {
	text-align: center;
	white-space: nowrap;
}

h4, .h4 {
	margin-top: 4px;
}

.multiselect {
	width: 20em;
	height: 15em;
	border: solid 1px #c0c0c0;
	overflow: auto;
}

.multiselect label {
	display: block;
}

.multiselect-on {
	color: #ffffff;
	background-color: #000099;
}
</style>

<div class="row">
	<div class="col-sm-3"></div>
	<div class="col-sm-6">
		<div class="panel panel-primary">
			<!-- Default panel contents -->
			<div class="panel-heading" style="height: 50px;">
				<div class="col-xs-5 col-sm-6 col-md-8">
					<h4>Prefered Supplier</h4>
				</div>
			</div>
			<!-- Table -->
			<div id="page-wrapper">
				<div ng-show="ctl.progress!=''">
					<div class="alert alert-danger" role="alert">
						<strong>{{ctl.progress}}</strong>
					</div>
				</div>
				<div class="table-responsive">
					<table class="table table-bordered table-striped table-hover"
						ng-show="ctl.dataList.list.length>0">
						<thead class="text-uppercase">
							<tr>
								<th>#</th>
								<th>#</th>
								<th>Supplier Product</th>
								<th>Supplier Company</th>
							</tr>
						</thead>
						<tbody>

							<tr ng-repeat="bid in ctl.dataList.list">
								<td align="center"><input type="checkbox"
									checklist-model="ctl.checkedData.del" checklist-value="bid.id"></td>
								<td align="center">{{$index+1}}</td>
								<td align="center">{{bid.productName}}</td>
								<td align="center">{{bid.companyName}}</td>
							</tr>
						</tbody>
					</table>
					<button type="button" class="btn btn-success" data-toggle="modal"
						data-target="#mainModalPreferred"
						ng-click="ctl.addModalPrefferd()">Add</button>
					<button type="button" class="btn btn-success"
						ng-show="ctl.dataList.list.length>0" ng-click="ctl.deleteData()">Delete</button>
				</div>
			</div>
		</div>
	</div>
	<!--Preferred-->
	<div class="modal fade" id="mainModalPreferred" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="mainModalLabel"></h4>
				</div>
				<form class="form-horizontal" role="form"
					ng-submit="ctl.addDataPrefferd()">
					<div class="modal-body">
						<div ng-show="ctl.progress!=''">
							<div class="alert alert-danger fade in">
								<strong>{{ctl.progress}}</strong>
							</div>
						</div>
						<div class="alert alert-danger"
							ng-show="ctl.message != '' && ctl.message.success == false">
							<strong>{{ctl.message.msg}}</strong>
						</div>
						<div class="alert alert-success"
							ng-show="ctl.message != '' && ctl.message.success == true">
							<strong>{{ctl.message.msg}}</strong>
						</div>
						<div class="form-group">
							<label for="type" class="col-sm-3 control-label"> Choose
								Product : <span style="color: red;">*</span>
							</label>
							<div class="col-sm-7">
								<select class="form-control inline"
									ng-model="ctl.selectedOptionProduct"
									ng-options="option.name for option in ctl.productList.list track by option.id"
									ng-change="ctl.form.productId=ctl.selectedOptionProduct.id;ctl.form.productName=ctl.selectedOptionProduct.name">
									<option value="">--Select--</option>
								</select>
							</div>
						</div>
						<div class="form-group">

							<label for="type" class="col-sm-3 control-label"> Choose
								User : <span style="color: red;">*</span>
							</label>
							<div class="col-sm-7">
								<select class="form-control inline"
									ng-model="ctl.selectedOption"
									ng-options="option.companyName for option in ctl.companyList.list track by option.id"
									ng-change="ctl.form.companyId=ctl.selectedOption.id;ctl.form.companyName=ctl.selectedOption.companyName"
									required>
									<option value="">--Select--</option>
								</select>
							</div>
						</div>
						<!-- <div class="form-group">
							<label class="col-sm-2 control-label" for="email">Select
								Seller</label>
							<div class="col-sm-7">
								<script type="text/javascript">
									$('.selectpicker').selectpicker([]);
								</script>
								<select class="selectpicker" multiple="multiple"
									ng-model="ctl.selected"
									ng-options="option1.companyName for option1 in ctl.companyList.list track by option1.id">
									<option></option>
									<option></option>
								</select>
							</div>
						</div> -->
						<div class="modal-footer">
							<input type="submit" value="Save" class="btn btn-success">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
</div>