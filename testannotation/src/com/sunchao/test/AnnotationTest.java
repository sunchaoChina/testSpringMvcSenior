package com.sunchao.test;

import com.sunchao.annotationhand.FruitInfoUtil;
import com.sunchao.vo.Apple;

public class AnnotationTest {

	public static void main(String[] args) {
		FruitInfoUtil.getFruitInfo(Apple.class);
	}

}
