package homework;

import java.sql.*;
import util.DBUtil;
/*
create or replace procedure emp_pro4(avgsal out number)
as
begin
select avg(sal)  into avgsal
from emp
where job in (select job from emp where ename='MARTIN' or ename='SMITH');
end;
*/
public class Homework14 {
	public static void main(String[] args) throws SQLException {
		Connection conn = DBUtil.getConnection();
		
		CallableStatement cs = conn.prepareCall("{call emp_pro4(?)}");
		cs.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
		cs.execute();
		double avgsal = cs.getDouble(1);
		System.out.println(avgsal);
		
		DBUtil.close();
	}
}




