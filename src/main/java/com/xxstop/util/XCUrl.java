package com.xxstop.util;

import com.xxstop.exception.AppException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.params.CoreProtocolPNames;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by xxstop on 2014/9/20.
 */
public class XCUrl {
    protected String url;

    protected static String cookieStr;
    protected HttpClient hc;

    public XCUrl(String url) {
        this.url = url;
    }

    public byte[] get(HashMap data) throws AppException {
        String param = URLEncodedUtils.format((List<? extends org.apache.http.NameValuePair>) data,"UTF-8");
        url += url.contains("?") ? "&" + param : "?" + param;
        return get();
    }

    public byte[] get() throws AppException {
        GetMethod gm = new GetMethod(this.url);
        return make(gm);
    }

    public static void setCookieStr(String cookieStr) {
        XCUrl.cookieStr = cookieStr;
        System.out.println("Cookie================\n" + XCUrl.cookieStr);
    }

    public String getCookie() {
        return StringUtils.join(hc.getState().getCookies(), ';');
    }

    public byte[] post(NameValuePair[] data) throws AppException {
        PostMethod pm = new PostMethod(this.url);
        pm.setRequestBody(data);
        return make(pm);
    }

    protected byte[] make(HttpMethod method) throws AppException {
        method.setRequestHeader(CoreProtocolPNames.USER_AGENT,
                "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.120 Safari/537.36");
        method.setRequestHeader("Cookie", cookieStr);
        method.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");

        try {
            HttpClient hc = new HttpClient();
            if (hc.executeMethod(method) != HttpStatus.SC_OK) {
                throw new AppException("Network is not working!");
            }

            this.hc = hc;
            return method.getResponseBody();
        } catch (IOException e) {
            throw new AppException("Network is not working!");
        }
    }

    //Inner class for UTF-8 support
    public static class UTF8PostMethod extends PostMethod {
        public UTF8PostMethod(String url) {
            super(url);
        }

        @Override
        public String getRequestCharSet() {
            //return super.getRequestCharSet();
            return "UTF-8";
        }
    }
}
