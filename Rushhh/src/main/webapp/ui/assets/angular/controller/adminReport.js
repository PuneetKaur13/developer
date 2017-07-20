mainApp.controller("AdminReportController", function($http, $scope,
		$routeParams, SellerBiddingService) {
	var self = this;
	self.pageNo = 1;
	self.pageSize = 5;
	self.form = {};
	self.message = "";
	self.success = "";

	SellerBiddingService.statiSticsList();
	SellerBiddingService.productListReport();
	SellerBiddingService.companyList();
	SellerBiddingService.stateList();
	SellerBiddingService.cityList();
	if ($routeParams.id != null && $routeParams.id > 0) {
		$('#mainModalLabel').text("Update Message");
		SellerBiddingService.get($routeParams.id);
	}
	

	$scope.$watch(SellerBiddingService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);
	
	$scope.$watch(SellerBiddingService.getStateList, function(newVal) {
		self.stateList = newVal;
	}, true);
	
	$scope.$watch(SellerBiddingService.getCityList, function(newVal) {
		self.cityList = newVal;
	}, true);
	
	$scope.$watch(SellerBiddingService.getProductListReport, function(newVal) {
		self.productListReport = newVal;
	}, true);
	
	$scope.$watch(SellerBiddingService.getCompanyList, function(newVal) {
		self.companyList = newVal;
	}, true);

	$scope.$watch(SellerBiddingService.getStatiSticsList, function(newVal) {
		
		self.statiSticsList = newVal;
		self.success = "";
	}, true);

	$scope.$watch(SellerBiddingService.getSuccessMsg, function(newVal) {
		self.message = newVal;
	}, true);

	self.next = function() {
		self.pageNo++;
		SellerBiddingService.listData(self.pageNo, self.pageSize);
		SellerBiddingService.getData();
	};
	
	self.search = function() {
		console.log('inside js ');
		SellerBiddingService.searchBox(self.branch,self.pageNo, self.pageSize);
		SellerBiddingService.getStatiSticsList();
	};

	self.previous = function() {
		self.pageNo--;
		SellerBiddingService.listData(self.pageNo, self.pageSize);
		SellerBiddingService.getData();
	};

	$scope.ToJavaScriptDateTime = function(value) {
		var updateDate = '';
		if (value != '') {
			var dt = new Date(parseFloat(value));
			updateDate = dt.getUTCDate() + '/' + (dt.getUTCMonth() + 1) + '/'
					+ dt.getUTCFullYear() + ' ' + dt.getHours() + ':'
					+ dt.getMinutes() + ':' + dt.getSeconds();
			if (updateDate == '1/1/1753' || dt.getFullYear() < '1900') {
				updateDate = '';
			}
		}
		return updateDate;
	}

	self.go = function() {
		self.pageNo;
		SellerBiddingService.listData(self.pageNo, self.pageSize);
		SellerBiddingService.getData();
	};

	self.resetForm = function() {
		self.form = {};
		self.message = "";
		self.success = "";
		self.progress = "";
	};

});