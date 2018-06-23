/******************************************************************************
 *  Purpose:	create operation of Database
 *
 *  @author  Zeeshan
 *  @version 1.0
 *  @since   23-06-2018
 *
 ******************************************************************************/
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
		    System.out.println("Enter the name of database");
		    String dbName=Utility.inputString();
		    String sql = "CREATE DATABASE"+dbName;
		    stmt.executeUpdate(sql);
		    System.out.println("Database created successfully...");
		    stmt.close();
		    conn.close();
		   
	}

}
