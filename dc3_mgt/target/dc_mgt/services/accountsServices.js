define(['application-configuration', 'ajaxService'], function (app) {

    app.register.service('accountsService', ['ajaxService', function (ajaxService) {

        this.registerUser = function (user, successFunction, errorFunction) {
            ajaxService.AjaxPostWithNoAuthenication(user, "/api/accounts/RegisterUser", successFunction, errorFunction);
        };

        this.login = function (user, successFunction, errorFunction) {
            ajaxService.AjaxPostWithNoAuthenication(user, "/api/accounts/Login", successFunction, errorFunction);
        };

        this.getUser = function (successFunction, errorFunction) {
            ajaxService.AjaxGet("/api/accounts/GetUser", successFunction, errorFunction);
        };        

        this.updateUser = function (user, successFunction, errorFunction) {
            ajaxService.AjaxPost(user, "/api/accounts/UpdateUser", successFunction, errorFunction);
        };

    }]);
});