package com.xxstop.util;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashMap;

/**
 * Created by xxstop on 2014/9/20.
 */
public class XJson {
    public static HashMap decode(String str) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        return mapper.readValue(str, HashMap.class);
    }
    public static String encode(Object obj) throws IOException {
        ObjectMapper mapper =new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }
}
