<style type="text/css">
th {
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
</style>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-primary">
				<!-- Default panel contents -->
				<div class="panel-heading" style="height: 50px;">
					<div class="col-xs-5 col-sm-6 col-md-8">
						<h4>Product Master</h4>
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
					<div class="alert alert-danger"
						ng-show="ctl.message != '' && ctl.message.success == true">
						<strong>{{ctl.message.msg}}</strong>
					</div>
					<div class="alert alert-success"
						ng-show="ctl.message != '' && ctl.message.success == false">
						<strong>{{ctl.message.msg}}</strong>
					</div>
					<div class="table-responsive">
						<table class="table table-bordered table-striped table-hover"
							ng-show="ctl.dataList.list.length>0">
							<thead class="text-uppercase">
								<tr>
									<th>#</th>
									<th>#</th>
									<th>ID</th>
									<th>Name</th>
									<th>BRAND</th>
									<th>GRADE</th>
									<th>MASTER RATE</th>
								</tr>
							</thead>
							<tbody>
								<tr ng-repeat="product in ctl.dataList.list">
									<td align="center"><input type="checkbox"
										checklist-model="ctl.checkedData.del"
										checklist-value="product.id"></td>
									<td align="center"><a href="#/Product/{{product.id}}"
										data-toggle="modal" data-target="#mainModal"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<td align="center">{{$index+1}}</td>
									<td>{{product.adminProductName}}</td>
									<td>{{product.brand}}</td>

									<td>{{product.grade}}</td>
									<td>{{product.masterrate}}</td>
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
						<label for="productName" class="col-sm-3 control-label">Product
							: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<select class="form-control inline" ng-model="ctl.selectedOption"
								ng-options="option.name for option in ctl.productList.list track by option.id"
								ng-change="ctl.form.data.adminProductId=ctl.selectedOption.id;ctl.form.data.adminProductName=ctl.selectedOption.name"
								required>
								<option value="">--Select--</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="brandname" class="col-sm-3 control-label">
							Brand Name : </label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.data.brand"
								class="form-control" placeholder="Enter Brand Name">
						</div>
					</div>
					<div class="form-group">
						<label for="grade" class="col-sm-3 control-label"> Grade :
							<span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<select class="form-control" ng-model="ctl.form.data.grade"
								ng-options="grade as grade for grade in ['Premium','A','B','C']"
								required>
								<option value="">--Select--</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="masterrate" class="col-sm-3 control-label">
							Master Rate : </label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.data.masterrate"
								class="form-control" placeholder="Enter Master Rate">
						</div>
					</div>
					<div class="form-group">
						<label for="mgfDate" class="col-sm-3 control-label">Effect
							From Date : </label>
						<div class="col-sm-7">
							<datepicker date-format="dd-MM-yyyy"> <input
								type="text" class="form-control"
								ng-model="ctl.form.data.effectfromdate" placeholder="DD-MM-YYYY" />
							</datepicker>
						</div>
					</div>
					<div class="form-group">
						<label for="description" class="col-sm-3 control-label">Description
							: </label>
						<div class="col-sm-7">
							<textarea type="text" ng-model="ctl.form.data.description"
								class="form-control" placeholder="Enter Description"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="siteTypeId" class="col-sm-3 control-label">
							Image : </label>

						<div class="col-md-3">

							<input accept="image/*" type="file" file-model="ctl.form.file"
								id="fileUser" ng-model="ctl.form.file" placeholder="Enter Image"
								preview-class="img-thumbnail" preview-container="mediaHere"
								media-preview>
						</div>
						<div class="col-md-5">
							<div id="mediaHere" class="custom-preview"></div>
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
