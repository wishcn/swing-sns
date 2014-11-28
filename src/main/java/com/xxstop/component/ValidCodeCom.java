package com.xxstop.component;

import com.xxstop.util.XMessage;

import javax.swing.*;

/**
 * Created by xxstop on 2014/9/24.
 */
public class ValidCodeCom {
    public void show(final JLabel tips) {
        XMessage.success(tips, "VC has changed!");
        Thread tr = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1000);
                    XMessage.clear(tips);
                    System.out.println("Text has removed!");
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        };
        tr.start();
    }
}
