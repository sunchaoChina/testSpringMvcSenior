package com.rederfile.util;

import org.junit.Test;

/**
 * @author Administrator
 *
 */
public class ExcelOutputTest {

	@Test
	public void testOutHengPaiExcel() {
		String[] headNames = { "证券编号", "证券名称", "证券价格" };
		String path = "readerFile/excel/securities_heng_out.xls";
		ExcelOutput.outHengExcel(path, headNames);
	}

	@Test
	public void testOutShuPaiExcel() {
		String[] headNames = { "证券编号", "证券名称", "证券价格" };
		String path = "readerFile/excel/securities_shu_out.xls";
		ExcelOutput.outShuExcel(path, headNames);
	}
}
