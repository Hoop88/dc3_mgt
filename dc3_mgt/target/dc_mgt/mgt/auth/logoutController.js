"use strict";

define(['application-configuration', 'loginService', 'alertsService'], function (app) {

    app.register.Controller('logoutController', ['$scope', '$rootScope', 'loginService', 'alertsService', function ($scope, $rootScope, loginService, alertsService) {



        $scope.initializeController = function () {
            loginService.logoutSYS($scope.logoutComplete, $scope.logoutError);
			//window.location = "index.html#/Login";
        }

        $scope.logoutComplete = function (response) {   
            window.location = "index.html#/Login";
        }

        $scope.logoutError = function (response) {
            alertsService.RenderErrorMessage(response.ReturnMessage);
			window.location = "index.html#/Login";
        }


    }]);
});