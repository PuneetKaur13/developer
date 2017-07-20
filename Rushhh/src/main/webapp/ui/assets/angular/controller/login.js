mainApp.controller("LoginController", function($http, $scope, $location,
		UserService) {
	var self = this;
	self.form = {};
	self.message = "";
	self.success = "";
	self.progress = "";

	$scope.$watch(UserService.getAuthMsg, function(newVal) {
		var msg = newVal;
		if (msg != '') {
			console.log("success here" + msg.success)
			if (msg.success) {
				console.log("success here1111")
				window.location = "#/AdminDashboard";
				location.reload(1);
			} else {

				self.progress = "Invalid Email Id / Password";
			}
		}
	}, true);

	$scope.$watch(UserService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);

	$scope.$watch(UserService.getSuccessMsg, function(newVal) {
		self.message = newVal.message;
		self.success = newVal.success;
	}, true);

	self.login = function() {
		UserService.authenticate(self.form);
		UserService.getSuccessMsg();
	};

	self.forget = function() {
		UserService.forgetPassword(self.form);
		UserService.getSuccessMsg();
	};

	function onSignIn(googleUser) {
		console.log("in self.onSignIn");
		var profile = googleUser.getBasicProfile();
		console.log("ID: " + profile.getId()); // Don't send this directly to
		// your server!
		console.log('Full Name: ' + profile.getName());
		console.log('Given Name: ' + profile.getGivenName());
		console.log('Family Name: ' + profile.getFamilyName());
		console.log("Image URL: " + profile.getImageUrl());
		console.log("Email: " + profile.getEmail());
		var name = profile.getName();
		var email = profile.getEmail();
		UserService.authenticateGoogle(name, email);
	};
	

});

// Login Controller End
