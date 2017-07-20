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

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-primary">
				<!-- Default panel contents -->
				<div class="panel-heading" style="height: 50px;">
					<div class="col-xs-5 col-sm-6 col-md-8">
						<h4>Sell Property</h4>
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
									ng-model="ctl.searchData.propertyName"
									placeholder="Search Property Name"></td>
								<td style="text-align: left;">&emsp;<input type="submit"
									class="btn btn-success" ng-click="ctl.search()" value="Search"></td>
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
							<!--  		<th>IMAGE></th> -->
									<th>Property Name</th>
									<th>Area Sq Feet</th>
									<th>State</th>
									<th>City</th> 
									<th>Pincode</th>
									<th>Status</th>
									<th>Property Price</th>
									<th>Price Per Sq Feet</th>
								</tr>
							</thead>
							<tbody>
								<tr ng-repeat="sellProperty in ctl.dataList.list">
									<td align="center"><input type="checkbox"
										checklist-model="ctl.checkedData.del"
										checklist-value="sellProperty.id"></td>
									<td align="center"><a href=""
										ng-click="ctl.display(sellProperty.id)" data-toggle="modal"
										data-target="#mainModal"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<td align="center">{{$index+1}}</td>
									<td align="center"><img
										ng-src="/Rushhh/upload/{{sellProperty.imagePath}}"
										title="{{sellProperty.propertyName}}" id="mediaHere"
										class="img-rounded" style="max-width: 60px;"
										ng-show="sellProperty.imagePath!=''"> <img
										ng-src="/Rushhh/images/unknown.png"
										title="{{sellProperty.propertyName}}" id="mediaHere"
										class="img-rounded" style="max-width: 60px;"
										ng-show="user.imagePath==''"></td>
									<td align="center">{{sellProperty.propertyName}}</td>
									<td>{{sellProperty.areaSqFeet}}</td>
									<td>{{sellProperty.stateName}}</td>
									<td>{{sellProperty.cityName}}</td> 
									<td>{{sellProperty.pincode}}</td>
									<td>{{sellProperty.propertyPrice}}</td>
									<td>{{sellProperty.pricePereSqFeet}}</td>
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
	<div class="modal-dialog" style="width: 60%">
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
						<label for="type" class="col-sm-2 control-label"> Property
							Name : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-3">
							<input type="text" ng-model="ctl.form.propertyName"
								class="form-control" placeholder="Enter Property Name ">
						</div>
						<label class="control-label col-sm-2" for="text">Area Sq Feet : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-3">
						<input type="text" ng-model="ctl.form.areaSqFeet" ui-br-phone-number
								class="form-control" placeholder="Enter Area Sq Feet ">
						</div>
					</div>
					<div class="form-group">
						<label for="state" class="col-sm-2 control-label">State :
							<span style="color: red;">*</span>
						</label>
						<div class="col-sm-3">
							<select class="form-control inline" ng-model="ctl.form.stateId"
								ng-options="option.id as option.stateName for option in ctl.dataList.preload.stateList"
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
						<label class="control-label col-sm-2" for="text">Address :
							<span style="color: red;">*</span>
						</label>
						<div class="col-sm-3">
							<input style='width: 90%' type="text" ng-model="ctl.form.address"
								class="form-control text-capitalize" placeholder="Enter Address"
								required />
						</div>
						<label class="control-label col-sm-2" for="text">Pincode :
							<span style="color: red;">*</span>
						</label>
						<div class="col-sm-3">
							<input style='width: 90%' type="text" ng-model="ctl.form.pincode" ui-br-phone-number
								ui-br-phone-number class="form-control text-capitalize"
								placeholder="Enter Pincode" required />
						</div>
					</div>
					

		 		<div class="form-group">
						<label class="control-label col-sm-2" for="text">Status : <span style="color: red;">*</span>
						</label>
							<div class="col-sm-3">
							<select class="form-control" ng-model="ctl.form.status">
								<option value="">--Select--</option>
								<option value="1">Ready To Move</option>
								<option value="2">Resale</option>
							</select>
						</div>
						<label class="control-label col-sm-2" for="text">Property Price
							: </label>
						<div class="col-sm-3">
							<input style='width: 90%' type="text"
								ng-model="ctl.form.propertyPrice" ui-br-phone-number
								class="form-control text-capitalize"
								placeholder="Enter Property price" />
						</div>
					</div>
		 			<div class="form-group">
						<label class="control-label col-sm-2" for="text">Price per Sq Feet :
							<span style="color: red;">*</span>
						</label>
						<div class="col-sm-3">
							<input style='width: 90%' type="text" ng-model="ctl.form.pricePerSqFeet" ui-br-phone-number
								class="form-control text-capitalize" placeholder="Enter Price per sq Feet"
								required />
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
