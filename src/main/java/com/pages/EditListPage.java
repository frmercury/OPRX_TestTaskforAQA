package com.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EditListPage extends BasePage{

    public EditListPage(WebDriver driver) {
        super(driver);
    }

    protected Logger log = LoggerFactory.getLogger(EditListPage.class);

    private final By taskListTitle = (By.xpath("//input[@name = 'title']"));
    private final By taskListTextArea = (By.xpath("//textarea"));
    private final By submitButton = (By.xpath("//input[@type = 'submit']"));

    private String changedTestList = "First task \nSecond Task \nThird Task\n4th Task";

    private String testTitle = "Test Task List";

    public String getTestTitle() {
        return testTitle;
    }

    @Step("Edit title")
    public EditListPage editTitle() {
        driver.findElement(taskListTitle).clear();
        driver.findElement(taskListTitle).sendKeys(testTitle);
        log.info("Test title entered");
        return this;
    }

    @Step("Edit task list")
    public EditListPage editTaskList() {
        driver.findElement(taskListTextArea).clear();
        driver.findElement(taskListTextArea).sendKeys(changedTestList);
        log.info("Test list entered");
        return this;
    }
    @Step("Click at Submit button")
    public TaskPage clickAtSubmitButton() {
        driver.findElement(submitButton).click();
        log.info("Click at Submit button");
        return new TaskPage(driver);
    }
}
