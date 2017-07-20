mainApp.controller("ChangeMyPasswordController", function($http, $scope,
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
	self.searchData = ControllerService.getSearchObject({

	});

	// Initialize form
	self.resetForm = function() {
		ControllerService.resetForm(self, {
			"id" : "",
			"firstName" : "",
			"lastName" : "",
			"loginId" : "",
			"password" : "",
			"gender" : "",
			"email" : "",
			"dob" : "",
			"mobile" : "",
			"status" : "",
			"imagePath" : ""
		});
	};

	// Initialize form
	self.resetForm();

	// Fetch data
	self.changeMyPassword = function() {
		self.message = "Please Wait..";
		var endPoint = self.endPoint + "/changeMyPassword";
		BaseService.callEndPoint(endPoint, self.form).then(function(data) {
			self.message = data.message;
			self.success = data.success;
		});
	};

});