package com.sxit.mgt.caseManage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
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
import com.sxit.mgt.caseManage.dto.StationModel;
import com.sxit.mgt.caseManage.service.ProjectManageService;
import com.sxit.mgt.caseManage.service.StationService;
import com.sxit.model.caseManage.TcasStation;

/**
 * @公司:深讯信科
 * @功能:岗位 Action
 * @作者:张如兵
 * @日期:2015-08-03 16:55:52
 * @版本:1.0
 * @修改:
 */

@Controller
@RequestMapping("/caseManage")
public class StationAction extends BaseAction {

	@Autowired
	private StationService stationService;
	
	@Autowired
	private ProjectManageService projectManageService;

	/**
	 * 列表
	 * 
	 * @param searchTxt
	 * @param page
	 * @param model
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.Station")
	@RequestMapping(value = "/stationList")
	public @ResponseBody
	ResultMessage list(@ModelAttribute SearchVo vo, PageVo pagevo) {

		// 列表查询
		if (pagevo == null) {
			pagevo = new PageVo(0, 10);
		}

		Page page = stationService.getStationList(pagevo, vo.getMap());

		return ResultMessage.successPage(page);
	}

	
	@AuthPassport(rightCode = "common")
	@RequestMapping(value = "/stationTree")
	public @ResponseBody  List<TreeStringNode> tree() {
		Map<String,String> map =projectManageService.getProjectCodeMapList();

		PageVo pagevo = new PageVo(0, 5000);
		
		//列表查询
		List<TcasStation> list = stationService.getStationList(pagevo,null);
		 
		 List<TreeStringNode> nodelist = new ArrayList<TreeStringNode>();
		 
		for (TcasStation station : list) {
			
			TreeStringNode node = new TreeStringNode(station.getStationGuid(),
					station.getStationName(), station.getParentGuid());
			node.setCode(station.getProjectCode());
			nodelist.add(node);
			
		}
		
		List<TreeStringNode> treeList = TreeStringNode.buildTree(nodelist);
		
		//给树上增加项目
		nodelist = new ArrayList<TreeStringNode>();
		Set check = new HashSet();
		for(TreeStringNode node : treeList)
		{
			if(StringUtils.isNotBlank(map.get(node.getCode())))
			{
				if(!check.contains(node.getCode()))
				{
					check.add(node.getCode());
					TreeStringNode pnode = new TreeStringNode(node.getCode(),map.get(node.getCode()),null);
					nodelist.add(pnode);
				}
				
				node.setParentId(node.getCode());
				nodelist.add(node);
				
			}

		}
		
		
		
		List<TreeStringNode> tree = TreeStringNode.buildTree(nodelist);

		
		return tree;
	}
	
	/**
	 * 项目下的岗位树
	 * @param projectCode
	 * @param parentCode
	 * @return
	 */
	@AuthPassport(rightCode = "common")
	@RequestMapping(value = "/projectStationList")
	public @ResponseBody List<TcasStation> tree(String projectCode, String parentCode) {
		PageVo pagevo = new PageVo(0, 1000);
		Map map = new HashMap();
		map.put("projectCode", projectCode);
		map.put("parentCode", parentCode);
		
		List<TcasStation> list = stationService.getStationList(pagevo,map);
		
		return list;
	}

	/**
	 * 导出Excel
	 * 
	 * @param searchTxt
	 * @param page
	 * @param model
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.Station")
	@RequestMapping(value = "/stationExport")
	public @ResponseBody
	ResultMessage export(@ModelAttribute SearchVo vo, PageVo pagevo) {

		pagevo = new PageVo(0, 5000);

		List list = stationService.getStationList(pagevo, vo.getMap());

		if (list != null && list.size() > 0) {
			Map map = new HashMap();

			Map<Integer, String> stateMap = new HashMap<Integer, String>();
			stateMap.put(0, "禁用");
			stateMap.put(1, "正常");
			stateMap.put(2, "冻结");
			map.put("stateMap", stateMap);

			try {
				ExcelExport export = ExcelUtil.exportList(list, "stationData",
						"岗位数据", map);
				this.dowloadExcel(export, "stationdata.xls");
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
	 * @param stationGuid
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.Station")
	@RequestMapping(value = "/stationDetail")
	public @ResponseBody
	ResultMessage detail(@RequestParam String stationGuid) {
		String message = "";
		if (stationGuid == null) {
			message = "岗位ID不能空";
			return ResultMessage.errorMsg(message);
		}

		TcasStation station = stationService.getStationById(stationGuid);
		if (station == null) {
			message = "未找到该岗位";
			return ResultMessage.errorMsg(message);
		}

		return ResultMessage.successMsg("获取成功", station);
	}

	/**
	 * 增加
	 * 
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.Station")
	@RequestMapping(value = "/stationAdd")
	public @ResponseBody
	ResultMessage add(@Valid @RequestBody StationModel stationModel,
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
		TcasStation station = new TcasStation();
		BeanUtils.copyProperties(stationModel, station);
		// station.setCreateTime(new Date());
		// station.setState(1);
		stationService.insert(station);
		return ResultMessage.successMsg("添加成功");
	}

	/**
	 * 编辑
	 * 
	 * @param vo
	 * @param stationGuid
	 * @param errors
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.Station")
	@RequestMapping(value = "/stationEdit")
	public @ResponseBody
	ResultMessage edit(@Valid @RequestBody StationModel stationModel,
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

		String stationGuid = stationModel.getStationGuid();
		String message = "";
		if (stationGuid == null) {
			message = "岗位ID不能空";
			return ResultMessage.errorMsg(message);
		}

		TcasStation station = stationService.getStationById(stationGuid);
		if (station == null) {
			message = "未找到该岗位";
			return ResultMessage.errorMsg(message);
		}

		MyBeanUtils.copyProperties(stationModel, station, stationModel.colset);
		// station.setModifyTime(new Date());

		stationService.update(station);

		return ResultMessage.successMsg("修改成功");
	}

	/**
	 * 
	 * @param stationGuid
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.Station")
	@RequestMapping(value = "/stationDelete")
	public @ResponseBody
	ResultMessage delete(@RequestParam String stationGuid) {

		if (stationGuid == null) {
			return ResultMessage.errorMsg("岗位ID不能空");
		}

		TcasStation station = stationService.getStationById(stationGuid);
		if (station == null) {
			return ResultMessage.errorMsg("未找到该岗位");
		}

		// 判断状态
		// if(station.getState()==2)
		// {
		stationService.delete(stationGuid);
		// }else{

		// stationService.updateToDelete(stationGuid);
		// }

		return ResultMessage.successMsg("删除成功");
	}

}
