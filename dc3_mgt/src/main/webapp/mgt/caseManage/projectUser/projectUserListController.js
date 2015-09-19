"use strict";

define([ 'application-configuration', 'bootstrap', 'jquery', 'WdatePicker',
		'ZeroClipboard', 'projectUserService', 'alertsService', "dataGridService",
		"encryptService", "upload", 'toastr' ], function(app) {

	app.register.Controller('projectUserListController', [
			'$location',
			'$modal',
			'$log',
			'$filter',
			'$scope',
			'$rootScope',
			'$stateParams',
			'$document',
			'projectUserService',
			'alertsService',
			"dataGridService",
			"encryptService",
			"$upload",
			'toastr',

			function($location, $modal, $log, $filter, $scope, $rootScope,
					$routeParams, $document, projectUserService, alertsService,
					dataGridService, encryptService, $upload, toastr) {
				$scope.initializeController = function() {
					$scope.searchTxt = "";
					$scope.pageSize = 20;
					$scope.roleTypeMap = projectUserService.roleTypeMap;
					$scope.userStateMap= projectUserService.userStateMap;
					$scope.currentPage = 1;
					$scope.TotalRows = 0;
					$rootScope.closeAlert = alertsService.closeAlert;

					$scope.ProjectUsers = [];
					projectUserService.initData();
					$scope.projectId = $rootScope.$stateParams.id;
					$scope.getProjectUsers($scope.projectId);
					$scope.FileUpload;
				}

				$scope.getProjectUsers = function(id) {
					
					var searchVo = new Object();
					searchVo.id =id;
					searchVo.searchTxt=$scope.searchTxt;
				
					projectUserService.getProjectUsers(searchVo, $scope.getProjectUsersCompleted,
							$scope.getProjectUsersError);
							
							
				}

				$scope.enter = function(ev) { 
					if (ev.keyCode !== 13) {
					  return; 
					}
					$scope.getProjectUsers('search');
				}

				$scope.getProjectUsersCompleted = function(response, status) {
					
					$scope.allCompanyMap = projectUserService.allCompanyMap;
					$scope.allCompanyList = projectUserService.allCompanyList;

					if (response.header.code == 0) {
						$scope.ProjectUsers = response.data.list;
						$scope.pageSize = response.data.page.pageSize;
						$scope.currentPage = response.data.page.currentPage;
						$scope.TotalPages = response.data.page.pageCount;
						$scope.TotalRows = response.data.page.recordCount;
					}
				}

				$scope.getProjectUsersError = function(response, status) {
					alertsService.RenderErrorMessage(response.ReturnMessage);
				}


				$scope.pageChanged = function() {
					alert($scope.projectId);
					$scope.getProjectUsers($scope.projectId);
				}



				var addModalInstanceCtrl = function($scope, $modalInstance) {
					$scope.HeaderText = "新增";
					$scope.projectUserModal = {};
					$scope.projectUserModal.projectUserType = 1;
					$scope.projectUserTypeList = projectUserService.projectUserTypeList;

					$scope.ok = function() {
						$modalInstance.close($scope.projectUserModal);
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

					modalInstance.result.then(function(projectUser) {
						projectUserService.createProjectUser(projectUser, $scope.editProjectUserCompleted,
								$scope.editProjectUserError);
					}, function() {
						// $log.info('Modal dismissed at: ' + new Date());
					});
				};

				var editModalInstanceCtrl = function($scope, $modalInstance,
						projectUser) {

					$scope.HeaderText = "修改";

					$scope.projectUserTypeList = projectUserService.projectUserTypeList;

					$scope.roleTypeList = projectUserService.roleTypeList;
					$scope.userStateList= projectUserService.userStateList;
					$scope.allCompanyMap = projectUserService.allCompanyMap;

					$scope.projectUserModal = projectUser;

					$scope.ok = function() {
						var projectUser = new Object();
						$modalInstance.close($scope.projectUserModal);
					};

					$scope.cancel = function() {
						$modalInstance.dismiss('cancel');
					};
				};

				$scope.editModal = function(id) {
					projectUserService.getProjectUser({
						"id" : id
					}, function(response) {
						if (response.header.code == 0) {
							var modalInstance = $modal.open({
								templateUrl : 'editModal.html',
								Controller : editModalInstanceCtrl,
								windowClass : 'app-modal-window',
								resolve : {
									projectUser : function() {
										return response.data;
									}
								}
							});
						} else {
							alert(response.header.message);
						}

						modalInstance.result.then(function(projectUser) {
							projectUserService.updateProjectUser(projectUser,
									$scope.editProjectUserCompleted,
									$scope.editProjectUserError);
						}, function() {
							// $log.info('Modal dismissed at: ' + new Date());
						});
					}, function() {

					})
				};

				$scope.editProjectUserCompleted = function(response) {
					if (response.header.code == 0) {
						$scope.getProjectUsers($scope.projectId);
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

				$scope.editProjectUserError = function(response) {
					toastr.warning("操作失败", '提示', {
						closeButton : true,
						timeOut : 5000
					});
				}

				$scope.deleteOne = function(id) {
					if (confirm("确定要删除?")) {
						projectUserService.deleteProjectUser({
							"id" : id
						}, $scope.editProjectUserCompleted, $scope.editProjectUserError);
					}
				}

				$scope.exportExcel = function() {
					var searchvo = $scope.createSearchObject(null);
					projectUserService.exportProjectUser(searchvo);
				}

			} ]);
});
