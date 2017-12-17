package com.sunchao.testrange;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.BoundType;
import com.google.common.collect.Range;
import com.google.common.primitives.Ints;

/**
 * Range定义了连续跨度的范围边界，这个连续跨度是一个可以比较的类型(Comparable type)
 * 
 * @author Administrator
 *
 */
public class TestBaseRange {

	@Before
	public void beforeMethod() {
		System.out.println("=============开始==============");
	}

	public void test2() {

	}

	@Test
	public void tryCatch() {
		try {
			System.out.println(BigDecimal.TEN.divide(BigDecimal.ONE));
			List<String> results = new ArrayList<String>();
			results.add("1");
			results.add("2");
			results.add("3");
			for(String result:results){
				results.remove(result);
			}
		} catch (ArithmeticException a) {
			System.out.println(a);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void test() {
		System.out.println("open:" + Range.open(1, 10));
		System.out.println("closed:" + Range.closed(1, 10));
		System.out.println("closedOpen:" + Range.closedOpen(1, 10));
		System.out.println("openClosed:" + Range.openClosed(1, 10));
		System.out.println("greaterThan:" + Range.greaterThan(10));
		System.out.println("atLeast:" + Range.atLeast(10));
		System.out.println("lessThan:" + Range.lessThan(10));
		System.out.println("atMost:" + Range.atMost(10));
		System.out.println("all:" + Range.all());
		System.out.println("closed:" + Range.closed(10, 10));
		System.out.println("closedOpen:" + Range.closedOpen(10, 10));
		// 会抛出异常
		// System.out.println("open:" + Range.open(10, 10));
		Range<Integer> r = Range.open(1, 10);
		if (r.contains(5)) {
			System.out.println("我成功了");
		}
		if (Range.closedOpen(4, 4).contains(4)) {
			System.out.println("在范围内，我成功了！");
		}
		if (Range.openClosed(4, 4).contains(4)) {
			System.out.println("在范围内，我成功了！");
		}
		if (Range.closed(4, 4).contains(4)) {
			System.out.println("在范围内，我成功了！");
		}
	}

	@Test
	public void testRange() {
		System.out.println("downTo:" + Range.downTo(4, BoundType.OPEN));
		System.out.println("upTo:" + Range.upTo(4, BoundType.CLOSED));
		System.out.println("range:" + Range.range(1, BoundType.CLOSED, 4, BoundType.OPEN));
	}

	@Test
	public void testContains() {
		// 判断指定数值是否包含于该范围
		BigDecimal i = BigDecimal.ONE;
		BigDecimal j = BigDecimal.TEN;
		systemPrint(i, i);
	}

	private void systemPrint(BigDecimal newParam, BigDecimal newParam2) {
		System.out.println(Range.closed(1, 3).contains(2));
		System.out.println(Range.closed(1, 3).contains(4));
		System.out.println(Range.lessThan(5).contains(5));
		System.out.println(Range.closed(1, 4).containsAll(Ints.asList(1, 2, 3)));
		System.out.println(Range.range(10, BoundType.OPEN, 15, BoundType.CLOSED).contains(10));
	}

	@Test
	public void testQuery() {
		System.out.println("hasLowerBound:" + Range.closedOpen(4, 4).hasLowerBound());
		System.out.println("hasUpperBound:" + Range.closedOpen(4, 4).hasUpperBound());
		// Range.closedOpen(4, 4).isEmpty()：范围(4,4)是否是空白的
		System.out.println(Range.closedOpen(4, 4).isEmpty());
		System.out.println(Range.openClosed(4, 4).isEmpty());
		System.out.println(Range.closed(4, 4).isEmpty());
		if (Range.closedOpen(4, 4).isEmpty()) {
			System.out.println("该范围是空白的");
		}
		// Range.open throws IllegalArgumentException
		// System.out.println(Range.open(4, 4).isEmpty());

		// 返回该范围指定的端值
		System.out.println(Range.closed(3, 10).lowerEndpoint());
		System.out.println(Range.open(3, 10).lowerEndpoint());
		System.out.println(Range.closed(3, 10).upperEndpoint());
		System.out.println(Range.open(3, 10).upperEndpoint());
		// 返回该范围指定的端值的范围状态(范围状态分为等于和不等于，例如1<x<=3)
		System.out.println(Range.closed(3, 10).lowerBoundType());
		System.out.println(Range.open(3, 10).upperBoundType());

	}

	@Test
	public void testEncloses() {
		Range<Integer> rangeBase = Range.open(1, 4);
		Range<Integer> rangeClose = Range.closed(2, 3);
		Range<Integer> rangeCloseOpen = Range.closedOpen(2, 4);
		Range<Integer> rangeCloseOther = Range.closedOpen(2, 5);
		// rangeBase.encloses(rangeClose)：rangeBase是否包含rangeClose
		System.out.println(
				"rangeBase: " + rangeBase + " Enclose:" + rangeBase.encloses(rangeClose) + " rangeClose:" + rangeClose);
		System.out.println("rangeBase: " + rangeBase + " Enclose:" + rangeBase.encloses(rangeCloseOpen) + " rangeClose:"
				+ rangeCloseOpen);
		System.out.println("rangeBase: " + rangeBase + " Enclose:" + rangeBase.encloses(rangeCloseOther)
				+ " rangeClose:" + rangeCloseOther);
	}

	@Test
	public void testConnected() {
		// 判断范围1和范围2是否可连接上。例如：(3,5)和[5,10]是可连接上的，(3,5)和(5,10)是不可连接上的
		System.out.println(Range.closed(3, 5).isConnected(Range.open(5, 10)));
		System.out.println(Range.closed(0, 9).isConnected(Range.closed(3, 4)));
		System.out.println(Range.closed(0, 5).isConnected(Range.closed(3, 9)));
		System.out.println(Range.open(3, 5).isConnected(Range.open(5, 10)));
		System.out.println(Range.closed(1, 5).isConnected(Range.closed(6, 10)));
	}

	@Test
	public void testIntersection() {
		// 如果两个range相连时，返回最大交集，如果不相连时，直接抛出异常
		System.out.println(Range.closed(3, 5).intersection(Range.open(5, 10)));
		System.out.println(Range.closed(0, 9).intersection(Range.closed(3, 4)));
		System.out.println(Range.closed(0, 5).intersection(Range.closed(3, 9)));
		System.out.println(Range.open(3, 5).intersection(Range.open(5, 10)));
		System.out.println(Range.closed(1, 5).intersection(Range.closed(6, 10)));
	}

	@Test
	public void testSpan() {
		// 获取两个range的并集，如果两个range是两连的，则是其最小range
		System.out.println(Range.closed(3, 5).span(Range.open(5, 10)));
		System.out.println(Range.closed(0, 9).span(Range.closed(3, 4)));
		System.out.println(Range.closed(0, 5).span(Range.closed(3, 9)));
		System.out.println(Range.open(3, 5).span(Range.open(5, 10)));
		System.out.println(Range.closed(1, 5).span(Range.closed(6, 10)));
		System.out.println(Range.closed(1, 5).span(Range.closed(7, 10)));
	}

	@After
	public void afterMethod() {
		System.out.println("=============结束==============");
	}

}
