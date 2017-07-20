mainApp.controller("PostFreeADController", function($http, $scope,
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
	self.searchData = ControllerService.getSearchObject({});

	// Initialize form
	self.resetForm = function() {
		ControllerService.resetForm(self, {
			"areaType" : "Sq feet",
			"carpetAreaType" : "Sq feet",
			"bedrooms" : "1",
			"furnishingType" : "Unfurnished",
			"totalFloors" : "1",
			"plotAreaType" : "Sq-yrd"
		});
	};

	self.display = function() {

	};
	// Initialize form
	self.resetForm();
	// Get first page of list
	self.search();

	// Upload file form
	self.uploadForm1 = {
		"file" : "",
		"uploadedFileName" : "",
		"uploadMessage" : "",
	};

	self.uploadForm2 = {
		"file" : "",
		"uploadedFileName" : "",
		"uploadMessage" : "",
	};

	self.uploadForm3 = {
		"file" : "",
		"uploadedFileName" : "",
		"uploadMessage" : "",
	};

	self.uploadForm4 = {
		"file" : "",
		"uploadedFileName" : "",
		"uploadMessage" : "",
	};

	self.uploadForm5 = {
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

	self.upload2 = function() {
		self.button.add = false;
		self.uploadForm2.uploadMessage = "Uploading...";
		ControllerService.upload(self.uploadForm2);
	};

	self.upload3 = function() {
		self.button.add = false;
		self.uploadForm3.uploadMessage = "Uploading...";
		ControllerService.upload(self.uploadForm3);
	};

	self.upload4 = function() {
		self.button.add = false;
		self.uploadForm4.uploadMessage = "Uploading...";
		ControllerService.upload(self.uploadForm4);
	};

	self.upload5 = function() {
		self.button.add = false;
		self.uploadForm5.uploadMessage = "Uploading...";
		ControllerService.upload(self.uploadForm5);
	};

	// Watch the new uploaded file name. It will always used with self.upload
	// method
	$scope.$watch(function() {
		return self.uploadForm1.uploadedFileName;
	}, function(newVal) {
		self.form.imagePath1 = newVal;
		self.button.add = true;
		self.uploadForm1.uploadMessage = "";
	}, true);

	$scope.$watch(function() {
		return self.uploadForm2.uploadedFileName;
	}, function(newVal) {
		self.form.imagePath2 = newVal;
		self.button.add = true;
		self.uploadForm2.uploadMessage = "";
	}, true);

	$scope.$watch(function() {
		return self.uploadForm3.uploadedFileName;
	}, function(newVal) {
		self.form.imagePath3 = newVal;
		self.button.add = true;
		self.uploadForm3.uploadMessage = "";
	}, true);

	$scope.$watch(function() {
		return self.uploadForm4.uploadedFileName;
	}, function(newVal) {
		self.form.imagePath4 = newVal;
		self.button.add = true;
		self.uploadForm4.uploadMessage = "";
	}, true);

	$scope.$watch(function() {
		return self.uploadForm5.uploadedFileName;
	}, function(newVal) {
		self.form.imagePath5 = newVal;
		self.button.add = true;
		self.uploadForm5.uploadMessage = "";
	}, true);

	self.submit = function() {
		self.message = "Please Wait..";
		BaseService.saveOrUpdate(self.form).then(function(data) {
			self.message = data.message;
			self.success = data.success;
			self.button.add = false;
		});
	}

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

});