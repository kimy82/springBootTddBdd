var PaginationModel = function(idTableReload, userItemsPerPage, sortType, getRealoadQueryDataFunction, selfName) {
	
	this.reloadTable = function(url, data, _self){
		$.ajax({
			url : url,
			data : data,
			type : "get",
			dataType : 'html',
			xhrFields : {
				withCredentials : true
			},
			success : function(data) {
				ko.cleanNode(document.getElementById(idTableReload));
				$("#" + idTableReload).html(data);
				ko.applyBindings(_self, document.getElementById(idTableReload));
			},
			error : function() {
				throw "No reload table with id" + idTableReload;
			}
		});
	};
	
	this.itemsPerPage = ko.observable(userItemsPerPage);
	this.sortField = ko.observable(sortType);
	this.getRealoadQueryData = getRealoadQueryDataFunction;
	
	this.gotoPage = function(url,_self){
		var completeUrl = url + "/"+ _self[selfName].itemsPerPage();
		var data = _self[selfName].getReloadQueryDataWithSort(_self);
		_self[selfName].reloadTable(completeUrl, data, _self);
	}.bind(this);
	
	this.gotoPageWithI = function(url, i,_self){
		var completeUrl = url + "/" + i + "/" + _self[selfName].itemsPerPage();
		var data = _self[selfName].getReloadQueryDataWithSort(_self);
		_self[selfName].reloadTable(completeUrl, data, _self);
	}.bind(this);
	
	this.changedItemsPerPage = function(url, currentPage,  _self){
		var completeUrl = url + "/0/" + _self[selfName].itemsPerPage();
		var data = _self[selfName].getReloadQueryDataWithSort(_self);
		_self[selfName].reloadTable(completeUrl,data, _self);
	}.bind(this);
	
	this.sort = function(field, url, _self, e) {
		_self.fillsort(field, _self[selfName].sortField);
		var data = _self[selfName].getReloadQueryDataWithSort(_self);
		var completeUrl = url + "/0/" + _self[selfName].itemsPerPage();
		_self[selfName].reloadTable(completeUrl, data,  _self);
	}.bind(this);
	
	this.getReloadQueryDataWithSort = function(_self){
		var data = _self.getRealoadQueryData(_self);
		data.sort = _self[selfName].sortField();
		return data;
	};
	
	this.filterBy = function(url, _self){
		var completeUrl = url + "/0/"+ _self[selfName].itemsPerPage();
		var data = _self[selfName].getReloadQueryDataWithSort(_self);
		_self[selfName].reloadTable(completeUrl, data,  _self);
	}.bind(this);

};
