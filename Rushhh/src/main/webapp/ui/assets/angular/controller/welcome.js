mainApp.controller("WelcomeController", function($scope, $location, $window,
		HomeService) {

	var self = this;
	var type = "SELL";
	var typew = "BUY";

	self.setSessionProduct = function(productId) {
		HomeService.setSessionProduct(productId);
	};

	self.box = function() {

		bootbox.confirm({

			message : "Do you want to ?",

			buttons : {
				confirm : {
					label : 'SELL',
					className : 'btn-success',
					//value : 'SELL',
					action : function() {
					}
				},
				cancel : {
					label : 'BUY',
					className : 'btn-primary pull-left',
					//value : 'BUY'
				}
			},
			callback : function(result) {
				if (result == true) {
					HomeService.setUserType("SELL");
					$window.location.assign('#/Dashboard');
				} else {
					HomeService.setUserType("BUY");
					$window.location.assign('#/Dashboard');
				}

			},
		});
	};

});