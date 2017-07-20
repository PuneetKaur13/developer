mainApp.controller("PreferredSupplierController", function($http, $scope,
		$routeParams, PreferredSupplierService, NonPreferredSupplierService) {
	var self = this;
	self.pageNo = 1;
	self.pageSize = 5;
	self.form = {};
	self.message = "";
	self.success = "";

	PreferredSupplierService.listData(self.pageNo, self.pageSize);
	NonPreferredSupplierService.preListData(self.pageNo, self.pageSize);
	PreferredSupplierService.companyList();
	PreferredSupplierService.productList();

	if ($routeParams.id != null && $routeParams.id > 0) {
		$('#mainModalLabel').text("Update Message");
		PreferredSupplierService.get($routeParams.id);
	}
	$scope.$watch(PreferredSupplierService.getUserList, function(newVal) {
		self.userList = newVal;
		self.success = "";
	}, true);
	$scope.$watch(PreferredSupplierService.getProductList, function(newVal) {
		self.productList = newVal;
		self.success = "";
	}, true);
	$scope.$watch(PreferredSupplierService.getCompanyList, function(newVal) {
		self.companyList = newVal;
		self.success = "";
	}, true);
	$scope.$watch(NonPreferredSupplierService.getPreData, function(newVal) {
		self.preDataList = newVal;
		self.success = "";
	}, true);
	$scope.$watch(PreferredSupplierService.getData, function(newVal) {
		self.dataList = newVal;
		self.success = "";
	}, true);

	$scope.$watch(PreferredSupplierService.getFormData, function(newVal) {
		self.resetForm();
		self.form = newVal.form;
		self.success = "";
	}, true);

	$scope.$watch(NonPreferredSupplierService.getFormData, function(newVal) {
		self.resetForm();
		self.form = newVal.form;
		self.success = "";
	}, true);

	$scope.$watch(PreferredSupplierService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);

	$scope.$watch(NonPreferredSupplierService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);

	$scope.$watch(NonPreferredSupplierService.getSuccessMsg, function(newVal) {
		self.message = newVal;
	}, true);

	$scope.$watch(PreferredSupplierService.getSuccessMsg, function(newVal) {
		self.message = newVal;
	}, true);

	self.next = function() {
		self.pageNo++;
		PreferredSupplierService.listData(self.pageNo, self.pageSize);
		PreferredSupplierService.getData();
	};

	self.previous = function() {
		self.pageNo--;
		PreferredSupplierService.listData(self.pageNo, self.pageSize);
		PreferredSupplierService.getData();
	};

	self.go = function() {
		self.pageNo;
		PreferredSupplierService.listData(self.pageNo, self.pageSize);
		PreferredSupplierService.getData();
	};

	self.resetForm = function() {
		self.form = {};
		self.message = "";
		self.success = "";
		self.progress = "";
		self.selectedOptionProduct={};
		self.selectedOption={};
	};

	self.addModalPrefferd = function() {
		// clear form
		self.resetForm();
		// change modal title
		$('#mainModalLabel').text("Add Preferred Supplier");
	};
	self.addModalNonPrefferd = function() {
		// clear form
		self.resetForm();
		// change modal title
		$('#mainModalLabel1').text("Add Non Preferred Supplier");
	};
	self.addDataPrefferd = function() {
		if (self.form.id != null && self.form.id > 0) {
			PreferredSupplierService.updateData(self.form, self.pageNo,
					self.pageSize);
			PreferredSupplierService.getSuccessMsg();
		} else {
			self.form.id = 0;
			PreferredSupplierService.addDataPrefferd(self.form, self.pageNo,
					self.pageSize);
			PreferredSupplierService.getSuccessMsg();
		}
	};

	self.addDataNonPrefferd = function() {
		if (self.form.id != null && self.form.id > 0) {

			NonPreferredSupplierService.getSuccessMsg();
		} else {
			self.form.id = 0;
			NonPreferredSupplierService.addDataNonPrefferd(self.form,
					self.pageNo, self.pageSize);
			NonPreferredSupplierService.getSuccessMsg();
		}
	};

	self.updateModal = function(role) {

	};

	self.convertForm = function(data) {
		self.form = {};
		self.form.id = data.id;
		self.form.type = data.type;
		self.form.title = data.title;
		self.form.message = data.message;
		return self.form;
	};

	self.checkedData = {
		del : []
	};

	self.checkedNonData = {
		dele : []
	};

	self.deleteData = function() {
		if (self.checkedData.del.length > 0) {
			PreferredSupplierService.deleteData(self.checkedData.del + "",
					self.pageNo, self.pageSize);
			self.checkedData.del = [];
		} else {
			self.progress = "Please Check the Checkbox.";
		}
	};

	self.nonDeleteData = function() {
		if (self.checkedNonData.dele.length > 0) {
			NonPreferredSupplierService.nonDeleteData(self.checkedNonData.dele
					+ "", self.pageNo, self.pageSize);
			self.checkedNonData.dele = [];
		} else {
			self.progress = "Please Check the Checkbox.";
		}
	};
});