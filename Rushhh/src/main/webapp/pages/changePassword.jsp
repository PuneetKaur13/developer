<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-8">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">
					<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
					Change Password
				</h3>
			</div>
			<div id="page-wrapper">
				<form class="form-horizontal" role="form"
					ng-submit="ctl.changeMyPassword()">
					<div class="modal-body">
						<div ng-show="ctl.message!=null"
							ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
							<strong>{{ctl.message}}</strong>
						</div>
						<div class="form-group">
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-3 control-label">Current
									Password :</label>

								<div class="col-sm-6">
									<input type="password" class="form-control"
										ng-model="ctl.form.password" placeholder="Current Password"
										required>
								</div>
							</div>

							<div class="form-group">
								<label for="inputEmail3" class="col-sm-3 control-label">New
									Password :</label>

								<div class="col-sm-6">
									<input type="password" required 
										title="Minimum 8 characters required." class="form-control"
										ng-model="ctl.form.newPassword" placeholder="New Password">
								</div>
							</div>
							<div class="row">
								<div class="col-sm-3"></div>
								<div class="col-sm-3">
									<span id="8char" class="glyphicon glyphicon-remove"
										style="color: #FF0004;"></span>8 Characters Long
								</div>
							</div>
							<br />
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-3 control-label">Confirm
									New Password :</label>
								<div class="col-sm-6">
									<input type="password" class="form-control"
										ng-model="ctl.form.confirmPassword" 
										title="Minimum 8 characters required."
										placeholder="Confirm New Password" required>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-3"></div>
								<div class="col-sm-6">
									<span id="pwmatch" class="glyphicon glyphicon-remove"
										style="color: #FF0004;"></span>Passwords Match
								</div>
							</div>
							<br />
							<div class="row">
								<div class="col-md-2 col-md-offset-3">
									<input type="submit" class="btn btn-primary"
										value="Change Password">
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<!-- /#page-wrapper -->
	</div>
	<div class="col-md-2"></div>
</div>