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




/*mainApp.controller("SellerQuotationController", function($http, $scope,
		$routeParams, $filter, SellerQuotationService,BuyerQuotationService,SellerBiddingService) {
	var self = this;
	self.pageNo = 1;
	self.pageSize = 5;
	self.form = {};
	self.searchform = {};
	self.message = "";
	self.success = "";

	SellerQuotationService.searchByUser(self.pageNo, self.pageSize);
	SellerQuotationService.productList();
	SellerQuotationService.userList();

	if ($routeParams.id != null && $routeParams.id > 0) {
		$('#mainModalLabel').text("Update Bidding");
		SellerQuotationService.get($routeParams.id);
	}
	$scope.$watch(SellerQuotationService.getData, function(newVal) {
		self.dataList = newVal;
		self.success = "";
	}, true);

	$scope.$watch(SellerQuotationService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);

	$scope.$watch(SellerQuotationService.getProductList, function(newVal) {
		self.productList = newVal;
	}, true);

	$scope.$watch(SellerQuotationService.getUserList, function(newVal) {
		self.userList = newVal;
	}, true);

	$scope.$watch(SellerQuotationService.getFormData, function(newVal) {
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

	$scope.$watch(SellerQuotationService.getSuccessMsg, function(newVal) {
		self.message = newVal;
	}, true);

	$scope.$watch(SellerQuotationService.getCounterList, function(newVal) {
		self.counterList = newVal;
	}, true);

	self.viewCounter = function(qId) {
		SellerQuotationService.viewCounter(qId);
	};
	self.sellerCounter = function() {
		window.location = "#/SellerMakeQuotation";
		location.reload(1);
	};
	
	self.search = function() {
		self.searchform.operation = "Search";
		SellerQuotationService.search(self.searchform);
		SellerQuotationService.getData();
	};

	self.next = function() {
		self.pageNo++;
		SellerQuotationService.listData(self.pageNo, self.pageSize);
		SellerQuotationService.getData();
	};
	self.previous = function() {
		self.pageNo--;
		SellerQuotationService.listData(self.pageNo, self.pageSize);
		SellerQuotationService.getData();
	};

	self.go = function() {
		self.pageNo;
		SellerQuotationService.listData(self.pageNo, self.pageSize);
		SellerQuotationService.getData();
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

	self.addQuotation = function() {
		BuyerQuotationService.addData(self.form, self.pageNo, self.pageSize);
		self.form.status = "OPEN";
		//a="KG";
	};
	self.getBidId = function(bid) {
		self.resetForm();
		self.form.bidId = bid.bidId;
		self.form.packagingId = bid.packagingId;
		self.form.packaging = bid.packaging;
		self.form.productId = bid.productId;
		self.form.productName = bid.productName;
		self.form.buyerCompanyId = bid.companyId;
		self.form.buyerCompanyName = bid.companyName;
		self.form.unit = bid.unit;
		self.form.quantity = bid.quantity;
		self.form.cityId = bid.cityId;
		self.form.cityName = bid.cityName;
		self.form.stateId = bid.stateId;
		self.form.stateName = bid.stateName;
	
	};
	self.addData = function() {
		if (self.form.id != null && self.form.id > 0) {
			SellerQuotationService.updateData(self.form, self.pageNo,
					self.pageSize);
			SellerQuotationService.getSuccessMsg();
		} else {
			self.form.id = 0;
			SellerQuotationService.addData(self.form, self.pageNo,
					self.pageSize);
			SellerQuotationService.getSuccessMsg();
		}
	};
	self.updateModal = function(bid) {
		
		 * // change modal title $('#mainModalLabel').text("Update Bidding");
		 * self.resetForm(); // self.form = self.convertForm(bidding); self.form =
		 * bid;
		 
	};

	self.checkedData = {
		del : []
	};

	self.deleteData = function() {
		if (self.checkedData.del.length > 0) {
			SellerQuotationService.deleteData(self.checkedData.del + "",
					self.pageNo, self.pageSize);
			self.checkedData.del = [];
		} else {
			self.progress = "Please Check the Checkbox.";
		}
	};
});*/