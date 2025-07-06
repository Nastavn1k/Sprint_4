package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    WebDriver driver;

    //Выпадающий список "Вопросы о важном"
    //Сколько это стоит? И как оплатить?
    public static By dropListHowMuchCost = By.xpath(".//div[text()='Сколько это стоит? И как оплатить?']");
    //Ответ насчет стоимости
    public static By howMuchCostAnswer = By.xpath(".//p[text()='Сутки — 400 рублей. Оплата курьеру — наличными или картой.']");
    //Хочу сразу несколько самокатов! Так можно?
    public static By dropListWantFewScooters = By.xpath(".//div[text()='Хочу сразу несколько самокатов! Так можно?']");
    //Ответ насчет нескольких самокатов
    public static By wantFewScootersAnswer = By.xpath(".//p[contains(text(),'Пока что у нас так: один заказ — один самокат.')]");
    //Как рассчитывается время аренды?
    public static By dropListRentalTimeCalculated = By.xpath(".//div[text()='Как рассчитывается время аренды?']");
    //Ответ насчет времени аренды
    public static By rentalTimeCalculatedAnswer = By.xpath(".//p[contains(text(),'Допустим, вы оформляете заказ на 8 мая.')]");
    //Можно ли заказать самокат прямо на сегодня?
    public static By dropListOrderScooterToday = By.xpath(".//div[text()='Можно ли заказать самокат прямо на сегодня?']");
    //Ответ насчет заказа на сегодня
    public static By orderScooterTodayAnswer = By.xpath(".//p[text()='Только начиная с завтрашнего дня. Но скоро станем расторопнее.']");
    //Можно ли продлить заказ или вернуть самокат раньше?
    public static By dropListExtendOrder = By.xpath(".//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']");
    //Ответ насчет продления заказа
    public static By extendOrderAnswer = By.xpath(".//p[text()='Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.']");
    //Вы привозите зарядку вместе с самокатом?
    public static By dropListChargerWithScooter = By.xpath(".//div[text()='Вы привозите зарядку вместе с самокатом?']");
    //Ответ начет зарядки
    public static By chargerWithScooterAnswer = By.xpath(".//p[contains(text(),'Самокат приезжает к вам с полной зарядкой.')]");
    //Можно ли отменить заказ?
    public static By dropListCancelingOrder = By.xpath(".//div[text()='Можно ли отменить заказ?']");
    //Ответ насчет отмены заказа
    public static By cancelingOrderAnswer = By.xpath(".//p[contains(text(),'Да, пока самокат не привезли. Штрафа не будет')]");
    //Я живу за МКАДом, привезёте?
    public static By dropListFarAway = By.xpath(".//div[text()='Я жизу за МКАДом, привезёте?']");
    //Ответ доставки за МКАД
    public static By farAwayAnswer = By.xpath(".//p[text()='Да, обязательно. Всем самокатов! И Москве, и Московской области.']");
    //Надпись внизу сайта "Вопросы о важном"
    public static By titleQuestions = By.xpath(".//div[@class='Home_SubHeader__zwi_E' and text()='Вопросы о важном']");
    //Кнопка заказать расположенная вверху страницы
    public static By orderButtonUp = By.xpath("/html/body/div/div/div/div/div/button[@class='Button_Button__ra12g' and text()='Заказать']");
    //Кнопка заказать расположенная внизу страницы
    public static By orderButtonDown = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    public MainPage (WebDriver driver){
        this.driver = driver;
    }

    public WebElement waitForVisibility(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForVisibility() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[src='/assets/blueprint.png']")));
    }

    public WebElement scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        return element;
    }

    public WebElement search (By nameLocator) {
        return driver.findElement(nameLocator);
    }

    public void openPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        waitForVisibility();
    }

    public void openDropList(By question, By answer) {
        waitForVisibility(question);
        scrollToElement(titleQuestions);
        waitForVisibility(question);
        search(question).click();
        waitForVisibility(answer);
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
}
