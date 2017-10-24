package spittr.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import spittr.filter.MyFilter;

public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	/**
	 * 注册ContextLoaderListener监听
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class };
	}
	
	/**
	 * 注册DispatcherServlet
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}
	
	/**
	 * 配置multipart具体细节
	 */
	@Override
	protected void customizeRegistration(Dynamic registration) {
		registration.setMultipartConfig(new MultipartConfigElement("/tmp/spittr/uploads",2097152,4194394,0));
	}

	/**
	 * 处理进入应用的所有请求
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	/**
	 * 注册Filter并映射到DispatcherServlet
	 */
	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new MyFilter() };
	}

}
