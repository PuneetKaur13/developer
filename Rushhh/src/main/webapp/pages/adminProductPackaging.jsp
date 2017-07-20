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
					<div class="col-xs-5 col-sm-6 col-md-3">
						<h4>Product Packaging Master</h4>
					</div>
					<div class="col-xs-7 col-sm-6 col-md-8" ng-show="ctl.button.go">
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
									ng-model="ctl.searchData.name"
									placeholder="Search Product Name"></td>
								<td>&nbsp;</td>
								<td><input type="text" class="form-control"
									ng-model="ctl.searchData.packaging"
									placeholder="Search Packaging Name"></td>
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
						<table class="table table-bordered table-striped table-hover"
							ng-show="ctl.dataList.list.length>0">
							<thead class="text-uppercase">
								<tr>
									<th>#</th>
									<th>#</th>
									<th>#</th>
									<th>Product</th>
									<th>Packaging</th>
								</tr>
							</thead>
							<tbody>
								<tr ng-repeat="product in ctl.dataList.list">
									<td align="center"><input type="checkbox"
										checklist-model="ctl.checkedData.del"
										checklist-value="product.id"></td>
									<td align="center"><a href=""
										ng-click="ctl.display(product.id)" data-toggle="modal"
										data-target="#mainModal"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<td align="center">{{$index+1}}</td>
									<td align="center">{{product.adminProductName}}</td>
									<td align="center">{{product.packaging}}</td>
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
<div class="modal fade" id="mainModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
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
						<label for="productName" class="col-sm-3 control-label">Product
							: <span style="color: red;">*</span>
						</label>

						<div class="col-sm-7">
							<select class="form-control inline"
								ng-model="ctl.form.adminProductId"
								ng-options="option.id as option.value for option in ctl.dataList.preload.productList">
								<option value="">--Select--</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="Packaging" class="col-sm-3 control-label">
							Packaging : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.packaging"
								class="form-control" placeholder="Enter Packaging">
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