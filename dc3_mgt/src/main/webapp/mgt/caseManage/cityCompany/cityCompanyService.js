define(['application-configuration', 'ajaxService'], function (app) {

    app.register.service('cityCompanyService', ['ajaxService', function (ajaxService) {
		
	this.cityCompanyStateList   = [ {
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
			
	this.cityCompanyStateMap   =  this.listToMap(this.cityCompanyStateList);
		
        this.createCityCompany = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "caseManage/cityCompanyAdd", successFunction, errorFunction);
        };

        this.deleteCityCompany = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "caseManage/cityCompanyDelete", successFunction, errorFunction);
        };

        this.updateCityCompany = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "caseManage/cityCompanyEdit", successFunction, errorFunction);
        };

        this.getCityCompanys = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "caseManage/cityCompanyList", successFunction, errorFunction);
        };

	this.getCityCompany = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "caseManage/cityCompanyDetail", successFunction, errorFunction);
        };

	this.exportCityCompany = function (reqdata) {
            ajaxService.AjaxDownload(reqdata, "caseManage/cityCompanyExport");
        };
		
    }]);
});
