package com.sxit.api.base.action;

import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.sxit.api.base.service.ApiService;
import com.sxit.api.base.vo.RequestVo;
import com.sxit.api.base.vo.ResponseVo;
import com.sxit.common.config.InterfaceConfig;
import com.sxit.common.security.DESCoder;
import com.sxit.common.utils.JsonUtils;
import com.sxit.model.report.LogApi;

/**
 * 
 * @author agu
 *
 */

public class BaseAction {
	protected HttpServletRequest request;
	protected HttpSession session;
	protected HttpServletResponse response;
	protected LogApi op;
	@Autowired
	protected ApiService apiService;

	public BaseAction() {
		super();
	}

	@ModelAttribute
	public void setHttp(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
		op = new LogApi(this.getCururl(), this.getIp());
		// op.setReqData(getReqData());
	}

	/**
	 * 将信息存储到会话信息中
	 */
	protected void set(String key, Object value) {
		request.getSession().setAttribute(key, value);
	}

	/**
	 * 从会话信息中获取信息
	 */
	protected Object get(String key) {
		return request.getSession().getAttribute(key);
	}

	/**
	 * 获取当前url
	 * 
	 * @return
	 */
	public String getCururl() {

		String reqStr = request.getRequestURL().toString();
		String queryStr = request.getQueryString();

		if (StringUtils.isBlank(queryStr)) {
			return reqStr;
		} else {
			return reqStr + "?" + queryStr;
		}
	}

	/**
	 * 获取当前IP
	 * 
	 * @return
	 */
	public String getIp() {
		String ip = request.getHeader("X-Real-IP");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个IP值，第一个为真实IP。
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		} else {
			return request.getRemoteAddr();
		}
	}

	/**
	 * 设置请求数据
	 * 
	 * @param o
	 */
	protected void setReqData(RequestVo req) {
		try {
			String json = JsonUtils.serialize(req);
			op.setReqData(json);
			op.setVersionNum(req.getVersionNum());
			op.setAppCode(req.getAppCode());
			op.setAppVersion(req.getAppVersion());
			op.setImei(req.getImei());
			op.setModelNum(req.getModelNum());
			op.setIntName(req.getCommand());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//apiService.save(op);
		}
	}

	/**
	 * 设置请求内容 非加密
	 * 
	 * @param reqContent
	 */
	public void setReqContent(String reqContent) {
		op.setReqContent(reqContent);
	}

	/**
	 * 设置返回数据
	 * 
	 * @param o
	 */
	protected void setResData(ResponseVo o) {
		try {
			String json = JsonUtils.serialize(o);
			op.setResData(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 设置返回内容 非加密
	 * 
	 * @param reqContent
	 */
	public void setResContent(String resContent) {
		op.setResContent(resContent);
	}

	/**
	 * 设置异常数据
	 * 
	 * @param msg
	 */
	protected void setExcData(String msg) {
		op.setExcData(msg);
	}

	/**
	 * 返回成功信息
	 * 
	 * @param msg
	 * @return
	 */
	public ResponseVo successMsg(String msg) {
		ResponseVo rv = new ResponseVo(0, 0, msg);
		setResData(rv);
		return rv;
	}

	/**
	 * 返回成功信息
	 * 
	 * @param msg
	 * @param content
	 * @return
	 */
	public ResponseVo successMsg(String msg, String content) {
		ResponseVo rv = new ResponseVo(0, 0, msg, content);
		setResData(rv);
		return rv;
	}

	/**
	 * 返回成功信息
	 * 
	 * @param status
	 * @param msg
	 * @param content
	 * @return
	 */
	public ResponseVo successMsg(int status, String msg, String content) {
		ResponseVo rv = new ResponseVo(0, status, msg, content);
		setResData(rv);
		return rv;
	}

	/**
	 * 返回错误信息
	 * 
	 * @param msg
	 * @return
	 */
	public ResponseVo errorMsg(String msg) {
		ResponseVo rv = new ResponseVo(1, 0, msg);
		setResData(rv);
		return rv;
	}

	/**
	 * 返回错误细细
	 * 
	 * @param msg
	 * @param status
	 * @return
	 */
	public ResponseVo errorMsg(String msg, int status) {
		ResponseVo rv = new ResponseVo(1, status, msg);
		setResData(rv);
		return rv;
	}

	/**
	 * 返回handlerMsg
	 * 
	 * @param msg
	 * @param status
	 * @return
	 */
	public ResponseVo handlerMsg(ResponseVo rv) {
		setResContent(rv.getContent());
		if(op.getIsdes()==1)
		{
			setResData(rv.desContent());
		}else{
			setResData(rv);
		}
		return rv;
	}
}
