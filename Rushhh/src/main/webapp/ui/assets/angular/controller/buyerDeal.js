mainApp.controller("BuyerDealController", function($http, $scope, $routeParams,
		$filter, BuyerBiddingService, BuyerQuotationService) {
	var self = this;
	self.pageNo = 1;
	self.pageSize = 5;
	self.form = {};
	self.searchform = {};
	self.message = "";
	self.success = "";

	BuyerBiddingService.buyerDeals(self.pageNo, self.pageSize);

	$scope.$watch(BuyerBiddingService.getBuyerDeals, function(newVal) {
		self.dataList = newVal;
		self.success = "";
	}, true);

	$scope.$watch(BuyerBiddingService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);

});