package homework;

import java.sql.*;
import util.DBUtil;
/*
create or replace procedure emp_pro3(gradeno in number,mycursor out sys_refcursor)
as
begin
       open mycursor  for 
select ename,dname,loc
from emp e,dept d,salgrade s
where e.deptno = d.deptno 
    and e.sal between s.losal and s.hisal
    and grade <> gradeno;
end;
*/
public class Homework13 {
	public static void main(String[] args) throws SQLException {
		Connection conn = DBUtil.getConnection();
		
		CallableStatement cs = conn.prepareCall("{call emp_pro3(?,?)}");
		cs.setInt(1, 1);
		cs.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
		cs.execute();
		ResultSet set  = (ResultSet) cs.getObject(2);
		while(set.next()){
			System.out.println(set.getString(1));
			System.out.println(set.getString(2));
			System.out.println(set.getString(3));
			System.out.println("=================");
		}
		DBUtil.close();
	}
}




