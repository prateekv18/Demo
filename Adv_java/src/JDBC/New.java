package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class New {
	public static void main(String[] args) throws Exception {
		 select();
		// add();
//		 update();
//		 delete();
	}

	private static void select() throws Exception {

		ResourceBundle rb = ResourceBundle.getBundle("rb.app");
		
		Class.forName(rb.getString("driver"));
		
		Connection con = DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("pwd"));

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("Select * from empdata");
		System.out.println("ID\tFname\tLname\tSalary");

		while (rs.next()) {
			System.out.print(rs.getString(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.println("\t" + rs.getString(4));
		}
		rs.close();
		stmt.close();
		con.close();
	}

	private static void add() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydata", "root", "root");
		
		con.setAutoCommit(false);
		
		Statement stmt = con.createStatement();

		int i = stmt.executeUpdate("Insert into empdata values(8,'Rahul','Agrawal',25000)");
		stmt.executeUpdate("Insert into empdata values(9,'Suresh','Rathore',22000)");
		stmt.executeUpdate("Insert into empdata values(10,'Rahul','Agrawal',25000)");
		stmt.executeUpdate("Insert into empdata values(11,'Rahul','Agrawal',25000)");
		
		con.commit();
		
		System.out.println(i + " Inserted");

		stmt.close();
		con.close();
	}

	private static void update() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydata", "root", "root");

		Statement stmt = con.createStatement();

		int i = stmt.executeUpdate("Update empdata set fname='Raju', lname='Vyas', Salary= 25000 where id=4");
		System.out.println(i + " Updated");

		stmt.close();
		con.close();
	}

	private static void delete() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydata", "root", "root");

		Statement stmt = con.createStatement();

		int i = stmt.executeUpdate("Delete from empdata where id=7");
		System.out.println(i + " deleted");

		stmt.close();
		con.close();
	}
}

