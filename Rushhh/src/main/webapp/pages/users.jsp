<style type="text/css">
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
				<!-- Default panel contents -->
				<div class="panel-heading" style="height: 50px; background-color:#64b5f6">
					<div class="col-sm-5 ">
						<h4>User List</h4>
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
							<button type="submit" class="btn btn-success btn-sm" id="Button2" style="background-color:#64b5f6"
								name="command" ng-click="ctl.search()" value="Go">Go</button>
							<button type="submit" ng-disabled="!ctl.button.previous"
								class="btn btn-success btn-sm inline" id="Button6" style="background-color:#64b5f6"
								name="command" value="Previous" ng-click="ctl.previous()"><<</button>
							<button type="submit" ng-disabled="!ctl.button.next"
								class="btn btn-success btn-sm inline" id="Button7" style="background-color:#64b5f6"
								name="command" value="Next" ng-click="ctl.next()">>></button>
						</div>
					</div>
				</div>
				<!-- Table -->
				<div id="page-wrapper">
					<div ng-show="ctl.searchMessage!=null"
						ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
						<strong>{{ctl.searchMessage}}</strong>
					</div>
					<div class="table-responsive">
				 <table>
							<!--  <tr>
								  <td><input type="text" class="form-control"
									ng-model="ctl.searchData.name" placeholder="Search User"></td>
								<td>&nbsp;&nbsp;</td>
								<td style="text-align: left;">&emsp;<input type="submit"
									class="btn btn-success" ng-click="ctl.search()" value="Search"></td>
							</tr> -->
						</table> 
						<br> 
						<table class="table table-bordered table-striped table-hover"
							ng-show="ctl.dataList.list.length>0">
							<thead class="text-uppercase">
								<tr>
									<th>#</th>
									<th>#</th>
									<th>Id</th>
									<th>First Name</th>
									<th>Last Name</th>
									<th>Login Id</th>
									<th>Card Type</th>
									<th>Mobile</th>
								</tr>
							</thead>
							<tbody>
								<tr ng-repeat="user in ctl.dataList.list">
									<td align="center"><input type="checkbox"
										checklist-model="ctl.checkedData.del"
										checklist-value="user.id"></td>
									<td align="center"> <a href=""
										ng-click="ctl.display(user.id)" data-toggle="modal"
										data-target="#mainModal"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<td align="center">{{user.id}}</td>
									<td align="center">
										{{user.firstName}}</td>
									<td align="center">{{user.lastName}}</td>
									<td align="center">{{user.loginId}}</td>
									<td align="center">{{user.cardType}}</td>
									<td align="center">{{user.mobile}}</td>
								</tr>
							</tbody>
						</table>
						<button type="button" class="btn btn-success" data-toggle="modal" style="background-color:#64b5f6"
							data-target="#mainModal" ng-click="ctl.display(0)">Add</button>
						<button type="button" class="btn btn-success" style="background-color:#64b5f6"
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
				<button type="button" class="close" data-dismiss="modal"style="background-color:#64b5f6"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">User</h4>
			</div>
			<form class="form-horizontal" role="form" ng-submit="ctl.submit()">
				<div class="modal-body">
					<div ng-show="ctl.message!=null"
						ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
						<strong>{{ctl.message}}</strong>
					</div>
					<div class="form-group">
						<label for="type" class="col-sm-3 control-label"> Id : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.id" class="form-control"
								placeholder="Enter Id" required>
						</div>
					</div>
					<div class="form-group">
						<label for="type" class="col-sm-3 control-label"> First Name :
							<span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.firstName"
								class="form-control" placeholder="Enter Fisrt Name" required>
						</div>
					</div>
					<div class="form-group">
						<label for="type" class="col-sm-3 control-label">
							Last Name : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.lastName"
								class="form-control" placeholder="Enter Last Name"
								required>
						</div>
					</div>
					<div class="form-group">
						<label for="type" class="col-sm-3 control-label">
							Login Id : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.loginId"
								class="form-control" placeholder="Enter Login Id"
								required>
						</div>
					</div>
					<div class="form-group">
						<label for="type" class="col-sm-3 control-label">
							Card Type : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.cardType"
								class="form-control" placeholder="Enter Card Type"
								required>
						</div>
					</div>
					<div class="modal-footer">
						<input type="submit" value="Save" class="btn btn-success" style="background-color:#64b5f6">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>