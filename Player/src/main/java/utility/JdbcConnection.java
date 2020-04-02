package utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection {
	private static final String DBURL="jdbc:mysql://localhost:3306/student";
	private static final String USERNAME="root";
	private static final String PASSWORD="BHANU";
	public static Connection getConnection()
	{
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 connection= (Connection) DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return connection;
	}
	public static  String  closeConneection(Connection con)
	{
		 String res="";
		try {
			con.close();
		}
		catch(Exception e)
		{
			res=e.getMessage();
		}
		return res;
	}


}
