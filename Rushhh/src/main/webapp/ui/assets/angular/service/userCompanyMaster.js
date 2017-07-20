mainApp.factory("UserCompanyMasterService", function($http, $location) {
	list = [];
	listByUser = [];
	formData = [];
	roleList = [];
	progress = "";
	successMsg = "";
	authMsg = "";
	logoutMsg = "";
	sessionMsg = "";
	companyList=[];
	searchForSellSupplier=[];
	notificationList=[];

	var endpoint = "/Rushhh/rest/Users";

	return {

		getCompanyList :function()
		{
			return companyList;
		},
		getData : function() {
			return list;
		},
		getNotificationList : function() {
			return notificationList;
		},
		getSearchForSellSupplier: function() {
			return searchForSellSupplier;
		},
		getDataByUser : function() {
			return listByUser;
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

		getSessionMsg : function() {
			return sessionMsg;
		},

		getLogoutMsg : function() {
			return logoutMsg;
		},

		getRoleList : function() {
			return roleList;
		},

		getProgress : function() {
			return progress;
		},

		listData : function(user, pageNo, pageSize) {
			progress = "Please Wait..";
			var subpoint = endpoint + "/searchByAdmin";
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
		searchForSellSupplier : function(user, pageNo, pageSize) {
			progress = "Please Wait..";
			var subpoint = endpoint + "/searchForSellSupplier";
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
	
		searchBoxUser : function(branch, pageNo, pageSize) {
			var reload = this;
			progress = "Please Wait..";
			var subpoint = endpoint + "/searchByBoxUser";
			$http({
				method : 'POST',
				url : subpoint,
				data : branch
			}).success(function(data, status, headers, config) {
				list = data;
				if (list.list.length != '' || list.list.length > 0) {
					progress = "";
				} else {
					progress = "No Record Found.";
				}
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Please Select One Value Inside Search Box";
			});
		},

		listByUser : function(user, pageNo, pageSize) {
			progress = "Please Wait..";
			var subpoint = endpoint + "/searchByUser";
			$http({
				method : 'GET',
				url : subpoint,
			}).success(
					function(data, status, headers, config) {
						listByUser = data;
						if (listByUser.list.length != ''
								|| listByUser.list.length > 0) {
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

		editMyProfile : function() {
			progress = "Please Wait..";
			var subpoint = endpoint + "/editMyProfile";
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
/*authenticate : function(user) {
			successMsg = [];
			progress = "Please Wait..";
			var subpoint = endpoint + "/authentication";
			$http({
				method : 'POST',
				url : subpoint,
				data : user
				
			}).success(function(serverRes, status, headers, config) {
				progress = "";
				
				authMsg = {
					"success" : serverRes.success,
					"msg" : serverRes.message,
				};
				if(!serverRes.success  && serverRes.message == 'DEACTIVATED'){
				
					successMsg = {
						"success" : false,
						"msg" : "You are deactivated now. Please enter OTP to activate."
					};
					$location.path("OTP");
				}else if(!serverRes.success  && serverRes.message == 'REGISTER COMPANY'){
					successMsg = {
							"success" : false,
							"msg" : "You are not a  member of any company. Please select or create your own company."
						};
						$location.path("UserCompanyRegistration");
				}
			}).error(function(data, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		},*/
		

authenticate : function(user) {
	
			successMsg = [];
			//progress = "Please Wait..";
			var subpoint = endpoint + "/authentication";
			$http({
				method : 'POST',
				url : subpoint,
				data : user
			}).success(function(serverRes, status, headers, config) {
				authMsg = {
					"success" : serverRes.success,
					"msg" : serverRes.message,
				};
				if(!serverRes.success  && serverRes.message == 'DEACTIVATED'){
					successMsg = {
						"success" : false,
						"msg" : "You are deactivated now. Please enter OTP to activate."
					};
					$location.path("OTP");
					
				}/*if(!serverRes.success  && serverRes.message == 'REGISTER COMPANY'){
						successMsg = {
								"success" : false,
								"msg" : "You are not a  member of any company. Please select or create your own company."
							};
							$location.path("UserCompanyRegistration");
					}
			if(serverRes.message == 'DISAPPROVED'){
								$location.path("Approval");
			}
	*/
				
				
			}).error(function(data, status, headers, config) {

				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		},

		submitOTP : function(user) {
			successMsg = [];
			progress = "Please Wait..";
			var subpoint = endpoint + "/submitOTP";
			$http({
				method : 'POST',
				url : subpoint,
				data : user
			}).success(function(data, status, headers, config) {
				progress = "";
				successMsg = {
					"success" : data.success,
					"msg" : data.message,
				};
				if(data.success){
					successMsg = {
							"success" : false,
							"msg" : "You are not a  member of any company. Please enter or create your company.",
					}
					$location.path("UserCompanyRegistration");
				}
				
			}).error(function(data, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		},
		

		register : function(user) {
			var reload = this;
			successMsg = [];
			progress = "Please Wait..";
			var subpoint = endpoint + "/uploadFile";
			var fd = new FormData();
			var url = subpoint;
			fd.append('file', user.file);
			fd.append("form", angular.toJson(user.data));
			$http.post(url, fd, {
				withCredentials : false,
				transformRequest : angular.identity,
				headers : {
					'Content-Type' : undefined
				},
				data : angular.toJson(user.data)
			}).success(function(data, status, headers, config) {
				progress = "";
				successMsg = {
					"success" : data.success,
					"msg" : data.message,
				};
				if (data.success) {
					successMsg.msg = "Congratulations "+user.data.firstName+", You have been registered successfully, Please enter OTP to activate yourself.";
					$location.path("OTP");
				}
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},

		
		resendOTP : function() {
			successMsg = [];
			progress = "Please Wait..";
			var subpoint = endpoint + "/resendOTP";
			$http({
				method : 'POST',
				url : subpoint
			}).success(function(data, status, headers, config) {
				progress = "";
				successMsg = {
					"success" : data.success,
					"msg" : data.message,
				};
			}).error(function(data, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		},
		
		forgetPassword : function(user) {
			successMsg = [];
			progress = "Please Wait..";
			var subpoint = endpoint + "/forgetPassword";
			$http({
				method : 'POST',
				url : subpoint,
				data : user
			}).success(function(data, status, headers, config) {
				progress = "";
				successMsg = {
					"success" : data.success,
					"msg" : data.message,
				};
			}).error(function(data, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		},
		
		
		submitCompany : function(user) {
			successMsg = [];
			progress = "Please Wait..";
			var subpoint = endpoint + "/submitCompany";
			$http({
				method : 'POST',
				url : subpoint,
				data : user
			}).success(function(data, status, headers, config) {
				progress = "";
				successMsg = {
					"success" : data.success,
					"msg" : data.message,
				};
				if(user.companyType=="existingCompany")
					{
					
					window.location = "#/Approval";
					location.reload(1);
					}
				else if(user.companyType=="newCompany")
					{
					window.location = "#/CompanyDetail";
					location.reload(1);
					
					}
			}).error(function(data, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		},
		/*checkSession : function() {
			successMsg = [];
			progress = "Please Wait..";
			var subpoint = endpoint + "/checkSession";
			$http({
				method : 'GET',
				url : subpoint
			}).success(function(serverRes, status, headers, config) {
				progress = "";
				sessionMsg = {
					"success" : serverRes.success,
					"msg" : serverRes.message,
				};
			}).error(function(data, status, headers, config) {

				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		},*/
		
		checkSession : function() {
			successMsg = [];
			progress = "Please Wait..";
			var subpoint = endpoint + "/checkSession";
			$http({
				method : 'GET',
				url : subpoint
			}).success(function(serverRes, status, headers, config) {
				progress = "";
				sessionMsg = {
					"success" : serverRes.success,
					"msg" : serverRes.message,
				};
			}).error(function(data, status, headers, config) {

				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		},


		changeType : function(type) {
			successMsg = [];
			progress = "Please Wait..";
			var subpoint = endpoint + "/changeType/" + type;
			$http({
				method : 'GET',
				url : subpoint
			}).success(function(serverRes, status, headers, config) {
				progress = "";
				successMsg = serverRes;
				if (successMsg.length != '' && successMsg.success == true) {
					window.location = "#/Home";
					location.reload(1);
				}
			}).error(function(data, status, headers, config) {

				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		},

		logout : function() {
			successMsg = [];
			progress = "Please Wait..";
			var subpoint = endpoint + "/logout";
			$http({
				method : 'GET',
				url : subpoint
			}).success(function(serverRes, status, headers, config) {
				progress = "";
				logoutMsg = {
					"success" : serverRes.success,
					"msg" : serverRes.message,
				};
			}).error(function(data, status, headers, config) {

				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		},

		addData : function(user, pageNo, pageSize) {
			var reload = this;
			successMsg = [];
			progress = "Please Wait..";
			var subpoint = endpoint + "/uploadFile";
			var fd = new FormData();
			var url = subpoint;
			fd.append('file', user.file);
			fd.append("form", angular.toJson(user.data));
			$http.post(url, fd, {
				withCredentials : false,
				transformRequest : angular.identity,
				headers : {
					'Content-Type' : undefined
				},
				data : angular.toJson(user.data)
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

		updateData : function(user, pageNo, pageSize) {
			var reload = this;
			successMsg = [];
			progress = "Please Wait..";
			var fd = new FormData();
			var url = endpoint;
			fd.append('photo', user.photo);
			fd.append("operation", "Save");
			fd.append("model", angular.toJson(user));
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
					reload.listData(null, pageNo, pageSize);
				}
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},

		notificationList : function() {
			progress = "Please Wait..";
			
			var subpoint = "/OCBS/rest/Notification/getCount";
			$http({
				method : 'GET',
				url : subpoint,
			}).success(function(data, status, headers, config) {
				notificationList = data;
				console.log(notificationList,'data data')
				if (notificationList != '' ) {
					progress = "";
				} else {
					progress = "No Record Found..";
				}
			}).error(function(serverRes, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		},
		
		roleList : function() {
			progress = "Please Wait..";
			var subpoint = "/OCBS/rest/Role/search";
			$http({
				method : 'POST',
				url : subpoint,
			}).success(function(data, status, headers, config) {
				roleList = data;
				if (roleList.length != '' || roleList.length > 0) {
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
			var subpoint = "/OCBS/rest/Company/searchNotNull";
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
		
		
	};
});