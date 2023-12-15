import Page.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class TestMtsBy extends MainPage {

    @Test
    @DisplayName("Проверке блока 'Онлайн пополнение без комиссии'")
    void start() {
        driver.get("https://mts.by");
        clickBtnCookie();
        assertEquals("Онлайн пополнение без комиссии",
                driver.findElement(title).getAttribute("textContent"));
    }

    @Test
    @DisplayName("Проверить наличие логотипов платёжных систем")
    void logoTest() {
        driver.get("https://mts.by");
        clickBtnCookie();
        assertEquals(true, driver.findElement(logoVisa).isDisplayed());
        assertEquals(true, driver.findElement(logoVerifiedByVisa).isDisplayed());
        assertEquals(true, driver.findElement(logoMasterCard).isDisplayed());
        assertEquals(true, driver.findElement(logoBelCard).isDisplayed());
        assertEquals(true, driver.findElement(logoMir).isDisplayed());
    }

    @Test
    @DisplayName("Проверка работы ссылки 'Подробнее о сервисе'")
    void LinkCheck() {
        driver.get("https://mts.by");
        clickBtnCookie();
        link();
        assertEquals("Оплата банковской картой", driver.findElement(moreDetailsAboutTheService)
                .getAttribute("outerText"));
    }

    @Test
    @DisplayName("Проверка работы кнопки 'Продолжить'")
    void CheckBtnContinue() {
        driver.get("https://mts.by");
        clickBtnCookie();
        btnContinue();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']")));
        assertEquals("Сохранить данные карты для последующих оплат", driver.findElement(continueBtn)
                .getAttribute("innerText"));
    }
}