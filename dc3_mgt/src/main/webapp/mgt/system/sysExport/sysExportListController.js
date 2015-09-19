"use strict";

define([ 'application-configuration', 'bootstrap', 'jquery', 'WdatePicker',
		'ZeroClipboard', 'sysExportService', 'alertsService', "dataGridService",
		"encryptService", "upload", 'toastr' ], function(app) {

	app.register.Controller('sysExportListController', [
			'$location',
			'$modal',
			'$log',
			'$filter',
			'$scope',
			'$rootScope',
			'$stateParams',
			'$document',
			'sysExportService',
			'alertsService',
			"dataGridService",
			"encryptService",
			"$upload",
			'toastr',

			function($location, $modal, $log, $filter, $scope, $rootScope,
					$routeParams, $document, sysExportService, alertsService,
					dataGridService, encryptService, $upload, toastr) {
				$scope.initializeController = function() {
					$scope.searchTxt = "";
					$scope.pageSize = 20;
					$scope.sysExportTypeMap = sysExportService.sysExportTypeMap;
					$scope.currentPage = 1;
					$scope.TotalRows = 0;
					$rootScope.closeAlert = alertsService.closeAlert;

					$scope.SysExports = [];
					$scope.getSysExports(null);
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

				$scope.getSysExports = function(pageNumber) {
					var sysExport = $scope.createSearchObject(pageNumber);
					sysExportService.getSysExports(sysExport, $scope.getSysExportsCompleted,
							$scope.getSysExportsError);
				}

				$scope.getSysExportsCompleted = function(response, status) {
					alertsService.RenderSuccessMessage(response.ReturnMessage);

					if (response.header.code == 0) {
						$scope.SysExports = response.data.list;
						$scope.pageSize = response.data.page.pageSize;
						$scope.currentPage = response.data.page.currentPage;
						$scope.TotalPages = response.data.page.pageCount;
						$scope.TotalRows = response.data.page.recordCount;
					}
				}

				$scope.getSysExportsError = function(response, status) {
					alertsService.RenderErrorMessage(response.ReturnMessage);
				}


				$scope.pageChanged = function() {
					$scope.getSysExports(null);
				}



				var addModalInstanceCtrl = function($scope, $modalInstance) {
					$scope.HeaderText = "新增";
					$scope.sysExportModal = {};
					$scope.sysExportModal.sysExportType = 1;
					$scope.sysExportTypeList = sysExportService.sysExportTypeList;

					$scope.ok = function() {
						$modalInstance.close($scope.sysExportModal);
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

					modalInstance.result.then(function(sysExport) {
						sysExportService.createSysExport(sysExport, $scope.editSysExportCompleted,
								$scope.editSysExportError);
					}, function() {
						// $log.info('Modal dismissed at: ' + new Date());
					});
				};

				var editModalInstanceCtrl = function($scope, $modalInstance,
						sysExport) {

					$scope.HeaderText = "修改";

					$scope.sysExportTypeList = sysExportService.sysExportTypeList;

					

					$scope.sysExportModal = sysExport;

					$scope.ok = function() {
						var sysExport = new Object();
						$modalInstance.close($scope.sysExportModal);
					};

					$scope.cancel = function() {
						$modalInstance.dismiss('cancel');
					};
				};

				$scope.editModal = function(id) {
					sysExportService.getSysExport({
						"exportId" : id
					}, function(response) {
						if (response.header.code == 0) {
							var modalInstance = $modal.open({
								templateUrl : 'editModal.html',
								Controller : editModalInstanceCtrl,
								windowClass : 'app-modal-window',
								resolve : {
									sysExport : function() {
										return response.data;
									}
								}
							});
						} else {
							alert(response.header.message);
						}

						modalInstance.result.then(function(sysExport) {
							sysExportService.updateSysExport(sysExport,
									$scope.editSysExportCompleted,
									$scope.editSysExportError);
						}, function() {
							// $log.info('Modal dismissed at: ' + new Date());
						});
					}, function() {

					})
				};

				$scope.editSysExportCompleted = function(response) {
					if (response.header.code == 0) {
						$scope.getSysExports(null);
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

				$scope.editSysExportError = function(response) {
					toastr.warning("操作失败", '提示', {
						closeButton : true,
						timeOut : 5000
					});
				}

				$scope.deleteOne = function(exportId) {
					if (confirm("确定要删除?")) {
						sysExportService.deleteSysExport({
							"exportId" : exportId
						}, $scope.editSysExportCompleted, $scope.editSysExportError);
					}
				}

				$scope.exportSysExport = function(i) {

					var form = $("<form>"); // 定义一个form表单
					form.attr('style', 'display:none'); // 在form表单中添加查询参数
					form.attr('target', '');
					form.attr('method', 'post');
					form.attr('action', "/api/ExportHandler.ashx");
					var input1 = $('<input>');
					input1.attr('type', 'hidden');
					input1.attr('name', 'MeetID');
					input1.attr('value', $scope.SysExports[i].ID);
					$('body').append(form); // 将表单放置在web中
					form.append(input1); // 将查询参数控件提交到表单上
					form.submit(); // 表单提交
				}

			} ]);
});
