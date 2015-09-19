"use strict";

define([ 'application-configuration', 'bootstrap','bootstrap-select', 'jquery', 'WdatePicker',
		'ZeroClipboard', 'cityCompanyService', 'alertsService', "dataGridService",
		"encryptService", "upload", 'toastr' ], function(app) {

	app.register.Controller('cityCompanyListController', [
			'$location',
			'$modal',
			'$log',
			'$filter',
			'$scope',
			'$rootScope',
			'$stateParams',
			'$document',
			'cityCompanyService',
			'alertsService',
			"dataGridService",
			"encryptService",
			"$upload",
			'toastr',

			function($location, $modal, $log, $filter, $scope, $rootScope,
					$routeParams, $document, cityCompanyService, alertsService,
					dataGridService, encryptService, $upload, toastr) {
				$scope.initializeController = function() {
					$scope.searchTxt = "";
					$scope.pageSize = 20;
					$scope.cityCompanyStateMap = cityCompanyService.cityCompanyStateMap;
					$scope.currentPage = 1;
					$scope.TotalRows = 0;
					$rootScope.closeAlert = alertsService.closeAlert;

					$scope.CityCompanys = [];
					$scope.getCityCompanys(null);
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

				$scope.getCityCompanys = function(pageNumber) {
					var cityCompany = $scope.createSearchObject(pageNumber);
					cityCompanyService.getCityCompanys(cityCompany, $scope.getCityCompanysCompleted,
							$scope.getCityCompanysError);
				}

				$scope.enter = function(ev) { 
					if (ev.keyCode !== 13) {
					  return; 
					}
					$scope.getCityCompanys('search');
				}

				$scope.getCityCompanysCompleted = function(response, status) {
					alertsService.RenderSuccessMessage(response.ReturnMessage);

					if (response.header.code == 0) {
						$scope.CityCompanys = response.data.list;
						$scope.pageSize = response.data.page.pageSize;
						$scope.currentPage = response.data.page.currentPage;
						$scope.TotalPages = response.data.page.pageCount;
						$scope.TotalRows = response.data.page.recordCount;
					}
				}

				$scope.getCityCompanysError = function(response, status) {
					alertsService.RenderErrorMessage(response.ReturnMessage);
				}


				$scope.pageChanged = function() {
					$scope.getCityCompanys(null);
				}



				var addModalInstanceCtrl = function($scope, $modalInstance) {
					$scope.HeaderText = "新增";
					$scope.cityCompanyModal = {};
					$scope.cityCompanyModal.companyType = 1;
					$scope.cityCompanyModal.state = 1;
					$scope.cityCompanyStateList = cityCompanyService.cityCompanyStateList;

					$scope.ok = function() {
						$modalInstance.close($scope.cityCompanyModal);
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

					modalInstance.result.then(function(cityCompany) {
						cityCompanyService.createCityCompany(cityCompany, $scope.editCityCompanyCompleted,
								$scope.editCityCompanyError);
					}, function() {
						// $log.info('Modal dismissed at: ' + new Date());
					});
				};

				var editModalInstanceCtrl = function($scope, $modalInstance,
						cityCompany) {

					$scope.HeaderText = "修改";

					$scope.cityCompanyStateList = cityCompanyService.cityCompanyStateList;

					$scope.cityCompanyModal = cityCompany;

					$scope.ok = function() {
						var cityCompany = new Object();
						$modalInstance.close($scope.cityCompanyModal);
					};

					$scope.cancel = function() {
						$modalInstance.dismiss('cancel');
					};
				};

				$scope.editModal = function(id) {
					cityCompanyService.getCityCompany({
						"companyId" : id
					}, function(response) {
						if (response.header.code == 0) {
							var modalInstance = $modal.open({
								templateUrl : 'editModal.html',
								Controller : editModalInstanceCtrl,
								windowClass : 'app-modal-window',
								resolve : {
									cityCompany : function() {
										return response.data;
									}
								}
							});
						} else {
							alert(response.header.message);
						}

						modalInstance.result.then(function(cityCompany) {
							cityCompanyService.updateCityCompany(cityCompany,
									$scope.editCityCompanyCompleted,
									$scope.editCityCompanyError);
						}, function() {
							// $log.info('Modal dismissed at: ' + new Date());
						});
					}, function() {

					})
				};

				$scope.editCityCompanyCompleted = function(response) {
					if (response.header.code == 0) {
						$scope.getCityCompanys(null);
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

				$scope.editCityCompanyError = function(response) {
					toastr.warning("操作失败", '提示', {
						closeButton : true,
						timeOut : 5000
					});
				}

				$scope.deleteOne = function(companyId) {
					if (confirm("确定要删除?")) {
						cityCompanyService.deleteCityCompany({
							"companyId" : companyId
						}, $scope.editCityCompanyCompleted, $scope.editCityCompanyError);
					}
				}

				$scope.exportExcel = function() {
					var searchvo = $scope.createSearchObject(null);
					cityCompanyService.exportCityCompany(searchvo);
				}

			} ]);
});
