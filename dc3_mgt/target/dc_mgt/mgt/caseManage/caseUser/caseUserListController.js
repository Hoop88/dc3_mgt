"use strict";

define([ 'application-configuration', 'bootstrap', 'jquery', 'WdatePicker',
		'ZeroClipboard', 'caseUserService', 'alertsService', "dataGridService",
		"encryptService", "upload", 'toastr' ], function(app) {

	app.register.Controller('caseUserListController', [
			'$location',
			'$modal',
			'$log',
			'$filter',
			'$scope',
			'$rootScope',
			'$stateParams',
			'$document',
			'caseUserService',
			'alertsService',
			"dataGridService",
			"encryptService",
			"$upload",
			'toastr',

			function($location, $modal, $log, $filter, $scope, $rootScope,
					$routeParams, $document, caseUserService, alertsService,
					dataGridService, encryptService, $upload, toastr) {
				$scope.initializeController = function() {
					$scope.searchTxt = "";
					$scope.pageSize = 20;
					$scope.caseUserTypeMap = caseUserService.caseUserTypeMap;
					$scope.caseUserStateMap = caseUserService.caseUserStateMap;
					$scope.caseJobStateMap = caseUserService.caseJobStateMap;
					
					$scope.caseUserTypeList = caseUserService.caseUserTypeList;
					$scope.caseUserStateList = caseUserService.caseUserStateList;
					
					$scope.caseUserStateList.unshift({"id":-1,"name":"全部"});
					$scope.caseUserTypeList.unshift({"id":-1,"name":"全部"});
					
					$scope.userState=-1;
					$scope.userType=-1;
					$scope.companyId=-1;
					caseUserService.initData();
					
					$scope.currentPage = 1;
					$scope.TotalRows = 0;
					$rootScope.closeAlert = alertsService.closeAlert;
					$scope.CaseUsers = [];
					$scope.getCaseUsers(null);
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
					
					searchVo.userType = $scope.userType;
					searchVo.userState = $scope.userState;
					searchVo.companyId = $scope.companyId;
					
					return searchVo;
				}

				$scope.getCaseUsers = function(pageNumber) {
					var caseUser = $scope.createSearchObject(pageNumber);
					caseUserService.getCaseUsers(caseUser, $scope.getCaseUsersCompleted,
							$scope.getCaseUsersError);
				}

				$scope.enter = function(ev) { 
					if (ev.keyCode !== 13) {
					  return; 
					}
					$scope.getCaseUsers('search');
				}

				$scope.getCaseUsersCompleted = function(response, status) {
					$scope.allCompanyMap = caseUserService.allCompanyMap;
					$scope.allCompanyList = caseUserService.allCompanyList;
					
					
					
					if (response.header.code == 0) {
						$scope.CaseUsers = response.data.list;
						$scope.pageSize = response.data.page.pageSize;
						$scope.currentPage = response.data.page.currentPage;
						$scope.TotalPages = response.data.page.pageCount;
						$scope.TotalRows = response.data.page.recordCount;
					}
				}

				$scope.getCaseUsersError = function(response, status) {
					alertsService.RenderErrorMessage(response.ReturnMessage);
				}

				$scope.pageChanged = function() {
					$scope.getCaseUsers(null);
				}

				var addModalInstanceCtrl = function($scope, $modalInstance) {
					$scope.HeaderText = "新增";
					$scope.caseUserModal = {};
					$scope.caseUserModal.caseUserType = 1;
					$scope.caseUserTypeList = caseUserService.caseUserTypeList;
					$scope.caseUserStateList = caseUserService.caseUserStateList;
					$scope.caseJobStateList = caseUserService.caseJobStateList;
					$scope.ok = function() {
						$modalInstance.close($scope.caseUserModal);
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

					modalInstance.result.then(function(caseUser) {
						caseUserService.createCaseUser(caseUser, $scope.editCaseUserCompleted,
								$scope.editCaseUserError);
					}, function() {
						// $log.info('Modal dismissed at: ' + new Date());
					});
				};

				var editModalInstanceCtrl = function($scope, $modalInstance,
						caseUser) {

					$scope.HeaderText = "修改";

					$scope.caseUserTypeList = caseUserService.caseUserTypeList;
					$scope.caseUserStateList = caseUserService.caseUserStateList;
					$scope.caseJobStateList = caseUserService.caseJobStateList;
					$scope.allCompanyMap = caseUserService.allCompanyMap;
					
					


				    
					$scope.caseUserModal = caseUser;

					$scope.ok = function() {
						var caseUser = new Object();
						$modalInstance.close($scope.caseUserModal);
					};

					$scope.cancel = function() {
						$modalInstance.dismiss('cancel');
					};
				};

				$scope.editModal = function(id) {
					caseUserService.getCaseUser({
						"userId" : id
					}, function(response) {
						if (response.header.code == 0) {
							var modalInstance = $modal.open({
								templateUrl : 'editModal.html',
								Controller : editModalInstanceCtrl,
								windowClass : 'app-modal-window',
								resolve : {
									caseUser : function() {
										return response.data;
									}
								}
							});
						} else {
							alert(response.header.message);
						}

						modalInstance.result.then(function(caseUser) {
							caseUserService.updateCaseUser(caseUser,
									$scope.editCaseUserCompleted,
									$scope.editCaseUserError);
						}, function() {
							// $log.info('Modal dismissed at: ' + new Date());
						});
					}, function() {

					})
				};

				$scope.editCaseUserCompleted = function(response) {
					if (response.header.code == 0) {
						$scope.getCaseUsers(null);
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

				$scope.editCaseUserError = function(response) {
					toastr.warning("操作失败", '提示', {
						closeButton : true,
						timeOut : 5000
					});
				}

				$scope.deleteOne = function(userId) {
					if (confirm("确定要删除?")) {
						caseUserService.deleteCaseUser({
							"userId" : userId
						}, $scope.editCaseUserCompleted, $scope.editCaseUserError);
					}
				}

				$scope.exportExcel = function() {
					var searchvo = $scope.createSearchObject(null);
					caseUserService.exportCaseUser(searchvo);
				}

			} ]);
});
