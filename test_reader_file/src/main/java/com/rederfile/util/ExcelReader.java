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

public class ExcelReader {

	/**
	 * 获取excel内容，其中第一层list为sheet，第二层为每个sheet里具体内容
	 * 
	 * @param path
	 * @return
	 */
	public static List<List<String[]>> getExcelReult(String path) {
		Workbook workbook = null;
		List<List<String[]>> singleSheetResult = new ArrayList<List<String[]>>();
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(new File(path));
			workbook = WorkbookFactory.create(fileInputStream);
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				// 获取excel的一个sheet页
				Sheet sheet = workbook.getSheetAt(i);
				List<String[]> rowList = getSingleSheetResult(sheet);
				if (rowList == null) {
					continue;
				}
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
	 * 
	 * @param sheet
	 * @return
	 */
	@SuppressWarnings({ "deprecation", "static-access" })
	public static List<String[]> getSingleSheetResult(Sheet sheet) {
		List<String[]> rowList = new ArrayList<String[]>();
		// 获取该sheet页总行数
		int rows = sheet.getPhysicalNumberOfRows();
		if (rows == 0) {
			return null;
		}
		// 获取该sheet页总列数
		for (int i = 1; i < rows; i++) {
			Row row = sheet.getRow(i);
			List<String> cellList = new ArrayList<String>();
			for (int j = 0; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				if (cell != null) {
					int cellType = cell.getCellType();
					if (cellType == cell.CELL_TYPE_FORMULA) {
						cellList.add(cell.getCellFormula());
					} else if (cellType == cell.CELL_TYPE_NUMERIC) {
						cellList.add(((Double) cell.getNumericCellValue()).toString());
					} else if (cellType == cell.CELL_TYPE_STRING) {
						cellList.add(cell.getStringCellValue().trim());
					}
				} else {
					cellList.add("");
				}
			}
			rowList.add(cellList.toArray(new String[cellList.size()]));
		}
		return rowList;
	}
}
