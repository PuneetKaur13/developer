<style type="text/css">
th, .td, tr, td {
	white-space: pre-wrap;
	text-align: center;
}

.modal-dialog {
	margin: 30px auto;
	width: 750px;
}
</style>
<div class="container">
	<div class="row">
		<div class="col-xs-7 col-sm-12" ng-show="ctl.button.go">
			<div class="col-md-5"></div>
			<div class="col-md-3">
				<h3>
					<b>User Master</b>
				</h3>
			</div>
			<br>
			<div class="text-right">
				<input type="hidden" ng-model="hidPageNoValue" /> <input
					type="hidden" ng-model="hidPageSize" /> <select
					class="form-control"
					style="width: 74px; height: 31px; display: inline;"
					ng-model="ctl.searchData.pageNo"
					ng-options="page as page for page in ctl.dataList.pageNoList">
				</select>
				<button type="submit" class="btn btn-primary btn-sm inline"
					id="Button2" name="command" ng-click="ctl.search()" value="Go">Go</button>
				<button type="submit" ng-disabled="!ctl.button.previous"
					class="btn btn-primary btn-sm inline" id="Button6" name="command"
					value="Previous" ng-click="ctl.previous()"><<</button>
				<button type="submit" ng-disabled="!ctl.button.next"
					class="btn btn-primary btn-sm inline" id="Button7" name="command"
					value="Next" ng-click="ctl.next()">>></button>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2">
			<input type="text" class="form-control"
				ng-model="ctl.searchData.firstName"
				placeholder="Search by first name">
		</div>
		<div class="col-md-2">
			<input type="text" class="form-control"
				ng-model="ctl.searchData.email" placeholder="Search by email">
		</div>
		<div class="col-md-2">
			<select ng-model="ctl.searchData.status" class="form-control">
				<option value="">--Status--</option>
				<option value="APPROVED">ACTIVE</option>
				<option value="DISAPPROVED">DEACTIVE</option>
				<option value="LOCKED">LOCKED</option>
			</select>
		</div>
		<div class="col-md-2">
			<button type="Submit" class="btn btn-primary" ng-click="ctl.search()">Search</button>

		</div>
	</div>
	<br>
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

						<th><h4>ID</h4></th>
						<th><h4>IMAGE</h4></th>
						<th><h4>FIRST NAME</h4></th>
						<th><h4>LAST NAME</h4></th>
						<th><h4>Email ID</h4></th>
						<th><h4>ROLE</h4></th>
						<th><h4>STATUS</h4></th>
						<th>#</th>
						<th>#</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="user in ctl.dataList.list">
						<td>{{ctl.index+($index+1)}}</td>
						<td align="center"><img
							ng-src="/Rushhh/upload/{{user.imagePath}}" title="{{user.name}}"
							id="mediaHere" class="img-rounded" style="max-width: 60px;"
							ng-show="user.imagePath!=''"> <img
							ng-src="/OCBS/images/unknown.png" title="{{user.name}}"
							id="mediaHere" class="img-rounded" style="max-width: 60px;"
							ng-show="user.imagePath==''"></td>
						<td>{{user.firstName}}</td>
						<td>{{user.lastName}}</td>
						<td>{{user.loginId}}</td>
						<td>{{user.roleName}}</td>
						<td align="center"><img src="images/{{user.status}}.png"
							class="img-rounded" title="{{user.status}}" width="25"
							height="25" ng-show="user.status!=null"></td>
						<td class="text-center"><a class='btn btn-info btn-xs'
							ng-click="ctl.display(user.id)" data-toggle="modal"
							data-target="#mainModal" href=""><span
								class="glyphicon glyphicon-edit"></span> Edit</a>
						<td align="center"><input type="checkbox"
							checklist-model="ctl.checkedData.del" checklist-value="user.id"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row">
		<div class="col-md-5"></div>
		<div class="col-md-4">
			<button type="Submit" class="btn btn-primary" data-toggle="modal"
				data-target="#mainModal" ng-click="ctl.display(0)">Add</button>
			&nbsp;
			<button type="Submit" class="btn btn-danger"
				ng-show="ctl.button.remove" ng-click="ctl.removeAll()">Delete</button>
		</div>
	</div>
</div>
<div class="modal fade" id="mainModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<div class="pull-right">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				</div>
				<h3 class="modal-title">Add Associates</h3>
			</div>
			<form class="form-horizontal" role="form" ng-submit="ctl.submit()">
				<div class="modal-body">
					<div ng-show="ctl.message!=null"
						ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
						<strong>{{ctl.message}}</strong>
					</div>
					<div class="form-group">
						<label for="countryName" class="col-sm-2 control-label">First
							Name : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<input type="text" ng-model="ctl.form.firstName"
								class="form-control" placeholder="Enter First Name" required>
						</div>
						<label for="user" class="col-sm-2 control-label">Last Name
							: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<input type="text" ng-model="ctl.form.lastName"
								class="form-control" placeholder="Enter Last Name" required>
						</div>
					</div>
					<div class="form-group">
						<label for="shortName" class="col-sm-2 control-label">
							Email : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<input type="text" ng-model="ctl.form.loginId"
								class="form-control" placeholder="Enter Email Id " required>
						</div>
						<label for="shortName" class="col-sm-2 control-label">
							Password : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<input type="password" ng-model="ctl.form.password"
								class="form-control" placeholder="Enter Password " required>
							<!-- <input type="checkbox" id="checkbox" ng-model="passwordCheckbox"
								ng-click="hideShowPassword()" /> <label for="checkbox"
								ng-if="passwordCheckbox">Hide password</label> <label class="control-label"
								for="checkbox" ng-if="!passwordCheckbox">Show password</label> -->
						</div>
					</div>
					<div class="form-group">
						<label for="shortName" class="col-sm-2 control-label">
							Gender : </label>
						<div class="col-sm-4">
							<select class="form-control" ng-model="ctl.form.gender"
								ng-options="gender as gender for gender in ['Male','Female']">
								<option value="">--Select--</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="DOB" class="col-sm-2 control-label">DOB : </label>
						<div class="col-sm-4">
							<datepicker date-format="dd-MM-yyyy"> <input
								type="text" class="form-control" ng-model="ctl.form.dob"
								placeholder="DD-MM-YYYY" /> </datepicker>
						</div>
						<label for="shortName" class="col-sm-2 control-label">Mobile
							No : </label>
						<div class="col-sm-4">
							<input type="text" class="form-control" ui-br-phone-number
								ng-model="ctl.form.mobile" placeholder="Enter Mobile NO." />
						</div>
					</div>

					<div class="form-group">
						<label for="Designation" class="col-sm-2 control-label">Role
							: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<select class="form-control inline" ng-model="ctl.form.roleId"
								ng-options="option.id as option.value for option in ctl.dataList.preload.roleList">
								<option value="">--Select--</option>
							</select>
						</div>
						<label for="shortName" class="col-sm-2 control-label">Status
							: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<select class="form-control inline" ng-model="ctl.form.status"
								required>
								<option value="">--Select--</option>
								<option value="APPROVED">ACTIVE</option>
								<option value="DISAPPROVED">DEACTIVE</option>
								<option value="locked">LOCKED</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="shortName" class="col-sm-2 control-label">Image
							: {{ctl.uploadForm.uploadMessage}}</label>
						<div class="col-sm-4">
							<img ng-src="/Rushhh/upload/{{ctl.form.imagePath}}"
								id="mediaHere" class="img-rounded" style="max-width: 150px;"
								ng-show="ctl.form.imagePath!=''"> <input accept="image/*"
								type="file" file-model="ctl.uploadForm.file" id="fileUser"
								ng-model="ctl.uploadForm.file" preview-class="img-thumbnail"
								preview-container="mediaHere" media-preview
								ng-change="ctl.upload();">
						</div>
					</div>
					<div class="modal-footer">
						<div class="col-md-3"></div>
						<div class="col-md-3">
							<input type="submit" class="btn btn-primary btn-md" value="Save"
								class="btn btn-success">&nbsp;
						</div>
						<div class="col-md-1">
							<button type="button" class="btn btn-danger btn-sm"
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