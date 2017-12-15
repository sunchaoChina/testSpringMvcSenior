package com.rederfile.util;

import org.junit.Test;

/**
 * @author Administrator
 *
 */
public class ExcelOutputTest {

	@Test
	public void testOutPutExcel() {
		String[] headNames = { "证券编号", "证券名称", "证券价格" };
		String path = "readerFile/excel/securities_out.xls";
		ExcelOutput.outPutExcel(path, headNames);
	}

}
