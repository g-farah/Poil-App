package tests.LanguageScreen;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import poilapp.AppiumConfiguration;

public class LanguagesScreenTestCases extends AppiumConfiguration {
    // Elements on the screen
	private String languagePageNavigationTitle = LanguagesScreenStrings.getString("LANGUAGES_SCREEN_NAVIGATION_TITLE");
	private String languagePageEnglishButton = LanguagesScreenStrings.getString("LANGUAGES_SCREEN_ENGLISH_BUTTON");
	private String languagePageEnglishButtonTitle = LanguagesScreenStrings
			.getString("LANGUAGES_SCREEN_ENGLISH_BUTTON_TITLE");
	private String languagePageArabicButton = LanguagesScreenStrings.getString("LANGUAGES_SCREEN_ARABIC_BUTTON");
	private String languagePageArabicButtonTitle = LanguagesScreenStrings
			.getString("LANGUAGES_SCREEN_ARABIC_BUTTON_TITLE");
	private static String languagePageNextButton = LanguagesScreenStrings.getString("LANGUAGES_SCREEN_NEXT_BUTTON");
	private String languagePageNextButtonTitle = LanguagesScreenStrings.getString("LANGUAGES_SCREEN_NEXT_BUTTON_TITLE");
	private static String userTypeScreenNavigationTitle = LanguagesScreenStrings
			.getString("USERTYPE_SCREEN_NAVIGATION_TITLE");

	// Private Strings
	private String languagePageNavigationTitleText = LanguagesScreenStrings
			.getString("LANGUAGES_SCREEN_NAVIGATION_TITLE_TEXT");
	private String languagePageEnglishButtonText = LanguagesScreenStrings
			.getString("LANGUAGES_SCREEN_ENGLISH_BUTTON_TITLE_TEXT");
	private String languagePageArabicButtonText = LanguagesScreenStrings
			.getString("LANGUAGES_SCREEN_ARABIC_BUTTON_TITLE_TEXT");
	private String languagePageNextButtonText = LanguagesScreenStrings
			.getString("LANGUAGES_SCREEN_NEXT_BUTTON_TITLE_TEXT");
	private static String userTypeScreenNavigationTitleText = LanguagesScreenStrings
			.getString("USERTYPE_SCREEN_NAVIGATION_TITLE_TEXT");

	// Booleans
	private boolean isElementVisible = true;

	// Boolean for element visibility
	private boolean isLanguagePageNavigationTitleVisible;
	private boolean isLanguagePageEnglishButtonVisible;
	private boolean isLanguagePageArabicButtonVisible;
	private boolean isLanguagePageNextButtonVisible;

    @Test
    public void checkLanguagesScreenContent() throws MalformedURLException, URISyntaxException, InterruptedException {
        configureAppium();

        Thread.sleep(5000);

        // Check if the navigation title is visible
        WebElement navigationTile = driver.findElement(By.xpath(this.languagePageNavigationTitle));
        isLanguagePageNavigationTitleVisible = navigationTile.isDisplayed();
        Assert.assertEquals(isLanguagePageNavigationTitleVisible, this.isElementVisible);

        // Check the text of the navigation title
        String navigationTitleText = navigationTile.getText();
        Assert.assertEquals(navigationTitleText, this.languagePageNavigationTitleText);

        // Check if the English button is visible
        WebElement englishButton = driver.findElement(By.xpath(this.languagePageEnglishButton));
        isLanguagePageEnglishButtonVisible = englishButton.isDisplayed();
        Assert.assertEquals(isLanguagePageEnglishButtonVisible, this.isElementVisible);

        // Check the title of the button
        WebElement englishButtonTitle = driver.findElement(By.xpath(this.languagePageEnglishButtonTitle));
        String englishButtonText = englishButtonTitle.getText();
        Assert.assertEquals(englishButtonText, this.languagePageEnglishButtonText);

        // Check if the Arabic button is visible
        WebElement arabicButton = driver.findElement(By.xpath(this.languagePageArabicButton));
        isLanguagePageArabicButtonVisible = arabicButton.isDisplayed();
        Assert.assertEquals(isLanguagePageArabicButtonVisible, this.isElementVisible);

        // Check the title of the button
        WebElement arabicButtonTitle = driver.findElement(By.xpath(this.languagePageArabicButtonTitle));
        String arabicButtonText = arabicButtonTitle.getText();
        Assert.assertEquals(arabicButtonText, this.languagePageArabicButtonText);

        // Check the visibility of the Next button
        WebElement nextButton = driver.findElement(By.xpath(languagePageNextButton));
        isLanguagePageNextButtonVisible = nextButton.isDisplayed();
        Assert.assertEquals(isLanguagePageNextButtonVisible, this.isElementVisible);

        // Check the title of the next button
        WebElement nextButtonTitle = driver.findElement(By.xpath(this.languagePageNextButtonTitle));
        String nextButtonTitleText = nextButtonTitle.getText();
        Assert.assertEquals(nextButtonTitleText, this.languagePageNextButtonText);

        tearDown();
    }

    @Test
    public static void nextButtonClicked() throws MalformedURLException, URISyntaxException, InterruptedException {
        configureAppium();

        Thread.sleep(7000);

        WebElement nextButton = driver.findElement(By.xpath(languagePageNextButton));
        nextButton.click();

        WebElement userTypePageTitle = driver.findElement(By.xpath(userTypeScreenNavigationTitle));
        String nextPageTitle = userTypePageTitle.getText();
        Assert.assertEquals(nextPageTitle, userTypeScreenNavigationTitleText);
    }
}
