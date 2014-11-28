package com.xxstop.bus.data;

import com.xxstop.exception.AppException;
import com.xxstop.util.XCUrl;
import com.xxstop.util.XJson;
import com.xxstop.util.XString;
import org.apache.commons.httpclient.NameValuePair;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by xxstop on 2014/9/19.
 */
public class User {

    protected static boolean logined = false;

    public boolean login(String userName, String password, String validCode) throws AppException {
        NameValuePair[] nvp = {
                new NameValuePair("loginID", userName),
                new NameValuePair("loginPwd", password),
                new NameValuePair("loginValid", validCode),
                new NameValuePair("cmd", "Login"),
        };

        try {
            XCUrl curl = new XCUrl("http://www.96096kp.com/UserData/UserCmd.aspx");
            byte[] result = curl.post(nvp);
            String str = XString.b2(result);
            System.out.println(str);
            HashMap hm = XJson.decode(str);
            if (hm.get("success").toString().equals("false")) {
                throw new AppException((String) hm.get("msg"));
            }
            return true;
        } catch (IOException e) {
            throw new AppException("Failed to convert string!");
        }

    }

    public HashMap getUser() {
        HashMap user = new HashMap();
        user.put("ctl00$FartherMain$NavigationControl1$o_CustomerName", "李明");
        return user;
    }

    public static boolean isLogined() {
        return logined;
    }

    public static void setLogined(boolean logined) {
        User.logined = logined;
    }
}
