define(['application-configuration', 'ajaxService'], function (app) {

    app.register.service('loginService', ['ajaxService', function (ajaxService) {
      

        /*this.loginTopic = function (login, successFunction, errorFunction) {
            ajaxService.AjaxGetWithData(login, "/api/login.ashx?action=LoginTopic", successFunction, errorFunction);
        };*/

        this.loginSYS = function (login, successFunction, errorFunction) {
            ajaxService.AjaxPostWithNoAuthenication(login, "auth/login", successFunction, errorFunction);
        };
		
		this.logoutSYS = function (successFunction, errorFunction) {
            ajaxService.AjaxPostWithNoAuthenication(null, "auth/logout", successFunction, errorFunction);
        };

    }]);
});