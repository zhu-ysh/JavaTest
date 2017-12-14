package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) throws IOException {
		//把配置文件写到文件中，从XML中读出配置信息
	/*	Properties pro = new Properties();
		pro.put("url", "jdbc:oracle:thin:@localhost:1521:orcl");
		pro.put("name", "scott");
		pro.put("password", "123456");
		//写到XML里
		FileOutputStream fos = new FileOutputStream("src/db.xml");
		pro.storeToXML(fos, "oracle-jdbc");*/
		
		//把配置从XML中读取出来
		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream("src/db.xml");
		pro.loadFromXML(fis);
		System.out.println(pro.getProperty("url"));
		System.out.println(pro.getProperty("name"));
		System.out.println(pro.getProperty("password"));
		
	}
}
