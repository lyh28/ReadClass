package Constant;


public class Constant_Factory {
	public static ConstantBase getConstantBase(int tag) {
		switch (tag) {
		case 1:
			return new Constant_Utf8();
		case 3:
		case 4:
			return new Constant_Integer();
		case 5:
		case 6:
			return new Constant_Long();
		case 7:
			return new Constant_Class();
		case 8:
			return new Constant_String();
		case 9:
			return new Constant_Field();
		case 10:
			return new Constant_Method();
		case 11:
			return new Constant_Interface();
		case 12:
			return new Constant_NameAndType();
		case 15:
			return new Constant_MethodHandle();
		case 16:
			return new Constant_MethodType();
		case 18:
			return new Constant_Invoke();
		default:
			System.out.println("为空"+tag);
			return null;
		}
	}
}
