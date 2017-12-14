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
		//ͨ�������ѯ executeQuery()���ؽ����
		//ResultSet set = sta.executeQuery("select * from emp");
		
		sta.execute("select * from emp");
		ResultSet set = sta.getResultSet(); //����ִ�к���ȡ�����
	
		//���������
		while(set.next()){ //��ȡһ��
			//����ʹ�õڼ�����ȡֵ��ʹ��������ȡֵ
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
