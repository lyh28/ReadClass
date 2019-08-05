import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import Attribute.Attribute_Code;
import Constant.ConstantBase;
import Constant.Constant_Factory;
import Read.Readu;


public class Client {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        File file = new File("test.class");
        InputStream is = null;

        try {
            is = new FileInputStream(file);
            //读魔数
            System.out.println("魔数：" + Readu.readForFour(is));
            //读版本号
            System.out.print("min version：" + Readu.readIntForTwo(is) + "\n");
            System.out.print("max version：" + Readu.readIntForTwo(is) + "\n");
            //读常量表
            int constantlen = Readu.readIntForTwo(is);
            System.out.println("Constant pool:");
            System.out.println("Constant pool len:"+constantlen);
            ConstantBase[] constantArray = new ConstantBase[constantlen];
            Map<Integer, String> map = new HashMap<>();
            for (int i = 1; i < constantlen; i++) {
                //先读类型
                int tag = Readu.readIntForOne(is);
                constantArray[i] = Constant_Factory.getConstantBase(tag);

                if (constantArray[i] != null) {
                    constantArray[i].read(is);
                }
                if(tag==5||tag==6){
                    i++;
                }
            }
            for (int i = 1; i < constantlen; i++) {
                if (constantArray[i] == null) continue;
                constantArray[i].print(constantArray, map, i);
                System.out.printf("#%3d = ", i);
                constantArray[i].print();

            }
            //读访问标志
            System.out.println("flags： " + Readu.readForTwo(is));
            //读类索引
            int this_class = Readu.readIntForTwo(is);
            System.out.println("this_class：#" + this_class + "\t\t// " + map.get(this_class));
            int super_class = Readu.readIntForTwo(is);
            System.out.println("super_class：#" + super_class + "\t\t// " + map.get(super_class));
            //读接口
            int interCount = Readu.readIntForTwo(is);
            System.out.println("interfacesCount:" + interCount);
            if (interCount != 0)
                System.out.println(("interface: "+Readu.readIntForTwo(is)));
            //读变量
            int filedsCount = Readu.readIntForTwo(is);
            System.out.println("filedsCount:" + filedsCount);
            for (int i = 0; i < filedsCount; i++) {
                System.out.println("----filed" + i + "----");
                System.out.println("flags:" + Readu.readForTwo(is));
                int name = Readu.readIntForTwo(is);
                System.out.println("name:#" + name + "\t\t// " + map.get(name));
                int descriptor = Readu.readIntForTwo(is);
                System.out.println("descriptor:#" + descriptor + "\t\t// " + map.get(descriptor));
                int filed_attributes = Readu.readIntForTwo(is);
                System.out.println("attributes:" + filed_attributes);
                for (int j = 0; j < filed_attributes; j++) {
                    int filed_name = Readu.readIntForTwo(is);
                    int filed_len = Readu.readIntForFour(is);
                    int count = 0;
                    for (int n = 0; n < filed_len; n++) {
                        Readu.readForOne(is);
                        count++;
                        String tmp = Readu.readForOne(is);
                        if (count % 2 == 0)
                            tmp += " ";
                        if (count % 16 == 0)
                            tmp += "\n";
                        System.out.print(tmp);
                    }
                }
            }
            System.out.println("\n");
            //读方法
            int methodsCount = Readu.readIntForTwo(is);
            System.out.println("methodsCount:" + methodsCount+"\n");
            for (int i = 0; i < methodsCount; i++) {
                System.out.println("flags:" + Readu.readForTwo(is));
                int name = Readu.readIntForTwo(is);
                System.out.println("name:#" + name + "\t\t// " + map.get(name));
                int descriptor = Readu.readIntForTwo(is);
                System.out.println("descriptor:#" + descriptor + "\t\t// " + map.get(descriptor));
                int attributes = Readu.readIntForTwo(is);
                System.out.println("attributes:" + attributes);
                for (int j = 0; j < attributes; j++) {
                    //得到不同类型的attribute
                    int type = Readu.readIntForTwo(is);
                    String attribute_type = map.get(type);

                    //作出选择
                    switch (attribute_type) {
                        case "Code":
                            System.out.println(Attribute_Code.read(is, map));
                            break;
                        default:
                            System.out.println(attribute_type);
                            int len = Readu.readIntForFour(is);
                            int count = 0;
                            for (int z = 0; z < len; z++) {
                                count++;
                                String tmp = Readu.readForOne(is);
                                if (count % 2 == 0)
                                    tmp += " ";
                                if (count % 16 == 0)
                                    tmp += "\n";
                                System.out.print(tmp);
                            }
                            System.out.println("\n");
                            break;
                    }
                }
                System.out.println("\n");
            }
            //属性表
            int end_attribute_count = Readu.readIntForTwo(is);
            for (int i = 0; i < end_attribute_count; i++) {
                int attribute_name_index = Readu.readIntForTwo(is);
                int attribute_length = Readu.readIntForFour(is);
                int sourcefile_index = Readu.readIntForTwo(is);
                System.out.println(map.get(attribute_name_index) + "  " + map.get(sourcefile_index));
            }


        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }
    }
}
