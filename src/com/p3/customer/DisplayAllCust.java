package com.p3.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.p2.Customer;

public class DisplayAllCust {

	public Connection con;
	public DisplayAllCust(Connection con) {
		this.con=con;
	}
	public void displayAll(Customer c){
		String query="SELECT * FROM customer";
		try{
			PreparedStatement pstmt=this.con.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("cust_id"+"\t"+"cust_name"+" "+"cust_mobile"+"\t"+"cust_mail"+"\t"+"user id");
			System.out.println("--------------------------------------------------------------------------");
			while(rs.next())
			{
				c.setCid(rs.getInt("cid"));
				c.setCname(rs.getString("cname"));
				c.setMob(rs.getString("mob"));
				c.setMail_id(rs.getString("mail_id"));
				c.setUid(rs.getInt("userid"));
				System.out.println(c.toString());
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
