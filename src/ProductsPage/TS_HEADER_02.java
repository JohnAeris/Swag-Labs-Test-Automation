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

public class TS_HEADER_02 {

	@BeforeClass
	public static void beforeClass() {
		System.setProperty("webdriver.edge.driver", "D:\\Projects\\Test Automation\\Swag Labs\\drivers\\Edge\\edgedriver_win64\\msedgedriver.exe");
	}
	
	private WebDriver driver;
	private SoftAssert softAssert;
	private WebElement usernameField, passwordField, loginButton;
	private WebElement menuButton, cartIcon;
	
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
		
		menuButton = driver.findElement(By.id("react-burger-menu-btn"));
		cartIcon = driver.findElement(By.id("shopping_cart_container"));
		
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
	
	@Test // TC_H_00: Verify the title in header
	void TC_H_00() {
		
		String expectedTitleHeader = "Swag Labs";
		String actualTitleHeader = driver.findElement(By.className("app_logo")).getText();
		
		softAssert.assertEquals(expectedTitleHeader, actualTitleHeader);
		softAssert.assertAll();
	}
	
	@Test // TC_H_01: Verify if the hamburger menu button is presented
	void TC_H_01() {
		softAssert.assertTrue(menuButton.isDisplayed());
		softAssert.assertAll();
	}
	
	@Test // TC_H_02: Verify if the cart icon is presented
	void TC_H_02() {
		softAssert.assertTrue(cartIcon.isDisplayed());
		softAssert.assertAll();
	}
	
	@Test // TC_H_03: Verify if the hamburger menu button is enabled
	void TC_H_03() {
		softAssert.assertTrue(menuButton.isEnabled());
		softAssert.assertAll();
	}
	
	
	
	
	
	
	


}
