package com.xxstop.bus.data;

import com.xxstop.exception.AppException;
import com.xxstop.util.XCUrl;
import com.xxstop.util.XJson;
import com.xxstop.util.XString;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by xxstop on 2014/9/21.
 */
public class Ticket {
    public ArrayList query() throws AppException {
        String requestFile = "http://www.96096kp.com/UserData/MQCenterSale.aspx";
        try {
            NameValuePair[] data = {
                new NameValuePair("StartStation",""),
                new NameValuePair("WaitStationCode",""),
                new NameValuePair("OpStation","-1"),
                new NameValuePair("OpAddress", "-1"),
                new NameValuePair("SchDate", "2014-10-01"), //2014-10-01
                new NameValuePair("DstNode", "骝马"),
                new NameValuePair("SeatType", ""),
                new NameValuePair("SchTime", ""),
                new NameValuePair("OperMode", ""),
                new NameValuePair("SchCode", ""),
                new NameValuePair("txtImgCode", ""),
                new NameValuePair("cmd", "MQCenterGetClass"),
                new NameValuePair("isCheck", "false"),
            };
            byte[] result = new XCUrl(requestFile).post(data);
            String str = XString.b2(result);
            System.out.println(str);
            HashMap hm = XJson.decode(str);
            if (hm.get("success").toString().equals("false") ||
                    Integer.parseInt(hm.get("totalCount").toString()) < 1) {
                throw new AppException("Empty Query Results!");
            }
            return (ArrayList) hm.get("data");
        } catch (IOException e) {
            throw new AppException("Failed to convert string!");
        }
    }

    // TODO : 购买的逻辑
    public boolean buy(HashMap order) {
        /**
             __VIEWSTATE:/wEPDwUJMjE0NDU2OTUzD2QWAmYPZBYCAgMPFgIeBnRhcmdldAUGX2JsYW5rFgYCAQ8WAh4JaW5uZXJodG1sBfkBJm5ic3A7Jm5ic3A7PGEgdGFyZ2V0PSdfYmxhbmsnIGhyZWY9Jy4uL05ld3MuYXNweD9zaWduPTEwMDQ2Jz7ph43luobluILlhazot6/lrqLov5DllK7npajnvZHmmK/ph43luobluILlhazot6/lrqLov5DogZTnvZHllK7npajkuK3lv4PllK/kuIDlrpjmlrnnvZHnq5nvvIHmiKrmraLnm67liY3vvIzmnKrmjojmnYPlhbbku5bnvZHnq5nlvIDlsZXnsbvkvLzmnI3liqHlhoXlrrnvvIzmlazor7flub/lpKfml4XlrqLms6jmhI/jgII8L2E+ZAIDDw8WAh4EVGV4dAWFATxkaXYgc3R5bGU9Im1hcmdpbjowIGF1dG8iPgoJPGltZyBhbHQ9IiIgc3JjPSIvYWRtaW4vVXBsb2FkL2ltYWdlcy9CYW5uZXIvYmFubmVyMS5qcGciIHN0eWxlPSJ3aWR0aDogOTQycHg7IGhlaWdodDogMTkycHg7IiAvPjwvZGl2PgpkZAIFD2QWAgIBD2QWCGYPFgIeB1Zpc2libGVoFgICAQ8QZGQWAGQCBw8QDxYGHg1EYXRhVGV4dEZpZWxkBQhDb2RlTmFtZR4ORGF0YVZhbHVlRmllbGQFAklEHgtfIURhdGFCb3VuZGdkEBUDCei6q+S7veivgQnlo6vlrpjor4EG5oqk54WnFQMBMQUxMDAwMAUxMDAwMRQrAwNnZ2dkZAIPDxBkEBUCgwE8aW1nIGhlaWdodD0nMzAnIHdpZHRoPScxMTYnIHNyYz0nLi4vcmVzb3VyY2VzL2ltYWdlcy9VbmlvblBheUxvZ28ucG5nJyBhbHQ9J+mTtuiBlOWcqOe6v+aUr+S7mCcgc3R5bGU9J3ZlcnRpY2FsLWFsaWduOiBtaWRkbGU7JyAvPoABPGltZyBoZWlnaHQ9JzMwJyB3aWR0aD0nMTE2JyBzcmM9Jy4uL3Jlc291cmNlcy9pbWFnZXMvYWxpcGF5LmdpZicgYWx0PSfmlK/ku5jlrp3lnKjnur/mlK/ku5gnIHN0eWxlPSd2ZXJ0aWNhbC1hbGlnbjogbWlkZGxlOycgLz4VAiFPbmxpbmVVbmlvblBheSzpk7bogZTlnKjnur/mlK/ku5giT25saW5lQWxpUGF5LOaUr+S7mOWuneWcqOe6v+aUr+S7mBQrAwJnZ2RkAhQPFgIfA2hkZEHkyB7+ukcQnPjSYF1rp/vCCwDpt1MHUc+DW9PXiD6O
             __EVENTVALIDATION:/wEWDwKF5JTZDAKG4+POCQKR7f3HDgKB2/ucAwKBoPntBAKeoPntBALG0abZAQKXkYGVBQL7haJOAr/CjMgIAtWp7iACyLPN5gUCl6GX1QICnNqT5gMCgMbfyAUJRcFm98m5+Fx+btBUe2YiZ9MTK/uTzsMN9jHb6Ssf6g==
             ctl00$FartherMain$NavigationControl1$o_CustomerName:李明明
             ctl00$FartherMain$NavigationControl1$o_Mobele:13888888885
             ctl00$FartherMain$NavigationControl1$o_IdType:1
             ctl00$FartherMain$NavigationControl1$o_Email:
             ctl00$FartherMain$NavigationControl1$o_IdCard:410823198009107914
             ctl00$FartherMain$NavigationControl1$o_IdCardConfirm:410823198009107914
             ctl00$FartherMain$NavigationControl1$radioListPayType:OnlineAliPay,支付宝在线支付
             ctl00$FartherMain$NavigationControl1$ContactAddress:
             ctl00$FartherMain$NavigationControl1$o_Memo:
             ctl00$FartherMain$NavigationControl1$hideIsSubmit:true
         */
        return true;
    }

    public boolean order(HashMap hm) throws AppException {
        /**
            classInfo:{"SchDate":"2014-09-24","SchGlobalCode":"","SchLocalCode":"6860","SchLineName":"骝马","SchStationCode":"3001","SchStationName":"重庆汽车站","SchCompCode":"","SchCompName":"","SchBusBrand":"","SchBusBrandColor":"","SchTime":"12:40","SchWaitingRoom":"10","SchCheckGate":"10号","SchBerth":"","SchType":"配载","SchMode":"普通","SchDstCity":"","SchDstNode":"lma","SchOperType":"","SchFirstTime":"","SchLastTime":"","SchInterval":"0","SchNodeNameList":"资中,骝马","SchDist":"239.00","SchSeatCount":"29","SchPrice":"82.00","SchDiscPrice":"41.00","SchStdPrice":"82.00","SchFuel":"4.50","SchBusType":"中高一级","SchBusLevel":"","SchTicketCount":"29","SchChild":"2","SchStat":"1","SchPrintSeat":"1","Notes":"","SchNodeName":"骝马","SchNodeCode":"lma"}
            drBusStationCode:3001
            drBusStationName:重庆汽车站
            ticketHalfCount:0
            ticketFullCount:1
            ticketChildCount:0
            cmd:buyTicket
         */
        String requestFile = "http://www.96096kp.com/UserData/ShopCart.aspx";

        try {
            NameValuePair[] data = {
                new NameValuePair("classInfo", XJson.encode(hm)),
                new NameValuePair("drBusStationCode", hm.get("SchStationCode").toString()),
                new NameValuePair("drBusStationName", hm.get("SchStationName").toString()),
                new NameValuePair("ticketHalfCount", "0"),
                new NameValuePair("ticketFullCount", "1"),
                new NameValuePair("ticketChildCount", "0"),
                new NameValuePair("cmd", "buyTicket"),
            };
            byte[] result = new XCUrl(requestFile).post(data);
            String str = XString.b2(result);
            System.out.println(str);
            hm = XJson.decode(str);
            if (hm.get("success").toString().equals("false")) {
                throw new AppException(hm.get("msg").toString());
            }
            return true;
        } catch (IOException e) {
            throw new AppException("Failed to convert string!");
        }
    }

    public String toEmail(ArrayList list) {
        ArrayList result = new ArrayList();
        for (Object i : list) {
            ArrayList al = new ArrayList();
            HashMap vo = ((HashMap) i);
            al.add("[Date:" + vo.get("SchDate").toString() + "]");
            al.add("[Station:" + vo.get("SchStationName").toString() + "]");
            al.add("[Dst:" + vo.get("SchLineName") + "]");
            al.add("[Time:" + vo.get("SchTime").toString() + "]");
            result.add(StringUtils.join(al, "-"));
        }
        return StringUtils.join(result, "<br />");
    }

}
