<style type="text/css">
th {
	text-align: center;
	white-space: nowrap;
}

td {
	text-align: center;
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
				<div class="panel-heading" style="height: 50px;background-color:#64b5f6">
					<div class="col-md-2">
						<h4>Transaction History</h4>
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
				<br>
				<!-- Table -->
				<div id="page-wrapper">
					<div ng-show="ctl.progress!=''">
						<div ng-show="ctl.searchMessage!=null"
							ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
							<strong>{{ctl.searchMessage}}</strong>
						</div>
					</div>
					<div class="table-responsive">
						<table>
							<tr>
								<td><input type="text" class="form-control"
									ng-model="ctl.searchData.stateName"
									placeholder="Search State Name"></td>
								<td style="text-align: left;">&emsp;<input type="submit"
									class="btn btn-success" style="background-color:#64b5f6"ng-click="ctl.search()" value="Search"></td>
							</tr>
						</table>
						<br>
						<table class="table table-bordered table-striped table-hover"
							ng-show="ctl.dataList.list.length>0">
							<thead class="text-uppercase">
								<tr>
									<!-- 		<th>#</th>
									<th>#</th> -->
									<th>#</th>
									<th>TYPE</th>
									<th>DATE</th>
									<th>COMPANY</th>
			<!-- 						<th>USER</th> -->
									<th>POINTS</th>
									<th>AMOUNT</th>
								</tr>
							</thead>
							<tbody>
								<tr ng-repeat="role in ctl.dataList.list">
									<td align="center">{{$index+1}}</td>
									<td>{{role.type}}</td>
									<td>{{role.timestamp | date:'dd-MM-yyyy'}}</td>
									<td>{{role.companyName}}</td>
									<!-- <td>{{role.userName}}</td> -->
									<td><span class="fa fa-rupee" aria-hidden="true"></span>{{role.points}}</td>
									<td><span class="fa fa-rupee" aria-hidden="true"></span>
										{{role.amount}}</td>
								</tr>
							</tbody>
						</table>
						<button type="button" class="btn btn-success" style="background-color:#64b5f6"data-toggle="modal"
							data-target="#mainModal" ng-click="ctl.addModal()">New
							Transaction</button>
						<!-- <button type="button" class="btn btn-success"
							ng-show="ctl.dataList.list.length>0" ng-click="ctl.deleteData()">Delete</button> -->
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
			<div class="modal-header"style="background-color:#64b5f6">
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
						<label for="type" class="col-sm-5 control-label"><input
							type="radio" value="Payment" name="content"
							ng-model="ctl.form.type">Payment</label> <label for="type"
							class="col-sm-4 control-label"><input type="radio"
							value="Received" ng-model="ctl.form.type">Received</label>

					</div>

					<div class="form-group">
						<label for="role" class="col-sm-3 control-label">Company :
							<span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<select class="form-control inline" ng-model="ctl.form.companyId"
								ng-options="option.id as option.value for option in ctl.dataList.preload.companyList"
								required>
								<option value="">--Select--</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="text">Amount :
							<span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.amount"
								class="form-control" placeholder="Enter Amount" required />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="text">Points :
							<span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.points"
								class="form-control" placeholder="Enter Points" required />
						</div>
					</div>
					<div class="form-group">
						<label for="DOB" class="col-sm-3 control-label">Date : <span
							style="color: red;">*</span></label>
						<div class="col-sm-7">
							<datepicker date-format="dd-MM-yyyy"> <input
								type="text" class="form-control" ng-model="ctl.form.timestamp"
								placeholder="DD-MM-YYYY" required /> </datepicker>
						</div>
					</div>
					<div class="form-group">
						<label for="description" class="col-sm-3 control-label">Description
							: </label>
						<div class="col-sm-7">
							<textarea type="text" ng-model="ctl.form.description"
								class="form-control" placeholder="Enter Description"></textarea>
						</div>
					</div>
					<div class="modal-footer">
						<input type="submit" value="Save" class="btn btn-success"style="background-color:#64b5f6">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>