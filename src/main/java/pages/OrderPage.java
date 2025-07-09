package pages;

import org.openqa.selenium.*;

public class OrderPage extends BasePage{

    public OrderPage(WebDriver driver) {
        super(driver);
    }

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
    //Кнопка заказать
    public static By buttonOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    //Кнопка подтверждения заказа
    public static By buttonYes = By.xpath(".//button[text()='Да']");
    //Форма "Заказ оформлен"
    public static By orderForm = By.xpath(".//button[text()='Посмотреть статус']");
    //Выбрать срок на двое суток
    private static final By twoDaysRent = By.xpath(".//div[text()='двое суток']");
    //Выбрать срок на трое суток
    private static final By threeDaysRent = By.xpath(".//div[text()='трое суток']");

    public static Object[][] getDaysRent() {
        return new Object[][] {
                {twoDaysRent},
                {threeDaysRent}
        };
    }

    public void makeAnOrder(String name, String secondName, String address, String phoneNumber, String dateOfDelivery, By orderButton, int numberOfStation, By numberOfRentalDays) {
        scrollToElement(orderButton);
        waitForVisibility(orderButton);
        search(orderButton).click();
        waitForVisibility(OrderPage.nameField);
        search(OrderPage.nameField).sendKeys(name);
        search(OrderPage.secondNameField).sendKeys(secondName);
        search(OrderPage.addressField).sendKeys(address);
        search(OrderPage.stationField).click();
        choiseStation(numberOfStation);
        search(OrderPage.stationField).sendKeys(Keys.ENTER);
        search(OrderPage.phoneField).sendKeys(phoneNumber);
        search(OrderPage.buttonNext).click();
        search(OrderPage.dateField).sendKeys(dateOfDelivery);
        search(OrderPage.dateField).sendKeys(Keys.ENTER);
        search(OrderPage.rentField).click();
        search(numberOfRentalDays).click();
        search(OrderPage.buttonOrder).click();
        search(OrderPage.buttonYes).click();
    }

    public void choiseStation (int numberOfStation){
        for (int i = 0; i < numberOfStation; i++) {
            search(OrderPage.stationField).sendKeys(Keys.ARROW_DOWN);
        }
    }

    public boolean isOrderFormDisplayed() {
        return driver.findElement(orderForm).isDisplayed();
    }

}