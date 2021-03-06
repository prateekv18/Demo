package JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class CallableStmt {
	public static void main(String[] args) throws Exception{
	Class.forName("com.mysql.jdbc.Driver");
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydata", "root", "root");
	
	CallableStatement cs = con.prepareCall("{CALL empCount(?)}");
	
	cs.registerOutParameter(1, Types.INTEGER);
	
	cs.execute();
	
	int cnt=cs.getInt(1);
	
	System.out.println("Employee count: "+cnt);
	}
}
