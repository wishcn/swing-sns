package com.xxstop.util;

import javax.swing.*;

/**
 * Created by xxstop on 2014/9/23.
 */
public class XMessage {
    public static void success(JLabel tips, String message) {
        tips.setText(message);
    }

    public static void error(JLabel tips, String message) {
        tips.setText(message);
    }

    public static void clear(JLabel tips) {
        tips.setText(" ");
    }
}
