package com.sample.ui;

import com.sample.utils.SystemProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;

public class WebDriverSession {

    static WebDriver webDriver = null;
    protected static HashMap<Long, WebDriver> map =new HashMap<>();

    public static WebDriver getWebDriverSession(){
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\emman\\Downloads\\chromedriver_win32\\chromedriver.exe");
//        return new ChromeDriver();
        WebDriver toReturn = map.get(Thread.currentThread().getId());
        if (toReturn == null){
            loadNewWebDriverSession();
            toReturn = map.get(Thread.currentThread().getId());
        }
        return toReturn;
    }

    private static void loadNewWebDriverSession() {
        WebDriver webDriver = null;
        String browserType = SystemProperties.BROWSER;

        System.out.println("Browser to be utilized: " + browserType);
        try {
            switch (browserType) {
                case "CHROME":
                    System.getenv();
                    System.setProperty("webdriver.chrome.driver", SystemProperties.CHROME_WEBDRIVER);
                    ChromeOptions chromeOption = WebDriverOptionsProfile.chromeOptionsProfiles(SystemProperties.BROWSER_OPTIONS);

                    if (!SystemProperties.REMOTE) {
                        webDriver = new ChromeDriver(chromeOption);
                        webDriver.manage().deleteAllCookies();
                    }
                    break;
                default:
                    throw new UnsupportedOperationException("Browser not supported");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (webDriver == null) {
            throw new UnsupportedOperationException("webDriver is null");
        } else {
            webDriver.manage().window().maximize();
            webDriver.manage().deleteAllCookies();
            map.put(Thread.currentThread().getId(), webDriver);
        }
    }
}
