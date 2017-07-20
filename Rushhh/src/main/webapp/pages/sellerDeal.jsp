<style type="text/css">
th {
	text-align: center;
	white-space: nowrap;
}

h4, .h4 {
	margin-top: 4px;
}
</style>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-primary">
				<!-- Default panel contents -->
				<div class="panel-heading" style="height: 50px;">
					<div class="col-xs-5 col-sm-6 col-md-8">
						<h4>My Deals</h4>
					</div>

					<div class="col-xs-7 col-sm-6 col-md-4"
						ng-show="ctl.dataList.list.length>0">

						<div class="text-right">
							<label class="h4">PageNo:&nbsp;</label> <input type="hidden"
								ng-model="hidPageNoValue" /> <input type="hidden"
								ng-model="hidPageSize" /> <select class="form-control"
								style="width: 74px; height: 31px; display: inline;"
								ng-model="pageNo" ng-options="page as page for page in page_N0">
							</select>
							<button type="submit" class="btn btn-success btn-sm" id="Button2"
								name="command" ng-click="go()" value="Go">Go</button>
							<button type="submit"
								ng-class="{'disabled':productionControlList.btn_disable_Previous==true}"
								ng-disabled="btn_disable_Previous==true"
								class="btn btn-success btn-sm inline" id="Button6"
								name="command" value="Previous" ng-click="previous()"><<</button>
							<button type="submit"
								ng-class="{'disabled':productionControlList.btn_disable_Next==true}"
								ng-disabled="btn_disable_Next==true"
								class="btn btn-success btn-sm inline" id="Button7"
								name="command" value="Next" ng-click="next()">>></button>
						</div>
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
						<table ng-show="ctl.dataList.list.length>0">
							<tr>
								<td><input type="text" class="form-control"
									ng-model="ctl.productName" placeholder="Search Product"></td>
								<td style="text-align: left;">&emsp;<input type="submit"
									class="btn btn-success" ng-click="ctl.search()" value="Search"></td>
							</tr>
						</table>
						<br>



						<table class="table table-bordered table-striped table-hover"
							ng-show="ctl.dataList.list.length>0">

							<thead class="text-uppercase">
								<tr>
									<th>#</th>
									<th>BID REF. NO.</th>
									<th>PRODUCT</th>
									<th>QUANTITY</th>
									<th>PACKAGING</th>
									<th>COMPANY</th>
									<th>RATE</th>
									<th>DATE & TIME</th>
								</tr>
							</thead>
							<tbody>
								<tr ng-repeat="bid in ctl.dataList.list | orderBy:'timestamp':true">
									<td align="center">{{$index+1}}</td>
									<td align="center">{{bid.bidRefrenceNo}}</td>
									<td align="center">{{bid.productName}}</td>
									<td align="center">{{bid.quantity}} {{bid.unit}}</td>
									<td align="center">{{bid.packaging}}</td>
									<td align="center">{{bid.buyerCompanyName}}</td>
									<td align="center">{{bid.quotationAmount}} INR</td>
									<td align="center">{{bid.timestamp |date : 'dd-MM-yyyy HH:mm:ss'}}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>