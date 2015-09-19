define(['application-configuration', 'ajaxService'], function (app) {

    app.register.service('stationService', ['ajaxService', function (ajaxService) {
		
	this.stationTypeList   = [ {
			"id":1,"name":"系统角色"
			},{
			"id":2,"name":"案场角色"
			}];

	this.listToMap   =  function(list){
			var obj = {}
			for(var i=0, len=list.length; i<len; i++){
				obj[list[i].id] = list[i].name
			}
			return obj;
		};
			
	this.stationTypeMap   =  this.listToMap(this.stationTypeList);
		
        this.createStation = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "caseManage/stationAdd", successFunction, errorFunction);
        };

        this.deleteStation = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "caseManage/stationDelete", successFunction, errorFunction);
        };

        this.updateStation = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "caseManage/stationEdit", successFunction, errorFunction);
        };

        this.getStations = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "caseManage/stationList", successFunction, errorFunction);
        };
		
		 this.getStationTree = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "caseManage/stationTree", successFunction, errorFunction);
        };

	this.getStation = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "caseManage/stationDetail", successFunction, errorFunction);
        };

	this.exportStation = function (reqdata) {
            ajaxService.AjaxDownload(reqdata, "caseManage/stationExport");
        };
		
    }]);
});
