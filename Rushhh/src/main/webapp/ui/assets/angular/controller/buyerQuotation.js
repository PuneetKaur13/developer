mainApp.controller("BuyerQuotationController", function($scope, ControllerService,
		BaseService) {
	var self = this;

	// Service endpoint
	self.endPoint = "/OCBS/rest/BuyerQuotation";

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

/*mainApp.controller("BuyerQuotationController", function($http, $scope,
		$routeParams, $filter, BuyerQuotationService) {
	var self = this;
	self.pageNo = 1;
	self.pageSize = 5;
	self.form = {};
	self.searchform = {};
	self.message = "";
	self.success = "";

	BuyerQuotationService.searchByUser(self.pageNo, self.pageSize);
	BuyerQuotationService.productList();
	BuyerQuotationService.userList();

	if ($routeParams.id != null && $routeParams.id > 0) {
		$('#mainModalLabel').text("Update Bidding");
		BuyerQuotationService.get($routeParams.id);
	}
	$scope.$watch(BuyerQuotationService.getData, function(newVal) {
		self.dataList = newVal;
		self.success = "";
	}, true);

	$scope.$watch(BuyerQuotationService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);

	$scope.$watch(BuyerQuotationService.getProductList, function(newVal) {
		self.productList = newVal;
	}, true);

	$scope.$watch(BuyerQuotationService.getUserList, function(newVal) {
		self.userList = newVal;
	}, true);

	$scope.$watch(BuyerQuotationService.getFormData, function(newVal) {
		self.resetForm();
		self.form = newVal.form;
		if (self.form != undefined) {
			self.form.startDate = $filter('date')(self.form.startDate,
					"yyyy-MM-dd");
			self.form.enddate = $filter('date')
					(self.form.enddate, "yyyy-MM-dd");
			self.form.expectedDeliveryDate = $filter('date')(
					self.form.expectedDeliveryDate, "yyyy-MM-dd");

			if (self.productList != undefined) {
				angular.forEach(self.productList.list, function(value, key) {
					if (value.id == self.form.adminProductId) {
						self.selectedOption = value;
					}
				});
			}
		}
		self.success = "";
	}, true);

	$scope.$watch(BuyerQuotationService.getSuccessMsg, function(newVal) {
		self.message = newVal;
	}, true);

	$scope.$watch(BuyerQuotationService.getCounterList, function(newVal) {
		self.counterList = newVal;
	}, true);


	self.viewCounter = function(qId) {
		BuyerQuotationService.viewCounter(qId);
	};

	self.search = function() {
		self.searchform.operation = "Search";
		BuyerQuotationService.search(self.searchform);
		BuyerQuotationService.getData();
	};

	self.next = function() {
		self.pageNo++;
		BuyerQuotationService.listData(self.pageNo, self.pageSize);
		BuyerQuotationService.getData();
	};

	self.previous = function() {
		self.pageNo--;
		BuyerQuotationService.listData(self.pageNo, self.pageSize);
		BuyerQuotationService.getData();
	};

	self.go = function() {
		self.pageNo;
		BuyerQuotationService.listData(self.pageNo, self.pageSize);
		BuyerQuotationService.getData();
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
		$('#mainModalLabel').text("Add Bidding");
	};
	self.addData = function() {
		if (self.form.id != null && self.form.id > 0) {
			BuyerQuotationService.updateData(self.form, self.pageNo,
					self.pageSize);
			BuyerQuotationService.getSuccessMsg();
		} else {
			self.form.id = 0;
			BuyerQuotationService
					.addData(self.form, self.pageNo, self.pageSize);
			BuyerQuotationService.getSuccessMsg();
		}
	};

	self.updateModal = function(bid) {

	};

	self.checkedData = {
		del : []
	};

	self.deleteData = function() {
		if (self.checkedData.del.length > 0) {
			BuyerQuotationService.deleteData(self.checkedData.del + "",
					self.pageNo, self.pageSize);
			self.checkedData.del = [];
		} else {
			self.progress = "Please Check the Checkbox.";
		}
	};
});*/