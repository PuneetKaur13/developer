<style type="text/css">
th {
	text-align: center;
	white-space: nowrap;
}

h4, .h4 {
	margin-top: 4px;
}

.nav-tabs>li.active>a, .nav-tabs>li.active>a:hover, .nav-tabs>li.active>a:focus
	{
	color: black;
	background-color: #187f06;
}
</style>


<div class="container-fluid">
	<div class="row">

		<div class="col-sm-12">
			<div class="panel panel-primary">
				<!-- Default panel contents -->
				<div class="panel-heading"
					style="height: 50px;">
					<div class="col-md-8">
						<h4>Manage Requirements</h4>
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
					<table>
						<tr>
							<td><input type="text" class="form-control"
								ng-model="ctl.searchData.productName"
								placeholder="Search Product Name"></td>
							<td>&nbsp;&nbsp;</td>
							<td><select class="form-control"
								ng-model="ctl.searchData.status"
								ng-options="grade as grade for grade in ['ACTIVE','DEACTIVE','ABOUT TO OPEN','CLOSED']"
								required>
									<option value="">--Select--</option>
							</select></td>

							<td>&nbsp;&nbsp;</td>
							<td><select class="form-control inline"
								ng-model="ctl.searchData.companyName"
								ng-options="option.companyName as option.companyName for option in ctl.dataList.preload.companyList"
								ng-change="ctl.findCity(ctl.form.stateId)" required>
									<option value="">--Select--</option>
							</select></td>
							<td style="text-align: left;">&emsp;<input type="submit"
								class="btn btn-success" ng-click="ctl.search()" value="Search"></td>
						</tr>
					</table>
					<br>
					<div class="table-responsive tab-pane fade in active">
						<table ng-show="ctl.dataList.list.length>0">

						</table>
						<div class="table-responsive">
							<br>

							<table class="table table-bordered"
								ng-show="ctl.dataList.list.length>0">


								<thead class="text-uppercase">
									<tr>
										<th>#</th>
										<th>#</th>
										<th>Bid Ref No</th>
										<th>Product</th>
										<th>Packaging</th>
										<th>Original Quantity</th>
										<th>Quantity Available For Bid</th>
										<th>WON QUANTITY</th>
										<th>Freezing Type</th>
										<th>COMPANY</th>
										<th>Bid Security Amount</th>
										<th>START DATE</th>
										<th>END DATE</th>
										<th>Invited Seller</th>
										<th>STATUS</th>
									</tr>
								</thead>
								<tbody>
									<tr
										ng-repeat="bid in ctl.dataList.list | orderBy:'timestamp':true"
										ng-class="{'bg-success':bid.status=='ACTIVE' , 'bg-danger':bid.status=='ABOUT TO OPEN'}">
										<td align="center"><a href=""
											ng-click="ctl.display(bid.id)" data-toggle="modal"
											data-target="#mainModal"><span
												class="glyphicon glyphicon-pencil"></span></a></td>
										<td align="center">{{$index+1}}</td>
										<td align="center">{{bid.bidRefrenceNo}}</td>
										<td align="center">{{bid.productName}}</td>
										<td align="center">{{bid.packaging}}</td>
										<td align="center">{{bid.remainingQuantity}} {{bid.unit}}</td>
										<td align="center">{{bid.quantity}} {{bid.unit}}</td>
										<td align="center" ng-show="bid.isRemainQuantity">{{bid.wonQuantity}}
											{{bid.unit}}</td>
										<td align="center" ng-show="!bid.isRemainQuantity">--</td>
										<td align="center">{{bid.freezingType}}</td>
										<td align="center">{{bid.companyName}}</td>
										<td align="center">{{bid.bidAmount}}/-</td>
										<td align="center">{{bid.startDate | date :
											'dd-MM-yyyy'}}</td>
										<td align="center">{{bid.enddate | date : 'dd-MM-yyyy'}}</td>
										<td align="center"><a title="Invited Seller" href=""
											ng-click="ctl.viewAcceptUser(bid.id)" data-toggle="modal"
											data-target="#mainModalViewUser"><span
												class="glyphicon glyphicon-upload"></span></a></td>
										<td align="center"><img src="images/{{bid.status}}.png"
											class="img-rounded" title="{{bid.status}}" width="25"
											height="25" ng-show="bid.status!=null"></td>
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
						<label for="countryName" class="col-sm-2 control-label">Product
							: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<!-- 							<input type="hidden" value="BUY" ng-model="ctl.form.type"> -->
							<select class="form-control inline" ng-model="ctl.form.productId"
								ng-options="option.id as option.name for option in ctl.dataList.preload.productList"
								ng-change="ctl.findPackaging(ctl.form.productId);ctl.findByUserFavouriteProduct(ctl.form.productId)"
								required>
								<option value="">--Select--</option>
							</select>
						</div>
						<label for="countryName" class="col-sm-2 control-label">Packaging
							: <span style="color: red;">*</span>
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
						<label for="user" class="col-sm-2 control-label">Quantity
							: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<input type="text" ng-model="ctl.form.quantity"
								class="form-control" placeholder="Enter Quantity" required>
						</div>
						<label for="unit" class="col-sm-2 control-label"> Unit : <span
							style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<select class="form-control" ng-model="ctl.form.unit" required>
								<option value="">--Select--</option>
								<option value="KG">KG</option>
								<option value="MT">MT</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="startDate" class="col-sm-2 control-label">Start
							Date : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<datepicker date-format="dd-MM-yyyy"> <input
								type="text" class="form-control" ng-model="ctl.form.startDate"
								required placeholder="DD-MM-YYYY" /> </datepicker>
						</div>
						<label for="enddate" class="col-sm-2 control-label">Valid
							Till : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<datepicker date-format="dd-MM-yyyy"> <input
								type="text" class="form-control" ng-model="ctl.form.enddate"
								required placeholder="DD-MM-YYYY" /> </datepicker>
						</div>
					</div>
					<div class="form-group">
						<label for="expectedDeliveryDate" class="col-sm-2 control-label">Expected
							Delivery Date : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<datepicker date-format="dd-MM-yyyy"> <input
								type="text" class="form-control" required
								ng-model="ctl.form.expectedDeliveryDate"
								placeholder="DD-MM-YYYY" /> </datepicker>
						</div>
						<label for="status" class="col-sm-2 control-label"> UTR
							NO. :<span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<input type="text" ng-model="ctl.form.utrNo" class="form-control"
								placeholder="Enter UTR No" required="required">
						</div>
					</div>
					<div class="form-group">
						<label for="utrRcv Date" class="col-sm-8 control-label">UTR
							Receive Date :<span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<datepicker date-format="dd-MM-yyyy"> <input
								type="text" class="form-control" ng-model="ctl.form.utrRcvDate"
								placeholder="DD-MM-YYYY" required="required" /> </datepicker>
						</div>

					</div>
					<div class="form-group">
						<label for="status" class="col-sm-2 control-label"> Status
							: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<select class="form-control" ng-model="ctl.form.status"
								ng-options="grade as grade for grade in ['ACTIVE','DEACTIVE','ABOUT TO OPEN','CLOSED']"
								required>
								<option value="">--Select--</option>
							</select>
						</div>
						<label for="status" class="col-sm-2 control-label"> Bank
							Name :<span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<input type="text" ng-model="ctl.form.bankName"
								class="form-control" placeholder="Enter Bank Name"
								required="required">
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
						<div class="col-sm-4">
							<label for="type" class="col-sm-5 control-label"><input
								type="radio" value="YES" ng-model="ctl.form.transportation">YES</label>
							<label for="type" class="col-sm-6 control-label"><input
								type="radio" value="NO" ng-model="ctl.form.transportation">NO</label>
						</div>
						<label for="transportation" class="col-sm-2 control-label">
							Insurance: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<label for="type" class="col-sm-5 control-label"><input
								type="radio" value="YES" ng-model="ctl.form.insurance">YES</label>
							<label for="type" class="col-sm-6 control-label"><input
								type="radio" value="NO" ng-model="ctl.form.insurance">NO</label>
						</div>

					</div>

					<div class="form-group">
						<label for="insurance" class="col-sm-2 control-label">
							Third Party Inspection <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<label for="type" class="col-sm-5 control-label"><input
								type="radio" value="YES"
								ng-model="ctl.form.thirdPartyInspection">YES</label> <label
								for="type" class="col-sm-6 control-label"><input
								type="radio" value="NO" ng-model="ctl.form.thirdPartyInspection">NO</label>
						</div>

					</div>
				</div>
				<div class="modal-footer">
					<input type="submit" value="Save" class="btn btn-success">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>



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

					<div class="alert alert-danger"
						ng-show="ctl.message != '' && ctl.message.success == false">
						<strong>{{ctl.message.msg}}</strong>
					</div>
					<div class="alert alert-success"
						ng-show="ctl.message != '' && ctl.message.success == true">
						<strong>{{ctl.message.msg}}</strong>
					</div>
					{{ctl.viewAcceptUserList.list.length}}
					<!-- Table -->
					<div id="page-wrapper" ng-show="ctl.viewAcceptUserList.length>0">
						<div class="table-responsive">
							<table class="table table-bordered table-striped table-hover">
								<thead class="text-uppercase">
									<tr>
										<th>Company</th>
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