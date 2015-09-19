define(['application-configuration'], function (app) {

    app.register.service('alertsService', ['$rootScope', function ($rootScope) {

        $rootScope.alerts = [];
        $rootScope.MessageBox = "";

        this.SetValidationErrors = function (scope, validationErrors) {

            for (var prop in validationErrors) {
                var property = prop + "InputError";
                scope[property] = true;
            }        

        }

        this.RenderErrorMessage = function (message) {

            var messageBox = formatMessage(message);
            $rootScope.alerts = [];
            $rootScope.MessageBox = messageBox;
            $rootScope.alerts.push({ 'type': 'danger', 'msg': messageBox });

        };

        this.RenderSuccessMessage = function (message) {

            var messageBox = formatMessage(message);
            $rootScope.alerts = [];
            $rootScope.MessageBox = messageBox;
            $rootScope.alerts.push({ 'type': 'success', 'msg': messageBox });
        };

        this.RenderWarningMessage = function (message) {

            var messageBox = formatMessage(message);
            $rootScope.alerts = [];
            $rootScope.MessageBox = messageBox;
            $rootScope.alerts.push({ 'type': 'warning', 'msg': messageBox });
        };

        this.RenderInformationalMessage = function (message) {

            var messageBox = formatMessage(message);
            $rootScope.alerts = [];
            $rootScope.MessageBox = messageBox;
            $rootScope.alerts.push({ 'type': 'info', 'msg': messageBox });
        };

        this.closeAlert = function (index) {
            $rootScope.alerts.splice(index, 1);
        };

        function formatMessage(message) {
            var messageBox = "";
            if (angular.isArray(message) == true) {
                for (var i = 0; i < message.length; i++) {
                    messageBox = messageBox + message[i];
                }
            }
            else {
                messageBox = message;
            }

            return messageBox;

        }

    }]);
});