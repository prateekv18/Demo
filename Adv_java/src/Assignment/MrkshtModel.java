package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class MrkshtModel {

	public static int newPk() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydata", "root", "root");

		int pk = 0;

		PreparedStatement ps = con.prepareStatement("Select Max(Id) from marksheet");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}

		return pk + 1;
	}

	public static void add(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydata", "root", "root");

		con.setAutoCommit(false);

		int pk = newPk();
		PreparedStatement ps = con.prepareStatement("INSERT INTO MARKSHEET VALUES(?,?,?,?,?,?,?)");

		ps.setInt(1, pk);
		// ps.setInt(1, bean.getId());
		ps.setString(2, bean.getRollNo());
		ps.setString(3, bean.getFName());
		ps.setString(4, bean.getLname());
		ps.setInt(5, bean.getPhy());
		ps.setInt(6, bean.getChe());
		ps.setInt(7, bean.getMath());

		ps.executeUpdate();

		con.commit();

		System.out.println("Inserted successfully");

		ps.close();
		con.close();
	}

	public static void update(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydata", "root", "root");

		con.setAutoCommit(false);

		PreparedStatement ps = con.prepareStatement("UPDATE MARKSHEET SET PHY=?, CHE=?, MATH=? WHERE ID=?");

		ps.setInt(1, bean.getPhy());
		ps.setInt(2, bean.getChe());
		ps.setInt(3, bean.getMath());
		ps.setInt(4, bean.getId());

		ps.executeUpdate();

		con.commit();

		System.out.println("Updated successfully");

		ps.close();
		con.close();
	}

	public static void delete(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydata", "root", "root");

		con.setAutoCommit(false);

		PreparedStatement ps = con.prepareStatement("DELETE FROM MARKSHEET WHERE ID=?");

		ps.setInt(1, bean.getId());

		ps.executeUpdate();

		con.commit();

		System.out.println("Deleted successfully");

		ps.close();
		con.close();
	}

	public static void get(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydata", "root", "root");

		con.setAutoCommit(false);

		PreparedStatement ps = con.prepareStatement("SELECT * FROM MARKSHEET WHERE ID=?");

		ps.setInt(1, bean.getId());

		ResultSet rs = ps.executeQuery();

		con.commit();
		System.out.print("Id\tRollNo\tFName\tLName\tPhy\tChe\tMath");

		while (rs.next()) {
			System.out.print("\n" + rs.getString(1));

			System.out.print("\t" + rs.getString(2));

			System.out.print("\t" + rs.getString(3));

			System.out.print("\t" + rs.getString(4));

			System.out.print("\t" + rs.getString(5));

			System.out.print("\t" + rs.getString(6));

			System.out.println("\t" + rs.getString(7));
		}
		rs.close();

		ps.close();

		con.close();
	}

	public static void getMeritList() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydata", "root", "root");

		con.setAutoCommit(false);

		PreparedStatement ps = con.prepareStatement(
				"SELECT *, (PHY+CHE+MATH) AS TOTAL, ((PHY+CHE+MATH)/300)*100 AS PERCENTAGE FROM MARKSHEET WHERE PHY >40 AND CHE>40 AND MATH>40 ORDER BY PERCENTAGE DESC LIMIT 10");

		ResultSet rs = ps.executeQuery();

		con.commit();
		System.out.print("Id\tRollNo\tFName\tLName\tPhy\tChe\tMath\tTotal\tPercentage\n");

		while (rs.next()) {
			System.out.print(rs.getString(1));

			System.out.print("\t" + rs.getString(2));

			System.out.print("\t" + rs.getString(3));

			System.out.print("\t" + rs.getString(4));

			System.out.print("\t" + rs.getString(5));

			System.out.print("\t" + rs.getString(6));

			System.out.print("\t" + rs.getString(7));

			System.out.print("\t" + rs.getString(8));

			System.out.println("\t" + rs.getString(9));
		}
	}

	public static void search() throws Exception {
		ResourceBundle rb = ResourceBundle.getBundle("rb.app");
		
		Class.forName(rb.getString("driver"));

		Connection con = DriverManager.getConnection(rb.getString("url"),rb.getString("username"), rb.getString("pwd"));

		con.setAutoCommit(false);

		PreparedStatement ps = con.prepareStatement("SELECT * FROM MARKSHEET");

		// ps.setInt(1, bean.getId());

		ResultSet rs = ps.executeQuery();

		con.commit();

		System.out.print("Id\tRollNo\tFName\tLName\tPhy\tChe\tMath\n");

		while (rs.next()) {
			System.out.print(rs.getString(1));

			System.out.print("\t" + rs.getString(2));

			System.out.print("\t" + rs.getString(3));

			System.out.print("\t" + rs.getString(4));

			System.out.print("\t" + rs.getString(5));

			System.out.print("\t" + rs.getString(6));

			System.out.println("\t" + rs.getString(7));

		}

	}
}