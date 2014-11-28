package com.xxstop.bus.data;

import com.xxstop.exception.AppException;
import com.xxstop.util.XCUrl;

/**
 * Created by xxstop on 2014/9/24.
 */
public class Cookie {
    protected static String cookie;
    public void setCookie() throws AppException {
        XCUrl curl = new XCUrl("http://www.96096kp.com");
        curl.get();

        cookie = curl.getCookie();
        XCUrl.setCookieStr(cookie);
    }
    public String getCookie() {
        return cookie;
    }
}
