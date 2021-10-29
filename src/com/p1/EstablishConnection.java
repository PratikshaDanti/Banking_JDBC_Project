package com.p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EstablishConnection {

	String myDriver;
	String myUrl;
	String username;
	String password;
	
	public EstablishConnection(String myDriver,String myUrl,String username,String password){
		this.myDriver=myDriver;
		this.myUrl=myUrl;
		this.username=username;
		this.password=password;	
	}
	
	public Connection estconn()
	{
		Connection con=null;
		try {
			con=DriverManager.getConnection(myUrl,username,password);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
}
