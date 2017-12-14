package jdbc;
import java.sql.*;
import util.DBUtil;

public class JDBCTest5 {
	public static void main(String[] args) throws SQLException {
		Connection conn = DBUtil.getConnection();
		//1.简单的句柄
	/*	Statement sta = conn.createStatement();
		int deptno = 50;
		String dname = "abc";
		String loc = "dalian";
		int row =sta.executeUpdate("insert into dept values("+deptno+",'"+dname+"','"+loc+"')");
		System.out.println(row);*/
		
		//2.预处理句柄
	/*	PreparedStatement ps = conn.
				prepareStatement("insert into dept values(?,?,?)");
		ps.setInt(1, 60);
		ps.setString(2, "def");
		ps.setString(3, "shenyang");
		int row = ps.executeUpdate();
		System.out.println(row);*/
	
		/*
create or replace procedure emp_pro1(no in number,mycur out sys_refcursor)
as
begin
  open mycur for select * from emp where deptno = no;
end;
		 */
		
/*		//3.调用存储过程句柄,也是预处理句柄
		CallableStatement cs = conn.prepareCall("{call emp_pro1(?,?)}");
		//in类型使用setXXX(第几个问号,值);
		cs.setInt(1, 30);
		//out类型只需要注册!!!
		cs.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
		//执行
		cs.execute();
		//取出游标
		ResultSet set = (ResultSet) cs.getObject(2);
		while(set.next()){
			System.out.println(set.getString(2));
		}*/
		
		CallableStatement cs2 = conn.prepareCall("{call emp_pro2(?,?)}");
		cs2.registerOutParameter(1, oracle.jdbc.OracleTypes.VARCHAR);
		cs2.registerOutParameter(2, oracle.jdbc.OracleTypes.INTEGER);
		cs2.execute();
		
		System.out.println(cs2.getString(1));
		System.out.println(cs2.getInt(2));

	}
}
