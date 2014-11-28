package com.xxstop.util;

import java.io.UnsupportedEncodingException;

/**
 * Created by xxstop on 2014/9/23.
 */
public class XString {
    public static String b2(byte[] bytes) throws UnsupportedEncodingException {
        return new String(bytes, "UTF-8");
    }
}
