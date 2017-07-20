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
				<div class="panel-heading"
					style="height: 50px; background-color: #357AE8;"">
					<div class="col-xs-5 col-sm-6 col-md-8">
						<h4>My Favourite Seller's</h4>
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
					<div class="table-responsive">
						<table>
							<tr>
								<td><input type="text" class="form-control"
									ng-model="ctl.searchData.stateName"
									placeholder="Search State Name"></td>
								<td style="text-align: left;">&emsp;<input type="submit"
									class="btn btn-success" ng-click="ctl.search()" value="Search"></td>
							</tr>
						</table>
						<table class="table table-bordered table-striped table-hover"
							ng-show="ctl.dataList.list.length>0">
							<thead class="text-uppercase">
								<tr>
									<th>#</th>
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
									<td align="center"><a href=""
										ng-click="ctl.display(message.id)" data-toggle="modal"
										data-target="#mainModal"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<td align="center">{{$index+1}}</td>
									<td align="center">{{message.favCompanyName}}</td>
									<td align="center">{{message.productName}}</td>
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
						<label for="state" class="col-sm-4 control-label">Commodity
							: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<select class="form-control inline" ng-model="ctl.form.productId"
								ng-options="option.id as option.name for option in ctl.dataList.preload.productList"
								ng-change="ctl.findByUserCompanyProduct(ctl.form.productId);"
								required>
								<option value="">--Select--</option>
							</select>
							<!-- 	<select class="form-control inline" ng-model="ctl.selectedOption"
								ng-options="option.name for option in ctl.productList.list track by option.id"
								ng-change="ctl.form.productId=ctl.selectedOption.id;ctl.form.productName=ctl.selectedOption.name;ctl.findByProduct(ctl.selectedOption.id)"
								required>
								<option value="">--Select--</option>
							</select> -->
						</div>
					</div>
					<div class="form-group">
						<label for="state" class="col-sm-4 control-label">Company
							: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-4">

							<select class="form-control inline" ng-model="ctl.form.companyId"
								ng-options="option.companyId as option.companyName for option in ctl.userCompanyProductList">
								<option value="">--Select--</option>
							</select>

							<!-- <select class="form-control inline"
								ng-model="ctl.selectedOptionSeller"
								ng-options="option.companyName for option in ctl.sellerList.list track by option.groupId"
								ng-change="ctl.form.companyId=ctl.selectedOptionSeller.companyId;ctl.form.companyName=ctl.selectedOptionSeller.companyName"
								required>
								<option value="">--Select--</option>
							</select> -->
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
