define(['application-configuration', 'ajaxService'], function (app) {

    app.register.service('projectUserService', ['ajaxService', function (ajaxService) {
		
	this.roleTypeList   = [ {
			"id":1,"name":"案场经理"
			},{
			"id":2,"name":"项目经理"
			},{
			"id":3,"name":"置业顾问"
			}];
	this.userStateList   = [ {
			"id":1,"name":"正常"
			},{
			"id":2,"name":"冻结"
			}];

	this.listToMap   =  function(list){
			var obj = {}
			for(var i=0, len=list.length; i<len; i++){
				obj[list[i].id] = list[i].name
			}
			return obj;
		};
			
	this.roleTypeMap   =  this.listToMap(this.roleTypeList);
	this.userStateMap   =  this.listToMap(this.userStateList);
		
        this.createProjectUser = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "caseManage/projectUserAdd", successFunction, errorFunction);
        };

        this.deleteProjectUser = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "caseManage/projectUserDelete", successFunction, errorFunction);
        };

        this.updateProjectUser = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "caseManage/projectUserEdit", successFunction, errorFunction);
        };

        this.getProjectUsers = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "caseManage/projectUserList", successFunction, errorFunction);
        };

	this.getProjectUser = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "caseManage/projectUserDetail", successFunction, errorFunction);
        };

	this.exportProjectUser = function (reqdata) {
            ajaxService.AjaxDownload(reqdata, "caseManage/projectUserExport");
        };
		
	this.getAllCompanyMap = function ( successFunction, errorFunction) {
            ajaxService.AjaxFormPost({},"caseManage/allCompanyMap", successFunction, errorFunction);
        };
		
		this.initData =function()
		{
			
			//初始化地市公司数据
			var self = this;
			this.getAllCompanyMap(function(response,state){
			
						if(state==200)
						{
							if (response.header.code == 0) {
									
									self.allCompanyMap = response.data;
									self.allCompanyList = self.mapToList(response.data);
									self.allCompanyList.unshift({"id":-1,"name":"全部"});
	
								} else {
									console.log(response.header);
								}
						}else{
						   console.log("请求地市公司数据错误1");
						}
					
					},function (){
						console.log("请求地市公司数据错误2");
					})
					
		};
		
    }]);
});
