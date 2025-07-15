import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.OrderPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class RegistrationsTest {

    private final String name;
    private final String secondName;
    private final String address;
    private final String phoneNumber;
    private final String dateOfDelivery;
    private final String orderButtonPosition;
    private final int numberOfStation;
    private final String numberOfRentalDays;

    WebDriver driver;
    OrderPage orderPage;
    MainPage mainPage;

    public RegistrationsTest (String name, String secondName, String address, String phoneNumber, String dateOfDelivery, String orderButtonPosition, int numberOfStation, String numberOfRentalDays) {
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfDelivery = dateOfDelivery;
        this.orderButtonPosition = orderButtonPosition;
        this.numberOfStation = numberOfStation;
        this.numberOfRentalDays = numberOfRentalDays;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {"Дима", "Туманов", "г. Москва", "89788888888", "07.07.2025", "up", 1, "двое суток"},
                {"Вова", "Зарубин", "г. Ставрополь", "89787777777", "08.07.2025", "down", 2, "двое суток"}
        };
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        orderPage = new OrderPage(driver);
        mainPage = new MainPage(driver);
    }

    @Test
    public void makeOrder() {
        mainPage.openPage();
        orderPage.makeAnOrder(name, secondName, address, phoneNumber, dateOfDelivery, orderButtonPosition, numberOfStation, numberOfRentalDays);
        assertTrue(orderPage.isOrderFormDisplayed());
    }

    @After
    public void shutDown() {
        driver.quit();
    }
}
