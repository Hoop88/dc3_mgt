define(['application-configuration', 'ajaxService'], function (app) {

    app.register.service('sysExportService', ['ajaxService', function (ajaxService) {
		
		this.sysExportTypeList   = [ {
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
			
		this.sysExportTypeMap   =  this.listToMap(this.sysExportTypeList);
		
        this.createSysExport = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "system/sysExportAdd", successFunction, errorFunction);
        };

        this.deleteSysExport = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "system/sysExportDelete", successFunction, errorFunction);
        };

        this.updateSysExport = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "system/sysExportEdit", successFunction, errorFunction);
        };

        this.getSysExports = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "system/sysExportList", successFunction, errorFunction);
        };

		this.getSysExport = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "system/sysExportDetail", successFunction, errorFunction);
        };
		
    }]);
});
