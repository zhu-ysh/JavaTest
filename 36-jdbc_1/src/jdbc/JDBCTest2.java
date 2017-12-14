package jdbc;
import java.sql.*;

public class JDBCTest2 {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String name = "scott";
		String password = "123456";
		Connection conn = DriverManager.getConnection(url,name,password);
		//3.ͨ�����Ӵ���һ���������ݿ�ľ��
		Statement sta = conn.createStatement();
		//4.ͨ�����ִ�в���DML(��ɾ��)
		//int rowCount = sta.executeUpdate("delete from copy_emp");
		//System.out.println(rowCount);
		
		//5.����execute()ʲô����ִ�У�����ֵboolean����
		//ddl,dml->false  DQL->true
		boolean result = sta.execute("drop table t2");
		System.out.println(result);
		
		if(null!=conn){
			conn.close();
		}
	}
}
