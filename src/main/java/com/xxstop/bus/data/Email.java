package com.xxstop.bus.data;

import com.xxstop.exception.AppException;
import com.xxstop.util.MailSenderInfo;
import com.xxstop.util.MailUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xxstop on 2014/9/22.
 */
public class Email {
    public boolean send(String receive, String content) throws AppException {
        MailSenderInfo msInfo = new MailSenderInfo();
        List<String> toAddress = new ArrayList<String>();

        toAddress.add(receive);
        msInfo.setMailServerHost("smtp.126.com");
        msInfo.setMailServerPort("25"); // 465/994
        msInfo.setValidate(true);
        msInfo.setFromAddress("xxstop@126.com");
        msInfo.setToAddress(toAddress);
        msInfo.setUserName("xxstop@126.com");
        msInfo.setPassword("8023xx");
        msInfo.setSubject("Ticket");
        msInfo.setContent(content);

        MailUtils mailUtils = new MailUtils(msInfo);
        if (!mailUtils.sendHtmlEmail()) {
            throw new AppException("Email not send!");
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            new Email().send("13648385235@qq.com","[Date:2014-09-25]-[Station:重庆汽车站]-[Dst:骝马]-[Time:12:40]<br />[Date:2014-09-25]-[Station:陈家坪汽车站]-[Dst:骝马]-[Time:13:10]");
        } catch (AppException e) {
            e.printStackTrace();
        }
    }
}
