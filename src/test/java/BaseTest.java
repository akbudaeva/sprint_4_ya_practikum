import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;
public class BaseTest {
    protected WebDriver driver;
    // локатор для кнопки принятия куки
    private final By cookieButton = By.id("rcc-confirm-button");
    private final String URL = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void startUp() {
        driver = new SafariDriver();
        driver.get(URL);
        driver.findElement(cookieButton).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}
