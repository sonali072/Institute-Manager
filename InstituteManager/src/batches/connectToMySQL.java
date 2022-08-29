package batches;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectToMySQL {

	public static Connection doConnect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/institutemanager", "root", "");
			System.out.println("Connected!");
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		doConnect();

	}

}
