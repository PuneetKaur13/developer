<style type="text/css">
th {
	text-align: center;
	white-space: pre-wrap;
}

h4, .h4 {
	margin-top: 4px;
}

.modal-dialog {
	margin: 30px auto;
	width: 80%;
}

.colgreen {
	color: green;
}

.colred {
	color: red;
}

.nav-tabs>li.active>a, .nav-tabs>li.active>a:hover, .nav-tabs>li.active>a:focus
	{
	color: black;
	background-color: #357AE8;
}
</style>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-primary">
				<!-- Default panel contents -->
				<div class="panel-heading"
					style="height: 50px; background-color: #357AE8;">
					<div class="col-sm-6">
						<h4>My Requirements</h4>
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
									ng-model="ctl.searchData.bidRefrenceNo"
									placeholder="Search Bid Refrence No"></td>
								<td>&nbsp;&nbsp;</td>
								<td><select class="form-control inline"
									ng-model="ctl.searchData.productName"
									ng-options="option.name as option.name for option in ctl.dataList.preload.productList"
									ng-change="ctl.findPackaging(ctl.searchData.productId)"
									required>
										<option value="">--Select--</option>
								</select></td>
								<td>&nbsp;&nbsp;</td>
								<td><select class="form-control inline"
									ng-model="ctl.searchData.packaging"
									ng-options="option.pacakging as option.packaging for option in ctl.dataList.preload.packagingList">
										<option value="">--Select--</option>
								</select></td>
								<td>&nbsp;&nbsp;</td>
								<td><select class="form-control inline"
									ng-model="ctl.searchData.stateName"
									ng-options="option.stateName as option.stateName for option in ctl.dataList.preload.stateList"
									ng-change="ctl.findCity(ctl.searchData.stateId)" required>
										<option value="">--Select--</option>
								</select></td>

								<td>&nbsp;&nbsp;</td>
								<td><select class="form-control inline"
									ng-model="ctl.searchData.cityName"
									ng-options="option.cityName as option.cityName for option in ctl.dataList.preload.cityList">
										<option value="">--Select--</option>
								</select></td>
								<td>&nbsp;&nbsp;</td>
								<td><select class="form-control"
									ng-model="ctl.searchData.status"
									ng-options="grade as grade for grade in ['ACTIVE','DEACTIVE','ABOUT TO OPEN','CLOSED']"
									required>
										<option value="">--Select--</option>
								</select></td>
								<td>&nbsp;&nbsp;</td>
								<td style="text-align: left;">&emsp;<input type="submit"
									class="btn btn-success" ng-click="ctl.search()" value="Search"></td>
							</tr>
						</table>
						<br>
						<div ng-show="ctl.searchMessage!=null"
							ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
							<strong>{{ctl.searchMessage}}</strong>
						</div>
						<br>
						<table class="table table-bordered"
							ng-show="ctl.dataList.list.length>0">
							<thead class="text-uppercase">
								<tr>
									<th>#</th>
									<th>#</th>
									<th>#</th>
									<th>Bid Ref.No.</th>
									<th>Commodity</th>
									<th>Packaging</th>
									<th>Original Quantity</th>
									<th>Quantity Available For Bid</th>
									<th>WON QUANTITY</th>
									<th>Freezing Type</th>
									<th>START DATE</th>
									<th>END DATE</th>
									<th>OTHER INFORMATION</th>
									<th>STATUS</th>
									<th>ACTION</th>
								</tr>
							</thead>
							<tbody>
								<tr
									ng-repeat="bid in ctl.dataList.list | orderBy:'timestamp':true "
									ng-class="{'bg-success':bid.status=='ACTIVE' , 'bg-danger':bid.status=='ABOUT TO OPEN'}">
									<td align="center"><input type="checkbox"
										checklist-model="ctl.checkedData.del" checklist-value="bid.id"></td>
									<td align="center"><a href=""
										ng-click="ctl.display(bid.id)" data-toggle="modal"
										data-target="#mainModal"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<td align="center">{{$index+1}}</td>
									<td align="center">{{bid.bidRefrenceNo}}</td>
									<td align="center">{{bid.productName}} {{bid.bidId}}</td>
									<!-- 	<td align="center">{{bid.companyName}}</td> -->
									<td align="center">{{bid.packaging}}</td>
									<td align="center">{{bid.remainingQuantity}} {{bid.unit}}</td>
									<!-- 	<td align="center">{{bid.expectedAmount}}</td> -->
									<td align="center">{{bid.quantity}} {{bid.unit}}</td>
									<td align="center" ng-show="bid.isRemainQuantity">{{bid.wonQuantity}}
										{{bid.unit}}</td>
									<td align="center" ng-show="!bid.isRemainQuantity">--</td>
									<td align="center">{{bid.freezingType}}</td>
									<td align="center">{{bid.startDate |date : 'dd-MM-yyyy'}}</td>
									<td align="center">{{bid.enddate |date : 'dd-MM-yyyy'}}</td>
									<td align="center"><a title="Information" href=""
										ng-click="ctl.viewInformation(bid.id)" data-toggle="modal"
										data-target="#mainModalInfo"><span
											class="glyphicon glyphicon-info-sign"></span></a> &nbsp;<a
										title="Invited Seller" href=""
										ng-click="ctl.viewAcceptUser(bid.id)" data-toggle="modal"
										data-target="#mainModalViewUser"><span
											class="glyphicon glyphicon-upload"></span></a></td>

									<td align="center"><img src="images/{{bid.status}}.png"
										class="img-rounded" title="{{bid.status}}" width="25"
										height="25" ng-show="bid.status!=null"></td>
									<td align="center">
										<p
											ng-hide="bid.status=='ACTIVE' ||bid.status=='CLOSED'|| !bid.isVisit "
											ng-show="bid.isVisit" style="color: green">
											<b>Request Sent</b>
										</p>
										<p ng-show="bid.status=='ACTIVE'" style="color: green">
											<b>Bid Open</b>
										<p ng-show="bid.status=='CLOSED'" style="color: green">
											<b>Bid CLOSED</b>
									</td>
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
<!-- Modal Box -->
<div class="modal fade" id="mainModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="width: 60%;">
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
						<label for="state" class="col-sm-2 control-label">Commodity
							: <span style="color: red;">*</span>
						</label>

						<div class="col-sm-4">
							<select class="form-control inline" ng-model="ctl.form.productId"
								ng-options="option.id as option.name for option in ctl.dataList.preload.productList"
								ng-change="ctl.findPackaging(ctl.form.productId);ctl.findByUserFavouriteProduct(ctl.form.productId)"
								required>
								<option value="">--Select--</option>
							</select>
						</div>
						<label for="state" class="col-sm-2 control-label">Packaging
							Required : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<select class="form-control inline"
								ng-model="ctl.form.packagingId"
								ng-options="option.id as option.packaging for option in ctl.packagingList">
								<option value="">--Select--</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="user" class="col-sm-2 control-label"
							data-content="Must be at least 3 characters long, and must only contain letters.">Quantity
							: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<input type="text" ng-model="ctl.form.quantity"
								class="form-control" placeholder="Enter Quantity" required
								quantity>
						</div>
						<label for="unit" class="col-sm-2 control-label"> Unit : <span
							style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<select class="form-control" ng-model="ctl.form.unit"
								title="Search By Status" readonly>
								<option selected="selected">MT</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="startDate" class="col-sm-2 control-label">Start
							Date :<span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<datepicker date-format="dd-MM-yyyy"
								date-min-limit="{{ctl.min.startDate}}"> <input
								type="text" class="form-control" ng-model="ctl.form.startDate"
								required placeholder="DD-MM-YYYY" readonly="readonly" /> </datepicker>
						</div>
						<label for="enddate" class="col-sm-2 control-label">Valid
							Till : <span style="color: red;">*</span>
						</label>

						<div class="col-sm-4">
							<datepicker date-format="dd-MM-yyyy"
								date-min-limit="{{ctl.valid.enddate}}"> <input
								type="text" class="form-control" ng-model="ctl.form.enddate"
								required placeholder="DD-MM-YYYY" readonly="readonly" /> </datepicker>
						</div>
					</div>
					<div class="form-group">

						<label for="expectedDeliveryDate" class="col-sm-2 control-label">Expected
							Delivery Date<span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<datepicker date-format="dd-MM-yyyy"
								date-min-limit="{{ctl.exp.expectedDeliveryDate}}">
							<input type="text" class="form-control" required
								ng-model="ctl.form.expectedDeliveryDate"
								placeholder="DD-MM-YYYY" /> </datepicker>
						</div>
					</div>
					<div class="form-group" name="myForm">
						<label for="user" class="col-sm-2 control-label">Freezing
							Type: : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-8">
							<label for="type" class="col-sm-2 control-label"><input
								type="radio" value="IQF" ng-model="ctl.form.freezingType"
								ng-required="!ctl.form.freezingType">IQF</label> <label
								for="type" class="col-sm-5 control-label"><input
								type="radio" value="Blast Frozen Amonia"
								ng-model="ctl.form.freezingType"
								ng-required="!ctl.form.freezingType">Blast Frozen Amonia</label>
							<label for="type" class="col-sm-4 control-label"><input
								type="radio" value="Blast Frozen Freon"
								ng-model="ctl.form.freezingType"
								ng-required="!ctl.form.freezingType">Blast Frozen Freon</label>
						</div>
					</div>
					<div class="form-group">
						<hr />
						<div class="col-sm-4">
							<p>
								<b>Material Required At Location: </b>
							</p>
						</div>
					</div>
					<div class="form-group">
						<label for="state" class="col-sm-2 control-label">State :
							<span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<select class="form-control inline" ng-model="ctl.form.stateId"
								ng-options="option.id as option.stateName for option in ctl.dataList.preload.stateList"
								ng-change="ctl.findCity(ctl.form.stateId)" required>
								<option value="">--Select--</option>
							</select>
						</div>
						<label for="state" class="col-sm-2 control-label">City : <span
							style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<select class="form-control inline" ng-model="ctl.form.cityId"
								ng-options="option.id as option.cityName for option in ctl.cityList">
								<option value="">--Select--</option>
							</select>
						</div>
					</div>


					<div class="form-group">
						<hr />
						<div class="col-sm-4">
							<span><b>Additional Services Required: </b></span>
						</div>
					</div>
					<div class="form-group">
						<label for="transportation" class="col-sm-2 control-label">
							Transportation: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4 radio">
							<label for="type" class="col-sm-5 control-label"><input
								type="radio" value="YES" ng-model="ctl.form.transportation"
								ng-required="!ctl.form.transportation"><b>YES</b></label> <label
								for="type" class="col-sm-6 control-label"><input
								type="radio" value="NO" ng-model="ctl.form.transportation"
								ng-required="!ctl.form.transportation"><b>NO</b></label>
						</div>
						<label for="transportation" class="col-sm-2 control-label">
							Insurance: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4 radio">
							<label for="type" class="col-sm-5 control-label"><input
								type="radio" value="YES" ng-model="ctl.form.insurance"
								ng-required="!ctl.form.insurance"><b>YES</b></label> <label
								for="type" class="col-sm-6 control-label"><input
								type="radio" value="NO" ng-model="ctl.form.insurance"
								ng-required="!ctl.form.insurance"><b>NO</b></label>
						</div>
					</div>
					<div class="form-group">
						<label for="insurance" class="col-sm-2 control-label">
							Third Party Inspection <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4 radio">
							<label for="type" class="col-sm-5 control-label"><input
								type="radio" value="YES"
								ng-model="ctl.form.thirdPartyInspection"
								ng-required="!ctl.form.thirdPartyInspection"><b>YES</b></label>
							<label for="type" class="col-sm-6 control-label"><input
								type="radio" value="NO" ng-model="ctl.form.thirdPartyInspection"
								ng-required="!ctl.form.thirdPartyInspection"><b>NO</b></label>
						</div>
					</div>
					<div class="form-group">
						<hr />
						<div class="col-sm-4">
							<span><b>Select Your Seller For Bid </b></span>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-12">
							<input type="checkbox" ng-true-value="'YES'"
								data-toggle="collapse"
								ng-disabled="ctl.form.checkValueAllSellers=='all'"
								ng-hide="ctl.form.productId==null" ng-false-value="'NO'"
								ng-required="ctl.form.checkValueAllSellers=='noAll'"
								data-target="#mainModalFavouriteList"
								ng-click="ctl.findByUserFavouriteProduct(ctl.form.productId)"
								ng-model="ctl.form.checkValue">
							<button type="button" data-parent="#accordion"
								class="btn btn-success btn-xs"
								ng-hide="ctl.form.productId==null">Favourite Sellrs</button>
							&nbsp; &nbsp; &nbsp; <input type="checkbox"
								ng-hide="ctl.form.productId==null"
								ng-model="ctl.form.checkValueAllSellers" ng-true-value="'all'"
								ng-false-value="'noAll'" data-toggle="collapse"
								ng-click="ctl.findByUserProduct(ctl.form.productId)"
								data-target="#mainModalAllSellers"
								ng-disabled="ctl.form.checkValue=='YES'">


							<button data-parent="#accordion" type="button"
								class="btn btn-primary btn-xs"
								ng-disabled="ctl.form.checkValue=='noAll'"
								ng-hide="ctl.form.productId==null">All Sellrs</button>
						</div>
					</div>
					<div class="collapse" id="mainModalFavouriteList"
						class="form-group">
						<!-- Table -->
						<div id="page-wrapper" ng-show="ctl.favouriteProductList.length>0">
							<div class="table-responsive">
								<table class="table table-bordered table-striped table-hover">

									<thead class="text-uppercase">
										<tr>
											<th>Sellers</th>
											<th>Commodity</th>
										</tr>
									</thead>
									<tbody>
										<tr ng-repeat="bid in ctl.favouriteProductList">
											<td align="center">{{bid.favCompanyName}}</td>
											<td align="center">{{bid.productName}}</td>
										</tr>
									</tbody>
								</table>
							</div>
							<strong style="color: red">Do You Want To Modify Your
								Favourite List</strong><a ng-click="ctl.sellSupplier()"> ClickHere</a>
						</div>
					</div>
					<!--View All Sellers List -->
					<div class="form-group"
						ng-show="ctl.form.checkValueAllSellers=='all'">
						<div id="page-wrapper" ng-show="ctl.userProductList.length>0">
							<div class="table-responsive">
								<br />
								<table class="table table-bordered table-striped table-hover">
									<thead class="text-uppercase">
										<tr>
											<th><input type="checkbox" ng-model="isCheckAll"
												ng-click="SelectAll(isCheckAll)" />SelectAll</th>
											<th>Sellers</th>
										</tr>
									</thead>
									<tbody>
										<tr ng-repeat="bid in ctl.userProductList">
											<td align="center"><input name="check" type="checkbox"
												checklist-model="ctl.form.allSellerIdArray"
												checklist-value="bid.companyId" ng-model="bid.SELECTED"
												ng-required="ctl.form.allSellerIdArray==ctl.form.allSellerIdArray[1] && ctl.form.checkValueAllSellers=='all'"></td>

											<td align="center">{{bid.companyName}}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div class="alert alert-info fade in" style="text-align: center"
					ng-repeat="b in ctl.findByAmountList.list">
					<strong>I agree to pay Advance Amount Rs.<strong
						style="color: red;">
							{{b.secuirityAmount*ctl.form.quantity*1000}}/-</strong> to open the Bid on
						{{ctl.form.startDate}}
					</strong><br> <br> <input type="checkbox" name="checkbox"
						value="check" id="agree" required="required" /> I have read and
					agree to the Terms and Conditions and Privacy Policy.<a> (for T
						& C click here)</a>
				</div>
				<div class="modal-footer">
					<input type="submit" value="SEND" class="btn btn-success">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!--View Quatation -->
<div class="modal fade" id="mainModaltwo" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Quotation List</h4>
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
					<div id="page-wrapper"
						ng-show="ctl.viewQuotationList.list.length>0">
						<div class="table-responsive">
							<table class="table table-bordered table-striped table-hover">
								<thead class="text-uppercase">
									<tr>
										<th>#</th>
										<th>PRODUCT</th>
										<!-- <th>COMPANY</th>
										<th>SELLER</th> -->
										<th>QUANTITY</th>
										<!-- <th>RATE</th> -->
										<!-- <th>Deal VALUE</th> -->
										<th>DATE & TIME</th>
										<th>ACCEPT</th>
										<th>Counter</th>
										<th>History</th>
									</tr>
								</thead>
								<tbody>
									<tr ng-repeat="bid in ctl.viewQuotationList.list">
										<td align="center">{{$index+1}}</td>
										<td align="center">{{bid.productName}}</td>
										<td align="center">{{bid.buyerName}}</td>
										<td align="center">{{bid.quantity}} {{bid.unit}}</td>
										<td align="center">{{bid.timestamp |date:'dd-MM-yyyy
											h:mma'}}</td>
										<td align="center">
											<button type="button" class="btn btn-success btn-xs"
												ng-click="ctl.acceptBid(bid)" ng-show="bid.active">Accept
												Bid</button> <label for="Latitude" ng-hide="bid.active"
											ng-class="{colgreen:bid.status=='WON',colred:bid.status=='LOST'}">{{bid.status}}</label>
										</td>
										<td align="center"><a href=""
											ng-click="ctl.getBidCounterId(bid)" data-toggle="modal"
											data-target="#counterModel"
											ng-show="bid.status != 'WON' && bid.status != 'LOST'"> <span
												class="glyphicon glyphicon-upload"></span></a>
											<p ng-show="bid.status == 'WON' || bid.status == 'LOST'">--</p>
										</td>
										<td align="center"><a title="History" href=""
											ng-click="ctl.viewHistory(bid.productId,bid.buyerId)"
											data-toggle="modal" data-target="#mainModalHistory"><span
												class="glyphicon glyphicon-open-file"></span></a></td>
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
							Quantity : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.counterQuantity"
								class="form-control" placeholder="Enter Amount">
						</div>
					</div>
					<div class="form-group">
						<label for="CounterOffer" class="col-sm-3 control-label">Offer
							Rate : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.counterAmount"
								class="form-control" placeholder="Enter Amount" required>
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
	<div class="modal-dialog" style="width: 50ex">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">History</h4>
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
										<th>#</th>
										<th>QUANTITY</th>
										<th>RATE</th>
										<th>DATE & TIME</th>
									</tr>
								</thead>
								<tbody>
									<tr
										ng-repeat="bid in ctl.viewHistoryList.list | orderBy:'timestamp':true">
										<td align="center">{{$index+1}}</td>
										<td align="center">{{bid.quantity}} {{bid.unit}}</td>
										<td align="center">{{bid.quotationAmount}}</td>
										<td align="center">{{bid.timestamp |date:'dd-MM-yyyy
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
<!--OTHER INFORMATION -->
<div class="modal fade" id="mainModalInfo" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-sm" style="width: 30%;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Other Information</h4>
			</div>
			<form class="form-horizontal" role="form"
				ng-submit="ctl.addQuotation()">
				<div class="modal-body">
					<div ng-show="ctl.searchMessage!=null"
						ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
						<strong>{{ctl.searchMessage}}</strong>
					</div>
					<!-- Table -->
					<div id="page-wrapper" ng-show="ctl.viewInformationList.length>0">
						<div class="table-responsive">
							<table class="table table-bordered table-striped table-hover">
								<thead class="text-uppercase">
									<tr>
										<th>Transportation</th>
										<th>Insurance</th>
									</tr>
								</thead>
								<tbody>
									<tr ng-repeat="bid in ctl.viewInformationList">
										<td align="center">{{bid.transportation}}</td>
										<td align="center">{{bid.insurance}}</td>
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

<!-- View User -->

<div class="modal fade" id="mainModalViewUser" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-sm" style="width: 30%;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Invited Seller List</h4>
			</div>
			<form class="form-horizontal" role="form"
				ng-submit="ctl.addQuotation()">
				<div class="modal-body">
					<div ng-show="ctl.searchMessage!=null"
						ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
						<strong>{{ctl.searchMessage}}</strong>
					</div>
					<div class="alert alert-success"
						ng-show="ctl.message != '' && ctl.message.success == true">
						<strong>{{ctl.message.msg}}</strong>
					</div>
					<!-- Table -->
					<div id="page-wrapper" ng-show="ctl.viewAcceptUserList.length>0">
						<div class="table-responsive">
							<table class="table table-bordered table-striped table-hover">
								<thead class="text-uppercase">
									<tr>
										<th>Seller</th>
										<th>Status</th>
									</tr>
								</thead>
								<tbody>
									<tr ng-repeat="bid in ctl.viewAcceptUserList">
										<td align="center">{{bid.invitedUserCompanyName}}</td>
										<td ng-show="bid.inviteStatus=='No Reply'" align="center"
											style="color: black; font-weight: bold;">{{bid.inviteStatus}}</td>
										<td ng-show="bid.inviteStatus=='Accept'" align="center"
											style="color: blue; font-weight: bold;">{{bid.inviteStatus}}</td>
										<td ng-show="bid.inviteStatus=='Reject'" align="center"
											style="color: red; font-weight: bold;">{{bid.inviteStatus}}</td>
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