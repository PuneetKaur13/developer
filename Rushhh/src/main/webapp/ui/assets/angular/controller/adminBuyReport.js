mainApp.controller("AdminBuyReportController", function($scope, $filter,$http,
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
		
			var subpoint = endpoint + "/search";
			var dt = new Date();
			var dtFormat = dt.getUTCDate() + '_' + (dt.getUTCMonth() + 1) + '_'
					+ dt.getUTCFullYear();
			console.log('asdadasasdadsasdasd')
				subpoint = "PDFA/downloadPDFBuyerAdmin";
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
					a.download = 'Buyer_Report' + dtFormat + '.pdf';
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
	
/*	self.searchReport = function() {
		var reportType="PDF"
			BuyerBiddingService.searchByValue(self.searchData, reportType,
				self.pageNo, self.pageSize);
		BuyerBiddingService.getData();
	};*/

});
