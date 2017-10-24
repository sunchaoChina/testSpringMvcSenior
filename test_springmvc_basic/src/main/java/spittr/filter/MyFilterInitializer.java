package spittr.filter;

import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

public class MyFilterInitializer implements WebApplicationInitializer {
	
	/**
	 * 注册拦截器
	 */
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		Dynamic filter = servletContext.addFilter("myFilter", MyFilter.class);
		filter.addMappingForServletNames(null, false, "/custom/*");

	}

}
