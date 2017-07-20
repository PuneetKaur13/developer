mainApp.factory("SellerQuotationService", function($http) {
	list = [];
	viewQuotationList = [];
	viewVisitorList = [];
	viewHistoryList = [];
	counterList = [];
	productList = [];
	userList = [];
	formData = [];
	progress = "";
	successMsg = "";
	viewCounterHistoryList=[];

	var endpoint = "/OCBS/rest/SellerQuotation";

	return {
		getData : function() {
			return list;
		},
		
		getViewCounterHistoryList : function() {
			return viewCounterHistoryList;
		},

		getSuccessMsg : function() {
			return successMsg;
		},
		getFormData : function() {
			return formData;
		},

		getCounterList : function() {
			return counterList;
		},

		getProductList : function() {
			return productList;
		},

		getUserList : function() {
			return userList;
		},

		getViewQuotationList : function() {
			return viewQuotationList;
		},
		getViewVisitorList : function() {
			return viewVisitorList;
		},
		getViewHistoryList : function() {
			return viewHistoryList;
		},
		getProgress : function() {
			return progress;
		},

		listData : function(pageNo, pageSize) {
			progress = "Please Wait..";
			var subpoint = endpoint + "/search";
			$http({
				method : 'GET',
				url : subpoint,
			}).success(function(data, status, headers, config) {
				list = data;
				if (list.list.length != '' || list.list.length > 0) {
					progress = "";
				} else {
					progress = "No Record Found.";
				}
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},

		
		
		viewCounterHistory : function(quotationId) {
			var subpoint = endpoint + "/viewCounter/" + quotationId;
			$http({
				method : 'GET',
				url : subpoint,
			}).success(function(serverRes, status, headers, config) {
				counterList = serverRes;
			}).error(function(serverRes, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		},
		
		viewQoutation : function(productId) {
			progress = "Please Wait..";
			var subpoint = endpoint + "/viewQoutation/" + productId;
			$http({
				method : 'GET',
				url : subpoint,
			}).success(
					function(data, status, headers, config) {
						progress = "";
						viewQuotationList = data;
						if (viewQuotationList.list.length == ''
								|| viewQuotationList.list.length == 0) {
							successMsg = {
								"success" : false,
								"msg" : "No Record Found."
							};
						}
					}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},
		
		viewCounterH : function(bidId) {
			progress = "Please Wait..";
			var subpoint = endpoint + "/getHistory/" + bidId;
			$http({
				method : 'GET',
				url : subpoint,
			}).success(
					function(data, status, headers, config) {
						progress = "";
						viewCounterHistoryList = data;
						if (viewCounterHistoryList.list.length == ''
								|| viewCounterHistoryList.list.length == 0) {
							successMsg = {
								"success" : false,
								"msg" : "No Record Found."
							};
						}
					}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},
		
		/*viewCounter : function(quotationId) {
			var subpoint = endpoint + "/viewCounter/" + quotationId;
			$http({
				method : 'GET',
				url : subpoint,
			}).success(function(serverRes, status, headers, config) {
				counterList = serverRes;
			}).error(function(serverRes, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		},*/
		
		viewVisitor : function(productId) {
			progress = "Please Wait..";
			var subpoint = endpoint + "/viewVisitor/" + productId;
			$http({
				method : 'GET',
				url : subpoint,
			}).success(
					function(data, status, headers, config) {
						progress = "";
						viewVisitorList = data;
						console.log(list)
						if (viewVisitorList.list.length == ''
								|| viewVisitorList.list.length == 0) {
							successMsg = {
								"success" : false,
								"msg" : "No Record Found."
							};
						}
					}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},
		viewHistory : function(productId, sellerId) {
			progress = "Please Wait..";
			var subpoint = endpoint + "/getHistory/" + productId + "/"
					+ sellerId;
			$http({
				method : 'GET',
				url : subpoint,
			}).success(
					function(data, status, headers, config) {
						progress = "";
						viewHistoryList = data;
						if (viewHistoryList.list.length == ''
								|| viewHistoryList.list.length == 0) {
							successMsg = {
								"success" : false,
								"msg" : "No Record Found."
							};
						}
					}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},

		viewUserQoutation : function(productId) {
			progress = "Please Wait..";
			var subpoint = endpoint + "/viewUserQoutation/" + productId;
			$http({
				method : 'GET',
				url : subpoint,
			}).success(
					function(data, status, headers, config) {
						progress = "";
						viewQuotationList = data;
						if (viewQuotationList.list.length == ''
								|| viewQuotationList.list.length == 0) {
							successMsg = {
								"success" : false,
								"msg" : "No Record Found."
							};
						}
					}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},

		get : function(id) {
			progress = "Please Wait..";
			var subpoint = endpoint + "/edit/" + id;
			$http({
				method : 'GET',
				url : subpoint,
			}).success(function(serverRes, status, headers, config) {
				formData = serverRes;
				if (formData.length != '' || formData.length > 0) {
					progress = "";
				} else {
					progress = "No Record Found..";
				}
			}).error(function(serverRes, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});

		},

		searchByUser : function() {
			progress = "Please Wait..";
			var subpoint = endpoint + "/searchByUser";
			$http({
				method : 'GET',
				url : subpoint,
			}).success(function(serverRes, status, headers, config) {
				list = serverRes;
				if (list.list.length != '' || list.list.length > 0) {
					progress = "";
				} else {
					progress = "No Record Found.";
				}
			}).error(function(serverRes, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		},

		addData : function(bidding, pageNo, pageSize) {
			var reload = this;
			successMsg = [];
			progress = "Please Wait..";

			var subpoint = endpoint + "/add";
			$http({
				method : 'POST',
				url : subpoint,
				data : bidding
			}).success(function(data, status, headers, config) {
				progress = "";
				successMsg = {
					"success" : data.success,
					"msg" : data.message,
				};
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},

		updateData : function(bidding, pageNo, pageSize) {
			var reload = this;
			successMsg = [];
			progress = "Please Wait..";
			var subpoint = endpoint + "/edit";
			$http({
				method : 'POST',
				url : subpoint,
				data : bidding
			}).success(function(data, status, headers, config) {
				progress = "";
				successMsg = {
					"success" : data.success,
					"msg" : data.message,
				};
				if (successMsg.length != '' && successMsg.success == true) {
					reload.listData(pageNo, pageSize);
				}
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},

		acceptBid : function(bidding) {
			var reload = this;
			successMsg = [];
			progress = "Please Wait..";
			var subpoint = endpoint + "/acceptBid";
			$http({
				method : 'POST',
				url : subpoint,
				data : bidding
			}).success(function(data, status, headers, config) {
				progress = "";
				reload.viewQoutation(bidding.productId);
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},

		productList : function() {
			progress = "Please Wait..";
			var subpoint = "/OCBS/rest/AdminProduct/search";
			$http({
				method : 'POST',
				url : subpoint,

			}).success(function(serverRes, status, headers, config) {
				productList = serverRes;
				if (productList.length != '' || productList.length > 0) {
					progress = "";
				} else {
					progress = "No Record Found..";
				}
			}).error(function(serverRes, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		},
		deleteData : function(checkId, pageNo, pageSize) {
			var reload = this;
			progress = "Please Wait..";
			var subpoint = endpoint + "/delete/" + checkId;
			$http({
				method : 'POST',
				url : subpoint
			}).success(function(data, status, headers, config) {
				progress = "";
				successMsg = data;
				if (successMsg.length != '' && successMsg.success == true) {
					reload.listData(pageNo, pageSize);
				}
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},
		search : function(bidding, pageNo, pageSize) {
			var reload = this;
			progress = "Please Wait..";
			var subpoint = endpoint + "/search";
			$http({
				method : 'POST',
				url : subpoint,
				data : bidding
			}).success(function(data, status, headers, config) {
				list = data;
				if (list.length != '' || list.length > 0) {
					progress = "";
				} else {
					progress = "No Record Found.";
				}
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},

		userList : function() {
			progress = "Please Wait..";
			var subpoint = "/OCBS/rest/Users/search";
			$http({
				method : 'POST',
				url : subpoint,
			}).success(function(data, status, headers, config) {
				userList = data;
				if (userList.length != '' || userList.length > 0) {
					progress = "";
				} else {
					progress = "No Record Found..";
				}
			}).error(function(serverRes, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		}

	};
});