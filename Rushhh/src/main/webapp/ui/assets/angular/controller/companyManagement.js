mainApp.controller("CompanyManagementController", function($scope,
		ControllerService) {

	// Get reference of self
	var self = this;

	// Service endpoint
	self.endPoint = "/OCBS/rest/CompanyManagement";

	// Initialize controller
	ControllerService.setEndPoint(self.endPoint);

	// Get controller objects
	ControllerService.getCtlObjects(self);

	// Search Object contains filter values of list page
	self.searchData = ControllerService.getSearchObject({
		"companyName" : "",
		"companyAddress" : ""
	});

	// Initialize form
	self.resetForm = function() {
		ControllerService.resetForm(self, {
			"id" : "",
			"companyName" : "",
			"companyAddress" : "",
			"status" : ""
		});
	};

	// Initialize form
	self.resetForm();
	// Get first page of list
	self.search();

});