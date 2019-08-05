package Constant;

import java.io.InputStream;

import Read.Readu;

public class Constant_String extends ConstantBase_Num {
	public Constant_String() {
		// TODO Auto-generated constructor stub
		className="String";
		numArray=new int[1];
		content="";
	}
	@Override
	public void read(InputStream is) {
		// TODO Auto-generated method stub
		numArray[0]=Readu.readIntForTwo(is);
	}

}
