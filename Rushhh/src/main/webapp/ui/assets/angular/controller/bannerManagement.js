mainApp.controller("BannerManagementController", function($scope,
		ControllerService) {

	// Get reference of self
	var self = this;

	// Service endpoint
	self.endPoint = "/OCBS/rest/BannerManagement";

	// Initialize controller
	ControllerService.setEndPoint(self.endPoint);

	// Get controller objects
	ControllerService.getCtlObjects(self);

	// Search Object contains filter values of list page
	self.searchData = ControllerService.getSearchObject({
		"companyName" : "",
		"campaignName" : "",
		"bannerName" : ""
	});
	// Initialize form
	self.resetForm = function() {
		ControllerService.resetForm(self, {
			"id":"",
			"companyId" : "",
			"campaignId" : "",
			"bannerName" : "",
			"status" : "",
			"url" : ""
		});
	};

	// Initialize form
	self.resetForm();
	// Get first page of list
	self.search();

});