package jdbc;
import java.sql.*;
public class JDBCTest3 {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String name = "scott";
		String psd = "123456";
		Connection conn = DriverManager.getConnection(url,name,psd);
		Statement sta = conn.createStatement();
		//通过句柄查询 executeQuery()返回结果集
		//ResultSet set = sta.executeQuery("select * from emp");
		
		sta.execute("select * from emp");
		ResultSet set = sta.getResultSet(); //可以执行后再取结果集
	
		//遍历结果集
		while(set.next()){ //获取一行
			//可以使用第几列来取值，使用列名来取值
			System.out.print(set.getInt(1)+"\t");
			System.out.print(set.getDate(5)+"\t");
			System.out.println(set.getDouble(6));
		}
		if(null!=set){
			set.close();
		}
		if(null!=sta){
			sta.close();
		}
		if(null!=conn){
			conn.close();
		}
	}
}
