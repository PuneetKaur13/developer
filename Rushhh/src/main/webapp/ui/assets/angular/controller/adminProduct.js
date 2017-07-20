mainApp.controller("AdminProductController",
		function($scope, ControllerService) {

			// Get reference of self
			var self = this;

			// Service endpoint
			self.endPoint = "/Rushhh/rest/AdminProduct";

			// Initialize controller
			ControllerService.setEndPoint(self.endPoint);

			// Get controller objects
			ControllerService.getCtlObjects(self);

			// Search Object contains filter values of list page
			self.searchData = ControllerService.getSearchObject({
				"name" : "",
				"unit" : "",
				"imagePath" : ""
			});

			// Initialize form
			self.resetForm = function() {
				ControllerService.resetForm(self, {
					"id" : "",
					"name" : "",
					"unit" : ""
				});
			};
			// Upload file form
			self.uploadForm = {
				"file" : "",
				"uploadedFileName" : "",
				"uploadMessage" : "",
			};
			self.upload = function() {
				self.button.add = false;
				self.uploadForm.uploadMessage = "Uploading...";
				ControllerService.upload(self.uploadForm);
			};

			// Watch the new uploaded file name. It will always used with
			// self.upload
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
