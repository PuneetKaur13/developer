mainApp.controller("EditMyProfileController", function($http, $scope,
		ControllerService, BaseService) {

	// Get reference of self
	var self = this;

	// Service endpoint
	self.endPoint = "/Rushhh/rest/Users";

	// Initialize controller
	ControllerService.setEndPoint(self.endPoint);

	// Get controller objects
	ControllerService.getCtlObjects(self);

	// Search Object contains filter values of list page
	self.searchData = ControllerService.getSearchObject({});

	// Initialize form
	self.resetForm = function() {
		ControllerService.resetForm(self, {
			"id" : "",
			"firstName" : "",
			"lastName" : "",
		
		});
	};

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

	// Watch the new uploaded file name. It will always used with self.upload
	// method
	$scope.$watch(function() {
		return self.uploadForm.uploadedFileName;
	}, function(newVal) {
		self.form.imagePath = newVal;
		self.button.add = true;
		self.uploadForm.uploadMessage = "";
	}, true);

	// Initialize form
	self.resetForm();

	// Fetch data
	self.editProfile = function() {
		self.message = "Please Wait..";
		var endPoint = self.endPoint + "/editMyProfile";
		BaseService.callEndPoint(endPoint, null).then(function(data) {
			self.message = null;
			self.form = data.form;
			self.dataList = data;
		});
	};

	// Submits data and add/edit record
	self.updateProfile = function(ctl) {
		self.message = "Please Wait..";
		var endPoint = self.endPoint + "/updateProfile";
		BaseService.callEndPoint(endPoint, self.form).then(function(data) {
			self.message = data.message;
			self.success = data.success;
		});
	},

	self.editProfile();
});