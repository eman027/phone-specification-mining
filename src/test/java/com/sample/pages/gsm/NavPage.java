package com.sample.pages.gsm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.sample.ui.WebDriverSession.getWebDriverSession;

public class NavPage {
    public NavPage() {
        PageFactory.initElements(getWebDriverSession(),this);
    }

    @FindBy(xpath = "//a[@href='samsung-phones-9.php']")
    public WebElement samsung;
}
