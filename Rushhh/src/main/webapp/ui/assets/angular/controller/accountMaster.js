mainApp.controller("AccountMasterController", function($scope,
		ControllerService) {

	// Get reference of self
	var self = this;

	// Service endpoint
	self.endPoint = "/Rushhh/rest/AccountMaster";

	// Initialize controller
	ControllerService.setEndPoint(self.endPoint);

	// Get controller objects
	ControllerService.getCtlObjects(self);

	// Search Object contains filter values of list page
	self.searchData = ControllerService.getSearchObject({
		"companyName" : ""
	});

	// Initialize form
	self.resetForm = function() {
		ControllerService.resetForm(self, {
			"id" : "",
			"type" : "",
			"companyId" : "",
			"amount" : "",
			"points" : "",
			"userName":"",
			"timestamp" : "",
			"description" : ""
		});
	};

	// Initialize form
	self.resetForm();
	// Get first page of list
	self.search();

});

