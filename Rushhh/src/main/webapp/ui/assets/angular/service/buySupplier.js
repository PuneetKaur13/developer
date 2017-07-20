mainApp.factory("BuySupplierService", function($http) {
	list = [];
	formData = [];
	progress = "";
	successMsg = "";
	authMsg = "";
	productList=[];
	packagingList=[];
	searchForBuySupplier=[];

	var endpoint = "/OCBS/rest/BuySupplier";

	return {
		getData : function() {
			return list;
		},
		getSearchForBuySupplier : function() {
			return searchForBuySupplier;
		},
		getPackagingList : function() {
			return packagingList;
		},
		getProductList : function() {
			return productList;
		},
		getFormData : function() {
			return formData;
		},

		getSuccessMsg : function() {
			return successMsg;
		},

		getAuthMsg : function() {
			return authMsg;
		},

		getProgress : function() {
			return progress;
		},

		listData : function(pageNo, pageSize) {
			progress = "Please Wait..";
			var subpoint = endpoint + "/searchByUser";
			$http({
				method : 'GET',
				url : subpoint,
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

		addData : function(message, pageNo, pageSize) {
			var reload = this;
			successMsg = [];
			progress = "Please Wait..";
			var subpoint = endpoint + "/add";
			$http({
				method : 'POST',
				url : subpoint,
				data : message
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

		updateData : function(message, pageNo, pageSize) {
			var reload = this;
			successMsg = [];
			progress = "Please Wait..";
			var subpoint = endpoint + "/edit";
			$http({
				method : 'POST',
				url : subpoint,
				data : message
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
		findPackaging : function(productId) {
			var subpoint =  "/OCBS/rest/AdminProductPackaging/findByProductId/" + productId;
			$http({
				method : 'GET',
				url : subpoint,
			}).success(function(serverRes, status, headers, config) {
				packagingList = serverRes;
			}).error(function(serverRes, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});

		},
		searchForBuySupplier : function() {
			progress = "";
			var subpoint = "/OCBS/rest/Users/searchForBuySupplier";
			$http({
				method : 'POST',
				url : subpoint,
			}).success(function(serverRes, status, headers, config) {
				searchForBuySupplier = serverRes;
				if (searchForBuySupplier.length != '' || searchForBuySupplier.length > 0) {
					progress = "";
				} else {
					progress = "No Record Found..";
				}
			}).error(function(serverRes, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		},
		productList : function() {
			progress = "";
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
		}
	};
});