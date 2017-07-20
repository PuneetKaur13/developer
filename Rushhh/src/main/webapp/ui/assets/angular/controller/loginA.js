mainApp.controller("LoginA Controller", function($http, $scope, $routeParams,
		$filter, UserService) {
	var self = this;
	self.form = {};
	self.message = "";
	self.success = "";
	self.user = "";

	$scope.$watch(UserService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);

	$scope.$watch(UserService.getSuccessMsg, function(newVal) {
		self.message = newVal;
	}, true);

	self.submitOTP = function() {
		UserService.submitOTP(self.form);
	};
	
	self.login = function() {
		UserService.authenticate(self.form);
		UserService.getSuccessMsg();
	};
	
	self.resendOTP = function() {
		UserService.resendOTP();
	};

});