<div class="container-fluid">
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<div style="margin-top: 100px;">
				<div class="flow-panel">
					<div class="panel panel-default">
						<!-- Default panel contents -->
						<div class="panel-heading" style="height: 90px;">
							<div class="col-sm-12">
							</div>
						</div>
						<!-- Page Content -->
						<div id="page-wrapper">
							<form class="form-horizontal" role="form"
								ng-submit="ctl.submitOTP()">
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
										<label for="countryName" class="col-sm-4 control-label">OTP
											: <span style="color: red;">*</span>
										</label>
										<div class="col-sm-8">
											<input type="text" ng-model="ctl.form.otp"
												class="form-control" placeholder="Enter OTP" required>
										</div>
									</div>
									<div class="modal-footer">
										<input type="button" value="Resend OTP"
											class="btn btn-success" ng-click="ctl.resendOTP()">&nbsp;
										<input type="submit" value="Submit" class="btn btn-success">
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