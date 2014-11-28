package com.xxstop.util;

import com.xxstop.exception.AppException;

import java.awt.*;
import java.net.URI;

/**
 * Created by xxstop on 2014/9/23.
 */
public class XDesktop {
    public static void openWebpage(String url) throws AppException {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                URI uri = new URI(url);
                desktop.browse(uri);
            } catch (Exception e) {
                throw new AppException(e.getMessage());
            }
        }
    }
}
