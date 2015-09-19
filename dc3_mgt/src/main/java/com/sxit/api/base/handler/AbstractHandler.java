package com.sxit.api.base.handler;

import java.util.Set;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.sxit.api.base.vo.ResponseVo;
import com.sxit.model.report.LogApi;
/**
 * 
 * @author agu
 *
 */
public abstract class AbstractHandler implements IHandler {
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	protected String content;
	protected ResponseVo responseMsg;
	protected LogApi op;
	private Validator validator;

	@Resource
	public void setValidator(LocalValidatorFactoryBean validatorFactory) {// 使用spring中定义的factory
		validator = validatorFactory.getValidator();
	}

	public AbstractHandler() {
		super();
	}

	@Override
	public boolean init(String content) throws Exception {
		this.content = content;
		return handlerInitial();
	}

	/**
	 * 用户扩展的初始化方法
	 */
	public abstract boolean handlerInitial() throws Exception;

	/**
	 * 获取返回信息 
	 */
	@Override
	public ResponseVo getResponseMsg() {
		return responseMsg;
	}

	/**
	 * 验证
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public <T> boolean verify(final T t) throws Exception {
		Set<ConstraintViolation<T>> failures = validator.validate(t);
		for (ConstraintViolation<T> fail : failures) {
			setResponseMsg(ResponseVo.errorMsg(fail.getMessage()));
			return false;
		}
		return true;
	}
	/**
	 * 设置返回消息
	 * @param responseMsg
	 */
	public void setResponseMsg(ResponseVo responseMsg) {
		this.responseMsg = responseMsg;
	}
	
	/**
	 * 设置返回消息
	 * @param responseMsg
	 */
	public void successMsg(ResponseVo responseMsg) {
		this.responseMsg = responseMsg;
	}
	
	/**
	 * 设置返回消息
	 * @param responseMsg
	 */
	public void errorMsg(ResponseVo responseMsg) {
		this.responseMsg = responseMsg;
	}
}
