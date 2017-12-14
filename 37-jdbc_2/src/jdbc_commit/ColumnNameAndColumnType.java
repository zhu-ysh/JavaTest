package jdbc_commit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import util.DBUtil;

public class ColumnNameAndColumnType {
	public static void main(String[] args) {
		try {
			Connection conn = DBUtil.getConnection();
			String tableName = "dept";
			Statement ps = conn.createStatement();
			ResultSet rs2 = ps.executeQuery("select * from "+tableName);
			ResultSetMetaData rsmd =  rs2.getMetaData();
			//����
			System.out.println(rsmd.getColumnCount());
			for (int i = 1; i <=rsmd.getColumnCount() ; i++) {
				System.out.print("����:"+rsmd.getColumnName(i)+"\t");
				System.out.print("oracle������:"+rsmd.getColumnTypeName(i)+"\t");
				System.out.println("java������:"+rsmd.getColumnClassName(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
