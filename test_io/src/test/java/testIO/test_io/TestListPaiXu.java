package testIO.test_io;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.io.vo.User;

public class TestListPaiXu {

	@Test
	public void test() {
		List<User> users = new ArrayList<User>();
		users.add(new User("卞强", "男", "2"));
		users.add(new User("米雪然", "男", "3"));
		users.add(new User("孙超", null, "1"));
		users.add(new User("黄帆", "男", "4"));
		users.add(new User("杨飞", null, "5"));
		users.add(new User("黄帆", "男", "6"));
		users.add(new User("黄帆1", null, "7"));
		Collections.sort(users);
		for (User u : users) {
			System.out.println(u.toString());
		}
	}

	@Test
	public void test1() {
		List<User> users = new ArrayList<User>();
		users.add(new User("米雪然", "男", "3331"));
		users.add(new User("孙超", null, "111"));
		users.add(new User("卞强", "男", "6663"));
		users.add(new User("黄帆", "男", "222"));
		users.add(new User("米雪然", "男", "3333"));
		users.add(new User("杨飞", null, "555"));
		users.add(new User("孙超", "男", "111"));
		users.add(new User("米雪然", "男", "333"));
		users.add(new User("卞强", "男", "6662"));
		users.add(new User("孙超", "男", "111"));
		users.add(new User("黄帆", null, "222"));
		users.add(new User("米雪然", "男", "3332"));
		users.add(new User("卞强", "男", "6661"));
		List<User> results = new ArrayList<User>();
		List<User> resultsAgxNotNull = new ArrayList<User>();
		for (User user : users) {
			if (user.getAgx() == null) {
				results.add(user);
			} else {
				resultsAgxNotNull.add(user);
			}
		}
		for (User userNotNull : resultsAgxNotNull) {
			if (!results.contains(userNotNull)) {
				results.add(userNotNull);
			}
		}
		for (User u : results) {
			System.out.println(u.toString());
		}
	}

}
