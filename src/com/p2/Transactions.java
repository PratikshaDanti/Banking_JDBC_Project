package com.p2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transactions{

	int trn_id;
	int account_no;
	String trn_date;
	double amount;
	String comments;
	public Transactions() {	}
	
	public Transactions(int trn_id,int account_no, String trn_date,double amount, String comments) {
		this.trn_id=trn_id;
		this.trn_date=trn_date;
		this.account_no = account_no;
		this.amount = amount;
		this.comments = comments;
	}
	
	
	public int getTrn_id() {
		return trn_id;
	}

	public void setTrn_id(int trn_id) {
		this.trn_id = trn_id;
	}

	public int getAccount_no() {
		return account_no;
	}

	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}

	public String getTrn_date() {
		return trn_date;
	}

	public void setTrn_date(String trn_date) {
		this.trn_date = trn_date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return  trn_id  + "\t" + trn_date + "\t"	+ amount + "\t" + comments;
	}
}
