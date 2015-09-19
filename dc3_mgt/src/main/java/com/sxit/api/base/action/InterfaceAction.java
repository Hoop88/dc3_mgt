package com.sxit.api.base.action;

import java.net.URLDecoder;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxit.api.base.handler.IHandler;
import com.sxit.api.base.vo.RequestVo;
import com.sxit.api.base.vo.ResponseVo;
import com.sxit.common.config.InterfaceConfig;
import com.sxit.common.security.DESCoder;
import com.sxit.common.utils.Globals;

/**
 * API接口统一封装
 * 
 * @author agu
 *
 */

@Controller
@Scope("prototype")
@RequestMapping("/api")
public class InterfaceAction extends BaseAction {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	public InterfaceAction() {
		super();
		//  Auto-generated constructor stub
	}

	/**
	 * 客户端统一接口
	 * 
	 * @param req
	 * @param errors
	 * @return
	 */
	@RequestMapping(value = "/interface", method = RequestMethod.POST)
	public @ResponseBody ResponseVo api(@Valid @RequestBody RequestVo req,
			Errors errors) {
		try {
			// 设置返回数据 用于日志记录
			setReqData(req);
			
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
				return errorMsg(sb.toString(), 0);
			}

			// 验证参数合法性
			if (!req.verify()) {
				return errorMsg("数据被篡改或超时", 0);
			}

			// 解密content
			String content = null;
			if (StringUtils.isNotBlank(req.getContent())) {
				
				if(req.getIsdes()==1)
				{
					op.setIsdes(1);
					content = DESCoder.decrypt(URLDecoder.decode(
							req.getContent(), "utf-8"),
							InterfaceConfig.deskey);
				}else{
					content = req.getContent();
					op.setIsdes(0);
				}

				// 设置请求内容
				setReqContent(content); 
			}

			// 获取处理的bean
			IHandler handler = Globals.getBean(req.getCommand());

			if (handler == null) {
				return errorMsg("未找到对应的方法", 0);
				// 此处也可以动态加载来处理
			}

			// 初始化
			if(!handler.init(content)){
				return handlerMsg(handler.getResponseMsg());
			}
			
			// 验证
			if (handler.verify()) {
				// 执行
				handler.handle();				
			}
			op.setResult(1);
			return handlerMsg(handler.getResponseMsg());
			
		} catch (Exception e) {
			op.setResult(2);
			e.printStackTrace();
			setExcData(e.getMessage());
			return errorMsg("失败", 0);
		} finally {
			try {
				apiService.insert(op);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "api/test";
	}
}
