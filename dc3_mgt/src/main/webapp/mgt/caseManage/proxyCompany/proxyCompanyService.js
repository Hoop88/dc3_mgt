define(['application-configuration', 'ajaxService'], function (app) {

    app.register.service('proxyCompanyService', ['ajaxService', function (ajaxService) {
		
	this.proxyCompanyStateList   = [ {
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
			
		this.proxyCompanyStateMap   =  this.listToMap(this.proxyCompanyStateList);
		
        this.createProxyCompany = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "caseManage/proxyCompanyAdd", successFunction, errorFunction);
        };

        this.deleteProxyCompany = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "caseManage/proxyCompanyDelete", successFunction, errorFunction);
        };

        this.updateProxyCompany = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "caseManage/proxyCompanyEdit", successFunction, errorFunction);
        };

        this.getProxyCompanys = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "caseManage/proxyCompanyList", successFunction, errorFunction);
        };
		
		this.getCityProjectTree = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "caseManage/cityProjectTree", successFunction, errorFunction);
        };
		
		this.setCityProjectTree= function(list){
			this.cityProjectTree = list;
		};

		this.getProxyCompany = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "caseManage/proxyCompanyDetail", successFunction, errorFunction);
        };

		this.exportProxyCompany = function (reqdata) {
            ajaxService.AjaxDownload(reqdata, "caseManage/proxyCompanyExport");
        };
		
		this.getProjectCodeMap1 = function (successFunction, errorFunction) {
            ajaxService.AjaxFormPost({}, "caseManage/projectCodeMap1", successFunction, errorFunction);
        };
		
		this.initData =function()
		{	
			var self = this;
			//初始化数据
			this.getProjectCodeMap1(function(response,state){
				
						if(state==200)
						{
							if (response.header.code == 0) {
									self.projectCodeMap1 = response.data;
									
								} else {
									console.log(response.header);
								}
						}else{
						   console.log("请求地市公司数据错误");
						}
					
					},function (){
						console.log("请求地市公司数据错误");
					})	
		}
		
    }]);
});
