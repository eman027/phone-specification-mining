package com.sample.pages;

import com.sample.ui.WebDriverSession;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage extends WebDriverSession {
    public ResultPage () {
        PageFactory.initElements(getWebDriverSession(),this);
    }

    @FindBy(xpath = "//div[contains(text(),'All')]")
    public WebElement tabAll;

    @FindBy(xpath = "//a[contains(text(),'Videos')]")
    public WebElement tabVideos;

    @FindBy(xpath = "//a[contains(text(),'Images')]")
    public WebElement tabImages;

    @FindBy(xpath = "//a[contains(text(),'News')]")
    public WebElement tabNews;

}
