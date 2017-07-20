mainApp.controller("ProductController", function($http, $scope, $location,
		$routeParams, ProductService) {
	var self = this;
	self.pageNo = 1;
	self.pageSize = 20;
	self.form = {};
	self.message = "";
	self.success = "";
	self.product = "";

	ProductService.listData(self.pageNo, self.pageSize);
	ProductService.productList();

	if ($routeParams.id != null && $routeParams.id > 0) {
		$('#mainModalLabel').text("Update Product");
		ProductService.get($routeParams.id);
	}

	$scope.$watch(ProductService.getFormData, function(newVal) {
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

	$scope.$watch(ProductService.getData, function(newVal) {
		self.dataList = newVal;
		if ($routeParams.id == null) {
			self.resetForm();
		}
		self.success = "";
	}, true);

	$scope.$watch(ProductService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);
	$scope.$watch(ProductService.getProductList, function(newVal) {
		self.productList = newVal;
	}, true);
	$scope.$watch(ProductService.getSuccessMsg, function(newVal) {
		self.message = newVal;
	}, true);

	self.next = function() {
		self.pageNo++;
		ProductService.listData(self.pageNo, self.pageSize);
		ProductService.getData();
	};

	self.previous = function() {
		self.pageNo--;
		ProductService.listData(self.pageNo, self.pageSize);
		ProductService.getData();
	};

	self.go = function() {
		self.pageNo;
		ProductService.listData(self.pageNo, self.pageSize);
		ProductService.getData();
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
		$location.path("Product");
		self.resetForm();
		// change modal title
		$('#mainModalLabel').text("Add Product");
	};

	self.addData = function() {
		if (self.form.id != null && self.form.id > 0) {
			ProductService.updateData(self.form, self.pageNo, self.pageSize);
			ProductService.getSuccessMsg();
		} else {
			self.form.id = 0;
			ProductService.addData(self.form, self.pageNo, self.pageSize);
			ProductService.getSuccessMsg();
		}
	};

	self.updateModal = function(product) {

	};

	self.checkedData = {
		del : []
	};

	self.deleteData = function() {
		if (self.checkedData.del.length > 0) {
			ProductService.deleteData(self.checkedData.del + "", self.pageNo,
					self.pageSize);
			self.checkedData.del = [];
		} else {
			self.progress = "Please Check the Checkbox.";
		}
	};
});