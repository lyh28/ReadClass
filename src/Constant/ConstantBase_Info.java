package Constant;

import java.io.InputStream;
import java.util.Map;

public abstract class ConstantBase_Info extends ConstantBase {
	
	@Override
	public abstract void read(InputStream is) ;
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.printf("%-20s",className);
		System.out.print(content+"\n");
	}
	@Override
	public String print(ConstantBase[] array, Map<Integer, String> map,int index) {
		// TODO Auto-generated method stub
		map.put(index,content);
		return content;
	}
}
