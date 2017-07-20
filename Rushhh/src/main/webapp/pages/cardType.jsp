<style type="text/css">
th, .td, tr, td {
	white-space: inherit;
	text-align: center;
}
</style>
<div class="container">
	<div class="row">
		<div class="row">
			<div class="col-xs-7 col-sm-12" ng-show="ctl.button.go">
				<div class="col-md-5"></div>
				<div class="col-md-3">
					<h3>
						<b>Card Master</b>
					</h3>
				</div>
				<div class="text-right">
					<input type="hidden" ng-model="hidPageNoValue" /> <input
						type="hidden" ng-model="hidPageSize" /> <select
						class="form-control"
						style="width: 74px; height: 31px; display: inline;"
						ng-model="ctl.searchData.pageNo"
						ng-options="page as page for page in ctl.dataList.pageNoList">
					</select>
					<button type="submit" class="btn btn-primary btn-sm inline"
						id="Button2" name="command" ng-click="ctl.search()" value="Go">Go</button>
					<button type="submit" ng-disabled="!ctl.button.previous"
						class="btn btn-primary btn-sm inline" id="Button6" name="command"
						value="Previous" ng-click="ctl.previous()"><<</button>
					<button type="submit" ng-disabled="!ctl.button.next"
						class="btn btn-primary btn-sm inline" id="Button7" name="command"
						value="Next" ng-click="ctl.next()">>></button>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<input type="text " class="form-control text-capitalize"
					ng-model="ctl.searchData.name" placeholder="Search Card Type">
			</div>
			<div class="col-md-2">
				<button type="Submit" class="btn btn-primary"
					ng-click="ctl.search()">Search</button>
			</div>
		</div>
	</div>
	<br> <br>
	<div id="page-wrapper">
		<div class="table-responsive">
			<br>
			<div ng-show="ctl.searchMessage!=null"
				ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
				<strong>{{ctl.searchMessage}}</strong>
			</div>
			<table class="table table-bordered" fixed-header
				ng-show="ctl.dataList.list.length>0">
				<thead class="text-uppercase">
					<tr>
						<th>#</th>
						<th>Card Type</th>
						<th>Points</th>
						<th>Conversion Factor</th>
						<th>#</th>
						<th>#</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="card in ctl.dataList.list">
						<td>{{ctl.index+($index+1)}}</td>
						<td align="center">{{card.name}}</td>
						<td align="center">{{card.points}}</td>
						<td align="center">{{card.conversionFactor}}</td>
						<td align="center"><input type="checkbox"
							checklist-model="ctl.checkedData.del" checklist-value="card.id"></td>
						<td align="center"><a href="" ng-click="ctl.display(card.id)"
							data-toggle="modal" data-target="#mainModal"><span
								class="glyphicon glyphicon-pencil"></span></a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row">
		<div class="col-md-5"></div>
		<div class="col-md-4">
			<button type="Submit" class="btn btn-primary btn-md"
				data-toggle="modal" data-target="#mainModal"
				ng-click="ctl.display(0)">Add</button>
			<button type="Submit" class="btn btn-danger"
				ng-show="ctl.button.remove" ng-click="ctl.removeAll()">Delete</button>
		</div>
	</div>
</div>

<div class="modal fade" id="mainModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<div class="pull-right">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				</div>
				<h3 class="modal-title">Add Card</h3>
			</div>
			<form class="form-horizontal" role="form" ng-submit="ctl.submit()">
				<div class="modal-body">
					<div ng-show="ctl.message!=null"
						ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
						<strong>{{ctl.message}}</strong>
					</div>
					<div class="form-group">
						<label for="type" class="col-sm-3 control-label "> Card
							Type : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.name"
								class="form-control text-capitalize"
								placeholder="Enter Card Type" required>
						</div>
					</div>
					<div class="form-group">
						<label for="type" class="col-sm-3 control-label"> Points :
							<span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.points"
								class="form-control" placeholder="Enter Card Points" required>
						</div>
					</div>
					<div class="form-group">
						<label for="type" class="col-sm-3 control-label">
							Conversion Factor : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.conversionFactor"
								class="form-control" placeholder="Enter Conversion Factor"
								required>
						</div>
					</div>
					<div class="modal-footer">
						<div class="col-md-4"></div>
						<div class="col-md-2">
							<input type="submit" class="btn btn-primary btn-md" value="Save"
								class="btn btn-success">&nbsp;
						</div>
						<div class="col-md-1">
							<button type="button" class="btn btn-danger btn-sm"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
