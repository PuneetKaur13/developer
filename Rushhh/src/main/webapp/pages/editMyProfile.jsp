<style type="text/css">
th {
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
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
			<div class="panel panel-primary">
				<!-- Default panel contents -->
				<div class="panel-heading">
					<h3 class="panel-title">
						<span class="glyphicon glyphicon-edit"></span> Edit My Profile
					</h3>
				</div>
				<!-- Table -->
				<div id="page-wrapper">
					<form class="form-horizontal" role="form"
						ng-submit="ctl.updateProfile()">
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
								<label for="user" class="col-sm-2 control-label">Last
									Name : <span style="color: red;">*</span>
								</label>
								<div class="col-sm-4">
									<input type="text" ng-model="ctl.form.lastName"
										class="form-control" placeholder="Enter Last Name" required>
								</div>
							</div>
							<div class="form-group">
								<label for="shortName" class="col-sm-2 control-label">
									Login Id : <span style="color: red;">*</span>
								</label>
								<div class="col-sm-4">
									<input type="email" ng-model="ctl.form.loginId"
										class="form-control" placeholder="Enter Email  Id " readonly>
								</div>
								<label for="shortName" class="col-sm-2 control-label">
									Gender : <span style="color: red;">*</span>
								</label>
								<div class="col-sm-4">
									<select class="form-control" ng-model="ctl.form.gender"
										ng-options="gender as gender for gender in ['Male','Female']"
										required>
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

							</div>
							<div class="form-group">
								<label for="shortName" class="col-sm-2 control-label">Mobile
									No : </label>
								<div class="col-sm-4">
									<input type="text" class="form-control"
										ng-model="ctl.form.mobile" placeholder="Enter Mobile NO." />
								</div>
							</div>
							<div class="form-group">
								<label for="shortName" class="col-sm-2 control-label">Image
									: {{ctl.uploadForm.uploadMessage}}</label>
								<div class="col-sm-4">
									<img ng-src="/OCBS/upload/{{ctl.form.imagePath}}"
										id="mediaHere" class="img-rounded" style="max-width: 150px;"
										ng-show="ctl.form.imagePath!=''"> <input
										accept="image/*" type="file" file-model="ctl.uploadForm.file"
										id="fileUser" ng-model="ctl.uploadForm.file"
										preview-class="img-thumbnail" preview-container="mediaHere"
										media-preview ng-change="ctl.upload();">
								</div>
							</div>


						</div>
						<div class="modal-footer">
							<input type="submit" value="Save" class="btn btn-success">
						</div>
						</form>
				</div>
				
			</div>
		</div>
	</div>
</div>
</div>