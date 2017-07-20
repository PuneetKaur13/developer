<style type="text/css">
th {
	text-align: center;
}

.table {
	height: 400px;
}

.grText {
	color: green;
}

.redText {
	color: red;
}

.orgText {
	color: #900C3F;
}
</style>
<div class="container">

	<div class="text-center">
		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-primary">
					<div class="panel-heading" style="background-color:#64b5f6">
						<h4 class="panel-title text-left">
							<b><a href="" target="_blank"
								style="text-decoration: none; color: white;">Count</a></b>
						</h4>
					</div>
					<div class="panel-body" style="overflow-x: auto;">
						<table class="table table-bordered table-striped table-hover"
							style="height: 100%;">
							<thead class="text-uppercase">
								<tr>
									<th>Total User</th>
									<th>Total Property</th>
									<th>For Sell</th>
									<th>For Buy</th>
									<th>For Rent</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>10</td>
									<td>{{ctl.dataList.list.length}}</td>
									<td>{{ctl.propertySellList.length}}</td>
									<td>{{ctl.propertyBuyList.length}}</td>
									<td>{{ctl.propertyRentList.length}}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="col-sm-4">
				<div class="panel panel-primary">
					<div class="panel-heading"style="background-color:#64b5f6">
						<h4 class="panel-title text-left">
							<b>Property for SELL</b>
						</h4>
					</div>
					<div class="panel-body" style="overflow-x: auto;">
						<table class="table table-bordered table-hover table-striped"
							fixed-header ng-show="ctl.propertySellList.length>0">
							<thead>
								<tr>
									<th>For</th>
									<th>Type</th>
									<th>City</th>
									<th>Price</th>
									<th>Owner Contact No</th>
								</tr>
							</thead>
							<tbody>
								<tr ng-repeat="bid in ctl.propertySellList ">
									<td>{{bid.propertyFor}}</td>
									<td>{{bid.propertyType}}</td>
									<td>{{bid.cityName}}</td>
									<td>{{bid.propertyPrice}}</td>
									<td>{{bid.ownerContactNo}}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>


			<div class="col-sm-4">
				<div class="panel panel-primary">
					<div class="panel-heading"style="background-color:#64b5f6">
						<h4 class="panel-title text-left">
							<b><a href="#/Order" target="_blank"
								style="text-decoration: none; color: white;"> <b>Property
										for BUY</b></a></b>
						</h4>
					</div>
					<div class="panel-body" style="overflow-x: auto;">
						<table class="table table-bordered table-hover table-striped"
							fixed-header ng-show="ctl.propertyBuyList.length>0">
							<thead>
								<tr>
									<th>For</th>
									<th>Type</th>
									<th>City</th>
									<th>Price</th>
									<th>Owner Contact No</th>
								</tr>
							</thead>
							<tbody>
								<tr ng-repeat="bid in ctl.propertyBuyList">
									<td>{{bid.propertyFor}}</td>
									<td>{{bid.propertyType}}</td>
									<td>{{bid.cityName}}</td>
									<td>{{bid.propertyPrice}}</td>
									<td>{{bid.ownerContactNo}}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="panel panel-primary">
					<div class="panel-heading"style="background-color:#64b5f6">
						<h4 class="panel-title text-left">
							<b><a target="_blank"
								style="text-decoration: none; color: white;"> <b>Property
										for RENT</b></a></b>
						</h4>
					</div>
					<div class="panel-body" style="overflow-x: auto;">
						<table class="table table-bordered table-hover table-striped"
							fixed-header ng-show="ctl.propertyRentList.length>0">
							<thead>
								<tr>
									<th>For</th>
									<th>Type</th>
									<th>City</th>
									<th>Price</th>
									<th>Owner Contact No</th>
								</tr>
							</thead>
							<tbody>
								<tr ng-repeat="bid in ctl.propertyRentList">
									<td>{{bid.propertyFor}}</td>
									<td>{{bid.propertyType}}</td>
									<td>{{bid.cityName}}</td>
									<td>{{bid.propertyPrice}}</td>
									<td>{{bid.ownerContactNo}}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
