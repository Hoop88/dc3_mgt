"use strict";

define([ 'application-configuration', 'bootstrap', 'jquery', 'WdatePicker',
		'ZeroClipboard', 'departmentService', 'alertsService', "dataGridService",
		"encryptService", "upload", 'toastr' ], function(app) {

	app.register.Controller('departmentListController', [
			'$location',
			'$modal',
			'$log',
			'$filter',
			'$scope',
			'$rootScope',
			'$stateParams',
			'$document',
			'departmentService',
			'alertsService',
			"dataGridService",
			"encryptService",
			"$upload",
			'toastr',

			function($location, $modal, $log, $filter, $scope, $rootScope,
					$routeParams, $document, departmentService, alertsService,
					dataGridService, encryptService, $upload, toastr) {
				$scope.initializeController = function() {
					$scope.searchTxt = "";
					$scope.pageSize = 20;
					$scope.departmentTypeMap = departmentService.departmentTypeMap;
					$scope.currentPage = 1;
					$scope.TotalRows = 0;
					$rootScope.closeAlert = alertsService.closeAlert;

					$scope.Departments = [];
					$scope.getDepartments(null);
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

				$scope.getDepartments = function(pageNumber) {
					//var department = $scope.createSearchObject(pageNumber);
					departmentService.getDepTree({}, $scope.getDepartmentsCompleted,
							$scope.getDepartmentsError);
				}

				$scope.getDepartmentsCompleted = function(response, status) {
					alertsService.RenderSuccessMessage(response.ReturnMessage);
					if (status == 200) {
						$scope.depList= departmentService.treeToList(response);
						departmentService.setDepList($scope.depList);
					}
				}

				$scope.getDepartmentsError = function(response, status) {
					alertsService.RenderErrorMessage(response.ReturnMessage);
				}


				$scope.pageChanged = function() {
					$scope.getDepartments(null);
				}



				var addModalInstanceCtrl = function($scope, $modalInstance,depId) {
					$scope.HeaderText = "新增";
					$scope.departmentModal = {};
					$scope.departmentModal.departmentType = 1;
					$scope.departmentModal.parentId = parseInt(depId);
					
					console.log($scope.departmentModal.parentId);
					
					$scope.departmentTypeList = departmentService.departmentTypeList;
					$scope.depList = departmentService.depList;
					
					$scope.ok = function() {
						$modalInstance.close($scope.departmentModal);
					};

					$scope.cancel = function() {
						$modalInstance.dismiss('cancel');
					};
				};
				
				$scope.addModal = function(id) {
					console.log(id);
					var modalInstance = $modal.open({
						templateUrl : 'addModal.html',
						Controller : addModalInstanceCtrl,
						windowClass : 'app-modal-window',
						resolve : {
									depId: function() {
										return id;
									}
						}
					});

					modalInstance.result.then(function(department) {
						departmentService.createDepartment(department, $scope.editDepartmentCompleted,
								$scope.editDepartmentError);
					}, function() {
						// $log.info('Modal dismissed at: ' + new Date());
					});
				};

				var editModalInstanceCtrl = function($scope, $modalInstance,
						department) {

					$scope.HeaderText = "修改";

					$scope.departmentTypeList = departmentService.departmentTypeList;
					$scope.depList = departmentService.depList;
					$scope.departmentModal = department;

					$scope.ok = function() {
						$modalInstance.close($scope.departmentModal);
					};

					$scope.cancel = function() {
						$modalInstance.dismiss('cancel');
					};
				};

				$scope.editModal = function(id) {
					departmentService.getDepartment({
						"depId" : id
					}, function(response) {
						if (response.header.code == 0) {
							var modalInstance = $modal.open({
								templateUrl : 'editModal.html',
								Controller : editModalInstanceCtrl,
								windowClass : 'app-modal-window',
								resolve : {
									department : function() {
										return response.data;
									}
								}
							});
						} else {
							alert(response.header.message);
						}

						modalInstance.result.then(function(department) {
							departmentService.updateDepartment(department,
									$scope.editDepartmentCompleted,
									$scope.editDepartmentError);
						}, function() {
							// $log.info('Modal dismissed at: ' + new Date());
						});
					}, function() {

					})
				};

				$scope.editDepartmentCompleted = function(response) {
					if (response.header.code == 0) {
						$scope.getDepartments(null);
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

				$scope.editDepartmentError = function(response) {
					toastr.warning("操作失败", '提示', {
						closeButton : true,
						timeOut : 5000
					});
				}

				$scope.deleteOne = function(depId) {
					if (confirm("确定要删除?")) {
						departmentService.deleteDepartment({
							"depId" : depId
						}, $scope.editDepartmentCompleted, $scope.editDepartmentError);
					}
				}

				$scope.exportDepartment = function(i) {

					var form = $("<form>"); // 定义一个form表单
					form.attr('style', 'display:none'); // 在form表单中添加查询参数
					form.attr('target', '');
					form.attr('method', 'post');
					form.attr('action', "/api/ExportHandler.ashx");
					var input1 = $('<input>');
					input1.attr('type', 'hidden');
					input1.attr('name', 'MeetID');
					input1.attr('value', $scope.Departments[i].ID);
					$('body').append(form); // 将表单放置在web中
					form.append(input1); // 将查询参数控件提交到表单上
					form.submit(); // 表单提交
				}

			} ]);
});
