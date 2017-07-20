<style type="text/css">
th {
	text-align: center;
	white-space: nowrap;
}

h4, .h4 {
	margin-top: 4px;
}

.colgreen {
	color: green;
	font-weight: bold;
}

.colred {
	color: red;
	font-weight: bold;
}
</style>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-primary">
				<!-- Default panel contents -->
				<div class="panel-heading" style="height: 50px;">
					<div class="col-sm-6">
						<h4>My Quotations</h4>
					</div>
					<div class="col-md-6" ng-show="ctl.dataList.list.length>0">
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
						<table ng-show="ctl.dataList.list.length>0">
							<tr>
								<td><input type="text" class="form-control"
									ng-model="ctl.productName" placeholder="Search Product"></td>
								<td style="text-align: left;">&emsp;<input type="submit"
									class="btn btn-success" value="Search"></td>
							</tr>
						</table>
						<br>
						<table class="table table-bordered table-striped table-hover"
							ng-show="ctl.dataList.list.length>0">
							<thead class="text-uppercase">
								<tr>
									<th>#</th>
									<th>Bid Ref No.</th>

									<th>PRODUCT</th>
									<th>User</th>
									<th>Quote QUANTITY</th>
									<th>RATE</th>
									<th>TIME</th>
									<th>STATUS</th>
									<th>COUNTER OFFER</th>
								</tr>
							</thead>
							<tbody>
								<tr
									ng-repeat="bid in ctl.dataList.list | orderBy:'timestamp':true">
									<td align="center">{{$index+1}}</td>
									<td align="center">{{bid.bidRefrenceNo}}</td>
									<td align="center">{{bid.productName}}</td>
									<td align="center">{{bid.buyerName}}</td>
									<td align="center">{{bid.quantity}} {{bid.unit}}</td>
									<td align="center">{{bid.quotationAmount}}</td>
									<td align="center">{{bid.timestamp |date : 'dd-MM-yyyy
										HH:mm:ss'}}</td>
									<td align="center"><img src="images/{{bid.status}}.png"
										class="img-rounded" title="{{bid.status}}" width="25"
										height="25" ng-show="bid.status!=null"></td>
									<td align="center"><a title="View Counter Offers" href=""
										ng-click="ctl.viewCounter(bid.id)" ng-show="bid.isCounter"
										data-toggle="modal" data-target="#counterModal"><span
											class="glyphicon glyphicon-eye-open"></span></a>
										<p ng-show="!bid.isCounter" style="color: red;">No Counter
											Offer</p></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- View Counter  -->
<div class="modal fade" id="counterModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Counter Offers</h4>
			</div>
			<div class="modal-body">
				<!-- Table -->
				<div id="page-wrapper" ng-show="ctl.counterList.list.length>0">
					<div class="table-responsive">
						<table class="table table-bordered table-striped table-hover">
							<thead class="text-uppercase">
								<tr>
									<th>#</th>
									<th>QUANTITY</th>
									<th>RATE</th>
									<th>UNIT</th>
									<th>TIME</th>
								</tr>
							</thead>
							<tbody>
								<tr
									ng-repeat="bid in ctl.counterList.list | orderBy:'timestamp':true ">
									<td align="center">{{$index+1}}</td>
									<td align="center">{{bid.quantity}}</td>
									<td align="center">{{bid.quotationAmount}}</td>
									<td align="center">{{bid.unit}}</td>
									<td align="center">{{bid.createdDate | date:'MM/dd/yyyy
										h:mma'}}</td>
								</tr>
							</tbody>
						</table>
						<strong style="color: blue">Add same quantity and rate to
							accept this counter offer </strong><a ng-click="ctl.sellerCounter()"><b>ClickHere</b></a>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
