mainApp.controller("UserDetailController", function($http, $scope,
		ControllerService) {

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
		"loginId" : ""
	});

	// Initialize form
	self.resetForm = function() {
		ControllerService.resetForm(self, {
			"id" : "",
			"firstName" : "",
			"roleName":"",
			"lastName" : "",
			"loginId" : "",
			"password" : "",
			"gender" : "",
			"email" : "",
			"dob" : "",
			"mobile" : "",
			"imagePath" : ""
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

});
/*

mainApp.controller("UserDetailController", function($http, $scope,
		$routeParams, $filter, UserService) {
	var self = this;
	self.pageNo = 1;
	self.pageSize = 20;
	self.form = {};
	self.message = "";
	self.success = "";
	self.user = "";
	self.regex = '\\d+';
	self.branch = "";

	UserService.listData(self.user, self.pageNo, self.pageSize);
	UserService.roleList();

	self.edit = function(id) {
		$('#mainModalLabel').text("Update Associates");
		UserService.get(id);
	}
	$scope.$watch(UserService.getData, function(newVal) {
		self.userList = newVal;
		self.success = "";

		if (self.userList != '') {
			self.pageNo = parseInt(self.userList.pageNo);
			self.countStart = (parseInt(self.userList.pageNo) - 1)
					* parseInt(self.userList.pageSize);
		}
	}, true);

	$scope.$watch(UserService.getFormData, function(newVal) {
		self.resetForm();
		self.form.data = newVal.form;
		if (self.form.data != undefined) {
			self.form.data.validFromDate = $filter('date')(
					self.form.data.validFromDate, "yyyy-MM-dd");
			self.form.data.validToDate = $filter('date')(
					self.form.data.validToDate, "yyyy-MM-dd");
			self.form.data.dob = $filter('date')(self.form.data.dob,
					"yyyy-MM-dd");
			if (self.rolelist != undefined) {
				angular.forEach(self.rolelist.list, function(value, key) {
					if (value.id == self.form.data.roleId) {
						self.selectedOption = value;
					}
				});
			}
		}
		self.success = "";
	}, true);

	$scope.$watch(UserService.getRoleList, function(newVal) {
		self.rolelist = newVal;
	}, true);

	$scope.$watch(UserService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);

	$scope.$watch(UserService.getSuccessMsg, function(newVal) {
		self.message = newVal;
	}, true);

	self.next = function() {
		self.pageNo++;
		UserService.listData(self.user, self.pageNo, self.pageSize);
		UserService.getData();
	};

	self.previous = function() {
		self.pageNo--;
		UserService.listData(self.user, self.pageNo, self.pageSize);
		UserService.getData();
	};

	self.go = function() {
		UserService.listData(self.user, self.pageNo, self.pageSize);
		UserService.getData();
	};
	self.search = function() {
		UserService.searchBoxUser(self.branch, self.pageNo, self.pageSize);
		UserService.getData();
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
		$('#mainModalLabel').text("Add Associates");
	};

	self.addData = function() {
		self.form.data.roleId = 3;
		self.form.data.roleName = "Staff";
		self.form.data.status = "DEACTIVE";
		UserService.addData(self.form, self.pageNo, self.pageSize);
		UserService.getSuccessMsg();
	};

	self.checkedData = {
		del : []
	};

	self.deleteData = function() {
		if (self.checkedData.del.length > 0) {
			UserService.deleteData(self.checkedData.del + "", self.pageNo,
					self.pageSize);
			self.checkedData.del = [];
		} else {
			self.progress = "Please Check the Checkbox.";
		}
	};
});*/