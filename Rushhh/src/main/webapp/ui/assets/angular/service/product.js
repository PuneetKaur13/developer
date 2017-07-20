mainApp.factory("ProductService", function($http) {
	list = [];
	formData = [];
	productList = [];
	progress = "";
	successMsg = "";
	authMsg = "";

	var endpoint = "/Rushhh/rest/product";

	return {
		getData : function() {
			return list;
		},

		getSuccessMsg : function() {
			return successMsg;
		},
		getProductList : function() {
			return productList;
		},
		getFormData : function() {
			return formData;
		},

		getAuthMsg : function() {
			return authMsg;
		},
		getProgress : function() {
			return progress;
		},

		listData : function(pageNo, pageSize) {
			progress = "";
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

		get : function(id) {
			progress = "";
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
		addData : function(product, pageNo, pageSize) {
			var reload = this;
			successMsg = [];
			progress = "";
			var subpoint = endpoint + "/uploadFile";
			var fd = new FormData();
			var url = subpoint;
			fd.append('file', product.file);
			fd.append("form", angular.toJson(product.data));
			$http.post(url, fd, {
				withCredentials : false,
				transformRequest : angular.identity,
				headers : {
					'Content-Type' : undefined
				},
				data : angular.toJson(product.data)
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
			progress = "";
			var subpoint = "/Rushhh/rest/AdminProduct/searchProduct";
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
		updateData : function(product, pageNo, pageSize) {
			var reload = this;
			successMsg = [];
			progress = "";
			var subpoint = endpoint + "/edit";
			$http({
				method : 'POST',
				url : subpoint,
				data : product
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
		deleteData : function(checkId, pageNo, pageSize) {
			var reload = this;
			progress = "";
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