package com.rxwx.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 
 * @author hjw
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidateToken {

	/**
	 * token field Name
	 * 
	 * @return
	 */
	public String tokenField() default "token";

	/**
	 * uid field Name
	 * 
	 * @return
	 */
	public String uidField() default "uid";
}
