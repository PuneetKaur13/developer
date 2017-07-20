mainApp
		.controller("HomeController",
				function($http, $scope, $timeout, $filter, BuyerBiddingService,
						SellerBiddingService, UserService, $location,
						ProductService, NgMap, HomeService) {
					var self = this;
					self.searchform = {};
					self.form = {};
					self.bid = {};
					self.sell = {};
					self.bidOpen = {};
					self.type = {};
					self.min = {};
					self.sell.status = "ACTIVE";
					self.bid.status = "ACTIVE";
					self.bidOpen.status = "ABOUT TO OPEN";

					self.min.startDate = $filter('date')(
							new Date().setDate(new Date().getDate() - 1),
							"yyyy-MM-dd");
					self.valid = {};

					self.valid.enddate = $filter('date')(
							new Date().setDate(new Date().getDate() + 6),
							"yyyy-MM-dd");

					self.flag = true;
					self.message = "";
					self.success = "";

					ProductService.productList();

					HomeService.buyerBiddigList();

					HomeService.sellerBiddigList();

					// BuyerBiddingService.buyerBids(null);

					// SellerBiddingService.sellerOffer(null);

					// BuyerBiddingService.buyerBidsOpen(null);

					SellerBiddingService.stateList();

					SellerBiddingService.cityList();

					HomeService.getSessionProduct();
					BuyerBiddingService.ManageProduct();

					$scope.$watch(SellerBiddingService.getPackagingList,
							function(newVal) {
								self.packagingList = newVal;
							}, true);

					$scope.$watch(BuyerBiddingService.getManageProductList,
							function(newVal) {
								self.manageProductList = newVal;
								self.success = "";
							}, true);

					$scope.$watch(ProductService.getProductList, function(
							newVal) {
						self.productList = newVal;
					}, true);
					$scope.$watch(SellerBiddingService.getViewChartList,
							function(newVal) {
								self.viewChartList = newVal;
								self.success = "";
							}, true);

					$scope.$watch(SellerBiddingService.getViewCityChartList,
							function(newVal) {
								self.viewCityChartList = newVal;
								self.success = "";
							}, true);

					$scope.$watch(HomeService.getSessionProductDTO, function(
							newVal) {
						self.sessionProduct = newVal;
						if (self.sessionProduct != "") {
							var product = self.sessionProduct.dto;
							self.mapProduct = product.id;
							SellerBiddingService.viewChart(product.id);
						}
					}, true);

					$scope.$watch(BuyerBiddingService.getBuyerBids, function(
							newVal) {
						self.buyerBids = newVal;
						self.success = "";
					}, true);
					$scope.$watch(BuyerBiddingService.getBuyerBidsOpen,
							function(newVal) {
								self.buyerBidsOpen = newVal;
								self.success = "";
							}, true);

					$scope.$watch(BuyerBiddingService.getBuyerBidProgress,
							function(newVal) {
								self.buyerBidProgress = newVal;
								self.success = "";
							}, true);

					$scope.$watch(BuyerBiddingService.getBuyerBidOpenProgress,
							function(newVal) {
								self.buyerBidOpenProgress = newVal;
								self.success = "";
							}, true);

					self.initMap = function(mapId) {
						self.map = NgMap.initMap('map');
						self.flag = !self.flag;
					}

					$scope.$watch(HomeService.getSellerBiddigList, function(
							newVal) {
						self.sellerList = newVal;
						var values = self.sellerList.list;
						$scope.accounts = self.sellerList.list;
						angular.forEach($scope.accounts,
								function(value, index) {

								})

						self.success = "";
					}, true);

					$scope.$watch(HomeService.getBuyerBiddigList, function(
							newVal) {
						self.buyerList = newVal;
						self.success = "";
					}, true);

					$scope.$watch(SellerBiddingService.getSellerOffer,
							function(newVal) {
								self.sellerOffers = newVal;
								self.success = "";
							}, true);

					$scope.$watch(SellerBiddingService.getSellerOfferProgress,
							function(newVal) {
								self.sellerOfferProgress = newVal;
							}, true);

					$scope.$watch(BuyerBiddingService.getSuccessMsg, function(
							newVal) {
						self.message = newVal;
					}, true);

					self.changeSessionProduct = function(productId) {
						self.sell.productId = productId;
						self.bid.productId = productId;
						self.bidOpen.productId = productId;
						SellerBiddingService.sellerOffer(self.sell);
						BuyerBiddingService.buyerBids(self.bid);
						BuyerBiddingService.buyerBidsOpen(self.bidOpen);
						window.location.reload(true);

					};

					self.changeBids = function(status) {
						BuyerBiddingService.buyerBids(self.bid);
					};

					self.changeBidsOpen = function() {
						BuyerBiddingService.buyerBidsOpen(self.bidOpen);
					};

					self.changeSells = function() {
						SellerBiddingService.sellerOffer(self.sell);
					};

					self.changeChart = function(type) {
						SellerBiddingService.sellerOffer(self.sell);
					};

					$scope.totalQuantity = 0;
					self.showMapData = function(event, id, data) {
						// self.map.showInfoWindow(id, this);
						self.map.showInfoWindow(id, this);

						$scope.accounts = self.sellerList.list;
						var sum = 0;
						angular.forEach($scope.accounts,
								function(value, index) {
									if (value.cityId == data.cityId) {
										sum = sum + value.quantity;
									}
								})

						// data.quantity = sum;
						$scope.totalQuantity = sum;
						self.mapData = data;

					};
					// Show City Data on Map
					$scope.$watch(HomeService.getSellerByCityList, function(
							newVal) {
						self.listByCity = newVal;

					}, true);

					$scope.$watch(HomeService.getBuyerByCityList, function(
							newVal) {
						self.listByCity = newVal;
					}, true);

					self.showSellerByCity = function(city) {
						HomeService.showSellerByCity(city);
					};

					self.showBuyerByCity = function(city) {
						HomeService.showBuyerByCity(city);
					};

					self.resetForm = function() {
						self.form = {};
						self.message = "";
						self.success = "";
						self.progress = "";
					};
					self.viewChart = function(productId) {
						self.resetForm();
						SellerBiddingService.viewChart(productId);
						SellerBiddingService.getData();
					};

					self.viewCityChart = function(productId, stateId) {
						self.resetForm();
						SellerBiddingService.viewCityChart(productId, stateId);
						// SellerBiddingService.getData();

					};
					// Login

					$scope.$watch(UserService.getAuthMsg, function(newVal) {
						var msg = newVal;
						if (msg != '') {
							if (msg.success) {

								window.location = "#/Dashboard";
								location.reload(1);
							} else {

								self.progress = "Invalid Login Id / Password";
							}
						}
					}, true);

					$scope.$watch(UserService.getProgress, function(newVal) {
						self.progress = newVal;
					}, true);

					$scope.$watch(UserService.getSuccessMsg, function(newVal) {
						self.message = newVal.message;
						self.success = newVal.success;
					}, true);

					self.login = function() {
						UserService.authenticate(self.form);
						UserService.getSuccessMsg();
					};

					self.forget = function() {
						UserService.forgetPassword(self.form);
						UserService.getSuccessMsg();
					};

					self.reg = function() {

						window.location = "#/UserRegistration";
						location.reload(1);

					};

					self.isNull = function(val) {
						if (val == null) {
							return 0;
						} else {
							return val;
						}
					};
					// Placed Offer

					$scope.$watch(SellerBiddingService.getCityStateList,
							function(newVal) {
								self.cityStateList = newVal;
							}, true);
					$scope.$watch(SellerBiddingService.getStateList, function(
							newVal) {
						self.stateList = newVal;
					}, true);

					$scope.$watch(SellerBiddingService.getCityList, function(
							newVal) {
						self.cityList = newVal;
					}, true);

					self.findByStateId = function(stateId) {
						SellerBiddingService.findCityState(stateId);
					};
					self.findByProdctId = function(productId) {
						SellerBiddingService.findPackaging(productId);
					};

					self.placeOffer = function() {
						self.resetForm();
						self.form.unit = "MT";
					};

					self.addOffer = function() {
						if (self.form.id != null && self.form.id > 0) {
							SellerBiddingService.updateData(self.form,
									self.pageNo, self.pageSize);
							SellerBiddingService.getSuccessMsg();
						} else {
							self.form.id = 0;
							self.form.status = "ACTIVE";
							self.form.type = "SELL";
							SellerBiddingService.addData(self.form,
									self.pageNo, self.pageSize);

							SellerBiddingService.getSuccessMsg();
						}
					};
					$scope.$watch(SellerBiddingService.getProgress, function(
							newVal) {
						self.progress = newVal;
					}, true);

					$scope.$watch(SellerBiddingService.getSuccessMsg, function(
							newVal) {
						self.message = newVal;
					}, true);

					// Order Now Call For Bid
					self.placeOrder = function() {
						self.resetForm();
						self.form.unit = "MT";
					};

					self.addOrder = function() {
						if (self.form.id != null && self.form.id > 0) {
							BuyerBiddingService.updateData(self.form,
									self.pageNo, self.pageSize);
							BuyerBiddingService.getSuccessMsg();
						} else {
							self.form.id = 0;
							self.form.status = "ACTIVE";
							self.form.type = "SELL";
							BuyerBiddingService.addData(self.form, self.pageNo,
									self.pageSize);

							BuyerBiddingService.getSuccessMsg();
						}
					};
					$scope.$watch(BuyerBiddingService.getProgress, function(
							newVal) {
						self.progress = newVal;
					}, true);

					$scope.$watch(BuyerBiddingService.getSuccessMsg, function(
							newVal) {
						self.message = newVal;
					}, true);

				});