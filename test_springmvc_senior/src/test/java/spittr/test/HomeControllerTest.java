package spittr.test;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import spittr.web.HomeController;

public class HomeControllerTest {

	@Test
	public void testHomePage() throws Exception {
		HomeController controller = new HomeController();
		// 搭建MockMvc
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		//对“/”执行GET请求，并判断与结果是否为home视图
		mockMvc.perform(MockMvcRequestBuilders.get("/"))
							.andExpect(MockMvcResultMatchers.view().name("home"));
	}
}
