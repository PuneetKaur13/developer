mainApp.controller("SellSupplierController", function($scope, ControllerService,
		BaseService) {
	var self = this;

	// Service endpoint
	self.endPoint = "/OCBS/rest/SellSupplier";

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
	
	self.display = function(id) {
		self.resetForm();
		if (id > 0) {
			BaseService.get(id).then(function(data) {
				self.form = data.form;
				self.message = null;
				self.findByUserCompanyProduct(self.form.productId);
			});
		}
	},
	
	
	self.userCompanyProductList = [];

	
	self.findByUserCompanyProduct = function(productId) {
		
		if (productId != undefined) {
			var endPoint =  "/OCBS/rest/CompanyProductIntersection/findByProduct/" +productId;
			BaseService.callEndPoint(endPoint, null).then(function(data) {
				self.userCompanyProductList = data.list;
			});
		} else {
			self.userCompanyProductList = [];
		}

	};

});




/*mainApp.controller("SellSupplierController", function($http, $scope,
		$routeParams, SellSupplierService) {
	var self = this;
	self.pageNo = 1;
	self.pageSize = 5;
	self.form = {};
	self.message = "";
	self.success = "";

	SellSupplierService.listData(self.pageNo, self.pageSize);
	SellSupplierService.productList();
	SellSupplierService.searchForSellSupplier();
	

	

	if ($routeParams.id != null && $routeParams.id > 0) {
		$('#mainModalLabel').text("Update Seller's List");
		SellSupplierService.get($routeParams.id);
	}
	$scope.$watch(SellSupplierService.getSearchForSellSupplier, function(newVal) {
		self.searchForSellSupplier = newVal;
	}, true);

	$scope.$watch(SellSupplierService.getData, function(newVal) {
		self.dataList = newVal;
		self.success = "";
	}, true);
	
	$scope.$watch(SellSupplierService.getSellerList, function(newVal) {
		self.sellerList = newVal;
		self.success = "";
	}, true);

	$scope.$watch(SellSupplierService.getFormData, function(newVal) {
		self.resetForm();
		self.form = newVal.form;
		self.success = "";
	}, true);

	$scope.$watch(SellSupplierService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);

	$scope.$watch(SellSupplierService.getProductList, function(newVal) {
		self.productList = newVal;
	}, true);

	$scope.$watch(SellSupplierService.getSuccessMsg, function(newVal) {
		self.message = newVal;
	}, true);
	self.next = function() {
		self.pageNo++;
		SellSupplierService.listData(self.pageNo, self.pageSize);
		SellSupplierService.getData();
	};
	self.previous = function() {
		self.pageNo--;
		SellSupplierService.listData(self.pageNo, self.pageSize);
		SellSupplierService.getData();
	};
	self.go = function() {
		self.pageNo;
		SellSupplierService.listData(self.pageNo, self.pageSize);
		SellSupplierService.getData();
	};
	self.resetForm = function() {
		self.form = {};
		self.message = "";
		self.success = "";
		self.progress = "";
		self.selectedOption = {};
		self.selectedOptionSeller={};
	};
	self.addModal = function() {
		// clear form
		self.resetForm();
		// change modal title
		$('#mainModalLabel').text("Add Favourite Seller's");
	};
	self.addData = function() {
		if (self.form.id != null && self.form.id > 0) {
			SellSupplierService
					.updateData(self.form, self.pageNo, self.pageSize);
			SellSupplierService.getSuccessMsg();
		} else {
			self.form.id = 0;
			SellSupplierService.addData(self.form, self.pageNo, self.pageSize);
			SellSupplierService.getSuccessMsg();
		}
	};
	
	self.findByProduct = function(productId) {
		SellSupplierService.findByProductId(productId);
	};
	
	self.updateModal = function(role) {

	};
	self.convertForm = function(data) {
		self.form = {};
		return self.form;
	};
	$scope.$watch(SellSupplierService.getPackagingList,
			function(newVal) {
				self.packagingList = newVal;
			}, true);
	self.findByProdctId = function(productId) {
		SellSupplierService.findPackaging(productId);
	};
	self.checkedData = {
		del : []
	};
	self.deleteData = function() {
		if (self.checkedData.del.length > 0) {
			SellSupplierService.deleteData(self.checkedData.del + "",
					self.pageNo, self.pageSize);
			self.checkedData.del = [];
		} else {
			self.progress = "Please Check the Checkbox.";
		}
	};
});*/