<style type="text/css">
th, .td, tr, td {
	white-space: pre-wrap;
	text-align: center;
}
</style>
<div class="container">
	<div class="row">
		<div class="col-xs-7 col-sm-12">
			<div class="col-md-5"></div>
			<div class="col-md-3">
				<h3>
					<b>Message</b>
				</h3>
			</div>
			<div class="text-right" ng-show="ctl.button.go">
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
			<input type="text" class="form-control"
				ng-model="ctl.searchData.type" placeholder="Search Type">
		</div>
		<div class="col-sm-2">
			<input type="text" class="form-control"
				ng-model="ctl.searchData.title" placeholder="Search Title">
		</div>
		<div class="col-md-2">
			<button type="Submit" class="btn btn-primary" ng-click="ctl.search()">Search</button>
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
						<th>TYPE</th>
						<th>TITLE</th>
						<th>MESSAGE</th>
						<th>CODE</th>
						<th>#</th>
						<th>#</th>
					</tr>
				</thead>
				<tbody>
					<tr
						ng-repeat="message in ctl.dataList.list | orderBy:'timestamp':true">
						<td align="center">{{$index+1}}</td>
						<td align="center">{{message.type}}</td>
						<td align="center">{{message.title}}</td>
						<td align="center">{{message.message}}</td>
						<td align="center">{{message.code}}</td>
						<td class="text-center"><a class='btn btn-info btn-xs'
							ng-click="ctl.display(message.id)" data-toggle="modal"
							data-target="#mainModal" href=""><span
								class="glyphicon glyphicon-edit"></span> Edit</a>
						<td align="center"><input type="checkbox"
							checklist-model="ctl.checkedData.del" checklist-value="message.id"></td>
					</tr>


				</tbody>

			</table>
		</div>
	</div>
	<div class="row">
		<div class="col-md-5"></div>
		<div class="col-md-4">
			<button type="Submit" class="btn btn-primary" data-toggle="modal"
				data-target="#mainModal" ng-click="ctl.display(0)">Add</button>
			<button type="button" class="btn btn-success"
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
				<h3 class="modal-title">Add Message</h3>
			</div>
			<form class="form-horizontal" role="form" ng-submit="ctl.submit()">
				<div class="modal-body">
					<div ng-show="ctl.message!=null"
						ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
						<strong>{{ctl.message}}</strong>
					</div>
					<div class="form-group">
						<label for="type" class="col-sm-5 control-label"><input
							type="radio" value="SMS" ng-model="ctl.form.type">SMS</label> <label
							for="type" class="col-sm-4 control-label"><input
							type="radio" value="EMAIL" ng-model="ctl.form.type">EMAIL</label>
					</div>
					<div class="form-group">
						<label for="type" class="col-sm-3 control-label"> Code : <span
							style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.code" class="form-control"
								placeholder="Enter Code" required>
						</div>
					</div>
					<div class="form-group">

						<label for="type" class="col-sm-3 control-label"> Title :
							<span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.title" class="form-control"
								placeholder="Enter Title" required>
						</div>
					</div>
					<div class="form-group">
						<label for="description" class="col-sm-3 control-label">Message
							: </label>
						<div class="col-sm-7">
							<textarea type="text" ng-model="ctl.form.message"
								class="form-control" placeholder="Enter Message" required></textarea>
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
