<style type="text/css">
th {

	white-space: nowrap;
}

td {

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
				<div class="panel-heading" style="height: 50px;">
					<div class="col-xs-5 col-sm-6 col-md-8">
						<h4>Company Master</h4>
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
					<div class="table-responsive">
						<table>
							<tr>
								<td><input type="text" class="form-control"
									ng-model="ctl.searchData.companyName"
									placeholder="Search Company Name"></td>
								<td>&nbsp;</td>
								<td><input type="text" class="form-control"
									ng-model="ctl.searchData.phoneNo" placeholder="Search Email"></td>
								<td>&nbsp;</td>
								<td><select class="form-control inline"
									ng-model="ctl.searchData.stateName"
									ng-options="option.stateName as option.stateName for option in ctl.dataList.preload.stateList | orderBy:'stateName'"
									"
									required>
										<option value="">--Select--</option>
								</select></td>
								<td>&nbsp;</td>
								<td><select class="form-control inline"
									ng-model="ctl.searchData.cityName"
									ng-options="option.cityName as option.cityName for option in ctl.dataList.preload.cityList | orderBy:'cityName'"">
										<option value="">--Select--</option>
								</select></td>
								<td style="text-align: left;">&emsp;<input type="submit"
									class="btn btn-success" ng-click="ctl.search()" value="Search"></td>
							</tr>
						</table>
						<br>
						<div ng-show="ctl.searchMessage!=null"
							ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
							<strong>{{ctl.searchMessage}}</strong>
						</div>
						<table class="table table-bordered table-striped table-hover"
							ng-show="ctl.dataList.list.length>0">
							<thead class="text-uppercase">
								<tr>
									<th>#</th>
									<th>#</th>
									<th>ID</th>
									<th>COMPANY NAME</th>
									<th>Admin</th>
									<th>State</th>
									<th>City</th>
									<th>MOBILE NO.</th>
									<th>EMAIL</th>
									<th>Users</th>
									<th>Plant information</th>
								</tr>
							</thead>
							<tbody>
								<tr ng-repeat="company in ctl.dataList.list">
									<td align="center"><input type="checkbox"
										checklist-model="ctl.checkedData.del"
										checklist-value="company.id"></td>
									<td align="center"><a href=""
										ng-click="ctl.display(company.id)" data-toggle="modal"
										data-target="#mainModal"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<td align="center">{{ctl.index+($index+1)}}</td>
									<td>{{company.companyName}}</td>
									<td>{{company.firstName}} {{company.lastName}}</td>
									<td>{{company.stateName}}</td>
									<td>{{company.cityName}}</td>
									<td>{{company.phoneNo}}</td>
									<td>{{company.primaryEmail}}</td>
									<td align="center"><a title="Information" href=""
										ng-click="ctl.companyUnder(company.groupId)"
										data-toggle="modal" data-target="#underUser"><span
											class="glyphicon glyphicon-info-sign"></span></a></td>
									<td align="center"><a title="Information" href=""
										ng-click="ctl.companyPlant(company.id)" data-toggle="modal"
										data-target="#PlantInformation"><span
											class="glyphicon glyphicon-ok"></span></a></td>
								</tr>
							</tbody>
						</table>
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
				<h4 class="modal-title" id="mainModalLabel"></h4>
			</div>
			<form class="form-horizontal" role="form" ng-submit="ctl.submit()">
				<div class="modal-body">
					<div ng-show="ctl.message!=null"
						ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
						<strong>{{ctl.message}}</strong>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="text">Contact
							Person </label>
						<div class="col-sm-4">
							<input style='width: 90%' type="text"
								ng-model="ctl.form.firstName" id="name" class="form-control"
								placeholder="Enter First Name" required />
						</div>
						<div class="col-sm-4">
							<input style='width: 90%' type="text"
								ng-model="ctl.form.lastName" id="name1" class="form-control"
								placeholder="Enter Last Name" required />
						</div>
					</div>
					<div class="form-group">
						<label for="shortName" class="col-sm-3 control-label">Company
							Logo : {{ctl.uploadForm.uploadMessage}}</label>
						<div class="col-sm-4">
							<div id="mediaHere" class="custom-preview"></div>
							<input accept="image/*" type="file"
								file-model="ctl.uploadForm.file" ng-model="ctl.uploadForm.file"
								preview-class="img-thumbnail" preview-container="mediaHere"
								media-preview ng-change="ctl.upload()">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="text">Designation/Job
							Title </label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.designation"
								class="form-control" placeholder="Enter Job/Title" required />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3" for="text">CEO Name
						</label>
						<div class="col-sm-4">
							<input style='width: 90%' type="text" ng-model="ctl.form.ceoName"
								id="namec" class="form-control" placeholder="Enter First Name"
								required />
						</div>
						<div class="col-sm-4">
							<input style='width: 90%' type="text" ng-model="ctl.form.ceoLast"
								id="namec1" class="form-control" placeholder="Enter Last Name"
								required />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="text">Company
							Name </label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.companyName"
								class="form-control" placeholder="Enter Company" required />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="text"> Mobile </label>
						<div class="col-sm-7">
							<input type="text" class="form-control"
								ng-model="ctl.form.phoneNo" name="phoneNo" ng-Minlength="10"
								ng-maxlength="10" placeholder="Enter contact no."
								ng-pattern="ctl.regex" />
							<div role="alert">
								<span style="color: red" class="error"
									ng-show="sciptform.$error.maxlength"> Mobile No. is Too
									long!</span>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="text">
							Alternate Mobile No.</label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.phoneNo1"
								class="form-control" placeholder="Enter contact no." />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3" for="email">Primary
							E-mail </label>
						<div class="col-sm-7">
							<input type="email" ng-model="ctl.form.primaryEmail"
								class="form-control" placeholder="Enter Email Id" required />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="email">Alternate
							E-mail </label>
						<div class="col-sm-7">
							<input type="email" ng-model="ctl.form.alternateEmail"
								class="form-control" placeholder="Enter Alternate Email" />
						</div>
					</div>
					<div class="form-group">
						<label for="state" class="col-sm-3 control-label">State :
							<span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<select class="form-control inline" ng-model="ctl.form.stateId"
								ng-options="option.id as option.stateName for option in ctl.dataList.preload.stateList | orderBy:'stateName'"
								ng-change="ctl.findCity(ctl.form.stateId)" required>
								<option value="">--Select--</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="state" class="col-sm-3 control-label">City : <span
							style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<select class="form-control inline" ng-model="ctl.form.cityId"
								ng-options="option.id as option.cityName for option in ctl.cityList  | orderBy:'cityName'">
								<option value="">--Select--</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="text"> Website
						</label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.website"
								class="form-control" placeholder="Enter Website" required />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="bankName">PAN
							No. :<span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<input type="text" class="form-control"
								placeholder="Enter PAN No." class="input-xlarge"
								ng-model="ctl.form.panNo" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="branchAddress">TIN
							No :<span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<input type="text" class="form-control"
								placeholder="Enter PAN No." class="input-xlarge"
								ng-model="ctl.form.tinNo" required>
						</div>
					</div>
				</div>

				<div class="modal-footer">
					<input type="submit" value="Save" class="btn btn-success">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- Under User List -->
<div class="modal fade" id="underUser" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-sm" style="width: 80%;">
		<div class="modal-content">
			<div class="modal-header modal-header-info">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 align="center" class="modal-title">User Tree</h4>
			</div>
			<form class="form-horizontal" role="form"
				ng-submit="ctl.addQuotation()">
				<div class="modal-body">
					<div ng-show="ctl.searchMessage!=null"
						ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
						<strong>{{ctl.searchMessage}}</strong>
					</div>
					<div id="page-wrapper" ng-show="ctl.companyUnderUserList.length>0">
						<div class="table-responsive">
							<table class="table table-bordered table-striped table-hover">
								<thead class="text-uppercase">
									<tr>
										<th>Company</th>
										<th>Name</th>
										<th>Email</th>
										<th>Mobile No</th>
										<th>Status</th>
										<th>Date & Time</th>
									</tr>
								</thead>
								<tbody>
									<tr ng-repeat="bid in ctl.companyUnderUserList">
										<td align="center">{{bid.groupIdString}}</td>
										<td align="center">{{bid.firstName}} {{bid.lastName}}</td>
										<td align="center">{{bid.loginId}}</td>
										<td align="center">{{bid.mobile}}</td>
										<td align="center">{{bid.status}}</td>
										<td align="center">{{ToJavaScriptDateTime(bid.createdDate)}}</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</form>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<!-- Plant Information -->
<div class="modal fade" id="PlantInformatio" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-sm" style="width: 80%;">
		<div class="modal-content">
			<div class="modal-header modal-header-info">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 align="center" class="modal-title">User Tree</h4>
			</div>
			<form class="form-horizontal" role="form"
				ng-submit="ctl.addQuotation()">
				<div class="modal-body">
					<div ng-show="ctl.searchMessage!=null"
						ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
						<strong>{{ctl.searchMessage}}</strong>
					</div>
					<div id="page-wrapper" ng-show="ctl.plantInformationList.length>0">
						<div class="table-responsive">

							<table class="table table-bordered">
								<thead class="text-uppercase">
									<tr>
										<th style="text-align: left;">Facility Status</th>
										<th>Choice</th>
										<th>Document</th>
									</tr>
								</thead>
								<tbody>
									<tr ng-repeat="bid in ctl.plantInformationList">
										<td><span>Freezing Type: <span style="color: red;">*</span></span>
										</td>
										<td align="center"><b>{{ctl.isNull(bid.iqf)}}</b> , <b>{{ctl.isNull(bid.ammoniaBlast)
												}},</b><b>{{ctl.isNull(bid.freonBlast)}}</b></td>
										<td style="text-align: center;">--</td>
									</tr>
									<tr ng-repeat="bid in ctl.plantInformationList">
										<td>Water Used : <span style="color: red;">*</span>
										</td>
										<td align="center"><b>{{ctl.isNull(bid.waterTreatmentFacility)}}</b>
											, <b>{{ctl.isNull(bid.corporation) }},</b><b>{{ctl.isNull(bid.openWell)}}</b></td>
										<td style="text-align: center;">--</td>
									</tr>

									<tr ng-repeat="bid in ctl.plantInformationList">
										<td>Water Treatment Facility : <span style="color: red;">*</span>
										</td>
										<td align="center">{{ctl.isNull(bid.waterTreatmentFacility)}}</td>
										<td style="text-align: center;">--</td>
									</tr>
									<tr ng-repeat="bid in ctl.plantInformationList">
										<td>Water Testing Frequency : <span style="color: red;">*</span>
										</td>
										<td align="center">{{ctl.isNull(bid.waterTestingFrequency)}}</td>
										<td style="text-align: center;">--</td>
									</tr>

									<tr ng-repeat="bid in ctl.plantInformationList">
										<td>Waste Disposal Facility: : <span style="color: red;">*</span>
										</td>
										<td align="center">{{ctl.isNull(bid.waterDesposalFacility)}}</td>
										<td style="text-align: center;">--</td>
									</tr>
									<tr ng-repeat="bid in ctl.plantInformationList">
										<td>Cold Storage Capacity : <span style="color: red;">*</span>
										</td>
										<td align="center">{{ctl.isNull(bid.coledStoarageCapacity)}}</td>
										<td align="center"><img
											ng-src="/OCBS/upload/{{bid.imagePath}}" title="{{user.name}}"
											id="mediaHere" class="img-rounded" style="max-width: 60px;"
											ng-show="user.imagePath!=''"> <img
											ng-src="/OCBS/images/unknown.png" id="mediaHere"
											class="img-rounded" style="max-width: 60px;"
											ng-show="user.imagePath==''"></td>
									</tr>
									<tr ng-repeat="bid in ctl.plantInformationList">
										<td>Cold Storage System : <span style="color: red;">*</span>
										</td>
										<td align="center">{{ctl.isNull(bid.racksystem)}},
											{{ctl.isNull(bid.openSystem)}}</td>
										<td style="text-align: center;">--</td>
									</tr>
									<tr ng-repeat="bid in ctl.plantInformationList">
										<td>In House Lab Facility : <span style="color: red;">*</span>
										</td>
										<td align="center">{{ctl.isNull(bid.labFacility)}}</td>
									</tr>
									<tr ng-repeat="bid in ctl.plantInformationList">
										<td>Frequency of Testing of Processed Material : <span
											style="color: red;">*</span>
										</td>
										<td align="center">{{ctl.isNull(bid.frequencyMaterial)}}</td>
										<td style="text-align: center;">--</td>
									</tr>

									<tr ng-repeat="bid in ctl.plantInformationList">
										<td>Power Backup Available : <span style="color: red;">*</span>
										</td>
										<td align="center">{{ctl.isNull(bid.powerBackupAvailable)}}</td>
										<td style="text-align: center;">--</td>
									</tr>
									<tr ng-repeat="bid in ctl.plantInformationList">
										<td>Import Export Certificate : <span style="color: red;">*</span>
										</td>
										<td align="center">{{ctl.isNull(bid.importExportCertificate)}}</td>
										<td style="text-align: center;">--</td>

									</tr>

									<tr ng-repeat="bid in ctl.plantInformationList">
										<td>Pollution Control Board Certificate : <span
											style="color: red;">*</span>
										</td>
										<td align="center">{{ctl.isNull(bid.pollutionControlBoardCertificate)}}</td>
										<td style="text-align: center;">--</td>
									</tr>

									<tr ng-repeat="bid in ctl.plantInformationList">
										<td>Type of Certifications : <span style="color: red;">*</span>
										</td>
										<td>
											<div class="row">
												<div class="col-sm-2">
													<label for="type" class="col-sm-5 control-label"><input
														type="checkbox" ng-true-value="'YES'"
														ng-model="ctl.form.iso9000">ISO 9000</label>
												</div>
												<div class="col-sm-2">
													<label for="type" class="col-sm-5 control-label"><input
														type="checkbox" ng-true-value="'YES'"
														ng-model="ctl.form.iso22000">ISO 22000</label>
												</div>
												<div class="col-sm-2">
													<label for="type" class="col-sm-5 control-label"><input
														type="checkbox" ng-true-value="'YES'"
														ng-model="ctl.form.gmp">GMP</label>
												</div>
												<div class="col-sm-2">
													<label for="type" class="col-sm-5 control-label"><input
														type="checkbox" ng-true-value="'YES'"
														ng-model="ctl.form.hakal">HALAL</label>
												</div>
												<div class="col-sm-2">
													<label for="type" class="col-sm-5 control-label"><input
														type="checkbox" ng-true-value="'YES'"
														ng-model="ctl.form.brc">BRC</label>
												</div>
												<div class="col-sm-2">
													<label for="type" class="col-sm-5 control-label"><input
														type="checkbox" ng-true-value="'YES'"
														ng-model="ctl.form.gmp">other</label>
												</div>
											</div>
										</td>
										<td><input type="file"></td>
									</tr>
									<tr ng-repeat="bid in ctl.plantInformationList">
										<td>Raw Matrial Area: <span style="color: red;">*</span>
										</td>
										<td align="center">{{ctl.isNull(bid.rawMaterial)}}</td>
										<td style="text-align: center;">--</td>
									</tr>
									<tr ng-repeat="bid in ctl.plantInformationList">
										<td>Raw Matrial Area: <span style="color: red;">*</span>
										</td>
										<td align="center">{{ctl.isNull(bid.rawMaterialDistrict)}}
											{{ctl.isNull(bid.rawMaterialCity)}}</td>
										<td style="text-align: center;">--</td>
									</tr>
								</tbody>
							</table>

						</div>
					</div>
				</div>
			</form>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>


<!-- Plant Information -->
<div class="modal fade" id="PlantInformation" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="mainModalLabel"></h4>
			</div>
			<form class="form-horizontal" role="form"
				ng-submit="ctl.updatePlantInfo()">
				<div ng-show="ctl.message!=null"
					ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
					<strong>{{ctl.message}}</strong>
				</div>
				<table class="table table-bordered">
					<thead class="text-uppercase">
						<tr>
							<th style="text-align: left;">Facility Status</th>
							<th>Choice</th>
							<th>Document</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><span>Freezing Type: <span style="color: red;">*</span></span>
							</td>

							<td>
								<div class="row">
									<div class="col-sm-4">
										<label for="type" class="control-label"><input
											type="checkbox" ng-true-value="'IQF'" ng-model="ctl.form.iqf">IQF</label>
									</div>
									<div class="col-sm-4">
										<label for="type" class="control-label"><input
											type="checkbox" ng-true-value="'Blast Frozen Amonia'"
											ng-model="ctl.form.ammoniaBlast">Blast Frozen Amonia</label>
									</div>
									<div class="col-sm-4">
										<label for="type" class="control-label"><input
											type="checkbox" ng-true-value="'Blast Frozen Freon'"
											ng-model="ctl.form.freonBlast">Blast Frozen Freon</label>
									</div>

								</div>
							</td>
							<td style="text-align: center;">--</td>
						</tr>
						<tr>
							<td>Water Used : <span style="color: red;">*</span>
							</td>
							<td>
								<div class="row">
									<div class="col-sm-4">
										<label for="type" class="control-label"><input
											type="checkbox" ng-true-value="'Bore Well'"
											ng-model="ctl.form.boreWell">Bore Well</label>
									</div>
									<div class="col-sm-4">
										<label for="type" class="control-label"><input
											type="checkbox" ng-true-value="'Corporation'"
											ng-model="ctl.form.corporation">Corporation</label>
									</div>
									<div class="col-sm-4">
										<label for="type" class="control-label"><input
											type="checkbox" ng-true-value="'Open Well'"
											ng-model="ctl.form.openWell">Open Well</label>
									</div>
								</div>
							</td>
							<td style="text-align: center;">--</td>
						</tr>

						<tr>
							<td>Water Treatment Facility : <span style="color: red;">*</span>
							</td>
							<td>
								<div class="row">
									<div class="col-sm-4">

										<label for="type" class="control-label"><input
											type="radio" value="YES"
											ng-model="ctl.form.waterTreatmentFacility">YES</label>
									</div>
									<div class="col-sm-4">
										<label for="type" class="control-label"><input
											type="radio" value="NO"
											ng-model="ctl.form.waterTreatmentFacility">NO</label>
									</div>
								</div>
							</td>
							<td style="text-align: center;">--</td>
						</tr>
						<tr>
							<td>Water Testing Frequency : <span style="color: red;">*</span>
							</td>
							<td>
								<div class="row">
									<div class="col-sm-4">
										<label for="type" class="control-label"><input
											type="radio" value="Quarterly"
											ng-model="ctl.form.waterTestingFrequency">Quarterly</label>
									</div>
									<div class="col-sm-4">
										<label for="type" class="control-label"><input
											type="radio" value="Half
												Yearly"
											ng-model="ctl.form.waterTestingFrequency">Half Yearly</label>
									</div>
									<div class="col-sm-4">
										<label for="type" class="control-label"><input
											type="radio" value="Yearly"
											ng-model="ctl.form.waterTestingFrequency">Yearly</label>
									</div>
								</div>
							</td>
							<td style="text-align: center;">--</td>
						</tr>

						<tr>
							<td>Waste Disposal Facility: : <span style="color: red;">*</span>
							</td>
							<td>
								<div class="row">
									<div class="col-sm-4">
										<label for="type" class="control-label"><input
											type="checkbox" ng-true-value="'Available'"
											ng-model="ctl.form.waterDesposalFacility">Available</label>
									</div>
									<div class="col-sm-4">
										<label for="type" class="control-label"><input
											type="checkbox" ng-true-value="'Not Available'"
											ng-model="ctl.form.waterDesposalFacility">Not
											Available</label>
									</div>
								</div>
							</td>
							<td style="text-align: center;">--</td>
						</tr>
						<tr>
							<td>Cold Storage Capacity : <span style="color: red;">*</span>
							</td>
							<td>
								<div class="row">
									<div class="col-sm-4">
										<label for="type" class="control-label"><input
											type="radio" value="Owned"
											ng-model="ctl.form.coledStoarageCapacity">Owned</label> <input
											type="text" ng-show="ctl.form.coledStoarageCapacity=='Owned'"
											ng-model="ctl.form.coledStoarageCapacityValue"
											placeholder="MT">
									</div>
									<div class="col-sm-4">
										<label for="type" class="control-label"><input
											type="radio" value="Rented"
											ng-model="ctl.form.coledStoarageCapacity">Rented</label> <input
											type="text"
											ng-show="ctl.form.coledStoarageCapacity=='Rented'"
											ng-model="ctl.form.coledStoarageCapacityValue"
											placeholder="MT">
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td>Cold Storage System : <span style="color: red;">*</span>
							</td>
							<td>
								<div class="row">
									<div class="col-sm-4">
										<label for="type" class="control-label"><input
											type="checkbox" ng-true-value="'Rack system'"
											ng-model="ctl.form.racksystem">Rack system</label> <br>
										<br> <br> <input
											ng-show="ctl.form.racksystem=='Rack system'" type="file">
									</div>
									<div class="col-sm-4">
										<label for="type" class="control-label"><input
											type="checkbox" ng-true-value="'Open System'"
											ng-model="ctl.form.openSystem">Open System</label> <br>
										<br> <br> <input
											ng-show="ctl.form.openSystem=='Open System'" type="file">
									</div>
								</div>
							</td>
							<td></td>
						</tr>
						<tr>
							<td>In House Lab Facility : <span style="color: red;">*</span>
							</td>
							<td>
								<div class="row">
									<div class="col-sm-4">
										<label for="type" class="control-label"><input
											type="radio" value="YES" ng-model="ctl.form.labFacility">YES</label>
									</div>
									<div class="col-sm-4">
										<label for="type" class=" control-label"><input
											type="radio" value="NO" ng-model="ctl.form.labFacility">NO</label>
									</div>
									<div class="col-sm-4">
										<label for="type" class="control-label"><input
											type="radio" value="Using Third Part Lab"
											ng-model="ctl.form.labFacility">Using Third Party Lab</label>
										<input ng-show="ctl.form.labFacility=='Using Third Part Lab'"
											type="text" ng-model="ctl.form.labFacilityName"
											placeholder="Lab Facility Name"> <input type="text"
											ng-show="ctl.form.labFacility=='Using Third Part Lab'"
											ng-model="ctl.form.labFacilityAddress"
											placeholder="Lab Facility Address">

									</div>
								</div>
							</td>
							<td style="text-align: center;">--</td>
						</tr>

						<tr>
							<td>Frequency of Testing of Processed Material : <span
								style="color: red;">*</span>
							</td>
							<td>
								<div class="row">
									<div class="col-sm-2">
										<label for="type" class="control-label"><input
											type="radio" value="Weekly"
											ng-model="ctl.form.frequencyMaterial">Weekly</label>
									</div>
									<div class="col-sm-2">
										<label for="type" class="control-label"><input
											type="radio" value="Monthly"
											ng-model="ctl.form.frequencyMaterial">Monthly</label>
									</div>
									<div class="col-sm-2">
										<label for="type" class="control-label"><input
											type="radio" value="Quarterly"
											ng-model="ctl.form.frequencyMaterial">Quarterly</label>
									</div>
									<div class="col-sm-2">
										<label for="type" class="control-label"><input
											type="radio" value="Yearly"
											ng-model="ctl.form.frequencyMaterial">Yearly</label>
									</div>
									<div class="col-sm-2">
										<label for="type" class="control-label"><input
											type="radio" value="As and When Required"
											ng-model="ctl.form.frequencyMaterial">As and When
											Required</label>
									</div>
									<div class="col-sm-2">
										<label for="type" class="control-label"><input
											type="radio" value="As Per Costumer Requirement"
											ng-model="ctl.form.frequencyMaterial">As Per Costumer
											Requirement</label>
									</div>
								</div>
							</td>
							<td style="text-align: center;">--</td>
						</tr>

						<tr>
							<td>Power Backup Available : <span style="color: red;">*</span>
							</td>
							<td>
								<div class="row">
									<div class="col-sm-4">
										<label for="type" class="control-label"><input
											type="radio" value="YES"
											ng-model="ctl.form.powerBackupAvailable">YES</label> <br>
										<br> <input type="file"
											ng-show="ctl.form.powerBackupAvailable=='YES'">
									</div>

									<div class="col-sm-4">
										<label for="type" class="control-label"><input
											type="radio" value="NO"
											ng-model="ctl.form.powerBackupAvailable">NO</label>
									</div>
								</div>
							</td>
							<td style="text-align: center;">--</td>
						</tr>
						<tr>
							<td>Import Export Certificate : <span style="color: red;">*</span>
							</td>
							<td>
								<div class="row">
									<div class="col-sm-4">
										<label for="type" class="control-label"><input
											type="radio" value="YES"
											ng-model="ctl.form.importExportCertificate">YES</label> <br>
										<br> <input
											ng-show="ctl.form.importExportCertificate=='YES'" type="file">
									</div>
									<div class="col-sm-4">
										<label for="type" class="control-label"><input
											type="radio" value="NO"
											ng-model="ctl.form.importExportCertificate">NO</label>
									</div>
								</div>
							</td>
							<td>--</td>

						</tr>

						<tr>
							<td>Pollution Control Board Certificate : <span
								style="color: red;">*</span>
							</td>
							<td>
								<div class="row">
									<div class="col-sm-4">
										<label for="type" class="control-label"><input
											type="radio" value="YES"
											ng-model="ctl.form.pollutionControlBoardCertificate">YES</label>
									</div>
									<div class="col-sm-4">
										<label for="type" class="control-label"><input
											type="radio" value="NO"
											ng-model="ctl.form.pollutionControlBoardCertificate">NO</label>
									</div>
								</div>
							</td>
							<td><input type="file"></td>
						</tr>

						<tr>
							<td>Type of Certifications : <span style="color: red;">*</span>
							</td>
							<td>
								<div class="row">
									<div class="col-sm-6">
										<label for="type" class="control-label"><input
											type="checkbox" ng-true-value="'YES'"
											ng-model="ctl.form.iso9000">ISO 9000</label>
									</div>
									<div class="col-sm-6">
										<input accept="image/*" type="file"
											file-model="ctl.uploadForm.file" id="fileUser"
											ng-model="ctl.uploadForm.file" preview-class="img-thumbnail"
											preview-container="mediaHere" media-preview
											ng-change="ctl.upload();">

									</div>
								</div>
								<div class="row">
									<div class="col-sm-6">
										<label for="type" class="control-label"><input
											type="checkbox" ng-true-value="'YES'"
											ng-model="ctl.form.iso22000">ISO 22000</label>
									</div>
									<div class="col-sm-6">
										<input accept="image/*" type="file"
											file-model="ctl.uploadForm.file" id="fileUser"
											ng-model="ctl.uploadForm.file" preview-class="img-thumbnail"
											preview-container="mediaHere" media-preview
											ng-change="ctl.upload();">
									</div>
								</div>
								<div class="row">
									<div class="col-sm-6">
										<label for="type" class="control-label"><input
											type="checkbox" ng-true-value="'YES'" ng-model="ctl.form.gmp">GMP</label>
									</div>
									<div class="col-sm-6">
										<input accept="image/*" type="file"
											file-model="ctl.uploadForm.file" id="fileUser"
											ng-model="ctl.uploadForm.file" preview-class="img-thumbnail"
											preview-container="mediaHere" media-preview
											ng-change="ctl.upload();">
									</div>
								</div>
								<div class="row">
									<div class="col-sm-6">
										<label for="type" class="control-label"><input
											type="checkbox" ng-true-value="'YES'"
											ng-model="ctl.form.hakal">HALAL</label>
									</div>
									<div class="col-sm-6">
										<input accept="image/*" type="file"
											file-model="ctl.uploadForm.file" id="fileUser"
											ng-model="ctl.uploadForm.file" preview-class="img-thumbnail"
											preview-container="mediaHere" media-preview
											ng-change="ctl.upload();">
									</div>
								</div>
								<div class="row">
									<div class="col-sm-6">
										<label for="type" class="control-label"><input
											type="checkbox" ng-true-value="'YES'" ng-model="ctl.form.brc">BRC</label>
									</div>
									<div class="col-sm-6">
										<input accept="image/*" type="file"
											file-model="ctl.uploadForm.file" id="fileUser"
											ng-model="ctl.uploadForm.file" preview-class="img-thumbnail"
											preview-container="mediaHere" media-preview
											ng-change="ctl.upload();">
									</div>
								</div>
								<div class="row">
									<div class="col-sm-6">
										<label for="type" class="control-label"><input
											type="checkbox" ng-true-value="'YES'"
											ng-model="ctl.form.haccp">HACCP</label>
									</div>
									<div class="col-sm-6">
										<input accept="image/*" type="file"
											file-model="ctl.uploadForm.file" id="fileUser"
											ng-model="ctl.uploadForm.file" preview-class="img-thumbnail"
											preview-container="mediaHere" media-preview
											ng-change="ctl.upload();">
									</div>
								</div>
								<div class="row">
									<div class="col-sm-2">
										<label for="type" class="control-label"><input
											type="checkbox" ng-true-value="'YES'"
											ng-model="ctl.form.other">Other</label>
									</div>
									<div class="col-sm-4" ng-show="ctl.form.other=='YES'">
										<input type="text" placeholder="Enter Name"
											ng-required="ctl.form.other=='YES'">
									</div>
									<div class="col-sm-3">
										<input ng-show="ctl.form.other=='YES'" accept="image/*"
											type="file" file-model="ctl.uploadForm.file" id="fileUser"
											ng-model="ctl.uploadForm.file" preview-class="img-thumbnail"
											preview-container="mediaHere" media-preview
											ng-change="ctl.upload();">
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td>Name Of Variety Of Raw Material Used: <span
								style="color: red;">*</span>
							</td>
							<td>
								<div class="col-sm-12">
									<input type="text" ng-model="ctl.form.rawMaterial" id="name"
										class="form-control text-capitalize"
										placeholder="Enter Raw Material Name" />
								</div>
							</td>
							<td style="text-align: center;">--</td>
						</tr>
						<tr>
							<td>Raw Matrial Procurement Area: <span style="color: red;">*</span>
							</td>
							<td>
								<div class="col-sm-6">
									<input style='width: 90%' type="text"
										ng-model="ctl.form.rawMaterialDistrict" id="name"
										class="form-control text-capitalize"
										placeholder="Enter Raw Material District" />
								</div>
								<div class="col-sm-6">
									<input type="text" ng-model="ctl.form.rawMaterialCity"
										id="name" class="form-control text-capitalize"
										placeholder="Enter Raw Material City" />
								</div>
							</td>
							<td style="text-align: center;">--</td>
						</tr>
					</tbody>
					<div class="pull-right">
						<input type="submit" value="Save" class="btn btn-success">
					</div>
				</table>

			</form>

		</div>
	</div>
</div>
<!-- /.modal-content -->
</div>
<!-- /.modal-dialog -->
</div>


<!-- Product Modal -->
<div class="modal fade" id="plantModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="ProductLabel"></h4>
			</div>
			<form class="form-horizontal" role="form"
				ng-submit="ctl.addProduct()">
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
						<label for="state" class="col-sm-4 control-label">Commodity
							: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<select class="form-control inline" ng-model="ctl.selectedOption"
								ng-options="option.name for option in ctl.productList.list track by option.id"
								ng-change="ctl.form.productId=ctl.selectedOption.id;ctl.form.productName=ctl.selectedOption.name;">
								<option value="">--Select--</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="state" class="col-sm-4 control-label">Register
							yourself as : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<select class="form-control" ng-model="ctl.form.productType"
								required>
								<option value="">--Select--</option>
								<option value="Seller">Seller</option>
								<option value="Buyer">Buyer</option>
								<option value="Both">Both</option>
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
