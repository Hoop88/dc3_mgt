package com.sxit.mgt.caseManage.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxit.common.utils.MyBeanUtils;

import com.sxit.common.excel.ExcelExport;
import com.sxit.common.excel.ExcelUtil;

import com.sxit.common.action.BaseAction;
import com.sxit.common.annatation.AuthPassport;
import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.common.dto.ResultMessage;
import com.sxit.common.dto.SearchVo;
import com.sxit.mgt.caseManage.service.TeamService;
import com.sxit.mgt.caseManage.dto.TeamModel;
import com.sxit.model.caseManage.TcasTeam;


/**
 * @公司:深讯信科
 * @功能:项目团队 Action
 * @作者:张如兵    
 * @日期:2015-07-30 14:23:53  
 * @版本:1.0
 * @修改:
 */

@Controller
@RequestMapping("/caseManage")
public class TeamAction extends BaseAction {
	
	@Autowired
	private TeamService teamService;

	
	/**
	 * 列表
	 * @param searchTxt
	 * @param page
	 * @param model
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.Team")
	@RequestMapping(value = "/teamList")
	public @ResponseBody ResultMessage list(@ModelAttribute SearchVo vo, PageVo pagevo) {
		
		//列表查询
		if(pagevo==null)
		{
			pagevo = new PageVo(0,10);
		}
		
		Page page = teamService.getTeamList(pagevo, vo.getMap());

		return ResultMessage.successPage(page);
	}


	/**
	 * 导出Excel
	 * @param searchTxt
	 * @param page
	 * @param model
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.Team")
	@RequestMapping(value = "/teamExport")
	public @ResponseBody ResultMessage export(@ModelAttribute SearchVo vo, PageVo pagevo) {
		
		pagevo = new PageVo(0,5000);
		
		List list = teamService.getTeamList(pagevo, vo.getMap());

		if (list != null && list.size() > 0) {
			Map map = new HashMap();

			Map<Integer, String> stateMap = new HashMap<Integer, String>();
			stateMap.put(0, "禁用");
			stateMap.put(1, "正常");
			stateMap.put(2, "冻结");
			map.put("stateMap", stateMap);
			
			try {
				ExcelExport export = ExcelUtil.exportList(list, "teamData",
						"项目团队数据", map);
				this.dowloadExcel(export, "teamdata.xls");
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
	 * @param teamId
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.Team")
	@RequestMapping(value = "/teamDetail")
	public @ResponseBody
	ResultMessage detail(@RequestParam Long teamId) {
		String message = "";
		if (teamId == null) {
			message = "项目团队ID不能空";
			return ResultMessage.errorMsg(message);
		}

		TcasTeam team = teamService.getTeamById(teamId);
		if (team == null) {
			message = "未找到该项目团队";
			return ResultMessage.errorMsg(message);
		}

		return ResultMessage.successMsg("获取成功", team);
	}

	/**
	 * 增加
	 * 
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.Team")
	@RequestMapping(value = "/teamAdd")
	public @ResponseBody
	ResultMessage add(@Valid @RequestBody TeamModel teamModel, Errors errors) {
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
		TcasTeam team = new TcasTeam();
		BeanUtils.copyProperties(teamModel, team);
		team.setCreateTime(new Date());
		//team.setState(1);
		teamService.insert(team);
		return ResultMessage.successMsg("添加成功");
	}
	
	
	/**
	 * 编辑
	 * @param vo
	 * @param teamId
	 * @param errors
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.Team")
	@RequestMapping(value = "/teamEdit")
	public @ResponseBody
	ResultMessage edit(@Valid  @RequestBody TeamModel teamModel, 
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
		
		Long teamId = 	 teamModel.getTeamId();
		String message = "";
		if (teamId == null) {
			message = "项目团队ID不能空";
			return ResultMessage.errorMsg(message);
		}

		TcasTeam team = teamService.getTeamById(teamId); 
		if (team == null) {
			message = "未找到该项目团队";
			return ResultMessage.errorMsg(message);
		}

		
		MyBeanUtils.copyProperties(teamModel, team,teamModel.colset);
		//team.setModifyTime(new Date());

	        teamService.update(team);
    
		return ResultMessage.successMsg("修改成功");
	}
	
	/**
	 * 
	 * @param teamId
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.Team")
	@RequestMapping(value = "/teamDelete")
	public @ResponseBody
	ResultMessage delete(@RequestParam Long teamId) {

		if (teamId == null) {
			return ResultMessage.errorMsg("项目团队ID不能空");
		}

		TcasTeam team = teamService.getTeamById(teamId); 
		if (team == null) {
			return ResultMessage.errorMsg("未找到该项目团队");
		}

		//判断状态
		//if(team.getState()==2)
		//{
			teamService.delete(teamId);
		//}else{
			
		//	teamService.updateToDelete(teamId);
		//}

		return ResultMessage.successMsg("删除成功");
	}

}
