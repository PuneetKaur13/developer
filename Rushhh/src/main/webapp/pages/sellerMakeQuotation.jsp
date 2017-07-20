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
.box {
	background: #2db34a;
	border-radius: 6px;
	cursor: pointer;
	height: 30px;
	font-family: 'Oswald', Helvetica;
	line-height: 30px;
	text-align: center;
	transition-property: background, border-radius;
	transition-duration: 1s;
	transition-timing-function: linear;
	width: 95px;
}

.box:hover {
	background: #ff7b29;
	border-radius: 50%;
}

.b {
	position: relative;
	-webkit-animation: mymove 4s infinite; /* Safari 4.0 - 8.0 */
	animation: mymove 5s infinite;
}

th {
	text-align: center;
	white-space: nowrap;
}

h4, .h4 {
	margin-top: 4px;
}

.modal-dialog {
	margin: 30px auto;
	width: 80%;
}

.nav-tabs>li.active>a, .nav-tabs>li.active>a:hover, .nav-tabs>li.active>a:focus
	{
	color: black;
	background-color: #187f06;
}

.colred {
	color: green;
	font-weight: bold;
}

.colgreen {
	color: #357AE8;
	font-weight: bold;
}
</style>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-primary">
				<!-- Default panel contents -->
				<div class="panel-heading" style="height: 50px;">
					<div class="col-xs-5 col-sm-6 col-md-8">
						<h4>Requirement Placed By Buyer</h4>
					</div>
					<div class="col-xs-7 col-sm-6 col-md-4" ng-show="ctl.button.go">
						<div class="text-right">
							<label class="h4">PageNo:&nbsp;</label> <input type="hidden"
								ng-model="hidPageNoValue" /> <input type="hidden"
								ng-model="hidPageSize" /> <select class="form-control"
								style="width: 74px; height: 31px; display: inline;"
								ng-model="ctl.searchData.pageNo"
								ng-options="page as page for page in ctl.dataList.pageNoList">
							</select>
							<button type="submit" class="btn btn-success btn-sm" id="Button2"
								name="command" ng-click="ctl.search()" value="Go">Go</button>
							<button type="submit" ng-disabled="!ctl.button.previous"
								class="btn btn-success btn-sm inline" id="Button6"
								name="command" value="Previous" ng-click="ctl.previous()"><<</button>
							<button type="submit" ng-disabled="!ctl.button.next"
								class="btn btn-success btn-sm inline" id="Button7"
								name="command" value="Next" ng-click="ctl.next()">>></button>
						</div>
					</div>
				</div>
				<!-- Table -->
				<div id="page-wrapper">
					<div ng-show="ctl.searchMessage!=null"
						ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
						<strong>{{ctl.searchMessage}}</strong>
					</div>

					<table>
						<tr>
							<td><select class="form-control"
								ng-model="ctl.searchData.status"
								ng-options="grade as grade for grade in ['ACTIVE','DEACTIVE','ABOUT TO OPEN','CLOSED']"
								required>
									<option value="">--Select--</option>
							</select></td>
							<td><input type="text" class="form-control"
								ng-model="ctl.searchData.productName"
								placeholder="Search Product"></td>
							<td style="text-align: left;">&emsp;<input type="submit"
								class="btn btn-success" ng-click="ctl.search()" value="Search"></td>
						</tr>
					</table>
					<div class="table-responsive">
						<br>

						<table class="table table-bordered table-striped table-hover"
							ng-show="ctl.dataList.list.length>0">
							<thead class="text-uppercase">
								<tr>
									<th>#</th>
									<th>Bid Ref No</th>
									<th>Product</th>
									<!-- <th>Company</th> -->
									<th>PACKAGING</th>
									<th>Original Quantity</th>
									<!-- <th>RATE</th> -->
									<th>AVAILABLE QUANTITY</th>
									<th>WON QUANTITY</th>
									<th>START DATE</th>
									<th>END DATE</th>
									<th>STATUS</th>
									<th>QUOTATION</th>
									<th>History</th>
									<%
										if (!user.getRoleName().equals("Existing Company")) {
									%>

									<th>Bid Invitation</th>
									<%
										}
									%>

								</tr>
							</thead>
							<tbody>
								<tr
									ng-repeat="bid in ctl.dataList.list  | orderBy:'timestamp':true">
									<td align="center">{{$index+1}}</td>
									<td align="center">{{bid.bidRefrenceNo}}</td>
									<td align="center">{{bid.productName}}</td>
									<td align="center">{{bid.packaging}}</td>
									<!-- <td align="center">{{bid.companyName}}</td> -->
									<td align="center">{{bid.remainingQuantity}} {{bid.unit}}</td>
									<!-- <td align="center">{{bid.expectedAmount}}</td> -->
									<td align="center">{{bid.quantity}} {{bid.unit}}</td>
									<td align="center" ng-show="bid.isRemainQuantity">{{bid.wonQuantity}}
										{{bid.unit}}</td>
									<td align="center" ng-show="!bid.isRemainQuantity">--</td>

									<td align="center">{{bid.startDate | date :'dd-MM-yyyy'}}</td>
									<td align="center">{{bid.enddate | date : 'dd-MM-yyyy'}}</td>
									<td align="center"><img src="images/{{bid.status}}.png"
										class="img-rounded" title="{{bid.status}}" width="25"
										height="25" ng-show="bid.status!=null"></td>
									<!-- ng-show="
												bid.approveUserId==<%=user.getId()%> -->
									<td align="center"><a href="" ng-click="ctl.getBidId(bid)"
										title="Add Quotation" data-toggle="modal"
										data-target="#mainModal"
										ng-show="bid.status!='CLOSED'&& bid.status!='ABOUT TO OPEN' && bid.approveUserId && bid.approveUserId==<%=user.getId()%>||bid.status!='CLOSED' && bid.status!='ABOUT TO OPEN' &&  bid.approveUserId==null"><span
											class="glyphicon glyphicon-plus-sign"></span></a> &nbsp; <a
										title="View Quotation" href="" data-toggle="modal"
										ng-click="ctl.viewQuotation(bid.productId,bid.cityId,bid.stateId,bid.packagingId)"
										data-target="#mainModaltwo"><span
											class="glyphicon glyphicon-eye-open"></span></a></td>

									<td align="center"><a title="View Counter Offers" href=""
										ng-click="ctl.viewCounterHistory(bid.bidId)"
										data-toggle="modal" data-target="#counterModal"><span
											class="glyphicon glyphicon-open-file"></span></a></td>
									<%
										if (!user.getRoleName().equals("Existing Company")) {
									%>
									<td align="center" ng-show="bid.status=='ACTIVE'"><label
										for="Latitude"
										ng-class="{colred:bid.inviteStatus=='Reject',colgreen: bid.inviteStatus=='Accept'}">{{bid.inviteStatus}}</label>
									</td>

									<td align="center" ng-show="bid.status=='ABOUT TO OPEN'">
										<button type="button" class="btn btn-success btn-xs"
											ng-click="ctl.accept(bid)"
											ng-show="bid.inviteStatus=='Reject' || bid.inviteStatus=='No Reply'">Accept</button>

										<label for="Latitude"
										ng-class="{colred:bid.inviteStatus=='Reject'}"
										ng-hide="bid.inviteStatus=='Reject' || bid.inviteStatus=='No Reply'">{{bid.inviteStatus}}</label>
										<button type="button" class="btn btn-danger btn-xs"
											ng-click="ctl.reject(bid)"
											ng-show="bid.inviteStatus=='Accept' || bid.inviteStatus=='No Reply'">Reject</button>
										<label for="Latitude"
										ng-class="{colgreen:bid.inviteStatus=='Accept'}"
										ng-hide="bid.inviteStatus=='Accept' || bid.inviteStatus=='No Reply'">{{bid.inviteStatus}}</label>
										<br /> <br /> &nbsp;
										<button
											ng-hide="bid.inviteStatus=='Reject' || bid.inviteStatus=='No Reply'"
											type="button" class="box"
											ng-click="ctl.companyUnder(bid.bidId,bid.inviteGroupId)"
											data-toggle="modal" data-target="#underUser">
											Allocate To</button> <label for="Latitude"
										ng-class="{colgreen:bid.inviteStatus=='Accept'}"
										ng-hide="bid.inviteStatus=='Accept' || bid.inviteStatus=='No Reply'">{{bid.inviteStatus}}
											Invitation</label>

									</td>
									<%
										}
									%>
								
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!--Add Quatation -->
<div class="modal fade" id="mainModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="width: 40%;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Add Quotation</h4>
			</div>

			<form class="form-horizontal" role="form"
				ng-submit="ctl.addQuotation()">
				<div class="modal-body">

					<div ng-show="ctl.message!=null"
						ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
						<strong>{{ctl.message.msg}}</strong>
					</div>
					<div class="form-group">
						<label for="unit" class="col-sm-3 control-label"> Unit : </label>
						<div class="col-sm-7">
							<input type="text" ng-model="ctl.form.unit" class="form-control"
								readonly="readonly">
						</div>
					</div>

					<div class="form-group">
						<label for="unit" class="col-sm-3 control-label"> Unit : </label>
						<div class="col-sm-7">
							<select class="form-control" ng-model="ctl.form.unit" required>
								<option value="">--Select--</option>
								<option value="KG">KG</option>
								<option value="MT">MT</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="quantity" class="col-sm-3 control-label">
							Quantity : </label>
						<div class="col-sm-7" ng-hide="ctl.form.unit=='KG'">
							<input type="text" ng-model="ctl.form.quantity"
								class="form-control">
						</div>
						<div class="col-sm-7" ng-show="ctl.form.unit=='KG'">
							<input type="text" ng-model="ctl.form.quantity*1000"
								class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label for="price" class="col-sm-3 control-label">Rate : <span
							style="color: red;">*</span>
						</label>
						<div class="col-sm-4">
							<input type="text" ng-model="ctl.form.quotationAmount"
								class="form-control" placeholder="Enter Rate" required>
						</div>
						<div class="col-sm-3">
							<select class="form-control" ng-init="a='KG'" ng-model="a">
								<option value="KG">KG</option>
								<option value="MT">MT</option>
							</select>
						</div>
					</div>
					<div class="form-group" ng-show="a=='KG'">
						<label for="price" class="col-sm-3 control-label">Rate/MT
							: </label>
						<div class="col-sm-3">
							<input type="text" ng-model="ctl.form.quotationAmount*1000"
								class="form-control" placeholder="Rate In MT" required>
						</div>

					</div>
					<div class="form-group" ng-show="a=='MT'">
						<label for="price" class="col-sm-3 control-label">Rate/KG
							: </label>
						<div class="col-sm-3">
							<input type="text" ng-model="ctl.form.quotationAmount/1000"
								class="form-control" placeholder="Rate In KG" required>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<input type="submit" value="Save" class="btn btn-success">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!--View Quatation -->
<div class="modal fade" id="mainModaltwo" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Quotation List</h4>
			</div>
			<div ng-show="ctl.searchMessage!=null"
				ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
				<strong>{{ctl.searchMessage}}</strong>
			</div>
			<form class="form-horizontal" role="form"
				ng-submit="ctl.addQuotation()">
				<div class="modal-body">

					<!-- Table -->
					<div id="page-wrapper" ng-show="ctl.viewQuotationList.length>0">
						<div class="table-responsive">
							<table class="table table-bordered table-striped table-hover"
								ng-show="ctl.dataList.list.length>0">
								<thead class="text-uppercase">
									<tr>
										<th>#</th>
										<th>PRODUCT</th>
										<th>User</th>
										<th>STATUS</th>
										<th>Quantity</th>
										<th>RATE</th>
										<th>RANK</th>
										<th>DATE & TIME</th>
								<tbody>
									<tr ng-repeat="bid in ctl.viewQuotationList">
										<td align="center">{{$index+1}}</td>
										<td align="center">{{bid.productName}}</td>
										<td align="center">{{bid.buyerName}}</td>
										<td align="center"
											ng-class="{colgreen:bid.status=='OPEN',colred:bid.status=='WON'}">{{bid.status}}</td>
										<td align="center">{{bid.quantity}} {{bid.unit}}</td>
										<td align="center">{{bid.quotationAmount}}</td>
										<td align="center">{{bid.rank}}/{{bid.counter}}</td>
										<td align="center">{{bid.timestamp |date:'dd-MM-yyyy @
											h:mma'}}</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</form>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<!-- View Counter -->
<div class="modal fade" id="counterModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="width: 90%">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Counter Offers</h4>
			</div>
			<div class="modal-body">
				<div ng-show="ctl.searchMessage!=null"
					ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}">
					<strong>{{ctl.searchMessage}}</strong>
				</div>
				<!-- Table -->
				<div id="page-wrapper" ng-show="ctl.viewCounterHistoryList.length>0">
					<div class="table-responsive">
						<table class="table table-bordered table-striped table-hover">
							<thead class="text-uppercase">
								<tr>
									<th style="background-color: #696969;">#</th>
									<th style="background-color: #696969">Offer By You</th>
									<th style="background-color: #696969">QUANTITY In MT</th>
									<th style="background-color: #696969;">RATE/KG</th>
									<th style="background-color: #696969;">Date & Time</th>
									<th style="background-color: #696969;">Counter Offer By
										Buyer</th>
									<th style="background-color: #696969;">Counter Offered
										Quantity</th>
									<th style="background-color: #696969;">Counter Rates</th>
									<th style="background-color: #696969;">offer Status</th>
									<th style="background-color: #696969;">Date & Time</th>
								</tr>
							</thead>
							<tbody>
								<tr
									ng-repeat="bid in ctl.viewCounterHistoryList | orderBy:'timestamp':true "
									ng-class="{colgreen:bid.offerBy=='Offer By Buyer',colred:bid.offerBy=='Offer By Seller'}">
									<!-- 	<td align="center"
											style="background-color: black;; font-weight: bold; color: #FFFFFF;">{{ctl.counterList.list.length-$index}}</td> -->

									<td align="center"
										style="background-color: black;; font-weight: bold; color: #FFFFFF;">{{$index+1}}</td>
									<td
										style="background-color: #187f06; font-weight: bold; color: #FFFFFF;"
										align="center">{{bid.offerBy}}</td>
									<td
										style="background-color: #187f06; font-weight: bold; color: #FFFFFF;"
										align="center">{{bid.quantity}} {{bid.unit}}</td>
									<td
										style="background-color: #187f06; font-weight: bold; color: #FFFFFF;"
										align="center">{{bid.quotationAmount}}</td>
									<td
										style="background-color: #357AE8; font-weight: bold; color: #FFFFFF;"
										align="center">{{bid.createdDate | date:'MM/dd/yyyy
										h:mma'}}</td>
									<td
										style="background-color: #357AE8; font-weight: bold; color: #FFFFFF;"
										align="center">{{bid.offerByBuyer}}</td>
									<td
										style="background-color: #357AE8; font-weight: bold; color: #FFFFFF;"
										align="center">{{bid.counterQuantity}}</td>
									<td
										style="background-color: #357AE8; font-weight: bold; color: #FFFFFF;"
										align="center">{{bid.counterAmount}}</td>
									<td
										style="background-color: #357AE8; font-weight: bold; color: #FFFFFF;"
										align="center">{{bid.status}}</td>
									<td
										style="background-color: #357AE8; font-weight: bold; color: #FFFFFF;"
										align="center">{{bid.counterDate | date:'MM/dd/yyyy @
										h:mma'}}</td>

								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<!-- Company Under User List -->
<div class="modal fade" id="underUser" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-sm" style="width: 80%;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">My Teams</h4>
			</div>
			<form class="form-horizontal" role="form"
				ng-submit="ctl.addQuotation()">
				<div class="modal-body">
					<div class="alert alert-danger"
						ng-show="ctl.companyUnderUserList.length==0">
						<strong>No Under User Found In Your Team...Plase Check
							Your Associates <a ng-click="ctl.checkAssociates()">ClickHere</a>
						</strong>
					</div>
					<!-- Table -->

					<div id="page-wrapper" ng-show="ctl.companyUnderUserList.length>0">
						<div class="table-responsive">
							<table class="table table-bordered table-striped table-hover">
								<thead class="text-uppercase">
									<tr>
										<th>Company</th>
										<th>Name</th>
										<th>Email</th>
										<th>Mobile No</th>
										<th>User Status</th>
										<th>Allocate Status</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>

									<tr ng-repeat="b in ctl.companyUnderUserList">
										<td align="center">{{b[0]}}</td>
										<td align="center">{{b[2]}} {{b[3]}}</td>
										<td align="center">{{b[6]}}</td>
										<td align="center">{{b[5]}}</td>
										<td align="center">{{b[8]}}</td>

										<td align="center"><label
											ng-show="b[9]==true && b[10]==b[11]" for="Latitude"><span
												style="color: blue;"><b>Allocate For Quote</b></span></label> <label
											ng-show="b[9]!=true || b[10]!=b[11]" style="color: red;">Not
												Allocate For Quote</label></td>
										<td align="center"><button type="button" class="box"
												ng-click="ctl.approveQuote(b)" ng-hide="b[11]!=null">
												<span>Allocate</span>
											</button>
											<button type="button" class="box"
												ng-click="ctl.approveQuote(b)"
												ng-show="b[10]==b[11] && b[8]=='APPROVED'">
												<span>Reallocate</span>

											</button> <span ng-show=" b[10]==b[11] && b[8]=='APPROVED'"
											style="color: blue;">Allocate</span> <span
											ng-show=" b[10]!=b[11]">Not Allocate</span>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</form>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>