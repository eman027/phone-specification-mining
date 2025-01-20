package com.sample.ui;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverOptionsProfile {
    public static ChromeOptions chromeOptionsProfiles(String profileName) {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("disable-infobars");
        options.addArguments("start-maximized");
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        options.setAcceptInsecureCerts(true);

        switch (profileName) {
            case "NA":
                return new ChromeOptions();

            default:
                return options;
        }
    }
}
