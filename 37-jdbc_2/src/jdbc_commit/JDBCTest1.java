package jdbc_commit;

import java.sql.*;
import util.DBUtil;

public class JDBCTest1 {
	public static void main(String[] args) throws SQLException {
		Connection conn = DBUtil.getConnection();
		//�ر��Զ��ύ����
		conn.setAutoCommit(false);
		Statement sta = conn.createStatement();
		try {
			sta.executeQuery("insert into copy_dept values(50,'a','a')");
			sta.executeQuery("insert into copy_dept values(60,'a','a')");
			sta.executeQuery("insert into copy_dept values(70,'a','a')");
			conn.commit();   //ûʧ�����ύ����
		} catch (Exception e) {
			System.out.println("�ѻع�");
			conn.rollback();  //ʧ����ع�
		}
		
		DBUtil.close();
	}
}
