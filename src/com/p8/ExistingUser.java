package com.p8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.p2.AccountCtg;
import com.p2.UserLogin;

public class ExistingUser {

	public Connection con;
	public ExistingUser(Connection con) {
		this.con=con;
	}
		public boolean validateuser(String queryname,String querypwd){
		
			String query="SELECT * FROM userlogin WHERE username=? AND userpwd=?";
			try{
				PreparedStatement pstmt=con.prepareStatement(query);
				pstmt.setString(1, queryname);
				pstmt.setString(2, querypwd);
				ResultSet rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					if(queryname.equals(rs.getString("username")) && querypwd.equals(rs.getString("userpwd")))
					{
						
						return true;
					}
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return false;
		}


}
