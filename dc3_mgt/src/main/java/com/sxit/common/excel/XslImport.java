package com.sxit.common.excel;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface XslImport {
	String name() default "";
	int columnNum() default 1;
	boolean notNull() default true;
	String regex() default "";
	DataEnum type() default DataEnum.String;
	String mapName() default "";
	int minLength() default -1;
	int maxLength() default -1;
}
