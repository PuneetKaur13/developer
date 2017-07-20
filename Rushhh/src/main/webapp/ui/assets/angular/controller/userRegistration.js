mainApp.controller("UserRegistrationController", function($http, $scope,
		$location, ControllerService, BaseService) {

	// Get reference of self
	var self = this;

	// Service endpoint
	self.endPoint = "/Rushhh/rest/Users";

	// Initialize controller
	ControllerService.setEndPoint(self.endPoint);

	// Get controller objects
	ControllerService.getCtlObjects(self);

	// Search Object contains filter values of list page
	self.searchData = ControllerService.getSearchObject({
		"firstName" : "",
		"email" : ""
	});

	// Initialize form
	self.resetForm = function() {
		ControllerService.resetForm(self, {
			"id" : "",
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
	self.display(0);

	// Get first page of list
	self.search();
	
	self.registerData = function() {
		self.message = "Please Wait..";
		BaseService.saveOrUpdate(self.form).then(function(data) {
			self.message = data.message;
			self.success = data.success;
			self.search();
			if(data.success==true)
			{		
				self.message="Congratulations "+data.firstName+", You have been registered successfully, Please enter OTP to activate yourself.";
				$location.path("OTP");
			}
		});
	};
	

});
