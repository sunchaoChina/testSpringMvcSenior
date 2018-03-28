package testDate.test_date;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TestDateSimpleDateFormat {

	@Test
	public void test() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
		Date d = new Date();

		System.out.println(sdf.format(d));
	}

}
