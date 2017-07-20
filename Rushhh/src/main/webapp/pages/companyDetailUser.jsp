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
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Company</h3>
				</div>
				<!-- Table -->
				<div id="page-wrapper">
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
								<label class="control-label col-sm-3 text-capitalize" for="text">Company
									Name : <span style="color: red;">*</span>
								</label>
								<div class="col-sm-7">
									<input type="text" ng-model="ctl.form.data.companyName"
										class="form-control text-capitalize"
										placeholder="Enter Company Name" required readonly />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3" for="text">Contact
									Person : <span style="color: red;">*</span>
								</label>
								<div class="col-sm-4">
									<input style='width: 90%' type="text"
										ng-model="ctl.form.data.firstName" id="name"
										class="form-control text-capitalize"
										placeholder="Enter First Name" required />
								</div>
								<div class="col-sm-4">
									<input style='width: 90%' type="text"
										ng-model="ctl.form.data.lastName" id="name1"
										class="form-control text-capitalize"
										placeholder="Enter Last Name" required />
								</div>
							</div>
							<div class="form-group">
								<label for="siteTypeId" class="col-sm-3 control-label">
									Company Logo : </label>
								<div class="col-md-5">
									<div id="mediaHere" class="custom-preview"></div>
									<input accept="image/*" type="file" file-model="ctl.form.file"
										id="fileUser" ng-model="ctl.form.file"
										placeholder="Enter Image" preview-class="img-thumbnail"
										preview-container="mediaHere" media-preview>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3" for="text">Designation/Job
									Title : </label>
								<div class="col-sm-7">
									<input type="text" ng-model="ctl.form.data.designation"
										class="form-control text-capitalize"
										placeholder="Enter Job/Title" required />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-3" for="text">CEO
									Name : </label>
								<div class="col-sm-4">
									<input style='width: 90%' type="text"
										ng-model="ctl.form.data.ceoName" id="namec"
										class="form-control text-capitalize"
										placeholder="Enter First Name" readonly/>
								</div>
								<div class="col-sm-4">
									<input style='width: 90%' type="text"
										ng-model="ctl.form.data.ceoLast" id="namec1"
										class="form-control text-capitalize"
										placeholder="Enter Last Name" readonly />
								</div>
							</div>
							
							<div class="form-group">
								<label for="state" class="col-sm-3 control-label">State
									: <span style="color: red;">*</span>
								</label>
								<div class="col-sm-7">
									<select class="form-control inline"
										ng-model="ctl.selectedOptionState"
										ng-options="option.stateName for option in ctl.stateList.list track by option.id"
										ng-change="ctl.form.data.stateId=ctl.selectedOptionState.id;ctl.form.data.stateName=ctl.selectedOptionState.stateName;ctl.findByStateId(ctl.selectedOptionState.id)"
										required>
										<option value="">--Select--</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="state" class="col-sm-3 control-label">City :
									<span style="color: red;">*</span>
								</label>
								<div class="col-sm-7">
									<select class="form-control inline"
										ng-model="ctl.selectedOptionCity"
										ng-options="option as option.cityName for option in ctl.cityStateList.list track by option.id"
										ng-change="ctl.form.data.cityId=ctl.selectedOptionCity.id;ctl.form.data.cityName=ctl.selectedOptionCity.cityName"
										required>
										<option value="">--Select--</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3" for="text">Address
									: <span style="color: red;">*</span>
								</label>
								<div class="col-sm-7">
									<textarea type="text" ng-model="ctl.form.data.companyAddress"
										class="form-control" placeholder="Enter Address" required ></textarea>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-3" for="text">Mobile
									No. : <span style="color: red;">*</span>
								</label>
								<div class="col-sm-4">
									<input type="text" class="form-control"
										ng-model="ctl.form.data.phoneNo" name="phoneNo"
										placeholder="Enter Mobile No." required />
								</div>
								<div class="col-sm-4">
									<input type="text" ng-model="ctl.form.data.phoneNo1"
										class="form-control" placeholder="Enter Mobile No." />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3" for="email">Primary
									E-mail : <span style="color: red;">*</span>
								</label>
								<div class="col-sm-7">
									<input type="email" ng-model="ctl.form.data.primaryEmail"
										class="form-control" placeholder="Enter Email Id" required />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3" for="email">Alternate
									E-mail : </label>
								<div class="col-sm-7">
									<input type="email" ng-model="ctl.form.data.alternateEmail"
										class="form-control" placeholder="Enter Alternate Email" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3" for="text">
									Website : </label>
								<div class="col-sm-7">
									<input type="text" placeholder="www.abc.com"
										ng-model="ctl.form.data.website" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3" for="bankName">PAN
									No. : <span style="color: red;">*</span>
								</label>
								<div class="col-sm-7">
									<input type="text" class="form-control"
										placeholder="Enter PAN No." class="input-xlarge"
										ng-model="ctl.form.data.panNo" required>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3" for="branchAddress">TIN
									No : <span style="color: red;">*</span>
								</label>
								<div class="col-sm-7">
									<input type="text" class="form-control"
										placeholder="Enter PAN No." class="input-xlarge"
										ng-model="ctl.form.data.tinNo" required>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<input type="submit" value="Save" class="btn btn-success">
						</div>
					</form>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
	</div>
</div>