define(['application-configuration', 'ajaxService'], function (app) {

    app.register.service('teamService', ['ajaxService', function (ajaxService) {
		
	this.teamStateList   = [ {
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
			
	this.teamStateMap   =  this.listToMap(this.teamStateList);
		
        this.createTeam = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "caseManage/teamAdd", successFunction, errorFunction);
        };

        this.deleteTeam = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "caseManage/teamDelete", successFunction, errorFunction);
        };

        this.updateTeam = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "caseManage/teamEdit", successFunction, errorFunction);
        };

        this.getTeams = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "caseManage/teamList", successFunction, errorFunction);
        };

	this.getTeam = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "caseManage/teamDetail", successFunction, errorFunction);
        };

	this.exportTeam = function (reqdata) {
            ajaxService.AjaxDownload(reqdata, "caseManage/teamExport");
        };
		
    }]);
});
