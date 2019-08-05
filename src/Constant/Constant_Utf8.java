package Constant;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import Read.Readu;

public class Constant_Utf8 extends ConstantBase_Info {
	public Constant_Utf8() {
		className="utf8";
		content="";
		// TODO Auto-generated constructor stub
	}
	@Override
	public void read(InputStream is){
		// TODO Auto-generated method stub
		int len=Readu.readIntForTwo(is);
		for(int i=0;i<len;i++) {
			try {
				content+=URLDecoder.decode("%"+Readu.readForOne(is),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
