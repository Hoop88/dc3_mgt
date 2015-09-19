package com.sxit.mgt.auth.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxit.common.action.BaseAction;
import com.sxit.common.dto.ResultMessage;
import com.sxit.common.memery.CacheData;
import com.sxit.mgt.auth.service.LoginService;
import com.sxit.mgt.auth.vo.EMenu;
import com.sxit.mgt.auth.vo.LoginBean;
import com.sxit.mgt.common.service.CommonService;
import com.sxit.model.system.BaseUser;
import com.sxit.model.system.SysParams;
import com.sxit.model.system.SysUser;

/**
 * @公司:深讯信科
 * @功能:登录 Action
 * @作者:张如兵
 * @日期:2015-03-02 15:50:48
 * @版本:1.0
 * @修改:
 */

@Controller
@RequestMapping("/auth")
public class LoginAction extends BaseAction {

	@Autowired
	private LoginService loginService;

	/**
	 * 登录接口 post用户名密码
	 * 
	 * @param p
	 * @param errors
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody
	ResultMessage login(@Valid @RequestBody LoginBean p, Errors errors) {

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

		String sessionRand = this.getStr("random");

		sessionRand = "1234";

		// 验证码只能使用一次
		this.set("random", null);

		if (StringUtils.isBlank(sessionRand)) {
			return ResultMessage.errorMsg("验证码已过期");
		}

		if (!sessionRand.toLowerCase().equals(p.getRandnum().toLowerCase())) {
			return ResultMessage.errorMsg("验证码错误");
		}

		/** 登录 */
		SysUser user = loginService.login(p.getUserName(), p.getPassword());

		if (user == null) {
			return ResultMessage.errorMsg("登录失败,用户名或密码错误");
		}

		BaseUser baseUser = new BaseUser(user);

		this.set("baseUser", baseUser);

		// 管理员
		if (user.getUserType() == 5) {

			// 获取权限
			Set right_set = loginService.getSysRightSet();
			// 设置权限
			this.set("rightSet", right_set);

		} else {

			// 获取权限
			Set right_set = loginService.getRightSet(user.getUserId());
			// 设置权限
			this.set("rightSet", right_set);

		}
		return ResultMessage.successMsg("登录成功", baseUser);
	}

	/**
	 * 登录后的初始化数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "/initData", method = RequestMethod.POST)
	public @ResponseBody
	ResultMessage initData() {

		try {

			BaseUser baseUser = this.getCurUser();
			if (baseUser == null) {
				return ResultMessage.errorMsg("登录已经过期", 3);
			}

			Map<Object, Object> map = new HashMap();

			if (baseUser.getUserType() == 5) {
				List<EMenu> menuList = loginService.getEMenuAll();

				map.put("menu", menuList);
				map.put("user", baseUser);

				return ResultMessage.successMsg("成功", map);

			} else {

				List<EMenu> menuList = loginService.getEMenuAll();
				map.put("menu", menuList);
				map.put("user", baseUser);
				return ResultMessage.successMsg("成功", map);
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e.fillInStackTrace());
			return ResultMessage.errorMsg("系统错误", 1);
		}
	}

	/**
	 * 验证权限
	 * 
	 * @return
	 */
	@RequestMapping(value = "/authPath", method = RequestMethod.POST)
	public @ResponseBody
	ResultMessage authPath(String route) {
		try {

			if (StringUtils.isBlank(route)) {
				return ResultMessage.errorMsg("缺少参数");
			}
			
			Map<String, String> pathRightMap = CacheData.getPathRightMap();

			String right = pathRightMap.get(route.toLowerCase());

			if (right == null) {
				return ResultMessage.errorMsg("该路径未启用", 1);
			}

			Object object = this.get("rightSet");

			if (object == null) {
				return ResultMessage.errorMsg("登录已经过期", 3);
			}

			Set<String> rightSet = (Set<String>) object;

			rightSet.add("common");

			if (rightSet.contains(right.toLowerCase().trim())) {
				return ResultMessage.successMsg("成功");
			} else {
				return ResultMessage.errorMsg("您没有权限访问此功能", 1);
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e.fillInStackTrace());
			return ResultMessage.errorMsg("系统错误", 1);
		}
	}

	@RequestMapping(value = "/nopower", method = RequestMethod.GET)
	public String nopower() {
		return "auth/nopower";
	}
	

	

}
