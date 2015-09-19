define(['application-configuration', 'ajaxService'], function (app) {

    app.register.service('caseUserService', ['ajaxService', function (ajaxService) {
		
	this.caseUserTypeList   = [ {
			"id":1,"name":"地产员工"
			},{
			"id":2,"name":"代理员工"
			}];
			
	this.caseUserStateList   = [ {
			"id":1,"name":"正常"
			},{
			"id":2,"name":"冻结"
			}];
			
    this.caseJobStateList   = [ {
			"id":0,"name":"在岗"
			},{
			"id":1,"name":"申请离职"
			},{
			"id":2,"name":"离职办理"
			},{
			"id":3,"name":"已离职"
			}];

	this.listToMap   =  function(list){
			var obj = {}
			for(var i=0, len=list.length; i<len; i++){
				obj[list[i].id] = list[i].name
			}
			return obj;
		};
	
	this.mapToList   =  function(map){
		    var list=[];
			for(var key in map){
				var obj = {};
				obj.id = parseInt(key);
				obj.name=map[key];
				list.push(obj);
			}
			return list;
	};
			
	this.caseUserTypeMap   =  this.listToMap(this.caseUserTypeList);
	this.caseUserStateMap   =  this.listToMap(this.caseUserStateList);
	this.caseJobStateMap   =  this.listToMap(this.caseJobStateList);
		
        this.createCaseUser = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "caseManage/caseUserAdd", successFunction, errorFunction);
        };

        this.deleteCaseUser = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "caseManage/caseUserDelete", successFunction, errorFunction);
        };

        this.updateCaseUser = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "caseManage/caseUserEdit", successFunction, errorFunction);
        };

        this.getCaseUsers = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "caseManage/caseUserList", successFunction, errorFunction);
        };

	this.getCaseUser = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "caseManage/caseUserDetail", successFunction, errorFunction);
        };
		
		this.getAllCompanyMap = function ( successFunction, errorFunction) {
            ajaxService.AjaxFormPost({},"caseManage/allCompanyMap", successFunction, errorFunction);
        };
		
	

	this.exportCaseUser = function (reqdata) {
            ajaxService.AjaxDownload(reqdata, "caseManage/caseUserExport");
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
