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
import com.sxit.mgt.system.dto.Node;
import com.sxit.mgt.system.dto.RoleModel;
import com.sxit.mgt.system.service.FunctionService;
import com.sxit.mgt.system.service.RoleService;
import com.sxit.model.system.IdVo;
import com.sxit.model.system.SysFunction;
import com.sxit.model.system.SysRole;

/**
 * @公司:深讯信科
 * @功能:角色 Action
 * @作者:张如兵
 * @日期:2015-06-17 16:47:42
 * @版本:1.0
 * @修改:
 */

@Controller
@RequestMapping("/system")
public class RoleAction extends BaseAction {

	@Autowired
	private RoleService roleService;

	@Autowired
	private FunctionService functionService;

	@AuthPassport(rightCode = "System.Role")
	@RequestMapping(value = "/roleManage")
	public String manage() {
		return "system/role/manage";
	}

	/**
	 * 列表
	 * 
	 * @param searchTxt
	 * @param page
	 * @param model
	 * @return
	 */
	@AuthPassport(rightCode = "System.Role")
	@RequestMapping(value = "/roleList")
	public @ResponseBody
	ResultMessage list(@ModelAttribute SearchVo vo, PageVo pagevo) {

		// 列表查询
		if (pagevo == null) {
			pagevo = new PageVo();
		}

		Page page = roleService.getRoleList(pagevo, vo.getMap());

		return ResultMessage.successPage(page);
	}

	@AuthPassport(rightCode = "System.Role")
	@RequestMapping(value = "/functionTree")
	public @ResponseBody
	List<Node> functionTree() {

		// 列表查询

		List<SysFunction> list = functionService.getAllFunctionList();

		List<Node> nodelist = new ArrayList<Node>();

		for (SysFunction function : list) {
			Node node = new Node(function.getFunctionId(),
					function.getFunctionName(), function.getParentId());
			nodelist.add(node);
		}
		List<Node> tree = Node.buildTree(nodelist);

		return tree;
	}

	/**
	 * 明细
	 * 
	 * @param roleId
	 * @return
	 */
	@AuthPassport(rightCode = "System.Role")
	@RequestMapping(value = "/roleDetail")
	public @ResponseBody
	ResultMessage detail(@RequestParam Integer roleId) {
		String message = "";
		if (roleId == null) {
			message = "角色ID不能空";
			return ResultMessage.errorMsg(message);
		}

		SysRole role = roleService.getRoleById(roleId);
		if (role == null) {
			message = "未找到该角色";
			return ResultMessage.errorMsg(message);
		}

		List<IdVo> idList = roleService.getFunctionIdList(roleId);
		
		role.setIdList(idList);

		return ResultMessage.successMsg("获取成功", role);
	}

	/**
	 * 增加
	 * 
	 * @return
	 */
	@AuthPassport(rightCode = "System.Role")
	@RequestMapping(value = "/roleAdd")
	public @ResponseBody
	ResultMessage add(@Valid @RequestBody RoleModel roleModel, Errors errors) {
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
		SysRole role = new SysRole();
		BeanUtils.copyProperties(roleModel, role);
		role.setCreateTime(new Date());
		roleService.insert(role);
		return ResultMessage.successMsg("添加成功");
	}

	/**
	 * 编辑
	 * 
	 * @param vo
	 * @param roleId
	 * @param errors
	 * @return
	 */
	@AuthPassport(rightCode = "System.Role")
	@RequestMapping(value = "/roleEdit")
	public @ResponseBody
	ResultMessage edit(@Valid @RequestBody RoleModel roleModel, Errors errors) {
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
		Integer roleId = roleModel.getRoleId();
		String message = "";
		if (roleId == null) {
			message = "角色ID不能空";
			return ResultMessage.errorMsg(message);
		}

		SysRole role = roleService.getRoleById(roleId);
		if (role == null) {
			message = "未找到该角色";
			return ResultMessage.errorMsg(message);
		}

		MyBeanUtils.copyProperties(roleModel, role, roleModel.colset);

		roleService.update(role);

		return ResultMessage.successMsg("修改成功");
	}

	
	@AuthPassport(rightCode = "System.Role")
	@RequestMapping(value = "/roleEditPower")
	public @ResponseBody
	ResultMessage editPower(@Valid @RequestBody RoleModel roleModel, Errors errors) {


		Integer roleId = roleModel.getRoleId();
		String message = "";
		if (roleId == null) {
			message = "角色ID不能空";
			return ResultMessage.errorMsg(message);
		}

		SysRole role = roleService.getRoleById(roleId);
		if (role == null) {
			message = "未找到该角色";
			return ResultMessage.errorMsg(message);
		}

		List<IdVo> idList1 = roleService.getFunctionIdList(roleId);
		
		List<IdVo> idList2 = roleModel.getIdList();
		
		List<IdVo> temp1 = new ArrayList();
		List<IdVo> temp2 = new ArrayList();
		
		temp1.addAll(idList1);
		temp2.addAll(idList2);
		
		List<IdVo> addlist = new ArrayList();
		List<IdVo> deletelist = new ArrayList();
		
		temp2.removeAll(temp1);
		addlist.addAll(temp2);
		
		idList1.removeAll(idList2);
		deletelist.addAll(idList1);
		
		if(addlist.size()>0)
		{
			roleService.addPower(roleId,addlist);
		}
		
		if(deletelist.size()>0)
		{
			roleService.deletePower(roleId,deletelist);
		}
		
		return ResultMessage.successMsg("修改成功");
	}
	
	/**
	 * 
	 * @param roleId
	 * @return
	 */
	// @AuthPassport(rightCode = "System.Role")
	@RequestMapping(value = "/roleDelete")
	public @ResponseBody
	ResultMessage delete(@RequestParam Integer roleId) {

		if (roleId == null) {
			return ResultMessage.errorMsg("角色ID不能空");
		}

		SysRole role = roleService.getRoleById(roleId);
		if (role == null) {
			return ResultMessage.errorMsg("未找到该角色");
		}

		roleService.delete(roleId);

		return ResultMessage.successMsg("删除成功");
	}

}
