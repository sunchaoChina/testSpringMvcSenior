package com.rederfile.util;

import java.math.BigDecimal;

import org.junit.Test;

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

}
