import org.junit.Test;

public class TestExceptionTry {

	@Test
	public void test() {
		try {
			int a = 1;
			int b = 10;
			int c = a / b;
			System.out.println("代码完全成功");
		} catch (Exception e) {
			System.out.println("代码存在异常");
		}
	}

}
