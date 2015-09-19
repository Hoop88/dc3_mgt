"use strict";

define([ 'application-configuration', 'bootstrap', 'jquery', 'WdatePicker',
		'ZeroClipboard', 'projectManageService', 'alertsService', "dataGridService",
		"encryptService", "upload", 'toastr' ], function(app) {

	app.register.Controller('projectManageListController', [
			'$location',
			'$modal',
			'$log',
			'$filter',
			'$scope',
			'$rootScope',
			'$stateParams',
			'$document',
			'projectManageService',
			'alertsService',
			"dataGridService",
			"encryptService",
			"$upload",
			'toastr',

			function($location, $modal, $log, $filter, $scope, $rootScope,
					$routeParams, $document, projectManageService, alertsService,
					dataGridService, encryptService, $upload, toastr) {
				$scope.initializeController = function() {
					$scope.searchTxt = "";
					$scope.pageSize = 500;
					projectManageService.initData();
					$scope.projectStateMap = projectManageService.projectStateMap;
					$scope.projectTypeMap = projectManageService.projectTypeMap;
					
					$scope.currentPage = 1;
					$scope.TotalRows = 0;
					$rootScope.closeAlert = alertsService.closeAlert;

					$scope.ProjectManages = [];
					$scope.getProjectManages(null);
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

				$scope.getProjectManages = function(pageNumber) {
					var projectManage = $scope.createSearchObject(pageNumber);
					projectManageService.getProjectManages(projectManage, $scope.getProjectManagesCompleted,
							$scope.getProjectManagesError);
				}

				$scope.enter = function(ev) { 
					if (ev.keyCode !== 13) {
					  return; 
					}
					$scope.getProjectManages('search');
				}

				$scope.getProjectManagesCompleted = function(response, status) {
					alertsService.RenderSuccessMessage(response.ReturnMessage);
					$scope.cityCompanyMap = projectManageService.cityCompanyMap;
					if (response.header.code == 0) {
						$scope.ProjectManages = response.data.list;
						$scope.pageSize = response.data.page.pageSize;
						$scope.currentPage = response.data.page.currentPage;
						$scope.TotalPages = response.data.page.pageCount;
						$scope.TotalRows = response.data.page.recordCount;
					}
				}

				$scope.getProjectManagesError = function(response, status) {
					alertsService.RenderErrorMessage(response.ReturnMessage);
				}


				$scope.pageChanged = function() {
					$scope.getProjectManages(null);
				}



				var addModalInstanceCtrl = function($scope, $modalInstance) {
					$scope.HeaderText = "新增";
					$scope.projectManageModal = {};
					$scope.projectManageModal.projectManageType = 1;

					$scope.projectStateList = projectManageService.projectStateList;
					$scope.projectTypeList = projectManageService.projectTypeList;
					$scope.cityCompanyList = projectManageService.cityCompanyList;
					
					projectManageModal

					$scope.ok = function() {
						$modalInstance.close($scope.projectManageModal);
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

					modalInstance.result.then(function(projectManage) {
						projectManageService.createProjectManage(projectManage, $scope.editProjectManageCompleted,
								$scope.editProjectManageError);
					}, function() {
						// $log.info('Modal dismissed at: ' + new Date());
					});
				};

				var editModalInstanceCtrl = function($scope, $modalInstance,
						projectManage) {

					$scope.HeaderText = "修改";
					
					$scope.projectStateList = projectManageService.projectStateList;
					$scope.projectTypeMap = projectManageService.projectTypeMap;
					$scope.cityCompanyList = projectManageService.cityCompanyList;
					$scope.projectStationList = projectManageService.treeToList(projectManage.projectStationTree,0);
					
					$scope.projectManageModal = projectManage;

					$scope.ok = function() {
						var projectManage = new Object();
						$modalInstance.close($scope.projectManageModal);
					};

					$scope.cancel = function() {
						$modalInstance.dismiss('cancel');
					};
				};

				$scope.editModal = function(id) {
					projectManageService.getProjectManage({
						"projectId" : id
					}, function(response) {
						if (response.header.code == 0) {
							var modalInstance = $modal.open({
								templateUrl : 'editModal.html',
								Controller : editModalInstanceCtrl,
								windowClass : 'app-modal-window',
								size: "lg",
								resolve : {
									projectManage : function() {
										return response.data;
									}
								}
							});
						} else {
							alert(response.header.message);
						}

						modalInstance.result.then(function(projectManage) {
							projectManageService.updateProjectManage(projectManage,
									$scope.editProjectManageCompleted,
									$scope.editProjectManageError);
						}, function() {
							// $log.info('Modal dismissed at: ' + new Date());
						});
					}, function() {

					})
				};

				$scope.editProjectManageCompleted = function(response) {
					if (response.header.code == 0) {
						$scope.getProjectManages(null);
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

				$scope.editProjectManageError = function(response) {
					toastr.warning("操作失败", '提示', {
						closeButton : true,
						timeOut : 5000
					});
				}

				$scope.deleteOne = function(projectId) {
					if (confirm("确定要删除?")) {
						projectManageService.deleteProjectManage({
							"projectId" : projectId
						}, $scope.editProjectManageCompleted, $scope.editProjectManageError);
					}
				}

				$scope.exportExcel = function() {
					var searchvo = $scope.createSearchObject(null);
					projectManageService.exportProjectManage(searchvo);
				}

			} ]);
});
