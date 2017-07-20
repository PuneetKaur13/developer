
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
	white-space: nowrap;
}
h4, .h4 {
	margin-top: 4px;
}
input[type="checkbox"] {
	margin: 0 10px 0 10px;
}
</style>

<script type="text/javascript">
	$().ready(
			function() {
				$('#add').click(
						function() {
							return !$('#select1 option:selected').remove()
									.appendTo('#select2');
						});
				$('#remove').click(
						function() {
							return !$('#select2 option:selected').remove()
									.appendTo('#select1');
						});
			});
</script>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
			<div class="panel panel-primary">
				<div class="panel-heading" style="background-color: #64b5f6">
					<h3 class="panel-title">Add Property</h3>
				</div>
				<!-- Table -->
				<div id="page-wrapper">
					<form class="form-horizontal" role="form" ng-submit="ctl.submit()">
						<div class="row">
							<div ng-show="ctl.progress!=''">
								<div ng-show="ctl.message!=null"
									ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
									<strong>{{ctl.message}}</strong>
								</div>
								<div class="form-group">
									<!-- <label for="type" class="col-sm-2 control-label">
										Property Type : <span style="color: red;">*</span>
									</label>
									<div class="col-sm-3">
										<input type="text" ng-model="ctl.form.propertyType"
											class="form-control text-capitalize"
											placeholder="Enter Property Type ">
									</div> -->


			
								 <label for="propertyType" class="col-sm-2 control-label">Property Type
										: <span style="color: red;">*</span>
									</label> 
									<div class="col-sm-3">
										<select class="form-control inline"
											ng-model="ctl.form.propertyTypeName"
											ng-options="option.id as option.value for option in ctl.dataList.preload.propertyTypeList"
											required >
											<option value="">Property Type</option>
										</select>
									</div>


							 
									 
								
								 <label for="propertyFor" class="col-sm-2 control-label">Property For
										: <span style="color: red;">*</span>
									</label> 
									<div class="col-sm-3">
										<select class="form-control inline"
											ng-model="ctl.form.propertyForName"
											ng-options="option.id as option.value for option in ctl.dataList.preload.propertyForList"
											
											required >
											<option value="">Property For</option>
										</select>
									</div>
								
								
								
								
							</div>
							<div class="form-group">
							    <label class="control-label col-sm-2" for="text">Property
										Price : 
									</label>
									<div class="col-sm-3">
										<input style='width: 100%' type="text" maxlength="15"
											ng-model="ctl.form.propertyPrice"
											class="form-control text-capitalize"
											placeholder="Enter Property price In Digits" ui-number-mask="0" required />
									</div>
								<!--	<label for="shortName" class="col-sm-2 control-label">Upload
									Image : </label>
								 <div class="col-sm-4">
									<img ng-src="/Rushhh/upload/{{ctl.form.imagePath}}"
										id="mediaHere" class="img-rounded" style="max-width: 150px;"
										ng-show="ctl.form.imagePath!=''"> <input
										accept="image/*" type="file" file-model="ctl.uploadForm.file"
										id="fileUser" ng-model="ctl.uploadForm.file"
										preview-class="img-thumbnail" preview-container="mediaHere"
										media-preview ng-change="ctl.upload();">
								</div> -->
							</div>
							
							 <div class="form-group">
									<label class="control-label col-sm-2" for="text">Unit Area
                                   : 
									</label> 											
									<div class="col-sm-3">
										<input 
											ng-model="ctl.form.areaSqFeet" class="form-control"
											placeholder="Enter Unit Area In Degits" ui-br-phone-number  required />
											<select class="form-control inline"
											ng-model="ctl.form.unitName"
											ng-options="option.unitName as option.unitName for option in ctl.dataList.preload.unitList| orderBy:'unitName'"
											 required>
											<option value="">Select Area Unit</option>
										</select>
                                   
                                   </div>
                                   
                                   		<label for="shortName" class="col-sm-2 control-label">Upload
									Image : </label>
								<div class="col-sm-4">
									<img ng-src="/Rushhh/upload/{{ctl.form.imagePath}}"
										id="mediaHere" class="img-rounded" style="max-width: 150px;"
										ng-show="ctl.form.imagePath!=''"> <input
										accept="image/*" type="file" file-model="ctl.uploadForm.file"
										id="fileUser" ng-model="ctl.uploadForm.file"
										preview-class="img-thumbnail" preview-container="mediaHere"
										media-preview ng-change="ctl.upload();">
								</div>
								
								
								
								
								
								<!--  <label for="state" class="col-sm-2 control-label">Unit
										: <span style="color: red;">*</span>
									</label> 
									<div class="col-sm-1">
										<select class="form-control inline"
											ng-model="ctl.form.unitName"
											ng-options="option.unitName as option.unitName for option in ctl.dataList.preload.unitList| orderBy:'unitName'"
											 required>
											<option value="">Unit</option>
										</select>
									</div>
								-->
						</div>
							
							
							<div class="form-group">
									<label for="state" class="col-sm-2 control-label">State
										:
									</label>
									<div class="col-sm-3">
										<select class="form-control inline"
											ng-model="ctl.form.stateId"
											ng-options="option.id as option.stateName for option in ctl.dataList.preload.stateList| orderBy:'stateName'"
											ng-change="ctl.findCity(ctl.form.stateId)" required>
											<option value="">State</option>
										</select>
									</div>
									<label for="state" class="col-sm-2 control-label">City
										:
									</label>
									<div class="col-sm-3">
										<select class="form-control inline" ng-model="ctl.form.cityId"
											ng-options="option.id as option.cityName for option in ctl.cityList  | orderBy:'cityName'">
											<option value="">Select</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									
									<label class="control-label col-sm-2" for="text">Email
										Id: 
									</label>
									<div class="col-sm-3">

										<input type="email" ng-model="ctl.form.emailId"
											class="form-control" placeholder="Enter Valid Email "
											required>
									</div>
									
								</div>
                                <div class="form-group">
									<label class="control-label col-sm-2" for="text">Address
										: 
									      </label>
									<div class="col-sm-3">
										<input 
											ng-model="ctl.form.address"
											class="form-control text-capitalize"
											placeholder="Enter Address" required />
									</div>
									<label class="control-label col-sm-2" for="text">Landmark
										: </label>
									<div class="col-sm-3">
										<input style='width: 100%' type="text"
											ng-model="ctl.form.landmark"
											class="form-control text-capitalize"
											placeholder="Enter Landmark" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2" for="text">Property
										Owner Name : 
									</label>
									<div class="col-sm-3">
										<input s
											ng-model="ctl.form.ownerName" class="form-control"
											placeholder="Enter Owner Name" required />
									</div>
									<label class="control-label col-sm-2" for="text">Property
										Owner Contact No : 
									</label>
									<div class="col-sm-3">
										<input 
											ng-model="ctl.form.ownerContactNo" ui-br-phone-number
											class="form-control" placeholder="Enter Owner Contact No"
											required />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2" for="text">Bedrooms
										: </label>
									<div class="col-sm-3">
										<select class="form-control" ng-model="ctl.form.bedrooms">
											<option value="">Bedrooms</option>
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
											<option value="">Bathrooms</option>
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
											<option value="">Balconies</option>
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
											<option value="">Floor</option>
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
											<option value="">Furnished</option>
											<option value="Furnished">Furnished</option>
											<option value="Un-Furnished">Un-Furnished</option>
											<option value="Semi-Furnished">Semi-Furnished</option>
										</select>
									</div>
									<label class="control-label col-sm-2" for="text"> Total
										Floors : </label>
									<div class="col-sm-3">
										<select class="form-control" ng-model="ctl.form.totalFloors">
											<option value="">Total</option>
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
										</select>
									</div>
								</div>
                                 	<div class="form-group">
									<label class="control-label col-sm-2" for="comment">
										Description: </label>
									<div class="col-sm-6">
										<textarea class="form-control" rows="1" id="comment"
											style="width: 543px; height: 194px;"
											ng-model="ctl.form.description"
											placeholder="Enter Property Description"></textarea>
									</div>
								</div>
			   			   </div>
					  </div>
					 <div class="form-group" align="center">
								
								<button type="submit" class="btn btn-success">
									<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
									Save
								</button>
							<a href="http://localhost:8080/Rushhh/#/Home">	<button type="close" class="btn btn-success">
									<span class="glyphicon glyphicon-remove-circle"
										aria-hidden="true"></span> Close </button> </a>
						  </div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>






