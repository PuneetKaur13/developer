<!--header-->
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id"
	content="426844701468-9tqj2cjgk3hvum91l4mvs8npuoaurc4h.apps.googleusercontent.com">

<div class="container">
	<div id="sign_box">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<div class="login-rushhh">
					<h2 class="h_h2 wow zoomIn ">Sign in to your account</h2>
				</div>
				<br>
				<div ng-show="ctl.progress!=''">
					<div class="alert alert-danger" role="alert">
						<strong>{{ctl.progress}}</strong>
					</div>
				</div>
				<div class="login-right">
					<form ng-submit="ctl.login()">
						<div class="form-group">
							<input type="text" class="form-control input-lg"
								placeholder="Email or Phone" ng-model="ctl.form.loginId"
								required>
						</div>
						<div class="form-group">
							<input type="password" class="form-control input-lg"
								placeholder="Password" ng-model="ctl.form.password" required>
						</div>
						<input type="submit" value="Login">
					</form>
					<div></div>
					<div class="row">
						<div class=col-sm-12>
							<div class="social-icons" style="margin-right: 12ex">
								<google-plus-signin
									clientid="426844701468-9tqj2cjgk3hvum91l4mvs8npuoaurc4h.apps.googleusercontent.com"></google-plus-signin>

								<a href="https://www.facebook.com/"><i class="icon"></i></a>
								<!--  <a
									class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"><i
									class="icon2"></i></a> -->
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-4"></div>
			</div>
		</div>
	</div>
</div>
<!-- <style type="text/css">
.panel-default>.panel-heading {
	color: #333;
	background-color: #f5f5f5;
	border-color: #ddd;
}
</style>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-3 col-sm-offset-4">
			<div style="margin-top: 100px;">
				<div class="flow-panel">
					<div class="col-lg-12">
						<div class="panel panel-primary">
							<div class="panel-heading text-center custom-class "
								style="background-color: #64b5f6">
								<h4>
									<span><b>Rushhh.in</b></span>
								</h4>
							</div>
							<div id="page-wrapper">
								<div ng-show="ctl.progress!=''">
									<div class="alert alert-danger" role="alert">
										<strong>{{ctl.progress}}</strong>
									</div>
								</div>
								<form role="form" id="form" name="mainForm"
									ng-submit="ctl.login()">
									<div class="form-group">
										<input type="text" class="form-control input-sm"
											placeholder="Email or Phone" ng-model="ctl.form.loginId"
											required>
									</div>
									<div class="form-group">
										<input type="password" class="form-control input-sm"
											placeholder="Password" ng-model="ctl.form.password" required>
									</div>
									<input type="submit" class="btn btn-success btn-sm btn-block"
										style="background-color: #64b5f6" value="Login">
									<div class="form-group text-right">
										<a href="#/UserRegistration"><b>New User</b></a> | <a
											href="#/ForgetPassword">Forgot Password?</a>
									</div>
									<div class="form-group text-center">
										<a class="btn btn-block btn-social btn-facebook"> <span
											class="fa fa-facebook"></span> Sign in with Facebook
										</a>
									</div>
									<div class="form-group text-center">
										<a class="btn btn-block btn-social btn-google"> <span
											class="fa fa-google"></span> Sign in with Google
										</a>

									</div>

								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
 -->