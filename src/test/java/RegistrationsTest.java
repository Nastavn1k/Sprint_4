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
import pages.OrderPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class RegistrationsTest {

    private final String name;
    private final String secondName;
    private final String address;
    private final String phoneNumber;
    private final String dateOfDelivery;
    private final By orderButton;

    WebDriver driver;
    MainPage mainPage;

    public RegistrationsTest (String name, String secondName, String address, String phoneNumber, String dateOfDelivery, By orderButton) {
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfDelivery = dateOfDelivery;
        this.orderButton = orderButton;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {"Дима", "Туманов", "г. Москва", "89788888888", "07.07.2025", MainPage.orderButtonUp},
                {"Вова", "Зарубин", "г. Ставрополь", "89787777777", "08.07.2025", MainPage.orderButtonDown}
        };
    }

    @Before
    public void startUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);
    }

    @Test
    public void makeOrder() {
        mainPage.openPage();
        mainPage.makeAnOrder(name, secondName, address, phoneNumber, dateOfDelivery, orderButton);
        assertTrue(driver.findElement(OrderPage.orderForm).isDisplayed());
    }

    @After
    public void shutDown() {
        driver.quit();
    }
}
