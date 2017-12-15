package com.rederfile.util;

import java.util.List;

import org.junit.Test;

public class ExcelReaderTest {

	@Test
	public void test() {
		List<List<String[]>> results = ExcelReader.getExcelReult("readerFile/excel/securities.xls");
		for (List<String[]> result : results) {
			for (String[] line : result) {
				System.out.println("券id：" + line[0] + " 券名称：" + line[1] + " 券价格：" + line[2]);
			}
		}
	}

}
