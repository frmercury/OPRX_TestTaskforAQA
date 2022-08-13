package com.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.Assertion;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private final By createYourDailyTodolistButton = (By.xpath("//form[@id = 'start']/input"));

    public MainPage openMainPage () {
        driver.get(baseUrl);
        assertThat(baseUrl.equals(driver.getCurrentUrl())).as("Open Main page");
        return this;
    }

    public void clickCreateYourDailyTodolistButton () {
        driver.findElement(createYourDailyTodolistButton).click();
    }
}
