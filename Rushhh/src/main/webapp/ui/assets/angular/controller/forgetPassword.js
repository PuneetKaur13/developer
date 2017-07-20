mainApp.controller("ForgetPasswordController", function($http, $scope,
		$routeParams, $filter, UserService) {
	var self = this;
	self.form = {};
	self.message = "";
	self.success = "";
	self.user = "";
	self.regex = '\\d+';
	self.regEx = "/^[0-9]{10,10}$/;"
	self.toggle = !self.toggle;

	$scope.$watch(self.toggle, function(newVal) {
		//self.form = {};
		self.message = [];
		self.success = "";
		self.progress = "";
	}, true);

	$scope.$watch(UserService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);

	$scope.$watch(UserService.getSuccessMsg, function(newVal) {
		self.message = newVal;
	}, true);

	self.forgetP = function() {
		UserService.forgetPassword(self.form);
	};
});