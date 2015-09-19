"use strict";

define(['application-configuration', 'ngAnimate', 'toastr'], function (app) {

    app.register.Controller('welcomeController', ['$scope', '$rootScope', 'toastr', function ($scope, $rootScope, toastr) {
        $rootScope.applicationModule = "Main";
        $scope.initializeController = function () {
        }
    } ]);

});
