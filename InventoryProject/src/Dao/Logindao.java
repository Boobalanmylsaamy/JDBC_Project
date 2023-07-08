package Dao;
import module.Login;
import java.sql.*;
import ConnectionManager.connectionManager;


public class Logindao {
	public boolean validate(Login login) throws ClassNotFoundException, SQLException
	{
		String username=login.getUsername();
		String password=login.getPassword();
		connectionManager conm=new connectionManager();
		Connection con=conm.establishConnection();
		Statement st=con.createStatement();
		ResultSet rt=st.executeQuery("Select * from login");
		while(rt.next())
		{
			if(username.equals(rt.getString("username")) && password.equals(rt.getString("password")))
			{
				conm.closeConnection();
				return true;
			}
		}
		conm.closeConnection();
		return false;
		}
	}

