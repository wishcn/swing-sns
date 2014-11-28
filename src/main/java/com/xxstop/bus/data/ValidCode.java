package com.xxstop.bus.data;

import com.xxstop.exception.AppException;
import com.xxstop.util.XCUrl;

import javax.swing.*;

/**
 * Created by xxstop on 2014/9/24.
 */
public class ValidCode {
    public ImageIcon get() throws AppException {
        XCUrl curl = new XCUrl("http://www.96096kp.com/ValidateCode.aspx");
        byte[] response = curl.get();
        return new ImageIcon(response);
    }
}
