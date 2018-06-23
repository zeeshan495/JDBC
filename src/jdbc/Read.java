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
			while(rs.next())
			{
			String employees=rs.getInt("id")+" : "+rs.getString("ename")+" : "+rs.getInt("age");
			System.out.println(employees);
			}
		    stmt.close();
		    conn.close();
		   
	}

}
