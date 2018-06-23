package jdbc;

import java.sql.SQLException;
import java.util.Scanner;

import utility.Utility;

public class Crud {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Scanner scan=new Scanner(System.in);
//		java.sql.Connection conn = null;
//		Statement stmt = null;
//		System.out.println("Connecting to database...");
//		conn=Utility.getConnection();
		System.out.println("\n enter '1' to create databse\n"+
		"enter '2' to read database\n"+
		"enter '3' to update database\n"+
		"enter '4' to delete database\n");
		int choice=scan.nextInt();
	    switch(choice)
	    {
	    case 1:Utility.create();
	    break;
	    case 2:Utility.read();
	    break;
	    case 3:Utility.update();
	    break;
	    case 4:Utility.delete();
	    break;
	    }
	    scan.close();
//	    stmt.close();
//	    conn.close();
	}

}
