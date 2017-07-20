mainApp.controller("HeaderController", function($http, $scope, $routeParams,
		$filter, UserService) {
	var self = this;
	self.form = {};
	self.message = "";
	self.success = "";
	self.user = "";

	UserService.notificationList();

});