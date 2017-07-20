mainApp.controller("FeedbackController",function($http, $scope,
				ControllerService, BaseService) {

			// Get reference of self
			var self = this;

			// Service endpoint
			self.endPoint = "/Rushhh/rest/Feedback";

			// Initialize controller
			ControllerService.setEndPoint(self.endPoint);

			// Get controller objects
			ControllerService.getCtlObjects(self);

			self.submit = function() {
				self.message = "Please Wait..";
				BaseService.saveOrUpdate(self.form).then(function(data) {
					//self.message = data.message;
					self.success = data.success;
				});
				
			}
			// Initialize form
			self.resetForm = function() {
				ControllerService.resetForm(self, {
					"name" : "",
					"email" : "",
					"feedback" : ""
				});
			};

			// Initialize form
			self.resetForm();
			// Submit feedback
			self.submit();

		});
