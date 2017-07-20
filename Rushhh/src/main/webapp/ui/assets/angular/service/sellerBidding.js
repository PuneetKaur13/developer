mainApp.factory("SellerBiddingService", function($http, HomeService) {
	list = [];
	sellerBids = [];
	packagingList = [];
	sellerOfferSee = [];
	viewChartList = [];
	viewCityChartList = [];
	quotationList = [];
	cityList = [];
	cityStateList = [];
	stateList = [];
	sellerDeals = [];
	sellerOffer = [];
	productList = [];
	userList = [];
	formData = [];
	userReportList = [];
	statiSticsList = [];
	sellerCountList = [];
	viewInformationList = [];
	progress = "";
	sellerOfferProgress = "";
	successMsg = "";
	authMsg = "";
	buyerCountList = [];
	productCountList = [];
	userCountList = [];
	offersList = [];
	requirementList = -[];
	productListReport=[];
	companyList=[];
	var endpoint = "/Rushhh/rest/SellerBidding";

	return {
		getData : function() {
			return list;
		},
		getCompanyList : function() {
			return companyList;
		},
		
		getProductListReport : function() {
			return productListReport;
		},
		getRequirementList : function() {
			return requirementList;
		},
		getOffersList : function() {
			return offersList;
		},

		getUserCountList : function() {
			return userCountList;
		},

		getStatiSticsList : function() {
			return statiSticsList;
		},

		getProductCountList : function() {
			return productCountList;
		},

		getBuyerCountList : function() {
			return buyerCountList;
		},

		getSellerCountList : function() {
			return sellerCountList;
		},
		getSellerBids : function() {
			return sellerBids;
		},
		getUserReportList : function() {
			return userReportList;
		},
		getSellerOfferSee : function() {
			return sellerOfferSee;
		},
		getSellerDeals : function() {
			return sellerDeals;
		},

		getSellerOffer : function() {
			return sellerOffer;
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

		getProductList : function() {
			return productList;
		},

		getViewInformationList : function() {
			return viewInformationList;
		},
		getUserList : function() {
			return userList;
		},
		getViewChartList : function() {
			return viewChartList;
		},
		getViewCityChartList : function() {
			return viewCityChartList;
		},
		getStateList : function() {
			return stateList;
		},

		getCityList : function() {
			return cityList;
		},
		getCityStateList : function() {
			return cityStateList;
		},

		getPackagingList : function() {
			return packagingList;
		},

		getQuotationList : function() {
			return quotationList;
		},

		getProgress : function() {
			return progress;
		},

		getSellerOfferProgress : function() {
			return sellerOfferProgress;
		},

		listAll : function(pageNo, pageSize) {
			progress = "";
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
				//progress = "";
			});
		},
		
		userReportList : function(pageNo, pageSize) {
			progress = "";
			var subpoint = endpoint + "/searchUserSellerReport";
			$http({
				method : 'GET',
				url : subpoint,
			}).success(function(data, status, headers, config) {
				userReportList = data;
				if (userReportList.list.length != '' || userReportList.list.length > 0) {
					progress = "";
				} else {
					progress = "No Record Found.";
				}
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				//progress = "";
			});
		},
		searchBox : function(branch, pageNo, pageSize) {
			var reload = this;
			progress = "Please Wait..";
			var subpoint = endpoint + "/searchByBox";
			$http({
				method : 'POST',
				url : subpoint,
				data : branch
			}).success(function(data, status, headers, config) {
				userReportList = data;
				if (userReportList.list.length != '' || userReportList.list.length > 0) {
					progress = "";
				} else {
					progress = "No Record Found.";
				}
		
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},

		//Reports
		searchByValue : function(branch,reportType, pageNo, pageSize) {
			progress = "Please Wait..";
			
			var subpoint = endpoint + "/searchByBox";
			var dt=new Date();
			var dtFormat= dt.getUTCDate() + '_' + (dt.getUTCMonth() + 1) + '_'+ dt.getUTCFullYear() ;
			if(reportType=='PDF'){
				subpoint="PDFSeller/downloadPDFBuyer";
				$http({
					method : 'POST',
					url : subpoint,
					data : branch,
					responseType : 'arraybuffer'
				}).success(function(data, status, headers, config) {
				    // TODO when WS success
				    var file = new Blob([ data ], {
				        type : 'application/pdf'
				    });
			
				    //trick to download store a file having its URL
				    var fileURL = URL.createObjectURL(file);
				    var a         = document.createElement('a');
				    a.href        = fileURL; 
				    a.target      = '_blank';
				    a.download    = 'SellerReport'+dtFormat+'.pdf';
				    document.body.appendChild(a);
				    a.click();
				})
			}
			else{
			$http({
				method : 'POST',
				url : subpoint,
				data : branch
			}).success(function(data, status, headers, config) {
				userReportList = data;
				if (userReportList.list.length != '' || userReportList.list.length > 0) {
					progress = "";
				} else {
					progress = "No Record Found.";
				}
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Select Date";
			});
			}
		},
		
		listData : function(pageNo, pageSize) {
			progress = "";
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

		sellerDeals : function(pageNo, pageSize) {
			var reload = this;
			progress = "";
			var subpoint = endpoint + "/sellerDeals";
			$http({
				method : 'GET',
				url : subpoint
			}).success(
					function(data, status, headers, config) {
						sellerDeals = data;
						if (sellerDeals.list.length != ''
								|| sellerDeals.list.length > 0) {
							progress = "";
						} else {
							progress = "No Record Found.";
						}
					}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},
		viewChart : function(productId) {
			progress = "Please Wait..";
			var subpoint = endpoint + "/getStateChart/" + productId;
			$http({
				method : 'GET',
				url : subpoint,
			}).success(
					function(data, status, headers, config) {
						progress = "";
						viewChartList = data;
						if (viewChartList.list.length == ''
								|| viewChartList.list.length == 0) {
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

		viewInformationList : function(id) {
			progress = "Please Wait..";
			var subpoint = endpoint + "/viewInformation/" + id
			$http({
				method : 'GET',
				url : subpoint,
			}).success(
					function(data, status, headers, config) {
						progress = "";
						viewInformationList = data;
						if (viewInformationList.list.length == ''
								|| viewInformationList.list.length == 0) {
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

		viewCityChart : function(productId, stateId) {
			progress = "Please Wait..";
			var subpoint = endpoint + "/getCityChart/" + productId + "/"
					+ stateId;
			$http({
				method : 'GET',
				url : subpoint,
			}).success(
					function(data, status, headers, config) {
						progress = "";
						viewCityChartList = data;
						if (viewCityChartList.list.length == ''
								|| viewCityChartList.list.length == 0) {
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
		makeQuotation : function(pageNo, pageSize) {
			progress = "";
			var subpoint = endpoint + "/makeQuotation";
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
		addData : function(bidding, pageNo, pageSize) {
			var reload = this;
			successMsg = [];
			progress = "";
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
				if (successMsg.length != '' && successMsg.success == true) {
					reload.listData(pageNo, pageSize);
				}
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},

		updateData : function(bidding, pageNo, pageSize) {
			var reload = this;
			successMsg = [];
			progress = "";
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

		updateBySuperUser : function(bidding, pageNo, pageSize) {
			var reload = this;
			successMsg = [];
			progress = "";
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
					reload.listAll(pageNo, pageSize);
				}
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},
		findPackaging : function(productId) {
			var subpoint = "/Rushhh/rest/AdminProductPackaging/findByProductId/"
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

		findCityState : function(stateId) {
			var subpoint = "/Rushhh/rest/City/findByStateId/" + stateId;
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

		findQuotation : function(productId) {
			var subpoint = "/Rushhh/rest/BuyerQuoation/viewHistory/" + productId;
			$http({
				method : 'GET',
				url : subpoint,
			}).success(function(serverRes, status, headers, config) {
				quotationList = serverRes;
			}).error(function(serverRes, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});

		},
		stateList : function() {
			progress = "";
			var subpoint = "/Rushhh/rest/State/searchStateDashBoard";
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
			var subpoint = "/Rushhh/rest/City/searchCity";
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
		
		productListReport : function() {
			progress = "";
			var subpoint = "/Rushhh/rest/AdminProduct/searchProduct";
			$http({
				method : 'POST',
				url : subpoint,

			}).success(function(serverRes, status, headers, config) {
				productListReport = serverRes;
				if (productListReport.length != '' || productListReport.length > 0) {
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
			var subpoint = "/Rushhh/rest/AdminProduct/searchProduct";;
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
		},
		search : function(bidding, pageNo, pageSize) {
			var reload = this;
			progress = "";
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

		sellerBids : function() {
			var reload = this;
			progress = "";
			var subpoint = endpoint + "/getSellerInfo/BUY";
			$http({
				method : 'GET',
				url : subpoint
			}).success(
					function(data, status, headers, config) {
						sellerBids = data;
						if (sellerBids.list.length != ''
								|| sellerBids.list.length > 0) {
							progress = "";
						} else {
							progress = "No Record Found.";
						}
					}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},

		sellerOffer : function(bidding) {
			var reload = this;
			progress = "";
			var subpoint = endpoint + "/getSellerInfo/SELL";
			$http({
				method : 'POST',
				url : subpoint,
				data : bidding
			}).success(
					function(data, status, headers, config) {
						sellerOffer = data;
						if (sellerOffer.list.length != ''
								|| sellerOffer.list.length > 0) {
							sellerOfferProgress = "";
						} else {
							sellerOfferProgress = "No Record Found.";
						}
					}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},

		sellerOfferSee : function(bidding) {
			var reload = this;
			progress = "";
			var subpoint = endpoint + "/getSellerTab/SELL";
			$http({
				method : 'POST',
				url : subpoint,
				data : bidding
			}).success(
					function(data, status, headers, config) {
						sellerOfferSee = data;
						if (sellerOfferSee.list.length != ''
								|| sellerOfferSee.list.length > 0) {
							sellerOfferProgress = "";
						} else {
							sellerOfferProgress = "No Record Found.";
						}
					}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},

		statiSticsList : function() {
			console.log('in service');
			progress = "";
			var subpoint = endpoint + "/getAdminStatiStics";
			$http({
				method : 'GET',
				url : subpoint,
			}).success(function(data, status, headers, config) {
				statiSticsList = data;
				if (statiSticsList.length != '' || statiSticsList.length > 0) {
					progress = "";
				} else {
					progress = "No Record Found..";
				}
			}).error(function(serverRes, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		},

		sellerCountList : function() {
			progress = "";
			var subpoint = "/Rushhh/rest/Message/getSellerCountList";
			$http({
				method : 'GET',
				url : subpoint,
			}).success(
					function(data, status, headers, config) {
						sellerCountList = data;
						if (sellerCountList.length != ''
								|| sellerCountList.length > 0) {
							progress = "";
						} else {
							progress = "No Record Found..";
						}
					}).error(function(serverRes, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		},

		buyerCountList : function() {
			progress = "";
			var subpoint = "/Rushhh/rest/Message/getBuyerCountList";
			$http({
				method : 'GET',
				url : subpoint,
			}).success(function(data, status, headers, config) {
				buyerCountList = data;
				if (buyerCountList.length != '' || buyerCountList.length > 0) {
					progress = "";
				} else {
					progress = "No Record Found..";
				}
			}).error(function(serverRes, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		},

		productCountList : function() {
			progress = "";
			var subpoint = "/Rushhh/rest/Message/getProductCountList";
			$http({
				method : 'GET',
				url : subpoint,
			}).success(
					function(data, status, headers, config) {
						productCountList = data;
						if (productCountList.length != ''
								|| productCountList.length > 0) {
							progress = "";
						} else {
							progress = "No Record Found..";
						}
					}).error(function(serverRes, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		},

		userCountList : function() {
			progress = "";
			var subpoint = "/Rushhh/rest/Message/getUserCountList";
			$http({
				method : 'GET',
				url : subpoint,
			}).success(function(data, status, headers, config) {
				userCountList = data;
				if (userCountList.length != '' || userCountList.length > 0) {
					progress = "";
				} else {
					progress = "No Record Found..";
				}
			}).error(function(serverRes, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		},

		offersList : function() {
			progress = "";
			var subpoint = "/Rushhh/rest/Message/offersList";
			$http({
				method : 'GET',
				url : subpoint,
			}).success(function(data, status, headers, config) {
				offersList = data;
				if (offersList.length != '' || offersList.length > 0) {
					progress = "";
				} else {
					progress = "No Record Found..";
				}
			}).error(function(serverRes, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		},
	
		
		requirementList : function() {
			progress = "";
			var subpoint = "/Rushhh/rest/Message/requirementList";
			$http({
				method : 'GET',
				url : subpoint,
			}).success(
					function(data, status, headers, config) {
						requirementList = data;
						if (requirementList.length != ''
								|| requirementList.length > 0) {
							progress = "";
						} else {
							progress = "No Record Found..";
						}
					}).error(function(serverRes, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		},

		/*userReportList : function() {
			progress = "";
			var subpoint = endpoint + "/getUserStatiStics";
			console.log('ahjksdhkahksd')
			$http({
				method : 'GET',
				url : subpoint,
			}).success(function(data, status, headers, config) {
				userReportList = data;
				if (userReportList.length != '' || userReportList.length > 0) {
					progress = "";
				} else {
					progress = "No Record Found..";
				}
			}).error(function(serverRes, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		},*/


		
		
		
		companyList : function() {
			progress = "";
			var subpoint = "/Rushhh/rest/Company/search";
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

		
		
		userList : function() {
			progress = "";
			var subpoint = "/Rushhh/rest/Users/search";
			$http({
				method : 'POST',
				url : subpoint,
			}).success(function(data, status, headers, config) {
				userList = data;
				if (userList.length != '' || userList.length > 0) {
					progress = "";
				} else {
					// progress = "No Record Found..";
				}
			}).error(function(serverRes, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		}

	};
});