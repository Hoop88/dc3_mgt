"use strict";

define([ 'application-configuration', 'bootstrap', 'jquery', 'WdatePicker',
		'ZeroClipboard', 'sysUserService', 'alertsService', "dataGridService",
		"encryptService", "upload", 'toastr','jstree' ], function(app) {

	app.register.Controller('sysUserListController', [
			'$location',
			'$modal',
			'$log',
			'$filter',
			'$scope',
			'$rootScope',
			'$stateParams',
			'$document',
			'sysUserService',
			'alertsService',
			"dataGridService",
			"encryptService",
			"$upload",
			'toastr',

			function($location, $modal, $log, $filter, $scope, $rootScope,
					$routeParams, $document, sysUserService, alertsService,
					dataGridService, encryptService, $upload, toastr) {
				$scope.initializeController = function() {
					$scope.searchTxt = "";
					$scope.pageSize = 20;
					$scope.sysUserTypeMap = sysUserService.sysUserTypeMap;
					$scope.sysUserStateMap = sysUserService.sysUserStateMap;
					$scope.currentPage = 1;
					$scope.TotalRows = 0;
					$rootScope.closeAlert = alertsService.closeAlert;
					
 					$scope.getDepTree();
					$scope.getSysRoleList();
  
					$scope.SysUsers = [];
					//$scope.getSysUsers(null);
					$scope.FileUpload;
					
					$('#ajax').jstree({
							  "core" : {
								"animation" : 0,
								"check_callback" : true,
								"themes" : { "stripes" : true },
								'data' : {
									"url" : "system/departmentTree",
									"dataType" : "json" // needed only if you do not supply JSON headers
								}
							  },
							  "types" : {
								"#" : {
								  "max_children" : 1, 
								  "max_depth" : 4, 
								  "valid_children" : ["root"]
								},
								"root" : {
								  "icon" : "/st_mgt/jstree/dist/images/tree_icon.png",
								  "valid_children" : ["default"]
								},
								"default" : {
								  "valid_children" : ["default","file"]
								},
								"file" : {
								  "icon" : "glyphicon glyphicon-file",
								  "valid_children" : []
								}
							  },
							  "plugins" : [
								 "dnd", "search",
								"state", "types", "wholerow"
							  ]
							});
							
						$('#ajax').on("select_node.jstree", function (e, data) {
						
							$scope.depId=parseInt(data.selected[0]);
							$scope.searchTxt="";
							$scope.getSysUsers(null);
					        console.log(data.selected[0]);
					});
				}

				$scope.createSearchObject = function(search) {
					var searchVo = new Object();
					if (search != null)
						searchVo.currentPage = 1;
					else
						searchVo.currentPage = $scope.currentPage;
						
					searchVo.pageSize = $scope.pageSize;
					searchVo.searchTxt = $scope.searchTxt;
					searchVo.depId=$scope.depId;
					return searchVo;
				}

				$scope.getSysUsers = function(pageNumber) {
					var sysUser = $scope.createSearchObject(pageNumber);
					sysUserService.getSysUsers(sysUser, $scope.getSysUsersCompleted,
							$scope.getSysUsersError);
				}
				
				$scope.enter = function(ev) { 
					if (ev.keyCode !== 13) {
					  return; 
					}
					$scope.getSysUsers('search');
				}

				$scope.getSysUsersCompleted = function(response, status) {
					alertsService.RenderSuccessMessage(response.ReturnMessage);

					if (response.header.code == 0) {
						$scope.SysUsers = response.data.list;
						$scope.pageSize = response.data.page.pageSize;
						$scope.currentPage = response.data.page.currentPage;
						$scope.TotalPages = response.data.page.pageCount;
						$scope.TotalRows = response.data.page.recordCount;
					}
				}

				$scope.getSysUsersError = function(response, status) {
					alertsService.RenderErrorMessage(response.ReturnMessage);
				}

				$scope.getDepTree = function() {
					sysUserService.getDepTree(null, $scope.getDepTreeCompleted,
							function(){});
				}
				
				$scope.getDepTreeCompleted=function(response, status){
					if (status == 200) {
						var depList= sysUserService.treeToList(response);
						sysUserService.setDepList(depList);
			 			console.log(depList);
					}
				}
				
				$scope.getSysRoleList = function() {
					sysUserService.getSysRoleList(null, $scope.getSysRoleListCompleted,
							function(){});
				}
				
				$scope.getSysRoleListCompleted=function(response, status){
					
					if (status == 200) {
						sysUserService.setSysRoleList(response.data);
					}
				}

				$scope.pageChanged = function() {
					$scope.getSysUsers(null);
				}
				
				$scope.exportExcel = function() {
					var searchvo = $scope.createSearchObject(null);
					sysUserService.exportSysUser(searchvo);
				}
				
				var addModalInstanceCtrl = function($scope, $modalInstance) {
					$scope.HeaderText = "新增";
					$scope.sysUserModal = {};
					$scope.sysUserModal.userType = 1;
					$scope.sysUserModal.state = 1;
					$scope.sysUserModal.depId = $rootScope.depId;
					$scope.sysUserTypeList = sysUserService.sysUserTypeList;
					$scope.sysUserStateList = sysUserService.sysUserStateList;
					$scope.sysRoleList = sysUserService.sysRoleList;
					$scope.depList = sysUserService.depList;
					console.log($scope.depList);
					$scope.ok = function() {
						$modalInstance.close($scope.sysUserModal);
					};

					$scope.cancel = function() {
						$modalInstance.dismiss('cancel');
					};
				};
				
				$scope.addModal = function() {
					
					$rootScope.depId=$scope.depId;

					var modalInstance = $modal.open({
						templateUrl : 'addModal.html',
						Controller : addModalInstanceCtrl,
						windowClass : 'app-modal-window'
					});

					modalInstance.result.then(function(sysUser) {
						sysUserService.createSysUser(sysUser, $scope.editSysUserCompleted,
								$scope.editSysUserError);
					}, function() {
						// $log.info('Modal dismissed at: ' + new Date());
					});
				};

				var editModalInstanceCtrl = function($scope, $modalInstance,
						sysUser) {

					$scope.HeaderText = "修改";

					$scope.sysUserTypeList = sysUserService.sysUserTypeList;
					$scope.sysUserStateList = sysUserService.sysUserStateList;
					$scope.sysRoleList = sysUserService.sysRoleList;

					$scope.depList = sysUserService.depList;

					$scope.sysUserModal = sysUser;

					$scope.ok = function() {
						var sysUser = new Object();
						$modalInstance.close($scope.sysUserModal);
					};

					$scope.cancel = function() {
						$modalInstance.dismiss('cancel');
					};
				};

				$scope.editModal = function(id) {
					sysUserService.getSysUser({
						"userId" : id
					}, function(response) {
						if (response.header.code == 0) {
							var modalInstance = $modal.open({
								templateUrl : 'editModal.html',
								Controller : editModalInstanceCtrl,
								windowClass : 'app-modal-window',
								resolve : {
									sysUser : function() {
										return response.data;
									}
								}
							});
						} else {
							alert(response.header.message);
						}

						modalInstance.result.then(function(sysUser) {
							sysUserService.updateSysUser(sysUser,
									$scope.editSysUserCompleted,
									$scope.editSysUserError);
						}, function() {
							// $log.info('Modal dismissed at: ' + new Date());
						});
					}, function() {

					})
				};
				

				$scope.editSysUserCompleted = function(response) {
					if (response.header.code == 0) {
						$scope.getSysUsers(null);
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

				$scope.editSysUserError = function(response) {
					toastr.warning("操作失败", '提示', {
						closeButton : true,
						timeOut : 5000
					});
				}

				$scope.deleteOne = function(userId) {
					if (confirm("确定要删除?")) {
						sysUserService.deleteSysUser({
							"userId" : userId
						}, $scope.editSysUserCompleted, $scope.editSysUserError);
					}
				}

			} ]);
});
