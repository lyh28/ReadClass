package Constant;

import java.io.InputStream;

import Read.Readu;

public class Constant_Invoke extends ConstantBase_Num {
	public Constant_Invoke() {
		// TODO Auto-generated constructor stub
		className="Invoke";
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
