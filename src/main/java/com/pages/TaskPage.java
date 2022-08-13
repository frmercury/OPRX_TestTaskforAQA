package com.pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.helpers.WebHelpers;

import static org.assertj.core.api.Assertions.assertThat;


public class TaskPage extends BasePage {

    public TaskPage(WebDriver driver) {
        super(driver);
    }

    private final By taskTable = (By.xpath("//table[@id = 'tasktable']"));
    private final By createYourDailyTodolist = (By.xpath("//table[@id = 'tasktable']//input"));
    private final By taskListTitle = (By.xpath("//input[@name = 'title']"));
    private final By title = (By.xpath("//tr/td[1]"));
    private final By taskListTextArea = (By.xpath("//textarea"));
    private final By submitButton = (By.xpath("//input[@type = 'submit']"));
    private final By editTaskListButton = (By.xpath("//a[text() = 'Edit']"));


    String testText = "First task \nSecond Task \nThird Task";
    String changedText = "First task \nSecond Task \nThird Task\n4th Task";
    String titleText = "Test Task List";


    public TaskPage createTaskList() {


        driver.findElement(taskListTextArea).sendKeys(testText);
        driver.findElement(submitButton).click();
        assertThat(driver.findElement(taskTable).isDisplayed());

        return this;

    }

    public TaskPage editTaskList() {
        driver.findElement(editTaskListButton).click();
        driver.findElement(taskListTitle).clear();
        driver.findElement(taskListTitle).sendKeys(titleText);
        driver.findElement(taskListTextArea).sendKeys(changedText);
        driver.findElement(submitButton).click();

        assertThat(driver.findElement(taskTable).isDisplayed());
        assertThat(driver.findElement(title).getText()).isEqualTo(titleText);

        System.out.println();

        return this;
    }
}
