package jdbc;

import java.sql.*;
import util.DBUtil;

public class JDBCTest4 {
	public static void main(String[] args) throws SQLException {
		Connection conn = DBUtil.getConnection();
		
		Statement s = conn.createStatement();
		ResultSet set = s.executeQuery("select * from emp");
		while(set.next()){
			System.out.println(set.getString(2));
		}
		DBUtil.close();
	}
}
