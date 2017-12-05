package com.rederfile.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelReader {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ExcelReader.class);

	public List<List<String[]>> getExcelReult(String path) {
		Workbook workbook = null;
		List<List<String[]>> singleSheetResult = new ArrayList<List<String[]>>();
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(new File(path));
			workbook = WorkbookFactory.create(fileInputStream);
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				//获取excel的一个sheet页
				Sheet sheet = workbook.getSheetAt(i);
				List<String[]> rowList = getSingleSheetResult(sheet);
				singleSheetResult.add(rowList);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (workbook != null) {
				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return singleSheetResult;
	}
	/**
	 * 获取当前sheet页中的一行数据
	 * @param sheet
	 * @return
	 */
	private List<String[]> getSingleSheetResult(Sheet sheet) {
		List<String[]> rowList = new ArrayList<String[]>();
		// 获取该sheet页总行数
		int rows = sheet.getPhysicalNumberOfRows();
		// 获取该sheet页总列数
		int cellNum = sheet.getRow(0).getPhysicalNumberOfCells();
		for (int i = 1; i < rows; i++) {
			Row row = sheet.getRow(i);
			List<String> cellList = new ArrayList<String>();
			for (int j = 0; j < cellNum; j++) {
				Cell cell = row.getCell(j);
				if (cell != null) {
					cellList.add(cell.getCellFormula());
				} else {
					cellList.add("");
				}
			}
			rowList.add(cellList.toArray(new String[cellList.size()]));
		}
		return rowList;
	}
}
