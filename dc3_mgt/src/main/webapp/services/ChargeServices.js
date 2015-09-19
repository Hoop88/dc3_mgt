define(['application-configuration', 'ajaxService'], function (app) {

    app.register.service('chargeService', ['ajaxService', function (ajaxService) {
        this.createChargeBatch = function (chargeBatch, successFunction, errorFunction) {
            ajaxService.AjaxPost(chargeBatch, "/api/charge/CreateChargeBatch", successFunction, errorFunction);
        };

        this.deleteChargeBatch = function (chargeBatch, successFunction, errorFunction) {
            ajaxService.AjaxPost(chargeBatch, "/api/charge/DeleteChargeBatch", successFunction, errorFunction);
        };

        this.updateChargeBatch = function (chargeBatch, successFunction, errorFunction) {
            ajaxService.AjaxPost(chargeBatch, "/api/charge/UpdateChargeBatch", successFunction, errorFunction);
        };

        this.getChargeBatchs = function (chargeBatch, successFunction, errorFunction) {
            ajaxService.AjaxPost(chargeBatch, "/api/charge/GetChargeBatchs", successFunction, errorFunction);
        };

        this.getChargeDetails = function (chargeDetail, successFunction, errorFunction) {
            ajaxService.AjaxPost(chargeDetail, "/api/charge/GetChargeDetails", successFunction, errorFunction);
        };

        this.deleteChargeDetail = function (chargeBatch, successFunction, errorFunction) {
            ajaxService.AjaxPost(chargeBatch, "/api/charge/DeleteChargeDetail", successFunction, errorFunction);
        };

        this.getChargeBillDetails = function (chargeDetail, successFunction, errorFunction) {
            ajaxService.AjaxPost(chargeDetail, "/api/charge/GetChargeBillDetails", successFunction, errorFunction);
        };

        this.getBillDetails = function (chargeDetail, successFunction, errorFunction) {
            ajaxService.AjaxPost(chargeDetail, "/api/charge/GetBillDetails", successFunction, errorFunction);
        };

        this.addBillBatch = function (billBatch, successFunction, errorFunction) {
            ajaxService.AjaxPost(billBatch, "/api/charge/AddBillBatch", successFunction, errorFunction);
        };

        this.deleteBillBatch = function (billBatch, successFunction, errorFunction) {
            ajaxService.AjaxPost(billBatch, "/api/charge/DeleteBillBatch", successFunction, errorFunction);
        };

        this.updateBillBatch = function (billBatch, successFunction, errorFunction) {
            ajaxService.AjaxPost(billBatch, "/api/charge/UpdateBillBatch", successFunction, errorFunction);
        };

        this.printBillBatch = function (billBatch, successFunction, errorFunction) {
            ajaxService.AjaxPost(billBatch, "/api/charge/PrintBillBatch", successFunction, errorFunction);
        };

        this.printBillBatchs = function (billBatch, successFunction, errorFunction) {
            ajaxService.AjaxPost(billBatch, "/api/charge/PrintBillBatchs", successFunction, errorFunction);
        };

        this.updateBillBatchs = function (billBatch, successFunction, errorFunction) {
            ajaxService.AjaxPost(billBatch, "/api/charge/PrintBillBatchs", successFunction, errorFunction);
        };

        this.setGetDocument = function (chargeBatch, successFunction, errorFunction) {
            ajaxService.AjaxPost(chargeBatch, "/api/charge/SetGetDocument", successFunction, errorFunction);
        };
    }]);
});