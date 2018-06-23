package jdbc;
import java.sql.*;
import java.util.Scanner;
import utility.Utility;
public class Delete {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
			Scanner scan=new Scanner(System.in);
			String sql="";
			java.sql.Connection conn = null;
			Statement stmt = null;
			System.out.println("Connecting to database...");
			conn=Utility.getConnection();
		    stmt = conn.createStatement();
		    sql = "select * from employees";
		    ResultSet rs=stmt.executeQuery(sql);	   
			while(rs.next())
			{
			String employees=rs.getInt("id")+" : "+rs.getString("ename")+" : "+rs.getInt("age");
			System.out.println(employees);
			}
		    System.out.println("enter id of employee to delete");
		    int empID=scan.nextInt();
		    	
		    sql = "delete from employees where id ="+ empID;
		    stmt.executeUpdate(sql);
		    sql = "select * from employees";
		    ResultSet rs2=stmt.executeQuery(sql);	
		    System.out.println("after deleting : \n");
			while(rs2.next())
			{
			String employees=rs2.getInt("id")+" : "+rs2.getString("ename")+" : "+rs2.getInt("age");
			System.out.println(employees);
			}

		    stmt.close();
		    conn.close();
		    scan.close();
		   
	}

}
