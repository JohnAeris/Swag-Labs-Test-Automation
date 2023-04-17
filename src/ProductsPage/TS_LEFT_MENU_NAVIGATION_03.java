package ProductsPage;

import java.util.List;

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
import java.util.ArrayList;

public class TS_LEFT_MENU_NAVIGATION_03 {

	@BeforeClass
	public static void beforeClass() {
		System.setProperty("webdriver.edge.driver", "D:\\Projects\\Test Automation\\Swag Labs\\drivers\\Edge\\edgedriver_win64\\msedgedriver.exe");
	}
	
	private WebDriver driver;
	private SoftAssert softAssert;
	private WebElement usernameField, passwordField, loginButton;
	private WebElement cartIcon, menuButton, closeMenuButton;
	
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
		closeMenuButton = driver.findElement(By.id("react-burger-cross-btn"));
		cartIcon = driver.findElement(By.className("shopping_cart_link"));
		
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
	
	@Test // TC_LMN_00: Verify the total number of menu options
	void TC_LMN_00() {
		menuButton.click();
		
		WebElement navMenu = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/nav[1]"));
		List<WebElement> menuOptions = navMenu.findElements(By.tagName("a"));
		
		int expectedTitleHeader = 4;
		int actualTitleHeader = menuOptions.size();
		
		softAssert.assertEquals(expectedTitleHeader, actualTitleHeader);
		softAssert.assertAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
