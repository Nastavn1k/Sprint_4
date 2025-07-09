package pages;

import org.openqa.selenium.*;

public class MainPage extends BasePage{

    public MainPage (WebDriver driver){
        super(driver);
    }

    //Выпадающий список "Вопросы о важном"
    //Сколько это стоит? И как оплатить?
    private static final By dropListHowMuchCost = By.xpath("//*[@id='accordion__heading-0']");
    //Ответ насчет стоимости
    private static final By howMuchCostAnswer = By.xpath("//*[@id='accordion__panel-0']/p");
    //Хочу сразу несколько самокатов! Так можно?
    private static final By dropListWantFewScooters = By.xpath("//*[@id='accordion__heading-1']");
    //Ответ насчет нескольких самокатов
    private static final By wantFewScootersAnswer = By.xpath("//*[@id='accordion__panel-1']");
    //Как рассчитывается время аренды?
    private static final By dropListRentalTimeCalculated = By.xpath("//*[@id='accordion__heading-2']");
    //Ответ насчет времени аренды
    private static final By rentalTimeCalculatedAnswer = By.xpath("//*[@id='accordion__panel-2']/p");
    //Можно ли заказать самокат прямо на сегодня?
    private static final By dropListOrderScooterToday = By.xpath("//*[@id='accordion__heading-3']");
    //Ответ насчет заказа на сегодня
    private static final By orderScooterTodayAnswer = By.xpath("//*[@id='accordion__panel-3']");
    //Можно ли продлить заказ или вернуть самокат раньше?
    private static final By dropListExtendOrder = By.xpath("//*[@id='accordion__heading-4']");
    //Ответ насчет продления заказа
    private static final By extendOrderAnswer = By.xpath("//*[@id='accordion__panel-4']");
    //Вы привозите зарядку вместе с самокатом?
    private static final By dropListChargerWithScooter = By.xpath("//*[@id='accordion__heading-5']");
    //Ответ начет зарядки
    private static final By chargerWithScooterAnswer = By.xpath("//*[@id='accordion__panel-5']/p");
    //Можно ли отменить заказ?
    private static final By dropListCancelingOrder = By.xpath("//*[@id='accordion__heading-6']");
    //Ответ насчет отмены заказа
    private static final By cancelingOrderAnswer = By.xpath("//*[@id='accordion__panel-6']/p");
    //Я живу за МКАДом, привезёте?
    private static final By dropListFarAway = By.xpath("//*[@id='accordion__heading-7']");
    //Ответ доставки за МКАД
    private static final By farAwayAnswer = By.xpath("//*[@id='accordion__panel-7']/p");
    //Кнопка заказать расположенная вверху страницы
    private static final By orderButtonUp = By.xpath(".//button[@class='Button_Button__ra12g' and text()='Заказать']");
    //Кнопка заказать расположенная внизу страницы
    private static final By orderButtonDown = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    //Надпись внизу сайта "Вопросы о важном"
    public static By titleQuestions = By.xpath(".//div[@class='Home_SubHeader__zwi_E' and text()='Вопросы о важном']");
    //Изображение самоката
    public static By scooterImage = By.cssSelector("[src='/assets/blueprint.png']");

    public static By getDropListHowMuchCost() {
        return dropListHowMuchCost;
    }
    public static By getHowMuchCostAnswer() {
        return howMuchCostAnswer;
    }
    public static By getDropListWantFewScooters() {
        return dropListWantFewScooters;
    }
    public static By getWantFewScootersAnswer() {
        return wantFewScootersAnswer;
    }
    public static By getDropListRentalTimeCalculated() {
        return dropListRentalTimeCalculated;
    }
    public static By getRentalTimeCalculatedAnswer() {
        return rentalTimeCalculatedAnswer;
    }
    public static By getDropListOrderScooterToday() {
        return dropListOrderScooterToday;
    }
    public static By getOrderScooterTodayAnswer() {
        return orderScooterTodayAnswer;
    }
    public static By getDropListExtendOrder() {
        return dropListExtendOrder;
    }
    public static By getExtendOrderAnswer() {
        return extendOrderAnswer;
    }
    public static By getDropListChargerWithScooter() {
        return dropListChargerWithScooter;
    }
    public static By getChargerWithScooterAnswer() {
        return chargerWithScooterAnswer;
    }
    public static By getDropListCancelingOrder() {
        return dropListCancelingOrder;
    }
    public static By getCancelingOrderAnswer() {
        return cancelingOrderAnswer;
    }
    public static By getDropListFarAway() {
        return dropListFarAway;
    }
    public static By getFarAwayAnswer() {
        return farAwayAnswer;
    }
    public static By getOrderButtonUp() {
        return orderButtonUp;
    }
    public static By getOrderButtonDown() {
        return orderButtonDown;
    }

    public void openPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        waitForVisibility(scooterImage);
    }

    public boolean isDropListFormDisplayed(By answer) {
        return driver.findElement(answer).isDisplayed();
    }

    public void openDropList(By question, By answer) {
        waitForVisibility(question);
        scrollToElement(titleQuestions);
        waitForVisibility(question);
        search(question).click();
        waitForVisibility(answer);
    }

    public String getTextAnswer(By answer) {
        return search(answer).getText();
    }
}
