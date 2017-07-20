<%@page import="com.ncs.dto.CompanyDTO"%>
<%@page import="com.nenosystems.common.dto.UserContext"%>
<%@page import="com.ncs.dto.UserDTO"%>
<%
	UserContext ctx = (UserContext) session.getAttribute("ctx");
	UserDTO user = new UserDTO();
	if (ctx == null) {
		ctx = new UserContext();
	}
	user = (UserDTO) ctx.getBaseDTO();
	//String type = (String) session.getAttribute("type");
%>

<style type="text/css">
/* Put your css in here */
multiselect {
	display: block;
}

multiselect .btn {
	width: 100%;
	background-color: #FFF;
}

multiselect .btn.error {
	border: 1px solid #da4f49 !important;
}

multiselect .dropdown-menu {
	max-height: 300px;
	overflow-y: auto;
}

multiselect .dropdown-menu {
	width: 100%;
	box-sizing: border-box;
	padding: 2px;
}

multiselect .dropdown-menu>li>a {
	padding: 3px 10px;
	cursor: pointer;
}

th {
	text-align: center;
	white-space: nowrap;
}

h4, .h4 {
	margin-top: 4px;
}

input[type="checkbox"] {
	margin: 0 10px 0 10px;
}
</style>

<script type="text/javascript">
	$().ready(
			function() {
				$('#add').click(
						function() {
							return !$('#select1 option:selected').remove()
									.appendTo('#select2');
						});
				$('#remove').click(
						function() {
							return !$('#select2 option:selected').remove()
									.appendTo('#select1');
						});
			});
</script>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Company</h3>
				</div>
				<!-- Table -->
				<div id="page-wrapper">
					<form class="form-horizontal" role="form"
						ng-submit="ctl.updateProfile()">
						<div class="row">
							<div ng-show="ctl.progress!=''">
								<div ng-show="ctl.message!=null"
									ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
									<strong>{{ctl.message}}</strong>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3 text-capitalize"
										for="text">Company Name : <span style="color: red;">*</span>
									</label>
									<div class="col-sm-7">
										<input type="text" ng-model="ctl.form.companyName"
											class="form-control text-capitalize"
											placeholder="Enter Company Name" readonly="readonly" required />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3" for="text">Contact
										Person : <span style="color: red;">*</span>
									</label>
									<div class="col-sm-4">
										<input style='width: 90%' type="text"
											ng-model="ctl.form.firstName" id="name"
											class="form-control text-capitalize"
											placeholder="Enter First Name" readonly="readonly" required />
									</div>
									<div class="col-sm-4">
										<input style='width: 90%' type="text"
											ng-model="ctl.form.lastName" id="name1"
											class="form-control text-capitalize"
											placeholder="Enter Last Name" readonly="readonly" required />
									</div>
								</div>
								<div class="form-group">
									<label for="shortName" class="col-sm-3 control-label">Image
										: {{ctl.uploadForm.uploadMessage}}</label>
									<div class="col-sm-7">
										<img ng-src="/OCBS/upload/{{ctl.form.imagePath}}"
											id="mediaHere" class="img-rounded" style="max-width: 150px;"
											ng-show="ctl.form.imagePath!=''"> <input
											accept="image/*" type="file" file-model="ctl.uploadForm.file"
											id="fileUser" ng-model="ctl.uploadForm.file"
											preview-class="img-thumbnail" preview-container="mediaHere"
											media-preview ng-change="ctl.upload();">
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3" for="text">Designation/Job
										Title : <span style="color: red;">*</span>
									</label>
									<div class="col-sm-7">
										<select class="form-control" ng-model="ctl.form.designation">
											<option value="">--Select--</option>
											<option value="Proprieter">Proprieter</option>
											<option value="Managing Director">Managing Director</option>
											<option value="Marketing Manager">Marketing Manager</option>
											<option value="Operator">Operator</option>
											<option value="Other">Other</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-7 col-md-push-3">
										<input type="text" ng-model="ctl.form.designationOther"
											ng-show="ctl.form.designation=='Other'"
											class="form-control text-capitalize"
											placeholder="Other Please Specify"
											ng-required="ctl.form.designation=='Other'" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3" for="text">CEO
										Name : </label>
									<div class="col-sm-4">
										<input style='width: 90%' type="text"
											ng-model="ctl.form.ceoName" id="namec"
											class="form-control text-capitalize"
											placeholder="Enter First Name" />
									</div>
									<div class="col-sm-4">
										<input style='width: 90%' type="text"
											ng-model="ctl.form.ceoLast" id="namec1"
											class="form-control text-capitalize"
											placeholder="Enter Last Name" />
									</div>
								</div>
								<div class="form-group">
									<label for="state" class="col-sm-3 control-label">State
										: <span style="color: red;">*</span>
									</label>
									<div class="col-sm-3">
										<select class="form-control inline"
											ng-model="ctl.form.stateId"
											ng-options="option.id as option.stateName for option in ctl.dataList.preload.stateList | orderBy:'stateName'"
											ng-change="ctl.findCity(ctl.form.stateId)" required>
											<option value="">--Select--</option>
										</select>
									</div>
									<label for="state" class="col-sm-1 control-label">City
										: <span style="color: red;">*</span>
									</label>
									<div class="col-sm-3">
										<select class="form-control inline" ng-model="ctl.form.cityId"
											ng-options="option.id as option.cityName for option in ctl.cityList  | orderBy:'cityName'"
											required>
											<option value="">--Select--</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3" for="text">Mobile
										No. : <span style="color: red;">*</span>
									</label>
									<div class="col-sm-4">
										<input type="text" class="form-control"
											ng-model="ctl.form.phoneNo" ui-br-phone-number name="phoneNo"
											placeholder="Enter Mobile No." required />
									</div>
									<div class="col-sm-4">
										<input type="text" ng-model="ctl.form.phoneNo1"
											ui-br-phone-number class="form-control"
											placeholder="Enter Alternate Mobile No." />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3" for="email">Primary
										E-mail : <span style="color: red;">*</span>
									</label>
									<div class="col-sm-7">
										<input type="email" ng-model="ctl.form.primaryEmail"
											class="form-control" placeholder="Enter Email Id" required />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3" for="email">Alternate
										E-mail : </label>
									<div class="col-sm-7">
										<input type="email" ng-model="ctl.form.alternateEmail"
											class="form-control" placeholder="Enter Alternate Email" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3" for="text">
										Website : </label>
									<div class="col-sm-7">
										<input type="text" placeholder="www.abc.com"
											ng-model="ctl.form.website" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-3" for="bankName">PAN
										No. :<span style="color: red;">*</span>
									</label>
									<div class="col-sm-7">
										<input type="text" class="form-control"
											placeholder="Enter PAN No." class="input-xlarge"
											title="Please enter a valid pan no."
											ng-model="ctl.form.panNo" required>
									</div>
								</div>
								<!-- pattern="^[\w]{3}(p|P|c|C|h|H|f|F|a|A|t|T|b|B|l|L|j|J|g|G)[\w][\d]{4}[\w]$ -->
								<div class="form-group">
									<label class="control-label col-sm-3" for="branchAddress">TIN
										No :<span style="color: red;">*</span>
									</label>
									<div class="col-sm-7">
										<input type="text" class="form-control"
											placeholder="Enter TIN No." class="input-xlarge"
											ng-model="ctl.form.tinNo" required>
									</div>
								</div>
							</div>
							<div class="pull-right">
								<input type="submit" value="Save" class="btn btn-success">
							</div>
					</form>
				</div>

			</div>
		</div>
	</div>
</div>




<!-- /.modal-content -->
<

<!-- Product Modal -->
<div class="modal fade" id="productModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="ProductLabel"></h4>
			</div>
			<form class="form-horizontal" role="form"
				ng-submit="ctl.addProduct()">
				<div class="modal-body">
					<div class="alert alert-danger"
						ng-show="ctl.message != '' && ctl.message.success == false">
						<strong>{{ctl.message.msg}}</strong>
					</div>
					<div class="alert alert-success"
						ng-show="ctl.message != '' && ctl.message.success == true">
						<strong>{{ctl.message.msg}}</strong>
					</div>
					<div class="form-group">
						<label for="state" class="col-sm-4 control-label">Commodity
							: <span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<select class="form-control inline" ng-model="ctl.selectedOption"
								ng-options="option.name for option in ctl.productList.list track by option.id"
								ng-change="ctl.form.productId=ctl.selectedOption.id;ctl.form.productName=ctl.selectedOption.name;">
								<option value="">--Select--</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="state" class="col-sm-4 control-label">Register
							yourself as : <span style="color: red;">*</span>
						</label>
						<div class="col-sm-7">
							<select class="form-control" ng-model="ctl.form.productType"
								required>
								<option value="">--Select--</option>
								<option value="Seller">Seller</option>
								<option value="Buyer">Buyer</option>
								<option value="Both">Both</option>
							</select>
						</div>
					</div>
					<div class="modal-footer">
						<input type="submit" value="Save" class="btn btn-success">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>

