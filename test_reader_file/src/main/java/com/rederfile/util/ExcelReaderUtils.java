package com.rederfile.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.rederfile.annotation.CellOrder;

public class ExcelReaderUtils {
	public <T> List<T> getExcelResult(String path, Class<T> cls) {
		List<T> singleSheetResult = new ArrayList<T>();
		FileInputStream fileInputStream = null;
		try {
			Map<Integer, String> fieldMap = new HashMap<Integer, String>();
			Field[] fields = cls.getDeclaredFields();
			AccessibleObject.setAccessible(fields, true);
			for (Field field : fields) {
				CellOrder cellOrder = field.getAnnotation(CellOrder.class);
				if (cellOrder != null) {
					int order = cellOrder.order();
					fieldMap.put(order, field.getName());
				}
			}
			fileInputStream = new FileInputStream(new File(path));
			Workbook workbook = WorkbookFactory.create(fileInputStream);
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				Sheet sheet = workbook.getSheetAt(i);
				List<T> rowList = getSingleSheetResult(sheet, cls, fieldMap);
				singleSheetResult.addAll(rowList);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return singleSheetResult;
	}

	@SuppressWarnings({ "static-access", "deprecation" })
	private <T> List<T> getSingleSheetResult(Sheet sheet, Class<T> cls, Map<Integer, String> fieldMap)
			throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException,
			IllegalArgumentException, ParseException {
		List<T> rowList = new ArrayList<>();
		int rows = sheet.getPhysicalNumberOfRows();
		for (int j = 1; j < rows; j++) {
			Row headrow = sheet.getRow(0);
			int cellsNum = headrow.getPhysicalNumberOfCells();
			Row row = sheet.getRow(j);
			if (row == null) {
				continue;
			}
			T t = cls.newInstance();
			for (int k = 0; k < cellsNum; k++) {
				String name = fieldMap.get(k);
				if (name == null) {
					continue;
				}
				Field field = cls.getDeclaredField(name);
				field.setAccessible(true);
				Cell cell = row.getCell(k);
				Object value = null;
				if (cell != null) {
					if (cell.getCellType() == cell.CELL_TYPE_FORMULA) {
						value = cell.getCellFormula();
					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
						value = cell.getNumericCellValue();
					} else if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						value = cell.getStringCellValue();
					}
				}
				setFieldValue(t, field, value);
			}
			rowList.add(t);
		}
		return rowList;
	}

	private void setFieldValue(Object instance, Field field, Object value)
			throws IllegalArgumentException, IllegalAccessException, ParseException {
		String fieldType = field.getType().toString();
		switch (fieldType) {
		case "class java.lang.String":
			field.set(instance, value);
			break;
		case "class java.lang.BigDecimal":
			field.set(instance, new BigDecimal(value.toString()));
			break;
		case "class java.lang.Boolean":
			field.set(instance, Boolean.valueOf(value.toString()));
			break;

		case "class java.util.Date":
			if (value instanceof Date) {
				field.set(instance, value);
			} else if (value instanceof String) {
				field.set(instance, getDateTimeByString((String) value, "yyyy-MM-dd"));
			}
			break;
		case "class java.util.Double":
		case "double":
			field.set(instance, new Double(value.toString()));
			break;
		}
	}

	public static Date getDateTimeByString(String date, String format) throws ParseException {
		String d_format = "yyyy-MM-dd";
		if (format != null) {
			d_format = format;
		}
		SimpleDateFormat spFormat = new SimpleDateFormat(d_format);
		return spFormat.parse(date);
	}
}
