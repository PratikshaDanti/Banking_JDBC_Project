package com.p1;

public class LoadDriver {
	String myDriver;

	public LoadDriver(String myDriver) {
		this.myDriver=myDriver;
	}
	
	public void load()
	{
		try {
			Class.forName(this.myDriver);
		}catch(ClassNotFoundException ob1)
		{
			System.out.println("cannot load driver "+ob1);
		}
	}
}