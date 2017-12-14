package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) throws IOException {
		//�������ļ�д���ļ��У���XML�ж���������Ϣ
	/*	Properties pro = new Properties();
		pro.put("url", "jdbc:oracle:thin:@localhost:1521:orcl");
		pro.put("name", "scott");
		pro.put("password", "123456");
		//д��XML��
		FileOutputStream fos = new FileOutputStream("src/db.xml");
		pro.storeToXML(fos, "oracle-jdbc");*/
		
		//�����ô�XML�ж�ȡ����
		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream("src/db.xml");
		pro.loadFromXML(fis);
		System.out.println(pro.getProperty("url"));
		System.out.println(pro.getProperty("name"));
		System.out.println(pro.getProperty("password"));
		
	}
}
