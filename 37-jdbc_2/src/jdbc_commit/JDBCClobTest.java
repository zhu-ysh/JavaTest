package jdbc_commit;

import java.io.*;
import java.sql.*;
import util.DBUtil;

public class JDBCClobTest {
	public static void main(String[] args) throws Exception {
	/*	
		//1.从文件中读取到字符串中
		FileInputStream fis = new FileInputStream("src/哈利波特.txt");
		byte [] content = new byte[fis.available()];
		fis.read(content);
		String cont = new String(content);
		//2.创建StringReader
		StringReader sr = new StringReader(cont);
		//3.操作数据库，把sr插入到
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement("insert into book values(1,?)");
		//4.设置clob对象
		ps.setCharacterStream(1, sr);
		ps.execute();
		//5.关闭
		DBUtil.close();
		
*/
		Connection conn = DBUtil.getConnection();
		Statement state = conn.createStatement();
		ResultSet set = state.executeQuery("select content from book where id=1");
		if(set.next()){
			Clob clob = set.getClob(1);
			Reader reader = clob.getCharacterStream();
			BufferedReader br = new BufferedReader(reader);
			FileOutputStream fos = new FileOutputStream("src/哈利波特2.txt");
			String str;
			while((str = br.readLine())!=null){
				fos.write(str.getBytes());
				fos.write("\r\n".getBytes());
			}
			fos.flush();
			fos.close();
		}
	}
}
