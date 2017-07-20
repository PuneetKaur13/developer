mainApp.controller("SellPropertyController", function($http, $scope,
		ControllerService) {

	// Get reference of self
	var self = this;

	// Service endpoint
	self.endPoint = "/Rushhh/rest/SellProperty";

	// Initialize controller
	ControllerService.setEndPoint(self.endPoint);

	// Get controller objects
	ControllerService.getCtlObjects(self);

	// Search Object contains filter values of list page
	self.searchData = ControllerService.getSearchObject({});

	// Initialize form
	self.resetForm = function() {
		ControllerService.resetForm(self, {});
	};

	// Initialize form
	self.resetForm();
	// Get first page of list
	self.search();

	self.display = function(id) {

		console.log("i am call");
		self.resetForm();
		if (id > 0) {
			BaseService.get(id).then(function(data) {
				self.form = data.form;
				self.message = null;
				self.findCity(self.form.stateId);
			
			});
		}
	},

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