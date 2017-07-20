mainApp.controller("AdminDashboardController", function($http, $scope,
		ControllerService, BaseService) {

	// Get reference of self
	var self = this;

	// Service endpoint
	self.endPoint = "/Rushhh/rest/Property";
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
			"id" : ""
		});
	};

	// Initialize form
	self.resetForm();
	// Get first page of list
	self.search();

	// Dashboard Data

	self.propertySellDashboard = function() {
		self.message = "Please Wait..";
		var endPoint = "/Rushhh/rest/Property/searchByProprtyFor/Sell";
		BaseService.callEndPoint(endPoint, null).then(function(data) {
			self.propertySellList = data.list;

		});
	};
	self.propertySellDashboard();

	self.propertyRentDashboard = function() {
		self.message = "Please Wait..";
		var endPoint = "/Rushhh/rest/Property/searchByProprtyFor/Rent";
		BaseService.callEndPoint(endPoint, null).then(function(data) {
			self.propertyRentList = data.list;

		});
	};
	self.propertyRentDashboard();
	
	self.propertyBuyDashboard = function() {
		self.message = "Please Wait..";
		var endPoint = "/Rushhh/rest/Property/searchByProprtyFor/Buy";
		BaseService.callEndPoint(endPoint, null).then(function(data) {
			self.propertyBuyList = data.list;

		});
	};
	self.propertyBuyDashboard();

});
