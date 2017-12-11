package com.rederfile.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TxtReader {

	/**
	 * 解析txt文件
	 * 
	 * @param txtFilePath
	 * @return
	 */
	public static List<String> readTxtFile(String txtFilePath) {
		List<String> results = new ArrayList<String>();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(txtFilePath),"GBK"));
			String lineTxt = null;
			while ((lineTxt = bufferedReader.readLine()) != null) {
				results.add(lineTxt);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return results;
	}
}
