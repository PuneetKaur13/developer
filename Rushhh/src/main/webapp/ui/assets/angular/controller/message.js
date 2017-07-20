mainApp.controller("MessageController", function($http, $scope,
		ControllerService) {

	// Get reference of self
	var self = this;

	// Service endpoint
	self.endPoint = "/Rushhh/rest/Message";

	// Initialize controller
	ControllerService.setEndPoint(self.endPoint);

	// Get controller objects
	ControllerService.getCtlObjects(self);

	// Search Object contains filter values of list page
	self.searchData = ControllerService.getSearchObject({
		"type" : "",
		"title" : "",
		"message" : "",
		"code" : ""
	});

	// Initialize form
	self.resetForm = function() {
		ControllerService.resetForm(self, {
			"id" : "",
			"type" : "",
			"title" : "",
			"message" : ""
		});
	};

	// Initialize form
	self.resetForm();
	// Get first page of list
	self.search();

});