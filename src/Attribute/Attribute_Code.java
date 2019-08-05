package Attribute;

import Attribute_inner.Attribute_Linenumbertable;
import Attribute_inner.Attribute_Localvariable;
import Read.Readu;

import java.io.InputStream;
import java.util.Map;

public class Attribute_Code {
    public static String read(InputStream is, Map<Integer,String> map){
        StringBuilder stringBuilder=new StringBuilder("Code:"+"\n");
        stringBuilder.append("\tattribute_length="+Readu.readIntForFour(is)+"\n");
        stringBuilder.append("\tmax_stack="+Readu.readIntForTwo(is)+"\n");
        stringBuilder.append("\tmax_locals="+Readu.readIntForTwo(is)+"\n");
        int code_length=Readu.readIntForFour(is);
        for(int z=0;z<code_length;z++){
            String code=Readu.readForOne(is);
            if(code.length()==0)
                code="0"+code;
            //stringBuilder.append("\t\t"+code+"\n");
        }
        int exception_table_length=Readu.readIntForTwo(is);
        stringBuilder.append("\texception_table_length:" +exception_table_length+"\n");
        for(int z=0;z<exception_table_length;z++){
            stringBuilder.append("\t----exception " + z + "----\n");
            stringBuilder.append("\tstart_pc:"+Readu.readIntForTwo(is)+"\n");
            stringBuilder.append("\tend_pc="+Readu.readIntForTwo(is)+"\n");
            stringBuilder.append("\thandler_pc="+Readu.readForTwo(is)+"\n");
            stringBuilder.append("\tcatch_type="+Readu.readForTwo(is)+"\n");
        }
        //内部的attributes_count
        int attributes_count=Readu.readIntForTwo(is);
        for(int z=0;z<attributes_count;z++){
            //得到内部属性的类型
            int attribute_name_index=Readu.readIntForTwo(is);
            switch (map.get(attribute_name_index)){
                case "LineNumberTable":
                    stringBuilder.append(Attribute_Linenumbertable.read(is,map));
                    break;
                case "LocalVariableTable":
                    stringBuilder.append(Attribute_Localvariable.read(is,map));
                    break;
                default:
                    stringBuilder.append(map.get(attribute_name_index)+"\n");
                    int len=Readu.readIntForFour(is);
                    int count=0;
                    for(int i=0;i<len;i++){
                        count++;
                        String tmp=Readu.readForOne(is);
                        if(count%2==0)
                            tmp+=" ";
                        if(count%16==0)
                            tmp+="\n";
                        stringBuilder.append(tmp);
                    }
                    break;
            }
        }
        return stringBuilder.toString();
    }
}
