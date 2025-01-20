package com.sample.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownActions {

    public static void selectByVisibleTest(WebElement dropWebElement, String optionVisibleText) {
        Select dropSelect = new Select(dropWebElement);
        dropSelect.selectByVisibleText(optionVisibleText);
    }

}
