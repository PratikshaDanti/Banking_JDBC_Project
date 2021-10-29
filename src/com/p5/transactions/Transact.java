package com.p5.transactions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transact {

	public Connection con;
	public Transact(Connection con) {
		this.con=con;
	}
	
	public void deposit(int x,double amount){
		double currentbal=0.0;
		int cid,account_no,ctg_id;
		String dateofinit;
		String query="SELECT * FROM Banking WHERE account_no=?";
		try{
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1, x);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				if(x==rs.getInt("account_no"))
				{
					account_no=rs.getInt("account_no");
					cid=rs.getInt("cid");
					ctg_id=rs.getInt("ctg_id");
					dateofinit=rs.getString("dateofinit");
					currentbal=rs.getDouble("accbal");
					break;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		String ins="UPDATE banking b,transactions d SET b.accbal=? WHERE b.account_no=? AND b.account_no=d.account_no";
		PreparedStatement pstmt=null;
		try {
			pstmt=con.prepareStatement(ins);
			pstmt.setDouble(1, currentbal+amount);
			pstmt.setInt(2, x);
			pstmt.execute();
		}catch(SQLException ob3)
		{
			System.err.println("got an exception");
			System.err.println(ob3.getMessage());
		}
	}
	
	public void withdraw(int x,double amount){
		double currentbal=0.0;
		int cid,account_no,ctg_id;
		String dateofinit;
		String query="SELECT * FROM Banking WHERE account_no=?";
		try{
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1, x);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				if(x==rs.getInt("account_no"))
				{
					account_no=rs.getInt("account_no");
					cid=rs.getInt("cid");
					ctg_id=rs.getInt("ctg_id");
					dateofinit=rs.getString("dateofinit");
					currentbal=rs.getDouble("accbal");
					break;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		String ins="UPDATE banking b,transactions d SET b.accbal=? WHERE b.account_no=? AND b.account_no=d.account_no";
		PreparedStatement pstmt=null;
		try {
			pstmt=con.prepareStatement(ins);
			pstmt.setDouble(1, currentbal-amount);
			pstmt.setInt(2, x);
			pstmt.execute();
		}catch(SQLException ob3)
		{
			System.err.println("got an exception");
			System.err.println(ob3.getMessage());
		}
	}
}
