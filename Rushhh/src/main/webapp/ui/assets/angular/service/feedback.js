mainApp.factory("FeedbackService", function($http) {
	formData = [];
	successMsg = "";
	authMsg = "";

	var endpoint = "/OCBS/rest/Feedback";

	return {

		getFormData : function() {
			return formData;
		},

		getSuccessMsg : function() {
			return successMsg;
		},

		getAuthMsg : function() {
			return authMsg;
		},
		
});