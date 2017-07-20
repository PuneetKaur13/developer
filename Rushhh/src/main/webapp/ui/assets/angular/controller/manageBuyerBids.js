mainApp.controller("ManageBuyerBidsController", function($scope,$filter,
		ControllerService, BaseService,BuyerBiddingService,PreferredSupplierService) {
	var self = this;
	self.min = {};
	self.min.bidDate = $filter('date')(
			new Date().setDate(new Date().getDate() - 1), "dd-MM-yyyy");
	self.min.startDate = $filter('date')(
			new Date().setDate(new Date().getDate()), "dd-MM-yyyy");
	self.max = {};
	self.exp = {};
	self.exp.expectedDeliveryDate = $filter('date')(
			new Date().setDate(new Date().getDate() + 8), "dd-MM-yyy");

	self.valid = {};

	self.valid.enddate = $filter('date')(
			new Date().setDate(new Date().getDate() + 6), "dd-MM-yyyy");


	// Service endpoint
	self.endPoint = "/OCBS/rest/BuyerBidding";

	// Initialize controller
	ControllerService.setEndPoint(self.endPoint);

	// Get controller objects
	ControllerService.getCtlObjects(self);

	// Search Object contains filter values of list page
	self.searchData = ControllerService.getSearchObject({});

	// Initialize form
	self.resetForm = function() {
		ControllerService.resetForm(self, {
			"id" : "",
			"status" : "ABOUT TO OPEN"
			
				
		});
	},
	$scope.$watch(BuyerBiddingService.getFormData, function(newVal) {
		self.resetForm();
		self.form = newVal.form;
		if (self.form != undefined) {
			self.min.startDate = $filter('date')(self.form.startDate,
					"yyyy-MM-dd");
			self.form.startDate = $filter('date')(self.form.startDate,
					"yyyy-MM-dd");
			self.form.enddate = $filter('date')
					(self.form.enddate, "yyyy-MM-dd");
			self.form.expectedDeliveryDate = $filter('date')(
					self.form.expectedDeliveryDate, "yyyy-MM-dd");
		}
		self.success = "";
	}, true);
	
	
	self.display = function() {

	};
	// Initialize form
	self.resetForm();
	// Get first page of list
	self.search();

	self.display = function(id) {
		self.resetForm();
		self.form.unit = "MT";
		$('#mainModalLabel').text("Place Requirement");
		self.form.unit = "MT";
		self.form.isVisit = true;
		self.form.isRequest = false;
		self.form.checkValue = "NO";
		self.form.checkValueAllSellers = "noAll"
		self.form.startDate=self.min.startDate;
		self.form.enddate=self.valid.enddate;
		if (id > 0) {
			BaseService.get(id).then(function(data) {
				self.form = data.form;
				self.message = null;
				self.findCity(self.form.stateId);
				self.findPackaging(self.form.productId);
				self.findByUserProduct (self.form.productId);
				self.findByUserFavouriteProduct(self.form.productId);
			
			});
		}
	},

	self.packagingList = [];
	self.findPackaging = function(productId) {
		if (productId != undefined) {
			var endPoint = "/OCBS/rest/AdminProductPackaging/findByProductId/"
					+ productId;
			BaseService.callEndPoint(endPoint, null).then(function(data) {
				self.packagingList = data.list;
			});
		} else {
			self.packagingList = [];
		}
	},

	self.cityList = [];
	self.findCity = function(stateId) {
		if (stateId != undefined) {
			var endPoint = "/OCBS/rest/City/findByStateId/" + stateId;
			BaseService.callEndPoint(endPoint, null).then(function(data) {
				self.cityList = data.list;
			});
		} else {
			self.cityList = [];
		}
	};
	
	
	self.userProductList = [];

	
	self.findByUserProduct = function(productId) {
		
		if (productId != undefined) {
			var endPoint =  "/OCBS/rest/AdminProductPackaging/findByUserProductBuyer/"+productId;
			BaseService.callEndPoint(endPoint, null).then(function(data) {
				self.userProductList = data.list;
			});
		} else {
			self.userProductList = [];
		}
	};
	
	
	
	self.favouriteProductList = [];

	
	self.findByUserFavouriteProduct = function(productId) {
		
		if (productId != undefined) {
			var endPoint = "/OCBS/rest/AdminProductPackaging/findByUserProductFavourite/"+productId;
			BaseService.callEndPoint(endPoint, null).then(function(data) {
				self.favouriteProductList = data.list;
			});
		} else {
			self.favouriteProductList = [];
		}
	},
	
	self.viewInformationList=[];

	self.viewInformation = function(id) {
		self.resetForm();
		if (id != undefined) {
			var endPoint = "/OCBS/rest/BuyerBidding/viewInformation/"+id;
			BaseService.callEndPoint(endPoint, null).then(function(data) {
				self.viewInformationList = data.list;
			});
		} else {
			self.viewInformationList = [];
		}
	},
	
	self.viewAcceptUserList = [];
	
	self.viewAcceptUser = function(bidId) {
		self.resetForm();
	
		if (bidId != undefined) {
			var endPoint = "/OCBS/rest/PreferredSupllier/viewUser/"+bidId;
			BaseService.callEndPoint(endPoint, null).then(function(data) {
				self.viewAcceptUserList = data.list;
			});
		} else {
			self.viewAcceptUserList = [];
		}
	};
});




/*mainApp.controller("ManageBuyerBidsController", function($http, $scope,
		$routeParams, $filter, BuyerBiddingService,PreferredSupplierService) {
	var self = this;
	self.pageNo = 1;
	self.pageSize = 5;
	self.form = {};
	self.bid = {};
	self.bid.status = "ACTIVE";
	self.searchform = {};
	self.message = "";
	self.success = "";

	BuyerBiddingService.buyerBids(self.bid);
	BuyerBiddingService.listAll(self.pageNo, self.pageSize);
	BuyerBiddingService.productList();
	BuyerBiddingService.userList();
	BuyerBiddingService.stateList();
	BuyerBiddingService.cityList();

	self.edit = function(id) {
		$('#mainModalLabel').text("Update Buyer Bids");
		BuyerBiddingService.get(id);
	}

	$scope.$watch(BuyerBiddingService.getPackagingList, function(newVal) {
		self.packagingList = newVal;
	}, true);

	$scope.$watch(BuyerBiddingService.getData, function(newVal) {
		self.dataList = newVal;
		self.success = "";
	}, true);

	$scope.$watch(BuyerBiddingService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);

	$scope.$watch(BuyerBiddingService.getProductList, function(newVal) {
		self.productList = newVal;
	}, true);
	$scope.$watch(BuyerBiddingService.getStateList, function(newVal) {
		self.stateList = newVal;
	}, true);

	$scope.$watch(BuyerBiddingService.getCityList, function(newVal) {
		self.cityList = newVal;
	}, true);
	$scope.$watch(BuyerBiddingService.getUserList, function(newVal) {
		self.userList = newVal;
	}, true);
	
	$scope.$watch(PreferredSupplierService.getViewAcceptUserList, function(
			newVal) {
		self.viewAcceptUserList = newVal;
		self.success = "";
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

			console.log(self.productList);
			if (self.productList != undefined) {
				angular.forEach(self.productList.list, function(value, key) {
					console.log(value.id + " " + self.form.productId);
					if (value.id == self.form.productId) {
						console.log("in if");
						self.selectedOption = value;
						BuyerBiddingService.findPackaging(value.id);
					}
				});
			}

			if (self.stateList != undefined) {
				angular.forEach(self.stateList.list, function(value, key) {
					if (value.id == self.form.stateId) {
						self.selectedOptionState = value;
						BuyerBiddingService.findCityState(value.id);
					}
				});
			}

			if (self.cityList != undefined) {
				angular.forEach(self.cityList.list, function(value, key) {
					if (value.id == self.form.cityId) {
						self.selectedOptionCity = value;
					}
				});
			}
		}
		self.success = "";
	}, true);

	$scope.$watch(BuyerBiddingService.getCityStateList, function(newVal) {
		self.cityStateList = newVal;
	}, true);

	$scope.$watch(BuyerBiddingService.getSuccessMsg, function(newVal) {
		self.message = newVal;
	}, true);

	self.findByProdctId = function(product) {
		BuyerBiddingService.findPackaging(product.id);
	};

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
		BuyerBiddingService.updateBySuperUser(self.form, self.pageNo,
				self.pageSize);
		BuyerBiddingService.getSuccessMsg();
	};

	$scope.$watch(BuyerBiddingService.getBuyerBids, function(newVal) {
		self.buyerBids = newVal;
		self.success = "";
	}, true);

	$scope.$watch(BuyerBiddingService.getBuyerBidProgress, function(newVal) {
		self.buyerBidProgress = newVal;
		self.success = "";
	}, true);
	
	self.viewAcceptUser = function(bidId) {
		self.resetForm();
		PreferredSupplierService.viewAcceptUser(bidId);
	};
	
	self.changeBids = function(status) {
		self.bid.status = status;
		BuyerBiddingService.buyerBids(self.bid);
		self.activeTab = self.dataList.paneId;
	};

});*/