package jdbc;
import java.sql.*;
import java.sql.Statement;
import utility.Utility;
public class Create {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
			java.sql.Connection conn = null;
			Statement stmt = null;
			System.out.println("Connecting to database...");
			conn=Utility.getConnection();
			System.out.println("Creating database...");
		    stmt = conn.createStatement();
		    String sql = "CREATE DATABASE EMPLOYEES";
		    stmt.executeUpdate(sql);
		    System.out.println("Database created successfully...");
		    stmt.close();
		    conn.close();
		   
	}

}
