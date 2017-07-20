mainApp.controller("SellerMakeQoutationController", function($scope,$filter,
		ControllerService, BaseService,BuyerBiddingService,BuyerQuotationService,SellerBiddingService) {
	var self = this;
	
	self.message = "";
	self.success = "";
	// Service endpoint
	self.endPoint = "/OCBS/rest/MakeQuotation";
	
	

	// Initialize controller
	ControllerService.setEndPoint(self.endPoint);

	// Get controller objects
	ControllerService.getCtlObjects(self);

	// Search Object contains filter values of list page
	self.searchData = ControllerService.getSearchObject({
		"status":""
	});

	// Initialize form
	self.resetForm = function() {
		ControllerService.resetForm(self, {
			"id" : "",
		
		});
	},
	
	self.display = function() {

	};
	// Initialize form
	self.resetForm();
	// Get first page of list
	self.search();
	
	self.accept = function(bidding) {
		self.form = {};
		self.success = "";
		self.form.bidId = bidding.bidId;
		self.form.inviteStatus = bidding.inviteStatus;
		self.form.invitedUserId = bidding.invitedUserId;
		BuyerBiddingService.acceptInvitation(self.form);
	}
	self.reject = function(bidding) {
		self.form = {};
		self.success = "";
		self.form.bidId = bidding.bidId;
		self.form.inviteStatus = bidding.inviteStatus;
		self.form.invitedUserId = bidding.invitedUserId;
		BuyerBiddingService.rejectInvitation(self.form);
	}
	
	$scope.$watch(BuyerBiddingService.getCompanyUnderUserList,
			function(newVal) {
				self.companyUnderUserList = newVal;
				self.success = "";
			}, true);
	self.companyUnder = function(bidId, inviteGroupId) {
		self.resetForm();
		BuyerBiddingService.companyUnderUserList(bidId, inviteGroupId);
		
	};
	
	self.approveQuote = function(bids) {
		
		self.form = {};
		self.success = "";
		self.form.bidId = bids[7];
		self.form.inviteGroupId = bids[1];
		self.form.isQuote = bids[9];
		self.form.approveUserId = bids[10];

		BuyerBiddingService.approveQuote(self.form);
	}
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
	$scope.$watch(SellerBiddingService.getSuccessMsg, function(newVal) {
		self.message = newVal;
	}, true);
	self.addQuotation = function(data) {
		BuyerQuotationService.addData(self.form);
		SellerBiddingService.getSuccessMsg();
		self.form.status = "OPEN";
		a = "KG";
	};
	
	self.viewQuotationList=[];

	self.viewQuotation = function(productId, cityId, stateId, packagingId) {
		if (productId != undefined) {
			var endPoint = "/OCBS/rest/BuyerQuotation/viewQoutation/" + productId + "/"+cityId+"/"+stateId+"/"+packagingId;
				
			BaseService.callEndPoint(endPoint, null).then(function(data) {
				self.viewQuotationList = data.list;
			});
		} else {
			self.viewQuotationList = [];
		}
	};
	
	self.viewCounterHistoryList=[];

	self.viewCounterHistory = function(bidId) {
		if (bidId != undefined) {
			var endPoint = "/OCBS/rest/SellerQuotation/getHistory/" + bidId;
				
			BaseService.callEndPoint(endPoint, null).then(function(data) {
				self.viewCounterHistoryList = data.list;
			});
		} else {
			self.viewCounterHistoryList = [];
		}
	};
	

});

/*mainApp.controller("SellerMakeQoutationController", function($http, $scope,
		$routeParams, $interval, $filter, SellerBiddingService,
		BuyerQuotationService, BuyerBiddingService, PreferredSupplierService,
		SellerQuotationService, UserService, CompanyMasterService) {
	var self = this;
	self.pageNo = 1;
	self.pageSize = 5;
	self.form = {};
	self.searchform = {};
	self.message = "";
	self.success = "";
	self.bid = {};
	self.bid.status = "ACTIVE";
	self.count = 0;

	SellerBiddingService.makeQuotation(self.pageNo, self.pageSize);
	BuyerBiddingService.buyerBidTab(self.bid);

	$scope.$watch(BuyerBiddingService.getBuyerBidProgress, function(newVal) {
		self.buyerBidProgress = newVal;
		self.success = "";
	}, true);

	$scope.$watch(BuyerBiddingService.getCompanyUnderUserList,
			function(newVal) {
				self.companyUnderUserList = newVal;
				self.success = "";
			}, true);

	$scope.$watch(SellerQuotationService.getViewCounterHistoryList, function(
			newVal) {
		self.viewCounterHistoryList = newVal;
	}, true);

	$scope.$watch(SellerQuotationService.getCounterList, function(newVal) {
		self.counterList = newVal;
	}, true);

	$scope.$watch(SellerBiddingService.getData, function(newVal) {
		self.dataList = newVal;
		self.success = "";
	}, true);

	$scope.$watch(BuyerBiddingService.getBuyerBidTab, function(newVal) {
		self.buyerBidTab = newVal;
		self.success = "";
	}, true);

	$scope.$watch(BuyerQuotationService.getViewQuotationList, function(newVal) {
		self.viewQuotationList = newVal;
		self.success = "";
	}, true);

	$scope.$watch(BuyerQuotationService.getViewRankList, function(newVal) {
		self.viewRankList = newVal;
		self.success = "";
	}, true);

	$scope.$watch(BuyerQuotationService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);

	$scope.$watch(SellerBiddingService.getFormData, function(newVal) {
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
	$scope.$watch(SellerBiddingService.getSuccessMsg, function(newVal) {
		self.message = newVal;
		UserService.notificationList();
	}, true);

	$scope.$watch(BuyerQuotationService.getSuccessMsg, function(newVal) {
		self.message = newVal;
	}, true);

	self.search = function() {
		self.searchform.operation = "Search";
		SellerBiddingService.search(self.searchform);
		SellerBiddingService.getData();
	};
	self.changeTab = function(status) {
		self.bid.status = status;
		BuyerBiddingService.buyerBidTab(self.bid);
	};

	self.viewCounter = function(bidId) {
		SellerQuotationService.viewCounter(bidId);
	};

	self.checkAssociates = function() {
		window.location = "#/UserDetail";
		location.reload(1);
	};

	self.viewCounterHistory = function(bidId) {
		SellerQuotationService.viewCounterH(bidId);
	};

	self.next = function() {
		self.pageNo++;
		SellerBiddingService.listData(self.pageNo, self.pageSize);
		SellerBiddingService.getData();
	};

	self.previous = function() {
		self.pageNo--;
		SellerBiddingService.listData(self.pageNo, self.pageSize);
		SellerBiddingService.getData();
	};

	self.go = function() {
		self.pageNo;
		SellerBiddingService.listData(self.pageNo, self.pageSize);
		SellerBiddingService.getData();
	};

	self.sellerClick = function() {
		window.location = "#/SellerQuotation";
		location.reload(1);
	};

	self.accept = function(bidding) {
		self.form = {};
		self.success = "";
		self.form.bidId = bidding.bidId;
		self.form.inviteStatus = bidding.inviteStatus;
		self.form.invitedUserId = bidding.invitedUserId;
		BuyerBiddingService.acceptInvitation(self.form);
	}
	self.approveQuote = function(bids) {

		console.log(bids[7], 'here  is bids')
		self.form = {};
		self.success = "";
		self.form.bidId = bids[7];
		self.form.inviteGroupId = bids[1];
		self.form.isQuote = bids[9];
		self.form.approveUserId = bids[10];

		BuyerBiddingService.approveQuote(self.form);
	}
	self.reject = function(bidding) {
		self.form = {};
		self.success = "";
		self.form.bidId = bidding.bidId;
		self.form.inviteStatus = bidding.inviteStatus;
		self.form.invitedUserId = bidding.invitedUserId;
		BuyerBiddingService.rejectInvitation(self.form);
	}

	self.viewQuotation = function(productId, cityId, stateId, packagingId) {
		self.success = "";
		BuyerQuotationService.viewQoutation(productId, cityId, stateId,
				packagingId);
		BuyerQuotationService.getData();
	};

	self.viewRank = function(productId) {
		self.success = "";
		BuyerQuotationService.viewRank(productId);
		BuyerQuotationService.getData();
	};

	self.resetForm = function() {
		self.form = {};
		self.message = "";
		self.success = "";
		self.progress = "";
	};

	self.addQuotation = function() {
		BuyerQuotationService.addData(self.form, self.pageNo, self.pageSize);
		SellerBiddingService.getSuccessMsg();
		self.form.status = "OPEN";
		a = "KG";

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

	self.companyUnder = function(bidId, inviteGroupId) {
		self.resetForm();
		BuyerBiddingService.companyUnderUserList(bidId, inviteGroupId);
	};

});
*/