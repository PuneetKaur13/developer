<!DOCTYPE html>
<%@page import="com.nenosystems.common.dto.UserContext"%>
<%@page import="com.ncs.dto.UserDTO"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="/laravel/ui/images/favicon.ico"
	type="image/x-icon" />
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Real Estate | Rushhh.in</title>

<!-- Real Estate | rates in Indore. Property rate in Indore.
	Commercial Property rates in Indore. Houses for sale in Indore.Homes
	for sale in Indore. Land for Sale in Indore. Homes for sale by owner.
	New home,plots for sale in Indore. Homes for sale near me.Real estate
	for sale. Rushhh. -->
<!-- Jquery -->
<script src="js/jquery.min.js"></script>

<!-- Bootstrap -->

<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-datetimepicker.js"></script>
<!--css-->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!--Style css-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/landing_style.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="application/x-javascript">
	
	
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 






</script>
<link rel="stylesheet" href="css/flexslider.css" type="text/css"
	media="screen" />
<!--webfonts-->
<link
	href='//fonts.googleapis.com/css?family=Josefin+Sans:400,700italic,700,600italic,600,400italic,300italic,300,100italic,100'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
	rel='stylesheet' type='text/css'>
<!--webfonts-->
<script src="js/responsiveslides.min.js"></script>
<script>
	$(function() {
		$("#slider").responsiveSlides({
			auto : true,
			nav : true,
			speed : 500,
			namespace : "callbacks",
			pager : true,
		});
	});
</script>
<link href="css/owl.carousel.css" rel="stylesheet">
<script src="js/owl.carousel.js"></script>


<!-- Angular -->

<link href="css/angular-datepicker.css" rel="stylesheet">
<script src="js/angular.min.js"></script>
<script src="js/angular-route.min.js"></script>
<script src="js/checklist-model.js"></script>
<script src="js/angular-media-preview.min.js"></script>
<script src="js/angu-fixed-header-table.js"></script>
<script src="js/angular-datepicker.js"></script>
<script src="js/angular-animate.js"></script>



<script src="js/ng-upload.js"></script>
<script src="js/loader.js"></script>

<script src="js/moment-with-locales.js"></script>

<script src="js/index.js"></script>
<script src="js/ng-map.min.js"></script>

<link href="css/datetimepick.css" rel="stylesheet">
<script src="js/mask.js"></script>

<!-- Google Login -->
<script src="js/google-plus-signin.js"></script>
<link href="css/google-plus-signin.css" rel="stylesheet">

<!-- GMap -->
<script
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBzJmRsI3F4h0LTexSKfLigWJHYisd6ecE&v=3"></script>
<!-- 
<script src="http://maps.google.com/maps/api/js"></script>
 -->
<!-- Time  -->
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">

<link rel="stylesheet" type="text/css" href="css/ngTimepicker.css">

<!-- App JS -->
<script src="ang/app.js"></script>



<!-- User JS -->
<script src="ang/service/user.js"></script>
<script src="ang/controller/userMaster.js"></script>
<script src="ang/controller/userDeatail.js"></script>
<script src="ang/controller/userRegistration.js"></script>
<script src="ang/controller/otp.js"></script>

<!-- User Company Master -->
<script src="ang/service/userCompanyMaster.js"></script>
<script src="ang/controller/userCompanyMaster.js"></script>
<!-- Home JS -->
<script src="ang/service/home.js"></script>
<script src="ang/controller/home.js"></script>

<!-- Property Search JS -->
<script src="ang/controller/propertySearch.js"></script>

<!-- Login JS -->
<script src="ang/controller/login.js"></script>

<!-- Edit My Profile JS -->
<script src="ang/controller/editMyProfile.js"></script>

<!-- Role JS -->
<script src="ang/service/role.js"></script>
<script src="ang/controller/role.js"></script>

<!-- Feedback JS -->
<script src="ang/service/feedback.js"></script> 
<script src="ang/controller/feedback.js"></script>

<!-- Account Master JS -->
<script src="ang/service/accountMaster.js"></script>
<script src="ang/controller/accountMaster.js"></script>

<!-- Transaction Master JS -->
<script src="ang/service/transactionMaster.js"></script>
<script src="ang/controller/transactionMaster.js"></script>

<!-- Message JS -->
<script src="ang/controller/message.js"></script>
<script src="ang/service/message.js"></script>

<!-- Notification JS -->
<script src="ang/controller/notification.js"></script>
<script src="ang/service/notification.js"></script>


<!-- ConversionFactor JS -->
<script src="ang/controller/systemSetting.js"></script>
<script src="ang/service/systemSetting.js"></script>

<!-- State JS -->
<script src="ang/controller/state.js"></script>
<script src="ang/service/state.js"></script>

<!-- City JS -->
<script src="ang/controller/city.js"></script>
<script src="ang/service/city.js"></script>
<script src="ang/controller/userCompanyRegister.js"></script>



<!-- Live Bids -->
<script src="ang/controller/liveBids.js"></script>
<!-- Banner ManageMent -->
<script src="ang/controller/bannerManagement.js"></script>
<script src="ang/service/bannerManagement.js"></script>

<!-- CAMPAIGN ManageMent -->
<script src="ang/controller/campaignManagement.js"></script>
<script src="ang/service/campaignManagement.js"></script>


<!-- Forget Password -->
<script src="ang/controller/forgetPassword.js"></script>



<!-- Admin -->
<script src="ang/controller/adminUserMaster.js"></script>
<!-- Statistics -->
<script src="ang/controller/adminReport.js"></script>
<script src="ang/controller/userSellReport.js"></script>
<script src="ang/controller/userBuyReport.js"></script>
<script src="ang/controller/adminDashboard.js"></script>


<script src="ang/controller/homeLiveBids.js"></script>

<!-- Admin Report -->
<script src="ang/controller/adminSellReport.js"></script>
<script src="ang/controller/adminBuyReport.js"></script>

<!-- Change My Password JS -->
<script src="ang/controller/changeMyPassword.js"></script>

<!-- Message Center -->
<script src="ang/controller/messageCenter.js"></script>

<!-- Card Type -->
<script src="ang/controller/cardType.js"></script>

<!--  Property -->
<script src="ang/controller/property.js"></script>

<!-- Users -->
<!--  <script src="ang/controller/users.js"></script> -->

<!-- User Card Management -->
<script src="ang/controller/userCardManagement.js"></script>

<!-- Agent JS -->
<script src="ang/controller/agent.js"></script>

<!-- Add Property JS -->
<script src="ang/controller/addProperty.js"></script>

<!-- Unit JS -->
<script src="ang/controller/unit.js"></script>

<!-- PropertyFor -->
<script src="ang/controller/propertyFor.js"></script>

<!-- PropertyFor -->
<script src="ang/controller/propertyType.js"></script>

<script src="ang/controller/postFreeAd.js"></script>


<style type="text/css">
.dropdown-submenu {
	position: relative;
}

.dropdown-submenu>.dropdown-menu {
	top: 0;
	left: 100%;
	margin-top: -6px;
	margin-left: -1px;
	-webkit-border-radius: 0 6px 6px 6px;
	-moz-border-radius: 0 6px 6px 6px;
	border-radius: 0 6px 6px 6px;
}

.dropdown-submenu:hover>.dropdown-menu {
	display: block;
}

.dropdown-submenu>a:after {
	display: block;
	content: " ";
	float: right;
	width: 0;
	height: 0;
	border-color: transparent;
	border-style: solid;
	border-width: 5px 0 5px 5px;
	border-left-color: #cccccc;
	margin-top: 5px;
	margin-right: -10px;
}

.dropdown-submenu:hover>a:after {
	border-left-color: #ffffff;
}

.dropdown-submenu.pull-left {
	float: none;
}

.dropdown-submenu.pull-left>.dropdown-menu {
	left: -100%;
	margin-left: 10px;
	-webkit-border-radius: 6px 0 6px 6px;
	-moz-border-radius: 6px 0 6px 6px;
	border-radius: 6px 0 6px 6px;
}

datepicker {
	cursor: pointer;
}
</style>
<body ng-app="mainApp" ng-controller="BaseController">
	<jsp:include page="/pages/header.jsp"></jsp:include>
	<div ng-view></div>
	<jsp:include page="/pages/footer.jsp"></jsp:include>
</body>
</html>