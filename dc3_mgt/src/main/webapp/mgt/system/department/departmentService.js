define(['application-configuration', 'ajaxService'], function (app) {

    app.register.service('departmentService', ['ajaxService', function (ajaxService) {
		
		this.departmentTypeList   = [ {
			"id":1,"name":"系统角色"
			},{
			"id":2,"name":"案场角色"
			}];
			
		this.departmentTypeMap   =  function(departmentTypeList){
			var obj = {}
			for(var i=0, len=departmentTypeList.length; i<len; i++){
				obj[departmentTypeList[i].id] = departmentTypeList[i].name
			}
			return obj;
		}(this.departmentTypeList);
		
        this.createDepartment = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "system/departmentAdd", successFunction, errorFunction);
        };

        this.deleteDepartment = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "system/departmentDelete", successFunction, errorFunction);
        };

        this.updateDepartment = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "system/departmentEdit", successFunction, errorFunction);
        };

        this.getDepartments = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "system/departmentList", successFunction, errorFunction);
        };

		this.getDepartment = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "system/departmentDetail", successFunction, errorFunction);
        };
		
		this.getDepTree = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "system/departmentTree", successFunction, errorFunction);
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
