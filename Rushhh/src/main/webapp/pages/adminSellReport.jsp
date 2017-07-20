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

				<div class="panel-heading" style="height: 50px;background-color:#64b5f6"">
					<div class="col-md-6">
						<h4>Sell Reports</h4>
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
							<button type="submit" class="btn btn-success btn-sm" id="Button2"style="background-color:#64b5f6"
								name="command" ng-click="ctl.search()" value="Go">Go</button>
							<button type="submit" ng-disabled="!ctl.button.previous"
								class="btn btn-success btn-sm inline" id="Button6"style="background-color:#64b5f6"
								name="command" value="Previous" ng-click="ctl.previous()"><<</button>
							<button type="submit" ng-disabled="!ctl.button.next"
								class="btn btn-success btn-sm inline" id="Button7"style="background-color:#64b5f6"
								name="command" value="Next" ng-click="ctl.next()">>></button>
						</div>
					</div>
				</div>
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
									ng-model="ctl.searchData.startDate" placeholder="Select Start Date" />
								</datepicker></td>
							<td>&emsp;</td>
						

							<td>&nbsp;&nbsp;</td>
							<td style="text-align: left;">&emsp;<input type="submit"
								class="btn btn-success"style="background-color:#64b5f6" ng-click="ctl.search()" value="Search"></td>
							<td>&nbsp;&nbsp;</td>
							<td><button type="submit" class="btn btn-success btn-sm"style="background-color:#64b5f6"
									ng-click="ctl.searchData.pageNo=1;ctl.searchReport()">
									<span class="glyphicon glyphicon-export"></span><b>PDF</b>
								</button></td>

						</tr>
					</table>
					<div class="table-responsive">
						<br> <br>
						<table class="table table-bordered table-striped table-hover"
							ng-show="ctl.dataList.list.length>0">
							<thead class="text-uppercase">
								<tr>
									<th>Offer Ref. No.</th>
									<th>Commodity</th>
									<!-- <th>Company</th> -->
									<th>Packaging</th>
									<th>Quantity</th>
									<!-- <th>EXPECTED RATE</th> -->
									<th>FREEZING TYPE</th>
									<th>RATE NEGOTIABLE</th>
									<th>START DATE</th>
									<th>END DATE</th>
									<!-- 	<th>OTHER INFORMATION</th> -->
									<th>STATUS</th>
									<!-- 		<th>Visitors</th> -->
								</tr>
							</thead>
							<tbody>
								<tr
									ng-repeat="bid in ctl.dataList.list | orderBy:'timestamp':true">
									<td align="center">{{bid.offerRefrenceNo}}</td>
									<td align="center">{{bid.productName}}</td>
									<td align="center">{{bid.packaging}}</td>
									<!--<td align="center">{{bid.companyName}}</td>-->
									<td align="center">{{bid.quantity}} {{bid.unit}}</td>
									<!-- 	<td align="center">{{bid.expectedAmount}}</td> -->
									<td align="center">{{bid.freezingType}}</td>
									<td align="center">{{bid.rateNegotiable}}</td>
									<td align="center">{{bid.startDate | date : 'dd-MM-yyyy'}}</td>
									<td align="center">{{bid.enddate | date : 'dd-MM-yyyy'}}</td>
									<!-- <td align="center"><a title="Information" href=""
										ng-click="ctl.viewInformation(bid.id)" data-toggle="modal"
										data-target="#mainModalInfo"><span
											class="glyphicon glyphicon-info-sign"></span></a></td> -->
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