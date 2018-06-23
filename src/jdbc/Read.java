/******************************************************************************
 *  Purpose:	Read operation of Database
 *
 *  @author  Zeeshan
 *  @version 1.0
 *  @since   23-06-2018
 *
 ******************************************************************************/
package jdbc;
import java.sql.*;
import utility.Utility;
public class Read {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
			java.sql.Connection conn = null;
			Statement stmt = null;
			System.out.println("Connecting to database...");
			conn=Utility.getConnection();
		    stmt = conn.createStatement();
		    String sql = "select * from employees";
		    ResultSet rs=stmt.executeQuery(sql);	
		    System.out.println("\tID\tname\t\tage");
		    System.out.println("\t-----------------------------");
			while(rs.next())
			{
			String employees="\t"+rs.getInt("id")+"\t"+rs.getString("ename")+"\t\t"+rs.getInt("age");
			System.out.println(employees);
			}
		    stmt.close();
		    conn.close();
		   
	}

}
