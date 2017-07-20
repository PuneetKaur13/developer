mainApp.controller("AdminProductPackagingController", function($scope,
		ControllerService) {

	// Get reference of self
	var self = this;

	// Service endpoint
	self.endPoint = "/Rushhh/rest/AdminProductPackaging";

	// Initialize controller
	ControllerService.setEndPoint(self.endPoint);

	// Get controller objects
	ControllerService.getCtlObjects(self);

	// Search Object contains filter values of list page
	self.searchData = ControllerService.getSearchObject({
		"adminProductName" : "",
		"packaging" : ""
	});

	// Initialize form
	self.resetForm = function() {
		ControllerService.resetForm(self, {
			"id" : "",
			"adminProductName" : "",
			"adminProductId" : "",
			"packaging" : ""
		});
	};

	// Initialize form
	self.resetForm();
	// Get first page of list
	self.search();

});



/*mainApp.controller("AdminProductPackagingController", function($http, $scope,
		$routeParams, AdminProductPackagingService) {
	var self = this;
	self.pageNo = 1;
	self.pageSize = 5;
	self.form = {};
	self.message = "";
	self.success = "";
	self.product = "";
	self.branch = "";
	AdminProductPackagingService.listData(self.pageNo, self.pageSize);
	AdminProductPackagingService.productList();

	if ($routeParams.id != null && $routeParams.id > 0) {
		$('#mainModalLabel').text("Update Product Packaging");
		AdminProductPackagingService.get($routeParams.id);
	}
	
	self.edit = function(id) {
		$('#mainModalLabel').text("Update Product Packaging");
		AdminProductPackagingService.get(id);
	}


	$scope.$watch(AdminProductPackagingService.getFormData, function(newVal) {
		self.resetForm();
		self.form.data = newVal.form;

		if (self.form.data != undefined) {
			if (self.productList != undefined) {
				angular.forEach(self.productList.list, function(value, key) {

					if (value.id == self.form.data.adminProductId) {
						self.selectedOption = value;

					}
				});
			}
		}
		self.success = "";
	}, true);
	$scope.$watch(AdminProductPackagingService.getData, function(newVal) {
		self.dataList = newVal;
		self.success = "";
	}, true);

	$scope.$watch(AdminProductPackagingService.getProductList,
			function(newVal) {
				self.productList = newVal;
				self.success = "";
			}, true);
	$scope.$watch(AdminProductPackagingService.getFormData, function(newVal) {
		self.resetForm();
		self.form = newVal.form;
		self.success = "";
	}, true);

	$scope.$watch(AdminProductPackagingService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);

	$scope.$watch(AdminProductPackagingService.getSuccessMsg, function(newVal) {
		self.message = newVal;
	}, true);

	self.next = function() {
		self.pageNo++;
		AdminProductPackagingService.listData(self.pageNo, self.pageSize);
		AdminProductPackagingService.getData();
	};

	self.previous = function() {
		self.pageNo--;
		AdminProductPackagingService.listData(self.pageNo, self.pageSize);
		AdminProductPackagingService.getData();
	};

	self.go = function() {
		self.pageNo;
		AdminProductPackagingService.listData(self.pageNo, self.pageSize);
		AdminProductPackagingService.getData();
	};
	self.search = function() {
		console.log('self.transaction' + self.branch);
		AdminProductPackagingService.searchBox(self.branch, self.pageNo,
				self.pageSize);
		AdminProductPackagingService.getData();
	};

	self.resetForm = function() {
		self.form = {};
		self.message = "";
		self.success = "";
		self.progress = "";
	};

	self.addModal = function() {
		// clear form
		self.resetForm();
		// change modal title
		$('#mainModalLabel').text("Add Product Wise Packaging");
	};

	self.addData = function() {
		if (self.form.id != null && self.form.id > 0) {
			AdminProductPackagingService.updateData(self.form, self.pageNo,
					self.pageSize);
			AdminProductPackagingService.getSuccessMsg();
		} else {
			self.form.id = 0;
			AdminProductPackagingService.addData(self.form, self.pageNo,
					self.pageSize);
			AdminProductPackagingService.getSuccessMsg();
		}
	};

	self.updateModal = function(role) {

	};

	self.checkedData = {
		del : []
	};

	self.deleteData = function() {
		if (self.checkedData.del.length > 0) {
			AdminProductPackagingService.deleteData(self.checkedData.del + "",
					self.pageNo, self.pageSize);
			self.checkedData.del = [];
		} else {
			self.progress = "Please Check the Checkbox.";
		}
	};
});*/