package tests.ui.BasicFuncTest;

import com.pages.MainPage;
import com.pages.TaskPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import tests.BaseTest;

public class SmokeTest extends BaseTest {

@Feature("Base functionality")

    @Story("Create new ToDoList")
    @Test(testName = "ToDo list creation", priority = 1)
    public void toDoListCreationTest() {

        new MainPage(driver)
                .openMainPage()
                .clickCreateTodolistButton()
                .createPageIsOpened()
                .createTaskList()
                .taskListIsCreated();
    }

    @Story("ToDo list edition")
    @Test(testName = "ToDo list edition", priority = 2)
    public void toDoListEditionTest() {

        new TaskPage(driver)
                .clickEditButton()
                .editTitle()
                .editTaskList()
                .clickAtSubmitButton()
                .checkEditing();
    }

    @Story("Checkbox status should be changed")
    @Test(testName = "Checkbox status modification", priority = 3)
    public void checkBoxModificationTest() {

        new TaskPage(driver)
                .checkBoxStatusCheck();
    }
}