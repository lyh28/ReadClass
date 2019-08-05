package Attribute;

import java.io.InputStream;
import java.util.Map;

public interface AttributeI {
    String read(InputStream is, Map<Integer,String> map);
}
