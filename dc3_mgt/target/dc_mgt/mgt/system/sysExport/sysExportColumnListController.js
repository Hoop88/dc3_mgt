"use strict";

define([ 'application-configuration', 'bootstrap', 'jquery', 'WdatePicker',
		'ZeroClipboard', 'sysExportService','sysExportColumnService', 'alertsService', "dataGridService",
		"encryptService", "upload", 'toastr' ], function(app) {

	app.register.Controller('sysExportColumnListController', [
			'$location',
			'$modal',
			'$log',
			'$filter',
			'$scope',
			'$rootScope',
			'$stateParams',
			'$document',
			'sysExportService',
			'sysExportColumnService',
			'alertsService',
			"dataGridService",
			"encryptService",
			"$upload",
			'toastr',

			function($location, $modal, $log, $filter, $scope, $rootScope,
					$routeParams, $document,sysExportService, sysExportColumnService, alertsService,
					dataGridService, encryptService, $upload, toastr) {
				$scope.initializeController = function() {
					$scope.searchTxt = "";
					$scope.pageSize = 20;
					$scope.sysExportColumnTypeMap = sysExportColumnService.sysExportColumnTypeMap;
					$scope.currentPage = 1;
					$scope.TotalRows = 0;
					
					
					$rootScope.closeAlert = alertsService.closeAlert;
					
					console.log($rootScope.$stateParams.id);
					
					$scope.sysExportModal = {};
					
					$scope.getSysExportModal($rootScope.$stateParams.id);
					
					$scope.SysExportColumns = [];
					$scope.getSysExportColumns($rootScope.$stateParams.id);
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

				$scope.getSysExportModal=function(id){
					sysExportService.getSysExport({"exportId" : id},
					$scope.getSysExportModalCompleted,$scope.getSysExportModalError);
				}
				
				$scope.getSysExportModalCompleted = function(response, status) {
					alertsService.RenderSuccessMessage(response.ReturnMessage);
					//console.log("=======");
					if (response.header.code == 0) {
						$scope.sysExportModal = response.data;
					}
				}

				$scope.getSysExportModalError = function(response, status) {
					alertsService.RenderErrorMessage(response.ReturnMessage);
				}
				

				$scope.getSysExportColumns = function(exportId) {
					
					var searchVo = new Object();
					searchVo.exportId = exportId;
					
					sysExportColumnService.getSysExportColumns(searchVo, $scope.getSysExportColumnsCompleted,
							$scope.getSysExportColumnsError);
				}

				$scope.getSysExportColumnsCompleted = function(response, status) {
					alertsService.RenderSuccessMessage(response.ReturnMessage);

					if (response.header.code == 0) {
						$scope.SysExportColumns = response.data;
					}
				}

				$scope.getSysExportColumnsError = function(response, status) {
					alertsService.RenderErrorMessage(response.ReturnMessage);
				}


				$scope.pageChanged = function() {
					$scope.getSysExportColumns($rootScope.$stateParams.id);
				}



				var addModalInstanceCtrl = function($scope, $modalInstance,sysExportModal) {
					console.log("============");
					console.log(sysExportModal);
					
					$scope.HeaderText = "新增";
					$scope.sysExportColumnModal = {};
					
					$scope.sysExportColumnModal.exportId = sysExportModal.exportId;
					$scope.sysExportColumnModal.exportCode = sysExportModal.exportCode;
					$scope.sysExportColumnModal.columnType = 1;
					$scope.sysExportColumnTypeList = sysExportColumnService.sysExportColumnTypeList;

					$scope.ok = function() {
						$modalInstance.close($scope.sysExportColumnModal);
					};

					$scope.cancel = function() {
						$modalInstance.dismiss('cancel');
					};
				};
				
				$scope.addModal = function() {

					var modalInstance = $modal.open({
						templateUrl : 'addModal.html',
						Controller : addModalInstanceCtrl,
						windowClass : 'app-modal-window',
						resolve : {
									sysExportModal: function() {
										return $scope.sysExportModal;
									}
								}
					});

					modalInstance.result.then(function(sysExportColumn) {
						sysExportColumnService.createSysExportColumn(sysExportColumn, $scope.editSysExportColumnCompleted,
								$scope.editSysExportColumnError);
					}, function() {
						// $log.info('Modal dismissed at: ' + new Date());
					});
				};

				var editModalInstanceCtrl = function($scope, $modalInstance,
						sysExportColumn) {

					$scope.HeaderText = "修改";

					$scope.sysExportColumnTypeList = sysExportColumnService.sysExportColumnTypeList;

					

					$scope.sysExportColumnModal = sysExportColumn;

					$scope.ok = function() {
						var sysExportColumn = new Object();
						$modalInstance.close($scope.sysExportColumnModal);
					};

					$scope.cancel = function() {
						$modalInstance.dismiss('cancel');
					};
				};

				$scope.editModal = function(id) {
					sysExportColumnService.getSysExportColumn({
						"columnId" : id
					}, function(response) {
						if (response.header.code == 0) {
							var modalInstance = $modal.open({
								templateUrl : 'editModal.html',
								Controller : editModalInstanceCtrl,
								windowClass : 'app-modal-window',
								resolve : {
									sysExportColumn : function() {
										return response.data;
									}
								}
							});
						} else {
							alert(response.header.message);
						}

						modalInstance.result.then(function(sysExportColumn) {
							sysExportColumnService.updateSysExportColumn(sysExportColumn,
									$scope.editSysExportColumnCompleted,
									$scope.editSysExportColumnError);
						}, function() {
							// $log.info('Modal dismissed at: ' + new Date());
						});
					}, function() {

					})
				};

				$scope.editSysExportColumnCompleted = function(response) {
					if (response.header.code == 0) {
						$scope.getSysExportColumns($rootScope.$stateParams.id);
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

				$scope.editSysExportColumnError = function(response) {
					toastr.warning("操作失败", '提示', {
						closeButton : true,
						timeOut : 5000
					});
				}

				$scope.deleteOne = function(columnId) {
					if (confirm("确定要删除?")) {
						sysExportColumnService.deleteSysExportColumn({
							"columnId" : columnId
						}, $scope.editSysExportColumnCompleted, $scope.editSysExportColumnError);
					}
				}

				$scope.exportSysExportColumn = function(i) {

					var form = $("<form>"); // 定义一个form表单
					form.attr('style', 'display:none'); // 在form表单中添加查询参数
					form.attr('target', '');
					form.attr('method', 'post');
					form.attr('action', "/api/ExportHandler.ashx");
					var input1 = $('<input>');
					input1.attr('type', 'hidden');
					input1.attr('name', 'MeetID');
					input1.attr('value', $scope.SysExportColumns[i].ID);
					$('body').append(form); // 将表单放置在web中
					form.append(input1); // 将查询参数控件提交到表单上
					form.submit(); // 表单提交
				}

			} ]);
});
