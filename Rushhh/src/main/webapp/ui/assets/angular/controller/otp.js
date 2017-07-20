
mainApp.controller("OTPController", function($scope, ControllerService,$location,
		BaseService) {
	var self = this;

	// Get controller objects
	ControllerService.getCtlObjects(self);

	// Search Object contains filter values of list page
	self.searchData = ControllerService.getSearchObject({});

	// Initialize form
	self.resetForm = function() {
		ControllerService.resetForm(self, {
			"id" : ""
		});
	};

	// Initialize form
	self.resetForm();
	// Get first page of list
	
	

	self.submitOTP = function() {
			var endPoint = "/Rushhh/rest/Users/submitOTP";
				
			BaseService.callEndPoint(endPoint, self.form).then(function(data) {
				self.message = data.message;
				self.searchMessage = data.success;
				self.search();
				
				if(data.success){
					successMsg = {
							"success" : true,
							"msg" : "Thank You! You have successfully registered.",
					}
					$location.path("UserCompanyRegistration");
				}
			});
		
	}

	self.resendOTP = function() {
		var endPoint = "/Rushhh/rest/Users/resendOTP";
		BaseService.callEndPoint(endPoint, self.form).then(function(data) {
			self.message = data.message;
			self.searchMessage = data.success;
			self.search();
			
			if(data.success){
				successMsg = {
			
				}
				
			}
		});
	};
	
});
