mainApp.controller("CompanyMasterController", function($http, $scope,
		ControllerService,BaseService,CompanyMasterService) {

	// Get reference of self
	var self = this;

	// Service endpoint
	self.endPoint = "/Rushhh/rest/Company";

	// Initialize controller
	ControllerService.setEndPoint(self.endPoint);

	// Get controller objects
	ControllerService.getCtlObjects(self);

	// Search Object contains filter values of list page
	self.searchData = ControllerService.getSearchObject({
		"companyName" : "",
		"phoneNo" : ""
	});

	// Initialize form
	self.resetForm = function() {
		ControllerService.resetForm(self, {
			"id" : 0
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
	
	self.display = function(id) {
		if (id > 0) {
			BaseService.get(id).then(function(data) {
				self.form = data.form;
				self.message = null;
				self.findCity(self.form.stateId);
			});
		}
	};
	
	self.cityList = [];
	self.findCity = function(stateId) {
		if (stateId != undefined) {
			var endPoint = "/OCBS/rest/City/findByStateId/" + stateId;
			BaseService.callEndPoint(endPoint, null).then(function(data) {
				self.cityList = data.list;
			});
		} else {
			self.cityList = [];
		}
	};
	
	
	
	self.companyUnderUserList = [];
	self.companyUnder = function(groupId) {
		if (groupId != undefined) {
			var endPoint = "/OCBS/rest/Company/searchCompanyUnderUser/" + groupId;
			BaseService.callEndPoint(endPoint, null).then(function(data) {
				self.companyUnderUserList = data.list;
			});
		} else {
			self.companyUnderUserList = [];
		}
	};
	
	self.plantInformationList = [];
	self.companyPlant = function(groupId) {
		if (groupId != undefined) {
			var endPoint = "/OCBS/rest/Company/searchPlantInformation/" + groupId;
			BaseService.callEndPoint(endPoint, null).then(function(data) {
				self.plantInformationList = data.list;
			});
		} else {
			self.plantInformationList = [];
		}
	};
	
	self.isNull = function(val) {
		if (val == null) {
			return "--";
		} else {
			return val;
		}
	};
	
	$scope.ToJavaScriptDateTime = function(value) {
		var updateDate = '';
		if (value != '') {
			var dt = new Date(parseFloat(value));
			updateDate = dt.getUTCDate() + '/' + (dt.getUTCMonth() + 1)
					+ '/' + dt.getUTCFullYear() + ' ' + dt.getHours()
					+ ':' + dt.getMinutes() + ':' + dt.getSeconds();
			if (updateDate == '1/1/1753' || dt.getFullYear() < '1900') {
				updateDate = '';
			}
		}
		return updateDate;
	}

});


/*mainApp.controller("CompanyMasterController",
		function($http, $scope, $routeParams, CompanyMasterService) {
			var self = this;
			self.pageNo = 1;
			self.pageSize = 5;
			self.form = {};
			self.message = "";
			self.success = "";
			self.company = "";
			self.branch = "";

			CompanyMasterService.listData(self.pageNo, self.pageSize);
			CompanyMasterService.stateList();
			CompanyMasterService.cityList();

			$scope.$watch(CompanyMasterService.getData, function(newVal) {
				self.dataList = newVal;
				self.success = "";
			}, true);

			$scope.$watch(CompanyMasterService.getCompanyUnderUserList,
					function(newVal) {
						self.companyUnderUserList = newVal;
						self.success = "";
					}, true);

			$scope.$watch(CompanyMasterService.getCityStateList, function(
					newVal) {
				self.cityStateList = newVal;
			}, true);
			$scope.$watch(CompanyMasterService.getStateList, function(newVal) {
				self.stateList = newVal;

			}, true);

			$scope.$watch(CompanyMasterService.getCityList, function(newVal) {
				self.cityList = newVal;
			}, true);

			$scope.$watch(CompanyMasterService.getFormData, function(newVal) {
				self.resetForm();
				self.form.data = newVal.form;
				self.success = "";
			}, true);

			self.edit = function(id) {
				$('#mainModalLabel').text("Update Associates");
				CompanyMasterService.get(id);
			}

			$scope.$watch(CompanyMasterService.getFormData, function(newVal) {
				 UserService.notificationList(); 
				self.form.data = newVal.form;
				if (self.form.data != undefined) {
					if (self.stateList != undefined) {
						angular.forEach(self.stateList.list, function(value,
								key) {
							if (value.id == self.form.data.stateId) {
								self.selectedOptionState = value;
								CompanyMasterService.findCityState(value.id);
							}
						});
					}
					if (self.cityList != undefined) {
						angular.forEach(self.cityList.list,
								function(value, key) {
									if (value.id == self.form.data.cityId) {
										self.selectedOptionCity = value;
									}
								});
					}
				}
				self.success = "";
			}, true);

			$scope.$watch(CompanyMasterService.getProgress, function(newVal) {
				self.progress = newVal;
			}, true);

			$scope.$watch(CompanyMasterService.getSuccessMsg, function(newVal) {
				self.message = newVal;
			}, true);

			self.search = function() {
				CompanyMasterService.searchBox(self.branch, self.pageNo,
						self.pageSize);
				CompanyMasterService.getData();
			};

			self.next = function() {
				self.pageNo++;
				CompanyMasterService.listData(self.pageNo, self.pageSize);
				CompanyMasterService.getData();
			};

			self.previous = function() {
				self.pageNo--;
				CompanyMasterService.listData(self.pageNo, self.pageSize);
				CompanyMasterService.getData();
			};

			self.go = function() {
				self.pageNo;
				CompanyMasterService.listData(self.pageNo, self.pageSize);
				CompanyMasterService.getData();
			};

			self.resetForm = function() {
				self.form = {};
				$('#fileUser').val('');
				$('#mediaHere').empty();
				self.message = "";
				self.success = "";
				self.progress = "";
			};

			self.addModal = function() {
				// clear form
				self.resetForm();
				// change modal title
				$('#mainModalLabel').text("Add Company");
			};

			self.companyUnder = function(groupId) {
				self.resetForm();
				CompanyMasterService.companyUnderUserList(groupId);
			};

			self.addData = function() {
				if (self.form.id != null && self.form.id > 0) {
					CompanyMasterService.updateData(self.form, self.pageNo,
							self.pageSize);
					CompanyMasterService.getSuccessMsg();
				} else {
					self.form.id = 0;
					CompanyMasterService.addData(self.form, self.pageNo,
							self.pageSize);
					CompanyMasterService.getSuccessMsg();
				}
			};

			$scope.ToJavaScriptDateTime = function(value) {
				var updateDate = '';
				if (value != '') {
					var dt = new Date(parseFloat(value));
					updateDate = dt.getUTCDate() + '/' + (dt.getUTCMonth() + 1)
							+ '/' + dt.getUTCFullYear() + ' ' + dt.getHours()
							+ ':' + dt.getMinutes() + ':' + dt.getSeconds();
					if (updateDate == '1/1/1753' || dt.getFullYear() < '1900') {
						updateDate = '';
					}
				}
				return updateDate;
			}

			self.checkedData = {
				del : []
			};

			self.deleteData = function() {
				if (self.checkedData.del.length > 0) {
					CompanyMasterService.deleteData(self.checkedData.del + "",
							self.pageNo, self.pageSize);
					self.checkedData.del = [];
				} else {
					self.progress = "Please Check the Checkbox.";
				}
			};
		});*/