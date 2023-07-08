package Dao;

import java.sql.*;

import ConnectionManager.connectionManager;
import module.Product;

public class ProductDAO 
{
	public void addProduct(Product product) throws ClassNotFoundException, SQLException
	{
		connectionManager conm=new connectionManager();
		Connection con = conm.establishConnection();
		
		String sql_query = "insert into product(productId,productName,minSellQuantity,price,quantity) values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql_query);
		ps.setInt(1,product.getProductid());
		ps.setString(2,product.getProductname());
		ps.setInt(3, product.getMinsellquantity());
		ps.setInt(4, product.getPrice());
		ps.setInt(5, product.getQuantity());
		
		ps.executeUpdate();
		
		conm.closeConnection();
	}

public void display() throws ClassNotFoundException, SQLException
{

	connectionManager conm=new connectionManager();
	Connection con = conm.establishConnection();
	Statement st=con.createStatement();
	ResultSet rt=st.executeQuery("Select * from product");
	while(rt.next())
	{
		System.out.println(rt.getInt("productId")+" | "+rt.getString("productName")+" | "+rt.getInt("minsellQuantity")+" | "+rt.getInt("price")+" | "+rt.getInt("quantity"));
		
	}
}
}