package com.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class CreateListPage extends BasePage {

    protected Logger log = LoggerFactory.getLogger(CreateListPage.class);

    public CreateListPage(WebDriver driver) {
        super(driver);
    }

    private final By taskListTextArea = (By.xpath("//textarea"));
    private final By saveTasksButton = (By.xpath("//input[@type = 'submit']"));


//    Test data
    private String testList = "First task \nSecond Task \nThird Task";


    @Step("Create new ToDo list")
    public TaskPage createTaskList() {
        step("Fill up test task list");
        driver.findElement(taskListTextArea).sendKeys(testList);
        step("Press Submit button");
        driver.findElement(saveTasksButton).click();
        log.info("Creation of list submitted");
        return new TaskPage(driver);
    }

    public CreateListPage createPageIsOpened(){
        assertThat(driver.findElement(taskListTextArea).isDisplayed());
        log.info("List creation page is opened successfully");
        return this;
    }
}