package jdbc;

import java.sql.*;

public class JDBCTest1 {
	public static void main(String[] args) throws Exception {
		//1.����������
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2.�õ�����(url,username,password);
		String url = "jdbc:oracle:thin:@192.168.199.190:1521:orcl";
		String username = "scott";
		String password = "123456";
		Connection conn = DriverManager.getConnection(url,username,password);
		if(null != conn){
			System.out.println("���ݿ�������");
		}else{
			System.out.println("���ݿ�δ����");
		}
		//3.�ر�����
		if(null!=conn){
			conn.close();
		}
	}
}
