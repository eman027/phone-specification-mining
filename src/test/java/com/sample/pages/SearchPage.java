package com.sample.pages;

import com.sample.ui.WebDriverSession;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends WebDriverSession {

    public SearchPage() {
        PageFactory.initElements(getWebDriverSession(),this);
    }

    @FindBy(xpath = "//input[@name='q']")
    public WebElement googleSearchBox;

    @FindBy(xpath = "//div[@jsname='VlcLAe']//input[@value='Google Search']")
    public WebElement googleSearchButton;
}
