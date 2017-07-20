mainApp.controller("PropertyController", function($http, $scope,
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
		"propertyFor" : "",
		"propertyType" : "",
		"propertyName" : "",
		"propertyPrice" : "",
		"stateName" : "",
		"cityName" : "",
		"areaSqFeet" : "",
		"address" : "",
		"landmark" : "",
		"bedrooms" : "",
		"bathrooms" : "",
		"balconies" : "",
		"floorNumber" : "",
		"furnished" : ""
	});
	
	// Initialize form
	self.resetForm = function() {
		ControllerService.resetForm(self, {});
	};

	self.display = function() {
		console.log('i am call')

	};
	// Initialize form
	self.resetForm();
	// Get first page of list
	// self.search();

	// Upload file form
	self.uploadForm = {
		"file" : "",
		"uploadedFileName" : "",
		"uploadMessage" : "",
	};

	// Submits data and add/edit record
	self.upload = function() {
		self.button.add = false;
		self.uploadForm.uploadMessage = "Uploading...";
		ControllerService.upload(self.uploadForm);
	};

	/* ------------------------------------ */

	self.uploadForm1 = {
		"file" : "",
		"uploadedFileName" : "",
		"uploadMessage" : "",
	};

	// Submits data and add/edit record
	self.upload1 = function() {
		self.button.add = false;
		self.uploadForm1.uploadMessage = "Uploading...";
		ControllerService.upload(self.uploadForm1);
	};

	// Upload multiple data

	$scope.$watch(function() {
		return self.uploadForm.uploadedFileName;
	}, function(newVal) {
		self.form.imagePath = newVal;
		self.button.add = true;
		self.uploadForm.uploadMessage = "";
	}, true);

	self.search();

	self.display = function(id) {
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
	
//	self.searchProperty= ControllerService.getSearchObject({
//		"propertyFor" : "",
//		"propertyType" : "",
//		"cityName" : "",
//	});
//	self.linkToDescription=function(){
//		if(propertyFor)==""
//			self.findCity(cityName);
//			
//	};
});