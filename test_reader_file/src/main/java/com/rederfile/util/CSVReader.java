package com.rederfile.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	
	/**
	 * 解析CSV文件
	 * @param csvPath
	 * @return
	 */
	public static List<String> readCSVFile(String csvPath) {
		BufferedReader reader = null;
		List<String> results = new ArrayList<String>();
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(csvPath), "GBK"));
			String lineStr = null;
			while ((lineStr = reader.readLine()) != null) {
				results.add(lineStr);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return results;
	}
}
