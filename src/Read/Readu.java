package Read;
import java.awt.print.Printable;
import java.io.InputStream;

public class Readu {
	public static String readForOne(InputStream is) {
		return read(is, 1);
	}
	public static String readForTwo(InputStream is)  {
		return read(is, 2);
	}
	public static String readForFour(InputStream is) {
		return read(is, 4);
	}
	public static String readForEight(InputStream is) {
		return read(is, 8);
	}
	
	private static int getIntFromU(String str) {
		return Integer.parseInt(str,16);
	}
	public static int readIntForFour(InputStream is) {
		return getIntFromU(readForFour(is));
	}
	public static int readIntForTwo(InputStream is) {
		return getIntFromU(readForTwo(is));
	}
	public static int readIntForOne(InputStream is) {
		return getIntFromU(readForOne(is));
	}
	private static String read(InputStream is,int type) {
		String resstr="";
		try {
			for(int i=0;i<type;i++) {
				int res=is.read();
				String tmpstr=Integer.toHexString(res);
				if(tmpstr.length()==1)	tmpstr="0"+tmpstr;
				resstr+=tmpstr;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			return resstr;
		}
	}
	
}
