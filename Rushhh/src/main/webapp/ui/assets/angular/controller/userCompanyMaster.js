mainApp.controller("UserCompanyMasterController", function($http, $scope,
		ControllerService,BaseService) {

	// Get reference of self
	var self = this;

	// Service endpoint
	self.endPoint = "/OCBS/rest/Users";

	// Initialize controller
	ControllerService.setEndPoint(self.endPoint);

	// Get controller objects
	ControllerService.getCtlObjects(self);

	// Search Object contains filter values of list page
	self.searchData = ControllerService.getSearchObject({
		"firstName" : "",
		"loginId" : "",
		"imagePath" : ""
	});

	// Initialize form
	self.resetForm = function() {
		ControllerService.resetForm(self, {
			"id":"",
			"roleId":"",
			"roleName":"",
			"firstName":"",
			"lastName":"",
			"loginId":"",
			"password":"",
			"gender":"",
			"email":"",
			"dob":"",
			"status":"",
			"firstName":"",
			"lastName":"",
			"loginId":"",
			"password":"",
			"gender":"",
			"email":"",
			"dob":"",
			"mobile":"",
			"status":"",
			"imagePath" : ""

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
	// Get first page of list
	self.search();
	
	


});

