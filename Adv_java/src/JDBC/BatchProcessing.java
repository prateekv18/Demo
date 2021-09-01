package JDBC;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.Statement;

	public class BatchProcessing {
		private static void add() throws Exception{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/companydata","root","root");
			
			con.setAutoCommit(false);

			Statement stmt=con.createStatement();
			
			stmt.addBatch("INSERT INTO EMPLOYEE VALUES (1, 'Amaiy', 'Mathur', 19000)");
			stmt.addBatch("INSERT INTO EMPLOYEE VALUES(3, 'Mayank', 'Pawar', 21000)");
			stmt.addBatch("INSERT INTO EMPLOYEE VALUES(5, 'Shanaya', 'Mehra', 24000)");
			
			stmt.executeBatch();

			con.commit();
			
			System.out.println("Inserted");
			
			stmt.close();
			con.close();
		}
		
		public static void main(String[] args) throws Exception{
			//add();
			delete();
		}

		private static void delete() throws Exception {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/companydata",	"root", "root");
			
			conn.setAutoCommit(false);
			
			Statement stmt= conn.createStatement();
			
			stmt.addBatch("DELETE FROM MARKSHEET WHERE ID=13");
			stmt.addBatch("DELETE FROM MARKSHEET WHERE ID=14");
			stmt.addBatch("DELETE FROM MARKSHEET WHERE ID=15");
			stmt.addBatch("DELETE FROM MARKSHEET WHERE ID=16");
			stmt.addBatch("DELETE FROM MARKSHEET WHERE ID=17");
			stmt.addBatch("DELETE FROM MARKSHEET WHERE ID=18");
			stmt.addBatch("DELETE FROM MARKSHEET WHERE ID=19");
			stmt.addBatch("DELETE FROM MARKSHEET WHERE ID=20");
			stmt.addBatch("DELETE FROM MARKSHEET WHERE ID=21");
			stmt.addBatch("DELETE FROM MARKSHEET WHERE ID=22");
			
			stmt.executeBatch();
			
			conn.commit();
			
			System.out.println("Deleted");
			
			stmt.close();
			
			conn.close();
		}

		
	}

