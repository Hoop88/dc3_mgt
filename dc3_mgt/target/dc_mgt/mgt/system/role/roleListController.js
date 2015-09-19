"use strict";

define([ 'application-configuration', 'bootstrap', 'jquery', 'WdatePicker',
		'ZeroClipboard', 'roleService', 'alertsService', "dataGridService",
		"encryptService", "upload", 'toastr','jstree' ], function(app) {

	app.register.Controller('roleListController', [
			'$location',
			'$modal',
			'$log',
			'$filter',
			'$scope',
			'$rootScope',
			'$stateParams',
			'$document',
			'roleService',
			'alertsService',
			"dataGridService",
			"encryptService",
			"$upload",
			'toastr',

			function($location, $modal, $log, $filter, $scope, $rootScope,
					$routeParams, $document, roleService, alertsService,
					dataGridService, encryptService, $upload, toastr) {
				$scope.initializeController = function() {
					$scope.searchTxt = "";
					$scope.pageSize = 20;
					$scope.roleTypeMap = roleService.roleTypeMap;
					$scope.currentPage = 1;
					$scope.TotalRows = 0;
					$rootScope.closeAlert = alertsService.closeAlert;

					$scope.Roles = [];
					$scope.getRoles(null);
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

				$scope.getRoles = function(pageNumber) {
					var role = $scope.createSearchObject(pageNumber);
					roleService.getRoles(role, $scope.getRolesCompleted,
							$scope.getRolesError);
				}

				$scope.getRolesCompleted = function(response, status) {
					

					if (response.header.code == 0) {
						$scope.Roles = response.data.list;
						$scope.pageSize = response.data.page.pageSize;
						$scope.currentPage = response.data.page.currentPage;
						$scope.TotalPages = response.data.page.pageCount;
						$scope.TotalRows = response.data.page.recordCount;
					}
				}

				$scope.getRolesError = function(response, status) {
					alertsService.RenderErrorMessage(response.ReturnMessage);
				}


				$scope.pageChanged = function() {
					$scope.getRoles(null);
				}



				var addModalInstanceCtrl = function($scope, $modalInstance) {
					$scope.HeaderText = "新增";
					$scope.RoleModal = {};
					$scope.RoleModal.roleName = "test";
					$scope.RoleModal.roleType = 1;
					$scope.roleTypeMap = roleService.roleTypeMap;
					$scope.roleTypeList = roleService.roleTypeList;

					$scope.ok = function() {
						$modalInstance.close($scope.RoleModal);
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

					modalInstance.result.then(function(role) {
						roleService.createRole(role, $scope.editRoleCompleted,
								$scope.editRoleError);
					}, function() {
						// $log.info('Modal dismissed at: ' + new Date());
					});
				};

				var editModalInstanceCtrl = function($scope, $modalInstance,
						Role) {
					console.log("init");
					$scope.HeaderText = "修改";
					$scope.roleTypeMap = roleService.roleTypeMap;
					$scope.roleTypeList = roleService.roleTypeList;

					console.dir($scope.roleTypeMap);

					$scope.RoleModal = Role;

					$scope.ok = function() {
						var role = new Object();
						$modalInstance.close($scope.RoleModal);
					};

					$scope.cancel = function() {
						$modalInstance.dismiss('cancel');
					};
				};

				$scope.editModal = function(id) {
					roleService.getRole({
						"roleId" : id
					}, function(response) {
						if (response.header.code == 0) {
							var modalInstance = $modal.open({
								templateUrl : 'editModal.html',
								Controller : editModalInstanceCtrl,
								windowClass : 'app-modal-window',
								resolve : {
									Role : function() {
										console.log(1111123);
										console.dir(response.data.roleName);
										return response.data;
									}
								}
							});
						} else {
							alert(response.header.message);
						}

						modalInstance.result.then(function(role) {
							roleService.updateRole(role,
									$scope.editRoleCompleted,
									$scope.editRoleError);
						}, function() {
							// $log.info('Modal dismissed at: ' + new Date());
						});
					}, function() {

					})
				};

				$scope.editRoleCompleted = function(response) {
					if (response.header.code == 0) {
						$scope.getRoles(null);
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

				$scope.editRoleError = function(response) {
					toastr.warning("操作失败", '提示', {
						closeButton : true,
						timeOut : 5000
					});
				}

				$scope.deleteOne = function(roleId) {
					if (confirm("确定要删除?")) {
						roleService.deleteRole({
							"roleId" : roleId
						}, $scope.editRoleCompleted, $scope.editRoleError);
					}
				}
				
				var powerModalInstanceCtrl = function($scope, $modalInstance,
						Role) {
					$scope.roleTypeMap = roleService.roleTypeMap;
					$scope.roleTypeList = roleService.roleTypeList;

					$scope.RoleModal = Role;
					
					$scope.initTree=function(){
						
							$('#powerTree').jstree({
							  "core" : {
								"animation" : 0,
								"check_callback" : true,
								"themes" : { "stripes" : true },
								"checkbox" : {
								  "keep_selected_style" : false
								},
								'data' : {
									"url" : "system/functionTree",
									"dataType" : "json" // needed only if you do not supply JSON headers
								}
							  },
							  "plugins" : ["checkbox"]
							}).bind("loaded.jstree",function(){
							
							console.log("====1======");
							console.log(Role.idList);
							$("#powerTree").jstree("open_all");
							//$("#powerTree").jstree("check_node",Role.idList);
							$("#powerTree").jstree("check_node",Role.idList);
							console.log("=====1=====");		
								
							});
					}
					
					$scope.ok = function() {
						var role = new Object();
						var ids = $("#powerTree").jstree("get_checked");
						var idList = [];
						for(var id in ids)
						{
							var obj = {};
							obj.id = parseInt(ids[id]);
							idList.push(obj);
						}
						console.log(idList);
						$scope.RoleModal.idList = idList;
						$modalInstance.close($scope.RoleModal);
					};

					$scope.cancel = function() {
						$modalInstance.dismiss('cancel');
					};
				};
				
				$scope.powerModal = function(id) {
					roleService.getRole({
						"roleId" : id
					}, function(response) {
						if (response.header.code == 0) {
							var modalInstance = $modal.open({
								templateUrl : 'powerModal.html',
								Controller : powerModalInstanceCtrl,
								windowClass : 'app-modal-window',
								resolve : {
									Role : function() {
										return response.data;
									}
								}
							});
							
						} else {
							alert(response.header.message);
						}

						
						
						modalInstance.result.then(function(role) {
							roleService.updateRolePower(role,
									$scope.editRoleCompleted,
									$scope.editRoleError);
						}, function() {
							// $log.info('Modal dismissed at: ' + new Date());
						});
					}, function() {

					});
					
				};
				

			} ]);
});