mainApp.factory("PlantInformationService", function($http, $location) {
	list = [];
	formData = [];
	progress = "";
	successMsg = "";
	authMsg = "";
	stateList = [];
	productList = [];
	cityList = [];
	cityStateList = [];
	packagingList = [];
	companyList=[];
	interSectionList=[];
	companyUnderUserList=[];
	var endpoint = "/OCBS/rest/PlantInformation";

	return {
		
		getData : function() {
			return list;
		},
		getCompanyUnderUserList : function() {
			return companyUnderUserList;
		},
		getProductList : function() {
			return productList;
		},
		getInterSectionList : function() {
			return interSectionList;
		},
		getCompanyList : function() {
			return companyList;
		},
		getFormData : function() {
			return formData;
		},

		getPackagingList : function() {
			return packagingList;
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

		getCityStateList : function() {
			return cityStateList;
		},

		getStateList : function() {
			return stateList;
		},

		getCityList : function() {
			return cityList;
		},

		listData : function(pageNo, pageSize) {
			progress = "Please Wait..";
			var subpoint = endpoint + "/searchByUser";
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

		stateList : function() {
			progress = "";
			var subpoint = "/OCBS/rest/State/search";
			$http({
				method : 'GET',
				url : subpoint,
			}).success(function(data, status, headers, config) {
				stateList = data;
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},
		cityList : function(stateId) {
			progress = "";
			var subpoint = "/OCBS/rest/City/search";
			$http({
				method : 'GET',
				url : subpoint,
			}).success(function(data, status, headers, config) {
				cityList = data;
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},
		
		companyUnderUserList : function(bidId) {
			progress = "";
			var subpoint = endpoint + "/companyUnderUser/" + bidId ;
			$http({
				method : 'GET',
				url : subpoint,
			}).success(function(data, status, headers, config) {
				companyUnderUserList = data;
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
		searchBox : function(branch, pageNo, pageSize) {
			var reload = this;
			progress = "Please Wait..";
			refresh()
			var subpoint = endpoint + "/searchByBox";
			$http({
				method : 'POST',
				url : subpoint,
				data : branch
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
		searchByUser : function() {
			progress = "Please Wait..";
			var subpoint = endpoint + "/searchByUser";
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
		addData : function(company, pageNo, pageSize) {
			var reload = this;
			successMsg = [];
			progress = "Please Wait..";
			var subpoint = endpoint + "/uploadFile";
			
			var fd = new FormData();
			var url = subpoint;
			fd.append('file', company.file);
			fd.append("form", angular.toJson(company.data));
			$http.post(url, fd, {
				withCredentials : false,
				transformRequest : angular.identity,
				headers : {
					'Content-Type' : undefined
				},
				data : angular.toJson(company.data)
			}).success(function(data, status, headers, config) {
				progress = "";
				successMsg = {
					"success" : data.success,
					"msg" : data.message,
				};
				if (successMsg.length != '' && successMsg.success == true) {
					reload.listData(pageNo, pageSize);
					reload.searchByUser();
				}
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},

		updateData : function(company, pageNo, pageSize) {
			var reload = this;
			successMsg = [];
			progress = "Please Wait..";
			var fd = new FormData();
			var url = endpoint;
			fd.append('photo', company.photo);
			fd.append("operation", "Save");
			fd.append("model", angular.toJson(company));
			$http.post(url, fd, {
				withCredentials : false,
				transformRequest : angular.identity,
				headers : {
					'Content-Type' : undefined
				}
			}).success(function(data, status, headers, config) {
				progress = "";
				successMsg = {
					"success" : data.success,
					"msg" : data.message,
				};
				if (successMsg.length != '' && successMsg.success == true) {
					reload.listData(null, pageNo, pageSize);
					reload.searchByUser();
				}
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},

		findCityState : function(stateId) {
			var subpoint = "/OCBS/rest/City/findByStateId/" + stateId;
			$http({
				method : 'GET',
				url : subpoint,
			}).success(function(serverRes, status, headers, config) {
				cityStateList = serverRes;
			}).error(function(serverRes, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		},
		findPackaging : function(productId) {
			var subpoint = "/OCBS/rest/AdminProductPackaging/findByProductId/"
					+ productId;
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

		interSectionList : function() {
			progress = "";
			var subpoint = "/OCBS/rest/CompanyProductIntersection/searchByUser";
			$http({
				method : 'POST',
				url : subpoint,
			}).success(function(serverRes, status, headers, config) {
				interSectionList = serverRes;
				if (interSectionList.length != '' || interSectionList.length > 0) {
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