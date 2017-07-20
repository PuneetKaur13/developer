mainApp.controller("BuyerBiddingController", function($scope,$filter,
		ControllerService, BaseService,BuyerBiddingService) {
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
	self.endPoint = "/Rushhh/rest/BuyerBidding";

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
			var endPoint = "/Rushhh/rest/AdminProductPackaging/findByProductId/"
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
			var endPoint =  "/Rushhh/rest/AdminProductPackaging/findByUserProductBuyer/"+productId;
			BaseService.callEndPoint(endPoint, null).then(function(data) {
				self.userProductList = data.list;
				
				
				$scope.SelectAll = function(isCheckAll) {
					var list = [];
					angular.forEach(self.userProductList, function(dto) {
						dto.SELECTED = isCheckAll;
						list.push(dto);
						
						
					});
					self.userProductList =data.list;
				}
				
			});
		} else {
			self.userProductList = [];
		}
	};
	

	
	self.favouriteProductList = [];

	
	self.findByUserFavouriteProduct = function(productId) {
		
		if (productId != undefined) {
			var endPoint = "/Rushhh/rest/AdminProductPackaging/findByUserProductFavourite/"+productId;
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
			var endPoint = "/Rushhh/rest/BuyerBidding/viewInformation/"+id;
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
			var endPoint = "/Rushhh/rest/PreferredSupllier/viewUser/"+bidId;
			BaseService.callEndPoint(endPoint, null).then(function(data) {
				self.viewAcceptUserList = data.list;
			});
		} else {
			self.viewAcceptUserList = [];
		}
	};

	
});

