/**   
 * @Title: AuthPassport.java 
 * @Package com.dfzy.annotation 
 * @Description: (自定义权限验证注解) 
 * @author lit  
 * @date 2014年8月8日 下午3:45:32 
 * @version V1.0   
 */
package com.sxit.common.annatation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: AuthPassport
 * @Description: (自定义权限验证注解)
 * @author 张如兵
 * @date 2014年8月8日 下午3:45:32
 * 
 */
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthPassport {
	String rightCode() default "common";
}
