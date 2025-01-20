package com.sample.pages.gsm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.sample.ui.WebDriverSession.getWebDriverSession;

public class PhonePage {


    public PhonePage() {
        PageFactory.initElements(getWebDriverSession(),this);
    }

    @FindBy(xpath = "//a[@href='samsung-phones-9.php']")
    public WebElement samsung;
    //*[@id="review-body"]/div[1]/ul/li[1]/a
}
