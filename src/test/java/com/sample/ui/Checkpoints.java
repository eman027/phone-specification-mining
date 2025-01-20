package com.sample.ui;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class Checkpoints {
    public static boolean elementDisplay(WebElement myElement) {
        try {
            myElement.isDisplayed();
            System.out.println("PASSED - element displayed " + myElement.getText());
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("FAILED - element NOT displayed");
            return false;
        }
    }
}
