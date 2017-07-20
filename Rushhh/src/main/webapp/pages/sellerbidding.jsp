
<style type="text/css">
th {
	text-align: center;
	white-space: nowrap;
}

h4, .h4 {
	margin-top: 4px;
}

.modalVisitor {
	margin: 30px auto;
	width: 80%;
}

.modal-dialog {
	margin: 30px auto;
	width: 40%;
}

.colgreen {
	color: green;
}

.colred {
	color: red;
}

.badge {
	background: black;
	width: 20%;
}
</style>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-primary">
				<!-- Default panel contents -->
				<div class="panel-heading" style="height: 50px;">
					<div class="col-xs-5 col-sm-6 col-md-8">
						<h4>My Offers</h4>
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
					<br>
					<table>
						<tr>
							<td><input type="text" class="form-control"
								ng-model="ctl.searchData.offerRefrenceNo"
								placeholder="Search Offer Refrence No"></td>
							<td>&nbsp;&nbsp;</td>
							<td><select class="form-control inline"
								ng-model="ctl.searchData.productName"
								ng-options="option.name as option.name for option in ctl.dataList.preload.productList"
								ng-change="ctl.findPackaging(ctl.searchData.productId)" required>
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

							<td><datepicker date-format="dd-MM-yyyy"> <input
									type="text" class="form-control"
									ng-model="ctl.searchData.startDate"
									placeholder="Select Start Date" /> </datepicker></td>
							<td>&emsp;</td>
							<td><datepicker date-format="dd-MM-yyyy"> <input
									type="text" class="form-control"
									ng-model="ctl.searchData.enddate"
									placeholder="Select Start Date" /> </datepicker></td>
							<td>&emsp;</td>
							<td style="text-align: left;">&emsp;<input type="submit"
								class="btn btn-success" ng-click="ctl.search()" value="Search"></td>
						</tr>
					</table>
					<br>
					<table class="table table-bordered"
						ng-show="ctl.dataList.list.length>0">
						<thead class="text-uppercase">
							<tr>
								<th>#</th>
								<th>#</th>
								<th>Offer Ref. No.</th>
								<th>Commodity</th>
								<th>Packaging</th>
								<th>Quantity</th>
								<th>FREEZING TYPE</th>
								<th>RATE NEGOTIABLE</th>
								<th>START DATE</th>
								<th>END DATE</th>
								<th>STATUS</th>
							</tr>
						</thead>
						<tbody>
							<tr
								ng-repeat="bid in ctl.dataList.list  | orderBy:'timestamp':true"
								ng-class="{'bg-success':bid.status=='ACTIVE' , 'bg-danger':bid.status=='DEACTIVE'}">
								<td align="center"><input type="checkbox"
									checklist-model="ctl.checkedData.del" checklist-value="bid.id"></td>
								<td align="center"><a href=""
									ng-click="ctl.display(bid.id)" data-toggle="modal"
									data-target="#mainModal"><span
										class="glyphicon glyphicon-pencil"></span></a></td>
								<td align="center">{{bid.offerRefrenceNo}}</td>
								<td align="center">{{bid.productName}}</td>
								<td align="center">{{bid.packaging}}</td>

								<td align="center">{{bid.quantity}} {{bid.unit}}</td>

								<td align="center">{{bid.freezingType}}</td>
								<td align="center">{{bid.rateNegotiable}}</td>
								<td align="center">{{bid.startDate | date : 'dd-MM-yyyy'}}</td>
								<td align="center">{{bid.enddate | date : 'dd-MM-yyyy'}}</td>

								<td align="center"><img src="images/{{bid.status}}.png"
									class="img-rounded" title="{{bid.status}}" width="25"
									height="25" ng-show="bid.status!=null"></td>

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

<div class="modal fade" id="mainModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="width: 90%;">
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
						<label for="Commodity" class="col-sm-2 control-label">Commodity
							: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<select class="form-control inline" ng-model="ctl.form.productId"
								ng-options="option.key as option.name for option in ctl.dataList.preload.productList"
								ng-change="ctl.findPackaging(ctl.form.productId)" required>
								<option value="">--Select--</option>
							</select>
						</div>
						<label for="state" class="col-sm-2 control-label">Bulk
							Packaging : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<select class="form-control inline"
								ng-model="ctl.form.packagingId"
								ng-options="option.id as option.packaging for option in ctl.packagingList"
								required>
								<option value="">--Select--</option>
							</select>
						</div>
					</div>


					<div class="form-group">
						<label for="state" class="col-sm-2 control-label">Crop
							Harvest : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-2">
							<select class="form-control" ng-model="ctl.form.cropMonth"
								required>
								<option value="">--Month--</option>
								<option value="01">January</option>
								<option value="02">February</option>
								<option value="03">March</option>
								<option value="04">April</option>
								<option value="05">May</option>
								<option value="06">June</option>
								<option value="07">July</option>
								<option value="08">August</option>
								<option value="09">September</option>
								<option value="10">October</option>
								<option value="11">November</option>
								<option value="12">December</option>
							</select>
						</div>
						<div class="col-sm-2">
							<select class="form-control" ng-model="ctl.form.cropYear"
								required>
								<option value="">--Year--</option>
								<option value="11">2017</option>
								<option value="12">2016</option>
							</select>
						</div>
					</div>
					<div class="form-group" name="myForm">
						<label for="user" class="col-sm-2 control-label">Quantity
							: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<input type="text" ng-model="ctl.form.quantity"
								class="form-control" name="myField"
								placeholder="Enter Ex-Stock Quantity" required>
						</div>
						<label for="unit" class="col-sm-2 control-label"> Unit : <span
							style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<select class="form-control" ng-model="ctl.form.unit" readonly>
								<option value="MT">MT</option>
							</select>

						</div>
					</div>
					<div class="form-group">
						<label for="startDate" class="col-sm-2 control-label">Start
							Date : <span style="color: red;">*</span>
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
								date-min-limit="{{ctl.valid.enddate}}""> <input
								type="text" class="form-control" ng-model="ctl.form.enddate"
								required placeholder="DD-MM-YYYY" readonly="readonly" /> </datepicker>
						</div>
					</div>
					<div class="form-group">
						<label for="tax" class="col-sm-2 control-label">Rate per
							KG : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<input type="text" ng-model="ctl.form.expectedAmount"
								class="form-control" placeholder="Enter Expected Rate" required>
						</div>
						<label for="state" class="col-sm-2 control-label">Rate
							Negotiable : <span style="color: red;">*</span>
						</label>

						<div class="col-sm-3">
							<label for="type" class="col-sm-5 control-label"><input
								type="radio" value="YES" ng-required="!ctl.form.rateNegotiable"
								ng-model="ctl.form.rateNegotiable">YES</label> <label for="type"
								class="col-sm-6 control-label"><input type="radio"
								value="NO" ng-required="!ctl.form.rateNegotiable"
								ng-model="ctl.form.rateNegotiable">NO</label>
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
								<b>Material Available At Location: </b>
							</p>
						</div>
					</div>
					<div class="form-group">
						<label for="state" class="col-sm-2 control-label">State :
							<span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<select class="form-control inline" ng-model="ctl.form.stateId"
								ng-options="option.id as option.stateName for option in ctl.dataList.preload.stateList | orderBy:'stateName'"
								ng-change="ctl.findCity(ctl.form.stateId)" required>
								<option value="">--Select--</option>
							</select>
						</div>
						<label for="state" class="col-sm-2 control-label">City : <span
							style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<select class="form-control inline" ng-model="ctl.form.cityId"
								ng-options="option.id as option.cityName for option in ctl.cityList  | orderBy:'cityName'">
								<option value="">--Select--</option>
							</select>
						</div>
					</div>
					<div class="alert alert-info fade in"
						style="text-align: center; height: 50%;">
						<strong>You need to put the stock available will you for
							sale, on today's date. Your offer will be valid for a week,
							Unless you put your stock for sale, you cannot participate in the
							Bidding System... </strong><br> <br> <input type="checkbox"
							name="checkbox" value="check" id="agree" required="required" />
						I have read and agree to the Terms and Conditions and Privacy
						Policy
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
					<div id="page-wrapper" ng-show="ctl.viewVisitorList.list.length>0">
						<div class="table-responsive">
							<table class="table table-bordered table-striped table-hover">
								<thead class="text-uppercase">
									<tr>
										<th>#</th>
										<th>Commodity</th>
										<!-- <th>COMPANY</th>
										<th>SELLER</th> -->
										<th>QUANTITY</th>
										<th>RATE</th>
										<th>VALUE</th>
										<th>TIME</th>
										<!-- <th>DESCRIPTION</th> -->
										<!-- <th>ACCEPT</th> -->
										<th>Counter Offer</th>
										<th>History</th>
									</tr>
								</thead>
								<tbody>
									<tr ng-repeat="bid in ctl.viewQuotationList.list">
										<td align="center">{{$index+1}}</td>
										<td align="center">{{bid.productName}}</td>
										<!--	<td align="center">{{bid.companyName}}</td>
										<td align="center">{{bid.buyerName}}</td>-->
										<td align="center">{{bid.quantity}} {{bid.unit}}</td>
										<td align="center">{{bid.quotationAmount}}</td>
										<td align="center">{{bid.quantity*bid.quotationAmount}}</td>
										<td align="center">{{bid.timestamp |date:'dd-MM-yyyy
											h:mma'}}</td>
										<!-- <td align="center">{{bid.description}}</td> -->
										<!-- <td align="center">
											<button type="button" class="btn btn-success btn-xs"
												ng-click="ctl.acceptBid(bid)" ng-show="bid.active">Accept
												Bid</button> <label
											for="" ng-hide="bid.active"
											ng-class="{colgreen:bid.status=='WON',colred:bid.status=='LOST'}">{{bid.status}}</label>

										</td> -->
										<td align="center"><a href=""
											ng-click="ctl.getBidCounterId(bid)" data-toggle="modal"
											data-target="#counterModel"
											ng-show="bid.status != 'WON' && bid.status != 'LOST'"> <span
												class="glyphicon glyphicon-upload"></span></a>
											<p ng-show="bid.status == 'WON' || bid.status == 'LOST'"></p></td>
										<td align="center"><a title="History" href=""
											ng-click="ctl.viewHistory(bid.productId,bid.sellerId)"
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
						<label for="CounterOffer" class="col-sm-3 control-label">Offer
							Rate : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.counterAmount"
								class="form-control" placeholder="Enter Offer Rate" required>
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
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Hisotry</h4>
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
										<th>RATE</th>
										<th>TIME</th>
									</tr>
								</thead>
								<tbody>
									<tr ng-repeat="bid in ctl.viewHistoryList.list">
										<td align="center">{{$index+1}}</td>
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
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Other Information</h4>
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
						ng-show="ctl.viewInformationList.list.length>0">
						<div class="table-responsive">
							<table class="table table-bordered table-striped table-hover">
								<thead class="text-uppercase">
									<tr>
										<th>Transportation</th>
										<th>TAX</th>
										<th>Insurance</th>
									</tr>
								</thead>
								<tbody>
									<tr ng-repeat="bid in ctl.viewInformationList.list">
										<td align="center">{{bid.transportation}}</td>
										<td align="center">{{bid.tax}}</td>
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

<!--View Visitor -->

<div class="modal fade" id="modalVisitor" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Visitors</h4>
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
					<div id="page-wrapper" ng-show="ctl.viewVisitorList.list.length>0">
						<div class="table-responsive">
							<table class="table table-bordered table-striped table-hover">
								<thead class="text-uppercase">
									<tr>
										<th>#</th>
										<th>State</th>
										<th>City</th>
										<th>DATE & TIME</th>

									</tr>
								</thead>
								<tbody>
									<tr ng-repeat="bid in ctl.viewVisitorList.list">
										<td align="center">{{$index+1}}</td>
										<td align="center">{{bid.stateName}}</td>
										<td align="center">{{bid.cityName}}</td>
										<td align="center">{{bid.createdDate|date:'dd-MM-yyyy
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
