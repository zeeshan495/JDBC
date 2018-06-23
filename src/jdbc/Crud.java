/******************************************************************************
 *  Purpose:	crud operation of JDBC
 *
 *  @author  Zeeshan
 *  @version 1.0
 *  @since   23-06-2018
 *
 ******************************************************************************/
package jdbc;
import java.sql.SQLException;
import utility.Utility;

public class Crud {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String loop="";
		do
		{
		System.out.println("\nenter '1' to create databse\n"+
		"enter '2' to read database\n"+
		"enter '3' to update database\n"+
		"enter '4' to delete database\n");
		int choice=Utility.inputInteger();
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
	    System.out.println("enter 'yes' to continue otherwise 'no'");
	    loop=Utility.inputString();
		}while(loop.equals("yes"));
	}

}
