package spittr.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;

public class MyServletInitializer implements WebApplicationInitializer {
	
	/**
	 * 注册servlet
	 */
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		Dynamic myServlet = servletContext.addServlet("myServlet", MyServlet.class);
		myServlet.addMapping("/custom/**");
	}

}
