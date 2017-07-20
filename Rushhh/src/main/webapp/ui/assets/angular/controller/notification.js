mainApp.controller(
				"NotificationController",
				function($scope, ControllerService, BaseService, WatchService) {

					// Get reference of self
					var self = this;

					// Service endpoint
					self.endPoint = "/Rushhh/rest/Notification";

					// Initialize controller
					ControllerService.setEndPoint(self.endPoint);

					// Get controller objects
					ControllerService.getCtlObjects(self);

					// Search Object contains filter values of list page
					self.searchData = ControllerService.getSearchObject({
						"subject" : "",
						"message" : "",
						"from" : "",
						"to" : ""
					});

					// Initialize form
					self.resetForm = function() {
						ControllerService.resetForm(self, {
							"id" : "",
							"type" : "",
							"title" : "",
							"message" : ""
						});
					};

					// Initialize form
					self.resetForm();
					// Get first page of list
					self.search = function() {
						self.searchMessage = "Please Wait..";
						BaseService
								.find(self.searchData)
								.then(
										function(data) {
											self.dataList = data;
											WatchService
													.setAccountBalance(new Date()
															.getTime());
											WatchService
													.setNotificationCount(new Date()
															.getTime());
											if (self.dataList.list == null
													|| self.dataList.list.length == 0) {
												self.success = false;
												self.searchMessage = "No Record Found.";
												self.button.remove = false;
												self.button.go = false;
											} else {
												self.searchMessage = null;
												self.button.remove = true;
												self.button.go = true;

												// Enable pagination next
												// button after search
												if (self.searchData.pageNo == null) {
													self.searchData.pageNo = 1;
												}
												self.index = (self.searchData.pageNo - 1) * 10;
												if (self.dataList.pageNoList != null
														&& self.dataList.pageNoList.length == self.searchData.pageNo) {
													self.button.next = false;
												} else {
													self.button.next = true;
												}
												// Enable pagination
												// previous button after
												// search
												if (self.searchData.pageNo == 1) {
													self.button.previous = false;
												} else {
													self.button.previous = true;
												}

											}
										});

					};

					self.search();

				});