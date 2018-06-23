package jdbc;
import java.sql.*;

public class basic {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/demo";
		String uname="root";
		String pwd="root";
		String query="select * from student";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,uname,pwd);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next())
		{
		String students=rs.getInt(1)+" : "+rs.getString("sname");
		System.out.println(students);
		}
		con.close();

	}

}
