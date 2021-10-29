package com.p6.accountctg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.p2.AccountCtg;

public class DisplayAllAccCtg {

	public Connection con;
	public DisplayAllAccCtg(Connection con) {
		this.con=con;
	}
	public void displayAll(AccountCtg a){
		String query="SELECT * FROM accountctg";
		try{
			PreparedStatement pstmt=this.con.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			System.out.println("---------------------------");
			System.out.println("ctg_id"+"\t"+"category_name");
			System.out.println("---------------------------");;
			while(rs.next())
			{
				a.setCtg_id(rs.getInt("ctg_id"));
				a.setCategory(rs.getString("category"));
				System.out.println(a.toString());
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
