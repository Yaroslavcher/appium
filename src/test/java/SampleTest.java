/*

import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.netology.MainScreen;

import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static io.appium.java_client.remote.IOSMobileCapabilityType.*;
import static io.appium.java_client.remote.MobileCapabilityType.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

@TestInstance(Lifecycle.PER_CLASS)
public class SampleTest {

    private AppiumDriver driver;

    @BeforeAll
    public void createDriver() throws MalformedURLException {
        String platform = System.getProperty("platform");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        if ("android".equals(platform)) {
            desiredCapabilities.setCapability(PLATFORM_NAME, "android");
            desiredCapabilities.setCapability(DEVICE_NAME, "any name");
            desiredCapabilities.setCapability(APP_PACKAGE, "com.google.android.calculator");
            desiredCapabilities.setCapability(APP_ACTIVITY, "com.android.calculator2.Calculator");
        } else if ("ios".equals(platform)) {
            desiredCapabilities.setCapability(PLATFORM_NAME, "iOS");
            desiredCapabilities.setCapability(DEVICE_NAME, "iPhone 11");
            desiredCapabilities.setCapability(BUNDLE_ID, "com.shubham-iosdev.Calculator-UI");
            desiredCapabilities.setCapability(AUTOMATION_NAME, "XCUITest");
        } else {
            throw new IllegalArgumentException(String.format("Platform %s no supported", platform));
        }
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
    }

    @Test
    public void test() {
        MainScreen mainScreen = new MainScreen(driver);
        mainScreen.digitTwoButton.click();
        mainScreen.plusSignButton.click();
        mainScreen.digitTwoButton.click();
        mainScreen.equalsSignButton.click();
        Assertions.assertEquals("4", mainScreen.resultField.getText());
    }

    @AfterAll
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}*/

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
/*import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;*/
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SampleTest {

    private AndroidDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appium:deviceName", "deviceName");
        desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
        desiredCapabilities.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 0);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void inputEmptyStringTest() {
        MobileElement el1 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/textToBeChanged");
        MobileElement el2 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonChange");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/textToBeChanged");
        Assertions.assertEquals(el3.getText(), el1.getText());
    }

    @Test
    public void openTextInNewActivityTest() {
        MobileElement el1 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/userInput");
        el1.click();
        el1.sendKeys("test");
        //el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonActivity");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout");
        Assertions.assertEquals("true", el3.isDisplayed());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

