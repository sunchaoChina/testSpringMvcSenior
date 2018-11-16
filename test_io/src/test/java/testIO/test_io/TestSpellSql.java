package testIO.test_io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class TestSpellSql {

	@Test
	public void test_read_to_sql() {
		String readerPath = "C://Users//Administrator//Desktop//111//fjy20180516.txt";
		String writerPath = "C://Users//Administrator//Desktop//111//2222.sql";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(readerPath));
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(writerPath), true));
			String lineTxt = null;
			int number = 0;
			while ((lineTxt = reader.readLine()) != null) {
				String[] as = lineTxt.split("\\u007C");
				if (as[5].equals("BD")) {
					String newString = "insert into rd_local_code_mapping(mapping_type,orig_local_code,mapping_local_code) values('PLEDGE','"
							+ as[3] + "','" + as[1] + "')" + "\r" + "/";
					writer.write(newString);
					writer.newLine();
					number++;
				}
			}
			System.out.println(number);
			writer.flush();
			reader.close();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_String() {
		String a = "12312313.SZ";
		String b = a.split("\\.")[0];
		System.out.println(b);
	}

}
