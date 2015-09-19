define(['application-configuration', 'ajaxService'], function (app) {

    app.register.service('mainService', ['ajaxService', function (ajaxService) {
                 
        /*this.initializeApplication = function (successFunction, errorFunction) {
            ajaxService.AjaxGet("/api/main.ashx?action=initializeApplication", successFunction, errorFunction);           
        };*/
    
        this.authenicateUser = function (successFunction, errorFunction) {
            console.log(successFunction);
            console.log(errorFunction);
            //debugger;
            ajaxService.AjaxGet("api/main/AuthenicateUser.json", successFunction, errorFunction);
        };

        this.logout = function (successFunction, errorFunction) {
            ajaxService.AjaxGet("api/main/Logout.json", successFunction, errorFunction);
        };
    }]);
});