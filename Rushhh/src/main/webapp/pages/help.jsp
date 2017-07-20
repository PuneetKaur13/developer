<script>
	$(function() {
		$(".expand").on("click", function() {
			$(this).next().slideToggle(200);
			$expand = $(this).find(">:first-child");

			if ($expand.text() == "+") {
				$expand.text("-");
			} else {
				$expand.text("+");
			}
		});
	});
</script>

<style>
*, *:before, *:after {
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

#integration-list {
	font-family: 'Open Sans', sans-serif;
	width: 80%;
	margin: 0 auto;
	display: table;
}

#integration-list ul {
	padding: 0;
	margin: 20px 0;
	color: #555;
}

#integration-list ul>li {
	list-style: none;
	border-top: 1px solid #ddd;
	display: block;
	padding: 15px;
	overflow: hidden;
}

#integration-list ul:last-child {
	border-bottom: 1px solid #ddd;
}

#integration-list ul>li:hover {
	background: #efefef;
}

.expand {
	display: block;
	text-decoration: none;
	color: #555;
	cursor: pointer;
}

h2 {
	padding: 0;
	margin: 0;
	font-size: 17px;
	font-weight: 400;
}

span {
	font-size: 12.5px;
}

#left, #right {
	display: table;
}

#sup {
	display: table-cell;
	vertical-align: middle;
	width: 80%;
}

.detail a {
	text-decoration: none;
	color: #C0392B;
	border: 1px solid #C0392B;
	padding: 6px 10px 5px;
	font-size: 14px;
}

.detail {
	margin: 10px 0 10px 0px;
	display: none;
	line-height: 22px;
	height: 150px;
}

.detail span {
	margin: 0;
}

.right-arrow {
	margin-top: 12px;
	margin-left: 20px;
	width: 10px;
	height: 100%;
	float: right;
	font-weight: bold;
	font-size: 20px;
}

.icon {
	height: 75px;
	width: 75px;
	float: left;
	margin: 0 15px 0 0;
}

.london {
	background: url("http://placehold.it/50x50") top left no-repeat;
	background-size: cover;
}

.newyork {
	background: url("http://placehold.it/50x50") top left no-repeat;
	background-size: cover;
}

.paris {
	background: url("http://placehold.it/50x50") top left no-repeat;
	background-size: cover;
}
</style>

<div class="container-fluid">
	<div class="row">
		<div class="panel panel-primary">
			<div class="panel-heading"style="background-color:#64b5f6">
				<h3 class="panel-title">
					<span class="glyphicon glyphicon-tower" aria-hidden="true"></span><b>Help
						Center </b>
				</h3>
			</div>
			<div id="page-wrapper">

				<div id="integration-list">
					<div class="panel-panel-primary">
						<ul>
							<li><a class="expand">
									<div class="right-arrow">+</div>
									<div>
										<h2>Get started </h2>
									</div>
							</a>

								<div class="detail">
									<!-- <div id="left" style="width: 15%; float: left; height: 100%;">
										<div id="sup">
											<img src="http://www.ciagent.com/ciagent/cialogo4.png"
												width="100%" />
										</div>
									</div> -->
									<div id="right"
										style="width: 85%; float: right; height: 100%; padding-left: 20px;">
										<div id="sup">
											<div>
												<span></span> <br /> <br /> <a href="www.Rushhh.in">Visit
													Website</a>
											</div>
										</div>
									</div>
								</div></li>
							<li><a class="expand">
									<div class="right-arrow">+</div>
									<h2>Register Your Self</h2>
							</a>

								<div class="detail">
									<div id="left" style="width: 15%; float: left; height: 100%;">

									</div>
									<div id="right"
										style="width: 85%; float: right; height: 100%; padding-left: 20px;">
										<div id="sup">
											<div>
												<span><b>Registration-</b></span> <br /> <span><b>Step-1:
												</b></span><br />

												<p>
													As you don't have any account yet, you need to create one.
													Click on <b>New user</b>
												</p>
												<br /> <span><b>Step-2:</b> </span><br />
												<p>To set up your new account, we need some information
													about you – Enter your first and last names, your Email id,
													mobile number and your password. The Mobile number and
													email address that you wish to use for login. Fill out the
													rest of your information. You will need to ensure that the
													Mobile number you enter is valid otherwise you will unable
													to proceeds further.</p>
												<br /> <br /> <span><b>Step-3: Click on
														Register.</b> </span><br />
												<p>To set up your new account, we need some information
													about you – Enter your first and last names, your Email id,
													mobile number and your password. The Mobile number and
													email address that you wish to use for login. Fill out the
													rest of your information. You will need to ensure that the
													Mobile number you enter is valid otherwise you will unable
													to proceeds further.</p>
												<br /> <br />
											</div>
											<!-- OTP Auth -->
											<div>
												<span><b>OTP Authentication-</b></span> <br /> <span><b>Step-1:
												</b></span><br />
												<p>Enter OTP which you received on your registered
													Mobile number and click on submit.</p>
												<br /> <span><b>Step-2:</b> </span><br />
												<p>If you don’t received OTP then no need to worry click
													on Resend OTP.</p>
												<br /> <br /> <span><b>Step-3:</b> </span><br />
												<p>While you submit your OTP you will redirect to next
													page.</p>

											</div>

										<!--  <div>
												<span><b>Choose your company-</b></span>

												<p>If you are choosing Existing Company you will be
													under the particular company. • If you are choosing New
													Company you will be Admin of the company.</p>

												<p>If you are choosing Existing Company you will be
													under the particular company. • If you are choosing New
													Company you will be Admin of the company.</p>
											</div>
											<div>
												<span><b>New Company-</b></span> <br /> <span>Some
													steps which are necessary to create your own company which
													are as follow-</span><br /> <span><b>Step-1:</b></span><br />
												<p>Enter your company and click on save.</p>
												<br /> <span><b>Step-2:</b> </span><br />
												<p>As you click on save button you will redirecting to
													company page. Here you can view an editable company form is
													displaying .In this company form some of your details like
													Company name, Contact person, Mobile number, Email id is
													already filled. Remaining mandatory fields you have to fill
													which are as Designation, State, City, TIN Number and PAN
													Number.</p>
												<br /> <br /> <span><b>Step-3:</b> </span><br />
												<p>When you filled all mandatory fields click on save.
													You will receive notification Congrats!...Your company has
													been registered. You are the Admin of this company and all
													other user of this company will be under you.</p>
												<br /> <span><b>Steps-4:</b> </span><br />
												<p>To manage your product click on below link. You will
													redirecting to manage product you can choose your
													particular product from here. Also you can select your type
													from here as Seller, Buyer and Both.</p>

											</div>

											<div>
												<span><b>Manage Product-</b></span> <br /> <span>For
													manage your product go to- are as follow-</span><br /> <br>
												<div class="form-group">
													<div class="col-sm-6">
														<button type="button" class="btn btn-primary form-inline">Setting</button>
														<span class="form-inline"><b> < </b>-------------------------------<b>></b></span>
														<button type="button" class="btn btn-danger form-inline">ManageProduct</button>
													</div>
												</div>
											</div>
											<div>
												<br /> <br /> <span><b>Existing Company-</b></span> <br />
												<br />

												<p>If you are choosing existing company you are under
													the Admin of particular company. All rights are reserved to
													admin of company. Your product and type will be are already
													defined by admin. Once you fill all details you will not
													have rights to make any change. By default your status will
													be deactivate only admin will activate your status. Some
													steps which are necessary to create your company which are
													as follows-</p>
												<br /> <span><b>Step-1:</b> </span><br />
												<p>Select your company from dropdown and click on save.
													You will directly redirecting to dashboard.</p>
												<br /> <br /> <br /> <a href="#">Visit Website</a>
											</div>

										</div>
									</div> -->

								</div></li>
							<li><a class="expand"> 
									<div class="right-arrow">+</div>
									<h2>Seller Zone</h2>
							</a>

							<!--  	<div class="detail">
									<div id="left" style="width: 15%; float: left; height: 100%;">
										<div id="sup"></div>
									</div>
									<div id="right"
										style="width: 85%; float: right; height: 100%; padding-left: 20px;">
										<div id="sup">
											<div>
												<span><b>In seller zone seller can view all offer
														placed by him. Seller can Quote on buyers requirement also
														he can view all counter offer placed by buyer. Seller zone
														contains four Sub tabs are as follow-</b></span> <br /> <br /> <br>
												<div>

													<br /> <br /> <span><b>My Offers-</b></span> <br /> <br />
													<p>You can place offer from here. Fill all mandatory
														fields which are required. Buyer will see your offer in
														see offers-</p>
													<br />
													<div class="form-group">
														<div class="col-sm-9">
															<button type="button" class="btn btn-primary form-inline">SellerZone</button>
															<span class="form-inline">-------------------------------<b>></b></span>
															<button type="button" class="btn btn-danger form-inline">MyOffer</button>
															<span class="form-inline">-------------------------------<b>></b></span>
															<button type="button" class="btn btn-danger form-inline">Add
																Offer</button>
														</div>
													</div>
													<br /> <br /> <span><b>My quotes-</b></span> <br />
													<p>In my quotation user can view list of quotation
														placed by him against buyers requirement. You can also
														view counter offer placed by buyer placed against your
														quotation.</p>

													<div class="form-group">
														<div class="col-sm-9">
															<button type="button" class="btn btn-primary form-inline">SellerZone</button>
															<span class="form-inline">-------------------------------<b>></b></span>
															<button type="button" class="btn btn-danger form-inline">
																My Quotes</button>
														</div>
													</div>
													<br /> <br /> <br /> <span><b>My deals-</b></span> <br />
													<p>In my deals only won deals are displaying to user
														.Deals which are finalize between seller and buyer are
														displaying here.</p>

													<div class="form-group">
														<div class="col-sm-9">
															<button type="button" class="btn btn-primary form-inline">SellerZone</button>
															<span class="form-inline">-------------------------------<b>></b></span>
															<button type="button" class="btn btn-danger form-inline">
																My Deals</button>
														</div>
													</div>
													<br /> <br /> <br /> <br /> <br /> <span><b>Requirement
															placed by buyer-</b></span> <br />
													<p>Here you can see requirements placed by buyer. Two
														tabs are shown as-</p>
													<br /> <span><b>Upcoming bids-</b></span><br /> <span>Invited
														bids are displaying here you can Accept or Reject
														invitation from here. Status of these invited bids are
														about to open. You can quote on a particular bid only
														after requirement is activated</span> <br>
													<div class="form-group">
														<div class="col-sm-9">
															<button type="button" class="btn btn-primary form-inline">SellerZone</button>
															<span class="form-inline">-------------------------------<b>></b></span>
															<button type="button" class="btn btn-danger form-inline">
																My Deals</button>
														</div>
													</div>
													<br /> <br /> <span><b>Active bids-</b></span><br /> <span>Once
														bid is active you cannot accept or reject invitation You
														can place quotation from here and can view list of
														quotation placed by you also view counter offer placed by
														buyer against your quotation. Your placed quotation you
														can view in my quotes</span> <br> <br /> <br /> <br /> <br />
													<br />
													<div class="form-group">
														<div class="col-sm-12">
															<button type="button" class="btn btn-primary form-inline">SellerZone</button>
															<span class="form-inline">-------------------------------<b>></b></span>
															<button type="button" class="btn btn-danger form-inline">
																Make Quotation</button>
															<span class="form-inline">-------------------------------<b>></b></span>
															<button type="button" class="btn btn-danger form-inline">
																REQUIREMENT PLACED BY BUYER</button>
														</div>
													</div>
												</div>



												<br /> <br /> <a href="#">Visit Website</a>
											</div>
										</div>
									</div>
								</div></li> -->
							<li><a class="expand">
									<div class="right-arrow">+</div>
									<h2>Buyer Zone</h2>
							</a>

								<!--  <div class="detail">
									<div id="left" style="width: 15%; float: left; height: 100%;">
										<div id="sup"></div>
									</div>
									<div id="right"
										style="width: 85%; float: right; height: 100%; padding-left: 20px;">
										<div id="sup">
											<div>
												<span><b>In buyer zone seller can view all
														requirements placed by him. Buyer can choose all his
														favorites seller. Here you can check is seller accepted
														his invitation or rejected it. User can place counter
														offer against sellers quotation. Buyer zone contains five
														sub tabs which are as follow-</b></span>
												<div>

													<br /> <span><b>My requirement-</b></span> <br />
													<p>You can place requirements from here. Fill all
														mandatory fields which are required. Seller will see your
														requirements from requirements placed by buyer(Make
														quotation).</p>
													<br />
													<div class="form-group">
														<div class="col-sm-12">
															<button type="button" class="btn btn-primary form-inline">BUYER
																ZONE</button>
															<span class="form-inline">-------------------------------<b>></b></span>
															<button type="button" class="btn btn-danger form-inline">MY
																REQUIREMENT</button>
															<span class="form-inline">-------------------------------<b>></b></span>
															<button type="button" class="btn btn-danger form-inline">ADD
																Offer</button>
														</div>
													</div>
													<br /> <br /> <span><b>My Deals-</b></span> <br />
													<p>In my deals only won deals are displaying to user
														.Deals which are finalize between seller and buyer are
														displaying here.</p>

													<div class="form-group">
														<div class="col-sm-9">
															<button type="button" class="btn btn-primary form-inline">BUYER
																ZONE</button>
															<span class="form-inline">-------------------------------<b>></b></span>
															<button type="button" class="btn btn-danger form-inline">
																MY Deals</button>
														</div>
													</div>
													<br /> <br /> <br /> <span><b>My Live bids-</b></span> <br />
													<p>In live bids you can see number of running active
														bids. Quotation which are placed by seller are shown here
														.You can accept seller quotation from here. You can also
														view rank of all seller with their rate.</p>
													<div class="form-group">
														<div class="col-sm-9">
															<button type="button" class="btn btn-primary form-inline">BUYER
																ZONE</button>
															<span class="form-inline">-------------------------------<b>></b></span>
															<button type="button" class="btn btn-danger form-inline">
																MY LIVE BIDS</button>
														</div>
													</div>
													<br /> <br /> <span><b>See offer's-</b></span> <br />
													<p>Here you can see offers placed by Seller.</p>
													<br />
													<div class="form-group">
														<div class="col-sm-12">
															<button type="button" class="btn btn-primary form-inline">BUYER
																ZONE</button>
															<span class="form-inline">-------------------------------<b>></b></span>
															<button type="button" class="btn btn-danger form-inline">
																SEE OFFERS</button>
															<span class="form-inline">-------------------------------<b>></b></span>
															<button type="button" class="btn btn-danger form-inline">
																SEE SELLER'S OFFERS</button>
														</div>
													</div>
													<br /> <br /> <span><b>Choose your seller-</b></span><br />
													<span>You can choose your favorite seller from here.
														You can choose seller product wise. These selected sellers
														will be your favorite seller. You can choose them favorite
														seller when you added bid.</span> <br />
													<div class="form-group">
														<div class="col-sm-12">
															<button type="button" class="btn btn-primary form-inline">BUYER
																ZONE</button>
															<span class="form-inline">-------------------------------<b>></b></span>
															<button type="button" class="btn btn-danger form-inline">
																CHOOSE YOUR SELLER</button>
															<span class="form-inline">-------------------------------<b>></b></span>
															<button type="button" class="btn btn-danger form-inline">
																MY FAVORIATE SELLER</button>
														</div>
													</div>
													<br />
												</div>
												<br /> <br /> <a href="#">Visit Website</a>
											</div>
										</div>
									</div>
								</div></li> -->
							<li><a class="expand">
									<div class="right-arrow">+</div>
									<h2>Setting</h2>
							</a>

								<!--  <div class="detail">
									<div id="left" style="width: 15%; float: left; height: 100%;">
										<div id="sup"></div>
									</div>
									<div id="right"
										style="width: 85%; float: right; height: 100%; padding-left: 20px;">
										<div id="sup">
											<div>
												<span><b>Only new company user can view setting
														options. Settings contains three sub tabs as follows-</b></span>
												<div>

													<br /> <span><b>Associate-</b></span> <br />
													<p>If any user select your company and become member of
														your Company he will come under existing user. He will be
														your associate.</p>
													<br />
													<div class="form-group">
														<div class="col-sm-12">
															<button type="button" class="btn btn-primary form-inline">SETTING</button>
															<span class="form-inline">-------------------------------<b>></b></span>
															<button type="button" class="btn btn-danger form-inline">ASSOCIATE</button>
														</div>
													</div>
													<br /> <br /> <span><b>Company-</b></span> <br />
													<p>you can update your detail here. This is editable
														company form. Only company admin can view company form.</p>

													<div class="form-group">
														<div class="col-sm-9">
															<button type="button" class="btn btn-primary form-inline">SETTING</button>
															<span class="form-inline">-------------------------------<b>></b></span>
															<button type="button" class="btn btn-danger form-inline">
																COMPANY</button>
														</div>
													</div>
													<br /> <br /> <br /> <span><b>Manage Product-</b></span>
													<br />
													<p>To manage your product click on below link. You will
														redirecting to manage product you can choose your
														particular product from here. Also you can select your
														type from here as Seller, Buyer and Both.<br/> <b>Manage Product-
														For manage your product go to </b></p>
													<div class="form-group">
														<div class="col-sm-9">
															<button type="button" class="btn btn-primary form-inline">SETTING</button>
															<span class="form-inline">-------------------------------<b>></b></span>
															<button type="button" class="btn btn-danger form-inline">
																MANAGE PRODUCT</button>
														</div>
													</div>
													<br /> <br />
												<br /> <br /> <a href="#">Visit Website</a>
											</div>
										</div>
									</div>
								</div></li> -->

						</ul>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>