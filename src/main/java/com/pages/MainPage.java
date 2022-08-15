package com.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Configuration.baseUrl;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MainPage extends BasePage {

    protected Logger log = LoggerFactory.getLogger(MainPage.class);

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private final By createTodolistButton = (By.xpath("//form[@id = 'start']/input"));


    @Step("Open main page")
    public MainPage openMainPage () {
        driver.get(baseUrl);
        assertThat(baseUrl.equals(driver.getCurrentUrl()));
        log.info("Main page is opened");
        return this;
    }

    @Step("Click on SubmitButton")
    public CreateListPage clickCreateTodolistButton() {
        driver.findElement(createTodolistButton).click();
        return new CreateListPage(driver);
    }


}
