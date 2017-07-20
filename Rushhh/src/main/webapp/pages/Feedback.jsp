<center><h3>Feedback Form</h3></center>
<br><br>
<div class="container">
	<div class="row">
		<form class="form-horizontal" role="form" ng-submit="ctl.submit()">
			<label for="Name" class="col-sm-2 control-label"> Name : <span
					style="color: red;">*</span>
			</label>
			<div class="col-sm-10">
				<input type="text" ng-model="ctl.form.name"
					 placeholder="Enter Name" required>
			</div>
			<label for="Email" class="col-sm-2 control-label"> Email : <span
				style="color: red;">*</span>
			</label>
			<div class="col-sm-10">
				<input type="email" ng-model="ctl.form.email"
					 placeholder="Enter Email" required>
		    </div>
			<label for="feedback" class="col-sm-2">Feedback : </label>
			<div class="col-sm-10">
				<textarea type="text" ng-model="ctl.form.feedback"
					 placeholder="Enter Feedback"></textarea>
			</div>
			<div class="col-md-3"></div>
			<div class="col-md-1">
				<input type="submit" class="btn btn-primary btn-md" value="Save"
					class="btn btn-success" ng-click="ctl.submit()">&nbsp;
			</div>
			<div class="col-md-1">
				<input type="reset" class="btn btn-danger btn-md" value="Clear">
			</div>
			<!--  <div
				ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}"
				style="text-align: center">
				<strong>{{ctl.message}}</strong>
			</div>	-->
		</form>
	</div>	
</div>