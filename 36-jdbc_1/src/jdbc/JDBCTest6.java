package jdbc;

import java.sql.*;
import util.DBUtil;

public class JDBCTest6 {
	public static void main(String[] args) throws SQLException {
		Connection conn = DBUtil.getConnection();
		
		Statement sta = conn.createStatement();
		
		ResultSet rs = sta.executeQuery("select * from emp");
		
		ResultSetMetaData rsmd = rs.getMetaData();
		
		//�õ�����
		int column = rsmd.getColumnCount();
		
		for (int i = 1; i <= column; i++) {
			System.out.print("oracle����:"+rsmd.getColumnType(i)+"\t");
			System.out.print("oracle����:"+rsmd.getColumnTypeName(i)+"\t");
			System.out.print("JAVA����:"+rsmd.getColumnClassName(i)+"\t");
			System.out.print("JAVA����:"+rsmd.getColumnName(i)+"\t");
			System.out.println();
			
		}
	}
}
