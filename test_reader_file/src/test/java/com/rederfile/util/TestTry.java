package com.rederfile.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.Lists;

public class TestTry {

	@Test
	public void test() {
		try {
			try {
				BigDecimal a = new BigDecimal(12.23);
				BigDecimal b = BigDecimal.ZERO;
				a.divide(b);
				throw new NullPointerException();
			} catch (ArithmeticException e) {
				System.out.println("报错了");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_iterable() {
		String a = "1,2,3,4,5";
		String[] as = a.split(",");
		List<String> aas = Lists.newArrayList(as);
		for (int i = 0; i < as.length; i++) {
			System.out.println(as[i]);
		}
	}

	@Test
	public void test_stringArray() {
		String[] a = { "r", "t", "y", "u" };
		System.out.println(a.toString());
	}

	@Test
	public void test_to_array() {
		List<String> s = new ArrayList<String>();
		s.add("123");
		s.add("321");
		String[] sarray = s.toArray(new String[s.size()]);
		for (String sa : sarray) {
			System.out.println(sa);
		}

	}

	@Test
	public void test_double() {
		List<String> s = new ArrayList<String>();
		s.add("123");
		s.add("321");
		String[] sarray = s.toArray(new String[s.size()]);
		for (String sa : sarray) {
			System.out.println(sa);
		}

	}

	@Test
	public void test_big() {
		double b = 0.12345;
		System.out.println(b);
		String a = null;
		System.out.println(new BigDecimal(a));
	}

	@Test
	public void test_map() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "ab");
		map.put(4, "ab");
		map.put(4, "ab");// 和上面相同 ， 会自己筛选
		System.out.println(map.size());
		// 第一种：
		/*
		 * Set<Integer> set = map.keySet(); //得到所有key的集合
		 * 
		 * for (Integer in : set) { String str = map.get(in);
		 * System.out.println(in + "     " + str); }
		 */
		System.out.println("第一种：通过Map.keySet遍历key和value：");
		for (Integer in : map.keySet()) {
			// map.keySet()返回的是所有key的值
			String str = map.get(in);// 得到每个key多对用value的值
			System.out.println(in + "     " + str);
		}
		// 第二种：
		System.out.println("第二种：通过Map.entrySet使用iterator遍历key和value：");
		Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, String> entry = it.next();
			System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
		}
		// 第三种：推荐，尤其是容量大时
		System.out.println("第三种：通过Map.entrySet遍历key和value");
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			// Map.entry<Integer,String> 映射项（键-值对） 有几个方法：用上面的名字entry
			// entry.getKey() ;entry.getValue(); entry.setValue();
			// map.entrySet() 返回此映射中包含的映射关系的 Set视图。
			System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
		}
		// 第四种：
		System.out.println("第四种：通过Map.values()遍历所有的value，但不能遍历key");
		for (String v : map.values()) {
			System.out.println("value= " + v);
		}

	}

	@Test
	public void test_map2() {
		String a = "M61";
		System.out.println(a.substring(1));
		Map<Integer, String> map = new HashMap<Integer, String>();
		System.out.println(map.get(1));
		for (Integer s : map.keySet()) {
			System.out.println(s);
		}

	}

	public class Aug {
		private String a;

		public String getA() {
			return a;
		}

		public void setA(String a) {
			this.a = a;
		}

		@Override
		public String toString() {
			return "Aug [a=" + a + "]";
		}

	}
}
