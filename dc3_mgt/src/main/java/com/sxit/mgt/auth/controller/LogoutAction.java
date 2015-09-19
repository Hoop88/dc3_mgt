/**   
 * @Title: LogoutAction.java 
 * @Package com.dfzy.logout 
 * @Description: (退出系统) 
 * @author lit  
 * @date 2014年8月8日 上午11:32:24 
 * @version V1.0   
 */
package com.sxit.mgt.auth.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxit.common.action.BaseAction;
import com.sxit.common.dto.ResultMessage;

/**
 * @ClassName: LogoutAction
 * @Description: (退出系统)
 * @author lit
 * @date 2014年8月8日 上午11:32:24
 * 
 */
@Controller
@RequestMapping("/auth")
public class LogoutAction extends BaseAction {
	@RequestMapping(value = "/logout")
	public @ResponseBody
	ResultMessage logout() {
		HttpSession session = getHttpSession();
		session.removeAttribute("baseUser");
		session.removeAttribute("menuMap");
		session.invalidate();
		return ResultMessage.successMsg("ok");
	}
}
