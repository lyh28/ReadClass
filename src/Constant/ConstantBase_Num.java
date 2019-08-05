package Constant;

import java.io.InputStream;
import java.util.Map;

public abstract class ConstantBase_Num extends ConstantBase {
	protected int[] numArray;
	@Override
	public abstract void read(InputStream is);
	@Override
	public void print() {
		// TODO Auto-generated method stub

		//打印编号
		String numstr="";
		for(int i=0;i<numArray.length;i++) {
			if(i!=0)
				numstr+=",";
			numstr+=("#"+numArray[i]);
		}
		System.out.printf("%-20s",className);
		System.out.print(numstr+"\t\t"+"// "+content+"\n");
	}
	@Override
	public String print(ConstantBase[] array, Map<Integer, String> map,int index) {
		// TODO Auto-generated method stub
		
		int len=numArray.length;
		content="";
		for(int i=0;i<len;i++) {
			if(map.containsKey(numArray[i])) {
				if(i!=0)
					content+=":";	//分隔符
				content+=map.get(numArray[i]);
			}else {
				String tmp=array[numArray[i]].print(array, map,index);
				map.put(numArray[i], tmp);
				if(i!=0)
					content+=" : ";	//注释
				content+=tmp;
			}
		}
		
		return content;
	}
}
