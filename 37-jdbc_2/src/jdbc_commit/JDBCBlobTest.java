package jdbc_commit;

import java.io.*;
import java.sql.*;
import util.DBUtil;

public class JDBCBlobTest {
	public static void main(String[] args) throws Exception{
		Connection conn = DBUtil.getConnection();
/*		PreparedStatement sta = conn.
				prepareStatement("insert into video values(1,?)");
		FileInputStream fis = new FileInputStream("src/南海姑娘.mp3");
		sta.setBlob(1, fis);
		sta.execute();*/
		
		Statement sta = conn.createStatement();
		ResultSet rs = sta.
				executeQuery("select vid from video where id=1");
		if(rs.next()){
			InputStream is = rs.getBinaryStream(1);
			FileOutputStream fos = 
					new FileOutputStream("src/南海姑娘2.mp3");
			int ch;
			while((ch = is.read())!= -1){
				fos.write(ch);
			}
			fos.flush();
			fos.close();
			is.close();
		}
	
	}
}
