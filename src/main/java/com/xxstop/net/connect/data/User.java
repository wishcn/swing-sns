package com.xxstop.net.connect.data;

import com.xxstop.exception.AppException;
import com.xxstop.util.XCUrl;
import com.xxstop.util.XString;
import org.apache.commons.httpclient.NameValuePair;

import java.io.IOException;

/**
 * Created by xxstop on 2014/11/13.
 */
public class User {
    protected static boolean logined = false;

    public static boolean isLogined() {
        return logined;
    }

    public static void setLogined(boolean logined) {
        User.logined = logined;
    }

    public void login(String username, String password) throws AppException {
        NameValuePair[] nvp = {
                new NameValuePair("username", username),
                new NameValuePair("pwd", password),
                new NameValuePair("savepwd", "on"),
                new NameValuePair("mode", "login"),
                new NameValuePair("gaenable", "0"),
                new NameValuePair("userhomepage", ""),
                new NameValuePair("host", ""),
                new NameValuePair("mac", ""),
        };

        try {
            XCUrl xcUrl = new XCUrl("http://10.10.10.5:8002/index.php");
            byte[] bytes = xcUrl.post(nvp);
            String result = XString.b2(bytes);
            System.out.println("=====================login result====================\n"
                    + result);
            if (!result.equals("<script type='text/javascript'>window.location='http://10.10.10.5:8002/useratte/alive.php?user="+username+"&mac='</script>")) {
                throw new AppException("login failed!");
            }
        } catch (IOException e) {
            throw new AppException("Failed to convert string!");
        }

    }
}
