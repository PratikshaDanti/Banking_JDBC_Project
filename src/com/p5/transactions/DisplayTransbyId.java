package com.p5.transactions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.p2.Transactions;

public class DisplayTransbyId {

	public Connection con;
	public DisplayTransbyId(Connection con) {
		this.con=con;
	}
		public void displaytranbyid(int queryid,Transactions t){
			String query="SELECT * FROM transactions WHERE account_no=?";
			try{
				PreparedStatement pstmt=con.prepareStatement(query);
				pstmt.setInt(1, queryid);
				ResultSet rs=pstmt.executeQuery();
				System.out.println("------------------------------------------------------------------");
				System.out.println("trn_id"+"\t"+"acc_num"+" "+"trn_date"+"\t"+"amount"+"\t"+"comments");
				System.out.println("------------------------------------------------------------------");
				System.out.println("account number : "+queryid);
				while(rs.next())
				{
					if(queryid==rs.getInt("account_no"))
					{
						t.setTrn_id(rs.getInt("trn_id"));
						t.setAccount_no(rs.getInt("account_no"));
						t.setTrn_date(rs.getString("trn_date"));
						t.setAmount(rs.getDouble("amount"));
						t.setComments(rs.getString("comments"));
						
						System.out.println(t.toString());
						
					}System.out.println("------------------------------------------------------------------");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
}
