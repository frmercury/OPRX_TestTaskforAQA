package com.pages;

import com.helpers.WebHelpers;
import org.openqa.selenium.WebDriver;

public class BasePage extends WebHelpers {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void cookiesDeletion() {
        driver.manage().deleteAllCookies();
    }

}