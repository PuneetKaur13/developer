<div class="container-fluid">
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<div class="panel panel-default">
				<div class="panel-body">
					<h4 class="verifiactio-rush">Registration Detail</h4>
				</div>
			</div>
			<form class="form-horizontal" role="form"
				ng-submit="ctl.submitCompany()">
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

					<div class="modal-footer">
						<input type="submit" value="Continue" class="btn btn-success">
					</div>
				</div>
			</form>
		<div class="col-sm-4"></div>
	</div>
</div>