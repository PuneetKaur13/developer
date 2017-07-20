mainApp.controller("CompanyDetailController", function($http, $scope,
		ControllerService, BaseService,CompanyProductIntersectionService) {

	// Get reference of self
	var self = this;

	// Service endpoint
	self.endPoint = "/ocbc/rest/Company";

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

	self.search();
	
	// Fetch data
	self.companyProfile = function() {
		self.message = "Please Wait..";
		var endPoint = self.endPoint + "/searchByUser";
		BaseService.callEndPoint(endPoint, null).then(function(data) {
			self.message = null;
			self.form = data.form;
			self.dataList = data;
		});
	};
	
	
	self.display = function(id) {
		if (id > 0) {
			BaseService.get(id).then(function(data) {
				self.form = data.form;
				self.message = null;
				self.findCity(self.form.stateId);
			});
		}
	},

	self.updateProfile = function(ctl) {
		self.message = "Please Wait..";
		var endPoint = self.endPoint + "/updateCompany";
		BaseService.callEndPoint(endPoint, self.form).then(function(data) {
			self.message = data.message;
			self.success = data.success;
		});
	},

	self.companyProfile();
	
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


	
	// Multistep Form

	$scope.steps = [ 'Step 1: Company Info', 'Step 2: Product Info',

	];
	$scope.selection = $scope.steps[0];

	$scope.getCurrentStepIndex = function() {
		// Get the index of the current step given selection
		
		return _.indexOf($scope.steps, $scope.selection);
	};

	// Go to a defined step index
	$scope.goToStep = function(index) {
		if (!_.isUndefined($scope.steps[index])) {
			$scope.selection = $scope.steps[index];
		}
	};

	$scope.hasNextStep = function() {
		var stepIndex = $scope.getCurrentStepIndex();
		var nextStep = stepIndex + 1;
		// Return true if there is a next step, false if not

		return !_.isUndefined($scope.steps[nextStep]);
	};

	$scope.hasPreviousStep = function() {
		var stepIndex = $scope.getCurrentStepIndex();
		var previousStep = stepIndex - 1;
		// Return true if there is a next step, false if not
		return !_.isUndefined($scope.steps[previousStep]);
	};

	$scope.incrementStep = function() {
		if ($scope.hasNextStep()) {
			var stepIndex = $scope.getCurrentStepIndex();
			var nextStep = stepIndex + 1;
			$scope.selection = $scope.steps[nextStep];
		}
	};

	$scope.decrementStep = function() {
		if ($scope.hasPreviousStep()) {
			var stepIndex = $scope.getCurrentStepIndex();
			var previousStep = stepIndex - 1;
			$scope.selection = $scope.steps[previousStep];
		}
	};
	

	$scope.$watch(CompanyProductIntersectionService.getProductList, function(
			newVal) {
		self.productList = newVal;
		self.success = "";
	}, true);
	
	CompanyProductIntersectionService.productList();
	self.addPro = function() {
		// clear form
		self.resetForm();
		// change modal title
		$('#ProductLabel').text("Add Product As A Favourite");
	};

	self.addProduct = function() {
		if (self.form.id != null && self.form.id > 0) {
			CompanyProductIntersectionService.updateData(self.form,
					self.pageNo, self.pageSize);
			CompanyProductIntersectionService.getSuccessMsg();
		} else {
			self.form.id = 0;
			CompanyProductIntersectionService.addData(self.form, self.pageNo,
					self.pageSize);
			CompanyProductIntersectionService.getSuccessMsg();
		}
	};
	
});



/*mainApp.controller("CompanyDetailController", function($http, $scope, $filter,$interval,
		CompanyMasterService, UserService,CompanyProductIntersectionService) {
	var self = this;
	self.form = {};
	self.message = "";
	self.success = "";

	CompanyMasterService.searchByUser();
	CompanyMasterService.stateList();
	CompanyMasterService.cityList();
	CompanyMasterService.interSectionList();
	CompanyProductIntersectionService.productList();
	CompanyProductIntersectionService.listData(self.pageNo, self.pageSize);

	self.selectProduct = function() {
		window.location = "#/DealProduct";
		location.reload(1);
	};
	self.edit = function(id) {
		$('#mainModalLabel').text("Update Deal Product");
		CompanyProductIntersectionService.get(id);
	}

	$scope.$watch(CompanyMasterService.getFormData, function(newVal) {
	
		self.form.data = newVal.form;
		if (self.form.data != undefined) {
			if (self.stateList != undefined) {
				angular.forEach(self.stateList.list, function(value, key) {
					if (value.id == self.form.data.stateId) {
						self.selectedOptionState = value;
						CompanyMasterService.findCityState(value.id);
					}
				});
			}
			if (self.cityList != undefined) {
				angular.forEach(self.cityList.list, function(value, key) {
					if (value.id == self.form.data.cityId) {
						self.selectedOptionCity = value;
					}
				});
			}
		}
		self.success = "";
	}, true);

	$scope.$watch(CompanyProductIntersectionService.getData, function(newVal) {
		self.dataList = newVal;
		self.success = "";
	}, true);

	$scope.$watch(CompanyProductIntersectionService.getProductList, function(
			newVal) {
		self.productList = newVal;
		self.success = "";
	}, true);
	$scope.$watch(CompanyMasterService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);
	$scope.$watch(CompanyMasterService.getProductList, function(newVal) {
		self.productList = newVal;
	}, true);

	$scope.$watch(CompanyMasterService.getCompanyList, function(newVal) {
		self.companyList = newVal;

	}, true);

	$scope.$watch(CompanyMasterService.getInterSectionList, function(newVal) {
		self.interSectionList = newVal;

	}, true);

	$scope.$watch(CompanyMasterService.getSuccessMsg, function(newVal) {
		self.message = newVal;
	}, true);

	self.addData = function() {
		CompanyMasterService.addData(self.form, self.pageNo, self.pageSize);
		CompanyMasterService.getSuccessMsg();
		$.notify("Your Company Has Been Updated Successfully! ", "success");
	};
	self.interval=$interval(function() {
		CompanyProductIntersectionService.listData(self.pageNo, self.pageSize);
	}, 15000);

	self.findByProdctId = function(productId) {
		CompanyMasterService.findPackaging(productId);
	};

	$scope.$watch(CompanyMasterService.getCityStateList, function(newVal) {
		self.cityStateList = newVal;
	}, true);
	$scope.$watch(CompanyMasterService.getStateList, function(newVal) {
		self.stateList = newVal;

	}, true);

	$scope.$watch(CompanyMasterService.getCityList, function(newVal) {
		self.cityList = newVal;
	}, true);

	// Product Name List

	self.addPro = function() {
		// clear form
		self.resetForm();
		// change modal title
		$('#ProductLabel').text("Add Product As A Favourite");
	};
	self.addProduct = function() {
		if (self.form.id != null && self.form.id > 0) {
			CompanyProductIntersectionService.updateData(self.form,
					self.pageNo, self.pageSize);
			CompanyProductIntersectionService.getSuccessMsg();
		} else {
			self.form.id = 0;
			CompanyProductIntersectionService.addData(self.form, self.pageNo,
					self.pageSize);
			CompanyProductIntersectionService.getSuccessMsg();
		}
	};
	self.deleteData = function() {
		if (self.checkedData.del.length > 0) {
			CompanyProductIntersectionService.deleteData(self.checkedData.del
					+ "", self.pageNo, self.pageSize);
			self.checkedData.del = [];
		} else {
			self.progress = "Please Check the Checkbox.";
		}
	};
	self.resetForm = function() {
		self.form = {};
		self.message = "";
		self.success = "";
		self.progress = "";
		self.selectedOption = {}
	};

	// Multistep Form

	$scope.steps = [ 'Step 1: Company Info', 'Step 2: Product Info',

	];
	$scope.selection = $scope.steps[0];

	$scope.getCurrentStepIndex = function() {
		// Get the index of the current step given selection
		
		return _.indexOf($scope.steps, $scope.selection);
	};

	// Go to a defined step index
	$scope.goToStep = function(index) {
		if (!_.isUndefined($scope.steps[index])) {
			$scope.selection = $scope.steps[index];
		}
	};

	$scope.hasNextStep = function() {
		var stepIndex = $scope.getCurrentStepIndex();
		var nextStep = stepIndex + 1;
		// Return true if there is a next step, false if not

		return !_.isUndefined($scope.steps[nextStep]);
	};

	$scope.hasPreviousStep = function() {
		var stepIndex = $scope.getCurrentStepIndex();
		var previousStep = stepIndex - 1;
		// Return true if there is a next step, false if not
		return !_.isUndefined($scope.steps[previousStep]);
	};

	$scope.incrementStep = function() {
		if ($scope.hasNextStep()) {
			var stepIndex = $scope.getCurrentStepIndex();
			var nextStep = stepIndex + 1;
			$scope.selection = $scope.steps[nextStep];
		}
	};

	$scope.decrementStep = function() {
		if ($scope.hasPreviousStep()) {
			var stepIndex = $scope.getCurrentStepIndex();
			var previousStep = stepIndex - 1;
			$scope.selection = $scope.steps[previousStep];
		}
	};

	self.findByStateId = function(stateId) {
		CompanyMasterService.findCityState(stateId);
	};
});*/