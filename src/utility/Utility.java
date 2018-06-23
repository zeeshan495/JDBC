package utility;
import java.sql.*;
import java.util.Scanner;
public class Utility {
	public static final String DB_driver="com.mysql.jdbc.Driver";
	public static final String url="jdbc:mysql://localhost:3306/EMPLOYEES";
	public static final String uname="root";
	public static final String pwd="root";
	public static Scanner scan=new Scanner(System.in);

	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
		Connection connection=null;
		Class.forName(DB_driver);
		connection=DriverManager.getConnection(url,uname,pwd);
		return connection;
	}
	
	public static void create() throws ClassNotFoundException, SQLException
	{
		java.sql.Connection conn = null;
		Statement stmt = null;
		System.out.println("Connecting to database...");
		conn=getConnection();
		System.out.println("Creating database...");
	    stmt = conn.createStatement();
	    String sql = "CREATE DATABASE EMPLOYEES";
	    stmt.executeUpdate(sql);
	    System.out.println("Database created successfully...");
	}
	
	public static void read() throws ClassNotFoundException, SQLException
	{
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
	
	public static void update() throws ClassNotFoundException, SQLException
	{
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
	
	public static void delete() throws ClassNotFoundException, SQLException
	{
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
