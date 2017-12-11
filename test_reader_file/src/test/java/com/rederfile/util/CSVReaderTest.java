package com.rederfile.util;

import java.util.List;

import org.junit.Test;

public class CSVReaderTest {

	@Test
	public void testReadCSVFile() {
		List<String> results = CSVReader.readCSVFile("readerFile/csv/securities.csv");
		for (int i = 1; i < results.size(); i++) {
			String[] securitys = results.get(i).split(",");
			System.out.println("券id：" + securitys[0] + " 券名称：" + securitys[1] + " 券价格：" + securitys[2]);
		}
	}

}
