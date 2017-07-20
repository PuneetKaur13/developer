mainApp.controller("LiveBidController", function($http, $scope, $routeParams,
		$interval, $filter, BuyerBiddingService, BuyerQuotationService,
		SellerQuotationService, CounterOfferService,
		AdminProductPackagingService) {
	var self = this;
	self.pageNo = 1;
	self.pageSize = 5;
	self.form = {};
	self.searchform = {};
	self.message = "";
	self.success = "";
	self.selectedId = null;

	BuyerQuotationService.liveList(self.pageNo, self.pageSize);

	$interval(function() {
		BuyerQuotationService.liveList(self.pageNo, self.pageSize);
	}, 150000);

	$scope.$watch(BuyerQuotationService.getLive, function(newVal) {
		self.dataList = newVal;
		self.success = "";
	}, true);

	$scope.$watch(BuyerQuotationService.getViewUserQoutationList, function(
			newVal) {
		self.viewUserQoutationList = newVal;
	}, true);

	$scope.$watch(BuyerQuotationService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);

	$scope.$watch(BuyerQuotationService.getSuccessMsg, function(newVal) {
		self.message = newVal;
	}, true);

	$scope.$watch(BuyerQuotationService.getViewHistoryList, function(newVal) {
		self.viewHistoryList = newVal;
		self.success = "";
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
	self.viewUserQuotation = function(productId, cityId, stateId, packagingId) {
		self.resetForm();
		BuyerQuotationService.viewUserQoutation(productId, cityId, stateId,
				packagingId);
		BuyerQuotationService.getData();
	};

	self.acceptBid = function(bidding) {
		self.form = {};
		self.success = "";
		self.form.id = bidding.id;
		self.form.buyerCompanyId = bidding.companyId;
		self.form.buyerCompanyName = bidding.companyName;
		self.form.quotationAmount = bidding.quotationAmount;
		self.form.buyerId = bidding.buyerId;
		self.form.buyerName = bidding.buyerName;
		self.form.productId = bidding.productId;
		self.form.companyId = bidding.buyerCompanyId;
		self.form.quantity = bidding.quantity;
		self.form.cityId = bidding.cityId;
		self.form.stateId = bidding.stateId;
		self.form.packagingId = bidding.packagingId;
		BuyerQuotationService.acceptBid(self.form);
	};

	self.resetForm = function() {
		self.form = {};
		self.message = "";
		self.success = "";
		self.progress = "";
		self.selectedOptionState = {};
		self.selectedOption = {};
	};
	self.addCounterOffer = function() {
		CounterOfferService.addData(self.form, self.pageNo, self.pageSize);
		self.form.type = "BUY";
		// self.form.offerBy = "Offer By Buyer"
		BuyerBiddingService.getSuccessMsg();
	};
	self.viewHistory = function(productId, buyerId, packagingId, stateId,
			cityId) {
		self.resetForm();
		BuyerQuotationService.viewHistory(productId, buyerId, packagingId,
				stateId, cityId);
		BuyerQuotationService.getData();
	};

	self.getBidId = function(bid) {
		self.resetForm();
		self.form.bidId = bid.id;
		self.form.productId = bid.productId;
		self.form.productName = bid.productName;
		self.form.companyId = bid.companyId;
		self.form.companyName = bid.companyName;
		self.form.buyerCompanyId = bid.buyerCompanyId;
		self.form.buyerCompanyName = bid.buyerCompanyName;
		self.form.sellerName = bid.sellerName;
		self.form.packagingId = bid.packagingId;
		self.form.unit = bid.unit;
		self.form.quotationAmount = bid.quotationAmount;
		self.form.isActive = false;
	};
	self.getBidCounterId = function(bidform) {
		self.resetForm();
		self.form.quotationId = bidform.id;
		self.form.sellerId = bidform.sellerId;
		self.form.buyerId = bidform.buyerId;
		self.form.sellerName = bidform.sellerName;
		self.form.buyerName = bidform.buyerName;
		self.form.productId = bidform.productId;
		self.form.productName = bidform.productName;
		self.form.packagingId = bidform.packagingId;
		self.form.unit = bidform.unit;
		self.form.counterQuantity = bidform.counterQuantity;
		self.form.counterAmount = bidform.counterAmount;
		self.form.quotationAmount = bidform.quotationAmount;
		self.form.quantity = bidform.quantity;
		self.form.stateId = bidform.stateId;
		self.form.stateName = bidform.stateName;
		self.form.cityId = bidform.cityId;
		self.form.cityName = bidform.cityName;
	};

	self.GetSelectedRow = function(id) {
		console.log(id);
		self.selectedId = id;
		console.log(self.selectedId);
	}

});