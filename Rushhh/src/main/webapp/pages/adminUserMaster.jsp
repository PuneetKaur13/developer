<%@page import="com.ncs.dto.UserDTO"%>
<%@page import="com.nenosystems.common.dto.UserContext"%>
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

<%
	UserContext ctx = (UserContext) session.getAttribute("ctx");
	UserDTO user = new UserDTO();
	if (ctx == null) {
		ctx = new UserContext();
	}
	user = (UserDTO) ctx.getBaseDTO();
%>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-8">
			<div class="panel panel-primary">
				<!-- Default panel contents -->
				<div class="panel-heading" style="height: 50px;">
					<div class="col-md-6">
						<h4>Admin Master</h4>
					</div>
					<!-- <div class="col-sm-2">
						<input type="text" ng-model="ctl.branch.firstName"
							class="form-control" placeholder="Enter FirstName" required>
					</div>
					<div class="col-sm-2">
						<input type="text" ng-model="ctl.branch.lastName"
							class="form-control" placeholder="Enter Last Name" required>
					</div>
					<div class="col-sm-2">
						<input type="text" ng-model="ctl.branch.loginId"
							class="form-control" placeholder="Enter LoginId" required>
					</div>
					<div class="col-sm-2">
						<input type="text" ng-model="ctl.branch.roleName"
							class="form-control" placeholder="Enter Role" required>
					</div>
					<div class=" col-xs-5 col-sm-6 col-md-1">
						<input type="submit" class="btn btn-success col-sm"
							ng-click="ctl.search()" value="Search" />
					</div> -->
					<div class="col-md-6" ng-show="ctl.userList.list.length>0">
						<div class="text-right">
							<label class="h4">PageNo:&nbsp;</label> <input type="hidden"
								ng-model="ctl.pageNo" /><select class="form-control"
								style="width: 74px; height: 31px; display: inline;"
								ng-model="ctl.pageNo"
								ng-options="page as page for page in ctl.userList.pageNoList">
							</select>
							<button type="submit" class="btn btn-success btn-sm" id="Button2"
								name="command" ng-click="ctl.go()" value="Go">Go</button>
							<button type="submit"
								ng-class="{'disabled':ctl.userList.disablePrevious==true}"
								ng-disabled="ctl.userList.disablePrevious==true"
								class="btn btn-success btn-sm inline" id="Button6"
								name="command" value="Previous" ng-click="ctl.previous()"><<</button>
							<button type="submit"
								ng-class="{'disabled':ctl.userList.disableNext==true}"
								ng-disabled="ctl.userList.disableNext==true"
								class="btn btn-success btn-sm inline" id="Button7"
								name="command" value="Next" ng-click="ctl.next()">>></button>
						</div>
					</div>
				</div>
				<!-- Table -->
				<div id="page-wrapper">
					<div ng-show="ctl.progress!=''">
						<div class="alert alert-danger" role="alert">
							<strong>{{ctl.progress}}</strong>
						</div>
					</div>
					<div ng-show="ctl.success!=''">
						<div class="alert alert-danger" role="alert">
							<strong>{{ctl.progress}}</strong>
						</div>
					</div>
					<div class="table-responsive">

						<br>
						<table class="table table-bordered table-striped table-hover"
							fixed-header ng-show="ctl.userList.list.length>0">
							<thead class="text-uppercase">
								<tr>
									<th>#</th>
									<th>#</th>
									<th>ID</th>
									<th>FIRST NAME</th>
									<th>LAST NAME</th>
									<th>LOGIN ID</th>
									<th>EMAIL ID</th>
									<th>ROLE</th>
									<th>STATUS</th>
								</tr>
							</thead>
							<tbody>
								<tr ng-repeat="user in ctl.userList.list">
									<td align="center"><input type="checkbox"
										checklist-model="ctl.checkedData.del"
										checklist-value="user.id"></td>
									<td align="center"><a href="" ng-click="ctl.edit(user.id)"
										data-toggle="modal" data-target="#mainModal"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<!-- 		<td align="center">{{($index+1)+(ctl.countStart)}}</td> -->
									<td>{{$index+1}}</td>
									<td>{{user.firstName}}</td>
									<td>{{user.lastName}}</td>
									<td>{{user.loginId}}</td>
									<td>{{user.email}}</td>
									<td>{{user.roleName}}</td>
									<td align="center"><img src="images/{{user.status}}.png"
										class="img-rounded" title="{{user.status}}" width="25"
										height="25" ng-show="user.status!=null"></td>
								</tr>
							</tbody>
						</table>
						<button type="button" class="btn btn-success" data-toggle="modal"
							data-target="#mainModal" ng-click="ctl.addModal()">Add</button>
						<button type="button" class="btn btn-success"
							ng-show="ctl.userList.list.length>0" ng-click="ctl.deleteData()">Delete</button>
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
				<h4 class="modal-title" id="mainModalLabel"></h4>
			</div>
			<form class="form-horizontal" role="form" ng-submit="ctl.addData()">
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
						<label for="countryName" class="col-sm-2 control-label">First
							Name : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<input type="text" ng-model="ctl.form.data.firstName"
								class="form-control" placeholder="Enter First Name" required>
						</div>
						<label for="user" class="col-sm-2 control-label">Last Name
							: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<input type="text" ng-model="ctl.form.data.lastName"
								class="form-control" placeholder="Enter Last Name" required>
						</div>
					</div>
					<div class="form-group">
						<label for="shortName" class="col-sm-2 control-label">
							Login Id : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<input type="text" ng-model="ctl.form.data.loginId"
								class="form-control" placeholder="Enter Login Id " required>
						</div>
						<label for="shortName" class="col-sm-2 control-label">
							Password : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<input type="password" ng-model="ctl.form.data.password"
								class="form-control" placeholder="Enter Password " required>
						</div>
					</div>
					<div class="form-group">
						<label for="shortName" class="col-sm-2 control-label">
							Gender : </label>
						<div class="col-sm-4">
							<select class="form-control" ng-model="ctl.form.data.gender"
								ng-options="gender as gender for gender in ['Male','Female']">
								<option value="">--Select--</option>
							</select>
						</div>
						<label for="shortName" class="col-sm-2 control-label">
							Email Id : </label>
						<div class="col-sm-4">
							<input type="email" ng-model="ctl.form.data.email"
								class="form-control" placeholder="Enter Email Id">
						</div>
					</div>
					<div class="form-group">
						<label for="DOB" class="col-sm-2 control-label">DOB : </label>
						<div class="col-sm-4">
							<datepicker date-format="dd-MM-yyyy"> <input
								type="text" class="form-control" ng-model="ctl.form.data.dob"
								placeholder="DD-MM-YYYY" /> </datepicker>
						</div>
						<label for="shortName" class="col-sm-2 control-label">Mobile
							No : </label>
						<div class="col-sm-4">
							<input type="text" class="form-control"
								ng-model="ctl.form.data.mobile" placeholder="Enter Mobile NO." />
						</div>
					</div>
					<%
						if (user.getRoleName().equals("Super Admin")) {
					%>
					<div class="form-group">
						<label for="Designation" class="col-sm-2 control-label">Role
							: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<select class="form-control inline" ng-model="ctl.selectedOption"
								ng-options="option.roleName for option in ctl.rolelist.list track by option.id"
								ng-change="ctl.form.data.roleId=ctl.selectedOption.id;ctl.form.data.roleName=ctl.selectedOption.roleName"
								required>
								<option value="">--Select--</option>
							</select>
						</div>
						<label for="shortName" class="col-sm-2 control-label">Status
							: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<select class="form-control inline"
								ng-model="ctl.form.data.status" required>
								<option value="">--Select--</option>
								<option value="ACTIVE">ACTIVE</option>
								<option value="DEACTIVE">DEACTIVE</option>
								<option value="LOCKED">LOCKED</option>
							</select>
						</div>
					</div>
					<%
						}
					%>
					<div class="form-group">
						<label for="shortName" class="col-sm-2 control-label">Image
							: </label>
						<div class="col-sm-4">
							<div class="form-control inline"
								style="width: 200px; height: 200px; background-image: url('http://www.software.iitedu.org.in/img/unknown_user.png');"
								ng-hide="ctl.form.data.imagePath!=null"></div>
							<div ng-show="ctl.form.data.imagePath!=null">
								<img alt="User" src="{{ctl.form.data.imagePath}}" height="200"
									width="200">
							</div>
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
