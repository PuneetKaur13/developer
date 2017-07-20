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
	background-color: #357AE8;
}
</style>
<div class="container-fluid">
	<div class="row">

		<div class="col-sm-12">
			<div class="panel panel-primary" style="">
				<!-- Default panel contents -->
				<div class="panel-heading" style="height: 50px;">
					<div class="col-md-5">
						<h4>Manage Offers</h4>
					</div>
					<div class="col-xs-7 col-sm-6 col-md-6" ng-show="ctl.button.go">
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
					<div class="tab-content">
						<div class="table-responsive tab-pane fade in active">
							<br>
							<div ng-show="ctl.searchMessage!=null"
								ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
								<strong>{{ctl.searchMessage}}</strong>
							</div>
							<table class="table table-bordered"
								ng-show=" ctl.dataList.list.length>0">
								<thead class="text-uppercase">
									<tr>
										<th>#</th>
										<th>#</th>
										<th>#</th>
										<th>Commodity</th>
										<th>COMPANY</th>
										<th>Quantity</th>
										<th>Freezing Type</th>
										<th>RATE NEGOTIABLE</th>

										<th>START DATE</th>
										<th>END DATE</th>
										<th>STATUS</th>
									</tr>
								</thead>
								<tbody>
									<tr
										ng-repeat="bid in  ctl.dataList.list  | orderBy:'timestamp':true"
										ng-class="{'bg-success':bid.status=='ACTIVE' , 'bg-danger':bid.status=='DEACTIVE'}">
										<td align="center"><input type="checkbox"
											checklist-model="ctl.checkedData.del"
											checklist-value="bid.id"></td>
										<td align="center"><a href=""
											ng-click="ctl.display(bid.id)" data-toggle="modal"
											data-target="#mainModal"><span
												class="glyphicon glyphicon-pencil"></span></a></td>
										<td align="center">{{$index+1}}</td>
										<td align="center">{{bid.productName}}</td>
										<td align="center">{{bid.companyName}}</td>
										<td align="center">{{bid.quantity}}</td>
										<td align="center">{{bid.freezingType}}</td>
										<td align="center">{{bid.rateNegotiable}}</td>
										<td align="center">{{bid.startDate | date :
											'dd-MM-yyyy'}}</td>
										<td align="center">{{bid.enddate | date : 'dd-MM-yyyy'}}</td>
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
								ng-options="option.id as option.name for option in ctl.dataList.preload.productList"
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
						<label for="status" class="col-sm-2 control-label" style="color: red;"> Status
							: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<select class="form-control" ng-model="ctl.form.status"
								ng-options="grade as grade for grade in ['ACTIVE','DEACTIVE','CLOSED']"
								required>
								<option value="">--Select--</option>
							</select>
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