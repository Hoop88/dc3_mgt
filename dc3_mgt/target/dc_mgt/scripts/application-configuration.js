"use strict";

define(['angularAMD', 'Layout', 'jquery', 'angular-route', 'ui-bootstrap', 'angular-sanitize', 'blockUI', "angular-ui-router", "bootstrap-hover-dropdown"], function (angularAMD, Layout) {
    var app = angular.module("mainModule", ['blockUI', 'ngSanitize', 'ui.bootstrap', 'ui.router', 'ngRoute']);
    //左边头部按钮初始化
    Layout.init();
    app.filter('html', ['$sce', function ($sce) {
        return function (text) {
            return $sce.trustAsHtml(text);
        }
    }]);

	app.filter('strToDate', [function () {
        return function (text) {
			if(text==null || text=='')
			{
			  return '';
			}else{
			 return new Date(text);
			}
        }
    }]);

    app.factory('authInterceptor', function ($rootScope, $q, $window) {
      return {
        /*request: function (config) {
            console.log("request");
          config.headers = config.headers || {};
          if ($window.sessionStorage.token) {
            config.headers.Authorization = 'Bearer ' + $window.sessionStorage.token;
          }
          return config;
        },*/
        response: function (response) {
            //console.log("response start");
            //console.dir(response);
          if (response.status === 401) {
            // handle the case where the user is not authenticated
          }
          return response || $q.when(response);
        }
      };
    });

    app.config(function ($httpProvider) {
      $httpProvider.interceptors.push('authInterceptor');
    });

    app.config(function ($httpProvider) {
        $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
        $httpProvider.defaults.withCredentials = true;
    });

    app.config(function (blockUIConfigProvider) {
        blockUIConfigProvider.message("加载中...");
        blockUIConfigProvider.delay(1);
        blockUIConfigProvider.autoBlock(false);
    });


    app.run(["$rootScope", "$state", "$stateParams", function($rootScope, $state, $stateParams){
        $rootScope.$state = $state;
        $rootScope.$stateParams = $stateParams;
    }])
    app.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            $urlRouterProvider.when("", "/Login");
			var ver = '?1.0';
            $stateProvider
			.state('System', angularAMD.route({
				abstract: true,
                url: '/System',
				templateUrl: 'mgt/manageView.html'
            }))
			.state('System.Department', angularAMD.route({
                url: '/Department',
                templateUrl: 'mgt/system/department/departmentList.html'+ver,
				ControllerUrl: 'mgt/system/department/departmentListController'
            }))
			.state('System.SysUser', angularAMD.route({
                url: '/SysUser',
                templateUrl: 'mgt/system/sysUser/sysUserList.html'+ver,
				ControllerUrl: 'mgt/system/sysUser/sysUserListController'
            }))
			.state('System.Role', angularAMD.route({
                url: '/Role',
                templateUrl: 'mgt/system/role/roleList.html'+ver,
				ControllerUrl: 'mgt/system/role/roleListController'
            }))
           .state('System.SysParam', angularAMD.route({
                url: '/SysParam',
                templateUrl: 'mgt/system/sysParam/sysParamList.html'+ver,
				ControllerUrl: 'mgt/system/sysParam/sysParamListController'
            }))
			.state('System.SysExport', angularAMD.route({
                url: '/SysExport',
                templateUrl: 'mgt/system/sysExport/sysExportList.html'+ver,
				ControllerUrl: 'mgt/system/sysExport/sysExportListController'
            }))
			.state('System.SysExportColumn', angularAMD.route({
                url: '/SysExportColumn/{id:[0-9]{1,4}}',
                templateUrl: 'mgt/system/sysExport/sysExportColumnList.html'+ver,
				ControllerUrl: 'mgt/system/sysExport/sysExportColumnListController'
            }))
			.state('CaseManage', angularAMD.route({
				abstract: true,
                url: '/CaseManage',
				templateUrl: 'mgt/manageView.html'
            }))
			.state('CaseManage.CityCompany', angularAMD.route({
                url: '/CityCompany',
                templateUrl: 'mgt/caseManage/cityCompany/cityCompanyList.html'+ver,
				ControllerUrl: 'mgt/caseManage/cityCompany/cityCompanyListController'
            }))
			.state('CaseManage.ProxyCompany', angularAMD.route({
                url: '/ProxyCompany',
                templateUrl: 'mgt/caseManage/proxyCompany/proxyCompanyList.html'+ver,
				ControllerUrl: 'mgt/caseManage/proxyCompany/proxyCompanyListController'
            }))
			.state('CaseManage.ProjectManage', angularAMD.route({
                url: '/ProjectManage',
                templateUrl: 'mgt/caseManage/projectManage/projectManageList.html'+ver,
				ControllerUrl: 'mgt/caseManage/projectManage/projectManageListController'
            }))
			.state('CaseManage.ProjectUser', angularAMD.route({
                url: '/ProjectUser/{id:[0-9]{1,4}}',
                templateUrl: 'mgt/caseManage/projectUser/projectUserList.html'+ver,
				ControllerUrl: 'mgt/caseManage/projectUser/projectUserListController'
            }))
			.state('CaseManage.Team', angularAMD.route({
                url: '/Team',
                templateUrl: 'mgt/caseManage/team/teamList.html'+ver,
				ControllerUrl: 'mgt/caseManage/team/teamListController'
            }))
			.state('CaseManage.Station', angularAMD.route({
                url: '/Station',
                templateUrl: 'mgt/caseManage/station/stationList.html'+ver,
				ControllerUrl: 'mgt/caseManage/station/stationListController'
            }))
			.state('CaseManage.CaseUser', angularAMD.route({
                url: '/CaseUser',
                templateUrl: 'mgt/caseManage/caseUser/caseUserList.html'+ver,
				ControllerUrl: 'mgt/caseManage/caseUser/caseUserListController'
            }))
            .state('Main', angularAMD.route({
                url: '/Main',
                templateUrl: 'views/Main/Welcome.html'+ver,
                ControllerUrl: 'views/Main/WelcomeController'
              }))
            .state('Login', angularAMD.route({
                url: '/Login',
                templateUrl: 'mgt/auth/login.html'+ver,
                ControllerUrl: 'mgt/auth/loginController.js'
              }))
            .state('Logout', angularAMD.route({
                url: '/Logout',
                templateUrl: 'mgt/auth/logout.html'+ver,
                ControllerUrl: 'mgt/auth/logoutController.js'
              }));
			  
            $urlRouterProvider.otherwise('/Login');
      }]);



    var time = 0;
    var indexController = function ($scope, $rootScope, $http, $location, blockUI) {
        $scope.isFirst = true;
        $scope.$on('$stateChangeStart', function (scope, next, current) {

            if ($rootScope.IsloggedIn == true && next.name!='Login' && next.name!='Logout' ) {
               $scope.authenicateUser(next.name, $scope.authenicateUserComplete, $scope.authenicateUserError);
            }
            $scope.isFirst = false;
        });

        $scope.$on('$routeChangeSuccess', function (scope, next, current) {
            setTimeout(function () {
                if ($scope.isCollapsed == true) {
                    set95PercentWidth();
                }
                $scope.isFirst = true;
            }, 1000);
        });

        $scope.authenicateUser = function (route, successFunction, errorFunction) {
            var authenication = new Object();
            authenication.route = route;
            $scope.AjaxGetWithData(authenication, "auth/authPath", successFunction, errorFunction);
        };

        $scope.authenicateUserComplete = function (response) {
			if(response.header)
			{
				if(response.header.code==0)
				{
					
				}else if(response.header.code==3)
				{
					alert(response.header.message);
					window.location = "index.html#/Login";
				}
				else
				{
					alert(response.header.message);
					//window.location = "index.html#/Main";
				}
			}else{
				
				alert("数据请求失败!");
	        };
			
        }

        $scope.authenicateUserError = function (response) {

			alert("数据请求失败!!");
        }

        $rootScope.Title = "案场后台管理";
        $scope.initializeController = function () {
            $scope.Title = "案场后台管理";
            $rootScope.IsloggedIn = false;
            $rootScope.IE11Login = false;
            //console.log($location.path());
            if ($location.path() != "/Login") {
                $scope.initializeApplication($scope.initializeApplicationComplete, $scope.initializeApplicationError);
            }
        }

        $scope.navigation = "";
        $scope.setNavigation = function (txt) {
			console.log(txt);
            $scope.navigation = txt;
        }

        $scope.initializeApplicationComplete = function (response, status) {
			
			if(response.header)
			{
				if(response.header.code==0)
				{
				   $rootScope.menuItems = response.data.menu;
					//修复刷新后导航地址为空
					//console.log(2222);
					//console.dir(response.menuItems);
					console.log($location.path());
					
					console.log(response.data.menu);
					
					var path = $location.path().split("/").join("");
					console.log("path: " + path);
					angular.forEach(response.data.menu, function (lineItem) {
						angular.forEach(lineItem.menuItems, function (lineItemSub) {
							//console.log("lineItemSub: " +lineItemSub);
							//console.log("href: " + lineItemSub.href);
							//console.log("path: " + $location.path().split("/").join("."));
							//if (lineItemSub.href == $location.path().split("/").join("."))
								//$scope.navigation = lineItemSub.navigation;
							console.log("href: " + lineItemSub.href.split(".").join(""));
							if(path === lineItemSub.href.split(".").join("")){
								$scope.navigation = lineItemSub.navigation;
							}
								
						});
					});
					
					
					
					
		
					$rootScope.UserName = response.data.user.userName;
					if(response.data.user.logo)
					{
						$rootScope.HeaderPic = response.data.user.logo;
					}else
					{
						$rootScope.HeaderPic ="images/userLogo.png"
					}
					$rootScope.displayContent = true;
					$rootScope.IsloggedIn = true;
					
				}else if(response.header.code==3)
				{
					window.location = "index.html#/Login";
				}
				else
				{
				   alert(response.header.message);
				   window.location = "anchang.html#/Main";
				}
			}else{
			 $rootScope.IsloggedIn = false;
			 alert("初始请求失败");
			}
        }

        $scope.initializeApplication = function (successFunction, errorFunction) {
            blockUI.start();
            /*检测是否登陆请求*/
            //console.log(111);
            $scope.AjaxGet("auth/initData", successFunction, errorFunction);
            blockUI.stop();
        };

        $scope.AjaxGet = function (route, successFunction, errorFunction) {
            setTimeout(function () {
                $http({ method: 'POST', url: route }).success(function (response, status, headers, config) {
                    successFunction(response, status);
                }).error(function (response) {
                    errorFunction(response);
                });
            }, 1);
        }

        $scope.AjaxGetWithData = function (data, route, successFunction, errorFunction) {
            setTimeout(function () {
                $http({ method: 'POST', url: route, params: data }).success(function (response, status, headers, config) {
                    successFunction(response, status);
                }).error(function (response) {
                    errorFunction(response);
                });
            }, 1);
        }
    };

    indexController.$inject = ['$scope', '$rootScope', '$http', '$location', 'blockUI'];
    app.Controller("indexController", indexController);    
    angularAMD.bootstrap(app);
    return app;
});