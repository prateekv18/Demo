package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PrptStmt {
	private static void add() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydata", "root", "root");

		int id = 7;
		String fname = "Raj";
		String lname = "Malhotra";
		int salary = 25000;

		PreparedStatement ps = con.prepareStatement("INSERT INTO EMPDATA VALUES(?,?,?,?)");

		ps.setInt(1, id);
		ps.setString(2, fname);
		ps.setString(3, lname);
		ps.setInt(4, salary);

		ps.executeUpdate();

		ps.close();
		con.close();
	}

	private static void delete() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydata", "root", "root");

		int id = 2;

		PreparedStatement ps = con.prepareStatement("DELETE FROM EMPLOYEE WHERE ID = ?");

		ps.setInt(1, id);

		ps.executeUpdate();

		System.out.println("Record deleted");

		ps.close();
		con.close();
	}

	private static void select() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydata", "root", "root");

		// int id=4;

		PreparedStatement ps = con.prepareStatement("SELECT * FROM EMPDATA");

		// ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.print(rs.getString(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.println("\t" + rs.getString(4));
		}
		rs.close();
		ps.close();
		con.close();

	}

	private static void update() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydata", "root", "root");

		int id = 4;
		String fname = "Meena";
		String lname = "Singh";
		int salary = 22000;

		PreparedStatement ps = con.prepareStatement("UPDATE EMPDATA SET FNAME=?, LNAME=?, SALARY=? WHERE ID=?");

		ps.setString(1, fname);
		ps.setString(2, lname);
		ps.setInt(3, salary);
		ps.setInt(4, id);

		ps.executeUpdate();

		System.out.println("Record updated");
		ps.close();
		con.close();

	}

	public static void main(String args[]) throws Exception {
		// add();
		// update();
		// select();
		delete();
	}

}
