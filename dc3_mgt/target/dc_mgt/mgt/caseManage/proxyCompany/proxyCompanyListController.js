"use strict";

define([ 'application-configuration', 'bootstrap', 'jquery', 'WdatePicker',
		'ZeroClipboard', 'proxyCompanyService', 'alertsService', "dataGridService",
		"encryptService", "upload", 'toastr' ], function(app) {

	app.register.Controller('proxyCompanyListController', [
			'$location',
			'$modal',
			'$log',
			'$filter',
			'$scope',
			'$rootScope',
			'$stateParams',
			'$document',
			'proxyCompanyService',
			'alertsService',
			"dataGridService",
			"encryptService",
			"$upload",
			'toastr',

			function($location, $modal, $log, $filter, $scope, $rootScope,
					$routeParams, $document, proxyCompanyService, alertsService,
					dataGridService, encryptService, $upload, toastr) {
				$scope.initializeController = function() {
					$scope.searchTxt = "";
					$scope.pageSize = 20;
					$scope.proxyCompanyStateMap = proxyCompanyService.proxyCompanyStateMap;
					proxyCompanyService.initData();
					
					$scope.currentPage = 1;
					$scope.TotalRows = 0;
					$rootScope.closeAlert = alertsService.closeAlert;
					$scope.getCityProjectTree();
					$scope.ProxyCompanys = [];
					
					$scope.getProxyCompanys(null);
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
				
				$scope.getCityProjectTree = function() {
					proxyCompanyService.getCityProjectTree({}, $scope.getCityProjectTreeCompleted,
							function(){});
				}

				$scope.getCityProjectTreeCompleted= function(response, status) {
					if (status == 200) {
						proxyCompanyService.setCityProjectTree(response);
					}
			    }
				
				
				$scope.getProxyCompanys = function(pageNumber) {
					var proxyCompany = $scope.createSearchObject(pageNumber);
					proxyCompanyService.getProxyCompanys(proxyCompany, $scope.getProxyCompanysCompleted,
							$scope.getProxyCompanysError);
				}

				$scope.enter = function(ev) { 
					if (ev.keyCode !== 13) {
					  return; 
					}
					$scope.getProxyCompanys('search');
				}

				$scope.getProxyCompanysCompleted = function(response, status) {
					//alertsService.RenderSuccessMessage(response.ReturnMessage);
					$scope.projectCodeMap1=proxyCompanyService.projectCodeMap1;
					if (response.header.code == 0) {
						$scope.ProxyCompanys = response.data.list;
						$scope.pageSize = response.data.page.pageSize;
						$scope.currentPage = response.data.page.currentPage;
						$scope.TotalPages = response.data.page.pageCount;
						$scope.TotalRows = response.data.page.recordCount;
					}
				}

				$scope.getProxyCompanysError = function(response, status) {
					alertsService.RenderErrorMessage(response.ReturnMessage);
				}


				$scope.pageChanged = function() {
					$scope.getProxyCompanys(null);
				}

				var addModalInstanceCtrl = function($scope, $modalInstance) {
					$scope.HeaderText = "新增";
					$scope.proxyCompanyModal = {};
					$scope.proxyCompanyModal.companyType = 2;
					$scope.proxyCompanyModal.state = 1;
					$scope.proxyCompanyStateList = proxyCompanyService.proxyCompanyStateList;
					$scope.cityProjectTree = proxyCompanyService.cityProjectTree;
					
					$scope.ok = function() {
						$modalInstance.close($scope.proxyCompanyModal);
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

					modalInstance.result.then(function(proxyCompany) {
						proxyCompanyService.createProxyCompany(proxyCompany, $scope.editProxyCompanyCompleted,
								$scope.editProxyCompanyError);
					}, function() {
						// $log.info('Modal dismissed at: ' + new Date());
					});
				};

				var editModalInstanceCtrl = function($scope, $modalInstance,
						proxyCompany) {

					$scope.HeaderText = "修改";

					$scope.proxyCompanyStateList = proxyCompanyService.proxyCompanyStateList;
					$scope.cityProjectTree = proxyCompanyService.cityProjectTree;
					$scope.projectCodeMap1=proxyCompanyService.projectCodeMap1;

					$scope.proxyCompanyModal = proxyCompany;

					$scope.ok = function() {
						var proxyCompany = new Object();
						$modalInstance.close($scope.proxyCompanyModal);
					};

					$scope.cancel = function() {
						$modalInstance.dismiss('cancel');
					};
				};

				$scope.editModal = function(id) {
					proxyCompanyService.getProxyCompany({
						"companyId" : id
					}, function(response) {
						if (response.header.code == 0) {
							var modalInstance = $modal.open({
								templateUrl : 'editModal.html',
								Controller : editModalInstanceCtrl,
								windowClass : 'app-modal-window',
								resolve : {
									proxyCompany : function() {
										return response.data;
									}
								}
							});
						} else {
							alert(response.header.message);
						}

						modalInstance.result.then(function(proxyCompany) {
							proxyCompanyService.updateProxyCompany(proxyCompany,
									$scope.editProxyCompanyCompleted,
									$scope.editProxyCompanyError);
						}, function() {
							// $log.info('Modal dismissed at: ' + new Date());
						});
					}, function() {

					})
				};

				$scope.editProxyCompanyCompleted = function(response) {
					if (response.header.code == 0) {
						$scope.getProxyCompanys(null);
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

				$scope.editProxyCompanyError = function(response) {
					toastr.warning("操作失败", '提示', {
						closeButton : true,
						timeOut : 5000
					});
				}

				$scope.deleteOne = function(companyId) {
					if (confirm("确定要删除?")) {
						proxyCompanyService.deleteProxyCompany({
							"companyId" : companyId
						}, $scope.editProxyCompanyCompleted, $scope.editProxyCompanyError);
					}
				}

				$scope.exportExcel = function() {
					var searchvo = $scope.createSearchObject(null);
					proxyCompanyService.exportProxyCompany(searchvo);
				}

			} ]);
});
