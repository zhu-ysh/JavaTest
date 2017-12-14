package jdbc_commit;

import java.sql.*;
import util.DBUtil;

public class JDBCTest1 {
	public static void main(String[] args) throws SQLException {
		Connection conn = DBUtil.getConnection();
		//关闭自动提交服务
		conn.setAutoCommit(false);
		Statement sta = conn.createStatement();
		try {
			sta.executeQuery("insert into copy_dept values(50,'a','a')");
			sta.executeQuery("insert into copy_dept values(60,'a','a')");
			sta.executeQuery("insert into copy_dept values(70,'a','a')");
			conn.commit();   //没失败则提交事务
		} catch (Exception e) {
			System.out.println("已回滚");
			conn.rollback();  //失败则回滚
		}
		
		DBUtil.close();
	}
}
