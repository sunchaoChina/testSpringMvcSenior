package com.rederfile.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelOutput {
	/**
	 * 生成excel模板
	 * 
	 * @param path
	 * @param headNames
	 */
	public static void outHengExcel(String path, String[] headNames) {
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("sheet1");
		Row row0 = sheet.createRow(0);
		for (int i = 0; i < headNames.length; i++) {
			Cell cell = row0.createCell(i, CellType.STRING);
			cell.setCellValue(headNames[i]);
		}
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(new File(path));
			workbook.write(outputStream);
			outputStream.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
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
	}

	/**
	 * 生成excel模板
	 * 
	 * @param path
	 * @param headNames
	 */
	public static void outShuExcel(String path, String[] headNames) {
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("sheet1");
		for (int i = 0; i < headNames.length; i++) {
			Row row0 = sheet.createRow(i);
			Cell cell = row0.createCell(0, CellType.STRING);
			cell.setCellValue(headNames[i]);
		}
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(new File(path));
			workbook.write(outputStream);
			outputStream.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
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
	}
}
