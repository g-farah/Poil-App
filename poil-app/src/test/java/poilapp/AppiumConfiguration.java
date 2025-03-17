package poilapp;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppiumConfiguration {
    private static String applicationPath = "";
    private static String appiumURL = "http://127.0.0.1/wd.hub";
    private static String emulatorName = "";

    public static AndroidDriver driver;

    public static void configureAppium() throws MalformedURLException, URISyntaxException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(emulatorName);
        options.setApp(applicationPath);

        driver = new AndroidDriver(new URI(appiumURL).toURL(), options);
    }

    public static void tearDown() {
        driver.quit();
    }
}