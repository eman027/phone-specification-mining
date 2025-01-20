package com.sample.steps.gsm;

import com.sample.pages.gsm.NavPage;
import com.sample.ui.WebDriverSession;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavSteps {

    public static void navigate() {
        WebDriverWait wait = new WebDriverWait(WebDriverSession.getWebDriverSession(), 20);
        NavPage navPage = new NavPage();

        System.out.println("Start: Check results record:");
        System.out.println(navPage);

        navPage.samsung.click();
    }
}
