<!-- <div class="container-fluid">
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<div style="margin-top: 100px;">
				<div class="flow-panel">
					<div class="panel panel-primary">

						<div class="panel-heading">
							<h4 class="text-center">User Registration</h4>
						</div>
						<div id="page-wrapper">
							<form class="form-horizontal" role="form"
								ng-submit="ctl.submitOTP()">
								<div class="modal-body">
									<div ng-show="ctl.message!=null"
										ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
										<strong>{{ctl.message}}</strong>
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
											class="btn btn-primary" ng-click="ctl.resendOTP()">&nbsp;
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
 -->
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<div class="panel panel-default">
				<div class="panel-body">
					<h4 class="verifiactio-rush">OTP Verification</h4>
				</div>
			</div>
			<div class="enetr">
				<h4>Please Enter Your OTP</h4>
			</div>
			<form ng-submit="ctl.submitOTP()">
					<div ng-show="ctl.message!=null"
						ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
						<strong>{{ctl.message}}</strong>
					</div>
					<div class="form-group">
						<input type="Text" class="form-control" placeholder=" Enter OTP"
							ng-model="ctl.form.otp" required="required">
					</div>
					<div class="login-right">
						<input type="submit" value="Verify OTP" class="otp-rush-button">
					</div>
					<div class="login-right">
						<input type="button" class="btn btn-primary" value="Resend OTP"
							class="otp-rush-button" ng-click="ctl.resendOTP()">
					</div>
				</form>
			
		</div>
		<div class="col-sm-4"></div>
	</div>
</div>
