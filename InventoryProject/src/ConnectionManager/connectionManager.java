package ConnectionManager;
import java.sql.*;
public class connectionManager {
	Connection con = null;
	public Connection establishConnection() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InventoryProject","root","BMVS");
		return con;
	}
	public void closeConnection() throws SQLException
	{
		con.close();
	}
}
 