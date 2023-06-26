package org.example.allpages;

import org.openqa.selenium.*;

public class OrderPage {
    private WebDriver driver;
    //Локатор поля ввода имени
    private By firstName = By.xpath(".//input[@placeholder='* Имя']");
    //Локатор поля ввода фамилии
    private By lastName = By.xpath(".//input[@placeholder='* Фамилия']");
    //Локатор поля ввода адреса
    private By deliveryAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Локатор поля ввода станции метро
    private By deliveryMetroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    //Локатор списка станций метро
    private  By selectMetroStation = By.xpath(".//*[@class='Order_SelectOption__82bhS select-search__option' and @value='8']");
    //Локатор поля ввода телефона
    private By phoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Локатор кнопки "Далее"
    private By nextButton = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Ввод имени
    public void inputFirstName(String firstNameClient) {
        driver.findElement(firstName).sendKeys(firstNameClient);
    }

    //Ввод фамилии
    public void inputLastName(String lastNameClient) {
        driver.findElement(lastName).sendKeys(lastNameClient);
    }

    //Ввод адреса
    public void inputDeliveryAddress(String deliveryAddressClient) {
        driver.findElement(deliveryAddress).sendKeys(deliveryAddressClient);
    }

    //Выбор станциии метро
    public void choiceDeliveryMetroStation() {
        driver.findElement(deliveryMetroStation).click();
        driver.findElement(selectMetroStation).click();
    }

    //Ввод телефона
    public void inputPhoneNumber(String phoneNumberClient) {
        driver.findElement(phoneNumber).sendKeys(phoneNumberClient);
    }

    //Нажатие на кнопку "Далее"
    public void pushNextButton() {
        driver.findElement(nextButton).click();
    }

    //Метод для заказа
    public void order(String firstNameClient, String lastNameClient, String deliveryAddressClient, String phoneNumberClient) {
        inputFirstName(firstNameClient);
        inputLastName(lastNameClient);
        inputDeliveryAddress(deliveryAddressClient);
        choiceDeliveryMetroStation();
        inputPhoneNumber(phoneNumberClient);
        pushNextButton();
    }
}