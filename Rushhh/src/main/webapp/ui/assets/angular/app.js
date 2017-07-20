var mainApp = angular.module('mainApp',
		[ 'ngRoute', 'checklist-model', 'ngUpload', '720kb.datepicker',
				'angular-media-preview', 'anguFixedHeaderTable', 'ngMap',
				'ui.utils.masks', 'directive.g+signin' ]);

mainApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/Home', {
		templateUrl : 'pages/welcome.jsp',
		controller : 'PropertyController as ctl'
	}).when('/Dashboard', {
		templateUrl : 'pages/home.jsp',
		controller : 'HomeController as ctl'
	}).when('/AdminDashboard', {
		templateUrl : 'pages/adminDashboard.jsp',
		controller : 'AdminDashboardController as ctl'
	}).when('/Login', {
		templateUrl : 'pages/login.jsp',
		controller : 'LoginController as ctl'
	}).when('/ForgetPassword', {
		templateUrl : 'pages/forgetPassword.jsp',
		controller : 'ForgetPasswordController as ctl'
	}).when('/UserRegistration', {
		templateUrl : 'pages/userRegistration.jsp',
		controller : 'UserRegistrationController as ctl'
	}).when('/EditMyProfile', {
		templateUrl : 'pages/editMyProfile.jsp',
		controller : 'EditMyProfileController as ctl'
	}).when('/ChangePassword', {
		templateUrl : 'pages/changePassword.jsp'
	}).when('/User', {
		templateUrl : 'pages/userMaster.jsp',
		controller : 'UserMasterController as ctl'
	}).when('/OTP', {
		templateUrl : 'pages/otp.jsp',
		controller : 'OTPController as ctl'
	}).when('/UserCompanyRegistration', {
		templateUrl : 'pages/userCompanyRegister.jsp',
		controller : 'UserCompanyRegisterController as ctl'
	}).when('/UserDetail', {
		templateUrl : 'pages/userDetail.jsp',
		controller : 'UserCompanyMasterController as ctl'
	}).when('/Role', {
		templateUrl : 'pages/role.jsp',
		controller : 'RoleController as ctl'
	}).when('/AboutUs', {
		templateUrl : 'pages/about.jsp',
	}).when('/ContactUs', {
		templateUrl : 'pages/contactus.jsp',
	}).when('/Feedback', {
		templateUrl : 'pages/Feedback.jsp',
		controller: 'FeedbackController as ctl'
	}).when('/Preferences', {
		templateUrl : 'pages/preferences.jsp',
	}).when('/Account', {
		templateUrl : 'pages/accountMaster.jsp',
		controller : 'AccountMasterController as ctl'
	}).when('/Transaction', {
		templateUrl : 'pages/transactionMaster.jsp',
		controller : 'TransactionMasterController as ctl'
	}).when('/Message', {
		templateUrl : 'pages/message.jsp',
		controller : 'MessageController as ctl'
	}).when('/Notification', {
		templateUrl : 'pages/notification.jsp',
		controller : 'NotificationController as ctl'
	}).when('/SystemSetting', {
		templateUrl : 'pages/systemSetting.jsp',
		controller : 'SystemSettingController as ctl'
	}).when('/State', {
		templateUrl : 'pages/state.jsp',
		controller : 'StateController as ctl'
	}).when('/City', {
		templateUrl : 'pages/city.jsp',
		controller : 'CityController as ctl'
	}).when('/LiveBids', {
		templateUrl : 'pages/liveBids.jsp',
		controller : 'LiveBidController as ctl'
	}).when('/HomeLive', {
		templateUrl : 'pages/homeLive.jsp',
		controller : 'HomeLiveBidController as ctl'
	}).when('/BannerManagement', {
		templateUrl : 'pages/bannerManagement.jsp',
		controller : 'BannerManagementController as ctl'
	}).when('/CompanyManagement', {
		templateUrl : 'pages/companyManagement.jsp',
		controller : 'CompanyManagementController as ctl'
	}).when('/CampaignManagement', {
		templateUrl : 'pages/campaignManagement.jsp',
		controller : 'CampaignManagementController as ctl'
	}).when('/AdminReport', {
		templateUrl : 'pages/adminStatistics.jsp',
		controller : 'AdminReportController as ctl'
	}).when('/UserSellReport', {
		templateUrl : 'pages/userSellReport.jsp',
		controller : 'UserReportController as ctl'
	}).when('/UserBuyReport', {
		templateUrl : 'pages/userBuyReport.jsp',
		controller : 'UserBuyReportController as ctl'
	}).when('/AdminSellReport', {
		templateUrl : 'pages/adminSellReport.jsp',
		controller : 'AdminSellReportController as ctl'
	}).when('/AdminBuyReport', {
		templateUrl : 'pages/adminBuyReport.jsp',
		controller : 'AdminBuyReportController as ctl'
	}).when('/DealProduct', {
		templateUrl : 'pages/dealProduct.jsp',
		controller : 'CompanyProductIntersectionController as ctl'
	}).when('/MessageCenter', {
		templateUrl : 'pages/messageCenter.jsp',
		controller : 'MessageCenterController as ctl'
	}).when('/AdminUserMaster', {
		templateUrl : 'pages/adminUserMaster.jsp',
		controller : 'AdminUserMasterController as ctl'
	}).when('/Help', {
		templateUrl : 'pages/help.jsp'
	}).when('/ChangePassword', {
		templateUrl : 'pages/changePassword.jsp',
		controller : 'ChangeMyPasswordController as ctl'
	}).when('/CardType', {
		templateUrl : 'pages/cardType.jsp',
		controller : 'CardTypeController as ctl'
	}).when('/Property', {
		templateUrl : 'pages/property.jsp',
		controller : 'PropertyController as ctl'
	}).when('/UserCardManagement', {
		templateUrl : 'pages/userCardManagement.jsp',
		controller : 'UserCardManagementController as ctl'
	}).when('/Agent', {
		templateUrl : 'pages/agent.jsp',
		controller : 'AgentController as ctl'
	}).when('/AddProperty', {
		templateUrl : 'pages/addProperty.jsp',
		controller : 'AddPropertyController as ctl'
	}).otherwise({
		redirectTo : '/Home'
	}).when('/Unit', {
		templateUrl : 'pages/unit.jsp',
		controller : 'UnitController as ctl'
	}).when('/PropertyFor', {
		templateUrl : 'pages/propertyFor.jsp',
		controller : 'PropertyForController as ctl'
	}).when('/PropertyFor/:id', {
		templateUrl : 'pages/propertyFor.jsp',
		controller : 'PropertyForController as ctl'
	}).when('/PropertyType', {
		templateUrl : 'pages/propertyType.jsp',
		controller : 'PropertyTypeController as ctl'
	}).when('/Projects', {
		templateUrl : 'pages/projects.jsp',
		controller : 'PropertyTypeController as ctl'
	}).when('/PostFreeProperty', {
		templateUrl : 'pages/postFreeAD.jsp',
		controller : 'PostFreeADController as ctl'
	}).when('/PropertyDescription', {
		templateUrl : 'pages/propertyDescription.jsp',
		controller : 'PostFreeADController as ctl'
	});

} ]);

mainApp.directive('fileModel', [ '$parse', function($parse) {
	return {
		restrict : 'A',
		link : function(scope, element, attrs) {
			var model = $parse(attrs.fileModel);
			var modelSetter = model.assign;

			element.bind('change', function() {
				scope.$apply(function() {
					modelSetter(scope, element[0].files[0]);
				});
			});
		}
	};
} ]);

mainApp.filter('dateFilter', function($filter) {
	return function(dateString, format) {
		if (dateString === '0000-00-00') {
			return "";
		} else {
			return $filter('date')(dateString, format.toString());
		}
	};
});

mainApp.controller('BaseController', function($scope, $interval, $location,
		UserService, WatchService, BaseService, ControllerService) {
	var self = this;
	self.form = {};

	$scope.linkToDescription = function() {
		$location.path("PropertyDescription");
	}

	// UserService.checkSession();

	$scope.$watch(WatchService.getNotificationCount, function(newVal) {
		$scope.getNotificationCount();
	}, true);

	$scope.notificationCount = 0;
	$scope.getNotificationCount = function() {
		UserService.getNotificationList();
	}

	$scope.$watch(UserService.getNotificationList, function(newVal) {
		self.notificationList = newVal;
		for (var int = 0; int < notificationList.length; int++) {
			console.log(notificationList[int])

			$scope.notificationCount = notificationList[int];
		}
		self.success = "";
	}, true);

	// Get notification count of user
	$scope.$watch(UserService.getLogoutMsg, function(newVal) {
		var msg = newVal;
		if (msg != '') {
			if (msg.success) {
				window.location = "#/Login";
				location.reload(1);
			}
		}
	}, true);

	$scope.checkSession = function() {
		var endPoint = endPoint = "/Rushhh/rest/Users/checkSession";
		BaseService.callEndPoint(endPoint, null).then(function(data) {
			$scope.sessionCheck = data.success;
			if (!data.success) {
				$location.path("Dashborad");
			}
		});
	};

	$scope.$watch(UserService.getProgress, function(newVal) {
		self.progress = newVal;
	}, true);

	self.checkSession = function() {
		UserService.checkSession();
		UserService.getLogoutMsg();
	};

	$scope.logout = function() {
		UserService.logout();
		UserService.getLogoutMsg();
	};

	$scope.changeType = function(type) {
		UserService.changeType(type);
	};

	// Notification count initialization
	$scope.notificationCount = 0;

	$scope.getNotificationCount = function() {
		var endPoint = "/Rushhh/rest/Notification/getNotificationCount";
		BaseService.callEndPoint(endPoint, self.form).then(function(data) {
			$scope.notificationCount = data.list.length;
			console.log(data.list.length);
		});
	};

	$scope.getNotificationCount();

	$scope.$on('event:google-plus-signin-success', function(event, authResult) {
		console.log(authResult.w3);
		var w3 = authResult.w3;
		var user = {
			"firstName" : w3.ofa,
			"lastName" : w3.wea,
			"loginId" : w3.U3,
			"email" : w3.U3,
			"imagePath" : w3.paa
		};

		var endPoint = "/Rushhh/rest/Users/authenticationGoogle";
		BaseService.callEndPoint(endPoint, user).then(function(data) {
			console.log(data);
		});

	});

	$scope.$on('event:google-plus-signin-failure', function(event, authResult) {
		// User has not authorized the G+ App!
		console.log('Not signed into Google Plus.');
		console.log(authResult);
	});
	
	
});

mainApp.factory("WatchService", function() {
	var accountBalance = 0;
	var notificationCount = 0;

	return {

		getAccountBalance : function() {
			return accountBalance;
		},

		setAccountBalance : function(ab) {
			accountBalance = ab;
		},

		getNotificationCount : function() {
			return notificationCount;
		},

		setNotificationCount : function(nc) {
			notificationCount = nc;
		}
	}

});

mainApp.factory("BaseService", function($http, $q, UserService) {

	var endpoint = "";
	var searchPoint = "";
	var getPoint = "";
	var addPoint = "";
	var updatePoint = "";
	var deletePoint = "";
	var uploadPoint = "";

	return {

		setEndPoint : function(ep) {
			endpoint = ep;
			searchPoint = endpoint + "/search";
			getPoint = endpoint + "/get/";
			addPoint = endpoint + "/add";
			updatePoint = endpoint + "/edit";
			deletePoint = endpoint + "/delete/";
			uploadPoint = endpoint + "/upload/";

		},

		find : function(obj) {
			return this.callEndPoint(searchPoint, obj);

		},

		get : function(id) {
			var subpoint = getPoint + id;
			return this.callEndPoint(subpoint, id);
		},

		saveOrUpdate : function(form) {
			var subpoint = addPoint;

			if (form.id > 0) {
				subpoint = updatePoint;
			}
			return this.callEndPoint(subpoint, form);
		},

		remove : function(checkId) {
			var subpoint = deletePoint + checkId;
			return this.callEndPoint(subpoint, checkId);
		},

		upload : function(form) {
			return this.uploadEndPoint(uploadPoint, form);
		},

		// Make a post request to endpoint
		callEndPoint : function(subpoint, form) {
			var def = $q.defer();
			$http({
				method : 'POST',
				url : subpoint,
				data : form
			}).then(function(response) {
				def.resolve(response.data);
			}, function(response) {
				def.resolve(response.data);
			});

			return def.promise;
		},

		// Make a upload request to endpoint
		uploadEndPoint : function(subpoint, form) {
			var def = $q.defer();
			var fd = new FormData();
			var url = subpoint;
			fd.append('file', form.file);
			fd.append("form", angular.toJson(form.data));
			$http.post(url, fd, {
				withCredentials : false,
				transformRequest : angular.identity,
				headers : {
					'Content-Type' : undefined
				},
				data : angular.toJson(form.data)
			}).then(function(response) {
				def.resolve(response.data);
			}, function(response) {
				def.resolve(response.data);
			});
			return def.promise;
		}

	};
});

mainApp
		.factory(
				"ControllerService",
				function(BaseService) {

					return {

						setEndPoint : function(endPoint) {
							// Initialize controller
							BaseService.setEndPoint(endPoint);
						},
						// Apply filters and get list elements
						search : function(ctl) {
							ctl.searchMessage = "Please Wait..";
							BaseService
									.find(ctl.searchData)
									.then(
											function(data) {
												ctl.dataList = data;
												if (ctl.dataList.list == null
														|| ctl.dataList.list.length == 0) {
													ctl.success = false;
													ctl.searchMessage = "No Record Found.";
													ctl.button.remove = false;
													ctl.button.go = false;
												} else {
													ctl.searchMessage = null;
													ctl.button.remove = true;
													ctl.button.go = true;

													// Enable pagination next
													// button after search
													if (ctl.searchData.pageNo == null) {
														ctl.searchData.pageNo = 1;
													}
													ctl.index = (ctl.searchData.pageNo - 1) * 10;
													if (ctl.dataList.pageNoList != null
															&& ctl.dataList.pageNoList.length == ctl.searchData.pageNo) {
														ctl.button.next = false;
													} else {
														ctl.button.next = true;
													}
													// Enable pagination
													// previous button after
													// search
													if (ctl.searchData.pageNo == 1) {
														ctl.button.previous = false;
													} else {
														ctl.button.previous = true;
													}

												}
												if (ctl.dataList.form != null) {
													ctl.searchData = ctl.dataList.form;
												}
											});
						},

						// Handles next event of pagination
						next : function(ctl) {
							ctl.searchData.pageNo++;
							ctl.search();
						},

						// Handles previous event of pagination
						previous : function(ctl) {
							ctl.searchData.pageNo--;
							ctl.search();
						},

						// Displays add/edit record
						display : function(id, ctl) {
							ctl.resetForm();
							// Fetch data if id is greater than 0
							if (id > 0) {
								BaseService.get(id).then(function(data) {
									ctl.form = data.form;
									ctl.message = null;
								});
							}
						},

						// Submits data and add/edit record
						submit : function(ctl) {
							ctl.message = "Please Wait..";
							BaseService.saveOrUpdate(ctl.form).then(
									function(data) {
										ctl.message = data.message;
										ctl.success = data.success;
										ctl.search();
									});
						},

						// Upload attach file
						upload : function(form) {
							var fileName = "";
							BaseService.upload(form).then(function(data) {
								fileName = data.message;
								form.uploadedFileName = fileName;
							});
						},

						// Remove selected items from list
						removeAll : function(ctl) {
							if (ctl.checkedData.del.length > 0) {
								BaseService.remove(ctl.checkedData.del + "")
										.then(function(data) {
											ctl.checkedData.del = [];
											ctl.message = data.message;
											ctl.success = data.success;
											ctl.search();
										});
							} else {
								ctl.success = false;
								ctl.searchMessage = "Please select at least one checkbox.";
							}
						},

						getButtonObject : function() {
							// Enables or disables view buttons
							return {
								"add" : true,
								"remove" : true,
								"search" : true,
								"go" : true,
								"next" : true,
								"previous" : true
							};
						},

						getSearchObject : function(obj) {
							obj.pageNo = 1;
							obj.pageSize = 10;
							return obj
						},

						getCtlObjects : function(ctl) {

							// DTO Object contains dto data need to be edited or
							// added
							ctl.form = {};

							// Contains list of records
							ctl.dataList = [];

							// Contains ids of selected items from list
							ctl.checkedData = {
								del : []
							};

							// Contains success or error message
							ctl.message = null;

							// Contains success or error message
							ctl.searchMessage = null;

							// Contains boolean value true if
							// add/edit/delete/list operation is
							// successful
							ctl.success = true;

							// Enables or disables view buttons
							ctl.button = this.getButtonObject();

							var self = this;

							// Apply filters and get list elements
							ctl.search = function() {
								self.search(ctl);

							};

							// Handles next event of pagination
							ctl.next = function() {
								self.next(ctl);
							};

							// Handles previous event of pagination
							ctl.previous = function() {
								self.previous(ctl);
							};

							// Displays add/edit record
							ctl.display = function(id) {
								self.display(id, ctl);
							};

							// Submits data and add/edit record
							ctl.submit = function() {
								self.submit(ctl);
							};

							// Remove selected items from list
							ctl.removeAll = function() {
								self.removeAll(ctl);
							};

						},

						// Initialize form
						resetForm : function(ctl, obj) {
							ctl.form = obj;
							$('#fileUser').val('');
							ctl.message = null;
							ctl.searchMessage = null;
							ctl.success = true;
						}

					}
				});

mainApp
		.directive(
				'myMap',
				function() {
					// directive link function
					var link = function(scope, element, attrs) {
						var map, infoWindow;
						var markers = [];

						// map config
						var mapOptions = {
							center : new google.maps.LatLng(22.7144513,
									75.8715451),
							zoom : 4,
							mapTypeId : google.maps.MapTypeId.ROADMAP,
							scrollwheel : false
						};

						// init the map
						function initMap() {
							if (map === void 0) {
								map = new google.maps.Map(element[0],
										mapOptions);
							}
						}
						// place a marker
						function setMarker(map, position, title, content) {
							var marker;
							var markerOptions = {
								position : position,
								map : map,
								title : title,
								icon : 'https://maps.google.com/mapfiles/ms/icons/green-dot.png'
							};

							marker = new google.maps.Marker(markerOptions);
							markers.push(marker); // add marker to array

							google.maps.event
									.addListener(
											marker,
											'click',
											function() {
												// close window if not undefined
												if (infoWindow !== void 0) {
													infoWindow.close();
												}
												// create new window
												var infoWindowOptions = {
													content : content
												};
												infoWindow = new google.maps.InfoWindow(
														infoWindowOptions);
												infoWindow.open(map, marker);
											});
						}

						// show the map and place some markers
						initMap();
						var map;
						var myCenter = new google.maps.LatLng(53, -1.33);
						var marker = new google.maps.Marker({
							position : myCenter
						});

						function initialize() {
							var mapProp = {
								center : myCenter,
								zoom : 14,
								draggable : false,
								scrollwheel : false,
								mapTypeId : google.maps.MapTypeId.ROADMAP
							};

							map = new google.maps.Map(document
									.getElementById("map-canvas"), mapProp);
							marker.setMap(map);

							google.maps.event.addListener(marker, 'click',
									function() {

										infowindow.setContent(contentString);
										infowindow.open(map, marker);

									});
						}
						;

						function setMapOnAll(map) {
							for (var i = 0; i < markers.length; i++) {
								markers[i].setMap(map);
							}
						}
						;

						google.maps.event.addDomListener(window, 'load',
								initialize);

						google.maps.event.addDomListener(window, "resize",
								resizingMap());

						$("#projectLocations")
								.on(
										"click",
										function() {
											var mapOptions = {
												center : new google.maps.LatLng(
														scope.markarr[0].lattitude,
														scope.markarr[0].longitude),
												zoom : 4,
												mapTypeId : google.maps.MapTypeId.ROADMAP,
												scrollwheel : false
											};

											map = new google.maps.Map(
													element[0], mapOptions);
											setMapOnAll(null);
											for (i = 0; i < scope.markarr.length; i++) {
												var m = scope.markarr[i];
												setMarker(map,
														new google.maps.LatLng(
																m.lattitude,
																m.longitude),
														m.name, 'More content');
											}
											resizeMap();
										})

						$('#gmapModal')
								.on(
										'show.bs.modal',
										function() {
											if (scope.op == 'Site') {
												var mapOptions = {
													center : new google.maps.LatLng(
															scope.let,
															scope.long),
													zoom : 2,
													mapTypeId : google.maps.MapTypeId.ROADMAP,
													scrollwheel : false
												};
												map = new google.maps.Map(
														element[0], mapOptions);
												setMapOnAll(null);
												setMarker(map,
														new google.maps.LatLng(
																scope.let,
																scope.long),
														scope.name,
														'More content');
												resizeMap();
											}
											if (scope.op == 'Project') {
												var mapOptions = {
													center : new google.maps.LatLng(
															scope.markarr[0].lattitude,
															scope.markarr[0].longitude),
													zoom : 2,
													mapTypeId : google.maps.MapTypeId.ROADMAP,
													scrollwheel : false
												};

												map = new google.maps.Map(
														element[0], mapOptions);
												setMapOnAll(null);
												for (i = 0; i < scope.markarr.length; i++) {
													var m = scope.markarr[i];
													setMarker(
															map,
															new google.maps.LatLng(
																	m.lattitude,
																	m.longitude),
															m.name,
															'More content');
												}
												resizeMap();
											}
										})

						function resizeMap() {
							if (typeof map == "undefined")
								return;
							setTimeout(function() {
								resizingMap();
							}, 400);
						}

						function resizingMap() {
							if (typeof map == "undefined")
								return;
							var center = map.getCenter();
							google.maps.event.trigger(map, "resize");
							map.setCenter(center);
						}

					};

					return {
						restrict : 'A',
						template : '<div id="gmaps"></div>',
						replace : true,
						link : link,
						scope : {
							let : '@let',
							long : '@long',
							name : '@name',
							op : '@op',
							markarr : '='
						},
					};
				});
