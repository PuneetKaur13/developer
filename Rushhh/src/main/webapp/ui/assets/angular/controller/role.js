	mainApp.controller("RoleController",
		function($scope, ControllerService) {

			// Get reference of self
			var self = this;

			// Service endpoint
			self.endPoint = "/Rushhh/rest/Role";

			// Initialize controller
			ControllerService.setEndPoint(self.endPoint);

			// Get controller objects
			ControllerService.getCtlObjects(self);

			// Search Object contains filter values of list page
			self.searchData = ControllerService.getSearchObject({
				"roleName" : ""
			});

			// Initialize form
			self.resetForm = function() {
				ControllerService.resetForm(self, {
					"id" : "",
					"roleName" : ""
				});
			};

			// Initialize form
			self.resetForm();
			// Get first page of list
			self.search();

		});
