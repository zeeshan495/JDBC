/******************************************************************************
 *  Purpose:	Update operation of Database
 *
 *  @author  Zeeshan
 *  @version 1.0
 *  @since   23-06-2018
 *
 ******************************************************************************/
package jdbc;
import java.sql.*;
import utility.Utility;
public class Update {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
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
		    int empID=Utility.inputInteger();
		    System.out.println("select choice to edit : \n"+
		    " 1-id \n"+" 2-age \n");
		    int choice=Utility.inputInteger();
		    switch(choice)
		    {
		    case 1:System.out.println("enter new id");
		    id=Utility.inputInteger();
		    sql = "UPDATE employees SET id = "+id+" WHERE id in ("+empID+")";
		    break;
		    case 2:System.out.println("enter new age");
		    age=Utility.inputInteger();
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
		   
	}

}
