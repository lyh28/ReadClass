package Constant;

import java.io.InputStream;

import Read.Readu;

public class Constant_MethodType extends ConstantBase_Num {
	public Constant_MethodType() {
		// TODO Auto-generated constructor stub
		className="MethodType";
		numArray=new int[1];
		content="";
	}
	@Override
	public void read(InputStream is) {
		// TODO Auto-generated method stub
		numArray[0]=Integer.valueOf(Readu.readForTwo(is));
	}
}
