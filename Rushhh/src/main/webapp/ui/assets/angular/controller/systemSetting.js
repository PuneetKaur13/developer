mainApp.controller("SystemSettingController", function($http, $scope,
		ControllerService) {

	// Get reference of self
	var self = this;

	// Service endpoint
	self.endPoint = "/Rest/rest/SystemSetting";

	// Initialize controller
	ControllerService.setEndPoint(self.endPoint);

	// Get controller objects
	ControllerService.getCtlObjects(self);

	// Search Object contains filter values of list page
	self.searchData = ControllerService.getSearchObject({

	});

	// Initialize form
	self.resetForm = function() {
		ControllerService.resetForm(self, {
			"id" : "",
			"conversionFactor" : "",
			"recordsPerPage" : "",
			"valuePoint" : "",
			"appVersion" : ""
		});
	};

	// Initialize form
	self.resetForm();
	// Displays add/edit record
	self.display(1);

});
