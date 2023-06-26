package org.example.allpages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RentPage {
    private WebDriver driver;
    //локатор для поля начала аренды
    private  By startDateRent = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //локатор для поля срока аренды
    private  By periodRent = By.className("Dropdown-control");
    // Локатор списка срока аренды
    private  By selectPeriodRent = By.xpath(".//*[(@role ='option' and text()='трое суток')]");
    // Локатор цвета  "Черный жемчуг"
    private  By checkBoxColourBlackPearl = By.xpath(".//input[@id='black']");
    // Локатор цвета  "Серая безысходность"
    private  By checkBoxColourGreyDespair = By.xpath(".//input[@id='grey']");
    //локатор для поля комментарий
    private  By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //локатор для кнопки "Назад"
    private By previousButton = By.xpath("Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i");
    //локатор для кнопки "Заказать"
    private  By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Локатор для кнопки "Да"
    private By acceptOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    //Локатор для окна заказа
    private By orderWindow = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']");

    public RentPage(WebDriver driver) {
        this.driver = driver;
    }

    //Ввод даты начала аренды
    public void inputStartDateRent(String startDate) {
        driver.findElement(startDateRent).sendKeys(startDate);
        driver.findElement(startDateRent).sendKeys(Keys.ENTER);
    }

    //Выбор срока аренды
    public void choicePeriodRent() {
        driver.findElement(periodRent).click();
        driver.findElement(selectPeriodRent).click();
    }

    //Выбор цвета "Черный жемчуг"
    public void choiceColourBlack() {
        driver.findElement(checkBoxColourBlackPearl).click();
    }

    //Выбор цвета "Серая безысходность"
    public void choiceColourGrey() {
        driver.findElement(checkBoxColourGreyDespair).click();
    }

    //Ввод комментария
    public void inputComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    //клик "нажать"
    public void pushPreviousButton() {
        driver.findElement(previousButton).click();
    }

    //клик "Заказать"
    public void pushOrderButton() {
        driver.findElement(orderButton).click();
    }

    //клик "Да"
    public void pushAcceptOrderButton() {
        driver.findElement(acceptOrderButton).click();
    }

    //Проверка видно ли всплывающие окно
    public boolean checkOrderWindow() {
        return driver.findElement(orderWindow).isEnabled();
    }

    //Заказ самоката
    public void rent(String startDate, String comment) {
        inputStartDateRent(startDate);
        choicePeriodRent();
        choiceColourGrey();
        inputComment(comment);
        pushOrderButton();
        pushAcceptOrderButton();
    }
}

