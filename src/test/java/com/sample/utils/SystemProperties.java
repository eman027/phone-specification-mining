package com.sample.utils;

import com.google.common.io.Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class SystemProperties {

    private static Properties prop;

    private static Properties getProp() {
        if (prop == null) {
            prop = new Properties();
            InputStream input = null;

            try {
                input = new FileInputStream(new File(Resources.getResource("system.properties").toURI()));
                prop.load(input);
            } catch (Exception e) {
                e.printStackTrace();;
            }
        }

        return prop;
    }

    public static final Boolean REMOTE = new Boolean(getProp().getProperty("selenium.remote"));
    public static final String BROWSER = getProp().getProperty("selenium.browser");
    public static final String BROWSER_OPTIONS = getProp().getProperty("selenium.browser.option");
    public static final String CHROME_WEBDRIVER = getProp().getProperty("webdriver.chrome.driver");
    public static final String EXECUTION_ENVIRONMENT = getProp().getProperty("execution.environment");
}
