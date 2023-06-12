package org.example.allpages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {
    private WebDriver driver;
    //локатор логотипа Яндекса
    private final By logoYa = By.className("Header_LogoYandex__3TSOI");
    //локатор логотипа Саммокат
    private final By logoSamokat=By.className("Header_LogoScooter__3lsAR");
    //локатор кнопка "Заказать"
    private final By buttonOrderinAtTheTop = By.className("Button_Button__ra12g");
    //локатор кнопки "Статус Заказа"
    private final By statusButton = By.className("Header_Link__1TAG7");
    //локатор кнопки "Заказать" посередине страницы
    private final By buttonOrderAtMiddle=By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");
    //Массив локаторов вопросов
    public static final String[] questionButtons = new String[]{
            "accordion__heading-0",
            "accordion__heading-1",
            "accordion__heading-2",
            "accordion__heading-3",
            "accordion__heading-4",
            "accordion__heading-5",
            "accordion__heading-6",
            "accordion__heading-7"};
    //Массив локаторов ответов
    public static final String[]  answerToTheQuesrions = new String[]{
            "accordion__panel-0",
            "accordion__panel-1",
            "accordion__panel-2",
            "accordion__panel-3",
            "accordion__panel-4",
            "accordion__panel-5",
            "accordion__panel-6",
            "accordion__panel-7"};

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickLogoYandex() {
        driver.findElement(logoYa).click();
    }

    public void clickLogoSamokat() {
        driver.findElement(logoSamokat).click();
    }

    public void clickOrderButton() {
        driver.findElement(buttonOrderinAtTheTop).click();
    }

    public void clickStatusButton() {
        driver.findElement(statusButton).click();
    }

    public void clickButtonOrderAtMiddle() {
        driver.findElement(buttonOrderAtMiddle).click();
    }

    public void scrollToPushOrderButton() {
        WebElement element = driver.findElement(buttonOrderAtMiddle);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void scrollPageToQuestions(){
        WebElement lastQuestionArrow = driver.findElement(By.id(questionButtons[7]));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lastQuestionArrow);
    }
    public void clickOnButtonQuestion(String questionButton){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(By.id(questionButton)));
        driver.findElement(By.id(questionButton)).click();

    }


}
