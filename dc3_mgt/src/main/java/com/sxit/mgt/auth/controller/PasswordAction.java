package com.sxit.mgt.auth.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxit.common.action.BaseAction;
import com.sxit.common.annatation.AuthPassport;
import com.sxit.common.dto.ResultMessage;
import com.sxit.common.security.MD5;
import com.sxit.mgt.system.service.SysUserService;
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
public class PasswordAction extends BaseAction {
	@Autowired
	private SysUserService sysUserService;
	
	
	@AuthPassport(rightCode = "common")
	@RequestMapping(value = "/updatePassword2")
	public String updatePassword2() { 
		return "auth/login/password_update";
	}
	
	
	@AuthPassport(rightCode = "common")
	@RequestMapping(value = "/updatePassword")
	public @ResponseBody  ResultMessage updatePassword(@RequestParam Integer userId ,HttpServletRequest request) {
		if (userId == null) {
			return ResultMessage.errorMsg("用户管理ID不能空");
		}
		
		String oldpasswd = request.getParameter("oldpasswd"); 
		
		if ( oldpasswd==null || "".equals(oldpasswd)) {
			return ResultMessage.errorMsg("旧密码不能空");
		}
		
		String newpasswd = request.getParameter("newpasswd1"); 
		String newpasswd2 = request.getParameter("newpasswd2");
		
		if ( newpasswd==null || "".equals(newpasswd)) {
			return ResultMessage.errorMsg("新密码不能空");
		}
		
		if ( newpasswd2==null || "".equals(newpasswd2)) {
			return ResultMessage.errorMsg("确认密码不能空");
		}
		
		if (!newpasswd.equals(newpasswd2)) {
			return ResultMessage.errorMsg("2次输入密码不相同");
		}
		
		SysUser sysUser = sysUserService.getSysUserById(userId);
		
		String md5pass = MD5.md5(oldpasswd);
		if( !md5pass.equals(sysUser.getPassword().toLowerCase().trim()) ){
			return ResultMessage.errorMsg("旧密码输入不正确");
		}
		String md5newpw = MD5.md5(newpasswd);
		//userService.updatePassword(userId, md5newpw);
		return ResultMessage.successMsg("修改密码成功"); 
		
	}
}
