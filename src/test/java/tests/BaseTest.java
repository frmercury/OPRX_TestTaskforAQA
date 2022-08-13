package tests;



import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;

import com.WebDriverManagerClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;
import static com.helpers.Loader.loadProperty;


public class BaseTest {

    protected static WebDriver driver;

    protected Logger log = LoggerFactory.getLogger("Test logger");

    @BeforeSuite(alwaysRun = true, description = "Driver initialization")

    public void initProps() {
        browser = loadProperty("browser");
        baseUrl = loadProperty("app.url");
    }

    @BeforeTest(alwaysRun = true, description = "Browser session creation")
    protected void initWebDriver() {
        driver = WebDriverManagerClass.getWebDriver();
        log.info("Browser is opened");
    }

//    @AfterTest(alwaysRun = true, description = "End browser session")
//    public void closeWebBrowser() {
//        log.info("Browser is closed");
//        driver.quit();
//    }
}