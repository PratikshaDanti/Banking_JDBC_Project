package com.p3.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.p2.Customer;

public class DisplayCustbyId {

	public Connection con;
	public DisplayCustbyId(Connection con) {
		this.con=con;
	}
		public void displaybyid(int queryid,Customer c){
			String query="SELECT * FROM customer WHERE cid=?";
			try{
				PreparedStatement pstmt=con.prepareStatement(query);
				pstmt.setInt(1, queryid);
				ResultSet rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					if(queryid==rs.getInt("cid"))
					{
						c.setCid(rs.getInt("cid"));
						c.setCname(rs.getString("cname"));
						c.setMob(rs.getString("mob"));
						c.setMail_id(rs.getString("mail_id"));
						c.setUid(rs.getInt("userid"));
						
						System.out.println("--------------------------------------------------------------------------");
						System.out.println("cust_id"+"\t"+"cust_name"+" "+"cust_mobile"+"\t"+"cust_mail"+"\t"+"user id");
						System.out.println("--------------------------------------------------------------------------");
						System.out.println(c.toString());
						System.out.println("--------------------------------------------------------------------------");
						break;
					}
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
}
