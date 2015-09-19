define(['application-configuration', 'ajaxService'], function (app) {

    app.register.service('sysParamService', ['ajaxService', function (ajaxService) {
		
		this.sysParamTypeList   = [ {
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
			
		this.sysParamTypeMap   =  this.listToMap(this.sysParamTypeList);
		
        this.createSysParam = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "system/sysParamAdd", successFunction, errorFunction);
        };

        this.deleteSysParam = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "system/sysParamDelete", successFunction, errorFunction);
        };

        this.updateSysParam = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "system/sysParamEdit", successFunction, errorFunction);
        };

        this.getSysParams = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "system/sysParamList", successFunction, errorFunction);
        };

		this.getSysParam = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "system/sysParamDetail", successFunction, errorFunction);
        };
		
    }]);
});
