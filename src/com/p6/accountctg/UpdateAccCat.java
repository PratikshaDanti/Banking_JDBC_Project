package com.p6.accountctg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateAccCat {

	public Connection con;
	public UpdateAccCat(Connection con) {
		this.con=con;
	}
	
	public void updatename(String s1,int x){

		String ins="UPDATE accountctg SET category=? WHERE ctg_id=?";
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
