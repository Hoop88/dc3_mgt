define(['application-configuration'], function (app) {

    app.register.service('dataGridService', [function () {

        var dataGrid = new Object();

        dataGrid.tableHeaders = [];
        dataGrid.sortExpression = "";
        dataGrid.sortDirection = "";
        dataGrid.sort = "";

        this.initializeTableHeaders = function () {
            dataGrid = new Object();
            dataGrid.tableHeaders = [];
        };

        this.addHeader = function (label, expression) {
            var tableHeader = new Object();
            tableHeader.label = label;
            tableHeader.sortExpression = expression;
            dataGrid.tableHeaders.push(tableHeader);
        };

        this.setTableHeaders = function () {
            return dataGrid.tableHeaders;
        }

        this.changeSorting = function (columnSelected, currentSort, tableHeaders) {

            dataGrid = new Object();

            dataGrid.sortExpression = "";

            var sort = currentSort;
            if (sort.column == columnSelected) {
                sort.descending = !sort.descending;
            } else {
                sort.column = columnSelected;
                sort.descending = false;
            }

            for (var i = 0; i < tableHeaders.length; i++) {
                if (sort.column == tableHeaders[i].label) {
                    dataGrid.sortExpression = tableHeaders[i].sortExpression;
                    break;
                }
            }

            if (sort.descending == true)
                dataGrid.sortDirection = "DESC";
            else
                dataGrid.sortDirection = "ASC";

            dataGrid.sort = sort;

        }

        this.getSort = function (columnSelected, currentSort, tableHeaders) {
            return dataGrid.sort;
        };

        this.getSortDirection = function () {
            return dataGrid.sortDirection;
        };

        this.getSortExpression = function () {
            return dataGrid.sortExpression;
        };

        this.setDefaultSort = function (defaultSort) {
            var sort = {
                column: defaultSort,
                descending: false
            }
            return sort;
        };

        this.setSortIndicator = function (column, defaultSort) {
            return column == defaultSort.column && 'sort-' + defaultSort.descending;
        };

    }]);
});