mainApp.controller("SeeSellerOffersController", function($scope, ControllerService,
		BaseService) {
	var self = this;

	// Service endpoint
	self.endPoint = "/OCBS/rest/SellerBidding";

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



/*mainApp.controller("SeeSellerOffersController", function($http, $scope,
		$routeParams, $filter, BuyerBiddingService, SellerQuotationService,
		SellerBiddingService) {
	var self = this;
	self.pageNo = 1;
	self.pageSize = 5;
	self.form = {};
	self.searchform = {};
	self.message = "";
	self.success = "";
	self.sell = {};
	self.sell.status = "ACTIVE";
	self.isDisabled = false;

	BuyerBiddingService.seeSellerOffers(self.pageNo, self.pageSize);
	SellerBiddingService.sellerOfferSee(self.sell);

	$scope.$watch(BuyerBiddingService.getData, function(newVal) {
		self.dataList = newVal;
		self.success = "";
	}, true);

	$scope.$watch(BuyerBiddingService.getBuyerBids, function(newVal) {
		self.buyerBids = newVal;
		self.success = "";
	}, true);

	$scope.$watch(SellerQuotationService.getViewQuotationList,
			function(newVal) {
				self.viewQuotationList = newVal;
				self.success = "";
			}, true);

	$scope.$watch(BuyerBiddingService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);

	$scope.$watch(SellerBiddingService.getSellerOfferSee, function(newVal) {
		self.sellerOffersSee = newVal;
		self.success = "";
	}, true);

	self.changeSells = function(status) {
		self.sell.status = status;
		SellerBiddingService.sellerOfferSee(self.sell);
		self.activeTab = self.dataList.paneId;
	};

	$scope.$watch(SellerBiddingService.getSellerOfferProgress,
			function(newVal) {
				self.sellerOfferProgress = newVal;
			}, true);

	$scope.$watch(BuyerBiddingService.getProductList, function(newVal) {
		self.productList = newVal;
	}, true);

	$scope.$watch(BuyerBiddingService.getUserList, function(newVal) {
		self.userList = newVal;
	}, true);

	self.visitor = function(bidding) {
		self.isDisabled = true;
		self.form = {};
		self.success = "";
		BuyerBiddingService.visitor(self.form);
	};

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

	self.getBidId = function(bid) {
		self.resetForm();
		self.form.bidId = bid.id;
		self.form.productId = bid.productId;
		self.form.productName = bid.productName;
		self.form.sellerCompanyId = bid.companyId;
		self.form.sellerCompanyName = bid.companyName;
	};

});*/