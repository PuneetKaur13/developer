mainApp.controller("PropertySearchController", function($http, $scope,
		ControllerService, BaseService) {

	// Get reference of self
	var self = this;

	// Service endpoint
	self.endPoint = "/Rushhh/rest/PropertySearch";

	// Initialize controller
	ControllerService.setEndPoint(self.endPoint);

	// Get controller objects
	ControllerService.getCtlObjects(self);

	// Search Object contains filter values of list page
	self.searchData = ControllerService.getSearchObject({
		"propertyFor" : "",
		"stateName" : "",
		"cityName" : ""
	});

	// Initialize form
	self.resetForm = function() {
		ControllerService.resetForm(self, {});
	};

	// Initialize form
	self.resetForm();
	// Get first page of list
	self.search();

	self.cityList = [];

	self.findCity = function(stateId) {
		if (stateId != undefined) {
			var endPoint = "/Rushhh/rest/City/findByStateId/" + stateId;
			BaseService.callEndPoint(endPoint, null).then(function(data) {
				self.cityList = data.list;
			});
		} else {
			self.cityList = [];
		}
	};
});