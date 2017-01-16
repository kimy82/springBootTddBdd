var DashboardModel = function(isScreenSmaller) {
	this.ajaxResultTemplate = _.template("<div class='<%= cssclass %>'><p><strong><%= message %></strong></p></div>");
	this.usersTab = ko.observable(false);

	this.showUsersTab = function(){
		this.usersTab(true);
	}.bind(this);

	
	this.togglemenu = function() {
		$(".wrapper").toggleClass("toggled");
		$(".top-menu").toggleClass("toggled");
	};
	
	this.showAjaxResult = function(cssclass, message, e, stickToParent, callback){
		var ajaxResultDiv = this.ajaxResultTemplate({cssclass: cssclass, message: message});
		
		if(stickToParent){
			$(e.target).parent().parent().append(ajaxResultDiv);
		}else{
			$(e.target).append(ajaxResultDiv);
		}
		
		setTimeout(function(){
			var theEl = $(e.target);
			if(stickToParent){
				theEl = theEl.parent().parent();
			}
			
			theEl.find("." + cssclass).fadeOut(400, function(){
				$(this).remove();
				if(callback !== undefined){
					callback.call();
				}
			});
		}, 2000);
	}
	
	/**
	 * Request user info to the server an opens the popup
	 */
	this.showUserInfo =  function(id, _self){
		$.ajax({
			url : "/admin/users-info/" + id,
			data : {},
			type : "get",
			dataType : 'html',
			xhrFields : {
				withCredentials : true
			},
			success : function(data) {
				ko.cleanNode(document.getElementById("user-info-box"));
				$("#user-info-box").html(data);
				ko.applyBindings(_self, document.getElementById("user-info-box"));
				$("#userModal").modal('show');
			},
			error : function() {
				throw "No reload table with id user-info-box";
			}
		});
	}.bind(this);
	
	/**
	 * Must be implemented for pagination model
	 */
	this.getRealoadQueryData = function(){
		return {};
	}
	
	if(isScreenSmaller){
		this.togglemenu();
	}
};


$(function() {
	var isScreenSmaller = window.innerWidth < 768;
	var dashboardModel = new DashboardModel(isScreenSmaller);

	$(window).resize(function(){
		if(window.innerWidth < 768 && !$(".wrapper").hasClass("toggled")){
			dashboardModel.togglemenu();
		}
	});
	
	ko.applyBindings(dashboardModel);
});
