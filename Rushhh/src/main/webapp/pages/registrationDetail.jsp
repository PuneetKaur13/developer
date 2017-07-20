<div class="container-fluid">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div style="margin-top: 100px;">
				<div class="flow-panel">

					<!-- Page Content -->
					<div id="page-wrapper">
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
									<input type="submit" value="Save" class="btn btn-success">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
