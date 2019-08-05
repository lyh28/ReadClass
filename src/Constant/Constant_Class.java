package Constant;

import java.io.InputStream;

import Read.Readu;

public class Constant_Class extends ConstantBase_Num {
	public Constant_Class() {
		className="Class";
		content="";
		numArray=new int[1];
		// TODO Auto-generated constructor stub
	}
	@Override
	public void read(InputStream is) {
		// TODO Auto-generated method stub
		numArray[0]=Readu.readIntForTwo(is);
	}

}
