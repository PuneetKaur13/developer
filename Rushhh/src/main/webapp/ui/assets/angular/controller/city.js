
mainApp.controller("CityController", function($scope, ControllerService) {

	// Get reference of self
	var self = this;

	// Service endpoint
	self.endPoint = "/Rushhh/rest/City";

	// Initialize controller
	ControllerService.setEndPoint(self.endPoint);

	// Get controller objects
	ControllerService.getCtlObjects(self);

	// Search Object contains filter values of list page
	self.searchData = ControllerService.getSearchObject({
		"stateName" : "",
		"cityName" : ""
	});

	// Initialize form
	self.resetForm = function() {
		ControllerService.resetForm(self, {
			"id" : "",
			"stateName" : "",
			"stateId" : ""
		});
	};

	// Initialize form
	self.resetForm();
	// Get first page of list
	self.search();

});

/*mainApp.controller("CityController", function($http, $scope, $routeParams,
		CityService, StateService) {
	var self = this;
	self.pageNo = 1;
	self.pageSize = 5;
	self.form = {};
	self.message = "";
	self.success = "";
	self.state = "";
	self.branch="";

	CityService.listData(self.pageNo, self.pageSize);
	CityService.stateList();

	if ($routeParams.id != null && $routeParams.id > 0) {
		$('#mainModalLabel').text("Update Message");
		CityService.get($routeParams.id);
	}
	$scope.$watch(CityService.getFormData, function(newVal) {
		self.resetForm();
		self.form = newVal.form;
		if (self.form != undefined) {
			if (self.stateList != undefined) {
	
				angular.forEach(self.stateList.list, function(value, key) {
					if (value.id == self.form.stateId) {
						self.selectedOption = value;
					}
				});
			}
		}
		self.success = "";
	}, true);
	$scope.$watch(CityService.getStateList, function(newVal) {
		self.stateList = newVal;
		self.success = "";
	}, true);

	$scope.$watch(CityService.getData, function(newVal) {
		self.dataList = newVal;
		self.success = "";
	}, true);

	$scope.$watch(CityService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);

	$scope.$watch(CityService.getSuccessMsg, function(newVal) {
		self.message = newVal;
	}, true);

	self.next = function() {
		self.pageNo++;
		CityService.listData(self.pageNo, self.pageSize);
		CityService.getData();
	};
	self.search = function() {
		 CityService.searchBox(self.branch,self.pageNo, self.pageSize);
		 CityService.getData();
	};
	self.previous = function() {
		self.pageNo--;
		CityService.listData(self.pageNo, self.pageSize);
		CityService.getData();
	};

	self.go = function() {
		self.pageNo;
		CityService.listData(self.pageNo, self.pageSize);
		CityService.getData();
	};

	self.resetForm = function() {
		self.form = {};
		self.message = "";
		self.success = "";
		self.progress = "";
		self.selectedOption="";
	};

	self.addModal = function() {
		// clear form
		self.resetForm();
		$('#mainModalLabel').text("Add Product Wise Packaging");
	};

	self.addData = function() {
		if (self.form.id != null && self.form.id > 0) {
			CityService.updateData(self.form, self.pageNo, self.pageSize);
			CityService.getSuccessMsg();
		} else {
			self.form.id = 0;
			CityService.addData(self.form, self.pageNo, self.pageSize);
			CityService.getSuccessMsg();
		}
	};

	self.convertForm = function(data) {
		self.form = {};
		self.form.stateid = data.stateId;
		self.form.stateName = data.stateName;
		self.form.id = data.cityId;
		self.form.cityName = data.cityName;
		return self.form;
	};

	self.checkedData = {
		del : []
	};

	self.deleteData = function() {
		if (self.checkedData.del.length > 0) {
			CityService.deleteData(self.checkedData.del + "", self.pageNo,
					self.pageSize);
			self.checkedData.del = [];
		} else {
			self.progress = "Please Check the Checkbox.";
		}
	};
});*/