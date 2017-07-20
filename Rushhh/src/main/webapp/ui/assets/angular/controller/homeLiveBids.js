mainApp.controller("HomeLiveBidController", function($http, $scope, $routeParams,
		$interval, $filter, BuyerBiddingService, BuyerQuotationService,
		CounterOfferService, AdminProductPackagingService) {
	var self = this;
	self.pageNo = 1;
	self.pageSize = 5;
	self.form = {};
	self.searchform = {};
	self.message = "";
	self.success = "";

	BuyerQuotationService.homeLiveList(self.pageNo, self.pageSize);
	$interval(function() {
		BuyerQuotationService.homeLiveList(self.pageNo, self.pageSize);
	}, 150000);

	$scope.$watch(BuyerQuotationService.getHomeLiveList, function(newVal) {
		self.homeLiveList = newVal;
		self.success = "";
	}, true);


	$scope.$watch(BuyerQuotationService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);

	$scope.$watch(BuyerQuotationService.getSuccessMsg, function(newVal) {
		self.message = newVal;
	}, true);
});