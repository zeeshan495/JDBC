package jdbc;
import java.sql.*;
import java.util.Scanner;
import utility.Utility;
public class Update {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
			Scanner scan=new Scanner(System.in);
			String sql="";
			int id=0,age=0;
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
		    System.out.println("enter id of employee to edit");
		    int empID=scan.nextInt();
		    System.out.println("select choice to edit : \n"+
		    " 1-id \n"+" 2-age \n");
		    int choice=scan.nextInt();
		    switch(choice)
		    {
		    case 1:System.out.println("enter new id");
		    id=scan.nextInt();
		    sql = "UPDATE employees SET id = "+id+" WHERE id in ("+empID+")";
		    break;
		    case 2:System.out.println("enter new age");
		    age=scan.nextInt();
		    sql = "UPDATE employees SET age = "+age+" WHERE id in ("+empID+")";
		    break;
		    }	    
		    stmt.executeUpdate(sql);
		    sql = "select * from employees";
		    ResultSet rs2=stmt.executeQuery(sql);
		    System.out.println("after updating");
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
