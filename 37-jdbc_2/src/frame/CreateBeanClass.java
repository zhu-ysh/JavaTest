package frame;

import java.io.*;
import java.lang.reflect.*;
import java.sql.*;
import java.util.*;
import org.dom4j.*;
import org.dom4j.io.*;

import util.DBUtil;
import util.MyDataSource;

public class CreateBeanClass{
	//解析xml创建一个mydateSource对象并创建连接
	public static Connection saxXML(File file) throws Exception{
		//读取文件，创建对象，映射到实际对象
		try {
			SAXReader sax = new SAXReader();
			Document doc = sax.read(new FileInputStream(file));
			Element root = doc.getRootElement();
			List<Element> firEles =  root.elements();
			for (Element element : firEles) {
				Class nodeClass = Class.forName(element.attributeValue("class"));
				Object obj = nodeClass.newInstance();
				List<Element> secEles = element.elements();
				for (Element element2 : secEles) {
					String proName = element2.attributeValue("name");
					String proValue = element2.attributeValue("value");
					
					String methodName = "set"+(proName.charAt(0)+"").toUpperCase()+proName.substring(1);
					Method method = nodeClass.getMethod(methodName,String.class);
					method.invoke(obj, proValue);
				}
				
				MyDataSource mds = (MyDataSource)obj;
				Class.forName(mds.getDriver());
				Connection conn = DriverManager.
						getConnection(mds.getUrl(),mds.getName(),mds.getPassword());
				return conn;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	//通过创建的连接反射到该用户的所有表，通过所有的表得到类
	public static void createBeans() throws Exception{
		Connection conn = saxXML(new File("src/sql.xml"));
		Statement sta = conn.createStatement();
		ResultSet rs = sta.executeQuery("select tname from tab where tabtype='TABLE'");
		while(rs.next()){
			String tableName = rs.getString(1);
			
			Statement ps = conn.createStatement();
			ResultSet rs2 = ps.executeQuery("select * from "+tableName);
			ResultSetMetaData rsmd =  rs2.getMetaData();
			
			
			
			File newFile = new File("src/beans",tableName+".java");
			if(!newFile.exists()){
				newFile.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(newFile);
			fos.write("package beans;\n".getBytes());
			fos.write(("public class "+tableName+"\n").getBytes());
			fos.write("{\n".getBytes());
			for (int i = 1; i <=rsmd.getColumnCount() ; i++) {
				fos.write(("\tprivate "+rsmd.getColumnClassName(i)+" "+rsmd.getColumnName(i).toLowerCase()+";\n").getBytes());
			}
			//生成get,set方法
			for (int i = 1; i <=rsmd.getColumnCount() ; i++) {
				String columnName = rsmd.getColumnName(i).toLowerCase();
				String setMethodName = "set"+(columnName.charAt(0)+"").toUpperCase()+columnName.substring(1).toLowerCase();
				String getMethodName = "get"+(columnName.charAt(0)+"").toUpperCase()+columnName.substring(1).toLowerCase();
				fos.write(("\tpublic void "+setMethodName+"("+rsmd.getColumnClassName(i)+" "+columnName.toLowerCase()+")\n").getBytes());
				fos.write("\t{\n".getBytes());
				fos.write(("\t\tthis."+columnName+" = "+columnName+";\n").getBytes());
				fos.write("\t}\n".getBytes());
				fos.write(("\tpublic "+rsmd.getColumnClassName(i)+" "+getMethodName+"()\n").getBytes());
				fos.write("\t{\n".getBytes());
				fos.write(("\t\treturn this."+columnName+";\n").getBytes());
				fos.write("\t}\n".getBytes());
			}
			
			
			fos.write("}".getBytes());
			fos.flush();
			fos.close();
		}
		conn.close();
	}
	
	public static void main(String[] args) throws Exception {
		createBeans();
		
	}
}
