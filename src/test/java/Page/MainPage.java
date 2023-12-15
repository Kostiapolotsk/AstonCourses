package Page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPage {
    public static WebDriver driver;
    public By title = By.xpath("//div[@class='pay__wrapper']/h2");
    public By logoVisa = By.xpath("//img[@alt='Visa']");
    public By logoVerifiedByVisa = By.xpath("//img[@alt='Verified By Visa']");
    public By logoMasterCard = By.xpath("//img[@alt='MasterCard']");
    public By logoBelCard = By.xpath("//img[@alt='Белкарт']");
    public By logoMir = By.xpath("//img[@alt='МИР']");
    public By moreDetailsAboutTheService = By.xpath("//div[@class ='container-fluid']/h3");
    public By continueBtn = By.xpath("//label[@class='ng-tns-c50-2 ng-star-inserted']");


    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public static void clickBtnCookie() {
        driver.findElement(By.xpath("//button[@class='btn btn_black cookie__ok']")).click();
    }

    public static void link() {
        driver.findElement(By.xpath("//div[@class='pay__wrapper']//a")).click();
    }

    public static void btnContinue() {
        driver.findElement(By.xpath("//button[@class='select__header']")).click();
        driver.findElement(By.xpath("//p[@class='select__option']")).click();
        driver.findElement(By.xpath("//input[@class='phone'][@id='connection-phone']")).click();
        driver.findElement(By.xpath("//input[@class='phone'][@id='connection-phone']"))
                .sendKeys("297777777");
        driver.findElement(By.xpath("//input[@class='total_rub'][@id='connection-sum']")).click();
        driver.findElement(By.xpath("//input[@class='total_rub'][@id='connection-sum']"))
                .sendKeys("500");
        driver.findElement(By.xpath("//input[@class='email'][@id='connection-email']")).click();
        driver.findElement(By.xpath("//input[@class='email'][@id='connection-email']"))
                .sendKeys("123@yandex.ru");
        driver.findElement(By.xpath("//button[@class='button button__default ']")).click();
    }

    @AfterEach
    public void postCondition() {
        driver.quit();
    }
}
