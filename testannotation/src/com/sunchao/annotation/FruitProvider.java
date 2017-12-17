package com.sunchao.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface FruitProvider {
	/**
	 * 供应商编号
	 * 
	 * @return
	 */
	public int id() default -1;

	/**
	 * 供应商名称
	 * 
	 * @return
	 */
	public String name() default "";

	/**
	 * 供应商地址
	 * 
	 * @return
	 */
	public String address() default "";
	
}
