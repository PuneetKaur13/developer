<style type="text/css">
th, .td, tr, td {
	white-space: pre-wrap;
	text-align: center;
}
</style>
<div class="container">
	<div class="row">
		<div class="col-xs-7 col-sm-12" ng-show="ctl.button.go">
			<div class="col-md-5"></div>
			<div class="col-md-3">
				<h3>
					<b>System Setting</b>
				</h3>
			</div>
		</div>
	</div>
	<div id="page-wrapper">
		<form class="form-horizontal" role="form" ng-submit="ctl.submit()">
			<div class="modal-body">
				<div ng-show="ctl.message!=null"
					ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
					<strong>{{ctl.message}}</strong>
				</div>

				<div class="form-group">
					<label for="conversionfactor" class="col-sm-4 control-label">
						Conversion Factor :<span style="color: red;">*</span>
					</label>
					<div class="col-sm-7">
						<input type="text" ng-model="ctl.form.conversionFactor"
							class="form-control" placeholder="Enter ConversionFactor"
							required>
					</div>
				</div>

				<div class="form-group">
					<label for="recordsPerPage" class="col-sm-4 control-label">
						Records Per Page :<span style="color: red;">*</span>
					</label>
					<div class="col-sm-7">
						<input type="number" class="form-control"
							ng-model="ctl.form.recordsPerPage" min="0" max="9999" required>
					</div>
				</div>
				<div class="form-group">
					<label for="recordsPerPage" class="col-sm-4 control-label">
						Set Security Amount Factor :<span style="color: red;">*</span>
					</label>
					<div class="col-sm-7">
						<input type="text" class="form-control"
							ng-model="ctl.form.secuirityAmount" min="0" max="9999" required>
					</div>
				</div>
				<div class="form-group">
					<label for="recordsPerPage" class="col-sm-4 control-label">
						MOQ Quantity :<span style="color: red;">*</span>
					</label>
					<div class="col-sm-7">
						<input type="text" class="form-control"
							ng-model="ctl.form.quantity" min="0" max="9999" required>
					</div>
					<label for="status" class="col-sm-4 control-label"> Unit :
					</label>
					<div class="col-sm-7">
						<select class="form-control" ng-model="ctl.form.unit"
							ng-options="grade as grade for grade in ['MT','KG']" required>
							<option value="">--Select--</option>
						</select>
					</div>
				</div>

			</div>
			<div class="modal-footer">
				<input type="submit" value="Save" class="btn btn-primary"
					style="background-color: #64b5f6">
			</div>
		</form>
	</div>


<!-- <style type="text/css">
th {
	text-align: center;
	white-space: nowrap;
}

h4, .h4 {
	margin-top: 4px;
}
</style>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-5">
			<div class="panel panel-primary">
				<div class="panel-heading"style="background-color:#64b5f6">
					<h3 class="panel-title">System Setting</h3>
				</div>
				Table
				<div id="page-wrapper">
					<form class="form-horizontal" role="form" ng-submit="ctl.submit()">
						<div class="modal-body">
							<div ng-show="ctl.message!=null"
								ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
								<strong>{{ctl.message}}</strong>
							</div>

							<div class="form-group">
								<label for="conversionfactor" class="col-sm-4 control-label">
									Conversion Factor :<span style="color: red;">*</span>
								</label>
								<div class="col-sm-7">
									<input type="text" ng-model="ctl.form.conversionFactor"
										class="form-control" placeholder="Enter ConversionFactor"
										required>
								</div>
							</div>

							<div class="form-group">
								<label for="recordsPerPage" class="col-sm-4 control-label">
									Records Per Page :<span style="color: red;">*</span>
								</label>
								<div class="col-sm-7">
									<input type="number" class="form-control"
										ng-model="ctl.form.recordsPerPage" min="0" max="9999" required>
								</div>
							</div>
							<div class="form-group">
								<label for="recordsPerPage" class="col-sm-4 control-label">
									Set Security Amount Factor :<span style="color: red;">*</span>
								</label>
								<div class="col-sm-7">
									<input type="text" class="form-control"
										ng-model="ctl.form.secuirityAmount" min="0" max="9999"
										required>
								</div>
							</div>
							<div class="form-group">
								<label for="recordsPerPage" class="col-sm-4 control-label">
									MOQ Quantity :<span style="color: red;">*</span>
								</label>
								<div class="col-sm-7">
									<input type="text" class="form-control"
										ng-model="ctl.form.quantity" min="0" max="9999" required>
								</div>
								<label for="status" class="col-sm-4 control-label"> Unit
									: </label>
								<div class="col-sm-7">
									<select class="form-control" ng-model="ctl.form.unit"
										ng-options="grade as grade for grade in ['MT','KG']" required>
										<option value="">--Select--</option>
									</select>
								</div>
							</div>

						</div>
						<div class="modal-footer">
							<input type="submit" value="Save" class="btn btn-success"style="background-color:#64b5f6">
						</div>
					</form>
				</div>
				/.modal-content
			</div>
			/.modal-dialog
		</div>
	</div>
</div> -->