package com.p5.transactions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.p2.AccountCtg;
import com.p2.Transactions;

public class AddTransaction {

	public Connection con; 
	public AddTransaction(Connection con){
		this.con=con;
	}
	public void insert(Transactions t) {
		String ins="INSERT INTO transactions VALUES(?,?,?,?,?)";
		PreparedStatement pstmt=null;
		try {
			pstmt=con.prepareStatement(ins);
			pstmt.setInt(1, t.getTrn_id());
			pstmt.setInt(2, t.getAccount_no());
			pstmt.setString(3, t.getTrn_date());
			pstmt.setDouble(4, t.getAmount());
			pstmt.setString(5, t.getComments());
			pstmt.execute();
			
		}catch(SQLException ob3)
		{
			System.err.println("got an exception");
			System.err.println(ob3.getMessage());
		}

	}
}
