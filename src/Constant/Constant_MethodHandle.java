package Constant;

import java.io.InputStream;

import Read.Readu;

public class Constant_MethodHandle extends ConstantBase_Num {
	public Constant_MethodHandle() {
		// TODO Auto-generated constructor stub
		className="MethodHandle";
		numArray=new int[2];
		content="";
	}
	@Override
	public void read(InputStream is) {
		// TODO Auto-generated method stub
		numArray[0]=Readu.readIntForOne(is);
		numArray[1]=Readu.readIntForTwo(is);
	}
}
