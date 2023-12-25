import PageNew.FirstPage;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Testing extends FirstPage {
    private String nameOneFirstPage;
    private String nameTwoFirstPage;
    private String nameOneBasket;
    private String nameTwoBasket;
    private int firstPrice;
    private int secondPrice;
    private int priseTotal;

    @Test
    void checkName() throws InterruptedException {
        addToCartAnd();
        nameOneFirstPage = driver.findElement(productNameOne).getText().substring(2).trim();
        nameTwoFirstPage = driver.findElement(productNameTwo).getText().substring(2).trim();
        driver.findElement(clickBasket).click();
        nameOneBasket = driver.findElement(getProductNameFirst).getAttribute("innerText").trim();
        nameTwoBasket = driver.findElement(getProductNameSecond).getAttribute("innerText").trim();
        Thread.sleep(2000);
        assertEquals(nameOneFirstPage, nameOneBasket);
        assertEquals(nameTwoFirstPage, nameTwoBasket);
        postCondition();
    }

    @Test
    void checkQuantity() throws InterruptedException {
        addToCartAnd();
        clickBasketBtn();
        assertEquals("2", driver.findElement(getQuantity).getAttribute("childElementCount"));
        postCondition();
    }

    @Test
    void checkPrice() throws InterruptedException {
        addToCartAnd();
        clickBasketBtn();
        Thread.sleep(3000);
        firstPrice = Integer.parseInt(driver.findElement(sell1)
                .getText().replaceAll("[^0-9]", ""));
        secondPrice = Integer.parseInt(driver.findElement(sell2)
                .getText().replaceAll("[^0-9]", ""));
        priseTotal = Integer.parseInt(driver.findElement(priseTotalBasket)
                .getText().replaceAll("[^0-9]", ""));
        assertEquals((firstPrice + secondPrice), priseTotal);
        postCondition();
    }
}
