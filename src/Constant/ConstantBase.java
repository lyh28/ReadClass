package Constant;

import java.io.InputStream;
import java.util.Map;

public abstract class ConstantBase {
	protected String className;
	protected String content;	//内容
	//从文件中读取信息
	public abstract void read(InputStream is);
	//根据自身数据输出信息
	public abstract String print(ConstantBase[] array,Map<Integer, String> map,int index);
	public abstract void print();

	@Override
	public String toString() {
		return "ConstantBase{" +
				"className='" + className + '\'' +
				", content='" + content + '\'' +
				'}';
	}
}