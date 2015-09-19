define(['application-configuration', 'ajaxService'], function (app) {

    app.register.service('sysExportColumnService', ['ajaxService', function (ajaxService) {
		
		this.sysExportColumnTypeList   = [ {
			"id":1,"name":"常规"
			},{
			"id":2,"name":"通过map转换"
			},{
			"id":3,"name":"时间"
			}];


	   	this.listToMap   =  function(list){
			var obj = {}
			for(var i=0, len=list.length; i<len; i++){
				obj[list[i].id] = list[i].name
			}
			return obj;
		};
			
		this.sysExportColumnTypeMap   =  this.listToMap(this.sysExportColumnTypeList);
		
        this.createSysExportColumn = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "system/sysExportColumnAdd", successFunction, errorFunction);
        };

        this.deleteSysExportColumn = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "system/sysExportColumnDelete", successFunction, errorFunction);
        };

        this.updateSysExportColumn = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "system/sysExportColumnEdit", successFunction, errorFunction);
        };

        this.getSysExportColumns = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "system/sysExportColumnList", successFunction, errorFunction);
        };

		this.getSysExportColumn = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "system/sysExportColumnDetail", successFunction, errorFunction);
        };
		
    }]);
});
