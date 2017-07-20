mainApp.controller("SellerDealController", function($http, $scope,
		SellerBiddingService) {
	var self = this;
	self.pageNo = 1;
	self.pageSize = 5;
	self.form = {};
	self.searchform = {};
	self.message = "";
	self.success = "";

	SellerBiddingService.sellerDeals(self.pageNo, self.pageSize);

	$scope.$watch(SellerBiddingService.getSellerDeals, function(newVal) {
		self.dataList = newVal;
		self.success = "";
	}, true);

	$scope.$watch(SellerBiddingService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);

});