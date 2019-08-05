package Attribute_inner;

import Attribute.AttributeI;
import Read.Readu;

import java.io.InputStream;
import java.util.Map;

public class Attribute_Linenumbertable {
    public static String read(InputStream is, Map<Integer, String> map) {
        StringBuilder stringBuilder = new StringBuilder("\tlinenumbertable:" + "\n");
        int len=Readu.readIntForFour(is);
        int line_number_table_len=Readu.readIntForTwo(is);

        for(int m=0;m<line_number_table_len;m++){
            int startpc=Readu.readIntForTwo(is);
            int line_num=Readu.readIntForTwo(is);
            //stringBuilder.append("\tline "+line_num+": ");
            //stringBuilder.append(startpc+"\n");
        }
        return stringBuilder.toString();
    }
}
