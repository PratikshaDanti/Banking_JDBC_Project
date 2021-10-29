package com.p6.accountctg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.p2.AccountCtg;

public class InsertAccCtg {

	public Connection con; 
	public InsertAccCtg(Connection con){
		this.con=con;
	}
	public void insert(AccountCtg a) {
		String ins="INSERT INTO accountctg VALUES(?,?)";
		PreparedStatement pstmt=null;
		try {
			pstmt=con.prepareStatement(ins);
			pstmt.setInt(1, a.getCtg_id());
			pstmt.setString(2, a.getCategory());
			pstmt.execute();
			
		}catch(SQLException ob3)
		{
			System.err.println("got an exception");
			System.err.println(ob3.getMessage());
		}

	}
}
