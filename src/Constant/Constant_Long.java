package Constant;

import java.io.InputStream;

import Read.Readu;

public class Constant_Long extends ConstantBase_Info {
	public Constant_Long() {
		className="long";
		content="";
		// TODO Auto-generated constructor stub
	}
	@Override
	public void read(InputStream is) {
		// TODO Auto-generated method stub
		content=Readu.readForEight(is);
	}
}
