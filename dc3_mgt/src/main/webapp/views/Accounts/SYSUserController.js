"use strict";

define(['application-configuration', 'jquery', 'WdatePicker', 'ZeroClipboard', 'chargeService', 'userInfoService', 'alertsService', "dataGridService", "encryptService", "upload", 'toastr'], function (app) {
    //console.dir(app);

    app.register.Controller('SYSUserController', ['$location', '$modal', '$log', '$filter', '$scope', '$rootScope', '$document',
        'chargeService', 'userInfoService', 'alertsService', "dataGridService", "encryptService", "$upload", 'toastr',

  function ($location, $modal, $log, $filter, $scope, $rootScope, $document, chargeService, userInfoService, alertsService, dataGridService, encryptService, $upload, toastr) {
    

      $scope.testa = "hahaha";
      var pageSize = 10;
      var SortDirection = "Desc";
      var SortExpression = "Name";
      var currentPage = 1;
      $scope.initializeController = function () {
          //alert(2222);
          $scope.ID = 0;
          $scope.Title = "aa";
          $scope.Description = "";
          $scope.searchText = "";
          $scope.pageSize = pageSize;
          $scope.SortDirection = SortDirection;
          $scope.SortExpression = SortExpression;
          $scope.currentPage = currentPage;
          $scope.TotalRows = 0;
          $rootScope.closeAlert = alertsService.closeAlert;
          $scope.RoleMeus = [];
          $scope.UserInfos = [];
          $scope.getUserInfos(null);
      }

      $scope.getUserInfos = function (search) {
          var userInfo = $scope.createChargeBatchObject(search);
          userInfoService.getSYSUsers(userInfo, $scope.userInfoCompleted, $scope.userInfoError);
      }

      $scope.userInfoCompleted = function (response, status) {
          $scope.UserInfos = response.SYSUsers;
          $scope.RoleMenus = response.RoleMenus;
          $scope.TotalProducts = response.TotalRows;
          $scope.TotalPages = response.TotalPages;
          $scope.TotalRows = response.TotalRows;
          $scope.UserID = response.UserID;
      }

      $scope.userInfoError = function (response, status) {
          alertsService.RenderErrorMessage(response.ReturnMessage[0]);
      }

      $scope.getChargeBatch = function () {
          alert("test");
      }

      $scope.pageChanged = function () {
          $scope.getUserInfos(null);
      }

      $scope.createChargeBatchObject = function (search) {

          var chargeBatch = new Object();
          chargeBatch.ID = $scope.ID;
          chargeBatch.searchText = $scope.searchText;
          if (search!=null)
              chargeBatch.currentPage = 1;
          else
              chargeBatch.currentPage = $scope.currentPage;
          chargeBatch.SortExpression = $scope.SortExpression;
          chargeBatch.SortDirection = $scope.SortDirection;
          chargeBatch.pageSize = $scope.pageSize;

          return chargeBatch;
      }

      var addModalInstanceCtrl = function ($scope, $modalInstance,RoleMenus,CurUserID) {
          $scope.HeaderText = "新增";
          $scope.ID = 0;
          $scope.thisRoleIDToEdit = '';
          $scope.thisUserIDToEdit = '';
          $scope.thisNameToEdit = '';
          $scope.thisRemarkToEdit = '';
          $scope.thisPasswordToEdit = '';
          $scope.thisSuperPasswordToEdit = '';
          $scope.RoleMenus = RoleMenus;
          $scope.CurUserID = CurUserID;
          $scope.ok = function (ID, thisRoleIDToEdit, thisUserIDToEdit, thisNameToEdit, thisRemarkToEdit, thisPasswordToEdit, thisSuperPasswordToEdit) {
              var userInfo = new Object();
              userInfo.ID = 0;
              userInfo.RoleName= thisRoleIDToEdit;
              userInfo.UserID = thisUserIDToEdit;
              userInfo.Name = thisNameToEdit;
              userInfo.Remark = thisRemarkToEdit;
              userInfo.Password = thisPasswordToEdit;
              userInfo.SuperPassword = thisSuperPasswordToEdit;
              $scope.existsUserID(userInfo);
              $scope.UserInfo = userInfo;
          };

          $scope.existsUserID = function (userInfo) {
              userInfoService.existsSYSUser(userInfo, $scope.Success, $scope.Warning);
          }

          $scope.Success = function (txt) {
              toastr.success(txt.ReturnMessage[0], '提示', {
                  closeButton: true,
                  timeOut: 5000
              });
              $modalInstance.close($scope.UserInfo);
          }

          $scope.Warning = function (txt) {
              toastr.warning(txt.ReturnMessage[0], '提示', {
                  closeButton: true,
                  timeOut: 5000
              });
          }

          $scope.cancel = function () {
              $modalInstance.dismiss('cancel');
          };
      };
      $scope.addLineItemModal = function () {

          var modalInstance = $modal.open({
              templateUrl: 'addLineItemModal.html',
              Controller: addModalInstanceCtrl,
              windowClass: 'app-modal-window',
              resolve: {
                  RoleMenus: function () {
                      return $scope.RoleMenus;
                  },
                  CurUserID: function () {
                      return $scope.UserID;
                  }
              }
          });

          modalInstance.result.then(function (userInfo) {
              $scope.UserInfo = userInfo;
              userInfoService.createSYSUser(userInfo, $scope.createUserInfo, $scope.editChargeBatchLineItemError);
          }, function () {
              //$log.info('Modal dismissed at: ' + new Date());
          });
      };

      $scope.createUserInfo = function (response) {
          $scope.editChargeBatchLineItemCompleted(response);
          $scope.getUserInfos(null);
      }     

      var editModalInstanceCtrl = function ($scope, $modalInstance, UserInfo, RoleMenus,CurUserID) {
          $scope.HeaderText = "编辑";
          $scope.ID = UserInfo.ID;
          $scope.thisRoleIDToEdit = UserInfo.RoleID;
          $scope.thisUserIDToEdit = UserInfo.UserID;
          $scope.thisNameToEdit = UserInfo.Name;
          $scope.thisRemarkToEdit = UserInfo.Remark;
          $scope.thisPasswordToEdit = UserInfo.Password;
          $scope.thisSuperPasswordToEdit = UserInfo.SuperPassword;
          //console.log(UserInfo);
          //console.log(RoleMenus);
          //console.log(CurUserID);
          $scope.RoleMenus = RoleMenus;
          $scope.CurUserID = CurUserID;
          $scope.ok = function (ID, thisRoleIDToEdit, thisUserIDToEdit, thisNameToEdit, thisRemarkToEdit, thisPasswordToEdit, thisSuperPasswordToEdit) {
              var userInfo = new Object();
              userInfo.ID = UserInfo.ID;
              userInfo.RoleName = thisRoleIDToEdit;
              userInfo.UserID = thisUserIDToEdit;
              userInfo.Name = thisNameToEdit;
              userInfo.Remark = thisRemarkToEdit;
              userInfo.Password = thisPasswordToEdit;
              userInfo.SuperPassword = thisSuperPasswordToEdit;
              $modalInstance.close(userInfo);
          };
          $scope.cancel = function () {
              $modalInstance.dismiss('cancel');
          };
      };

      $scope.editLineItemModal = function (i) {
          var modalInstance = $modal.open({
              templateUrl: 'addLineItemModal.html',
              Controller: editModalInstanceCtrl,
              windowClass: 'app-modal-window',
              resolve: {
                  UserInfo: function () {
                      return $scope.UserInfos[i];
                  },
                  RoleMenus: function () {
                      return $scope.RoleMenus;
                  },
                  CurUserID: function () {
                      return $scope.UserID;
                  }
              }
          });
          //console.log("star");
          modalInstance.result.then(function (userInfo) {
             
              $scope.UserInfo = userInfo;
              userInfoService.updateSYSUser(userInfo, $scope.editUserInfoComplted, $scope.editChargeBatchLineItemError);
          }, function () {
              //console.log(22222);
              //$log.info('Modal dismissed at: ' + new Date());
          });
      };

      $scope.editUserInfoComplted = function (response) {
          $scope.editChargeBatchLineItemCompleted(response);
          $scope.getUserInfos(null);
      }

      $scope.editChargeBatchLineItemCompleted = function (response) {
          toastr.success(response.ReturnMessage[0], '提示', {
              closeButton: true,
              timeOut: 5000
          });
          $scope.getUserInfos(null);
      }

      $scope.editChargeBatchLineItemError = function (response) {
          toastr.warning(response.ReturnMessage[0], '提示', {
              closeButton: true,
              timeOut: 5000
          });
      }


      $scope.deleteLineItem = function (i) {
          if (confirm("确定要删除该人员信息?")) {
              userInfoService.deleteSYSUser($scope.UserInfos[i], $scope.editChargeBatchLineItemCompleted, $scope.editChargeBatchLineItemError);
          }
      }


      $scope.Success = function (txt) {
          toastr.success(txt, '提示', {
              closeButton: true,
              timeOut: 5000
          });
      }

      $scope.Warning = function (txt) {
          toastr.warning(txt, '提示', {
              closeButton: true,
              timeOut: 5000
          });
      }

  }]);
});

