package tests.UserTypeScreen;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import poilapp.AppiumConfiguration;
import tests.LanguageScreen.LanguagesScreenTestCases;

public class UserTypesScreenTestCases extends AppiumConfiguration {
    private String navigationTitle = UserTypeScreenStrings.getString("USER_TYPE_NAVIGATION_TITLE_ELEMENT");
    private static String userTypeNextButton = UserTypeScreenStrings.getString("USER_TYPE_NEXT_BUTTON");
    private static String infoScreenSkipButton = UserTypeScreenStrings.getString("INFO_SCREEN_SKIP_BUTTON");
    private static String loginPageTitle = UserTypeScreenStrings.getString("LOGIN_PAGE_TITLE");
    private static String loginPageTitleTextValue = UserTypeScreenStrings.getString("LOGIN_PAGE_TITLE_TEXT");

    // Private Strings
    private static String loginPageTitleText;

    // Booleans
    private static boolean isElementVisible = true;
    private boolean isNavigationTitleElementVisible;
    private static boolean isSkipButtonVisible;

    @Test
    public void checkIsScreenTitleVisible() throws MalformedURLException, URISyntaxException, InterruptedException {
        configureAppium();

        Thread.sleep(3000);

        LanguagesScreenTestCases.nextButtonClicked();

        WebElement navigationTitleElement = driver.findElement(By.xpath(this.navigationTitle));
        isNavigationTitleElementVisible = navigationTitleElement.isDisplayed();
        Assert.assertEquals(isNavigationTitleElementVisible, isElementVisible);
    }

    @Test
    public void chooseIndividualTypeAndTapNext() throws MalformedURLException, URISyntaxException, InterruptedException {
        configureAppium();

        Thread.sleep(5000);

        LanguagesScreenTestCases.nextButtonClicked();
        WebElement nextButton = driver.findElement(By.xpath(userTypeNextButton));
        nextButton.click();

        Thread.sleep(10000);

        WebElement skipButton = driver.findElement(By.xpath(infoScreenSkipButton));
        isSkipButtonVisible = skipButton.isDisplayed();
        Assert.assertEquals(isSkipButtonVisible, isElementVisible);

        // Press the skip button to reach the login page
        skipButton.click();

        Thread.sleep(5000);

        WebElement loginPageTitleElement = driver.findElement(By.xpath(loginPageTitle));
        loginPageTitleText = loginPageTitleElement.getText();
        Assert.assertEquals(loginPageTitleText, loginPageTitleTextValue);
    }
}
