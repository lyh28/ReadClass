package Constant;

import java.io.InputStream;

import Read.Readu;

public class Constant_Integer extends ConstantBase_Info {
	public Constant_Integer() {
		className="integer";
		content="";
		// TODO Auto-generated constructor stub
	}
	@Override
	public void read(InputStream is) {
		// TODO Auto-generated method stub
		content=Readu.readForFour(is);
	}

}
