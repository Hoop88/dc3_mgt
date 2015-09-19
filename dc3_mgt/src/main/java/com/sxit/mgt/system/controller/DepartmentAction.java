package com.sxit.mgt.system.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxit.common.action.BaseAction;
import com.sxit.common.annatation.AuthPassport;
import com.sxit.common.dto.ResultMessage;
import com.sxit.common.dto.SearchVo;
import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.common.utils.MyBeanUtils;
import com.sxit.mgt.system.dto.DepartmentModel;
import com.sxit.mgt.system.dto.Node;
import com.sxit.mgt.system.service.DepartmentService;
import com.sxit.model.system.SysDepartment;


/**
 * @公司:深讯信科
 * @功能:部门 Action
 * @作者:张如兵    
 * @日期:2015-06-25 20:42:16  
 * @版本:1.0
 * @修改:
 */

@Controller
@RequestMapping("/system")
public class DepartmentAction extends BaseAction {
	
	@Autowired
	private DepartmentService departmentService;



	@AuthPassport(rightCode = "department_manage")
	@RequestMapping(value = "/departmentManage")
	public String manage() {
		return "system/department/manage";
	}
	
	/**
	 * 列表
	 * @param searchTxt
	 * @param page
	 * @param model
	 * @return
	 */
	@AuthPassport(rightCode = "System.Department")
	@RequestMapping(value = "/departmentList")
	public @ResponseBody ResultMessage list(@ModelAttribute SearchVo vo, PageVo pagevo) {
		
		//列表查询
		if(pagevo==null)
		{
			pagevo = new PageVo(0,10);
		}
		
		Page page = departmentService.getDepartmentList(pagevo, vo.getMap());

		return ResultMessage.successPage(page);
	}
	
	/**
	 * 获取部门的树
	 * @param vo
	 * @param pagevo
	 * @return
	 */
	@AuthPassport(rightCode = "common")
	@RequestMapping(value = "/departmentTree")
	public @ResponseBody  List<Node> tree(@ModelAttribute SearchVo vo, PageVo pagevo) {
		
		//列表查询
		 List<SysDepartment> list  = departmentService.getAllDepartmentList();
		 
		 List<Node> nodelist = new ArrayList<Node>();
		 
		for (SysDepartment dep : list) {
			Node node = new Node(dep.getDepId(),dep.getDepName(),dep.getParentId());
			nodelist.add(node);
		}

		List<Node> tree = Node.buildTree(nodelist);
		
		return tree;
		//return ResultMessage.successMsg("成功", tree);
	}

	/**
	 * 明细
	 * 
	 * @param depId
	 * @return
	 */
	@AuthPassport(rightCode = "System.Department")
	@RequestMapping(value = "/departmentDetail")
	public @ResponseBody
	ResultMessage detail(@RequestParam Integer depId) {
		String message = "";
		if (depId == null) {
			message = "部门ID不能空";
			return ResultMessage.errorMsg(message);
		}

		SysDepartment department = departmentService.getDepartmentById(depId);
		if (department == null) {
			message = "未找到该部门";
			return ResultMessage.errorMsg(message);
		}

		return ResultMessage.successMsg("获取成功", department);
	}

	/**
	 * 增加
	 * 
	 * @return
	 */
	@AuthPassport(rightCode = "System.Department")
	@RequestMapping(value = "/departmentAdd")
	public @ResponseBody
	ResultMessage add(@Valid @RequestBody DepartmentModel departmentModel, Errors errors) {
		// 判断验证是否通过
		if (errors.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			for (FieldError e : errors.getFieldErrors()) {
				if (sb.length() > 0) {
					sb.append(",");
				}
				sb.append(e.getDefaultMessage());
				break;
			}
			return ResultMessage.errorMsg(sb.toString());
		}
		SysDepartment department = new SysDepartment();
		BeanUtils.copyProperties(departmentModel, department);
		department.setCreateTime(new Date());
		//department.setState(1);
		departmentService.insert(department);
		return ResultMessage.successMsg("添加成功");
	}
	
	
	
	/**
	 * 编辑
	 * @param vo
	 * @param depId
	 * @param errors
	 * @return
	 */
	@AuthPassport(rightCode = "System.Department")
	@RequestMapping(value = "/departmentEdit")
	public @ResponseBody
	ResultMessage edit(@Valid @RequestBody DepartmentModel departmentModel, 
			Errors errors) {
		// 判断验证是否通过
		if (errors.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			for (FieldError e : errors.getFieldErrors()) {
				if (sb.length() > 0) {
					sb.append(",");
				}
				sb.append(e.getDefaultMessage());
				break;
			}
			return ResultMessage.errorMsg(sb.toString());
		}

		Integer depId = departmentModel.getDepId();
		
		String message = "";
		if (depId == null) {
			message = "部门ID不能空";
			return ResultMessage.errorMsg(message);
		}

		SysDepartment department = departmentService.getDepartmentById(depId); 
		if (department == null) {
			message = "未找到该部门";
			return ResultMessage.errorMsg(message);
		}

		
		MyBeanUtils.copyProperties(departmentModel, department,departmentModel.colset);
		//department.setModifyTime(new Date());

	        departmentService.update(department);
    
		return ResultMessage.successMsg("修改成功");
	}
	
	/**
	 * 
	 * @param depId
	 * @return
	 */
	@AuthPassport(rightCode = "System.Department")
	@RequestMapping(value = "/departmentDelete")
	public @ResponseBody
	ResultMessage delete(@RequestParam Integer depId) {

		if (depId == null) {
			return ResultMessage.errorMsg("部门ID不能空");
		}

		//SysDepartment department = departmentService.getDepartmentById(depId); 
		//if (department == null) {
		//	return ResultMessage.errorMsg("未找到该部门");
		//}

		//判断状态
		//if(department.getState()==2)
		//{
			departmentService.delete(depId);
		//}else{
			
		//	departmentService.updateToDelete(depId);
		//}

		return ResultMessage.successMsg("删除成功");
	}

}
