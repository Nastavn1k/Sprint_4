package pages;

import org.openqa.selenium.*;

public class MainPage extends BasePage{

    public MainPage (WebDriver driver){
        super(driver);
    }

    //Выпадающий список "Вопросы о важном"
    //Кнопка заказать расположенная вверху страницы
    public static final By orderButtonUp = By.xpath(".//button[@class='Button_Button__ra12g' and text()='Заказать']");
    //Кнопка заказать расположенная внизу страницы
    public static final By orderButtonDown = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    //Надпись внизу сайта "Вопросы о важном"
    private static final By titleQuestions = By.xpath(".//div[@class='Home_SubHeader__zwi_E' and text()='Вопросы о важном']");
    //Изображение самоката
    private static final By scooterImage = By.cssSelector("[src='/assets/blueprint.png']");

    public By choiceQuestion(int numberOfQuestion) {
        return By.xpath("//*[@id='accordion__heading-" + numberOfQuestion + "']");
    }
    public By choiceAnswer(int numberOfQuestion) {
        return By.xpath("//*[@id='accordion__panel-" + numberOfQuestion + "']/p");
    }

    public void openPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        waitForVisibility(scooterImage);
    }

    public boolean isDropListFormDisplayed(int numberOfQuestion) {
        return driver.findElement(choiceAnswer(numberOfQuestion)).isDisplayed();
    }

    public void openDropList(int numberOfQuestion) {
        waitForVisibility(choiceQuestion(numberOfQuestion));
        scrollToElement(titleQuestions);
        waitForVisibility(choiceQuestion(numberOfQuestion));
        search(choiceQuestion(numberOfQuestion)).click();
        waitForVisibility(choiceAnswer(numberOfQuestion));
    }

    public String getTextAnswer(int numberOfQuestion) {
        return search(choiceAnswer(numberOfQuestion)).getText();
    }
}
