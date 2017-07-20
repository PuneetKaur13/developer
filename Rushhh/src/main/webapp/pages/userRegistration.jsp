<div class="container-fluid">
	<div class="row">
		<div class="col-sm-6 col-sm-offset-3">
			<div class="flow-panel">
				<div class="login-grids">
					<div class="login">
						<div class="login-right">
							<form ng-submit="ctl.registerData()">
								<h3>Register</h3>
								<br>
								<div ng-show="ctl.message!=null"
									ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
									<strong>{{ctl.message}}</strong>
								</div>
								<input type="text" ng-model="ctl.form.firstName"
									class="form-control input-lg text-capitalize"
									placeholder="Enter First Name" required="required"> <input
									type="text" ng-model="ctl.form.lastName"
									class="form-control input-lg text-capitalize"
									placeholder="Enter Last Name" required="required"> <br>
								<input type="email" ng-model="ctl.form.loginId"
									class="form-control input-lg" placeholder="Enter Email "
									required> <input type="password"
									ng-model="ctl.form.password" pattern="^\w{8,}$"
									title="Minimum 8 characters required."
									class="form-control input-lg" placeholder="Enter Password"
									required="required"> <input type="text"
									ng-model="ctl.form.mobile" pattern="[789][0-9]{9}"
									class="form-control input-lg" title="Invalid Mobile Number"
									placeholder="Enter 10 Digits Mobile Number "
									required="required"><input type="submit"
									value="Register Now">
							</form>
						</div>
						<div class="clearfix"></div>
					</div>
					<!--  ui-br-phone-number-->
				</div>
			</div>
		</div>
	</div>
</div>
