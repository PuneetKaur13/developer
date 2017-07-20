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
						<h4>Offers</h4>
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
					<ul class="nav nav-tabs" ng-show="ctl.dataList.list.length>0">
						<li ng-class="{'active':ctl.activeTab==$index}"><a
							data-toggle="tab" href=""><strong>OPEN &
									ACTIVE </strong></a></li>
						<li ng-class="{'active':ctl.activeTab==$index}"><a
							data-toggle="tab" href=""><strong>ABOUT TO
									OPEN </strong></a></li>
						<li ng-class="{'active':ctl.activeTab==$index}"><a
							data-toggle="tab" href=""><strong>CLOSED </strong></a></li>
						<li ng-class="{'active':ctl.activeTab==$index}"><a
							data-toggle="tab" href=""><strong>EARLIER </strong></a></li>
					</ul>
					<div class="table-responsive">
						<!-- 						<table ng-show="ctl.dataList.list.length>0">
							<tr>
								<td><input type="text" class="form-control"
									ng-model="ctl.productName" placeholder="Search Product"></td>
								<td style="text-align: left;">&emsp;<input type="submit"
									class="btn btn-success" ng-click="ctl.search()" value="Search"></td>
							</tr>

						</table> -->
						<br>
						<table class="table table-bordered table-striped table-hover"
							ng-show="ctl.dataList.list.length>0">
							<thead class="text-uppercase">
								<tr>
									<th>#</th>
									<th>Product</th>
									<th>PACKAGING</th>
									<th>Quantity</th>
									<!-- <th>RATE</th> -->
									<th>START DATE</th>
									<th>END DATE</th>
									<th>STATUS</th>
									<th>QUOTATION</th>
								</tr>
							</thead>
							<tbody>
								<tr ng-repeat="bid in ctl.dataList.list">
									<td align="center">{{$index+1}}</td>
									<td align="center">{{bid.productName}}</td>
									<td align="center">{{bid.packaging}}</td>
									<td align="center">{{bid.quantity}} {{bid.unit}}</td>
									<!-- <td align="center">{{bid.expectedAmount}}</td> -->
									<td align="center">{{bid.startDate|date : 'dd-MM-yyyy'}}</td>
									<td align="center">{{bid.enddate|date : 'dd-MM-yyyy'}}</td>
									<td align="center"><img src="images/{{bid.status}}.png"
										class="img-rounded" title="{{bid.status}}" width="25"
										height="25" ng-show="bid.status!=null"></td>

									<td align="center"><a href="" ng-click="ctl.getBidId(bid)"
										title="Add Quotation" data-toggle="modal"
										data-target="#mainModal"
										ng-show="bid.status!='CLOSED' && bid.status!='DEACTIVE'"><span
											class="glyphicon glyphicon-plus-sign"></span></a> &nbsp; <a
										title="View Quotation" href="" data-toggle="modal"
										ng-click="ctl.viewQuotation(bid.productId)"
										data-target="#mainModaltwo"><span
											class="glyphicon glyphicon-eye-open"></span></a></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!--Add Quatation -->

<div class="modal fade" id="mainModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="width: 40%;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Add Quotation</h4>
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
					<div class="form-group">
						<label for="description" class="col-sm-3 control-label">
							Quantity : </label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.quantity"
								class="form-control" placeholder="Enter Quantity" required>
						</div>
						<!-- <div class="col-sm-7">
							<textarea ng-model="ctl.form.description" class="form-control"
								placeholder="Enter Description"></textarea>
						</div> -->

					</div>
					<div class="form-group">
						<label for="price" class="col-sm-3 control-label">Rate : <span
							style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.quotationAmount"
								class="form-control" placeholder="Enter Rate" required>
						</div>
					</div>
					<div class="form-group">

						<label for="unit" class="col-sm-3 control-label"> Unit : <span
							style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<select class="form-control" ng-model="ctl.form.unit" required>
								<option value="">--Select--</option>
								<option value="KG">KG</option>
								<option value="MT">MT</option>
							</select>
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
							<table class="table table-bordered table-striped table-hover"
								ng-show="ctl.dataList.list.length>0">
								<thead class="text-uppercase">
									<tr>
										<th>#</th>
										<th>PRODUCT</th>
										<th>USER</th>
										<th>RATE</th>
										<th>Quantity</th>
										<th>TIME</th>

									</tr>
								</thead>
								<tbody>
									<tr ng-repeat="bid in ctl.viewQuotationList.list">
										<td align="center">{{$index+1}}</td>
										<td align="center">{{bid.productName}}</td>
										<td align="center">{{bid.sellerName}}</td>
										<td align="center">{{bid.quotationAmount}}</td>
										<td align="center">{{bid.quantity}} {{bid.unit}}</td>
										<td align="center">{{bid.timestamp |date : 'dd-MM-yyyy
											HH:mm:ss'}}</td>

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
