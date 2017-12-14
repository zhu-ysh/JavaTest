package jdbc;

import java.sql.*;

public class JDBCTest1 {
	public static void main(String[] args) throws Exception {
		//1.加载驱动类
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2.得到连接(url,username,password);
		String url = "jdbc:oracle:thin:@192.168.199.190:1521:orcl";
		String username = "scott";
		String password = "123456";
		Connection conn = DriverManager.getConnection(url,username,password);
		if(null != conn){
			System.out.println("数据库已连接");
		}else{
			System.out.println("数据库未连接");
		}
		//3.关闭连接
		if(null!=conn){
			conn.close();
		}
	}
}
