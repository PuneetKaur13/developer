<style type="text/css">
th {
	text-align: center;
	white-space: nowrap;
}

h4, .h4 {
	margin-top: 4px;
}

.modal-dialog {
	margin: 30px auto;
	width: 80%;
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
					<div class="col-xs-5 col-sm-6 col-md-8">
						<h4>See Seller's Offer</h4>
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
					<div class="tab-content">
						<!-- <ul class="nav nav-tabs">
							<li class="active"><a data-toggle="tab" href=""
								class="tab-pane active" ng-click="ctl.changeSells('ACTIVE')"><strong>ACTIVE</strong></a></li>
							<li><a data-toggle="tab" href=""
								ng-click="ctl.changeSells('DEACTIVE')"><strong>DEACTIVE
								</strong></a></li>
						</ul> -->
					</div>
					<div class="tab-content">
						<div class="tab-pane fade in active">
							<br>
							<div ng-show="ctl.searchMessage!=null"
								ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
								<strong>{{ctl.searchMessage}}</strong>
							</div>
							<table class="table table-bordered table-striped table-hover"
								ng-show="ctl.dataList.list.length>0">
								<thead class="text-uppercase">
									<tr>
										<th>#</th>
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
									<tr ng-repeat="bid in ctl.dataList.list">
										<td align="center">{{$index+1}}</td>
										<td align="center">{{bid.offerRefrenceNo}}</td>
										<td align="center">{{bid.productName}}</td>
										<td align="center">{{bid.packaging}}</td>

										<td align="center">{{bid.quantity}} {{bid.unit}}</td>

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