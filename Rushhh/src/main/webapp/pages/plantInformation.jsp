<%@page import="com.ncs.dto.CompanyDTO"%>
<%@page import="com.nenosystems.common.dto.UserContext"%>
<%@page import="com.ncs.dto.UserDTO"%>
<%
	UserContext ctx = (UserContext) session.getAttribute("ctx");
	UserDTO user = new UserDTO();
	if (ctx == null) {
		ctx = new UserContext();
	}
	user = (UserDTO) ctx.getBaseDTO();
	//String type = (String) session.getAttribute("type");
%>

<style type="text/css">
/* Put your css in here */
multiselect {
	display: block;
}

multiselect .btn {
	width: 100%;
	background-color: #FFF;
}

multiselect .btn.error {
	border: 1px solid #da4f49 !important;
}

multiselect .dropdown-menu {
	max-height: 300px;
	overflow-y: auto;
}

multiselect .dropdown-menu {
	width: 100%;
	box-sizing: border-box;
	padding: 2px;
}

multiselect .dropdown-menu>li>a {
	padding: 3px 10px;
	cursor: pointer;
}

th {
	text-align: center;
}

td {
	text-align: left;
}

h4, .h4 {
	margin-top: 4px;
}

label {
	white-space: normal;
	text-align: center;
}
</style>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-1"></div>
		<div class="col-sm-12">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Plant Information</h3>
				</div>
				<!-- Table -->
				<div id="page-wrapper">
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
													type="checkbox" ng-true-value="'IQF'"
													ng-model="ctl.form.iqf">IQF</label>
											</div>
											<div class="col-sm-4">
												<label for="type" class="control-label"><input
													type="checkbox" ng-true-value="'Blast Frozen Amonia'"
													ng-model="ctl.form.ammoniaBlast">Blast Frozen
													Amonia</label>
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
													ng-model="ctl.form.waterTestingFrequency">Half
													Yearly</label>
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
													type="text"
													ng-show="ctl.form.coledStoarageCapacity=='Owned'"
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
													ng-model="ctl.form.labFacility">Using
													Third Party Lab</label> <input
													ng-show="ctl.form.labFacility=='Using Third Part Lab'"
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
													ng-model="ctl.form.frequencyMaterial">As
													and When Required</label>
											</div>
											<div class="col-sm-2">
												<label for="type" class="control-label"><input
													type="radio" value="As Per Costumer Requirement"
													ng-model="ctl.form.frequencyMaterial">As
													Per Costumer Requirement</label>
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
													ng-show="ctl.form.importExportCertificate=='YES'"
													type="file">
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
													ng-model="ctl.uploadForm.file"
													preview-class="img-thumbnail" preview-container="mediaHere"
													media-preview ng-change="ctl.upload();">

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
													ng-model="ctl.uploadForm.file"
													preview-class="img-thumbnail" preview-container="mediaHere"
													media-preview ng-change="ctl.upload();">
											</div>
										</div>
										<div class="row">
											<div class="col-sm-6">
												<label for="type" class="control-label"><input
													type="checkbox" ng-true-value="'YES'"
													ng-model="ctl.form.gmp">GMP</label>
											</div>
											<div class="col-sm-6">
												<input accept="image/*" type="file"
													file-model="ctl.uploadForm.file" id="fileUser"
													ng-model="ctl.uploadForm.file"
													preview-class="img-thumbnail" preview-container="mediaHere"
													media-preview ng-change="ctl.upload();">
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
													ng-model="ctl.uploadForm.file"
													preview-class="img-thumbnail" preview-container="mediaHere"
													media-preview ng-change="ctl.upload();">
											</div>
										</div>
										<div class="row">
											<div class="col-sm-6">
												<label for="type" class="control-label"><input
													type="checkbox" ng-true-value="'YES'"
													ng-model="ctl.form.brc">BRC</label>
											</div>
											<div class="col-sm-6">
												<input accept="image/*" type="file"
													file-model="ctl.uploadForm.file" id="fileUser"
													ng-model="ctl.uploadForm.file"
													preview-class="img-thumbnail" preview-container="mediaHere"
													media-preview ng-change="ctl.upload();">
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
													ng-model="ctl.uploadForm.file"
													preview-class="img-thumbnail" preview-container="mediaHere"
													media-preview ng-change="ctl.upload();">
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
													ng-model="ctl.uploadForm.file"
													preview-class="img-thumbnail" preview-container="mediaHere"
													media-preview ng-change="ctl.upload();">
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
									<td>Raw Matrial Procurement Area: <span
										style="color: red;">*</span>
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
<div class="modal fade" id="productModal" tabindex="-1" role="dialog"
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
