"use strict";

define([ 'application-configuration', 'bootstrap', 'jquery', 'WdatePicker',
		'ZeroClipboard', 'teamService', 'alertsService', "dataGridService",
		"encryptService", "upload", 'toastr' ], function(app) {

	app.register.Controller('teamListController', [
			'$location',
			'$modal',
			'$log',
			'$filter',
			'$scope',
			'$rootScope',
			'$stateParams',
			'$document',
			'teamService',
			'alertsService',
			"dataGridService",
			"encryptService",
			"$upload",
			'toastr',

			function($location, $modal, $log, $filter, $scope, $rootScope,
					$routeParams, $document, teamService, alertsService,
					dataGridService, encryptService, $upload, toastr) {
				$scope.initializeController = function() {
					$scope.searchTxt = "";
					$scope.pageSize = 20;
					$scope.teamStateMap = teamService.teamStateMap;
					$scope.currentPage = 1;
					$scope.TotalRows = 0;
					$rootScope.closeAlert = alertsService.closeAlert;

					$scope.Teams = [];
					$scope.getTeams(null);
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

				$scope.getTeams = function(pageNumber) {
					var team = $scope.createSearchObject(pageNumber);
					teamService.getTeams(team, $scope.getTeamsCompleted,
							$scope.getTeamsError);
				}

				$scope.enter = function(ev) { 
					if (ev.keyCode !== 13) {
					  return; 
					}
					$scope.getTeams('search');
				}

				$scope.getTeamsCompleted = function(response, status) {
					//alertsService.RenderSuccessMessage(response.ReturnMessage);

					if (response.header.code == 0) {
						$scope.Teams = response.data.list;
						$scope.pageSize = response.data.page.pageSize;
						$scope.currentPage = response.data.page.currentPage;
						$scope.TotalPages = response.data.page.pageCount;
						$scope.TotalRows = response.data.page.recordCount;
					}
				}

				$scope.getTeamsError = function(response, status) {
					alertsService.RenderErrorMessage(response.ReturnMessage);
				}


				$scope.pageChanged = function() {
					$scope.getTeams(null);
				}



				var addModalInstanceCtrl = function($scope, $modalInstance) {
					$scope.HeaderText = "新增";
					$scope.teamModal = {};
					$scope.teamModal.teamType = 1;
					$scope.teamStateList = teamService.teamStateList;

					$scope.ok = function() {
						$modalInstance.close($scope.teamModal);
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

					modalInstance.result.then(function(team) {
						teamService.createTeam(team, $scope.editTeamCompleted,
								$scope.editTeamError);
					}, function() {
						// $log.info('Modal dismissed at: ' + new Date());
					});
				};

				var editModalInstanceCtrl = function($scope, $modalInstance,
						team) {

					$scope.HeaderText = "修改";

					
					$scope.teamStateList = teamService.teamStateList;
					

					$scope.teamModal = team;

					$scope.ok = function() {
						var team = new Object();
						$modalInstance.close($scope.teamModal);
					};

					$scope.cancel = function() {
						$modalInstance.dismiss('cancel');
					};
				};

				$scope.editModal = function(id) {
					teamService.getTeam({
						"teamId" : id
					}, function(response) {
						if (response.header.code == 0) {
							var modalInstance = $modal.open({
								templateUrl : 'editModal.html',
								Controller : editModalInstanceCtrl,
								windowClass : 'app-modal-window',
								resolve : {
									team : function() {
										return response.data;
									}
								}
							});
						} else {
							alert(response.header.message);
						}

						modalInstance.result.then(function(team) {
							teamService.updateTeam(team,
									$scope.editTeamCompleted,
									$scope.editTeamError);
						}, function() {
							// $log.info('Modal dismissed at: ' + new Date());
						});
					}, function() {

					})
				};

				$scope.editTeamCompleted = function(response) {
					if (response.header.code == 0) {
						$scope.getTeams(null);
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

				$scope.editTeamError = function(response) {
					toastr.warning("操作失败", '提示', {
						closeButton : true,
						timeOut : 5000
					});
				}

				$scope.deleteOne = function(teamId) {
					if (confirm("确定要删除?")) {
						teamService.deleteTeam({
							"teamId" : teamId
						}, $scope.editTeamCompleted, $scope.editTeamError);
					}
				}

				$scope.exportExcel = function() {
					var searchvo = $scope.createSearchObject(null);
					teamService.exportTeam(searchvo);
				}

			} ]);
});
