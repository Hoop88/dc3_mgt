package com.sxit.mgt.caseManage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.sxit.common.dto.TreeStringNode;
import com.sxit.common.excel.ExcelExport;
import com.sxit.common.excel.ExcelUtil;
import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.common.utils.MyBeanUtils;
import com.sxit.mgt.caseManage.dto.CheckCompanyVo;
import com.sxit.mgt.caseManage.dto.ProjectManageModel;
import com.sxit.mgt.caseManage.service.ProjectManageService;
import com.sxit.mgt.caseManage.service.StationService;
import com.sxit.model.caseManage.TcasProject;
import com.sxit.model.caseManage.TcasStation;

/**
 * @公司:深讯信科
 * @功能:项目管理 Action
 * @作者:张如兵
 * @日期:2015-07-24 11:32:23
 * @版本:1.0
 * @修改:
 */

@Controller
@RequestMapping("/caseManage")
public class ProjectManageAction extends BaseAction {

	@Autowired
	private ProjectManageService projectManageService;

	@Autowired
	private StationService stationService;

	/**
	 * 列表
	 * 
	 * @param searchTxt
	 * @param page
	 * @param model
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.ProjectManage")
	@RequestMapping(value = "/projectManageList")
	public @ResponseBody
	ResultMessage list(@ModelAttribute SearchVo vo, PageVo pagevo) {

		// 列表查询
		if (pagevo == null) {
			pagevo = new PageVo(0, 10);
		}

		Page page = projectManageService
				.getProjectTreeList(pagevo, vo.getMap());

		return ResultMessage.successPage(page);
	}
	
	/**
	 * 一级项目的code name map
	 * @return
	 */
	@AuthPassport(rightCode = "common")
	@RequestMapping(value = "/projectCodeMap1")
	public @ResponseBody
	ResultMessage projectMap( ) {
		Map map  = projectManageService
				.getProjectCode1MapList();
		return ResultMessage.successMsg("ok", map);
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
	@RequestMapping(value = "/projectManageExport")
	public @ResponseBody
	ResultMessage export(@ModelAttribute SearchVo vo, PageVo pagevo) {

		pagevo = new PageVo(0, 5000);

		List list = projectManageService.getProjectManageList(pagevo,
				vo.getMap());

		if (list != null && list.size() > 0) {
			Map map = new HashMap();

			Map<Integer, String> stateMap = new HashMap<Integer, String>();
			stateMap.put(0, "禁用");
			stateMap.put(1, "正常");
			stateMap.put(2, "冻结");
			map.put("stateMap", stateMap);

			try {
				ExcelExport export = ExcelUtil.exportList(list,
						"projectManageData", "项目管理数据", map);
				this.dowloadExcel(export, "projectManagedata.xls");
				return ResultMessage.successMsg("下载成功!");
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
	 * @param projectId
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.ProjectManage")
	@RequestMapping(value = "/projectManageDetail")
	public @ResponseBody
	ResultMessage detail(@RequestParam Long projectId) {
		String message = "";
		if (projectId == null) {
			message = "项目管理ID不能空";
			return ResultMessage.errorMsg(message);
		}

		TcasProject projectManage = projectManageService
				.getProjectManageById(projectId);
		if (projectManage == null) {
			message = "未找到该项目管理";
			return ResultMessage.errorMsg(message);
		}

		PageVo pagevo = new PageVo(0, 1000);
		Map map = new HashMap();
		map.put("projectCode", projectManage.getProjectCode());
		
		map.put("parentCode", projectManage.getParentCode());

		List<TcasStation> list = stationService.getStationList(pagevo, map);

		List<TreeStringNode> nodelist = new ArrayList<TreeStringNode>();

		for (TcasStation station : list) {
			TreeStringNode node = new TreeStringNode(station.getStationGuid(),
					station.getStationName(), station.getParentGuid());
			nodelist.add(node);
		}

		List<TreeStringNode> tree = TreeStringNode.buildTree(nodelist);

		projectManage.setProjectStationTree(tree);
		
		
		List<CheckCompanyVo> clist =projectManageService.getCheckCompanyList(projectManage);
		
		projectManage.setProxyCompanyList(clist);
		

		return ResultMessage.successMsg("获取成功", projectManage);
	}

	/**
	 * 增加
	 * 
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.ProjectManage")
	@RequestMapping(value = "/projectManageAdd")
	public @ResponseBody
	ResultMessage add(
			@Valid @RequestBody ProjectManageModel projectManageModel,
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
		TcasProject projectManage = new TcasProject();
		BeanUtils.copyProperties(projectManageModel, projectManage);
		// projectManage.setCreateTime(new Date());
		// projectManage.setState(1);
		projectManageService.insert(projectManage);
		return ResultMessage.successMsg("添加成功");
	}

	/**
	 * 编辑
	 * 
	 * @param vo
	 * @param projectId
	 * @param errors
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.ProjectManage")
	@RequestMapping(value = "/projectManageEdit")
	public @ResponseBody
	ResultMessage edit(
			@Valid @RequestBody ProjectManageModel projectManageModel,
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

		Long projectId = projectManageModel.getProjectId();
		String message = "";
		if (projectId == null) {
			message = "项目管理ID不能空";
			return ResultMessage.errorMsg(message);
		}

		TcasProject projectManage = projectManageService
				.getProjectManageById(projectId);
		if (projectManage == null) {
			message = "未找到该项目管理";
			return ResultMessage.errorMsg(message);
		}

		MyBeanUtils.copyProperties(projectManageModel, projectManage,
				projectManageModel.colset);
		// projectManage.setModifyTime(new Date());

		projectManageService.update(projectManage);

		return ResultMessage.successMsg("修改成功");
	}

	/**
	 * 
	 * @param projectId
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.ProjectManage")
	@RequestMapping(value = "/projectManageDelete")
	public @ResponseBody
	ResultMessage delete(@RequestParam Long projectId) {

		if (projectId == null) {
			return ResultMessage.errorMsg("项目管理ID不能空");
		}

		TcasProject projectManage = projectManageService
				.getProjectManageById(projectId);
		if (projectManage == null) {
			return ResultMessage.errorMsg("未找到该项目管理");
		}

		// 判断状态
		// if(projectManage.getState()==2)
		// {
		projectManageService.delete(projectId);
		// }else{

		// projectManageService.updateToDelete(projectId);
		// }

		return ResultMessage.successMsg("删除成功");
	}

}
