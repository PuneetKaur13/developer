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

<!--header-->
<div class="header" id="home">
	<div class="header-top">
		<div class="container">
			<div class="head-top">
				<div class="indicate">
					<i class="glyphicon glyphicon-map-marker" aria-hidden="true"></i><a
						href="https://www.google.co.in/maps/place/Orbit+Mall/@22.7452542,75.892333,17z/data=!4m15!1m9!4m8!1m0!1m6!1m2!1s0x3962fd541ebaea29:0xac37f371817e9720!2sOrbit+Mall,+Agra+Bombay+Rd,+Near+Malhar+Mall,+Sheetal+Nagar,+Vijay+Nagar,+Indore,+Madhya+Pradesh+452010!2m2!1d75.8942749!2d22.7454818!3m4!1s0x3962fd541ebaea29:0xac37f371817e9720!8m2!3d22.7454818!4d75.8942749"
						target="_blank">150th, 1st Floor, Orbit Mall, Vijay Nagar,
						A.B. Road, Indore</a>
				</div>
				<div class="deatils">
					<%
						if (user != null) {
					%>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown pull-right"><a href=""
							class="dropdown-toggle" data-toggle="dropdown" role="button"
							aria-haspopup="true" aria-expanded="false"><span
								class="glyphicon glyphicon-user" aria-hidden="true"></span><b>
									<%=user.getFirstName()%><span class="caret"></span>
							</b></a>
							<ul class="dropdown-menu">
								<li><a href="#/EditMyProfile"><span
										class="glyphicon glyphicon-edit" aria-hidden="true"></span>
										Edit My Profile</a></li>
								<li><a href="#/ChangePassword"><span
										class="glyphicon glyphicon-cog" aria-hidden="true"></span>
										Change Password</a></li>
								<li><a href="" ng-click="logout()"><span
										class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
										Logout</a></li>
							</ul></li>
					</ul>
					<%
						}
						if (user == null) {
					%>
					<ul>
						<li class="post"><a href="#/PostFreeProperty"
							class="btn btn-primary btn-sm"
							style="margin-top: 1px; width: 98%; font-size: 12px; height: 28px;">
								<strong>POST FREE PROPERTY</strong>
						</a></li>
						<li><i class="glyphicon glyphicon-log-in" aria-hidden="true"></i><a
							href="#/Login">Sign In</a></li>
						<li><img src="images/1499080447_list-add-user.png"> <a
							href="#/UserRegistration">Register</a></li>
					</ul>
					<%
						}
					%>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="logo">
				<h1>
					<a href="#/Home">Rushhh.in<span>Real Estate</span></a>
				</h1>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="header-bottom">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<nav class="menu menu--francisco">
							<ul class="nav navbar-nav menu__list">
								<li class="menu__item menu__item--current"><a href="#/Home"
									class="menu__link"><span class="menu__helper">Home</span></a></li>
								<%
									if (user != null && user.getRoleId() == 1L) {
								%>

								<li class="dropdown"><a href="about.html"
									class="dropdown-toggle" data-toggle="dropdown" role="button"
									aria-haspopup="true"
									aria-expanded="
                                        "><span
										class="glyphicon glyphicon-user" aria-hidden="true"></span> <b>Admin</b>
										<span class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><a href="#/User">Associates</a></li>
										<li><a href="#/Role">Role</a></li>
										<li><a href="#/CardType">Card Master</a></li>
										<li><a href="#/Property">Property Type</a></li>
										<li><a href="#/Agent">Agent</a></li>
										<li class="dropdown-submenu"><a tabindex="-1" href="">Address</a>
											<ul class="dropdown-menu">
												<li><a tabindex="-1" href="#/State">State</a></li>
												<li><a tabindex="-1" href="#/City">City</a></li>
											</ul></li>
									</ul></li>
								<li class="dropdown"><a href="about.html"
									class="dropdown-toggle" data-toggle="dropdown" role="button"
									aria-haspopup="true"
									aria-expanded="
                                        "><span
										class="glyphicon glyphicon-list" aria-hidden="true"></span> <b>Bids</b>
										<span class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><a href="#">Manage Offers</a></li>
										<li><a href="#">Manange Requirements</a></li>
									</ul></li>
								<li class="dropdown"><a href="#/SystemSetting"
									class="dropdown-toggle" data-toggle="dropdown" role="button"
									aria-haspopup="true"
									aria-expanded="
                                        "><span
										class=" glyphicon glyphicon-cog" aria-hidden="true"></span> <b>System
											Setting</b> </a></li>
								<li class="dropdown"><a href="about.html"
									class="dropdown-toggle" data-toggle="dropdown" role="button"
									aria-haspopup="true"
									aria-expanded="
                                        "><span
										class="glyphicon glyphicon glyphicon-globe" aria-hidden="true"></span>
										<b>Live Bide</b> <span class="caret"></span></a></li>
								<li class="dropdown"><a href="about.html"
									class="dropdown-toggle" data-toggle="dropdown" role="button"
									aria-haspopup="true"
									aria-expanded="
                                        "><span
										class="glyphicon glyphicon-stats" aria-hidden="true"></span> <b>Report</b>
										<span class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><a href="#">Sell Report</a></li>
										<li><a href="#">Buy Report</a></li>
									</ul></li>
								<li class="dropdown"><a href="" class="dropdown-toggle"
									data-toggle="dropdown" role="button" aria-haspopup="true"
									aria-expanded="false"><span
										class="glyphicon glyphicon-bell" aria-hidden="true"></span>&nbsp;<span
										class="badge">{{notificationCount}} </span></a>
									<ul class="dropdown-menu">
										<li><a href="#/Message">Messages</a></li>
										<li><a href="#/Notification">Notification</a></li>
									</ul></li>

								<%
									}
								%>
								<li class="menu__item"><a href="#/AboutUs"
									class="menu__link"><span class="menu__helper">About</span></a></li>
								<li class="menu__item"><a href="#/Projects"
									class="menu__link"><span class="menu__helper">Projects</span></a></li>
								<li class="menu__item"><a href="#/ContactUs"
									class="menu__link"><span class="menu__helper">ContactUs</span></a></li>
								<li class="menu__item"><a href="#/Feedback"
									class="menu__link"><span class="menu__helper">Feedback</span></a></li>	
							</ul>
						</nav>
					</div>
				</div>
			</nav>

		</div>
	</div>
</div>