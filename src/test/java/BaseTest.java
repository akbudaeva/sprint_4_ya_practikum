import org.example.allpages.MainPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;
public class BaseTest {
    protected WebDriver driver;

    @Before
    public void startUp() {
        driver = new SafariDriver();
        MainPage mainPage = new MainPage(driver);
        //driver.get(URL);
        mainPage.goToUrl();
        mainPage.clickCookieButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}
