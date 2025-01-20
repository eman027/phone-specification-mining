package com.sample.steps;

import com.sample.pages.SearchPage;
import com.sample.ui.WebDriverSession;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchSteps {

    public static void searchFor(String strText) {
        WebDriverWait wait = new WebDriverWait(WebDriverSession.getWebDriverSession(), 20);
        SearchPage searchPage = new SearchPage();
        System.out.println("Start search for " + strText);
        searchPage.googleSearchBox.sendKeys(strText);
        System.out.println("Click on search button.");
        //searchPage.googleSearchButton.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(searchPage.googleSearchButton));
        searchPage.googleSearchButton.click();
    }

}
