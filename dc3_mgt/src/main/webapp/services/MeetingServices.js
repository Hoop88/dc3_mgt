define(['application-configuration', 'ajaxService'], function (app) {

    app.register.service('meetingService', ['ajaxService', function (ajaxService) {
        this.createMeetInfo = function (meetInfo, successFunction, errorFunction) {
            ajaxService.AjaxPost(meetInfo, "/api/meet/CreateMeetInfo", successFunction, errorFunction);
        };

        this.deleteMeetInfo = function (meetInfo, successFunction, errorFunction) {
            ajaxService.AjaxPost(meetInfo, "/api/meet/DeleteMeetInfo", successFunction, errorFunction);
        };

        this.updateMeetInfo = function (meetInfo, successFunction, errorFunction) {
            ajaxService.AjaxPost(meetInfo, "/api/meet/UpdateMeetInfo", successFunction, errorFunction);
        };

        this.getMeetInfos = function (meetInfo, successFunction, errorFunction) {
            ajaxService.AjaxPost(meetInfo, "api/meet/GetMeetInfos.json", successFunction, errorFunction);
        };


        this.uploadExcel = function (meetInfo, successFunction, errorFunction) {
            ajaxService.AjaxGetWithData(meetInfo, "/api/UploadHandler.ashx", successFunction, errorFunction);
        };

        this.exportMeetReport = function (meetInfo, successFunction, errorFunction) {
            ajaxService.AjaxPost(meetInfo, "/api/meet/ExportMeetReport", successFunction, errorFunction);
        };
    }]);
});