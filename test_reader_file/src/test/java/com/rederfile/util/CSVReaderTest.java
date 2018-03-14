package com.rederfile.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

	@Test
	public void testOutPut() {
		try {
			DateFormat format = new SimpleDateFormat("yyyyMMdd");
			Date date = format.parse("20130427");
			File f = new File("D:/test.txt");
			f.createNewFile();
			f.setLastModified(date.getTime());
			System.out.println(new Date(f.lastModified()));
			File f1 = new File("D:/test.txt");
			System.out.println(new Date(f1.lastModified()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testFilter() {
		File[] files = new File("D:/test11").listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				System.out.println("路径：" + dir + " " + "文件名：" + name);
				if (name.startsWith("COAC_STOCK_")) {
					return true;
				}
				return false;
			}
		});
		for (File f : files) {
			System.out.println(f);
		}

	}

	@Test
	public void testDate() {
		Long l = 1366905600000L;
		System.out.println(new Date(l));
		Date d = new Date();
		System.out.println(d);
		Calendar instance = Calendar.getInstance();
		instance.setTime(d);
		instance.add(Calendar.HOUR_OF_DAY, 1);
		System.out.println(instance.getTime());
	}

	@Test
	public void testBig() {
		BigDecimal a = new BigDecimal(123.2346);
		BigDecimal b = new BigDecimal(234.34576);
		System.out.println(a.divide(b, 0, RoundingMode.DOWN));
	}

}
