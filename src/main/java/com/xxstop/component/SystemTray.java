package com.xxstop.component;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/**
 * Created by xxstop on 2014/9/23.
 */
public class SystemTray {
    protected JFrame jFrame;
    public SystemTray(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    public void show() {
        if (java.awt.SystemTray.isSupported()) {// 判断系统是否托盘
            try {
                TrayIcon icon = new TrayIcon(ImageIO.read(getClass().getClassLoader().getResource("image/systemtray.png")));
                PopupMenu menu = new PopupMenu();// 创建弹出菜单
                MenuItem item = new MenuItem("Exit");// 创建一个菜单项
                item.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
                menu.add(item);// 将菜单项添加到菜单列表
                icon.setPopupMenu(menu);// 将菜单添加到托盘图标
                icon.setImageAutoSize(true);
                java.awt.SystemTray tray = java.awt.SystemTray.getSystemTray();// 获取系统托盘
                tray.add(icon);// 将托盘图表添加到系统托盘
                icon.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() == 1) {
                            jFrame.setExtendedState(Frame.NORMAL);
                        }
                        jFrame.setVisible(true);
                    }
                });

                jFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowIconified(WindowEvent e) {
                        jFrame.dispose();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }
    }
}
