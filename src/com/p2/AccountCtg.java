package com.p2;

public class AccountCtg {
	int ctg_id;
	String category;
	
	public AccountCtg(int ctg_id, String category) {
		this.ctg_id = ctg_id;
		this.category = category;
	}
	
	public AccountCtg() {
	}

	public int getCtg_id() {
		return ctg_id;
	}

	public void setCtg_id(int ctg_id) {
		this.ctg_id = ctg_id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return  ctg_id + "\t" + category ;
	}
	
}
