package ProductsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TS_FOOTER_07 {

	@BeforeClass
	public static void beforeClass() {
		System.setProperty("webdriver.edge.driver", "D:\\Projects\\Test Automation\\Swag Labs\\drivers\\Edge\\edgedriver_win64\\msedgedriver.exe");
	}
	
	private WebDriver driver;
	private SoftAssert softAssert;
	private WebElement usernameField, passwordField, loginButton;
	private WebElement twitterButton, facebookButton, linkedinButton, copyrightText;

	
	@BeforeMethod
	public void beforeTest() throws InterruptedException {
		driver = new EdgeDriver();
		driver.get("https://www.saucedemo.com");
		
		softAssert = new SoftAssert();
		
		usernameField = driver.findElement(By.name("user-name"));
		passwordField = driver.findElement(By.name("password"));
		loginButton = driver.findElement(By.name("login-button"));
		
		usernameField.sendKeys("standard_user");
		passwordField.sendKeys("secret_sauce");
		loginButton.click();
		
		twitterButton = driver.findElement(By.className("social_twitter"));
		facebookButton = driver.findElement(By.className("social_facebook"));
		linkedinButton = driver.findElement(By.className("social_linkedin"));
		copyrightText = driver.findElement(By.className("footer_copy"));
		
	}
	
	@AfterMethod
	public void afterTest() {
		driver.quit();
	}
	
	// On Test Skip
	public static void skipTest(String testCase) {
		System.out.println(testCase + " ---------- Test Skipped");
		throw new SkipException("Skipping this test");
	}
	
	@Test // TC_F_00: Verify if the twitter button is presented
	void TC_F_00() {
		softAssert.assertTrue(twitterButton.isDisplayed());
		softAssert.assertAll();
	}
	
	@Test // TC_F_01: Verify if the facebook button is presented
	void TC_F_01() {
		softAssert.assertTrue(facebookButton.isDisplayed());
		softAssert.assertAll();
	}
	
	@Test // TC_F_02: Verify if the linkedin button is presented
	void TC_F_02() {
		softAssert.assertTrue(linkedinButton.isDisplayed());
		softAssert.assertAll();
	}
	
	@Test // TC_F_03: Verify if the twitter button is working
	void TC_F_03() throws MalformedURLException, IOException {
		WebElement twitter = twitterButton.findElement(By.tagName("a"));
		String twitterLink = twitter.getAttribute("href");
		HttpURLConnection connection = (HttpURLConnection) new URL(twitterLink).openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		
		int responseCode = connection.getResponseCode();
		boolean isLinkWorking = false;
		
		if (responseCode < 400) {
			isLinkWorking = true;
		}
		connection.disconnect();
		
		softAssert.assertTrue(isLinkWorking);
		softAssert.assertAll();
	}
	
	@Test // TC_F_04: Verify if the facebook button is working
	void TC_F_04() throws MalformedURLException, IOException {
		WebElement facebook = facebookButton.findElement(By.tagName("a"));
		String facebookLink = facebook.getAttribute("href");
		HttpURLConnection connection = (HttpURLConnection) new URL(facebookLink).openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		
		int responseCode = connection.getResponseCode();
		boolean isLinkWorking = false;
		
		if (responseCode < 400) {
			isLinkWorking = true;
		}
		connection.disconnect();
		
		softAssert.assertTrue(isLinkWorking);
		softAssert.assertAll();
	}
	



}
