package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class DBUtil {
	private static Connection conn;
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Properties pro = new Properties();
			pro.loadFromXML(new FileInputStream("src/db.xml"));
			String url = pro.getProperty("url");
			String name = pro.getProperty("name");
			String psd = pro.getProperty("password");
			conn = DriverManager.getConnection(url,name,psd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		return conn;
	}
	
	public static void close(){
		if(null!=conn){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
