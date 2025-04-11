package poilapp;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppiumConfiguration {
    private static String applicationPath = "C:\\Users\\GeorgesF\\OneDrive\\Desktop\\Automation Projects\\Appium Automation\\PoilAutomation\\poil-app\\src\\test\\java\\resources\\POIL_GROUP_LATEST.apk";
    private static String appiumURL = "http://127.0.0.1:4723/wd/hub";
    private static String emulatorName = "Poil Emulator";
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(15);

    public static AndroidDriver driver;
    private static WebDriverWait wait;

    public static void configureAppium() throws MalformedURLException, URISyntaxException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(emulatorName);
        options.setApp(applicationPath);

        driver = new AndroidDriver(new URI(appiumURL).toURL(), options);
        wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
    }

    public static void tearDown() {
        driver.quit();
    }

    public static WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean waitForElementToBeInvisible(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}