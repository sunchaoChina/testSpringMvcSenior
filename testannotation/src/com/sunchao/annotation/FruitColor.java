package com.sunchao.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface FruitColor {
	/**
	 * 颜色枚举
	 * 
	 * @author peida
	 *
	 */
	public enum Color {
		BULE, RED, GREEN
	};

	/**
	 * 颜色属性
	 * 
	 * @return
	 */
	Color fruitColor() default Color.GREEN;
}
