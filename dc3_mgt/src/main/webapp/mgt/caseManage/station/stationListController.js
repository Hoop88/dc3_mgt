"use strict";

define([ 'application-configuration', 'bootstrap', 'jquery', 'WdatePicker',
		'ZeroClipboard', 'stationService', 'alertsService', "dataGridService",
		"encryptService", "upload", 'toastr','jstree' ], function(app) {

	app.register.Controller('stationListController', [
			'$location',
			'$modal',
			'$log',
			'$filter',
			'$scope',
			'$rootScope',
			'$stateParams',
			'$document',
			'stationService',
			'alertsService',
			"dataGridService",
			"encryptService",
			"$upload",
			'toastr',

			function($location, $modal, $log, $filter, $scope, $rootScope,
					$routeParams, $document, stationService, alertsService,
					dataGridService, encryptService, $upload, toastr) {
				$scope.initializeController = function() {
					$scope.searchTxt = "";
					$scope.pageSize = 20;
					$scope.stationTypeMap = stationService.stationTypeMap;
					$scope.currentPage = 1;
					$scope.TotalRows = 0;
					$rootScope.closeAlert = alertsService.closeAlert;

					$('#stationTree').jstree({
							  "core" : {
								"animation" : 0,
								"check_callback" : true,
								"themes" : { "stripes" : true },
								'data' : {
									"url" : "caseManage/stationTree",
									"dataType" : "json" // needed only if you do not supply JSON headers
								}
							  },
							  "search" : { 
                				"show_only_matches" : true,
								"show_only_matches_children" : true
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
							
							var to = false;
							$('#tree_search').keyup(function () {
								console.log(to);
								if(to) { clearTimeout(to); }
								to = setTimeout(function () {
									
								}, 250);
							});
							
							$('#stationTree').on("select_node.jstree", function (e, data) {
								$scope.guid=data.selected[0];
								$scope.getStation($scope.guid);
							});
							
							
							
							var b = $(window), c = $(document.body);

							var b = $("#stationInfo");
            				b.affix({offset: {
									top: function() {
										var c = b.offset().top, d = parseInt(b.children(0).css("margin-top"), 10), e = $(".bs-docs-nav").height();
										//alert("top");
									//alert(c - e - d);
										return this.top = c - e - d - 100
									},
									bottom: function() {
										//alert("bottom");
									//alert($("#stationInfo").outerHeight(!0));
										return this.bottom = $("#stationInfo").outerHeight(!0);
								
									}
								}
							}
						)
							
							


				}

				

				$scope.searchTree = function() {
					var v = $('#tree_search').val();
					$('#stationTree').jstree(true).search(v);
				}

				$scope.enter = function(ev) { 
					if (ev.keyCode !== 13) {
					  return; 
					}
					$scope.searchTree();
				}

				$scope.getStation = function(id) {
					stationService.getStation({
						"stationGuid" : id
					}, function(response) {
						if (response.header.code == 0) {
							$scope.stationModal= response.data;
						} else {
							$scope.stationModal={};
						}
					}, function() {
						$scope.stationModal={};
					})
				
				}

			} ]);
});
