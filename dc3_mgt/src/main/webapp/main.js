require.config({
    baseUrl: "",
	waitSeconds: 0,
    urlArgs: 'ver=1.0',
    paths: {
        'application-configuration': 'scripts/application-configuration',
        'angular': 'scripts/angular.min',
        'angular-route': 'scripts/angular-route.min',
        'angular-ui-router': 'scripts/angular-ui-router',
        'angularAMD': 'scripts/angularAMD',
        'ngAnimate': 'scripts/angular-animate.min',
        'toastr': 'scripts/angular-toastr.tpls',
        'upload': 'scripts/angular-file-upload',
        'jquery': 'scripts/jquery-1.9.1.min',
        'bootstrap': 'scripts/bootstrap.min',
        'ui-bootstrap': 'scripts/ui-bootstrap-tpls-0.11.0',
		'bootstrap-select': 'lib/bootstrap/bootstrap-select/bootstrap-select.min',
        'bootstrap-hover-dropdown': 'scripts/bootstrap-hover-dropdown.min',
        'blockUI': 'scripts/angular-block-ui.min',
        'ngload': 'scripts/ngload',
        'WdatePicker': 'lib/My97DatePicker/WdatePicker',
        'Metronic': 'scripts/metronic',
        'Layout': 'scripts/layout',
        'jquery-backstretch': 'scripts/jquery.backstretch.min',
        'jquery-uniform': 'scripts/jquery.uniform.min',
        'cookie': 'scripts/jquery.cokie.min',
        'kindeditor': 'lib/editor/kindeditor-min',
        'kindeditor-zh_CN': 'lib/editor/lang/zh_CN',
        'ztree-core': 'lib/ztree3.5/jquery.ztree.core-3.5.min',
        'ztree-excheck': 'lib/ztree3.5/jquery.ztree.excheck-3.5.min',
        'ZeroClipboard': 'lib/ZeroClipboard/ZeroClipboard',
		'jstree': 'jstree/dist/jstree.min',
        'encryptService': 'services/encryptServices',
        'mainService': 'services/mainServices',
        'ajaxService': 'services/ajaxServices',
        'alertsService': 'services/alertsServices',
        'accountsService': 'services/accountsServices',
		
        'loginService': 'mgt/auth/loginServices',
		'roleService': 'mgt/system/role/roleService',
		'sysUserService': 'mgt/system/sysUser/sysUserService',
		'departmentService': 'mgt/system/department/departmentService',
		'sysParamService': 'mgt/system/sysParam/sysParamService',
		'sysExportService': 'mgt/system/sysExport/sysExportService',
		'sysExportColumnService': 'mgt/system/sysExport/sysExportColumnService',
		
		'cityCompanyService': 'mgt/caseManage/cityCompany/cityCompanyService',
		'proxyCompanyService': 'mgt/caseManage/proxyCompany/proxyCompanyService',
		'projectManageService': 'mgt/caseManage/projectManage/projectManageService',
		'projectUserService': 'mgt/caseManage/projectUser/projectUserService',
		'caseProjectService': 'mgt/caseManage/caseProject/caseProjectService',
		'teamService': 'mgt/caseManage/team/teamService',
		'stationService': 'mgt/caseManage/station/stationService',
		'caseUserService': 'mgt/caseManage/caseUser/caseUserService',
		
		
        'meetingService': 'services/MeetingServices',
        'chargeService': 'services/ChargeServices',
        'userInfoService': 'services/UserInfoServices',
        'dataGridService': 'services/dataGridService',
        'resolverService':'services/ResolverService',
        'angular-sanitize': 'scripts/angular-sanitize'
    },
    shim: {
        'angularAMD': ['angular'],
        'angular-route': ['angular'],
        'angular-ui-router': ['angular'],
        'blockUI': ['angular'],
        'angular-sanitize': ['angular'],
        'angular-animate': ['angular'],
        'bootstrap': ['angular'],
        'ui-bootstrap': ['angular'],
        'WdatePicker': ['angular'],
        'kindeditor': ['jquery'],
        'kindeditor-zh_CN': ['kindeditor'],
        'ZeroClipboard': ['jquery'],
        'ztree-core': ['jquery'],
        'ztree-excheck': ['ztree-core'],
        'Layout': {
            deps: ['jquery', 'Metronic', 'cookie'],
            exports: 'Layout'
        },
        'Metronic': {
            deps: ['jquery', 'ui-bootstrap'],
            exports:'Metronic'
        },
        'jquery-uniform': ['jquery'],
        'cookie': ['jquery'],
        'bootstrap-hover-dropdown': ['ui-bootstrap'],
        'jquery-backstretch': ['jquery']
    },
    deps: ['application-configuration']
});
try {//初始化窗口为全屏
    window.moveTo(0, 0);
    window.resizeTo(screen.availWidth, screen.availHeight);
} catch (e) { }