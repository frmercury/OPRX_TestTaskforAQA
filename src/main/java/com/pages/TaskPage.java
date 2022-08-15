package com.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class TaskPage extends BasePage {

    protected Logger log = LoggerFactory.getLogger(TaskPage.class);

    public TaskPage(WebDriver driver) {
        super(driver);
    }

    EditListPage editListPage = new EditListPage(driver);

    private final By taskTable = (By.xpath("//table[@id = 'tasktable']"));
    private final By listOfToDo = (By.xpath("//table[@id = 'tasktable']//tr"));
    private final By checkBoxes = (By.xpath("//table[@id = 'tasktable']//input"));
    private final By title = (By.xpath("//*[@id = 'headline']"));
    private final By editListButton = (By.xpath("//a[text() = 'Edit']"));

    public static int initialListSize;

    @Step("Edit previously created ToDo list")
    public EditListPage clickEditButton() {
        getListOfToDo();
        step("Click on Edit button");
        driver.findElement(editListButton).click();
        return new EditListPage(driver);
    }

    @Step("Check if the changes have been applied")
    public TaskPage checkEditing() {

        assertThat(driver.findElement(taskTable).isDisplayed());
        step("Title should be changed");
        assertThat(driver.findElement(title).getText().replace(" Edit", "")).isEqualTo(editListPage.getTestTitle());
        log.info("Title has been changed");
        step("ToDo List should be changed");
        assertThat(driver.findElements(listOfToDo).size()).isNotEqualTo(initialListSize);
        log.info("ToDo List has been changed");
        return this;
    }

    private int getListOfToDo(){
        initialListSize = driver.findElements(listOfToDo).size();
        return initialListSize;
    }

    @Step("Checkbox status check")
    public TaskPage checkBoxStatusCheck() {
        checkToDoBox(getCheckBoxStatus());
        return this;
    }

    @Step("Change random checkbox status")
    public void checkToDoBox(List<WebElement> list) {
        Random rnd = new Random();
        WebElement randomCheckBox = list.get(rnd.nextInt(list.size()));
        step("Click random checkbox");
        randomCheckBox.click();
        log.info("Click random checkbox");
        assertThat(randomCheckBox.getAttribute("style")).isEqualTo("display: none;");
        log.info("Checkbox status has changed successfully");
    }

    @Step("Get ToDo checkboxes")
    private List<WebElement> getCheckBoxStatus (){
        int listSize = driver.findElements(listOfToDo).size();
        log.info(String.format("We have %s todo tasks", listSize));
        return driver.findElements(checkBoxes);
    }

    @Step("List of tasks should be created")
    public TaskPage taskListIsCreated(){
        assertThat(driver.findElement(taskTable).isDisplayed());
        log.info("Task list is created successfully");
        return this;
    }
}