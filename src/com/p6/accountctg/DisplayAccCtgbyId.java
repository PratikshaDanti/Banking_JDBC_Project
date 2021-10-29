package com.p6.accountctg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.p2.AccountCtg;

public class DisplayAccCtgbyId {

	public Connection con;
	public DisplayAccCtgbyId(Connection con) {
		this.con=con;
	}
		public void displaybyid(int queryid, AccountCtg a){
		
			String query="SELECT * FROM accountctg WHERE ctg_id=?";
			try{
				PreparedStatement pstmt=con.prepareStatement(query);
				pstmt.setInt(1, queryid);
				ResultSet rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					if(queryid==rs.getInt("ctg_id"))
					{
						a.setCtg_id(rs.getInt("ctg_id"));
						a.setCategory(rs.getString("category"));
						
						System.out.println("---------------------------");
						System.out.println("ctg_id"+"\t"+"category_name");
						System.out.println("---------------------------");;
						System.out.println(a.toString());
						System.out.println("---------------------------");
						break;
					}
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
}
