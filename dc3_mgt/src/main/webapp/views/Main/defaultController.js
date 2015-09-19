"use strict";

define(['application-configuration', 'mainService'], function (app) {

    app.register.Controller('defaultController', ['$scope', '$rootScope', 'mainService', function ($scope, $rootScope, mainService) {

        $scope.initializeController = function () {
            $scope.UserName = $rootScope.UserName;
			
			alert(111111);

            var authenication = new Object();
            authenication.route = "/Main";
            mainService.authenicateUser(/*authenication, */$scope.Complete, $scope.Error)
        }


        $scope.Complete = function (response) {
			
			alert(response.IsAuthenicated);
			
            if (response.IsAuthenicated == true) {
                window.location = "anchang.html#/Main";
            }
            else {
                setTimeout(function () {
                 window.location = "index.html#/Login";
                }, 10);
            }
        }

        $scope.Error = function (response) {

        }

        $scope.AjaxGetWithData = function (data, route, successFunction, errorFunction) {
            setTimeout(function () {
                $http({ method: 'GET', url: route, params: data }).success(function (response, status, headers, config) {
                    successFunction(response, status);
                }).error(function (response) {
                    errorFunction(response);
                });
            }, 1);
        }
    } ]);
});


