
<style type="text/css">
th {
	text-align: center;
	white-space: nowrap;
}

h4, .h4 {
	margin-top: 4px;
}
</style>

<div class="row col-sm-12">
	<div class="col-sm-6" style="padding-left: 20ex">
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
								<th>Preferred Supplier</th>
							</tr>
						</thead>
						<tbody>

							<tr ng-repeat="bid in ctl.dataList.list">
								<td align="center"><input type="checkbox"
									checklist-model="ctl.checkedData.del" checklist-value="bid.id"></td>
								<td align="center">{{$index+1}}</td>
								<td align="center">{{bid.userName}}</td>
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
	<div class="col-sm-5">
		<div class="panel panel-primary">
			<!-- Default panel contents -->
			<div class="panel-heading" style="height: 50px;">
				<div class="col-xs-5 col-sm-6 col-md-8">
					<h4>Non Prefered Supplier</h4>
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
						ng-show="ctl.preDataList.list.length>0">
						<thead class="text-uppercase">
							<tr>
								<th>#</th>
								<th>#</th>
								<th>Non Preferred Supplier</th>
							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="preferred in ctl.preDataList.list">
								<td align="center"><input type="checkbox"
									checklist-model="ctl.checkedNonData.dele"
									checklist-value="preferred.id"></td>
								<td align="center">{{$index+1}}</td>
								<td align="center">{{preferred.userName}}</td>
							</tr>
						</tbody>
					</table>
					<button type="button" class="btn btn-success" data-toggle="modal"
						data-target="#mainModalNonPreferred"
						ng-click="ctl.addModalNonPrefferd()">Add</button>
					<button type="button" class="btn btn-success"
						ng-show="ctl.preDataList.list.length>0"
						ng-click="ctl.nonDeleteData()">Delete</button>
				</div>
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
							User : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<select class="form-control inline" ng-model="ctl.selectedOption"
								ng-options="option.firstName for option in ctl.userList.list track by option.id"
								ng-change="ctl.form.userId=ctl.selectedOption.id;ctl.form.userName=ctl.selectedOption.firstName,ctl.selectedOption.lastName"
								required>
								<option value="">--Select--</option>
							</select>
						</div>
					</div>
					<div class="modal-footer">
						<input type="submit" value="Save" class="btn btn-success">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>

<!-- Non Preferred  -->
<div class="modal fade" id="mainModalNonPreferred" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="mainModalLabel1"></h4>
			</div>
			<form class="form-horizontal" role="form"
				ng-submit="ctl.addDataNonPrefferd()">
				<div class="modal-body">
					<div ng-show="ctl.progress!=''">
						<div class="alert alert-danger fsade in">
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
							User : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<select class="form-control inline" ng-model="ctl.selectedOption"
								ng-options="option.firstName for option in ctl.userList.list track by option.id"
								ng-change="ctl.form.userId=ctl.selectedOption.id;ctl.form.userName=ctl.selectedOption.firstName"
								required>
								<option value="">--Select--</option>
							</select>
						</div>
					</div>
					<div class="modal-footer">
						<input type="submit" value="Save" class="btn btn-success">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>

