package tests.LoginScreen;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import poilapp.AppiumConfiguration;
import tests.UserTypeScreen.UserTypesScreenTestCases;

public class LoginScreenTestCases extends AppiumConfiguration {
    // Elements on the screen
    private String emailAddressField = LoginScreenStrings.getString("EMAIL_ADDRESS_FIELD");
    private String passwordField = LoginScreenStrings.getString("PASSWORD_ADDRESS_FIELD");
    private String loginButton = LoginScreenStrings.getString("LOGIN_BUTTON");
    private String invalidCredentialsPopUp = LoginScreenStrings.getString("INVALID_CREDENTIALS_ERROR");
    private String welcomeMessage = LoginScreenStrings.getString("HOMEPAGE_WELCOME_MESSAGE");

    // Private Data
    private String validEmail = LoginScreenStrings.getString("VALID_EMAIL");
    private String invalidEmail = LoginScreenStrings.getString("INVALID_EMAIL");
    private String validPassword = LoginScreenStrings.getString("VALID_PASSWORD");

    // Private Booleans
    private boolean isElementVisible = true;
    private boolean isErrorPopupVisible;
    private boolean isWelcomeMessageElementVisible;

    @Test
    public void verifyLoggingInWithInvalidEmail() throws MalformedURLException, URISyntaxException, InterruptedException {
        configureAppium();

        UserTypesScreenTestCases.chooseIndividualTypeAndTapNext();

        // Focus on the Email Address Field
        // Insert an invalid email
        WebElement emailAddressElement = driver.findElement(By.xpath(this.emailAddressField));
        emailAddressElement.click();
        emailAddressElement.sendKeys(this.invalidEmail);

        // Focus on the password field
        // Insert a valid password
        WebElement passwordElement = driver.findElement(By.xpath(this.passwordField));
        passwordElement.click();
        passwordElement.sendKeys(this.validPassword);

        // Tap on the login button
        WebElement loginElement = driver.findElement(By.xpath(this.loginButton));
        loginElement.click();
        Thread.sleep(3000);

        WebElement errorElement = driver.findElement(By.xpath(this.invalidCredentialsPopUp));
        isErrorPopupVisible = errorElement.isDisplayed();
        Assert.assertEquals(isErrorPopupVisible, this.isElementVisible);
    }

    @Test
    public void verifySuccessfulLogin() throws MalformedURLException, URISyntaxException, InterruptedException {
        configureAppium();

        UserTypesScreenTestCases.chooseIndividualTypeAndTapNext();

        // Focus on the Email Address Element and insert an invalid email address
        WebElement emailAddressElement = driver.findElement(By.xpath(this.emailAddressField));
        emailAddressElement.click();
        emailAddressElement.sendKeys(this.validEmail);

        // Focus on the Password Field and insert a valid password
        WebElement passwordElement = driver.findElement(By.xpath(this.passwordField));
        passwordElement.click();
        passwordElement.sendKeys(this.validPassword);

        // Tap on the Login button
        WebElement loginElement = driver.findElement(By.xpath(this.loginButton));
        loginElement.click();
        System.out.println("======== LOGGED IN ========");
    }
}
