package PageNew;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

public class FirstPage {
    public static WebDriver driver;
    public static By productLocatorOne = By.xpath("//article[@data-index='0']");
    public static By productLocatorTwo = By.xpath("//article[@data-index='1']");
    public static By addBasket = By.xpath
            ("//a[@class='product-card__add-basket j-add-to-basket btn-main-sm-2']");
    public By productNameOne = By.xpath("//article[@data-index='0']//span[@class='product-card__name']");
    public By productNameTwo = By.xpath("//article[@data-index='1']//span[@class='product-card__name']");
    public By clickBasket = By.xpath("//span[@class='navbar-pc__icon navbar-pc__icon--basket']");
    public By getProductNameSecond = By.xpath
            ("//div[@class='accordion__list-item list-item j-b-basket-item'][1]" +
                    "//span[@class='good-info__good-name']");
    public By getProductNameFirst = By.xpath
            ("//div[@class='accordion__list-item list-item j-b-basket-item'][2]" +
                    "//span[@class='good-info__good-name']");
    public By getQuantity = By.xpath("//div[@class='b-top__count line']");
    public By sell1 = By.xpath("//div[@class='accordion__list-item list-item j-b-basket-item'][2]" +
            "//div[@class='list-item__price-new']");
    public By sell2 = By.xpath("//div[@class='accordion__list-item list-item j-b-basket-item'][1]" +
            "//div[@class='list-item__price-new']");
    public By priseTotalBasket = By.xpath("//div[@class='basket-order__b-top b-top']//span//span");

    @BeforeEach
    public void addToCartAnd() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.wildberries.ru/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(4000);
        WebElement myElement = driver.findElement(productLocatorOne);
        new Actions(driver).moveToElement(myElement).perform();
        driver.findElement(addBasket).click();
        Thread.sleep(2000);
        WebElement myElement2 = driver.findElement(productLocatorTwo);
        new Actions(driver).moveToElement(myElement2).perform();
        driver.findElement(addBasket).click();
        Thread.sleep(2000);
    }

    public void clickBasketBtn(){
        driver.findElement(clickBasket).click();
    }

    @AfterEach
    public void postCondition() {
        driver.quit();
    }
}
