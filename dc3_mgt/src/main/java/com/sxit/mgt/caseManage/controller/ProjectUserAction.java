package com.sxit.mgt.caseManage.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxit.common.action.BaseAction;
import com.sxit.common.annatation.AuthPassport;
import com.sxit.common.dto.ResultMessage;
import com.sxit.common.dto.SearchVo;
import com.sxit.common.excel.ExcelExport;
import com.sxit.common.excel.ExcelUtil;
import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.common.utils.MyBeanUtils;
import com.sxit.common.utils.OpenIdUtil;
import com.sxit.mgt.caseManage.dto.ProjectUserModel;
import com.sxit.mgt.caseManage.service.CaseUserService;
import com.sxit.mgt.caseManage.service.ProjectUserService;
import com.sxit.model.caseManage.TcasProjectUser;
import com.sxit.model.caseManage.TcasUser;

/**
 * @公司:深讯信科
 * @功能:项目用户 Action
 * @作者:张如兵
 * @日期:2015-08-10 09:09:35
 * @版本:1.0
 * @修改:
 */

@Controller
@RequestMapping("/caseManage")
public class ProjectUserAction extends BaseAction {

	@Autowired
	private ProjectUserService projectUserService;

	@Autowired
	private CaseUserService caseUserService;

	/**
	 * 列表
	 * 
	 * @param searchTxt
	 * @param page
	 * @param model
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.ProjectManage")
	@RequestMapping(value = "/projectUserList")
	public @ResponseBody
	ResultMessage list(Long id, String searchTxt) {

		PageVo pagevo = new PageVo(0, 1000);

		Map map = new HashMap();
		map.put("projectId", id);
		map.put("searchTxt", searchTxt);

		Page page = projectUserService.getProjectUserList(pagevo, map);

		return ResultMessage.successPage(page);
	}

	/**
	 * 导出Excel
	 * 
	 * @param searchTxt
	 * @param page
	 * @param model
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.ProjectManage")
	@RequestMapping(value = "/projectUserExport")
	public @ResponseBody
	ResultMessage export(@ModelAttribute SearchVo vo, PageVo pagevo) {

		pagevo = new PageVo(0, 5000);

		List list = projectUserService.getProjectUserList(pagevo, vo.getMap());

		if (list != null && list.size() > 0) {
			Map map = new HashMap();

			Map<Integer, String> stateMap = new HashMap<Integer, String>();
			stateMap.put(0, "禁用");
			stateMap.put(1, "正常");
			stateMap.put(2, "冻结");
			map.put("stateMap", stateMap);

			try {
				ExcelExport export = ExcelUtil.exportList(list,
						"projectUserData", "项目用户数据", map);

				if (export != null) {
					this.dowloadExcel(export, "projectUserdata.xls");
					return ResultMessage.successMsg("下载成功!");

				} else {
					return ResultMessage.errorMsg("请检查导出参数projectUserData是否配置");
				}

			} catch (Exception e) {
				e.printStackTrace();

				return ResultMessage.errorMsg("下载出错!");
			}
		} else {
			return ResultMessage.errorMsg("您要下载的数据为空!");
		}

	}

	/**
	 * 明细
	 * 
	 * @param id
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.ProjectManage")
	@RequestMapping(value = "/projectUserDetail")
	public @ResponseBody
	ResultMessage detail(@RequestParam Long id) {
		String message = "";
		if (id == null) {
			message = "项目用户ID不能空";
			return ResultMessage.errorMsg(message);
		}

		TcasProjectUser projectUser = projectUserService.getProjectUserById(id);
		if (projectUser == null) {
			message = "未找到该项目用户";
			return ResultMessage.errorMsg(message);
		}

		return ResultMessage.successMsg("获取成功", projectUser);
	}

	/**
	 * 增加
	 * 
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.ProjectManage")
	@RequestMapping(value = "/projectUserAdd")
	public @ResponseBody
	ResultMessage add(@Valid @RequestBody ProjectUserModel projectUserModel,
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
		TcasProjectUser projectUser = new TcasProjectUser();
		BeanUtils.copyProperties(projectUserModel, projectUser);
		projectUser.setCreateTime(new Date());
		// projectUser.setState(1);
		projectUserService.insert(projectUser);
		return ResultMessage.successMsg("添加成功");
	}

	/**
	 * 编辑
	 * 
	 * @param vo
	 * @param id
	 * @param errors
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.ProjectManage")
	@RequestMapping(value = "/projectUserEdit")
	public @ResponseBody
	ResultMessage edit(@Valid @RequestBody ProjectUserModel projectUserModel,
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

		Long id = projectUserModel.getId();
		String message = "";
		if (id == null) {
			message = "项目用户ID不能空";
			return ResultMessage.errorMsg(message);
		}

		TcasProjectUser projectUser = projectUserService.getProjectUserById(id);
		if (projectUser == null) {
			message = "未找到该项目用户";
			return ResultMessage.errorMsg(message);
		}

		MyBeanUtils.copyProperties(projectUserModel, projectUser,
				projectUserModel.colset);
		// projectUser.setModifyTime(new Date());

		projectUserService.update(projectUser);

		return ResultMessage.successMsg("修改成功");
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.ProjectManage")
	@RequestMapping(value = "/projectUserDelete")
	public @ResponseBody
	ResultMessage delete(@RequestParam Long id) {

		if (id == null) {
			return ResultMessage.errorMsg("项目用户ID不能空");
		}

		TcasProjectUser projectUser = projectUserService.getProjectUserById(id);
		if (projectUser == null) {
			return ResultMessage.errorMsg("未找到该项目用户");
		}

		// 判断状态
		// if(projectUser.getState()==2)
		// {
		projectUserService.delete(id);
		// }else{

		// projectUserService.updateToDelete(id);
		// }

		return ResultMessage.successMsg("删除成功");
	}

	@AuthPassport(rightCode = "CaseManage.CaseUser")
	@RequestMapping(value = "/previewWeb", method = RequestMethod.GET)
	public String previewWeb(@RequestParam Long id, Model model) {

		TcasProjectUser projectUser = projectUserService.getProjectUserById(id);

		if (projectUser == null) {

			model.addAttribute("message", "未找到数据");
			return "common/message";
		}

		TcasUser caseUser = caseUserService.getCaseUserById(projectUser
				.getUserId());

		if (StringUtils.isNotBlank(caseUser.getOpenId())) {
			return "redirect:"
					+ OpenIdUtil.getWebUrl(caseUser.getOpenId(),
							projectUser.getRoleId());
		}

		model.addAttribute("message", "未绑定微信");
		return "common/message";
	}
}
