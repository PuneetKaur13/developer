<style type="text/css">
th {
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
</style>

<div class="col-sm-12">
	<div class="panel panel-primary">
		<!-- Default panel contents -->
		<div class="panel-heading" style="height: 50px;background-color:#64b5f6" >
			<div class=" col-sm-12 col-md-8">
				<h4>Property</h4>
			</div>
			<div class="col-xs-2 col-sm-6 col-md-4" ng-show="ctl.button.go">
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
						class="btn btn-success btn-sm inline" id="Button6" name="command" style="background-color:#64b5f6"
						value="Previous" ng-click="ctl.previous()"><<</button>
					<button type="submit" ng-disabled="!ctl.button.next"
						class="btn btn-success btn-sm inline" id="Button7" name="command"style="background-color:#64b5f6"
						value="Next" ng-click="ctl.next()">>></button>
				</div>
			</div>
		</div>
		<!-- Table -->

		<div id="page-wrapper">
			<div ng-show="ctl.searchMessage!=null"
				ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}" >
				<strong>{{ctl.searchMessage}}</strong>
			</div>
			<div class="table-responsive">
				<table>
					<tr>
						<td><select class="form-control" style="width: 120px;"
							ng-model="ctl.searchData.propertyFor">
								<option value="">--For--</option>
								<option value="Rent">Rent</option>
								<option value="Sell">Sell</option>
								<option value="Buy">Buy</option>
								<option value="Sell Out">Sell Out</option>
						</select>
						<td>&nbsp;&nbsp;</td>
						<td><input type="text " style="width: 120px;"
							class="form-control text-capitalize"
							ng-model="ctl.searchData.propertyType" placeholder="Type"></td>
						<td>&nbsp;&nbsp;</td>
						<td><input type="text" style="width: 120px;"
							class="form-control" ng-model="ctl.searchData.propertyName"
							placeholder="Name"></td>
						<td>&nbsp;&nbsp;</td>
						<td><input type="text" style="width: 120px;"
							class="form-control text-capitalize"
							ng-model="ctl.searchData.propertyPrice" placeholder="Price"></td>
						<td>&nbsp;&nbsp;</td>
						<td><select class="form-control inline" style="width: 120px;"
							ng-model="ctl.searchData.stateId"
							ng-options="option.id as option.stateName for option in ctl.dataList.preload.stateList"
							ng-change="ctl.findCity(ctl.form.stateId)" required>
								<option value="">--State--</option>
						</select>
						<td>&nbsp;&nbsp;</td>
						<td><select class="form-control inline" style="width: 120px;"
							ng-model="ctl.searchData.cityId"
							ng-options="option.id as option.cityName for option in ctl.cityList  | orderBy:'cityName'">
								<option value="">--City--</option>
						</select>
						<td>&nbsp;&nbsp;</td>
						<td><input type="text" style="width: 120px;"
							class="form-control text-capitalize"
							ng-model="ctl.searchData.areaSqFeet" placeholder="Area Sq Feet"></td>
						<td>&nbsp;&nbsp;</td>
						<td><input type="text" style="width: 120px;"
							class="form-control" ng-model="ctl.searchData.address"
							placeholder="Address"></td>
						<td>&nbsp;&nbsp;</td>
						<td><input type="text" style="width: 120px;"
							class="form-control text-capitalize"
							ng-model="ctl.searchData.landmark" placeholder="Landmark"></td>
						<td>&nbsp;&nbsp;</td>
						<td><select class="form-control" style="width: 120px;"
							ng-model="ctl.searchData.bedrooms">
								<option value="">--Bedrooms--</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
						</select>
						<td>&nbsp;&nbsp;</td>
						<td><select class="form-control" style="width: 120px;"
							ng-model="ctl.searchData.bathrooms">
								<option value="">--Bathrooms--</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
						</select>
						<td>&nbsp;&nbsp;</td>
						<td><select class="form-control" style="width: 120px;"
							ng-model="ctl.searchData.balconies">
								<option value="">--Balconies--</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
						</select>
						<td>&nbsp;&nbsp;</td>
						<td><select class="form-control" style="width: 120px;"
							ng-model="ctl.searchData.floorNumber">
								<option value="">--FloorNo--</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
						</select>
						<td>&nbsp;&nbsp;</td>
						<td><select class="form-control" style="width: 120px;"
							ng-model="ctl.searchData.furnished">
								<option value="">--Furnished--</option>
								<option value="Furnished">Furnished</option>
								<option value="Un-Furnished">Un-Furnished</option>
								<option value="Semi-Furnished">Semi-Furnished</option>
						</select></td>
						<td style="text-align: left;">&emsp;<input type="submit"
							class="btn btn-success" style="background-color:#64b5f6"ng-click="ctl.search()" value="Search"></td>
					</tr>
				</table>
				<br>
				<table class="table table-bordered table-striped table-hover"
					ng-show="ctl.dataList.list.length>0">
					<thead class="text-uppercase">
						<tr>
							<th>#</th>
							<th>#</th>
							<th>#</th>
							<th>IMAGE</th>
							<th>Property Type</th>
							<th>Property For</th>
							<th>Property Name</th>
							<th>Property Price</th>
							<th>State</th>
							<th>City</th>
							<th>Pincode</th>
							<th>Area Sq feet</th>
							<th>Description</th>
							<th>Address</th>
							<th>Landmark</th>
							<th>Latitude</th>
							<th>Longitude</th>
							<th>Property Owner Name</th>
							<th>Property Owner Contact No</th>
							<th>Bedrooms</th>
							<th>Bathrooms</th>
							<th>Balconies</th>
							<th>Floor Number</th>
							<th>Furnished</th>
							<th>Total Floors</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="property in ctl.dataList.list">
							<td align="center"><input type="checkbox"
								checklist-model="ctl.checkedData.del"
								checklist-value="property.id"></td>
							<td align="center"><a href=""
								ng-click="ctl.display(property.id)" data-toggle="modal"
								data-target="#mainModal"><span
									class="glyphicon glyphicon-pencil"></span></a></td>
							<td align="center">{{$index+1}}</td>
							<td align="center"><img
								ng-src="/Rushhh/upload/{{property.imagePath}}"
								title="{{property.propertyName}}" id="mediaHere"
								class="img-rounded" style="max-width: 60px;"
								ng-show="property.imagePath!=''"> <img
								ng-src="/Rushhh/images/unknown.png"
								title="{{property.propertyName}}" id="mediaHere"
								class="img-rounded" style="max-width: 60px;"
								ng-show="user.imagePath==''"></td>
							<td align="center">{{property.propertyType}}</td>
							<td>{{property.propertyFor}}</td>
							<td>{{property.propertyName}}</td>
							<td>{{property.propertyPrice}}</td>
							<td>{{property.stateName}}</td>
							<td>{{property.cityName}}</td>
							<td>{{property.pincode}}</td>
							<td>{{property.areaSqFeet}}</td>
							<td>{{property.description}}</td>
							<td>{{property.address}}</td>
							<td>{{property.landmark}}</td>
							<td>{{property.latitude}}</td>
							<td>{{property.longitude}}</td>
							<td>{{property.ownerName}}</td>
							<td>{{property.ownerContactNo}}</td>
							<td>{{property.bedrooms}}</td>
							<td>{{property.bathrooms}}</td>
							<td>{{property.balconies}}</td>
							<td>{{property.floorNumber}}</td>
							<td>{{property.furnished}}</td>
							<td>{{property.totalFloors}}</td>
						</tr>
					</tbody>
				</table>
				<button type="button" class="btn btn-success" style="background-color:#64b5f6" data-toggle="modal"
					data-target="#mainModal" ng-click="ctl.display(0)">Add</button>
				<button type="button" class="btn btn-success" style="background-color:#64b5f6"
					ng-show="ctl.button.remove" ng-click="ctl.removeAll()">Delete</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="mainModal" tabindex="-1" role="dialog"aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="width: 60%">
		<div class="modal-content">
			<div class="modal-header " style="background-color:#64b5f6">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Add Property<id="mainModalLabel"></h4>
			</div>
			<form class="form-horizontal" role="form" ng-submit="ctl.submit()">
				<div class="modal-body">
					<div ng-show="ctl.message!=null"
						ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
						<!--  <strong>{{ctl.message}}</strong>-->
					</div>
					<div class="form-group">
						<label for="type" class="col-sm-2 control-label"> Property
							Type : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-3">
							<input type="text" ng-model="ctl.form.propertyType"
								class="form-control text-capitalize"
								placeholder="Enter Property Type" required>
						</div>
						<label class="control-label col-sm-2" for="text">Property
							For : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-3">
							<select class="form-control"  required ng-model="ctl.form.propertyFor">
								<option value="">--Select--</option>
								<option value="Rent">Rent</option>
								<option value="Sell">Sell</option>
								<option value="Buy">Buy</option>
								<option value="Sell Out">Sell Out</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="text">Property
							Name : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-3">
							<input style='width: 90%' type="text"
								ng-model="ctl.form.propertyName"
								class="form-control text-capitalize"
								placeholder="Enter Property Name" required />
						</div>
						<label class="control-label col-sm-2" for="text">Property
							Price : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-3">
							<input style='width: 90%' type="text" maxlength="15"
								ng-model="ctl.form.propertyPrice" ui-br-phone-number
								class="form-control"
								placeholder="Enter Property price" required />
						</div>
					</div>
					<div class="form-group">
						<label for="state" class="col-sm-2 control-label">State :
							<span style="color: red;">*</span>
						</label>
						<div class="col-sm-3">
							<select class="form-control inline" ng-model="ctl.form.stateId"
								ng-options="option.id as option.stateName for option in ctl.dataList.preload.stateList| orderBy:'stateName'"
								ng-change="ctl.findCity(ctl.form.stateId)" required>
								<option value="">--Select--</option>
							</select>
						</div>
						<label for="state" class="col-sm-2 control-label">City : <span
							style="color: red;">*</span>
						</label>
						<div class="col-sm-3">
							<select class="form-control inline" ng-model="ctl.form.cityId"
								ng-options="option.id as option.cityName for option in ctl.cityList  | orderBy:'cityName'">
								<option value="">--Select--</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="text">Pincode :
							<span style="color: red;">*</span>
						</label>
						<div class="col-sm-3">
							<input style='width: 90%' type="text" maxlength="7"
								ng-model="ctl.form.pincode" class="form-control" ui-br-phone-number
								placeholder="Enter Pincode" required />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-2" for="text">Area Sq
							Feet : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-3">
							<input style='width: 90%' type="text" maxlength="15"
								ng-model="ctl.form.areaSqFeet" ui-br-phone-number
								class="form-control text-capitalize"
								placeholder="Enter Area In Sq Feet" required />
						</div>
						<label class="control-label col-sm-2" for="text">Description
							: </label>
						<div class="col-sm-3">
							<input style='width: 90%' type="text"
								ng-model="ctl.form.description"
								class="form-control text-capitalize"
								placeholder="Enter Property Description" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="text">Address :
							<span style="color: red;">*</span>
						</label>
						<div class="col-sm-3">
							<input style='width: 90%' type="text" ng-model="ctl.form.address"
								class="form-control text-capitalize" placeholder="Enter Address"
								required />
						</div>
						<label class="control-label col-sm-2" for="text">Landmark
							: </label>
						<div class="col-sm-3">
							<input style='width: 90%' type="text"
								ng-model="ctl.form.landmark"
								class="form-control text-capitalize"
								placeholder="Enter Landmark" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="text">Latitude
							: </label>
						<div class="col-sm-3">
							<input style='width: 90%' type="text" maxlength="2"
								ng-model="ctl.form.latitude" ui-br-phone-number
								class="form-control text-capitalize"
								placeholder="Enter Latitude" />
						</div>
						<label class="control-label col-sm-2" for="text">Longitude
							: </label>
						<div class="col-sm-3">
							<input style='width: 90%' type="text" maxlength="2"
								ng-model="ctl.form.longitude" ui-br-phone-number
								class="form-control text-capitalize"
								placeholder="Enter Longitude" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="text">Property
							Owner Name : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-3">
							<input style='width: 90%' type="text"
								ng-model="ctl.form.ownerName"
								class="form-control text-capitalize"
								placeholder="Enter Owner Name" required />
						</div>
						<label class="control-label col-sm-2" for="text">Property
							Owner Contact No : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-3">
							<input style='width: 90%' type="text"
								ng-model="ctl.form.ownerContactNo" ui-br-phone-number
								class="form-control text-capitalize"
								placeholder="Enter Owner Contact No" required />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="text">Bedrooms
							: </label>
						<div class="col-sm-3">
							<select class="form-control" ng-model="ctl.form.bedrooms">
								<option value="">--Select--</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
						</div>
						<label class="control-label col-sm-2" for="text">Bathrooms
							: </label>
						<div class="col-sm-3">
							<select class="form-control" ng-model="ctl.form.bathrooms">
								<option value="">--Select--</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
						</div>

					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="text">Balconies
							: </label>
						<div class="col-sm-3">
							<select class="form-control" ng-model="ctl.form.balconies">
								<option value="">--Select--</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
						</div>
						<label class="control-label col-sm-2" for="text">Floor
							Number : </label>
						<div class="col-sm-3">
							<select class="form-control" ng-model="ctl.form.floorNumber">
								<option value="">--Select--</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="text">Furnished
							Status: </label>
						<div class="col-sm-3">
							<select class="form-control" ng-model="ctl.form.furnished">
								<option value="">--Select--</option>
								<option value="Furnished">Furnished</option>
								<option value="Un-Furnished">Un-Furnished</option>
								<option value="Semi-Furnished">Semi-Furnished</option>
							</select>
						</div>
						<label class="control-label col-sm-2" for="text"> Total
							Floors : </label>
						<div class="col-sm-3">
							<select class="form-control" ng-model="ctl.form.totalFloors">
								<option value="">--Select--</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="shortName" class="col-sm-2 control-label">Upload
							Image : </label>
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

