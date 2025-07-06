import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.MainPage;
import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)

public class DropListTests {

    private final By question;
    private final By answer;
    private final String errorMessage;

    WebDriver driver;
    MainPage mainPage;

    @Before
    public void startUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);
    }

    public DropListTests(By question, By answer, String errorMessage) {
        this.question = question;
        this.answer = answer;
        this.errorMessage = errorMessage;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
            {MainPage.dropListHowMuchCost, MainPage.howMuchCostAnswer, "Ответ насчет стоимости не обнаружен"},
            {MainPage.dropListWantFewScooters, MainPage.wantFewScootersAnswer, "Ответ насчет нескольких самокатов не обнаружен"},
            {MainPage.dropListRentalTimeCalculated, MainPage.rentalTimeCalculatedAnswer, "Ответ насчет времени аренды не обнаружен"},
            {MainPage.dropListOrderScooterToday, MainPage.orderScooterTodayAnswer, "Ответ насчет заказа на сегодня не обнаружен"},
            {MainPage.dropListExtendOrder, MainPage.extendOrderAnswer, "Ответ насчет продления заказа не обнаружен"},
            {MainPage.dropListChargerWithScooter, MainPage.chargerWithScooterAnswer, "Ответ насчет зарядки не обнаружен"},
            {MainPage.dropListCancelingOrder, MainPage.cancelingOrderAnswer, "Ответ насчет отмены заказа не обнаружен"},
            {MainPage.dropListFarAway, MainPage.farAwayAnswer, "Ответ насчет доставки за МКАД не обнаружен"},
        };
    }

    @Test
    public void dropList() {
        mainPage.openPage();
        mainPage.openDropList(question, answer);
        assertTrue(errorMessage, driver.findElement(answer).isDisplayed());
    }

    @After
    public void shutDown() {
        driver.quit();
    }
}