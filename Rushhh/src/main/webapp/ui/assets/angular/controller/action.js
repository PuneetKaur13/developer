mainApp.controller("ActionController", function($http, $scope,
		$routeParams, $filter, UserService) {
	var self = this;
	self.form = {};
	self.type = "existingCompany";
	self.message = "";
	self.success = "";
	self.user = "";
	
	$scope.$watch(UserService.getCompanyList, function(newVal) {
		self.companyList = newVal;
	}, true);

	$scope.$watch(UserService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);

	$scope.$watch(UserService.getSuccessMsg, function(newVal) {
		self.message = newVal;
	}, true);

	self.submitCompany = function() {
		UserService.submitCompany(self.form);
	};
	
});