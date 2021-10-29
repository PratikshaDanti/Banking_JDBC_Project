package com.p4;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.Calendar;  

import com.p1.EstablishConnection;
import com.p1.LoadDriver;
import com.p2.*;
import com.p3.customer.*;
import com.p5.transactions.*;
import com.p6.accountctg.*;
import com.p7.banking.*;
import com.p8.AddUser;
import com.p8.ExistingUser;

public class BankingApp {
	
	public static void main(String[] args) throws SQLException {
		LoadDriver l=new LoadDriver("com.mysql.cj.jdbc.Driver");
		l.load();
		System.out.println("driver loaded successfully");
		EstablishConnection e=new EstablishConnection("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/banking","root","Caroot");
		Connection con=e.estconn();
		System.out.println("connection with database established successfully");
		Scanner myObj = new Scanner(System.in);
		int ys=9110;
		
		boolean temp1=true;
		int x,y,val,uid,choice1;
		double z;
		String s1,s2,s3,uname,pwd;
		while(temp1) {
			System.out.println("-----------------------------------------");
			System.out.println("1.New User 2.Existing User 3.Admin 4.Exit");
			System.out.println("enter your choice");
			System.out.println("-----------------------------------------");
			choice1=myObj.nextInt();
			switch(choice1) {
			case 1: System.out.println("enter user id");
					uid=myObj.nextInt();
					
					System.out.println("Enter user name");
					myObj.nextLine();
					uname=myObj.nextLine();
					
					System.out.println("Enter password");
					pwd=myObj.nextLine();
				
					System.out.println("Enter customer id to be added");
					x=myObj.nextInt();
					
					UserLogin u=new UserLogin(uid,uname,pwd);
					AddUser au=new AddUser(con);
					au.insert(u);
					System.out.println("user created!");
			
					System.out.println("Enter customer name to be added");
					myObj.nextLine();
					s1=myObj.nextLine();
					
					System.out.println("Enter customer mobile to be added");
					s2=myObj.nextLine();
					
					System.out.println("Enter customer mail_id to be added");
					s3=myObj.nextLine();
			
					InsertCust iobj=new InsertCust(con);
					Customer c=new Customer(x,s1,s2,s3,uid);
					iobj.insert(c);
					break;
					
			case 2: System.out.println("Enter user name");
					myObj.nextLine();
					s1=myObj.nextLine();
					
					System.out.println("Enter user password");
					s2=myObj.nextLine();
					
					ExistingUser eu=new ExistingUser(con);
					boolean checkuser;
					checkuser=eu.validateuser(s1,s2);
					if(checkuser==true)
						{
							System.out.println("welcome");
							boolean temp=true;
							int choice;
							while(temp) {
								System.out.println("--------------------------------------------------------------");
								System.out.println("1.Customer 2.Accounts 3.Transactions 4.Account Category 5.Exit");
								System.out.println("enter your choice");
								System.out.println("--------------------------------------------------------------");
								choice=myObj.nextInt();
								switch(choice)
								{
								case 1: int choicecust;
										boolean tempcust=true;
										while(tempcust) {
											System.out.println("----------------------------------------------------------------------------------------------------------");
											System.out.println("1.Display customer by id 2.update mailid 3.update mobile 4.update name 5.Exit");
											System.out.println("enter your choice");
											System.out.println("----------------------------------------------------------------------------------------------------------");
											choicecust=myObj.nextInt();
											switch(choicecust) {
											
											case 1: System.out.println("Enter customer id to be displayed");
													x=myObj.nextInt();
													DisplayCustbyId sobj=new DisplayCustbyId(con);
													Customer cobj=new Customer();
													sobj.displaybyid(x,cobj);
													break;
													
													
											case 2: System.out.println("Enter customer id to be updated");
													x=myObj.nextInt();
													
													System.out.println("Enter customer mail_id");
													myObj.nextLine();
													s1=myObj.nextLine();
													
													UpdateCustMail uobj1=new UpdateCustMail(con);
													uobj1.updatemail(s1, x);
													break;
													
											case 3: System.out.println("Enter customer id to be updated");
													x=myObj.nextInt();
													
													System.out.println("Enter customer mobile");
													myObj.nextLine();
													s1=myObj.nextLine();
													
													UpdateCustMob uobj2=new UpdateCustMob(con);
													uobj2.updatemob(s1, x);
													break;
													
											case 4: System.out.println("Enter customer id to be updated");
													x=myObj.nextInt();
													
													System.out.println("Enter customer name");
													myObj.nextLine();
													s1=myObj.nextLine();
													
													UpdateCustName uobj3=new UpdateCustName(con);
													uobj3.updatename(s1, x);
													break;
											
											case 5: tempcust=false;
													break;
											
											default: tempcust=false;
													 break;	
											}
											if(tempcust==false)
												break;
										}
										break;
								
								case 2: int choiceacc=0;
										double ibal;
										boolean tempacc=true;
										while(tempacc) {
											 
											System.out.println("-----------------------------------------");
											System.out.println("1.Create Account 2.Display Account 3.Exit");
											System.out.println("enter your choice");
											System.out.println("-----------------------------------------");
											choiceacc=myObj.nextInt();
											switch(choiceacc) {
													
											case 1: System.out.println("Enter account number to be added");
													x=myObj.nextInt();
													
													System.out.println("Enter customer id to be added");
													y=myObj.nextInt();
													
													System.out.println("Enter category id to be added");
													val=myObj.nextInt();
													
													s1 = "2021-10-21"; 
													
													System.out.println("Enter account balance");
													ibal=myObj.nextDouble();
													
													InsertBanking ibobj=new InsertBanking(con);
													Banking b=new Banking(x,y,val,s1,ibal);
													ibobj.insert(b);
													break;
													
											case 2: System.out.println("Enter account number to be displayed");
													x=myObj.nextInt();
													
													DisplayBankingbyAccno dbaobj=new DisplayBankingbyAccno(con);
													Banking b1=new Banking();
													dbaobj.displaybyid(x, b1);
													break;
												
											case 3: tempacc=false;
													break;
											
											default: tempacc=false;
													 break;	
											}
											if(tempacc==false)
												break;
										}
										break;
								
								case 3: int choicetrans=0;
										boolean temptrans=true;
										while(temptrans) {
											 
											System.out.println("----------------------------------------------------");
											System.out.println("1.View Transaction by id 2.Deposit 3.Withdraw 4.Exit");
											System.out.println("enter your choice");
											System.out.println("----------------------------------------------------");
											choicetrans=myObj.nextInt();
											switch(choicetrans) {
													
											case 1: System.out.println("Enter customer account number to be displayed");
													x=myObj.nextInt();
													DisplayTransbyId dobj=new DisplayTransbyId(con);
													Transactions tobj1=new Transactions();
													dobj.displaytranbyid(x,tobj1);
													break;
											
											case 2:  
													String trn_date = "2021-10-20"; 
											
													System.out.println("Enter customer account number for deposit");
													x=myObj.nextInt();
													
													System.out.println("Enter amount to be depositted");
													z=myObj.nextDouble();
													
													s1="deposit";
													
													Transact t=new Transact(con);
													t.deposit(x, z);
													Transactions trn2=new Transactions(ys,x,trn_date,z,s1);
													ys++;
													AddTransaction atrn=new AddTransaction(con);
													atrn.insert(trn2);
													break;
													
											case 3: System.out.println("Enter customer account number for withdrawal");
													x=myObj.nextInt();
													
													String trn_date1 = "2021-10-20"; 
											
													System.out.println("Enter amount to be withdrawn");
													z=myObj.nextDouble();
													
													s1="Withdrawal";
													
													Transact t1=new Transact(con);
													t1.withdraw(x, z);
									
													Transactions trn1=new Transactions(ys,x,trn_date1,z,s1);
													ys++;
													AddTransaction atrn1=new AddTransaction(con);
													atrn1.insert(trn1);
													
													break;
													
											case 4: temptrans=false;
													break;
											
											default: temptrans=false;
													 break;	
											}
											if(temptrans==false)
												break;
										}
										break;
											
								case 4: break;
								
								case 5: temp=false;
										break;
										
								default:temp=false;
										break;
								
									}
							}
						}
			
						
					else
						System.out.println("username or password might be incorrect, please check again");
					break;
					
			case 3: System.out.println("welcome admin");
					boolean temp3=true;
					int choice3;
					while(temp3) {
						System.out.println("--------------------------------------------------------------");
						System.out.println("1.Customer 2.Accounts 3.Transactions 4.Account Category 5.Exit");
						System.out.println("enter your choice");
						System.out.println("--------------------------------------------------------------");
						choice3=myObj.nextInt();
						switch(choice3)
						{
						case 1: int choicecust;
								boolean tempcust=true;
								while(tempcust) {
									System.out.println("----------------------------------------------------------------------------------------------------------");
									System.out.println("1.Display customer by id 2.Display all 3.Exit");
									System.out.println("enter your choice");
									System.out.println("----------------------------------------------------------------------------------------------------------");
									choicecust=myObj.nextInt();
									switch(choicecust) {
									
									case 1: System.out.println("Enter customer id to be displayed");
											x=myObj.nextInt();
											DisplayCustbyId sobj=new DisplayCustbyId(con);
											Customer cobj=new Customer();
											sobj.displaybyid(x,cobj);
											break;
											
									case 2: System.out.println("all customer records");
											DisplayAllCust saobj=new DisplayAllCust(con);
											Customer call=new Customer();
											saobj.displayAll(call);
											break;
											
									case 3: tempcust=false;
											break;
									
									default: tempcust=false;
											 break;	
									}
									if(tempcust==false)
										break;
								}
								break;
						
						case 2: int choiceacc=0;
								double ibal;
								boolean tempacc=true;
								while(tempacc) {
									 
									System.out.println("-----------------------------------------");
									System.out.println("1.Display Account 2.Exit");
									System.out.println("enter your choice");
									System.out.println("-----------------------------------------");
									choiceacc=myObj.nextInt();
									switch(choiceacc) {
											
									case 1: System.out.println("Enter account number to be displayed");
											x=myObj.nextInt();
											
											DisplayBankingbyAccno dbaobj=new DisplayBankingbyAccno(con);
											Banking b1=new Banking();
											dbaobj.displaybyid(x, b1);
											break;
										
									case 2: tempacc=false;
											break;
									
									default: tempacc=false;
											 break;	
									}
									if(tempacc==false)
										break;
								}
								break;
						
						case 3: int choicetrans=0;
								boolean temptrans=true;
								while(temptrans) {
									 
									System.out.println("----------------------------------------------------");
									System.out.println("1.View Transaction by id 2.Exit");
									System.out.println("enter your choice");
									System.out.println("----------------------------------------------------");
									choicetrans=myObj.nextInt();
									switch(choicetrans) {
											
									case 1: System.out.println("Enter customer account number to be displayed");
											x=myObj.nextInt();
											DisplayTransbyId dobj=new DisplayTransbyId(con);
											Transactions tobj1=new Transactions();
											dobj.displaytranbyid(x,tobj1);
											break;
									
									case 2: temptrans=false;
											break;
									
									default: temptrans=false;
											 break;	
									}
									if(temptrans==false)
										break;
								}
								break;
									
						case 4: break;
						
						case 5: temp3=false;
								break;
								
						default:temp3=false;
								break;
						
							}
					}
					break;
			
			case 4: temp1=false;
					break;
			
			default: temp1=false;
					 break;
			}
			if(temp1==false)
			{
				con.close();
				System.out.println("Connection closed");
				break;
			}
		}
	}
}
	
/*public static void main(String[] args) throws SQLException {
LoadDriver l=new LoadDriver("com.mysql.cj.jdbc.Driver");
l.load();
System.out.println("driver loaded successfully");
EstablishConnection e=new EstablishConnection("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/banking","root","Caroot");
Connection con=e.estconn();
System.out.println("connection with database established successfully");
Scanner myObj = new Scanner(System.in);
int ys=9110;

boolean temp=true;
int x,y,val,choice,uid;
double z;
String s1,s2,s3,uname,pwd;
while(temp) {
	System.out.println("--------------------------------------------------------------");
	System.out.println("1.Customer 2.Accounts 3.Transactions 4.Account Category 5.Exit");
	System.out.println("enter your choice");
	System.out.println("--------------------------------------------------------------");
	choice=myObj.nextInt();
	switch(choice)
	{
	case 1: int choicecust;
			boolean tempcust=true;
			while(tempcust) {
				System.out.println("----------------------------------------------------------------------------------------------------------");
				System.out.println("1.Add 2.Display customer by id 3.Display all 4.update mailid 5.update mobile 6. update name 7.Login 8.Exit");
				System.out.println("enter your choice");
				System.out.println("----------------------------------------------------------------------------------------------------------");
				choicecust=myObj.nextInt();
				switch(choicecust) {
				
				case 1: System.out.println("enter user id");
						uid=myObj.nextInt();
						
						System.out.println("Enter user name");
						myObj.nextLine();
						uname=myObj.nextLine();
						
						System.out.println("Enter password");
						pwd=myObj.nextLine();
					
						System.out.println("Enter customer id to be added");
						x=myObj.nextInt();
						
						UserLogin u=new UserLogin(uid,uname,pwd);
						AddUser au=new AddUser(con);
						au.insert(u);
						System.out.println("user created!");
				
						System.out.println("Enter customer name to be added");
						myObj.nextLine();
						s1=myObj.nextLine();
						
						System.out.println("Enter customer mobile to be added");
						s2=myObj.nextLine();
						
						System.out.println("Enter customer mail_id to be added");
						s3=myObj.nextLine();
				
						InsertCust iobj=new InsertCust(con);
						Customer c=new Customer(x,s1,s2,s3,uid);
						iobj.insert(c);
						break;
						
				case 2: System.out.println("Enter customer id to be displayed");
						x=myObj.nextInt();
						DisplayCustbyId sobj=new DisplayCustbyId(con);
						Customer cobj=new Customer();
						sobj.displaybyid(x,cobj);
						break;
						
				case 3: System.out.println("all customer records");
						DisplayAllCust saobj=new DisplayAllCust(con);
						Customer call=new Customer();
						saobj.displayAll(call);
						break;
						
				case 4: System.out.println("Enter customer id to be updated");
						x=myObj.nextInt();
						
						System.out.println("Enter customer mail_id");
						myObj.nextLine();
						s1=myObj.nextLine();
						
						UpdateCustMail uobj1=new UpdateCustMail(con);
						uobj1.updatemail(s1, x);
						break;
						
				case 5: System.out.println("Enter customer id to be updated");
						x=myObj.nextInt();
						
						System.out.println("Enter customer mobile");
						myObj.nextLine();
						s1=myObj.nextLine();
						
						UpdateCustMob uobj2=new UpdateCustMob(con);
						uobj2.updatemob(s1, x);
						break;
						
				case 6: System.out.println("Enter customer id to be updated");
						x=myObj.nextInt();
						
						System.out.println("Enter customer name");
						myObj.nextLine();
						s1=myObj.nextLine();
						
						UpdateCustName uobj3=new UpdateCustName(con);
						uobj3.updatename(s1, x);
						break;
				
				case 7: System.out.println("Enter user name");
						myObj.nextLine();
						s1=myObj.nextLine();
						
						System.out.println("Enter user password");
						s2=myObj.nextLine();
						
						ExistingUser eu=new ExistingUser(con);
						boolean checkuser;
						checkuser=eu.validateuser(s1,s2);
						if(checkuser==true)
							System.out.println("welcome");
						else
							System.out.println("username or password might be incorrect, please check again");
						break;
					
				case 8: tempcust=false;
						break;
				
				default: tempcust=false;
						 break;	
				}
				if(tempcust==false)
					break;
			}
			break;
	
	case 2: int choiceacc=0;
			double ibal;
			boolean tempacc=true;
			while(tempacc) {
				 
				System.out.println("-----------------------------------------");
				System.out.println("1.Create Account 2.Display Account 3.Exit");
				System.out.println("enter your choice");
				System.out.println("-----------------------------------------");
				choiceacc=myObj.nextInt();
				switch(choiceacc) {
						
				case 1: System.out.println("Enter account number to be added");
						x=myObj.nextInt();
						
						System.out.println("Enter customer id to be added");
						y=myObj.nextInt();
						
						System.out.println("Enter category id to be added");
						val=myObj.nextInt();
						
						s1 = "2021-10-21"; 
						
						System.out.println("Enter account balance");
						ibal=myObj.nextDouble();
						
						InsertBanking ibobj=new InsertBanking(con);
						Banking b=new Banking(x,y,val,s1,ibal);
						ibobj.insert(b);
						break;
						
				case 2: System.out.println("Enter account number to be displayed");
						x=myObj.nextInt();
						
						DisplayBankingbyAccno dbaobj=new DisplayBankingbyAccno(con);
						Banking b1=new Banking();
						dbaobj.displaybyid(x, b1);
						break;
					
				case 3: tempacc=false;
						break;
				
				default: tempacc=false;
						 break;	
				}
				if(tempacc==false)
					break;
			}
			break;
	
	case 3: int choicetrans=0;
			boolean temptrans=true;
			while(temptrans) {
				 
				System.out.println("----------------------------------------------------");
				System.out.println("1.View Transaction by id 2.Deposit 3.Withdraw 4.Exit");
				System.out.println("enter your choice");
				System.out.println("----------------------------------------------------");
				choicetrans=myObj.nextInt();
				switch(choicetrans) {
						
				case 1: System.out.println("Enter customer account number to be displayed");
						x=myObj.nextInt();
						DisplayTransbyId dobj=new DisplayTransbyId(con);
						Transactions tobj1=new Transactions();
						dobj.displaytranbyid(x,tobj1);
						break;
				
				case 2:  
						String trn_date = "2021-10-20"; 
				
						System.out.println("Enter customer account number for deposit");
						x=myObj.nextInt();
						
						System.out.println("Enter amount to be depositted");
						z=myObj.nextDouble();
						
						s1="deposit";
						
						Transact t=new Transact(con);
						t.deposit(x, z);
						Transactions trn2=new Transactions(ys,x,trn_date,z,s1);
						ys++;
						AddTransaction atrn=new AddTransaction(con);
						atrn.insert(trn2);
						break;
						
				case 3: System.out.println("Enter customer account number for withdrawal");
						x=myObj.nextInt();
						
						String trn_date1 = "2021-10-20"; 
				
						System.out.println("Enter amount to be withdrawn");
						z=myObj.nextDouble();
						
						s1="Withdrawal";
						
						Transact t1=new Transact(con);
						t1.withdraw(x, z);
		
						Transactions trn1=new Transactions(ys,x,trn_date1,z,s1);
						ys++;
						AddTransaction atrn1=new AddTransaction(con);
						atrn1.insert(trn1);
						
						break;
						
				case 4: temptrans=false;
						break;
				
				default: temptrans=false;
						 break;	
				}
				if(temptrans==false)
					break;
			}
			break;
				
	case 4: break;
	
	case 5: temp=false;
			break;
			
	default:temp=false;
			break;
	
		}
	if(temp==false)
		{
			con.close();
			System.out.println("Connection closed");
			break;
		}
		
	}
}*/
			
				
	
