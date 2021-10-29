package com.p8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.p2.UserLogin;

public class AddUser {

		public Connection con; 
		public AddUser(Connection con){
			this.con=con;
		}
		public void insert(UserLogin u) {
			String ins="INSERT INTO userlogin VALUES(?,?,?)";
			PreparedStatement pstmt=null;
			try {
				pstmt=con.prepareStatement(ins);
				pstmt.setInt(1,u.getUserid());
				pstmt.setString(2,u.getUsername());
				pstmt.setString(3, u.getUserpwd());
				pstmt.execute();
				
			}catch(SQLException ob3)
			{
				System.err.println("got an exception");
				System.err.println(ob3.getMessage());
			}

		}
	}


