import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {
    AndroidDriver<AndroidElement> driver = null;

    public void initialize() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 7 API 28");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.calculator");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test()
    @DisplayName("Проверка суммы")
    public void checkSum() {
        initialize();
        driver.findElementById("com.google.android.calculator:id/digit_3").click();
        driver.findElementById("com.google.android.calculator:id/op_add").click();
        driver.findElementById("com.google.android.calculator:id/digit_2").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();
        assertEquals("5", driver.findElementById("com.google.android.calculator:id/result_final").getText());
    }

    @Test()
    @DisplayName("Проверка вычитания")
    public void checkDeduction() {
        initialize();
        driver.findElementById("com.google.android.calculator:id/digit_3").click();
        driver.findElementById("com.google.android.calculator:id/op_sub").click();
        driver.findElementById("com.google.android.calculator:id/digit_2").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();
        assertEquals("1", driver.findElementById("com.google.android.calculator:id/result_final").getText());
    }

    @Test()
    @DisplayName("Проверка деления")
    public void checkDividingNumbers() {
        initialize();
        driver.findElementById("com.google.android.calculator:id/digit_6").click();
        driver.findElementById("com.google.android.calculator:id/op_div").click();
        driver.findElementById("com.google.android.calculator:id/digit_2").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();
        assertEquals("3", driver.findElementById("com.google.android.calculator:id/result_final").getText());
    }

    @Test()
    @DisplayName("Проверка умножения")
    public void checkMultiplyingNumbers() {
        initialize();
        driver.findElementById("com.google.android.calculator:id/digit_6").click();
        driver.findElementById("com.google.android.calculator:id/op_mul").click();
        driver.findElementById("com.google.android.calculator:id/digit_2").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();
        assertEquals("12", driver.findElementById("com.google.android.calculator:id/result_final").getText());
    }
}
