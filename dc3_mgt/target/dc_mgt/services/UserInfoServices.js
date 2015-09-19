define(['application-configuration', 'ajaxService'], function (app) {

    app.register.service('userInfoService', ['ajaxService', function (ajaxService) {
        this.createUserInfo = function (userInfo, successFunction, errorFunction) {
            ajaxService.AjaxPost(userInfo, "/api/userInfo/CreateUserInfo", successFunction, errorFunction);
        };

        this.deleteUserInfo = function (userInfo, successFunction, errorFunction) {
            ajaxService.AjaxPost(userInfo, "/api/userInfo/DeleteUserInfo", successFunction, errorFunction);
        };

        this.updateUserInfo = function (userInfo, successFunction, errorFunction) {
            ajaxService.AjaxPost(userInfo, "/api/userInfo/UpdateUserInfo", successFunction, errorFunction);
        };

        this.getUserInfos = function (userInfo, successFunction, errorFunction) {
            ajaxService.AjaxPost(userInfo, "/api/userInfo/GetUserInfos", successFunction, errorFunction);
        };

        this.getUserInfoReport = function (userInfo, successFunction, errorFunction) {
            ajaxService.AjaxPost(userInfo, "/api/userInfo/GetUserInfoReport", successFunction, errorFunction);
        };

        this.getSumReport = function (meetInfo, successFunction, errorFunction) {
            ajaxService.AjaxPostNoBlock(meetInfo, "/api/charge/GetSumReport", successFunction, errorFunction);
        };

        this.getSYSUsers = function (userInfo, successFunction, errorFunction) {
            ajaxService.AjaxPost(userInfo, "api/userInfo/GetSYSUsers.json", successFunction, errorFunction);
        };

        this.existsSYSUser = function (userInfo, successFunction, errorFunction) {
            ajaxService.AjaxPost(userInfo, "/api/userInfo/ExistsSYSUser", successFunction, errorFunction);
        };

        this.createSYSUser = function (userInfo, successFunction, errorFunction) {
            ajaxService.AjaxPost(userInfo, "/api/userInfo/CreateSYSUser", successFunction, errorFunction);
        };

        this.deleteSYSUser = function (userInfo, successFunction, errorFunction) {
            ajaxService.AjaxPost(userInfo, "api/userInfo/DeleteSYSUser.json", successFunction, errorFunction);
        };

        this.updateSYSUser = function (userInfo, successFunction, errorFunction) {
            ajaxService.AjaxPost(userInfo, "/api/userInfo/UpdateSYSUser", successFunction, errorFunction);
        };
    }]);
});