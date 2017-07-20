<style type="text/css">
th {
	text-align: center;
	white-space: nowrap;
	white-space: nowrap !important;
	word-wrap: break-word;
}

h4, .h4 {
	margin-top: 8px;
}

.badge {
	background: red;
}

#mainModaltwo {
	width: 50%;
}

.colgreen {
	color: green;
}

.colred {
	color: red;
}

.column {
	display: table-cell;
}

.clock-bottom {
	float: left;
	width: 25%;
	font-weight: bold;
}

#Date {
	font-size: .875em;
	text-align: center;
	color:;
}
</style>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-12">
			<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-6">
					<div class="panel panel-success">
						<!-- Default panel contents -->
						<div class="panel-heading" style="height: 50px;">
							<div class="col-xs-5 col-sm-6 col-md-2">
								<img src="images/live.jpg" title="LIVE" class="img-rounded"
									title="" width="58" height="25">
							</div>
						</div>
						<!-- Table -->
						<div id="page-wrapper">
							<div ng-show="ctl.progress!=''">
								<div class="alert alert-danger" role="alert">
									<strong>{{ctl.progress}}</strong>
								</div>
							</div>
							<div class="table-responsive">
								<table class="table  table-striped table-hover"
									ng-show="ctl.homeLiveList.list.length>0">
									<thead class="text-uppercase">
										<tr>
											<th scope="row" align="center"><p style="width: -1px;"
													align="center">
													<img src="images/iconId.png" title="ID" class="img-rounded"
														title="" width="25" height="25">
												</p></th>
											<th><p style="width: -1px;">
													<img src="images/iconProduct.png" title="PRODUCT"
														class="img-rounded" title="" width="25" height="25">
												</p></th>
											<th><p style="width: -1px;">
													<img src="images/iconPackaging.jpg" title="PACKAGING"
														class="img-rounded" title="" width="25" height="25">
												</p></th>
											<th><p style="width: -1px;">
													<img src="images/quantityLogo.jpg"
														title="ORIGINAL QUANTITY" class="img-rounded" title=""
														width="25" height="25">
												</p></th>
											<th><p style="width: -1px;">
													<img src="images/quantityLogo.jpg"
														title="Available Quantity" class="img-rounded" title=""
														width="25" height="25">
												</p></th>
											<th><p style="width: -1px;">
													<img src="images/wonQuabtity.png" title="WON Quantity"
														class="img-rounded" title="" width="25" height="25">
												</p></th>
											<th><p style="width: -1px;">
													<img src="images/iconLocation.png" title="@STATE"
														class="img-rounded" title="" width="25" height="25">
												</p></th>
											<th><p style="width: -1px;">
													<img src="images/iconLocation.png" title="@CITY"
														class="img-rounded" title="" width="25" height="25">
												</p></th>
										</tr>
									</thead>
									<tbody>
										<tr
											ng-repeat="bid in ctl.homeLiveList.list  | orderBy:'timestamp':true">
											<td align="center" style="width: 50px;">{{bid.bidRefrenceNo}}</td>
											<td align="center" style="width: 50px;">{{bid.productName}}{{bid.bidId}}</td>
											<td align="center" style="width: 50px;">{{bid.packaging}}</td>
											<td align="center" style="width: 50px;">{{bid.remainingQuantity}}{{bid.unit}}</td>
											<td align="center" style="width: 50px;">{{bid.quantity}}
												{{bid.unit}}</td>
											<td align="center" style="width: 50px;"
												ng-show="bid.isRemainQuantity">{{bid.wonQuantity}}
												{{bid.unit}}</td>
											<td align="center" style="width: 50px;"
												ng-show="!bid.isRemainQuantity">--</td>
											<td align="center" style="width: 50px;">{{bid.stateName}}</td>
											<td align="center" style="width: 50px;">{{bid.cityName}}</td>

										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
