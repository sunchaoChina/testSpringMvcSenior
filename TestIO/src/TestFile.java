import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class TestFile {

	@Test
	public void test() {
		File f = new File("./Files/text.txt");
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
