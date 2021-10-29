package com.p7.banking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.p2.Banking;

public class DisplayBankingbyAccno {

	public Connection con;
	public DisplayBankingbyAccno(Connection con) {
		this.con=con;
	}
		public void displaybyid(int queryid,Banking b){
			String query="SELECT * FROM banking WHERE account_no=?";
			try{
				PreparedStatement pstmt=con.prepareStatement(query);
				pstmt.setInt(1, queryid);
				ResultSet rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					if(queryid==rs.getInt("account_no"))
					{
						b.setAccount_no(rs.getInt("account_no"));
						b.setCid(rs.getInt("cid"));
						b.setCtg_id(rs.getInt("ctg_id"));
						b.setDateofinit(rs.getString("dateofinit"));
						b.setAccbal(rs.getDouble("accbal"));
						
						System.out.println("------------------------------------------------------------------");
						System.out.println("acc_no"+"\t"+"c_id"+"\t"+"ctg_id"+"\t"+"date of init"+"\t"+"accbal");
						System.out.println("------------------------------------------------------------------");
						System.out.println(b.toString());
						System.out.println("------------------------------------------------------------------");
						break;
					}
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
}
