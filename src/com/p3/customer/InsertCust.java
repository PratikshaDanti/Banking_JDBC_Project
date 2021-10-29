package com.p3.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.p2.Customer;

public class InsertCust {

	public Connection con; 
	public InsertCust(Connection con){
		this.con=con;
	}
	public void insert(Customer c) {
		String ins="INSERT INTO customer VALUES(?,?,?,?,?)";
		PreparedStatement pstmt=null;
		try {
			pstmt=con.prepareStatement(ins);
			pstmt.setInt(1, c.getCid());
			pstmt.setString(2, c.getCname());
			pstmt.setString(3, c.getMob());
			pstmt.setString(4, c.getMail_id());
			pstmt.setInt(5, c.getUid());
			pstmt.execute();
			
		}catch(SQLException ob3)
		{
			System.err.println("got an exception");
			System.err.println(ob3.getMessage());
		}

	}

}
