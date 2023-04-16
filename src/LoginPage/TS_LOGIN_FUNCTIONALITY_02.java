package LoginPage;

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


public class TS_LOGIN_FUNCTIONALITY_02 {

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
	
	@Test // TC_LF_00: Login with correct username and password
	void TC_LF_00() {
		usernameField.sendKeys("standard_user");
		passwordField.sendKeys("secret_sauce");
		loginButton.click();
		
		String expectedPage = "https://www.saucedemo.com/inventory.html";
		String actualPage = driver.getCurrentUrl();
		
		softAssert.assertEquals(expectedPage, actualPage);
		softAssert.assertAll();
	}
	
	@Test // TC_LF_01: Login with correct username and incorrect password
	void TC_LF_01() {
		usernameField.sendKeys("standard_user");
		passwordField.sendKeys("secret_sauce123");
		loginButton.click();
		
		String expectedPage = "https://www.saucedemo.com/inventory.html";
		String actualPage = driver.getCurrentUrl();
		
		softAssert.assertNotEquals(expectedPage, actualPage);
		softAssert.assertAll();
	}
	
	@Test // TC_LF_02: Login with incorrect username and correct password
	void TC_LF_02() {
		usernameField.sendKeys("standard_user123");
		passwordField.sendKeys("secret_sauce");
		loginButton.click();
		
		String expectedPage = "https://www.saucedemo.com/inventory.html";
		String actualPage = driver.getCurrentUrl();
		
		softAssert.assertNotEquals(expectedPage, actualPage);
		softAssert.assertAll();
	}
	
	@Test // TC_LF_03: Login with incorrect username and password
	void TC_LF_03() {
		usernameField.sendKeys("standard_user123");
		passwordField.sendKeys("secret_sauce123");
		loginButton.click();
		
		String expectedPage = "https://www.saucedemo.com/inventory.html";
		String actualPage = driver.getCurrentUrl();
		
		softAssert.assertNotEquals(expectedPage, actualPage);
		softAssert.assertAll();
	}
	
	@Test // TC_LF_04: Login with blank username and password
	void TC_LF_04() {
		usernameField.sendKeys("");
		passwordField.sendKeys("");
		loginButton.click();
		
		String expectedPage = "https://www.saucedemo.com/inventory.html";
		String actualPage = driver.getCurrentUrl();
		
		softAssert.assertNotEquals(expectedPage, actualPage);
		softAssert.assertAll();
	}
	
	@Test // TC_LF_05: Login with blank username and correct password
	void TC_LF_05() {
		usernameField.sendKeys("");
		passwordField.sendKeys("secret_sauce");
		loginButton.click();
		
		String expectedPage = "https://www.saucedemo.com/inventory.html";
		String actualPage = driver.getCurrentUrl();
		
		softAssert.assertNotEquals(expectedPage, actualPage);
		softAssert.assertAll();
	}
	
	@Test // TC_LF_06: Login with blank username and incorrect password
	void TC_LF_06() {
		usernameField.sendKeys("");
		passwordField.sendKeys("secret_sauce123");
		loginButton.click();
		
		String expectedPage = "https://www.saucedemo.com/inventory.html";
		String actualPage = driver.getCurrentUrl();
		
		softAssert.assertNotEquals(expectedPage, actualPage);
		softAssert.assertAll();
	}
	
	@Test // TC_LF_07: Login with correct username and blank password
	void TC_LF_07() {
		usernameField.sendKeys("standard_user");
		passwordField.sendKeys("");
		loginButton.click();
		
		String expectedPage = "https://www.saucedemo.com/inventory.html";
		String actualPage = driver.getCurrentUrl();
		
		softAssert.assertNotEquals(expectedPage, actualPage);
		softAssert.assertAll();
	}
	
	@Test // TC_LF_08: Login with incorrect username and blank password
	void TC_LF_08() {
		usernameField.sendKeys("standard_user123");
		passwordField.sendKeys("");
		loginButton.click();
		
		String expectedPage = "https://www.saucedemo.com/inventory.html";
		String actualPage = driver.getCurrentUrl();
		
		softAssert.assertNotEquals(expectedPage, actualPage);
		softAssert.assertAll();
	}
	

	

	

	

}
