package Constant;

import java.io.InputStream;

import Read.Readu;

public class Constant_Method extends ConstantBase_Num {
	public Constant_Method() {
		// TODO Auto-generated constructor stub
		className="Method";
		numArray=new int[2];
		content="";
	}
	@Override
	public void read(InputStream is) {
		// TODO Auto-generated method stub
		numArray[0]=Readu.readIntForTwo(is);
		numArray[1]=Readu.readIntForTwo(is);
	}

}
