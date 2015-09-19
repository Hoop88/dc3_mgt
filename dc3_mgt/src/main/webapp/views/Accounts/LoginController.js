"use strict";

define(['application-configuration', 'Metronic', 'jquery', 'loginService', 'jquery-backstretch', 'bootstrap'], function (app, Metronic) {

    app.register.Controller('loginController', ['$scope', '$rootScope', 'loginService',
        function ($scope, $rootScope, loginService) {

            $scope.initializeController = function () {
                //背景切换初始化
                console.log()
                $.backstretch([
                    "images/bg/1.jpg",
                    "images/bg/2.jpg",
                    "images/bg/3.jpg",
                    "images/bg/4.jpg"
                    ], {
                    fade: 1000,
                    duration: 8000
                });
                $scope.LoginName = "";
                $scope.Password = "";
                $scope.RememberMe = false;
                //Metronic.init();
                window.document.title = "深讯后台管理";
                $scope.DataSourceCode = "DesignOA";
                window.onbeforeunload = function () {
                    //修复刷新和关闭事件
                }
                //修复从答题页面跳转到设计页面导致答题页面的登录model遮盖
                $(".fade").remove();
                $(document).ready(function () {
                    setTimeout(function () { $("#userName").focus(); }, 50);
                    $("body").addClass("body");
                });
            }

            $scope.applyPWD = function () {
                setTimeout(function () { $scope.$apply($scope.Password = document.getElementById("pw").value) }, 50);
            }

            $scope.login = function () {
                $rootScope.IsloggedIn = false;
                var user = $scope.createLoginCredentials();
                loginService.loginSYS(user, $scope.loginCompleted, $scope.loginError);
            }

            $scope.loginCompleted = function (response) {
                //$rootScope.menuItems = response.menuItems;
				if(response.header.code==0)
				{
					$rootScope.userName = response.data.userName;
					$rootScope.userId = response.data.userId;
					$rootScope.userType = response.data.userType;
					window.location = "anchang.html#/Main";
				}else{
				
					alert(response.header.message);
				    
				}
				
				
				
               
            }

            $scope.loginError = function (response) {
                $scope.IsError = true;
                $scope.LoginMSG = response.ReturnMessage[0];
                $("#LoginMSG").fadeIn("slow");
                setTimeout(function () {
                    $("#LoginMSG").fadeOut("slow");
                }, 3000);
            }

            $scope.createLoginCredentials = function () {
                var user = new Object();
                user.userName = $scope.LoginName;
                user.password = $scope.Password;
				user.randnum = "1234";
                user.rememberMe = $scope.RememberMe;
                return user;
            }
        } ]);
});
