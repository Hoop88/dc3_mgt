define(['application-configuration', 'ajaxService'], function (app) {

    app.register.service('projectManageService', ['ajaxService', function (ajaxService) {
		
	this.projectStateList   = [ {
			"id":0,"name":"未开盘"
			},{
			"id":1,"name":"启用"
			},{
			"id":2,"name":"未启用"
			}];
			

			
	this.projectTypeList   = [ {
			"id":1,"name":"一级项目"
			},{
			"id":2,"name":"二级项目"
			}];

	this.listToMap   =  function(list){
			var obj = {}
			for(var i=0, len=list.length; i<len; i++){
				obj[list[i].id] = list[i].name
			}
			return obj;
	};
	
	this.mapToList   =  function(map){
		    var list=[];
			for(var key in map){
				var obj = {};
				obj.id = parseInt(key);
				obj.name=map[key];
				list.push(obj);
			}
			return list;
	};
			
	this.projectStateMap   =  this.listToMap(this.projectStateList);
	
	this.projectTypeMap   =  this.listToMap(this.projectTypeList);
		
        this.createProjectManage = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "caseManage/projectManageAdd", successFunction, errorFunction);
        };

        this.deleteProjectManage = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "caseManage/projectManageDelete", successFunction, errorFunction);
        };

        this.updateProjectManage = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxPost(reqdata, "caseManage/projectManageEdit", successFunction, errorFunction);
        };

        this.getProjectManages = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "caseManage/projectManageList", successFunction, errorFunction);
        };

		this.getProjectManage = function (reqdata, successFunction, errorFunction) {
            ajaxService.AjaxFormPost(reqdata, "caseManage/projectManageDetail", successFunction, errorFunction);
        };
		
		this.getCityCompanyMap = function (successFunction, errorFunction) {
            ajaxService.AjaxFormPost({}, "caseManage/cityCompanyMap", successFunction, errorFunction);
        };
		

		
		
		this.initData =function()
		{
			//初始化地市公司数据
			var self = this;
			this.getCityCompanyMap(function(response,state){
				
						if(state==200)
						{
							if (response.header.code == 0) {
									
									self.cityCompanyMap = response.data;
									self.cityCompanyList = self.mapToList(response.data);
									
								} else {
									console.log(response.header);
								}
						}else{
						   console.log("请求地市公司数据错误");
						}
					
					},function (){
						console.log("请求地市公司数据错误");
					})
					
			
			  
		};

		this.exportProjectManage = function (reqdata) {
            ajaxService.AjaxDownload(reqdata, "caseManage/projectManageExport");
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
					obj.levleName =this.getTab(level) + obj.name;
					
					arr.push(obj);
					
					if(tree[i].children && tree[i].children.length > 0){
						var list = this.treeToList(tree[i].children, level+1);
						for(var j=0, len=list.length; j<len; j++)
						{
							arr.push(list[j]);
						}
					}
				}
				console.log("==================");
				console.log(arr);
				return arr;
			}
		
    }]);
});
