import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class database {
	
	Connection con;
	
	String url="jdbc:postgresql://localhost:5432/gigadb_v3/";
	String password="test";
	String user="test";
	
	

	
	Statement stmt;
	Statement stmt1;
	PreparedStatement prepforall= null;
	
	
	
	
	
	
	public database () {
		
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			con = DriverManager.getConnection(url, user, password);
		//this is important
			con.setAutoCommit(true);
			stmt = con.createStatement();
			stmt1=con.createStatement();
		
//		int i=1;
		
			} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
		// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
		// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	
	public String get_result(String command, String attribute) throws SQLException
	{
		System.out.println("get_result from query: "+ command);
		ResultSet resultSet=stmt.executeQuery(command);
		command=null;
		while(resultSet.next())
		{
			command= resultSet.getString(attribute);
		}
		System.out.println("get_result : "+ command);
		return command;
		
	}
	
	
	
	
}