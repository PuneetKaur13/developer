mainApp.factory("AdminDashboardService", function($http, $location) {
	buyerBiddigList = [];
	sellerBiddigList = [];
	buyerByCityList = [];
	sellerByCityList = [];
	sessionProduct = "";
	return {
		getBuyerBiddigList : function() {
			return buyerBiddigList;
		},

		getSellerBiddigList : function() {
			return sellerBiddigList;
		},

		getBuyerByCityList : function() {
			return buyerByCityList;
		},

		getSellerByCityList : function() {
			return sellerByCityList;
		},

		getSessionProductDTO : function() {
			return sessionProduct;
		},

		buyerBiddigList : function() {
			progress = "Please Wait..";
			var subpoint = "/OCBS/rest/BuyerBidding/searchforMap";
			$http({
				method : 'GET',
				url : subpoint
			}).success(function(data, status, headers, config) {
				buyerBiddigList = data;
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},

		sellerBiddigList : function() {
			progress = "Please Wait..";
			var subpoint = "/OCBS/rest/SellerBidding/searchforMap";
			$http({
				method : 'GET',
				url : subpoint
			}).success(function(data, status, headers, config) {
				sellerBiddigList = data;
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},

		showBuyerByCity : function(city) {
			progress = "Please Wait..";
			var subpoint = "/OCBS/rest/BuyerBidding/searchByCity/" + city;
			$http({
				method : 'GET',
				url : subpoint
			}).success(function(data, status, headers, config) {
				buyerByCityList = data;
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},

		showSellerByCity : function(city) {
			progress = "Please Wait..";
			var subpoint = "/OCBS/rest/SellerBidding/searchByCity/" + city;
			$http({
				method : 'GET',
				url : subpoint
			}).success(function(data, status, headers, config) {
				sellerByCityList = data;
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
				progress = "Error in Server Connection.. Please Try Again.";
			});
		},

		setSessionProduct : function(productId) {
			progress = "Please Wait..";
			var subpoint = "/OCBS/rest/AdminProduct/setSessionProduct/"
					+ productId;
			$http({
				method : 'GET',
				url : subpoint
			}).success(function(data, status, headers, config) {
				$location.path("Dashboard");
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
			});
		},

		setUserType : function(type) {
			progress = "Please Wait..";
			var subpoint = "/OCBS/rest/Users/setUserType/" + type;
			$http({
				method : 'GET',
				url : subpoint
			}).success(function(data, status, headers, config) {
				// window.location.reload(true); 
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
			});
		},

		getSessionProduct : function() {
			progress = "Please Wait..";
			var subpoint = "/OCBS/rest/AdminProduct/getSessionProduct";
			$http({
				method : 'GET',
				url : subpoint
			}).success(function(data, status, headers, config) {
				sessionProduct = data;
			}).error(function(data, status, headers, config) {
				error = status + "Request Failed";
			});
		},

	};
});