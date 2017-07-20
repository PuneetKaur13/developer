mainApp.controller("UserBuyReportController", function($scope, $filter,$http,
		ControllerService, BaseService, BuyerBiddingService,SellerBiddingService) {
	var self = this;

	self.min = {};
	self.min.startDate = $filter('date')(
			new Date().setDate(new Date().getDate()), "dd-MM-yyyy");
	self.valid = {};

	self.valid.enddate = $filter('date')(
			new Date().setDate(new Date().getDate() + 6), "dd-MM-yyyy");
	
	SellerBiddingService.stateList();
	SellerBiddingService.cityList();
	SellerBiddingService.productList();
	
	


	// Service endpoint
	self.endPoint = "/OCBS/rest/BuyerBidding";

	// Initialize controller
	ControllerService.setEndPoint(self.endPoint);

	// Get controller objects
	ControllerService.getCtlObjects(self);

	// Search Object contains filter values of list page
	self.searchData = ControllerService.getSearchObject({
		"packaging":"",
		"productName":""
	});

	// Initialize form
	self.resetForm = function() {
		ControllerService.resetForm(self, {
			"id":""
				
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
	

	self.display = function(id) {
		self.resetForm();
		self.form.unit = "MT";
		$('#mainModalLabel').text("Place Offer");
		self.form.startDate=self.min.startDate;
		self.form.enddate=self.valid.enddate;
		if (id > 0) {
			BaseService.get(id).then(function(data) {
				self.form = data.form;
				self.message = null;
				self.findCity(self.form.stateId);
				self.findPackaging(self.form.productId);
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

	
	self.searchReport = function() {
		self.searchMessage = "Please Wait..";
		var reportType="PDF";
			var reportType = self.searchData.reportType;
			var form = self.searchData;
			var endpoint = "/OCBS/rest/BuyerBidding";
			subpoint="PDF/downloadPDFBuyer";
			var dt = new Date();
			var dtFormat = dt.getUTCDate() + '_' + (dt.getUTCMonth() + 1) + '_'
					+ dt.getUTCFullYear();
		
				subpoint = "PDFSeller/downloadPDFBuyer";
				$http({
					method : 'POST',
					url : subpoint,
					data : form,
					responseType : 'arraybuffer'
				}).success(function(data, status, headers, config) {
					var file = new Blob([ data ], {
						type : 'application/pdf'
					});
					var fileURL = URL.createObjectURL(file);
					var a = document.createElement('a');
					a.href = fileURL;
					a.target = '_blank';
					a.download = 'Seller_Report' + dtFormat + '.pdf';
					document.body.appendChild(a);
					a.click();
				});
				self.searchMessage = null;
			BaseService.find(self.searchData).then(function(data) {
				self.dataList = data;
				self.searchMessage = null;
			});
		};
	
	
	self.resetForm();
	// Get first page of list
	self.search();
	
	self.searchReport = function() {
		var reportType="PDF"
			BuyerBiddingService.searchByValue(self.searchData, reportType,
				self.pageNo, self.pageSize);
		BuyerBiddingService.getData();
	};

});




/*mainApp.controller("UserBuyReportController", function($http, $scope,
		$routeParams, $filter, BuyerBiddingService, PreferredSupplierService) {
	var self = this;
	self.pageNo = 1;
	self.pageSize = 5;
	self.form = {};
	self.message = "";
	self.success = "";

	BuyerBiddingService.userBuyReportList();
	BuyerBiddingService.stateList();
	BuyerBiddingService.cityList();
	BuyerBiddingService.productList();
	if ($routeParams.id != null && $routeParams.id > 0) {
		$('#mainModalLabel').text("Update Message");
		BuyerBiddingService.get($routeParams.id);
	}
	$scope.$watch(BuyerBiddingService.getProductList, function(newVal) {
		self.productList = newVal;
	}, true);
	$scope.$watch(PreferredSupplierService.getViewAcceptUserList, function(
			newVal) {
		self.viewAcceptUserList = newVal;
		self.success = "";
	}, true);

	$scope.$watch(BuyerBiddingService.getStateList, function(newVal) {
		self.stateList = newVal;
	}, true);

	$scope.$watch(BuyerBiddingService.getCityList, function(newVal) {
		self.cityList = newVal;
	}, true);

	$scope.$watch(BuyerBiddingService.getUserBuyReportList, function(newVal) {
		self.userBuyReportList = newVal;
		self.success = "";
	}, true);

	$scope.$watch(BuyerBiddingService.getViewInformationList, function(newVal) {
		self.viewInformationList = newVal;
	}, true);

	$scope.$watch(BuyerBiddingService.getFormData, function(newVal) {
		self.resetForm();
		self.form = newVal.form;
		self.success = "";
	}, true);

	$scope.$watch(BuyerBiddingService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);

	$scope.$watch(BuyerBiddingService.getFormData, function(newVal) {
		self.resetForm();
		self.form = newVal.form;
		if (self.form != undefined) {
			self.form.startDate = $filter('date')(self.form.startDate,
					"yyyy-MM-dd");
			self.form.enddate = $filter('date')
					(self.form.enddate, "yyyy-MM-dd");
		}
		self.success = "";
	}, true);

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

	$scope.$watch(BuyerBiddingService.getSuccessMsg, function(newVal) {
		self.message = newVal;
	}, true);

	self.next = function() {
		self.pageNo++;
		BuyerBiddingService.listData(self.pageNo, self.pageSize);
		BuyerBiddingService.getData();
	};

	self.viewAcceptUser = function(bidId) {
		self.resetForm();
		PreferredSupplierService.viewAcceptUser(bidId);
	};
	self.previous = function() {
		self.pageNo--;
		BuyerBiddingService.listData(self.pageNo, self.pageSize);
		BuyerBiddingService.getData();
	};
	self.viewInformation = function(id) {
		self.resetForm();
		BuyerBiddingService.viewInformationList(id);
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
		$('#mainModalLabel').text("Add Message");
	};

	self.addData = function() {
		if (self.form.id != null && self.form.id > 0) {
			BuyerBiddingService.updateData(self.form, self.pageNo,
					self.pageSize);
			BuyerBiddingService.getSuccessMsg();
		} else {
			self.form.id = 0;
			BuyerBiddingService.addData(self.form, self.pageNo, self.pageSize);
			BuyerBiddingService.getSuccessMsg();
		}
	};
	self.search = function() {
		BuyerBiddingService.searchBox(self.branch, self.pageNo, self.pageSize);
		BuyerBiddingService.getUserBuyReportList();
	};

	self.updateModal = function(role) {

	};

	self.convertForm = function(data) {
		self.form = {};
		self.form.id = data.id;
		self.form.type = data.type;
		self.form.title = data.title;
		self.form.message = data.message;
		return self.form;
	};

	self.checkedData = {
		del : []
	};
	
	// UserBuyReport
	self.searchReport = function() {
		var reportType="PDF"
		BuyerBiddingService.searchByValue(self.branch, reportType,
				self.pageNo, self.pageSize);
		BuyerBiddingService.getData();
	},

	self.deleteData = function() {
		if (self.checkedData.del.length > 0) {
			BuyerBiddingService.deleteData(self.checkedData.del + "",
					self.pageNo, self.pageSize);
			self.checkedData.del = [];
		} else {
			self.progress = "Please Check the Checkbox.";
		}
	};
});*/