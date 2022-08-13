package com.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebHelpers {

    long timeOut = 2L;

    WebElement findElement(WebDriver webDriver, By locator) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(timeOut)).until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
