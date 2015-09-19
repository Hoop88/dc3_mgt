define(['application-configuration', 'ajaxService'], function (app) {

    app.register.service('sysUserService', ['ajaxService', function (ajaxService) {
		
		this.sysUserStateList   = [ {
			"id":1,"name":"正常"
			},{
			"id":2,"name":"冻结"
			},{
			"id":3,"name":"删除"
			}];
		
		this.sysUserTypeList   = [ {
			"id":1,"name":"普通用户"
			},{
			"id":2,"name":"管理员"
			}];
					
					
	   	this.listToMap   =  function(list){
			var obj = {}
			for(var i=0, len=list.length; i<len; i++){
				obj[list[i].id] = list[i].name
			}
			return obj;
		};
		
		this.sysUserStateMap   = this.listToMap(this.sysUserStateList); 
			
		this.sysUserTypeMap   = this.listToMap(this.sysUserTypeList);  
		

		
        this.createSysUser = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "system/sysUserAdd", successFunction, errorFunction);
        };

        this.deleteSysUser = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "system/sysUserDelete", successFunction, errorFunction);
        };

        this.updateSysUser = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "system/sysUserEdit", successFunction, errorFunction);
        };

        this.getSysUsers = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "system/sysUserList", successFunction, errorFunction);
        };

		this.getSysUser = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "system/sysUserDetail", successFunction, errorFunction);
        };
		
		this.getDepTree = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "system/departmentTree", successFunction, errorFunction);
        };
		
		this.getSysRoleList = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "system/sysRoleList", successFunction, errorFunction);
        };
		
		this.setSysRoleList= function(list){
			this.sysRoleList = list;
		};
		
        this.exportSysUser = function (reqdata) {
            ajaxService.AjaxDownload(reqdata, "system/sysUserExport");
        };
		
		this.setDepList= function(list){
			this.depList = list;
		};
		this.getTab= function(level){
			var str ="";
			for(var i=0, len=level-1; i<len; i++){
				str= str+"　";
			}
			str= str+"┣ ";
			return str;
		};
		this.treeToList= function(tree, level){
			
			    if(tree==null || tree.length==0)
				{
					return null;
				}

				
				var arr = [], obj = null, level = level || 1;
				
				for(var i=0; i<tree.length; i++){
					obj = {};

					for(var k in tree[i]){
						if(k !== "children"){
							obj[k] = tree[i][k]
						}
					};
					obj.level = level;
					obj.name =this.getTab(level) + obj.text;
					
					arr.push(obj);
					
					if(tree[i].children && tree[i].children.length > 0){
						var list = this.treeToList(tree[i].children, level+1);
						for(var j=0, len=list.length; j<len; j++)
						{
							arr.push(list[j]);
						}
					}
				}
				
				return arr;
			}
    }]);
});
