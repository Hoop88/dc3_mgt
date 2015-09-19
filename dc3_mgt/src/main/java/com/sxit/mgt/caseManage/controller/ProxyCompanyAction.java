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
import com.sxit.mgt.caseManage.dto.CompanyModel;
import com.sxit.mgt.caseManage.service.CompanyService;
import com.sxit.model.caseManage.TcasCompany;

/**
 * @公司:深讯信科
 * @功能:城市公司 Action
 * @作者:张如兵
 * @日期:2015-07-22 17:36:56
 * @版本:1.0
 * @修改:
 */

@Controller
@RequestMapping("/caseManage")
public class ProxyCompanyAction extends BaseAction {

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
	@AuthPassport(rightCode = "CaseManage.ProxyCompany")
	@RequestMapping(value = "/proxyCompanyList")
	public @ResponseBody
	ResultMessage list(@ModelAttribute SearchVo vo, PageVo pagevo) {

		// 列表查询
		if (pagevo == null) {
			pagevo = new PageVo(0, 10);
		}

		Map map = vo.getMap();
		map.put("companyType", 2);

		Page page = companyService.getCompanyList(pagevo, map);

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
	@AuthPassport(rightCode = "CaseManage.ProxyCompany")
	@RequestMapping(value = "/proxyCompanyExport")
	public @ResponseBody
	ResultMessage export(@ModelAttribute SearchVo vo, PageVo pagevo) {

		pagevo = new PageVo(0, 5000);

		List list = companyService.getCompanyList(pagevo, vo.getMap());

		if (list != null && list.size() > 0) {
			Map map = new HashMap();

			Map<Integer, String> stateMap = new HashMap<Integer, String>();
			stateMap.put(0, "禁用");
			stateMap.put(1, "正常");
			stateMap.put(2, "冻结");
			map.put("stateMap", stateMap);

			try {
				ExcelExport export = ExcelUtil.exportList(list,
						"proxyCompanyData", "城市公司数据", map);
				this.dowloadExcel(export, "proxyCompanydata.xls");
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
	 * @param companyId
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.ProxyCompany")
	@RequestMapping(value = "/proxyCompanyDetail")
	public @ResponseBody
	ResultMessage detail(@RequestParam Long companyId) {
		String message = "";
		if (companyId == null) {
			message = "城市公司ID不能空";
			return ResultMessage.errorMsg(message);
		}

		TcasCompany proxyCompany = companyService.getCompanyById(companyId);
		if (proxyCompany == null) {
			message = "未找到该城市公司";
			return ResultMessage.errorMsg(message);
		}

		/*
		 * Long projectId = companyService.getProjectLevel1Id(companyId);
		 * 
		 * proxyCompany.setProjectId(projectId);
		 */

		return ResultMessage.successMsg("获取成功", proxyCompany);
	}

	/**
	 * 增加
	 * 
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.ProxyCompany")
	@RequestMapping(value = "/proxyCompanyAdd")
	public @ResponseBody
	ResultMessage add(@Valid @RequestBody CompanyModel companyModel,
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
		TcasCompany proxyCompany = new TcasCompany();
		BeanUtils.copyProperties(companyModel, proxyCompany);
		proxyCompany.setCreateTime(new Date());
		// proxyCompany.setState(1);
		companyService.insertProxyCompany(proxyCompany);
		return ResultMessage.successMsg("添加成功");
	}

	/**
	 * 编辑
	 * 
	 * @param vo
	 * @param companyId
	 * @param errors
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.ProxyCompany")
	@RequestMapping(value = "/proxyCompanyEdit")
	public @ResponseBody
	ResultMessage edit(@Valid @RequestBody CompanyModel companyModel,
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

		Long companyId = companyModel.getCompanyId();
		String message = "";
		if (companyId == null) {
			message = "城市公司ID不能空";
			return ResultMessage.errorMsg(message);
		}

		TcasCompany proxyCompany = companyService.getCompanyById(companyId);
		if (proxyCompany == null) {
			message = "未找到该城市公司";
			return ResultMessage.errorMsg(message);
		}

		MyBeanUtils.copyProperties(companyModel, proxyCompany,
				companyModel.colset);
		// proxyCompany.setModifyTime(new Date());

		companyService.updateProxyCompany(proxyCompany);

		return ResultMessage.successMsg("修改成功");
	}

	/**
	 * 
	 * @param companyId
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.ProxyCompany")
	@RequestMapping(value = "/proxyCompanyDelete")
	public @ResponseBody
	ResultMessage delete(@RequestParam Long companyId) {

		if (companyId == null) {
			return ResultMessage.errorMsg("城市公司ID不能空");
		}

		TcasCompany proxyCompany = companyService.getCompanyById(companyId);
		if (proxyCompany == null) {
			return ResultMessage.errorMsg("未找到该城市公司");
		}

		// 判断状态
		// if(proxyCompany.getState()==2)
		// {
		companyService.delete(companyId);
		// }else{

		// companyService.updateToDelete(companyId);
		// }

		return ResultMessage.successMsg("删除成功");
	}

}
