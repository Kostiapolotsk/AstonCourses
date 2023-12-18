import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaceholderTest extends Page.MainPage {

    @Test
    @DisplayName("Проверка надписей в незаполненном поле 'Услуги связи'")
    void checkCommunicationServices() {
        driver.findElement(By.xpath("//p[@class='select__option']")).click();
        assertEquals("Номер телефона",
                driver.findElement(placeholderNumder).getAttribute("placeholder"));
        assertEquals("Сумма", driver.findElement(placeholderSum).getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", driver.findElement(placeholderEmail)
                .getAttribute("placeholder"));
    }

    @Test
    @DisplayName("Проверка надписей в незаполненном поле 'Домашний Интернет'")
    void checkHomeInternet() {
        driver.findElement(By.xpath("//li[@class='select__item active']")).click();
        driver.findElement(By.xpath("//p[@class='select__option'][text()='Домашний интернет']")).click();
        assertEquals("Номер абонента",
                driver.findElement(placeholderNumderInternet).getAttribute("placeholder"));
        assertEquals("Сумма", driver.findElement(placeholderSum).getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", driver.findElement(placeholderEmail)
                .getAttribute("placeholder"));
    }

    @Test
    @DisplayName("Проверка надписей в незаполненном поле 'Рассрочка'")
    void checkInstallmentPlan() {
        driver.findElement(By.xpath("//li[@class='select__item active']")).click();
        driver.findElement(By.xpath("//p[@class='select__option'][text()='Рассрочка']")).click();
        assertEquals("Номер счета на 44",
                driver.findElement(placeholderInstallmentPlan).getAttribute("placeholder"));
        assertEquals("Сумма", driver.findElement(placeholderSum).getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", driver.findElement(placeholderEmail)
                .getAttribute("placeholder"));
    }

    @Test
    @DisplayName("Проверка надписей в незаполненном поле 'Задолженность'")
    void checkDebt() {
        driver.findElement(By.xpath("//li[@class='select__item active']")).click();
        driver.findElement(By.xpath("//p[@class='select__option'][text()='Задолженность']")).click();
        assertEquals("Номер счета на 2073", driver.findElement(placeholderDebt)
                .getAttribute("placeholder"));
        assertEquals("Сумма", driver.findElement(placeholderSum).getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", driver.findElement(placeholderEmail)
                .getAttribute("placeholder"));
    }

    @Test
    @DisplayName("Проверка коррекности отображения суммы и placeholders карты")
    void btnContinue() {
        driver.findElement(By.xpath("//p[@class='select__option']")).click();
        driver.findElement(By.xpath("//input[@class='phone'][@id='connection-phone']")).click();
        driver.findElement(By.xpath("//input[@class='phone'][@id='connection-phone']"))
                .sendKeys("297777777");
        driver.findElement(By.xpath("//input[@class='total_rub'][@id='connection-sum']")).click();
        driver.findElement(By.xpath("//input[@class='total_rub'][@id='connection-sum']"))
                .sendKeys("50");
        driver.findElement(By.xpath("//input[@class='email'][@id='connection-email']")).click();
        driver.findElement(By.xpath("//input[@class='email'][@id='connection-email']"))
                .sendKeys("123@yandex.ru");
        driver.findElement(By.xpath("//button[@class='button button__default ']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']")));
        assertEquals("50.00 BYN", driver.findElement(priceHeader).getAttribute("outerText"));
        assertEquals("Оплата: Услуги связи Номер:375297777777", driver.findElement(afterPriceHeaderNumber)
                .getAttribute("outerText"));
        assertEquals("Google Pay", driver.findElement(btnGPay).getAttribute("ariaLabel"));
        assertEquals("Yandex Pay", driver.findElement(btnYPay).getAttribute("ariaLabel"));
        assertEquals("Номер карты", driver.findElement(cardNumber).getAttribute("outerText"));
        assertEquals("Срок действия", driver.findElement(cardValidity).getAttribute("outerText"));
        assertEquals("CVC", driver.findElement(cardCVC).getAttribute("outerText"));
        assertEquals("Имя держателя (как на карте)", driver.findElement(cardName)
                .getAttribute("outerText"));
        assertEquals("Оплатить 50.00 BYN", driver.findElement(btnCardPrice)
                .getAttribute("outerText"));
    }
}
