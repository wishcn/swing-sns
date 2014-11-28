package com.xxstop.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by xxstop on 2014/11/13.
 */
public class XHttp {
    static protected boolean isConnected = false;
    static public boolean isConnected() {
        URL url = null;
        try {
            url = new URL("http://www.baidu.com");
            InputStream in = url.openStream();
            in.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
