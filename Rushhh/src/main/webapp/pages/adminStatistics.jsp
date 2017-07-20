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

				<div class="panel-heading" style="height: 50px;">
					<div class="col-xs-5 col-sm-6 col-md-1">
						<h4>Reports</h4>
					</div>
					<div class="col-md-2">
						<select class="form-control" title="Product"
							ng-model="ctl.branch.productName"
							ng-options="option.name as option.name for option in ctl.productListReport.list track by option.id">
							<option value="">--Select Product--</option>
						</select>
					</div>
					<div class="col-md-2">
						<select class="form-control" title="Product"
							ng-model="ctl.branch.companyName"
							ng-options="option.companyName as option.companyName for option in ctl.companyList.list track by option.id">
							<option value="">--Select Company--</option>
						</select>
					</div>
					<div class="col-md-2">
						<select class="form-control" title="Product"
							ng-model="ctl.branch.stateName"
							ng-options="option.stateName as option.stateName for option in ctl.stateList.list track by option.id">
							<option value="">--Select State--</option>
						</select>
					</div>
					<div class="col-md-1">
						<select class="form-control" title="Product"
							ng-model="ctl.branch.cityName"
							ng-options="option.cityName as option.cityName for option in ctl.cityList.list track by option.id">
							<option value="">City</option>
						</select>
					</div>
					<div class=" col-md-1">
						<input type="submit" class="btn btn-success col-sm"
							ng-click="ctl.search()" value="Search" />
					</div>
					<div class="col-xs-7 col-sm-6 col-md-3"
						ng-show="ctl.statiSticsList.length>0">
						<div class="text-right">
							<label class="h4">PageNo:&nbsp;</label> <input type="hidden"
								ng-model="ctl.pageNo" /><select class="form-control"
								style="width: 74px; height: 31px; display: inline;"
								ng-model="ctl.pageNo"
								ng-options="page as page for page in ctl.statiSticsList.pageNoList">
							</select>
							<button type="submit" class="btn btn-success btn-sm" id="Button2"
								name="command" ng-click="ctl.go()" value="Go">Go</button>
							<button type="submit"
								ng-class="{'disabled':ctl.statiSticsList.disablePrevious==true}"
								ng-disabled="ctl.statiSticsList.disablePrevious==true"
								class="btn btn-success btn-sm inline" id="Button6"
								name="command" value="Previous" ng-click="ctl.previous()"><<</button>
							<button type="submit"
								ng-class="{'disabled':ctl.statiSticsList.disableNext==true}"
								ng-disabled="ctl.statiSticsListt.disableNext==true"
								class="btn btn-success btn-sm inline" id="Button7"
								name="command" value="Next" ng-click="ctl.next()">>></button>
						</div>
					</div>
				</div>
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
							fixed-header ng-show="ctl.statiSticsList.length>0">
							<thead class="text-uppercase">
								<tr>
									<th>Refrence No</th>
									<th>Company</th>
									<th>Product</th>
									<th>Packaging</th>
									<th>State</th>
									<th>City</th>
									<th>Quantity</th>
									<th>Status</th>
									<th>UNIT</th>
									<th>Start Date</th>
									<th>End Date</th>
								</tr>
							</thead>
							<tbody>
								<tr ng-repeat="bid in ctl.statiSticsList">
									<td>{{bid[0]}}</td>
									<td>{{bid[1]}}</td>
									<td>{{bid[2]}}</td>
									<td>{{bid[3]}}</td>
									<td>{{bid[4]}}</td>
									<td>{{bid[5]}}</td>
									<td>{{bid[6]}}</td>
									<td>{{bid[7]}}</td>
									<td>{{bid[8]}}</td>
									<td>{{ToJavaScriptDateTime(bid[9])}}</td>
									<td>{{ToJavaScriptDateTime(bid[10])}}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>