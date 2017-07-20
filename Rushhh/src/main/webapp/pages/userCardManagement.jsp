<style type="text/css">
th, .td {
	white-space: inherit;
}

td {
	white-space: inherit;
}

h4, .h4 {
	margin-top: 4px;
}

.modal-dialog {
	margin: 30px auto;
	width: 750px;
}
</style>
<div class="container">
	<div class="row">
		<div class="row">
			<div class="row">
				<div class="col-xs-5 col-sm-6 col-md-4">
					<h4>User Card Management Master</h4>
				</div>
				<div class="col-xs-5 col-sm-6 col-md-8">
					<div ng-show="ctl.button.go">
						<div class="text-right">
							<label class="h6">PageNo:&nbsp;</label> <input type="hidden"
								ng-model="hidPageNoValue" /> <input type="hidden"
								ng-model="hidPageSize" /> <select class="form-control"
								style="width: 74px; height: 31px; display: inline;"
								ng-model="ctl.searchData.pageNo"
								ng-options="page as page for page in ctl.dataList.pageNoList">
							</select> <a ng-click="ctl.previous()" ng-disabled="!ctl.button.previous"
								class="previous roundd">&#8249;</a> <a href=""
								class="next roundd-next" ng-disabled="!ctl.button.next"
								ng-click="ctl.next()">&#8250;</a>
							<!-- <button type="submit" class="btn btn-success btn-sm"
								name="command" ng-click="ctl.search()" value="Go">Go</button> -->
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<input type="text" class="form-control"
						ng-model="ctl.searchData.roleName" placeholder="Search by Role">
				</div>
				<div class="col-md-2">
					<button type="Submit" class="btn btn-primary"
						ng-click="ctl.search()">Search</button>
				</div>
			</div>
		</div>
		<div id="page-wrapper">
			<div class="table-responsive">
				<br>
				<div ng-show="ctl.searchMessage!=null"
					ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
					<strong>{{ctl.searchMessage}}</strong>
				</div>
				<table class="table table-bordered" fixed-header
					ng-show="ctl.dataList.list.length>0">
					<thead class="text-uppercase">
						<tr>
							<th>#</th>
							<th>User Name</th>
							<th>Reference No</th>
							<th>Chip No</th>
							<th>Card Type</th>
							<th>Date Of Issue</th>
							<th>Date Of Expiry</th>
							<th>#</th>
							<th>#</th>

						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="role in ctl.dataList.list">
							<td>{{ctl.index+($index+1)}}</td>
							<td align="center">{{$index+1}}</td>
							<td align="center">{{user.userName}}</td>
							<td align="center">{{user.cardReferenceNo}}</td>
							<td align="center">{{user.chipNo}}</td>
							<td align="center">{{user.cardType}}</td>
							<td align="center">{{user.dateOfIssue | date :
								'dd-MM-yyyy'}}</td>
							<td align="center">{{user.dateOfExpiry | date :
								'dd-MM-yyyy'}}</td>
							<td class="text-center"><a class='btn btn-info btn-xs'
								ng-click="ctl.display(role.id)" data-toggle="modal"
								data-target="#mainModal" href=""><span
									class="glyphicon glyphicon-edit"></span> Edit</a> <td align="center"><input type="checkbox"
								checklist-model="ctl.checkedData.del" checklist-value="user.id"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-3">
				<button type="Submit" class="btn btn-default" data-toggle="modal"
					data-target="#mainModal" ng-click="ctl.display(0)"
					style="height: 33px; background-color: #05222A; margin-top: 4px; color: #FFF; float: right; width: 30%;">Add</button>

			</div>
			<div class="col-md-3">
				<button type="Submit" class="btn btn-default"
					ng-show="ctl.button.remove" ng-click="ctl.removeAll()"
					style="height: 33px; background-color: #05222A; margin-top: 4px; color: #FFF; width: 30%;">Delete</button>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</div>
<div class="modal fade" id="mainModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<div class="pull-right">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				</div>
				<h3 class="modal-title">Add Role</h3>
			</div>
			<form class="form-horizontal" role="form" ng-submit="ctl.submit()">
				<div class="modal-body">
					<div ng-show="ctl.message!=null"
						ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
						<strong>{{ctl.message}}</strong>
					</div>
					<div class="form-group">
						<label for="type" class="col-sm-3 control-label"> Card
							Type : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.name" class="form-control"
								placeholder="Enter Card Type" required>
						</div>
					</div>
					<div class="form-group">
						<label for="type" class="col-sm-3 control-label"> Points :
							<span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.points"
								class="form-control" placeholder="Enter Card Points" required>
						</div>
					</div>
					<div class="form-group">
						<label for="type" class="col-sm-3 control-label">
							Conversion Factor : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.conversionFactor"
								class="form-control" placeholder="Enter Conversion Factor"
								required>
						</div>
					</div>
					<div class="modal-footer">
						<div class="col-md-3"></div>
						<div class="col-md-3">
							<input type="submit" class="btn btn-primary btn-sm" value="Save"
								class="btn btn-success">&nbsp;
						</div>
						<div class="col-md-3">
							<button type="button" class="btn btn-primary btn-sm"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>




<!-- <!-- <style type="text/css">
th {
	text-align: center;
	white-space: nowrap;
}

h4, .h4 {
	margin-top: 4px;
}
</style>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-primary">
				Default panel contents
				<div class="panel-heading" style="height: 50px; background-color:#64b5f6">
					<div class="col-sm-5 ">
						<h4>User Card Management</h4>
					</div>
					<div class="col-md-7" ng-show="ctl.dataList.list.length>0">
						<div class="text-right">
							<label class="h4">PageNo:&nbsp;</label> <input type="hidden"
								ng-model="hidPageNoValue" /> <input type="hidden"
								ng-model="hidPageSize" /> <select class="form-control"
								style="width: 74px; height: 31px; display: inline;"
								ng-model="ctl.searchData.pageNo"
								ng-options="page as page for page in ctl.dataList.pageNoList">
							</select>
							<button type="submit" class="btn btn-success btn-sm" id="Button2"style="background-color:#64b5f6"
								name="command" ng-click="ctl.search()" value="Go">Go</button>
							<button type="submit" ng-disabled="!ctl.button.previous"
								class="btn btn-success btn-sm inline" id="Button6"style="background-color:#64b5f6"
								name="command" value="Previous" ng-click="ctl.previous()"><<</button>
							<button type="submit" ng-disabled="!ctl.button.next"
								class="btn btn-success btn-sm inline" id="Button7"style="background-color:#64b5f6"
								name="command" value="Next" ng-click="ctl.next()">>></button>
						</div>
					</div>
				</div>
				Table
				<div id="page-wrapper">
					<div ng-show="ctl.searchMessage!=null"
						ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
						<strong>{{ctl.searchMessage}}</strong>
					</div>
					<div class="table-responsive">
						 <table>
							<tr>
								<td><input type="text" class="form-control"
									ng-model="ctl.searchData.cardType" placeholder="Search Card Type"></td>
								<td>&nbsp;&nbsp;</td>
								<td><input type="text" class="form-control"
									ng-model="ctl.searchData.cardReferenceNo" placeholder="Search Card Reference No"></td>
								<td style="text-align: left;">&emsp;<input type="submit"
									class="btn btn-success" style="background-color:#64b5f6" ng-click="ctl.search()" value="Search"></td>
							</tr>
						</table> 
						<br>
						<table class="table table-bordered table-striped table-hover"
							ng-show="ctl.dataList.list.length>0">
							<thead class="text-uppercase">
								<tr>
									<th>#</th>
									<th>User Name</th>
									<th>Reference No</th>
									<th>Chip No</th>
									<th>Card Type</th>
									<th>Date Of Issue</th>
									<th>Date Of Expiry</th>
								</tr>
							</thead>
							<tbody>
								<tr ng-repeat="user in ctl.dataList.list">
									<td align="center">{{$index+1}}</td>
									<td align="center">{{user.userName}}</td>
									<td align="center">{{user.cardReferenceNo}}</td>
									<td align="center">{{user.chipNo}}</td>
									<td align="center">{{user.cardType}}</td>
									<td align="center">{{user.dateOfIssue | date :
										'dd-MM-yyyy'}}</td>
									<td align="center">{{user.dateOfExpiry | date :
										'dd-MM-yyyy'}}</td>
								</tr>
							</tbody>
						</table>
						 	<button type="button" class="btn btn-success" data-toggle="modal"
							data-target="#mainModal" ng-click="ctl.display(0)">Add</button> 
						<button type="button" class="btn btn-success"
							ng-show="ctl.button.remove" ng-click="ctl.removeAll()">Delete</button> 
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
 <div class="modal fade" id="mainModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Card Type</h4>
			</div>
			<form class="form-horizontal" role="form" ng-submit="ctl.submit()">
				<div class="modal-body">
					<div ng-show="ctl.message!=null"
						ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
						<strong>{{ctl.message}}</strong>
					</div>
					<div class="form-group">
						<label for="type" class="col-sm-3 control-label"> Card
							Type : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.name" class="form-control"
								placeholder="Enter Card Type" required>
						</div>
					</div>
					<div class="form-group">
						<label for="type" class="col-sm-3 control-label"> Points :
							<span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.points"
								class="form-control" placeholder="Enter Card Points" required>
						</div>
					</div>
					<div class="form-group">
						<label for="type" class="col-sm-3 control-label">
							Conversion Factor : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.conversionFactor"
								class="form-control" placeholder="Enter Conversion Factor"
								required>
						</div>
					</div>
					<div class="modal-footer">
						<input type="submit" value="Save" class="btn btn-success">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</form>
		</div>
/.modal-content
</div>
/.modal-dialog
</div> --> -->