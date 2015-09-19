define(['application-configuration', 'ajaxService'], function (app) {

    app.register.service('roleService', ['ajaxService', function (ajaxService) {
		
		this.roleTypeList   = [ {
			"id":1,"name":"系统角色"
			},{
			"id":2,"name":"案场角色"
			}];
			
		this.roleTypeMap   =  function(roleTypeList){
			var obj = {}
			for(var i=0, len=roleTypeList.length; i<len; i++){
				obj[roleTypeList[i].id] = roleTypeList[i].name
			}
			return obj;
		}(this.roleTypeList);
		
        this.createRole = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "system/roleAdd", successFunction, errorFunction);
        };

        this.deleteRole = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "system/roleDelete", successFunction, errorFunction);
        };

        this.updateRole = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "system/roleEdit", successFunction, errorFunction);
        };

        this.getRoles = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "system/roleList", successFunction, errorFunction);
        };

		this.getRole = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "system/roleDetail", successFunction, errorFunction);
        };
		
    }]);
});