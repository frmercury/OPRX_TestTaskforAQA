package tests.ui.BasicFuncTest;

import com.pages.MainPage;
import com.pages.TaskPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Configuration.baseUrl;
import static java.lang.Thread.sleep;

public class SmokeTest extends BaseTest {

    protected Logger log = LoggerFactory.getLogger(SmokeTest.class);

    @Test
    public void firstTest() throws InterruptedException {
        log.info("Open main page");
        new MainPage(driver)
                .openMainPage()
                .clickCreateYourDailyTodolistButton();
        new TaskPage(driver)
                .createTaskList()
                .editTaskList();
    }
}
