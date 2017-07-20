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
				<div class="col-sm-6">
					<div class="panel panel-success">
						<!-- Default panel contents -->
						<div class="panel-heading" style="height: 50px;">
							<div class="col-xs-5 col-sm-6 col-md-2">
								<h4>Live Bids</h4>
							</div>
						</div>
						<!-- Table -->
						<div id="page-wrapper">
							<div ng-show="ctl.progress!=''">
								<div class="alert alert-danger" role="alert">
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
							<div class="table-responsive">
								<table class="table" ng-show="ctl.dataList.list.length>0">
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
											<th><p style="width: -1px;">
													<img src="images/live.jpg" title="LIVE" class="img-rounded"
														title="" width="58" height="25">
												</p></th>
										</tr>
									</thead>
									<tbody>
										<tr
											ng-repeat="bid in ctl.dataList.list  | orderBy:'timestamp':true"
											ng-class="{'alert-info':bid.id==ctl.selectedId}">
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
											<td align="center" style="width: 50px;"><span
												class="badge">{{bid.counter}}</span> <a
												title="View Quotation" href=""
												ng-click="ctl.viewUserQuotation(bid.productId,bid.cityId,bid.stateId,bid.packagingId); ctl.GetSelectedRow(bid.id);"
												data-target="#mainModaltwo"><span
													class="glyphicon glyphicon-eye-open"></span></a></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-6" id="mainModaltwo">
					<div class="panel panel-primary">
						<!-- Default panel contents -->
						<div class="panel-heading" style="height: 50px;">
							<div class="col-xs-5 col-sm-6 col-md-3">
								<h4>Selected Data</h4>
							</div>
						</div>
						<form class="form-horizontal" role="form"
							style="padding-top: 10px;">
							<div ng-show="ctl.viewUserQoutationList.list.length==0">
								<div class="alert alert-danger fade in">
									<strong>No Offer by any seller!</strong>
								</div>
							</div>
							<!-- Table -->
							<div id="page-wrapper"
								ng-show="ctl.viewUserQoutationList.list.length>0">
								<div class="table-responsive">
									<table
										class="table table-bordered table-striped table-hover span2">
										<thead class="text-uppercase">
											<tr>
												<th>COMPANY</th>
												<th>QUANTITY</th>
												<th>SELLER</th>
												<th>RATE</th>
												<th>RANK</th>
												<th>DATE & TIME</th>
												<th>ACTION</th>
												<th>History</th>
												<th>Counter Offer</th>

											</tr>
										</thead>
										<tbody>
											<tr
												ng-repeat="bid in ctl.viewUserQoutationList.list | orderBy:'timestamp':true">
												<td align="center">{{bid.companyName}}</td>
												<td align="center">{{bid.quantity}} {{bid.unit}}</td>
												<td align="center">{{bid.buyerName}}</td>
												<td align="center">{{bid.quotationAmount}}</td>
												<td align="center">{{bid.rank}}</td>
												<td align="center">{{bid.timestamp |date:'dd-MM-yyyy
													h:mma'}}</td>
												<td align="center">
													<button type="button" class="btn btn-success btn-xs"
														ng-click="ctl.acceptBid(bid)" ng-show="bid.active">Accept
														Bid</button> <label for="Latitude" ng-hide="bid.active"
													ng-class="{colgreen:bid.status=='WON',colred:bid.status=='LOST'}">{{bid.status}}</label>
												</td>
												<td align="center"><a title="History" href=""
													ng-click="ctl.viewHistory(bid.productId,bid.buyerId,bid.packagingId,bid.stateId,bid.cityId)"
													data-toggle="modal" data-target="#mainModalHistory"><span
														class="glyphicon glyphicon-open-file"></span></a></td>
												<td align="center" style="width: 1px"><a href=""
													ng-click="ctl.getBidCounterId(bid)" data-toggle="modal"
													data-target="#counterModel"
													ng-show="bid.status != 'WON' && bid.status != 'LOST'">
														<span class="glyphicon glyphicon-upload"></span>
												</a>
													<p ng-show="bid.status == 'WON' || bid.status == 'LOST'">--</p>
												</td>

											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!--View Quatation -->

<!-- Counter Offer -->
<div class="modal fade" id="counterModel" tabindex="-1" role="dialog"
	aria-labelledby="" aria-hidden="true">
	<div class="modal-dialog" style="width: 40%;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Add Counter Offer</h4>
			</div>
			<form class="form-horizontal" role="form"
				ng-submit="ctl.addCounterOffer()">
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
						<label for="unit" class="col-sm-3 control-label"> Unit : </label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.unit" class="form-control"
								readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<label for="Quantity" class="col-sm-3 control-label">Offer
							Quantity : </label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.quantity"
								class="form-control" placeholder="Enter Amount"
								readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<label for="CounterOffer" class="col-sm-3 control-label">Offer
							Rate By Seller : </label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.quotationAmount"
								class="form-control" placeholder="Enter Amount"
								readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<label for="CounterOffer" class="col-sm-3 control-label">Your
							Counter Quantity : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.counterQuantity"
								class="form-control" placeholder="Enter Counter Quantity"
								required="required">
						</div>
					</div>
					<div class="form-group">
						<label for="CounterOffer" class="col-sm-3 control-label">Your
							Rate : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.counterAmount"
								class="form-control" placeholder="Enter Counter Amount"
								required="required">
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<input type="submit" value="Save" class="btn btn-success">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!--History -->
<div class="modal fade" id="mainModalHistory" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="width: 100%">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Seller History</h4>
			</div>
			<form class="form-horizontal" role="form"
				ng-submit="ctl.addQuotation()">
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
					<!-- Table -->
					<div id="page-wrapper" ng-show="ctl.viewHistoryList.list.length>0">
						<div class="table-responsive">
							<table class="table table-bordered table-striped table-hover">
								<thead class="text-uppercase">
									<tr>
										<th style="background-color: #696969;">#</th>
										<th style="background-color: #696969">Offer By Seller</th>
										<th style="background-color: #696969">QUANTITY IN MT</th>
										<th style="background-color: #696969;">RATE/KG</th>
										<th style="background-color: #696969;">Date & Time</th>
										<th style="background-color: #696969;">Counter Offer By
											You</th>
										<th style="background-color: #696969;">Counter Offered
											Quantity</th>
										<th style="background-color: #696969;">Counter Rates</th>
										<th style="background-color: #696969;">offer Status</th>
										<th style="background-color: #696969;">Date & Time</th>
								</thead>
								<tbody>
									<tr
										ng-repeat="bid in ctl.viewHistoryList.list | orderBy:'timestamp':true">
										<td align="center"
											style="background-color: black;; font-weight: bold; color: #FFFFFF;">{{ctl.viewHistoryList.list.length-$index}}</td>
										<td
											style="background-color: #187f06; font-weight: bold; color: #FFFFFF;"
											align="center">{{bid.offerBy}}</td>
										<td
											style="background-color: #187f06; font-weight: bold; color: #FFFFFF;"
											align="center">{{bid.quantity}} {{bid.unit}}</td>
										<td
											style="background-color: #187f06; font-weight: bold; color: #FFFFFF;"
											align="center">{{bid.quotationAmount}}</td>
										<td
											style="background-color: #187f06; font-weight: bold; color: #FFFFFF;"
											align="center">{{bid.createdDate | date:'MM/dd/yyyy
											h:mma'}}</td>
										<td
											style="background-color: #357AE8; font-weight: bold; color: #FFFFFF;"
											align="center">{{bid.offerByBuyer}}</td>
										<td
											style="background-color: #357AE8; font-weight: bold; color: #FFFFFF;"
											align="center">{{bid.counterQuantity}}</td>
										<td
											style="background-color: #357AE8; font-weight: bold; color: #FFFFFF;"
											align="center">{{bid.counterAmount}}</td>
										<td
											style="background-color: #357AE8; font-weight: bold; color: #FFFFFF;"
											align="center">{{bid.status}}</td>
										<td
											style="background-color: #357AE8; font-weight: bold; color: #FFFFFF;"
											align="center">{{bid.counterDate | date:'MM/dd/yyyy
											h:mma'}}</td>
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