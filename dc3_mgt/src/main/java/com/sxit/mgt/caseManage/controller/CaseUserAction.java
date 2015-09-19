package com.sxit.mgt.caseManage.controller;

import java.util.Date;
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
import com.sxit.mgt.caseManage.dto.CaseUserModel;
import com.sxit.mgt.caseManage.service.CaseUserService;
import com.sxit.mgt.caseManage.service.CompanyService;
import com.sxit.model.caseManage.TcasUser;

/**
 * @公司:深讯信科
 * @功能:案场用户 Action
 * @作者:张如兵
 * @日期:2015-08-05 14:00:18
 * @版本:1.0
 * @修改:
 */

@Controller
@RequestMapping("/caseManage")
public class CaseUserAction extends BaseAction {

	@Autowired
	private CaseUserService caseUserService;

	@Autowired
	private CompanyService companyService;
	
	/**
	 * 列表
	 * 
	 * @param searchTxt
	 * @param page
	 * @param model
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.CaseUser")
	@RequestMapping(value = "/caseUserList")
	public @ResponseBody
	ResultMessage list(@ModelAttribute SearchVo vo, Integer userType,
			Integer userState, Integer companyId, PageVo pagevo) {

		// 列表查询
		if (pagevo == null) {
			pagevo = new PageVo(0, 10);
		}
		
		Map map =vo.getMap();
		
		if(userState!=null && userState>-1)
		{
			map.put("userState", userState);
		}
		
		if(userType!=null && userType>-1)
		{
			map.put("userType", userType);
		}
		
		if(companyId!=null && companyId>-1)
		{
			map.put("companyId", companyId);
		}

		Page page = caseUserService.getCaseUserList(pagevo, map);

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
	@AuthPassport(rightCode = "CaseManage.CaseUser")
	@RequestMapping(value = "/caseUserExport")
	public @ResponseBody
	ResultMessage export(@ModelAttribute SearchVo vo, PageVo pagevo) {

		pagevo = new PageVo(0,5000);

		List list = caseUserService.getCaseUserList(pagevo, vo.getMap());

		if (list != null && list.size() > 0) {
			Map map = new HashMap();

			Map<Integer, String> stateMap = new HashMap<Integer, String>();
			stateMap.put(0, "禁用");
			stateMap.put(1, "正常");
			stateMap.put(2, "冻结");
			map.put("stateMap", stateMap);
			
			Map<Integer, String> userTypeMap = new HashMap<Integer, String>();
			userTypeMap.put(1, "地产员工");
			userTypeMap.put(2, "代理员工");
			map.put("userTypeMap", userTypeMap);
			
			Map companyMap = companyService.getAllCompanyMap();
			map.put("companyMap", companyMap);

			try {
				ExcelExport export = ExcelUtil.exportList(list, "caseUserData",
						"案场用户数据", map);
				if(export!=null)
				{
					this.dowloadExcel(export, "caseUserdata.xls");
					return ResultMessage.successMsg("下载成功!");
				}else{
					return ResultMessage.errorMsg("请检查导出参数caseUserData是否配置");
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
	 * @param userId
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.CaseUser")
	@RequestMapping(value = "/caseUserDetail")
	public @ResponseBody
	ResultMessage detail(@RequestParam Long userId) {
		String message = "";
		if (userId == null) {
			message = "案场用户ID不能空";
			return ResultMessage.errorMsg(message);
		}

		TcasUser caseUser = caseUserService.getCaseUserById(userId);
		if (caseUser == null) {
			message = "未找到该案场用户";
			return ResultMessage.errorMsg(message);
		}

		return ResultMessage.successMsg("获取成功", caseUser);
	}

	/**
	 * 增加
	 * 
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.CaseUser")
	@RequestMapping(value = "/caseUserAdd")
	public @ResponseBody
	ResultMessage add(@Valid @RequestBody CaseUserModel caseUserModel,
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
		TcasUser caseUser = new TcasUser();
		BeanUtils.copyProperties(caseUserModel, caseUser);
		caseUser.setCreateTime(new Date());
		// caseUser.setState(1);
		caseUserService.insert(caseUser);
		return ResultMessage.successMsg("添加成功");
	}

	/**
	 * 编辑
	 * 
	 * @param vo
	 * @param userId
	 * @param errors
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.CaseUser")
	@RequestMapping(value = "/caseUserEdit")
	public @ResponseBody
	ResultMessage edit(@Valid @RequestBody CaseUserModel caseUserModel,
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

		Long userId = caseUserModel.getUserId();
		String message = "";
		if (userId == null) {
			message = "案场用户ID不能空";
			return ResultMessage.errorMsg(message);
		}

		TcasUser caseUser = caseUserService.getCaseUserById(userId);
		if (caseUser == null) {
			message = "未找到该案场用户";
			return ResultMessage.errorMsg(message);
		}

		MyBeanUtils.copyProperties(caseUserModel, caseUser,
				caseUserModel.colset);
		// caseUser.setModifyTime(new Date());

		caseUserService.update(caseUser);

		return ResultMessage.successMsg("修改成功");
	}

	/**
	 * 
	 * @param userId
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.CaseUser")
	@RequestMapping(value = "/caseUserDelete")
	public @ResponseBody
	ResultMessage delete(@RequestParam Long userId) {

		if (userId == null) {
			return ResultMessage.errorMsg("案场用户ID不能空");
		}

		TcasUser caseUser = caseUserService.getCaseUserById(userId);
		if (caseUser == null) {
			return ResultMessage.errorMsg("未找到该案场用户");
		}

		// 判断状态
		// if(caseUser.getState()==2)
		// {
		caseUserService.delete(userId);
		// }else{

		// caseUserService.updateToDelete(userId);
		// }

		return ResultMessage.successMsg("删除成功");
	}
	

}
