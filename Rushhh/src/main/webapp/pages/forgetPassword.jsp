<div class="container-fluid">
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<div style="margin-top: 100px;">
				<div class="flow-panel">
					<div class="panel panel-primary">
						<!-- Default panel contents -->
						<div class="panel-heading">
							<h4 class="text-center">Forget Password</h4>
						</div>
						<!-- Page Content -->
						<div id="page-wrapper">
							<form class="form-horizontal" role="form"
								ng-submit="ctl.forgetP()">
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
										<label for="countryName" class="col-sm-3 control-label">Email
											: <span style="color: red;">*</span>
										</label>
										<div class="col-sm-8">
											<input type="text" ng-model="ctl.form.loginId"
												class="form-control" placeholder="Enter Email" required>
										</div>
									</div>
									<div class="modal-footer">
										<input type="submit" value="Reset Your Password"
											class="btn btn-success">
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>