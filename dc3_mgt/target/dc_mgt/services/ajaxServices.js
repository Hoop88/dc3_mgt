
define(['application-configuration'], function (app) {

    app.register.service('ajaxService', ['$http', 'blockUI', function ($http, blockUI) {

        // setting timeout of 1 second to simulate a busy server.

        this.AjaxPost = function (data, route, successFunction, errorFunction) {
            blockUI.start();
            setTimeout(function () {
                $http.post(route, data).success(function (response, status, headers, config) {
                    blockUI.stop();
                    successFunction(response, status);
                }).error(function (response) {
                    blockUI.stop();
					
                    if (response.header.code == 3) { window.location = "/index.html"; }
                    errorFunction(response);
                });
            }, 300);

        }
		
		this.AjaxDownload = function (data, route) {
			var form=$("<form>");//定义一个form表单
			form.attr("style","display:none");
			form.attr("target","");
			form.attr("method","post");
			form.attr("action",route);
			$("body").append(form);//将表单放置在web中
			for (items in data){
				var input1=$("<input>");
				input1.attr("type","hidden");
				input1.attr("name",items);
				input1.attr("value",data[items]);
				form.append(input1);
			}
			form.submit().remove();//表单提交
        }
		
		
		this.AjaxFormPost = function (data, route, successFunction, errorFunction) {
            blockUI.start();
	
			var transform = function(data){
			   return $.param(data);
		  	}
					
			var header = {
					headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
					transformRequest: transform
   			};
				
            setTimeout(function () {
                $http.post(route,data,header).success(function (response, status, headers, config) {
                    blockUI.stop();
                    successFunction(response, status);
                }).error(function (response) {
                    blockUI.stop();
                    if (response.header.code == 3) { window.location = "/index.html"; }
                    errorFunction(response);
                });
            }, 300);
        }

        this.AjaxPostNoBlock = function (data, route, successFunction, errorFunction) {
            setTimeout(function () {
                $http.post(route, data).success(function (response, status, headers, config) {
                    successFunction(response, status);
                }).error(function (response) {
                    if (response.header.code == 3) { window.location = "/index.html"; }
                    errorFunction(response);
                });
            }, 300);

        }

        this.AjaxPostWithNoAuthenication = function (data, route, successFunction, errorFunction) {
            blockUI.start();
            setTimeout(function () {
                $http.post(route, data).success(function (response, status, headers, config) {
                    blockUI.stop();
                    successFunction(response, status);
                }).error(function (response) {
                    blockUI.stop();
                    errorFunction(response);
                });
            }, 300);
        }

        this.AjaxGet = function (route, successFunction, errorFunction) {
            blockUI.start();
            setTimeout(function () {
                $http({ method: 'GET', url: route }).success(function (response, status, headers, config) {
                    blockUI.stop();
                    successFunction(response, status);
                }).error(function (response) {
                    blockUI.stop();
                    if (response.header.code == 3) { window.location = "/index.html"; }
                    errorFunction(response);
                });
            }, 300);

        }

        this.AjaxGetWithData = function (data, route, successFunction, errorFunction) {
            blockUI.start("加载中...");
            //data += "&random=" + Math.random() * 100;
            setTimeout(function () {
                $http({ method: 'GET', url: route, params: data }).success(function (response, status, headers, config) {
                    blockUI.stop();
                    if (response.ReturnStatus == true)
                        successFunction(response, status);
                    else {
                        //if (response.header.code == 3) { window.location = "/index.html"; }
                        errorFunction(response);
                    }
                }).error(function (response) {
                    blockUI.stop();
                    if (response.header.code == 3) { window.location = "/index.html"; }
                    errorFunction(response);
                });
            }, 300);
        }


        this.AjaxGetWithNoBlock = function (data, route, successFunction, errorFunction) {
            setTimeout(function () {
                $http({ method: 'GET', url: route, params: data }).success(function (response, status, headers, config) {
                    successFunction(response, status);
                }).error(function (response) {
                    ;
                    if (response.header.code == 3) { window.location = "/index.html"; }
                    errorFunction(response);
                });
            }, 0);

        }


    } ]);
});


