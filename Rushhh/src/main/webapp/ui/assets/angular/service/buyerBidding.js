mainApp.factory("BuyerBiddingService", function($http,HomeService) {
	list = [];
	liveList=[];
	packagingList=[];
	companyList=[];
	cityList = [];
	stateList = [];	
	buyerBids = [];
	buyerBidTab = [];
	buyerBidsOpen=[];
	buyerOffer = [];
	buyerTabs=[];
	cityStateList = [];
	buyerDeals = [];
	productList = [];
	viewInformationList = [];
	userList = [];
	formData = [];
	myFavouriteList=[];
	progress = "";
	buyerBidProgress = "";
	buyerBidOpenProgress = "";
	successMsg = "";
	authMsg = "";
	viewSellersList=[];
	findByUserProductBuyerList=[];
	findByUserProductFavouriteList=[];
	manageProductList=[];
	findByAmountList=[];
	companyUnderUserList=[];
	userBuyReportList=[];
	var endpoint = "/Rushhh/rest/BuyerBidding";

	return {
		
		getData : function() {
			return list;
		},
		getUserBuyReportList : function() {
			return userBuyReportList;
		},
		
		getCompanyUnderUserList : function() {
			return companyUnderUserList;
		},
		
		getFindByUserProductBuyerList : function() {
			return findByUserProductBuyerList;
		},
		
		getFindByAmountList : function() {
			return findByAmountList;
		},
		getManageProductList : function() {
			return manageProductList;
		},
		getLive : function() {
			return liveList;
		},
		getViewSellersList : function() {
			return viewSellersList;
		},
		getBuyerBids : function() {
			return buyerBids;
		},
		getBuyerBidTab : function() {
			return buyerBidTab;
		},
		getFindByUserProductFavouriteList : function() {
			return findByUserProductFavouriteList;
		},
		getBuyerBidsOpen : function() {
			return buyerBidsOpen;
		},
	
		getViewInformationList : function() {
			return viewInformationList;
		},

		getBuyerDeals : function() {
			return buyerDeals;
		},

		getBuyerOffer : function() {
			return buyerOffer;
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
		
		getStateList : function() {
			return stateList;
		},
		
		getCityList : function() {
			return cityList;
		},
		getPackagingList : function() {
			return packagingList;
		},

		getUserList : function() {
			return userList;
		},
		getCompanyList : function() {
			return companyList;
		},
		getProgress : function() {
			return progress;
		},
		
		getBuyerTabs: function()
		{
			return buyerTabs;
		},
		
		getCityStateList : function() {
			return cityStateList;
		},

		getBuyerBidProgress : function() {
			return buyerBidProgress;
		},

		getBuyerBidOpenProgress : function() {
			return buyerBidOpenProgress;
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
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},

		requestSend : function(bidding) {
			var reload = this;
			successMsg = [];
			progress = "Please Wait..";
			var subpoint = endpoint + "/requestSend";
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
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},
		
		userBuyReportList : function(pageNo, pageSize) {
			progress = "";
			var subpoint = endpoint + "/searchUserBuyReport";
			$http({
				method : 'GET',
				url : subpoint,
			}).success(function(data, status, headers, config) {
				userBuyReportList = data;
				if (userBuyReportList.list.length != '' || userBuyReportList.list.length > 0) {
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
				userBuyReportList = data;
				if (userBuyReportList.list.length != '' || userBuyReportList.list.length > 0) {
					progress = "";
				} else {
					progress = "No Record Found.";
				}
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Please choose filter..";
			});
		},
		myFavouriteList : function() {
			progress = "";
			var subpoint = "/Rushhh/rest/PreferredSupllier/search";
			$http({
				method : 'POST',
				url : subpoint,

			}).success(function(serverRes, status, headers, config) {
				myFavouriteList = serverRes;
				if (myFavouriteList.length != '' || myFavouriteList.length > 0) {
					progress = "";
				} else {
					progress = "No Record Found..";
				}
			}).error(function(serverRes, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
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
		

		liveList : function(pageNo, pageSize) {
			progress = "";
			var subpoint = endpoint + "/searchLive";
			$http({
				method : 'GET',
				url : subpoint,
			}).success(function(data, status, headers, config) {
				list = data;
				if (liveList.length != '' || liveList.length > 0) {
					progress = "";
				} else {
					progress = "No Record Found.";
				}
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},
		
		
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
		viewInformationList : function(id) {
			progress = "Please Wait..";
			var subpoint = endpoint + "/viewInformation/"+id;
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
		
		viewSellersList : function() {
			progress = "Please Wait..";
			var subpoint = "/Rushhh/rest/SellSupplier/searchByUser";
			$http({
				method : 'GET',
				url : subpoint,
			}).success(
					function(data, status, headers, config) {
						progress = "";
						viewSellersList = data;
						if (viewSellersList.list.length == ''
								|| viewSellersList.list.length == 0) {
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

		findPackaging : function(productId) {
			var subpoint =  "/Rushhh/rest/AdminProductPackaging/findByProductId/" + productId;
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

		findByUserProductBuyerList : function(productId) {
			progress = "Please Wait..";
			var subpoint =  "/Rushhh/rest/AdminProductPackaging/findByUserProductBuyer/"+productId;
			$http({
				method : 'GET',
				url : subpoint,
			}).success(
					function(data, status, headers, config) {
						progress = "";
						findByUserProductBuyerList = data;
						if (findByUserProductBuyerList.list.length == ''
								|| findByUserProductBuyerList.list.length == 0) {
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

		findByUserProductFavouriteList : function(productId) {
			var subpoint =  "/Rushhh/rest/AdminProductPackaging/findByUserProductFavourite/"+productId;
			$http({
				method : 'GET',
				url : subpoint,
			}).success(function(serverRes, status, headers, config) {
				findByUserProductFavouriteList = serverRes;
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
		stateList : function() {
			progress = "";
			var subpoint = "/Rushhh/rest/State/search";
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
		
		findByAmountList : function(productId) {
			progress = "Please Wait..";
			var subpoint =  "/Rushhh/rest/AdminProductPackaging/findByAmount/"+productId;
			$http({
				method : 'GET',
				url : subpoint,
			}).success(
					function(data, status, headers, config) {
						progress = "";
						findByAmountList = data;
						if (findByAmountList.list.length == ''
								|| findByAmountList.list.length == 0) {
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
		
		cityList : function(stateId) {
			progress = "";
			var subpoint = "/Rushhh/rest/City/search";
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
		seeSellerOffers : function(pageNo, pageSize) {
			progress = "";
			var subpoint = endpoint + "/seeSellerOffers";
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
					reload.listData();
					//location.reload();
				}
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},

		addBank : function(bidding, pageNo, pageSize) {
			var reload = this;
			successMsg = [];
			progress = "";
			var subpoint = endpoint + "/editNew";
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
					console.log('heere is')
					location.reload();
				}
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},
		
		ManageProduct : function() {
			progress = "";
			var subpoint = "/Rushhh/rest/CompanyProductIntersection/searchByUser";
			$http({
				method : 'POST',
				url : subpoint,

			}).success(function(serverRes, status, headers, config) {
				manageProductList = serverRes;
				if (manageProductList.length != '' || manageProductList.length > 0) {
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
			var subpoint = "/Rushhh/rest/AdminProduct/search";
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
		buyerBids : function(bidding) {
			var reload = this;
			progress = "";
			var subpoint = endpoint + "/getBuyerInfo/BUY";
			$http({
				method : 'POST',
				url : subpoint,
				data : bidding
			}).success(function(data, status, headers, config) {
				buyerBids = data;
				if (buyerBids.list.length != '' || buyerBids.list.length > 0) {
					buyerBidProgress = "";
					HomeService.getSessionProduct();
				} else {
					buyerBidProgress = "No Record Found.";
				}
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				buyerBidProgress = "Error in Server Connection.. Please Try Again.";
			});
		},
		
		buyerBidTab : function(bidding) {
			var reload = this;
			progress = "";
			var subpoint = endpoint + "/getBuyerTab/BUY";
			$http({
				method : 'POST',
				url : subpoint,
				data : bidding
			}).success(function(data, status, headers, config) {
				buyerBidTab = data;
				if (buyerBidTab.list.length != '' || buyerBidTab.list.length > 0) {
					buyerBidProgress = "";
				} else {
					buyerBidProgress = "No Record Found.";
				}
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				buyerBidProgress = "Error in Server Connection.. Please Try Again.";
			});
		},
		buyerBidsOpen : function(d) {
			var reload = this;
			progress = "";
			var subpoint = endpoint + "/getBuyerInfoOpen/BUY";
			$http({
				method : 'POST',
				url : subpoint,
				data : d
			}).success(function(data, status, headers, config) {
				buyerBidsOpen = data;
				if (buyerBidsOpen.list.length != '' || buyerBidsOpen.list.length > 0) {
					buyerBidOpenProgress = "";
					HomeService.getSessionProduct();
				} else {
					buyerBidOpenProgress = "No Record Found.";
				}
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				buyerBidOpenProgress = "Error in Server Connection.. Please Try Again.";
			});
		},
		buyerDeals : function(pageNo, pageSize) {
			var reload = this;
			progress = "";
			var subpoint = endpoint + "/buyerDeals";
			$http({
				method : 'GET',
				url : subpoint
			}).success(
					function(data, status, headers, config) {
						buyerDeals = data;
						if (buyerDeals.list.length != ''
								|| buyerDeals.list.length > 0) {
							progress = "";
						} else {
							progress = "No Record Found.";
						}
					}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},
		
		buyerTabs : function(bidding) {
			var reload = this;
			progress = "";
			var subpoint = endpoint + "/getBuyerTabs/BUY";
			$http({
				method : 'POST',
				url : subpoint,
				data : bidding
			}).success(function(data, status, headers, config) {
				buyerBids = data;
				if (buyerTabs.list.length != '' || buyerBids.list.length > 0) {
					buyerBidProgress = "";
					HomeService.getSessionProduct();
				} else {
					progress = "No Record Found.";
				}
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},
		buyerOffer : function() {
			var reload = this;
			progress = "";
			var subpoint = endpoint + "/getBuyerInfo/SELL";
			$http({
				method : 'GET',
				url : subpoint
			}).success(
					function(data, status, headers, config) {
						buyerOffer = data;
						if (buyerOffer.list.length != ''
								|| buyerOffer.list.length > 0) {
							progress = "";
							HomeService.getSessionProduct();
						} else {
							progress = "No Record Found.";
						}
					}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},
		visitor : function(bidding) {
			var reload = this;
			successMsg = [];
			progress = "Please Wait..";
			var subpoint = endpoint + "/visitor";
			$http({
				method : 'POST',
				url : subpoint,
				data : bidding
			}).success(function(data, status, headers, config) {
				progress = "";
				//reload.viewQoutation(bidding.productId);
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},
		
		approveQuote : function(bids) {
			var reload = this;
			successMsg = [];
			progress = "Please Wait..";
			var subpoint = "/Rushhh/rest/MakeQuotation/approveQuote";
			$http({
				method : 'POST',
				url : subpoint,
				data : bids
			}).success(function(data, status, headers, config) {
				progress = "";
				successMsg = {
						"success" : data.success,
						"msg" : data.message
						
				};
				//location.reload();
				//reload.buyerBidTab();
				console.log(bids.bidId,'here bids')
				reload.companyUnderUserList(bids.bidId,bids.inviteGroupId);
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},
		acceptInvitation : function(bidding) {
			var reload = this;
			successMsg = [];
			progress = "Please Wait..";
			var subpoint = "/Rushhh/rest/MakeQuotation/acceptInvitation";
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
				location.reload();
				//reload.buyerBidTab();
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},
		rejectInvitation : function(bidding) {
			var reload = this;
			successMsg = [];
			progress = "Please Wait..";
			var subpoint = "/Rushhh/rest/MakeQuotation/rejectInvitation";
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
				location.reload();
				//reload.buyerBidTab();
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},
		
		//Company Under User List
		
		companyUnderUserList : function(bidId,inviteGroupId) {
			progress = "";
			var subpoint = "/Rushhh/rest/Company/companyUnderUser/"+bidId+"/"+inviteGroupId;
			//var subpoint = endpoint + "/companyUnderUser/" + bidId ;
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
		
		//Reports
		searchByValue : function(branch,reportType, pageNo, pageSize) {
			progress = "Please Wait..";
			
			var subpoint = endpoint + "/searchByBox";
			var dt=new Date();
			var dtFormat= dt.getUTCDate() + '_' + (dt.getUTCMonth() + 1) + '_'+ dt.getUTCFullYear() ;
			if(reportType=='PDF'){
				subpoint="PDF/downloadPDFBuyer";
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
				    a.download    = 'BuyerReport'+dtFormat+'.pdf';
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
				userBuyReportList = data;
				if (userBuyReportList.list.length != '' || userBuyReportList.list.length > 0) {
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
					progress = "No Record Found..";
				}
			}).error(function(serverRes, status, headers, config) {
				error = status + " Request failed";
				progress = "Error in Server Connection..Please Try Again.";
			});
		}

	};
});