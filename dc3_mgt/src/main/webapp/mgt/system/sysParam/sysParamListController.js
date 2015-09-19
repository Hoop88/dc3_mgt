"use strict";

define([ 'application-configuration', 'bootstrap', 'jquery', 'WdatePicker',
		'ZeroClipboard', 'sysParamService', 'alertsService', "dataGridService",
		"encryptService", "upload", 'toastr' ], function(app) {

	app.register.Controller('sysParamListController', [
			'$location',
			'$modal',
			'$log',
			'$filter',
			'$scope',
			'$rootScope',
			'$stateParams',
			'$document',
			'sysParamService',
			'alertsService',
			"dataGridService",
			"encryptService",
			"$upload",
			'toastr',

			function($location, $modal, $log, $filter, $scope, $rootScope,
					$routeParams, $document, sysParamService, alertsService,
					dataGridService, encryptService, $upload, toastr) {
				$scope.initializeController = function() {
					$scope.searchTxt = "";
					$scope.pageSize = 20;
					$scope.sysParamTypeMap = sysParamService.sysParamTypeMap;
					$scope.currentPage = 1;
					$scope.TotalRows = 0;
					$rootScope.closeAlert = alertsService.closeAlert;

					$scope.SysParams = [];
					$scope.getSysParams(null);
					$scope.FileUpload;
				}

				$scope.createSearchObject = function(search) {
					var searchVo = new Object();
					if (search != null)
						searchVo.currentPage = 1;
					else
						searchVo.currentPage = $scope.currentPage;
						
					searchVo.pageSize = $scope.pageSize;
					searchVo.searchTxt = $scope.searchTxt;
					
					return searchVo;
				}

				$scope.getSysParams = function(pageNumber) {
					var sysParam = $scope.createSearchObject(pageNumber);
					sysParamService.getSysParams(sysParam, $scope.getSysParamsCompleted,
							$scope.getSysParamsError);
				}

				$scope.getSysParamsCompleted = function(response, status) {
					alertsService.RenderSuccessMessage(response.ReturnMessage);

					if (response.header.code == 0) {
						$scope.SysParams = response.data.list;
						$scope.pageSize = response.data.page.pageSize;
						$scope.currentPage = response.data.page.currentPage;
						$scope.TotalPages = response.data.page.pageCount;
						$scope.TotalRows = response.data.page.recordCount;
					}
				}

				$scope.getSysParamsError = function(response, status) {
					alertsService.RenderErrorMessage(response.ReturnMessage);
				}


				$scope.pageChanged = function() {
					$scope.getSysParams(null);
				}



				var addModalInstanceCtrl = function($scope, $modalInstance) {
					$scope.HeaderText = "新增";
					$scope.sysParamModal = {};
					$scope.sysParamModal.sysParamType = 1;
					$scope.sysParamTypeList = sysParamService.sysParamTypeList;

					$scope.ok = function() {
						$modalInstance.close($scope.sysParamModal);
					};

					$scope.cancel = function() {
						$modalInstance.dismiss('cancel');
					};
				};
				
				$scope.addModal = function() {

					var modalInstance = $modal.open({
						templateUrl : 'addModal.html',
						Controller : addModalInstanceCtrl,
						windowClass : 'app-modal-window'
					});

					modalInstance.result.then(function(sysParam) {
						sysParamService.createSysParam(sysParam, $scope.editSysParamCompleted,
								$scope.editSysParamError);
					}, function() {
						// $log.info('Modal dismissed at: ' + new Date());
					});
				};

				var editModalInstanceCtrl = function($scope, $modalInstance,
						sysParam) {

					$scope.HeaderText = "修改";

					$scope.sysParamTypeList = sysParamService.sysParamTypeList;

					

					$scope.sysParamModal = sysParam;

					$scope.ok = function() {
						var sysParam = new Object();
						$modalInstance.close($scope.sysParamModal);
					};

					$scope.cancel = function() {
						$modalInstance.dismiss('cancel');
					};
				};

				$scope.editModal = function(id) {
					sysParamService.getSysParam({
						"paramsId" : id
					}, function(response) {
						if (response.header.code == 0) {
							var modalInstance = $modal.open({
								templateUrl : 'editModal.html',
								Controller : editModalInstanceCtrl,
								windowClass : 'app-modal-window',
								resolve : {
									sysParam : function() {
										return response.data;
									}
								}
							});
						} else {
							alert(response.header.message);
						}

						modalInstance.result.then(function(sysParam) {
							sysParamService.updateSysParam(sysParam,
									$scope.editSysParamCompleted,
									$scope.editSysParamError);
						}, function() {
							// $log.info('Modal dismissed at: ' + new Date());
						});
					}, function() {

					})
				};

				$scope.editSysParamCompleted = function(response) {
					if (response.header.code == 0) {
						$scope.getSysParams(null);
						toastr.success(response.header.message, '提示', {
							closeButton : true,
							timeOut : 2000
						});
					} else {
						toastr.warning(response.header.message, '提示', {
							closeButton : true,
							timeOut : 3000
						});
					}
				}

				$scope.editSysParamError = function(response) {
					toastr.warning("操作失败", '提示', {
						closeButton : true,
						timeOut : 5000
					});
				}

				$scope.deleteOne = function(paramsId) {
					if (confirm("确定要删除?")) {
						sysParamService.deleteSysParam({
							"paramsId" : paramsId
						}, $scope.editSysParamCompleted, $scope.editSysParamError);
					}
				}

				$scope.exportSysParam = function(i) {

					var form = $("<form>"); // 定义一个form表单
					form.attr('style', 'display:none'); // 在form表单中添加查询参数
					form.attr('target', '');
					form.attr('method', 'post');
					form.attr('action', "/api/ExportHandler.ashx");
					var input1 = $('<input>');
					input1.attr('type', 'hidden');
					input1.attr('name', 'MeetID');
					input1.attr('value', $scope.SysParams[i].ID);
					$('body').append(form); // 将表单放置在web中
					form.append(input1); // 将查询参数控件提交到表单上
					form.submit(); // 表单提交
				}

			} ]);
});
