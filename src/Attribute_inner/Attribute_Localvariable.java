package Attribute_inner;

import Attribute.AttributeI;
import Read.Readu;

import java.io.InputStream;
import java.util.Map;

public class Attribute_Localvariable {
    public static String read(InputStream is, Map<Integer, String> map) {
        StringBuilder stringBuilder = new StringBuilder("\tlocalvariable:" + "\n");
        int attribute_len=Readu.readIntForFour(is);
        stringBuilder.append("\tStart  Length  Slot  Name  Signature\n\t");
        int local_table_len = Readu.readIntForTwo(is);

        for (int z = 0; z < local_table_len; z++) {
            stringBuilder.append("\t"+Readu.readIntForTwo(is)+"\t");
            stringBuilder.append(Readu.readIntForTwo(is)+"\t\t");
            int name_index=Readu.readIntForTwo(is);
            int descriptor_index=Readu.readIntForTwo(is);
            int index=Readu.readIntForTwo(is);
            stringBuilder.append(index+"\t");
            stringBuilder.append(map.get(name_index)+"\t");
            stringBuilder.append(map.get(descriptor_index)+"\t");
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
