var DashboardModel = function(isScreenSmaller) {

};

$(function() {
	var isScreenSmaller = window.innerWidth < 768;
	var dashboardModel = new DashboardModel(isScreenSmaller);
	ko.applyBindings(dashboardModel);
});