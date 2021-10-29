package com.p3.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateCustMail {

	public Connection con;
	public UpdateCustMail(Connection con) {
		this.con=con;
	}
	
	public void updatemail(String s1,int x){

		String ins="UPDATE customer SET mail_id=? WHERE cid=?";
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
