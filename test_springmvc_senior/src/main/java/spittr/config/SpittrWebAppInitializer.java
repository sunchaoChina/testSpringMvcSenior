package spittr.config;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import spittr.filter.MyFilter;

public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * 
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class };
	}

	/**
	 * 指定配置类
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	/**
	 * 处理进入应用的所有请求
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	/**
	 * 组测Filter并映射到DispatcherServlet
	 */
	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new MyFilter() };
	}

}
