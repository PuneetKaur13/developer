mainApp.controller("BuyerMakeQoutationController", function($http, $scope,
		$routeParams, $filter, BuyerBiddingService, SellerQuotationService) {
	var self = this;
	self.pageNo = 1;
	self.pageSize = 5;
	self.form = {};
	self.searchform = {};
	self.message = "";
	self.success = "";

	BuyerBiddingService.makeQuotation(self.pageNo, self.pageSize);
	BuyerBiddingService.productList();
	BuyerBiddingService.userList();
	// BuyerBiddingService.buyerBids(null);

	if ($routeParams.id != null && $routeParams.id > 0) {
		$('#mainModalLabel').text("Update Bidding");
		BuyerBiddingService.get($routeParams.id);
	}

	$scope.$watch(BuyerBiddingService.getData, function(newVal) {
		self.dataList = newVal;
		self.success = "";
	}, true);

	$scope.$watch(BuyerBiddingService.getBuyerBids, function(newVal) {
		self.buyerBids = newVal;
		self.success = "";
	}, true);

	self.changeBids = function() {
		BuyerBiddingService.buyerBids(self.bid);
	};

	$scope.$watch(SellerQuotationService.getViewQuotationList,
			function(newVal) {
				self.viewQuotationList = newVal;
				self.success = "";
			}, true);

	$scope.$watch(BuyerBiddingService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);

	$scope.$watch(SellerQuotationService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);

	$scope.$watch(BuyerBiddingService.getProductList, function(newVal) {
		self.productList = newVal;
	}, true);

	$scope.$watch(BuyerBiddingService.getUserList, function(newVal) {
		self.userList = newVal;
	}, true);

	$scope.$watch(BuyerBiddingService.getFormData, function(newVal) {
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
					if (value.id == self.form.productId) {
						self.selectedOption = value;
					}
				});
			}
		}
		self.success = "";
	}, true);

	$scope.$watch(BuyerBiddingService.getSuccessMsg, function(newVal) {
		self.message = newVal;
	}, true);

	$scope.$watch(SellerQuotationService.getSuccessMsg, function(newVal) {
		self.message = newVal;
	}, true);

	self.search = function() {
		self.searchform.operation = "Search";
		BuyerBiddingService.search(self.searchform);
		BuyerBiddingService.getData();
	};

	self.next = function() {
		self.pageNo++;
		BuyerBiddingService.listData(self.pageNo, self.pageSize);
		BuyerBiddingService.getData();
	};

	self.previous = function() {
		self.pageNo--;
		BuyerBiddingService.listData(self.pageNo, self.pageSize);
		BuyerBiddingService.getData();
	};

	self.go = function() {
		self.pageNo;
		BuyerBiddingService.listData(self.pageNo, self.pageSize);
		BuyerBiddingService.getData();
	};

	self.viewQuotation = function(productId) {
		self.success = "";
		SellerQuotationService.viewQoutation(productId);
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
		$('#mainModalLabel').text("Add Bids");
	};

	self.addData = function() {
		if (self.form.id != null && self.form.id > 0) {
			BuyerBiddingService.updateData(self.form, self.pageNo,
					self.pageSize);
			BuyerBiddingService.getSuccessMsg();
		} else {
			self.form.id = 0;
			self.form.status = "DEACTIVE";
			BuyerBiddingService.addData(self.form, self.pageNo, self.pageSize);
			BuyerBiddingService.getSuccessMsg();
		}
	};

	self.addQuotation = function() {
		SellerQuotationService.addData(self.form, self.pageNo, self.pageSize);
		BuyerBiddingService.getSuccessMsg();
		self.form.status = "OPEN";

	};

	self.getBidId = function(bid) {
		self.resetForm();
		self.form.bidId = bid.id;
		self.form.productId = bid.productId;
		self.form.productName = bid.productName;
		self.form.sellerCompanyId = bid.companyId;
		self.form.sellerCompanyName = bid.companyName;
	};

	self.checkedData = {
		del : []
	};

	self.deleteData = function() {
		if (self.checkedData.del.length > 0) {
			BuyerBiddingService.deleteData(self.checkedData.del + "",
					self.pageNo, self.pageSize);
			self.checkedData.del = [];
		} else {
			self.progress = "Please Check the Checkbox.";
		}
	};
});