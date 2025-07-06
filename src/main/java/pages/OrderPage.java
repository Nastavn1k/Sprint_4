package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {

    WebDriver driver;

    //Ввести имя
    public static By nameField = By.cssSelector("input[placeholder='* Имя']");
    //Ввести фамилию
    public static By secondNameField = By.cssSelector("input[placeholder='* Фамилия']");
    //Ввести адрес
    public static By addressField = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    //Ввести название станции метро
    public static By stationField = By.cssSelector("input[placeholder='* Станция метро']");
    //Ввести номер телефона
    public static By phoneField = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка далее
    public static By buttonNext = By.xpath(".//button[text()='Далее']");
    //Выбрать дату доставки
    public static By dateField = By.cssSelector("input[placeholder='* Когда привезти самокат']");
    //Выбрать срок аренды
    public static By rentField = By.cssSelector("[class='Dropdown-placeholder']");
    //Выбрать срок на двое суток
    public static By twoDaysRent = By.xpath(".//div[text()='двое суток']");
    //Выбрать срок на трое суток
    public static By threeDaysRent = By.xpath(".//div[text()='трое суток']");
    //Кнопка заказать
    public static By buttonOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    //Кнопка подтверждения заказа
    public static By buttonYes = By.xpath(".//button[text()='Да']");
    //Форма "Заказ оформлен"
    public static By orderForm = By.cssSelector("[class='Order_Text__2broi']");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

}