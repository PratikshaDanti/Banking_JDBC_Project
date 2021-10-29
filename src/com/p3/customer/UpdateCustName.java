package com.p3.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateCustName {

	public Connection con;
	public UpdateCustName(Connection con) {
		this.con=con;
	}
	
	public void updatename(String s1,int x){

		String ins="UPDATE customer SET cname=? WHERE cid=?";
		PreparedStatement pstmt=null;
		try {
			pstmt=con.prepareStatement(ins);
			pstmt.setString(1, s1);
			pstmt.setInt(2, x);
			pstmt.execute();
		}catch(SQLException ob3)
		{
			System.err.println("got an exception");
			System.err.println(ob3.getMessage());
		}
	}

}
