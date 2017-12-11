package com.rederfile.util;

import java.util.List;

import org.junit.Test;

public class TxtReaderTest {

	@Test
	public void testReadTxtFile() {
		List<String> results = TxtReader.readTxtFile("readerFile/txt/securities.txt");
		for (int i = 0; i < results.size(); i++) {
			String[] securitys = results.get(i).split("\\|");
			System.out.println("券id：" + securitys[0] + " 券名称：" + securitys[1] + " 券价格：" + securitys[2]);
		}
	}

}
