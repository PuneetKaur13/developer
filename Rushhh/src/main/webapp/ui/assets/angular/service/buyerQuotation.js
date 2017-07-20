mainApp.factory("BuyerQuotationService", function($http) {
	list = [];
	viewQuotationList = [];
	viewUserQoutationList = [];
	counterList = [];
	productList = [];
	viewHistoryList = [];
	viewRankList = [];
	userList = [];
	formData = [];
	liveList = [];
	progress = "";
	successMsg = "";
	authMsg = "";
	searchByUserHistory = [];
	homeLiveList=[];

	var endpoint = "/OCBS/rest/BuyerQuotation";

	return {
		getData : function() {
			return list;
		},

		getLive : function() {
			return liveList;
		},
		
		getHomeLiveList : function() {
			return homeLiveList;
		},


		getSuccessMsg : function() {
			return successMsg;
		},
		getFormData : function() {
			return formData;
		},
		getAuthMsg : function() {
			return authMsg;
		},
		getViewHistoryList : function() {
			return viewHistoryList;
		},
		getViewRankList : function() {
			return viewRankList;
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
		getViewUserQoutationList : function() {
			return viewUserQoutationList;
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
		
		liveList : function(pageNo, pageSize) {
			progress = "";
			var subpoint = "/OCBS/rest/BuyerBidding/searchLive";
			$http({
				method : 'GET',
				url : subpoint,
			}).success(function(data, status, headers, config) {
				liveList = data;
				if (liveList.list.length != '' || liveList.list.length > 0) {
					progress = "";
				} else {
					progress = "No Record Found.";
				}
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},
		homeLiveList : function(pageNo, pageSize) {
			progress = "";
			var subpoint = "/OCBS/rest/BuyerBidding/homeLive";
			$http({
				method : 'GET',
				url : subpoint,
			}).success(function(data, status, headers, config) {
				homeLiveList = data;
				if (homeLiveList.list.length != '' || homeLiveList.list.length > 0) {
					progress = "";
				} else {
					progress = "No Record Found.";
				}
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},
		
		
		viewHistory : function(productId,buyerId,packagingId,stateId,cityId) {
			progress = "Please Wait..";
			var subpoint = endpoint + "/getHistory/" + productId +"/"+buyerId+"/"+packagingId+"/"+stateId+"/"+cityId;

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
		viewQoutation : function(productId, cityId,stateId,packagingId) {
			progress = "Please Wait..";
			var subpoint = endpoint + "/viewQoutation/" + productId + "/"+cityId+"/"+stateId+"/"+packagingId;
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
		viewRank : function(productId) {
			progress = "Please Wait..";
			var subpoint = endpoint + "/viewRank/" + productId;
			$http({
				method : 'GET',
				url : subpoint,
			}).success(
					function(data, status, headers, config) {
						progress = "";
						viewRankList = data;
						if (viewRankList.list.length == ''
								|| viewRankList.list.length == 0) {
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
		viewUserQoutation : function(productId,cityId,stateId,packagingId) {
			progress = "Please Wait..";
			var subpoint = endpoint + "/viewUserQoutation/"+ productId + "/"+cityId+"/"+stateId+"/"+packagingId;
			$http({
				method : 'GET',
				url : subpoint,
			}).success(
					function(data, status, headers, config) {
						progress = "";
						viewUserQoutationList = data;
						if (viewUserQoutationList.list.length == ''
								|| viewUserQoutationList.list.length == 0) {
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
		
		viewCounter : function(quotationId) {
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
				successMsg = {
						"success" : data.success,
						"msg" : data.message
				};
				reload.viewUserQoutation(bidding.productId,bidding.cityId,bidding.stateId,bidding.packagingId);
				reload.liveList(0, 0);
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
		searchQuotation : function() {
			progress = "Please Wait..";
			var subpoint = endpoint + "/searchQuotation";
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