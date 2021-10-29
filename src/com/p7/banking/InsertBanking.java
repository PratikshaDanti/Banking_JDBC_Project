package com.p7.banking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.p2.Banking;

public class InsertBanking {

	public Connection con; 
	public InsertBanking(Connection con){
		this.con=con;
	}
	public void insert(Banking b) {
		String ins="INSERT INTO banking VALUES(?,?,?,?,?)";
		PreparedStatement pstmt=null;
		try {
			pstmt=con.prepareStatement(ins);
			pstmt.setInt(1, b.getAccount_no());
			pstmt.setInt(2, b.getCid());
			pstmt.setInt(3, b.getCtg_id());
			pstmt.setString(4, b.getDateofinit());
			pstmt.setDouble(5, b.getAccbal());
			pstmt.execute();
			
		}catch(SQLException ob3)
		{
			System.err.println("got an exception");
			System.err.println(ob3.getMessage());
		}

	}
}
