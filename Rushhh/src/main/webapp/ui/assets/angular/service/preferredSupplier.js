mainApp.factory("PreferredSupplierService", function($http) {
	list = [];
	formData = [];
	progress = "";
	successMsg = "";
	userList=[];
	companyList=[];
	productList=[];
	authMsg = "";
	viewAcceptUserList=[];

	var endpoint = "/OCBS/rest/PreferredSupllier";

	return {
		getData : function() {
			return list;
		},
		
		getViewAcceptUserList : function() {
			return viewAcceptUserList;
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

		getUserList : function() {
			return userList;
		},
		getCompanyList : function() {
			return companyList;
		},
		getProductList : function() {
			return productList;
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
		
		viewAcceptUser : function(bidId) {
			var subpoint = endpoint + "/viewUser/" + bidId;
			$http({
				method : 'GET',
				url : subpoint,
			}).success(function(serverRes, status, headers, config) {
				viewAcceptUserList = serverRes;
			}).error(function(serverRes, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		},
		userList : function() {
			progress = "";
			var subpoint = "/OCBS/rest/Users/search";
			$http({
				method : 'POST',
				url : subpoint,

			}).success(function(serverRes, status, headers, config) {
				userList = serverRes;
				if (userList.length != '' || userList.length > 0) {
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
		
		companyList : function() {
			progress = "";
			var subpoint = "/OCBS/rest/Company/search";
			$http({
				method : 'POST',
				url : subpoint,

			}).success(function(serverRes, status, headers, config) {
				companyList = serverRes;
				if (companyList.length != '' || companyList.length > 0) {
					progress = "";
				} else {
					progress = "No Record Found..";
				}
			}).error(function(serverRes, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
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

		addDataPrefferd : function(message, pageNo, pageSize) {
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