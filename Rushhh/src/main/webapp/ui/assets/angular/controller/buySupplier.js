mainApp.controller("BuySupplierController", function($http, $scope,
		$routeParams, BuySupplierService) {
	var self = this;
	self.pageNo = 1;
	self.pageSize = 5;
	self.form = {};
	self.message = "";
	self.success = "";

	BuySupplierService.listData(self.pageNo, self.pageSize);
	BuySupplierService.productList();
	BuySupplierService.searchForBuySupplier();
	

	if ($routeParams.id != null && $routeParams.id > 0) {
		$('#mainModalLabel').text("Update Buyer's List");
		BuySupplierService.get($routeParams.id);
	}
	$scope.$watch(BuySupplierService.getSearchForBuySupplier, function(newVal) {
		self.searchForBuySupplier = newVal;
	}, true);
	$scope.$watch(BuySupplierService.getData, function(newVal) {
		self.dataList = newVal;
		self.success = "";
	}, true);

	$scope.$watch(BuySupplierService.getFormData, function(newVal) {
		self.resetForm();
		self.form = newVal.form;
		self.success = "";
	}, true);

	$scope.$watch(BuySupplierService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);

	$scope.$watch(BuySupplierService.getProductList, function(newVal) {
		self.productList = newVal;
	}, true);

	$scope.$watch(BuySupplierService.getSuccessMsg, function(newVal) {
		self.message = newVal;
	}, true);

	self.next = function() {
		self.pageNo++;
		BuySupplierService.listData(self.pageNo, self.pageSize);
		BuySupplierService.getData();
	};

	self.previous = function() {
		self.pageNo--;
		BuySupplierService.listData(self.pageNo, self.pageSize);
		BuySupplierService.getData();
	};

	self.go = function() {
		self.pageNo;
		BuySupplierService.listData(self.pageNo, self.pageSize);
		BuySupplierService.getData();
	};

	self.resetForm = function() {
		self.form = {};
		self.message = "";
		self.success = "";
		self.progress = "";
		self.selectedOption = {};
		self.selectedOptionPackaging = {};
	};

	self.addModal = function() {
		// clear form
		self.resetForm();
		// change modal title
		$('#mainModalLabel').text("Add Favourite Buyer's");
	};

	self.addData = function() {
		if (self.form.id != null && self.form.id > 0) {
			BuySupplierService
					.updateData(self.form, self.pageNo, self.pageSize);
			BuySupplierService.getSuccessMsg();
		} else {
			self.form.id = 0;
			BuySupplierService.addData(self.form, self.pageNo, self.pageSize);
			BuySupplierService.getSuccessMsg();
		}
	};

	self.updateModal = function(role) {

	};

	self.convertForm = function(data) {
		self.form = {};
		return self.form;
	};
	$scope.$watch(BuySupplierService.getPackagingList,
			function(newVal) {
				self.packagingList = newVal;
			}, true);
	self.findByProdctId = function(productId) {
		BuySupplierService.findPackaging(productId);
	};

	self.checkedData = {
		del : []
	};

	self.deleteData = function() {
		if (self.checkedData.del.length > 0) {
			BuySupplierService.deleteData(self.checkedData.del + "",
					self.pageNo, self.pageSize);
			self.checkedData.del = [];
		} else {
			self.progress = "Please Check the Checkbox.";
		}
	};
});