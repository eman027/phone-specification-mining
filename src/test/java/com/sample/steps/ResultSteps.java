package com.sample.steps;

import com.sample.pages.ResultPage;
import com.sample.ui.Checkpoints;
import com.sample.ui.WebDriverSession;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class ResultSteps {
    public static void checkResults() {
        ResultPage resultPage = new ResultPage();
        SoftAssert softAssert = new SoftAssert();

        System.out.println("Start: Check results record:");
        System.out.println(resultPage.tabAll.isDisplayed());
        softAssert.assertTrue(Checkpoints.elementDisplay(resultPage.tabAll));
        softAssert.assertTrue(Checkpoints.elementDisplay(resultPage.tabVideos));
        softAssert.assertTrue(Checkpoints.elementDisplay(resultPage.tabImages));
        softAssert.assertTrue(Checkpoints.elementDisplay(resultPage.tabNews));
        softAssert.assertAll();
    }
}
