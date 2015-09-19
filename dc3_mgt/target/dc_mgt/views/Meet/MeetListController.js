"use strict";

define(['application-configuration', 'bootstrap', 'jquery', 'WdatePicker', 'ZeroClipboard', 'meetingService', 'alertsService', "dataGridService", "encryptService", "upload", 'toastr'], function (app) {

    app.register.Controller('MeetInfoListController', ['$location', '$modal', '$log', '$filter', '$scope', '$rootScope', '$stateParams', '$document',
        'meetingService', 'alertsService', "dataGridService", "encryptService", "$upload", 'toastr',

  function ($location, $modal, $log, $filter, $scope, $rootScope, $routeParams, $document, meetingService, alertsService, dataGridService, encryptService, $upload, toastr) {
      var PageSize = 10;
      var SortDirection = "Desc";
      var SortExpression = "CreateTime";
      var CurrentPageNumber = 1;
      $scope.initializeController = function () {

          $scope.ID = 0;
          $scope.Title = "aa";
          $scope.Description = "";
          $scope.SearchText = "";
          $scope.PageSize = PageSize;
          $scope.SortDirection = SortDirection;
          $scope.SortExpression = SortExpression;
          $scope.CurrentPageNumber = CurrentPageNumber;
          $scope.TotalRows = 0;
          $rootScope.closeAlert = alertsService.closeAlert;

          $scope.MeetInfos = [];
          $scope.getMeetInfos(null);
          $scope.FileUpload;
      }

      $scope.getMeetInfos = function (search) {
          var meetInfo = $scope.createMeetInfoObject(search);
          meetingService.getMeetInfos(meetInfo, $scope.meetInfoCompleted, $scope.meetInfoError);
      }

      $scope.meetInfoCompleted = function (response, status) {
          alertsService.RenderSuccessMessage(response.ReturnMessage);

          $scope.MeetInfos = response.MeetInfos;
          $scope.TotalProducts = response.TotalRows;
          $scope.TotalPages = response.TotalPages;
          $scope.TotalRows = response.TotalRows;
      }

      $scope.meetInfoError = function (response, status) {
          alertsService.RenderErrorMessage(response.ReturnMessage);
      }

      $scope.getMeetInfo = function () {
          alert("test");
      }

      $scope.pageChanged = function () {
          $scope.getMeetInfos(null);
      }

      $scope.createMeetInfoObject = function (search) {

          var meetInfo = new Object();
          meetInfo.ID = $scope.ID;
          meetInfo.Title = $scope.Title;
          meetInfo.Description = $scope.Description;
          meetInfo.SearchText = $scope.SearchText;
          if (search != null)
              meetInfo.CurrentPageNumber = 1;
          else
              meetInfo.CurrentPageNumber = $scope.CurrentPageNumber;
          meetInfo.SortExpression = $scope.SortExpression;
          meetInfo.SortDirection = $scope.SortDirection;
          meetInfo.PageSize = $scope.PageSize;

          return meetInfo;
      }

      var addModalInstanceCtrl = function ($scope, $modalInstance) {
          $scope.HeaderText = "新增";
          $scope.ID = 0;
          $scope.thisMeetNameToEdit = "";
          $scope.thisStartTimeToEdit = "";
          $scope.thisEndTimeToEdit = "";
          $scope.thisAddressToEdit = "";
          $scope.thisIsCurrentToEdit = 0;
          $scope.thisCountToEdit = "";
          $scope.thisCostToEdit = "";
          $scope.thisRemarkToEdit = "";
          $scope.thisUploadToEdit = "";
          $scope.thisUploadSrcToEdit = "";
          $scope.thisChargeTipToEdit = "";
          $scope.thisBillTipToEdit = "";
          $scope.thisGetTipToEdit = "";
          $scope.Upload = function ($files) {
              if (typeof ($files) != "undefined" && $files != null) {//过滤非上传效果
                  if ($files.length > 0) {//过滤为选文件
                      var suffix = $files[0].name.substring($files[0].name.indexOf('.') + 1).toUpperCase();
                      if (suffix == "XLS" || suffix == "XLSX")//过滤非XLS||XLSX文件
                      {
                          $upload.upload({
                              url: 'api/UploadHandler.ashx',
                              data: { name: "test" },
                              file: $files[0], // or list of files ($files) for html5 only
                          }).progress(function (evt) {
                              console.log('percent: ' + parseInt(100.0 * evt.loaded / evt.total));
                          }).success(function (response, status, headers, config) {
                              $scope.thisUploadToEdit = $files[0].name;
                              $scope.thisUploadSrcToEdit = response;
                              toastr.success('上传成功!', '提示', {
                                  closeButton: true,
                                  timeOut: 5000
                              });
                          }).error(function (err) {
                              toastr.warning('上传失败，请重试!', '提示', {
                                  closeButton: true,
                                  timeOut: 5000
                              });
                          });
                      }
                      else {
                          toastr.warning('只允许上传XLS或XLSX文件!', '提示', {
                              closeButton: true,
                              timeOut: 5000
                          });
                      }
                  }
              }
          }

          $scope.ok = function (ID, thisMeetNameToEdit, thisStartTimeToEdit, thisEndTimeToEdit, thisAddressToEdit, thisIsCurrentToEdit, thisCountToEdit, thisCostToEdit, thisRemarkToEdit, thisChargeTipToEdit, thisBillTipToEdit, thisGetTipToEdit) {
              var meetInfo = new Object();
              meetInfo.ID = ID;
              meetInfo.MeetName = thisMeetNameToEdit;
              meetInfo.StartTime = thisStartTimeToEdit;
              meetInfo.EndTime = thisEndTimeToEdit;
              meetInfo.Address = thisAddressToEdit;
              meetInfo.IsCurrent = thisIsCurrentToEdit;
              meetInfo.Count = thisCountToEdit;
              meetInfo.Cost = thisCostToEdit;
              meetInfo.Remark = thisRemarkToEdit;
              meetInfo.FileSrc = $scope.thisUploadSrcToEdit;
              meetInfo.ChargeTip = thisChargeTipToEdit;
              meetInfo.BillTip = thisBillTipToEdit;
              meetInfo.GetTip = thisGetTipToEdit;
              $modalInstance.close(meetInfo);
          };

          $scope.cancel = function () {
              $modalInstance.dismiss('cancel');
          };
      };
      $scope.addLineItemModal = function () {

          var modalInstance = $modal.open({
              templateUrl: 'addLineItemModal.html',
              Controller: addModalInstanceCtrl,
              windowClass: 'app-modal-window'
          });

          modalInstance.result.then(function (meetInfo) {
              meetingService.createMeetInfo(meetInfo, $scope.editMeetInfoLineItemCompleted, $scope.editMeetInfoLineItemError);

          }, function () {
              //$log.info('Modal dismissed at: ' + new Date());
          });
      };

      var editModalInstanceCtrl = function ($scope, $modalInstance, MeetInfo) {
          $scope.HeaderText = "编辑";
          $scope.ID = MeetInfo.ID;
          $scope.thisMeetNameToEdit = MeetInfo.MeetName;
          $scope.thisStartTimeToEdit = MeetInfo.StartTime;
          $scope.thisEndTimeToEdit = MeetInfo.EndTime;
          $scope.thisAddressToEdit = MeetInfo.Address;
          $scope.thisIsCurrentToEdit = MeetInfo.IsCurrent;
          $scope.thisCountToEdit = MeetInfo.Count;
          $scope.thisCostToEdit = MeetInfo.Cost;
          $scope.thisRemarkToEdit = MeetInfo.Remark;
          $scope.thisUploadToEdit = MeetInfo.FileSrc;
          $scope.thisUploadSrcToEdit ="";
          $scope.thisChargeTipToEdit = MeetInfo.ChargeTip;
          $scope.thisBillTipToEdit = MeetInfo.BillTip;
          $scope.thisGetTipToEdit = MeetInfo.GetTip;

          $scope.ok = function (ID, thisMeetNameToEdit, thisStartTimeToEdit, thisEndTimeToEdit, thisAddressToEdit, thisIsCurrentToEdit, thisCountToEdit, thisCostToEdit, thisRemarkToEdit, thisChargeTipToEdit, thisBillTipToEdit, thisGetTipToEdit) {
              var meetInfo = new Object();
              meetInfo.ID = ID;
              meetInfo.MeetName = thisMeetNameToEdit;
              meetInfo.StartTime = thisStartTimeToEdit.toLocaleDateString();
              meetInfo.EndTime = thisEndTimeToEdit.toLocaleDateString();
              meetInfo.Address = thisAddressToEdit;
              meetInfo.IsCurrent = thisIsCurrentToEdit;
              meetInfo.Count = thisCountToEdit;
              meetInfo.Cost = thisCostToEdit;
              meetInfo.Remark = thisRemarkToEdit;
              meetInfo.FileSrc = $scope.thisUploadSrcToEdit;
              meetInfo.ChargeTip = thisChargeTipToEdit;
              meetInfo.BillTip = thisBillTipToEdit;
              meetInfo.GetTip = thisGetTipToEdit;
              $modalInstance.close(meetInfo);
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
                  MeetInfo: function () {
                      return $scope.MeetInfos[i];
                  }
              }
          });

          modalInstance.result.then(function (meetInfo) {
              meetingService.updateMeetInfo(meetInfo, $scope.editMeetInfoLineItemCompleted, $scope.editMeetInfoLineItemError);

          }, function () {
              //$log.info('Modal dismissed at: ' + new Date());
          });
      };

      $scope.editMeetInfoLineItemCompleted = function (response) {
          $scope.getMeetInfos(null);
          toastr.success(response.ReturnMessage[0], '提示', {
              closeButton: true,
              timeOut: 5000
          });
      }

      $scope.editMeetInfoLineItemError = function (response) {
          toastr.warning(response.ReturnMessage[0], '提示', {
              closeButton: true,
              timeOut: 5000
          });
      }


      $scope.deleteLineItem = function (i) {
          if (confirm("确定要删除?")) {
              var meetInfo = new Object();
              meetInfo.ID = $scope.MeetInfos[i].ID;
              meetingService.deleteMeetInfo(meetInfo, $scope.editMeetInfoLineItemCompleted, $scope.editMeetInfoLineItemError);
          }
      }

      $scope.dataBindMeetInfos = function (orderDetail) {

          var meetInfos = [];

          angular.forEach(orderDetail, function (lineItem) {

              var meetInfo = new Object();

              meetInfo.ID = encryptService.encrypt(lineItem.ID.toString(), "MeetManage");
              meetInfo.MeetInfoType = lineItem.MeetInfoType;
              meetInfo.Title = lineItem.Title;
              meetInfo.Score = lineItem.Score;
              meetInfo.Duration = lineItem.Duration;
              meetInfo.StartTime = lineItem.StartTime;
              meetInfo.EndTime = lineItem.EndTime;
              meetInfo.CreateTime = lineItem.CreateTime;
              meetInfo.CreateUser = lineItem.CreateUser;
              meetInfo.IsGlobal = lineItem.IsGlobal;
              meetInfo.CssType = lineItem.CssType;
              meetInfo.Description = lineItem.Description;
              meetInfo.RowNumber = lineItem.RowNumber;
              meetInfos.push(meetInfo);

          });
          return meetInfos;
      }

      $scope.exportMeetInfo = function (i) {

          var form = $("<form>");   //定义一个form表单
          form.attr('style', 'display:none');   //在form表单中添加查询参数
          form.attr('target', '');
          form.attr('method', 'post');
          form.attr('action', "/api/ExportHandler.ashx");
          var input1 = $('<input>');
          input1.attr('type', 'hidden');
          input1.attr('name', 'MeetID');
          input1.attr('value', $scope.MeetInfos[i].ID);
          $('body').append(form);  //将表单放置在web中
          form.append(input1);   //将查询参数控件提交到表单上
          form.submit();   //表单提交
      }

      $scope.exportMeetInfoLineItemCompleted = function (response) {
          alertsService.RenderSuccessMessage(response.ReturnMessage);
      }
      $scope.exportMeetInfoLineItemError = function (response) {
          alertsService.RenderErrorMessage(response.ReturnMessage);
      }
  }]);
});