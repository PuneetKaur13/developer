
<style type="text/css">
th, .td {
	text-align: center;
	white-space: nowrap;
}

td {
	text-align: center;
	white-space: nowrap;
}

h4, .h4 {
	margin-top: 4px;
}

.modal-dialog {
	margin: 30px auto;
	width: 750px;
}
</style>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-primary">
				<!-- Default panel contents -->
				<div class="panel-heading" style="height: 50px;">
					<div class="col-xs-5 col-sm-6 col-md-8">
						<h4>User List</h4>
					</div>
					<div class="col-xs-7 col-sm-6 col-md-4" ng-show="ctl.button.go">
						<div class="text-right">
							<label class="h4">PageNo:&nbsp;</label> <input type="hidden"
								ng-model="hidPageNoValue" /> <input type="hidden"
								ng-model="hidPageSize" /> <select class="form-control"
								style="width: 74px; height: 31px; display: inline;"
								ng-model="ctl.searchData.pageNo"
								ng-options="page as page for page in ctl.dataList.pageNoList">
							</select>
							<button type="submit" class="btn btn-success btn-sm" id="Button2"
								name="command" ng-click="ctl.search()" value="Go">Go</button>
							<button type="submit" ng-disabled="!ctl.button.previous"
								class="btn btn-success btn-sm inline" id="Button6"
								name="command" value="Previous" ng-click="ctl.previous()"><<</button>
							<button type="submit" ng-disabled="!ctl.button.next"
								class="btn btn-success btn-sm inline" id="Button7"
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
							<tr>
								<td><input type="text" class="form-control"
									ng-model="ctl.searchData.firstName"
									placeholder="Search First Name"></td>
								<td>&nbsp;</td>
								<td><input type="text" class="form-control"
									ng-model="ctl.searchData.loginId" placeholder="Search Email"></td>
								<td>&nbsp;</td>
								<td><select class="form-control inline"
									ng-model="ctl.searchData.status" required>
										<option value="">--Select--</option>
										<option value="APPROVED">ACTIVE</option>
										<option value="DISAPPROVED">DEACTIVE</option>
										<option value="LOCKED">LOCKED</option>
								</select></td>


								<td style="text-align: left;">&emsp;<input type="submit"
									class="btn btn-success" ng-click="ctl.search()" value="Search"></td>
							</tr>
						</table>
						<br>
						<table class="table table-bordered table-striped table-hover"
							fixed-header ng-show="ctl.dataList.list.length>0">
							<thead class="text-uppercase">
								<tr>
									<th>#</th>
									<th>#</th>
									<th>ID</th>
									<th>IMAGE</th>
									<th>FIRST NAME</th>
									<th>LAST NAME</th>
									<th>Email ID</th>
									<th>ROLE</th>
									<th>STATUS</th>
								</tr>
							</thead>
							<tbody>
								<tr ng-repeat="user in ctl.dataList.list">
									<td align="center"><input type="checkbox"
										checklist-model="ctl.checkedData.del"
										checklist-value="user.id"></td>
									<td align="center"><a href=""
										ng-click="ctl.display(user.id)" data-toggle="modal"
										data-target="#mainModal"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<td>{{$index+1}}</td>
									<td align="center"><img
										ng-src="/OCBS/upload/{{user.imagePath}}" title="{{user.name}}"
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
				<h4 class="modal-title">Add Associates</h4>
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
						<!-- <label for="shortName" class="col-sm-2 control-label">
							Email Id : </label>
						<div class="col-sm-4">
							<input type="email" ng-model="ctl.form.email"
								class="form-control" placeholder="Enter Email Id"> -->
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
						<input type="text" class="form-control" ng-model="ctl.form.mobile"
							placeholder="Enter Mobile NO." />
					</div>
				</div>

				<div class="form-group">
					<label for="Designation" class="col-sm-2 control-label">Role
						: <span style="color: red;">*</span>
					</label>
					<div class="col-sm-4">
						<select class="form-control inline" ng-model="ctl.form.roleId"
							ng-options="option.id as option.value for option in ctl.dataList.preload.roleList"
							required>
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
							<option value="LOCKED">LOCKED</option>
						</select>
					</div>
				</div>

				<!-- 	<div class="form-group">
						<label for="shortName" class="col-sm-3 control-label">Upload Image : {{ctl.uploadForm.uploadMessage}}</label>
						<div class="col-sm-4">
							<div id="mediaHere" class="custom-preview"></div>
							<input accept="image/*" type="file"
								file-model="ctl.uploadForm.file" ng-model="ctl.uploadForm.file"
								preview-class="img-thumbnail" preview-container="mediaHere"
								media-preview ng-change="ctl.upload()">
						</div>
					</div> -->

				<div class="form-group">
					<label for="shortName" class="col-sm-3 control-label">Company
						Logo : {{ctl.uploadForm.uploadMessage}}</label>
					<div class="col-sm-4">
						<img ng-src="/OCBS/upload/{{ctl.form.imagePath}}" id="mediaHere"
							class="img-rounded" style="max-width: 150px;"
							ng-show="ctl.form.imagePath!=''"> <input accept="image/*"
							type="file" file-model="ctl.uploadForm.file" id="fileUser"
							ng-model="ctl.uploadForm.file" preview-class="img-thumbnail"
							preview-container="mediaHere" media-preview
							ng-change="ctl.upload();">
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
