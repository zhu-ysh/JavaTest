package jdbc;
import java.sql.*;

public class JDBCTest2 {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String name = "scott";
		String password = "123456";
		Connection conn = DriverManager.getConnection(url,name,password);
		//3.通过连接创建一个操作数据库的句柄
		Statement sta = conn.createStatement();
		//4.通过句柄执行操作DML(增删改)
		//int rowCount = sta.executeUpdate("delete from copy_emp");
		//System.out.println(rowCount);
		
		//5.测试execute()什么都能执行，返回值boolean类型
		//ddl,dml->false  DQL->true
		boolean result = sta.execute("drop table t2");
		System.out.println(result);
		
		if(null!=conn){
			conn.close();
		}
	}
}
