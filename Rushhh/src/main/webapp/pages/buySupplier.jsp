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
						<h4>My Favourite Buyer's</h4>
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
						<table class="table table-bordered table-striped table-hover"
							ng-show="ctl.dataList.list.length>0">
							<thead class="text-uppercase">
								<tr>
									<th>#</th>
									<th>#</th>
									<th>Company</th>
									<th>Commodity</th>
								</tr>
							</thead>
							<tbody>
								<tr ng-repeat="message in ctl.dataList.list">
									<td align="center"><input type="checkbox"
										checklist-model="ctl.checkedData.del"
										checklist-value="message.id"></td>
									<td align="center">{{$index+1}}</td>
									<td align="center">{{message.companyName}}</td>
									<td align="center">{{message.productName}}</td>
								</tr>
							</tbody>
						</table>
						<button type="button" class="btn btn-success" data-toggle="modal"
							data-target="#mainModal" ng-click="ctl.addModal()">Add</button>
						<button type="button" class="btn btn-success"
							ng-show="ctl.dataList.list.length>0" ng-click="ctl.deleteData()">Delete</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="mainModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="mainModalLabel"></h4>
			</div>
			<form class="form-horizontal" role="form" ng-submit="ctl.addData()">
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
						<label for="state" class="col-sm-3 control-label">Commodity
							: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<select class="form-control inline" ng-model="ctl.selectedOption"
								ng-options="option.name for option in ctl.productList.list track by option.id"
								ng-change="ctl.form.productId=ctl.selectedOption.id;ctl.form.productName=ctl.selectedOption.name;">
								<option value="">--Select--</option>
							</select>
						</div>
					</div>
			<!-- 		<div class="form-group">
						<label for="state" class="col-sm-3 control-label">Bulk
							Packaging : </label>
						<div class="col-sm-7">
							<select class="form-control inline"
								ng-model="ctl.selectedOptionPackaging"
								ng-options="option as option.packaging for option in ctl.packagingList.list track by option.id"
								ng-change="ctl.form.packagingId=ctl.selectedOptionPackaging.id;ctl.form.packaging=ctl.selectedOptionPackaging.packaging">
								<option value="">--Select--</option>
							</select>
						</div>
					</div> -->
					<div class="form-group">
						<label for="state" class="col-sm-3 control-label">Buyr's :
							<span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<select class="form-control inline"
								ng-model="ctl.selectedOptionBuy"
								ng-options="option.companyName for option in ctl.searchForBuySupplier.list track by option.id"
								ng-change="ctl.form.companyId=ctl.selectedOptionBuy.id;ctl.form.companyName=ctl.selectedOptionBuy.companyName;">
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
