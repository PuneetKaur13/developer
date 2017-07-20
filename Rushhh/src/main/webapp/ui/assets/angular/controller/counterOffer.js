mainApp.controller("CounterOfferCountroller", function($http, $scope, $routeParams,
		CounterOfferService) {
	var self = this;
	self.pageNo = 1;
	self.pageSize = 5;
	self.form = {};
	self.message = "";
	self.success = "";

	CounterOfferService.listData(self.pageNo, self.pageSize);

	if ($routeParams.id != null && $routeParams.id > 0) {
		$('#mainModalLabel').text("Update CounterOffer");
		CounterOfferService.get($routeParams.id);
	}

	$scope.$watch(CounterOfferService.getData, function(newVal) {
		self.dataList = newVal;
		self.success = "";
	}, true);

	$scope.$watch(CounterOfferService.getFormData, function(newVal) {
		self.resetForm();
		self.form = newVal.form;
		self.success = "";
	}, true);

	$scope.$watch(CounterOfferService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);

	$scope.$watch(CounterOfferService.getSuccessMsg, function(newVal) {
		self.message = newVal;
	}, true);

	self.next = function() {
		self.pageNo++;
		CounterOfferService.listData(self.pageNo, self.pageSize);
		CounterOfferService.getData();
	};

	self.previous = function() {
		self.pageNo--;
		CounterOfferService.listData(self.pageNo, self.pageSize);
		CounterOfferService.getData();
	};

	self.go = function() {
		self.pageNo;
		CounterOfferService.listData(self.pageNo, self.pageSize);
		CounterOfferService.getData();
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
			CounterOfferService.updateData(self.form, self.pageNo, self.pageSize);
			CounterOfferService.getSuccessMsg();
		} else {
			self.form.id = 0;
			CounterOfferService.addData(self.form, self.pageNo, self.pageSize);
			CounterOfferService.getSuccessMsg();
		}
	};

	self.updateModal = function(role) {

	};

	self.checkedData = {
		del : []
	};

	self.deleteData = function() {
		if (self.checkedData.del.length > 0) {
			CounterOfferService.deleteData(self.checkedData.del + "", self.pageNo,
					self.pageSize);
			self.checkedData.del = [];
		} else {
			self.progress = "Please Check the Checkbox.";
		}
	};
});