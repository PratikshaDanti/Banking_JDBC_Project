package com.p2;

public class Customer {
	int cid ;
	String cname;
	String mob;
	String mail_id;
	int userid;
	public Customer() {	}
	
	public Customer(int cid, String cname, String mob, String mail_id,int userid) {
		this.cid = cid;
		this.cname = cname;
		this.mob = mob;
		this.mail_id = mail_id;
		this.userid=userid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getMail_id() {
		return mail_id;
	}
	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}
	public int getUid() {
		return userid;
	}

	public void setUid(int uid) {
		this.userid = uid;
	}

	@Override
	public String toString() {
		return cid + "\t" + cname + "\t" + mob + "\t" + mail_id+"\t"+userid;
	}
}
