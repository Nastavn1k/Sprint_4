package pages;

import org.openqa.selenium.*;

public class OrderPage extends BasePage{

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    //Ввести имя
    private static final By nameField = By.cssSelector("input[placeholder='* Имя']");
    //Ввести фамилию
    private static final By secondNameField = By.cssSelector("input[placeholder='* Фамилия']");
    //Ввести адрес
    private static final By addressField = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    //Ввести название станции метро
    private static final By stationField = By.cssSelector("input[placeholder='* Станция метро']");
    //Ввести номер телефона
    private static final By phoneField = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка далее
    private static final By buttonNext = By.xpath(".//button[text()='Далее']");
    //Выбрать дату доставки
    private static final By dateField = By.cssSelector("input[placeholder='* Когда привезти самокат']");
    //Выбрать срок аренды
    private static final By rentField = By.cssSelector("[class='Dropdown-placeholder']");
    //Кнопка заказать
    private static final By buttonOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    //Кнопка подтверждения заказа
    private static final By buttonYes = By.xpath(".//button[text()='Да']");
    //Форма "Заказ оформлен"
    private static final By orderForm = By.xpath(".//button[text()='Посмотреть статус']");

    public void makeAnOrder(String name, String secondName, String address, String phoneNumber, String dateOfDelivery, String orderButtonPosition, int numberOfStation, String numberOfRentalDays) {
        By orderButtonLocator;
        if (orderButtonPosition.equals("up")) {
            orderButtonLocator = MainPage.orderButtonUp;
        }   else if (orderButtonPosition.equals("down")) {
            orderButtonLocator = MainPage.orderButtonDown;
        } else {
            throw new IllegalArgumentException("Неизвестное положение кнопки заказа: " + orderButtonPosition);
        }
        scrollToElement(orderButtonLocator);
        waitForVisibility(orderButtonLocator);
        search(orderButtonLocator).click();
        waitForVisibility(nameField);
        search(nameField).sendKeys(name);
        search(secondNameField).sendKeys(secondName);
        search(addressField).sendKeys(address);
        search(stationField).click();
        choiseStation(numberOfStation);
        search(stationField).sendKeys(Keys.ENTER);
        search(phoneField).sendKeys(phoneNumber);
        search(buttonNext).click();
        search(dateField).sendKeys(dateOfDelivery);
        search(dateField).sendKeys(Keys.ENTER);
        search(rentField).click();
        choiceRentPeriod(numberOfRentalDays);
        search(buttonOrder).click();
        search(buttonYes).click();
    }

    public void choiseStation (int numberOfStation){
        for (int i = 0; i < numberOfStation; i++) {
            search(stationField).sendKeys(Keys.ARROW_DOWN);
        }
    }

    public boolean isOrderFormDisplayed() {
        return driver.findElement(orderForm).isDisplayed();
    }

    public void choiceRentPeriod (String rentPeriod) {
        String rentPeriodPattern = ".//div[@class='Dropdown-option' and text()='%s']";
        search(By.xpath(String.format(rentPeriodPattern, rentPeriod))).click();
    }

}