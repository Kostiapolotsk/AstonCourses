package Page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPage {
    public static WebDriver driver;
    public By placeholderNumder = By.xpath("//input[@placeholder='Номер телефона']");
    public By placeholderSum = By.xpath("//input[@placeholder='Сумма']");
    public By placeholderEmail = By.xpath("//input[@placeholder='E-mail для отправки чека']");
    public By placeholderNumderInternet = By.xpath("//input[@placeholder='Номер абонента']");
    public By placeholderInstallmentPlan = By.xpath("//input[@placeholder='Номер счета на 44']");
    public By placeholderDebt = By.xpath("//input[@placeholder='Номер счета на 2073']");
    public By priceHeader = By.xpath("//p[@class='header__payment-amount']");
    public By afterPriceHeaderNumber = By.xpath("//p[@class='header__payment-info']");
    public By cardNumber = By.xpath("//label[@class='ng-tns-c47-1 ng-star-inserted']");
    public By btnGPay = By.xpath("//button[@class='gpay-button black plain short ru']");
    public By btnYPay = By.xpath("//button[@class='ya-pay-button ya-pay-button_black']");
    public By cardValidity = By.xpath("//label[@class='ng-tns-c47-4 ng-star-inserted']");
    public By cardCVC = By.xpath("//label[@class='ng-tns-c47-5 ng-star-inserted']");
    public By cardName = By.xpath("//label[@class='ng-tns-c47-3 ng-star-inserted']");
    public By btnCardPrice = By.xpath("//button[@class='colored disabled ng-star-inserted']");

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://mts.by");
        clickBtnCookie();
        driver.findElement(By.xpath("//button[@class='select__header']")).click();
    }

    public static void clickBtnCookie() {
        driver.findElement(By.xpath("//button[@class='btn btn_black cookie__ok']")).click();
    }

    @AfterEach
    public void postCondition() {
        driver.quit();
    }
}
