package LoginPage;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class TS_LOGIN_PAGE_01 {
	
	@BeforeClass
	public static void beforeClass() {
		System.setProperty("webdriver.edge.driver", "D:\\Projects\\Test Automation\\Swag Labs\\drivers\\Edge\\edgedriver_win64\\msedgedriver.exe");
	}
	
	private WebDriver driver;
	private SoftAssert softAssert;
	private WebElement usernameField, passwordField, loginButton; 
	
	@BeforeMethod
	public void beforeTest() {
		driver = new EdgeDriver();
		driver.get("https://www.saucedemo.com");
		
		softAssert = new SoftAssert();
		
		usernameField = driver.findElement(By.name("user-name"));
		passwordField = driver.findElement(By.name("password"));
		loginButton = driver.findElement(By.name("login-button"));
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
	
	@Test // TC_LP_00: Verify the URl
	void TC_LP_00() {
		String expectedURL = "https://www.saucedemo.com/";
		String actualURL = driver.getCurrentUrl();
		softAssert.assertEquals(expectedURL, actualURL);
		softAssert.assertAll();
	}
	
	@Test // TC_LP_01: Verify the Title Page
	void TC_LP_01() {
		String expectedTitle = "Swag Labs";
		String actualTitle = driver.getTitle();
		softAssert.assertEquals(expectedTitle, actualTitle);
		softAssert.assertAll();
	}
	
	@Test // TC_LP_02: Verify the title in header
	void TC_LP_02() {
		String expectedTitleHeader = "Swag Labs";
		String actualTitleHeader = driver.findElement(By.className("login_logo")).getText();
		softAssert.assertEquals(expectedTitleHeader, actualTitleHeader);
		softAssert.assertAll();
	}
	
	@Test // TC_LP_03: Verify if username field is presented
	void TC_LP_03() {
		softAssert.assertTrue(usernameField.isDisplayed());
		softAssert.assertAll();
	}
	
	@Test // TC_LP_04: Verify if password field is presented
	void TC_LP_04() {
		softAssert.assertTrue(passwordField.isDisplayed());
		softAssert.assertAll();
	}
	
	@Test // TC_LP_05: Verify if login button is presented
	void TC_LP_05() {
		softAssert.assertTrue(loginButton.isDisplayed());
		softAssert.assertAll();
	}
	
	@Test // TC_LP_06: Verify if username field is enabled
	void TC_LP_06() {
		softAssert.assertTrue(usernameField.isEnabled());
		softAssert.assertAll();
	}
	
	@Test // TC_LP_07: Verify if password field is enabled
	void TC_LP_07() {
		softAssert.assertTrue(passwordField.isEnabled());
		softAssert.assertAll();
	}
	
	@Test // TC_LP_08: Verify if login button is enabled
	void TC_LP_08() {
		softAssert.assertTrue(loginButton.isEnabled());
		softAssert.assertAll();
	}
	
	@Test // TC_LP_09: Verify the label of username field
	void TC_LP_09() {
		String expectedLabel = "Username";
		String actualLabel = usernameField.getAttribute("placeholder");
		
		softAssert.assertEquals(expectedLabel, actualLabel);
		softAssert.assertAll();
	}
	
	@Test // TC_LP_10: Verify the label of password field
	void TC_LP_10() {
		String expectedLabel = "Password";
		String actualLabel = passwordField.getAttribute("placeholder");
		
		softAssert.assertEquals(expectedLabel, actualLabel);
		softAssert.assertAll();
	}
	
	@Test // TC_LP_11: Verify the label of login button
	void TC_LP_11() {
		String expectedLabel = "Login";
		String actualLabel = loginButton.getAttribute("value");
		
		softAssert.assertEquals(expectedLabel, actualLabel);
		softAssert.assertAll();
	}
	
	@Test // TC_LP_12: Verify if the login button is working
	void TC_LP_12() {
		usernameField.sendKeys("standard_user");
		passwordField.sendKeys("secret_sauce");
		loginButton.click();
		
		String expectedPage = "https://www.saucedemo.com/inventory.html";
		String actualPage = driver.getCurrentUrl();
		
		softAssert.assertEquals(expectedPage, actualPage);
		softAssert.assertAll();
	}


}
