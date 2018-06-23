package utility;
import java.sql.*;
import java.util.Scanner;
public class Utility {
	public static final String DB_driver="com.mysql.jdbc.Driver";
	public static final String url="jdbc:mysql://localhost:3306/EMPLOYEES";
	public static final String uname="root";
	public static final String pwd="root";
	public static Scanner scan=new Scanner(System.in);
	public static  Connection connection=null;
	public static Statement stmt = null;

	private static Scanner scanner = new Scanner(System.in);

	/**
	 * inputInteger is to take input from scanner
	 * 
	 * @return scanner to take next input
	 */
	public static int inputInteger() {
		try {
			return scanner.nextInt();
		} catch (Exception e) {
			scanner.nextLine();
			System.out.println("Invalid input,give integr type input.... again.");
			return inputInteger();
		}
	}
	
	/**
	 * inputString is to take a string value from input.
	 * 
	 * @return scanner to take next value.
	 */
	public static String inputString() {

		return scanner.next();

	}

	/**
	 * inputString1 is to take a string value from input.
	 * 
	 * @return scanner to take next value from next Line.
	 */
	public static String inputString1() {
		return scanner.nextLine();
	}
	/** getConnection is a method to connect the database
	 * @return connection object
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
		
		Class.forName(DB_driver);
		connection=DriverManager.getConnection(url,uname,pwd);
		return connection;
	}
	
	/**create is a method to create a database
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void create() throws ClassNotFoundException, SQLException
	{
		
		System.out.println("Connecting to database...");
//		connection=getConnection();
		Class.forName(DB_driver);
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306",uname,pwd);
		System.out.println("Creating database...");
	    stmt = connection.createStatement();
	    String sql = "CREATE DATABASE EMPLOYEES";
	    stmt.executeUpdate(sql);
	    System.out.println("Database created successfully...");
	}
	
	/**read is a method to display database
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void read() throws ClassNotFoundException, SQLException
	{
		System.out.println("Connecting to database...");
		connection=Utility.getConnection();
	    stmt = connection.createStatement();
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
	    connection.close();
		
	}
	
	/**update is a method to update data database
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void update() throws ClassNotFoundException, SQLException
	{
		String sql="";
		int id=0,age=0;
		System.out.println("Connecting to database...");
		connection=Utility.getConnection();
	    stmt = connection.createStatement();
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
	    connection.close();
	    scan.close();
		
	}
	
	/**delete is a method to delete data in database
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void delete() throws ClassNotFoundException, SQLException
	{
		String sql="";
		System.out.println("Connecting to database...");
		connection=Utility.getConnection();
	    stmt = connection.createStatement();
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
	    connection.close();
	    scan.close();
		
	}

}
