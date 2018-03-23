import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class TestDateCalendar {

	@Test
	public void test() {
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		String dayStr = (day < 10 ? "0" + day : "" + day);
		if (month == 10) {
			System.out.println("a" + dayStr);
		} else if (month == 11) {
			System.out.println("b" + dayStr);
		} else if (month == 12) {
			System.out.println("c" + dayStr);
		} else {
			System.out.println(month + dayStr);
		}
	}

}
