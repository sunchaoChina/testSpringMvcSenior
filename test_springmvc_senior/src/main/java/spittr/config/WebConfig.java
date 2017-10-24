package spittr.config;

import java.io.IOException;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc // 启动springMvc
@ComponentScan("spittr.web") // 启动组件扫描
public class WebConfig extends WebMvcConfigurerAdapter {

	/**
	 * 配置jsp视图解析器
	 * 
	 * @return
	 */
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		System.out.println("配置JSP视图解析器");
		resolver.setPrefix("/WEB-INF/views/");// 设置视图的前缀
		resolver.setSuffix(".jsp");// 设置视图的后缀
		resolver.setViewClass(JstlView.class);// 视图解析为JstlView
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;

	}
	
	/**
	 * 配置国际化
	 * @return
	 */
	@Bean
	public MessageSource messageSource() {
		System.out.println("国际化配置");
		ReloadableResourceBundleMessageSource messageSource = 
				new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:guojihua/messages");
		messageSource.setCacheSeconds(10);
		return messageSource;
	}
	
	/**
	 * 配置multipart解析器
	 * @return
	 * @throws IOException
	 */
	@Bean
	public MultipartResolver multipartResolver() throws IOException{
		return new StandardServletMultipartResolver();
	}

	/**
	 * 配置静态资源的处理。DispatcherServlet将对静态的资源的请求转发到Servlet容器中默认的Servlet上，而不是本身来处理请求
	 * 放行css、js、jquery等静态资源
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println("配置静态资源处理");
		configurer.enable();
	}

}
