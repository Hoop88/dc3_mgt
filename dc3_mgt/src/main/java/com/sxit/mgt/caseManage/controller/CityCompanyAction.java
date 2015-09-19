package com.sxit.mgt.caseManage.controller;

import java.util.ArrayList;
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
import com.sxit.common.dto.TreeStringNode;
import com.sxit.common.excel.ExcelExport;
import com.sxit.common.excel.ExcelUtil;
import com.sxit.common.pagehelper.Page;
import com.sxit.common.pagehelper.PageVo;
import com.sxit.common.utils.MyBeanUtils;
import com.sxit.mgt.caseManage.dto.CompanyModel;
import com.sxit.mgt.caseManage.service.CompanyService;
import com.sxit.mgt.caseManage.service.ProjectManageService;
import com.sxit.mgt.system.dto.Node;
import com.sxit.model.caseManage.TcasCompany;
import com.sxit.model.caseManage.TcasProject;

/**
 * @公司:深讯信科
 * @功能:城市公司 Action
 * @作者:张如兵
 * @日期:2015-07-22 17:36:17
 * @版本:1.0
 * @修改:
 */

@Controller
@RequestMapping("/caseManage")
public class CityCompanyAction extends BaseAction {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private ProjectManageService projectManageService;

	/**
	 * 获取部门的树
	 * 
	 * @param vo
	 * @param pagevo
	 * @return
	 */
	@AuthPassport(rightCode = "common")
	@RequestMapping(value = "/cityProjectTree")
	public @ResponseBody
	List<TreeStringNode> tree() {

		PageVo pagevo = new PageVo(0, 1000);
		Map map = new HashMap();
		map.put("companyType", 1);

		// 列表查询
		List<TcasCompany> list = companyService.getCompanyList(pagevo, map);

		Map map2 = new HashMap();
		map2.put("projectType", 1);

		List<TcasProject> projectList = projectManageService
				.getProjectManageList(pagevo, map2);

		List<TreeStringNode> nodelist = new ArrayList<TreeStringNode>();

		for (TcasCompany company : list) {
			TreeStringNode node_company = new TreeStringNode(company
					.getCompanyId().toString(), company.getCompanyName(), "");

			for (TcasProject project : projectList) {
				if (company.getCompanyId().equals(project.getCompanyId())) {
					TreeStringNode node_project = new TreeStringNode(
							project.getProjectCode(), project.getProjectName(),
							"");
					node_company.addChild(node_project);
				}
			}

			nodelist.add(node_company);
		}

		return nodelist;
	}

	/**
	 * 列表
	 * 
	 * @param searchTxt
	 * @param page
	 * @param model
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.CityCompany")
	@RequestMapping(value = "/cityCompanyList")
	public @ResponseBody
	ResultMessage list(@ModelAttribute SearchVo vo, PageVo pagevo) {

		// 列表查询
		if (pagevo == null) {
			pagevo = new PageVo(0, 10);
		}

		Map map = vo.getMap();
		map.put("companyType", 1);

		Page page = companyService.getCompanyList(pagevo, map);

		return ResultMessage.successPage(page);
	}

	@AuthPassport(rightCode = "common")
	@RequestMapping(value = "/cityCompanyMap")
	public @ResponseBody
	ResultMessage getCompanyMap() {

		Map map = companyService.getCityCompanyMap();

		return ResultMessage.successMsg("ok", map);
	}

	@AuthPassport(rightCode = "common")
	@RequestMapping(value = "/allCompanyMap")
	public @ResponseBody
	ResultMessage getAllCompanyMap() {
		Map map = companyService.getAllCompanyMap();
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
	@AuthPassport(rightCode = "CaseManage.CityCompany")
	@RequestMapping(value = "/cityCompanyExport")
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
						"cityCompanyData", "城市公司数据", map);
				this.dowloadExcel(export, "cityCompanyData.xls");
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
	@AuthPassport(rightCode = "CaseManage.CityCompany")
	@RequestMapping(value = "/cityCompanyDetail")
	public @ResponseBody
	ResultMessage detail(@RequestParam Long companyId) {
		String message = "";
		if (companyId == null) {
			message = "城市公司ID不能空";
			return ResultMessage.errorMsg(message);
		}

		TcasCompany cityCompany = companyService.getCompanyById(companyId);
		if (cityCompany == null) {
			message = "未找到该城市公司";
			return ResultMessage.errorMsg(message);
		}

		return ResultMessage.successMsg("获取成功", cityCompany);
	}

	/**
	 * 增加
	 * 
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.CityCompany")
	@RequestMapping(value = "/cityCompanyAdd")
	public @ResponseBody
	ResultMessage add(@Valid @RequestBody CompanyModel cityCompanyModel,
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
		TcasCompany cityCompany = new TcasCompany();
		BeanUtils.copyProperties(cityCompanyModel, cityCompany);
		cityCompany.setCreateTime(new Date());
		// cityCompany.setState(1);
		companyService.insert(cityCompany);
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
	@AuthPassport(rightCode = "CaseManage.CityCompany")
	@RequestMapping(value = "/cityCompanyEdit")
	public @ResponseBody
	ResultMessage edit(@Valid @RequestBody CompanyModel cityCompanyModel,
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

		Long companyId = cityCompanyModel.getCompanyId();
		String message = "";
		if (companyId == null) {
			message = "城市公司ID不能空";
			return ResultMessage.errorMsg(message);
		}

		TcasCompany cityCompany = companyService.getCompanyById(companyId);
		if (cityCompany == null) {
			message = "未找到该城市公司";
			return ResultMessage.errorMsg(message);
		}

		MyBeanUtils.copyProperties(cityCompanyModel, cityCompany,
				cityCompanyModel.colset);
		// cityCompany.setModifyTime(new Date());

		companyService.update(cityCompany);

		return ResultMessage.successMsg("修改成功");
	}

	/**
	 * 
	 * @param companyId
	 * @return
	 */
	@AuthPassport(rightCode = "CaseManage.CityCompany")
	@RequestMapping(value = "/cityCompanyDelete")
	public @ResponseBody
	ResultMessage delete(@RequestParam Long companyId) {

		if (companyId == null) {
			return ResultMessage.errorMsg("城市公司ID不能空");
		}

		TcasCompany cityCompany = companyService.getCompanyById(companyId);
		if (cityCompany == null) {
			return ResultMessage.errorMsg("未找到该城市公司");
		}

		// 判断状态
		// if(cityCompany.getState()==2)
		// {
		companyService.delete(companyId);
		// }else{

		// companyService.updateToDelete(companyId);
		// }

		return ResultMessage.successMsg("删除成功");
	}

}
