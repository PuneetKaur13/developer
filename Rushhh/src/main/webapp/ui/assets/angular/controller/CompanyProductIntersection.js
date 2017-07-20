mainApp.controller("CompanyProductIntersectionController", function($scope, ControllerService,
		BaseService) {
	var self = this;

	// Service endpoint
	self.endPoint = "/OCBS/rest/CompanyProductIntersection";

	// Initialize controller
	ControllerService.setEndPoint(self.endPoint);

	// Get controller objects
	ControllerService.getCtlObjects(self);

	// Search Object contains filter values of list page
	self.searchData = ControllerService.getSearchObject({});

	// Initialize form
	self.resetForm = function() {
		ControllerService.resetForm(self, {
			"id" : ""
		});
	};

	// Initialize form
	self.resetForm();
	// Get first page of list
	self.search();

});





/*mainApp.controller("CompanyProductIntersectionController", function($http, $scope,
		CompanyProductIntersectionService) {
	var self = this;
	self.pageNo = 1;
	self.pageSize = 5;
	self.form = {};
	self.message = "";
	self.success = "";

	CompanyProductIntersectionService.listData(self.pageNo, self.pageSize);
	CompanyProductIntersectionService.productList();

	self.edit = function(id) {
		$('#mainModalLabel').text("Update Deal Product");
		CompanyProductIntersectionService.get(id);
	}
	
	$scope.$watch(CompanyProductIntersectionService.getData, function(newVal) {
		self.dataList = newVal;
		self.success = "";
	}, true);
	
	$scope.$watch(CompanyProductIntersectionService.getProductList, function(newVal) {
		self.productList = newVal;
		self.success = "";
	}, true);
	
	$scope.$watch(CompanyProductIntersectionService.getFormData, function(newVal) {
		self.resetForm();
		self.form = newVal.form;
		self.success = "";
	}, true);

	$scope.$watch(CompanyProductIntersectionService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);

	$scope.$watch(CompanyProductIntersectionService.getSuccessMsg, function(newVal) {
		self.message = newVal;
		if(newVal.success==true){
			window.location = "#/CompanyDetail";
			//location.reload(1);
		}else if(newVal.success==false)
			{
				window.location = "#/DealProduct";
			}
	}, true);

	self.next = function() {
		self.pageNo++;
		CompanyProductIntersectionService.listData(self.pageNo, self.pageSize);
		CompanyProductIntersectionService.getData();
	};

	self.previous = function() {
		self.pageNo--;
		CompanyProductIntersectionService.listData(self.pageNo, self.pageSize);
		CompanyProductIntersectionService.getData();
	};

	self.go = function() {
		self.pageNo;
		CompanyProductIntersectionService.listData(self.pageNo, self.pageSize);
		CompanyProductIntersectionService.getData();
	};
	
	$scope.$watch(CompanyProductIntersectionService.getFormData, function(newVal) {
		self.resetForm();
		self.form = newVal.form;
		if (self.form != undefined) {
			if (self.productList != undefined) {
				angular.forEach(self.productList.list, function(value, key) {
					if (value.id == self.form.productId) {
						self.selectedOption = value;
					}
				});
			}
		}
		self.success = "";
	}, true);

	self.resetForm = function() {
		self.form = {};
		self.message = "";
		self.success = "";
		self.progress = "";
		self.selectedOption={}
	};

	self.addModal = function() {
		// clear form
		self.resetForm();
		// change modal title
		$('#mainModalLabel').text("Add Product");
	};
	
	

	self.addData = function() {
		if (self.form.id != null && self.form.id > 0) {
			CompanyProductIntersectionService.updateData(self.form, self.pageNo, self.pageSize);
			CompanyProductIntersectionService.getSuccessMsg();
		} else {
			self.form.id = 0;
			CompanyProductIntersectionService.addData(self.form, self.pageNo, self.pageSize);
			CompanyProductIntersectionService.getSuccessMsg();
		}
	};

	self.updateModal = function(role) {

	};

	self.checkedData = {
		del : []
	};

	self.deleteData = function() {
		if (self.checkedData.del.length > 0) {
			CompanyProductIntersectionService.deleteData(self.checkedData.del + "", self.pageNo,
					self.pageSize);
			self.checkedData.del = [];
		} else {
			self.progress = "Please Check the Checkbox.";
		}
	};
});*/