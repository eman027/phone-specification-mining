package com.sample.tests;

import com.sample.steps.ResultSteps;
import com.sample.steps.SearchSteps;
import com.sample.ui.WebDriverSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class Example_SimpleTest {


    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws IOException {
        WebDriverSteps nav = new WebDriverSteps();
        nav.navigateToApplication("GOOGLE");
    }

    @Test(groups = {"AllTests","Test1","Smoke"})
    public void testGoogleSearch(){
        SearchSteps.searchFor("Test");
        ResultSteps.checkResults();
    }
}
