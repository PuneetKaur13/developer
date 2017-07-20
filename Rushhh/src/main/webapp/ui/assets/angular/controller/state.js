mainApp.controller("StateController", function($scope, ControllerService,
		BaseService) {
	var self = this;

	// Service endpoint
	self.endPoint = "/Rushhh/rest/State";

	// Initialize controller
	ControllerService.setEndPoint(self.endPoint);

	// Get controller objects
	ControllerService.getCtlObjects(self);

	// Search Object contains filter values of list page
	self.searchData = ControllerService.getSearchObject({});

	// Initialize form
	self.resetForm = function() {
		ControllerService.resetForm(self, {
			"id" : ""
		});
	};

	// Initialize form
	self.resetForm();
	// Get first page of list
	self.search();

});

