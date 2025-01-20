package com.sample.tests;

import com.sample.steps.gsm.PhoneSteps;
import com.sample.ui.WebDriverSteps;
import org.testng.annotations.Test;

public class GsmArena {

    @Test
    public void testGoogleSearch() {
        //NavSteps.navigate();
        String phoneModel = "APPLE";
        WebDriverSteps nav = new WebDriverSteps();
        nav.navigateToApplication(phoneModel);
        PhoneSteps.clickPhone(nav, phoneModel);
    }
}
