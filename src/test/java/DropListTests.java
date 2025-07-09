import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)

public class DropListTests {

    private final By question;
    private final By answer;
    private final String correctTextAnswer;
    private final String errorMessageForAssertTrue = "Ответ не отображается";
    private final String errorMessageForAssertEquals = "Тексты не совпадают";

    WebDriver driver;
    MainPage mainPage;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
    }

    public DropListTests(By question, By answer, String correctTextAnswer) {
        this.question = question;
        this.answer = answer;
        this.correctTextAnswer = correctTextAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
            {MainPage.getDropListHowMuchCost(), MainPage.getHowMuchCostAnswer(), "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
            {MainPage.getDropListWantFewScooters(), MainPage.getWantFewScootersAnswer(), "Пока что у нас так: один заказ — один самокат." +
            " Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
            {MainPage.getDropListRentalTimeCalculated(), MainPage.getRentalTimeCalculatedAnswer(), "Допустим, вы оформляете заказ на 8 мая." +
            " Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
            "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
            {MainPage.getDropListOrderScooterToday(), MainPage.getOrderScooterTodayAnswer(), "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
            {MainPage.getDropListExtendOrder(), MainPage.getExtendOrderAnswer(), "Пока что нет! Но если что-то срочное — всегда можно позвонить в" +
            " поддержку по красивому номеру 1010."},
            {MainPage.getDropListChargerWithScooter(), MainPage.getChargerWithScooterAnswer(), "Самокат приезжает к вам с полной зарядкой. Этого" +
            " хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
            {MainPage.getDropListCancelingOrder(), MainPage.getCancelingOrderAnswer(), "Да, пока самокат не привезли. Штрафа не будет, объяснительной" +
            " записки тоже не попросим. Все же свои."},
            {MainPage.getDropListFarAway(), MainPage.getFarAwayAnswer(), "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void dropList() {
        mainPage.openPage();
        mainPage.openDropList(question, answer);
        assertTrue(errorMessageForAssertTrue, mainPage.isDropListFormDisplayed(answer));
        assertEquals(errorMessageForAssertEquals, correctTextAnswer, mainPage.getTextAnswer(answer));

    }

    @After
    public void shutDown() {
        driver.quit();
    }
}