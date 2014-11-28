package com.xxstop.util;


import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.File;

/**
 * Created by xxstop on 2014/11/18.
 */
public class XZdsoftConf {
    private static PropertiesConfiguration configuration = new PropertiesConfiguration();
    public void load(String xmPath) {
        try {
            String path = System.getProperty("user.home") + File.separatorChar + "zdsoft.properties";
            File file = new File(path);
            if (!file.exists()) {
                configuration = new PropertiesConfiguration();
                configuration.setFile(file);
                configuration.setProperty("username", "");
                configuration.setProperty("password", "");
                configuration.save();
            } else {
                configuration = new PropertiesConfiguration(path);
            }
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

    }

    public static String get(String key) {
        return configuration.getString(key);
    }

    public static void set(String key, String val) {
        configuration.setProperty(key, val);
        try {
            configuration.save();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }
}
