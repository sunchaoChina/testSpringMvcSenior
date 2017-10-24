package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping({"/","/homepage"})
public class HomeController {
	//处理对“/”的GET请求
	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		System.out.println("欢迎来到HomeController");
		//视图名为home
		return "home";
	}
}
