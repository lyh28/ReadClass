package Attribute_inner;

import Attribute.AttributeI;
import Read.Readu;

import java.io.InputStream;
import java.util.Map;

public class Attribute_StackMapTable implements AttributeI {
    public String read(InputStream is, Map<Integer, String> map) {
        StringBuilder stringBuilder = new StringBuilder("\tStackMapTable:" + "\n");
        int attribute_len= Readu.readIntForFour(is);
        int stack_map_len = Readu.readIntForTwo(is);

        for (int z = 0; z < stack_map_len; z++) {
            stringBuilder.append("same_frame: "+Readu.readIntForOne(is));

        }
        return stringBuilder.toString();
    }
}
