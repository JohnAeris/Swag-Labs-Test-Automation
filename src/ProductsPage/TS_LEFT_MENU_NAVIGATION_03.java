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
	
	@Test // TC_LMN_01: Verify the spelling of all options in menu
	void TC_LMN_01() {
		menuButton.click();
		
		WebElement navMenu = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/nav[1]"));
		List<WebElement> menuOptions = navMenu.findElements(By.tagName("a"));
		List<String> optionList = new ArrayList<>();
		
		for (WebElement option : menuOptions) { 
			String menuOption = option.getText();
			optionList.add(menuOption);
		}
		
		String actualOption1 = optionList.get(0);
		String actualOption2 = optionList.get(1);
		String actualOption3 = optionList.get(2);
		String actualOption4 = optionList.get(3);
		
		softAssert.assertEquals("All Items", actualOption1);
		softAssert.assertEquals("About", actualOption2);
		softAssert.assertEquals("Logout", actualOption3);
		softAssert.assertEquals("Reset App State", actualOption4);
		softAssert.assertAll();

	}
	
	@Test // TC_LMN_02: Verify if all items option is working
	void TC_LMN_02() {
		menuButton.click();
		driver.findElement(By.id("inventory_sidebar_link")).click();
		
		String expectedPage = "https://www.saucedemo.com/inventory.html";
		System.out.println(expectedPage);
		String actualPage = driver.getCurrentUrl();
		System.out.println(actualPage);
		
		softAssert.assertEquals(expectedPage, actualPage);
		softAssert.assertAll();
	}
	
	@Test // TC_LMN_03: Verify if about option is working
	void TC_LMN_03() {
		menuButton.click();
		driver.findElement(By.id("about_sidebar_link")).click();
		
		String expectedPage = "https://saucelabs.com/";
		String actualPage = driver.getCurrentUrl();
		System.out.println(actualPage);
		
		softAssert.assertEquals(expectedPage, actualPage);
		softAssert.assertAll();
	}
	
	@Test // TC_LMN_04: Verify if logout option is working
	void TC_LMN_04() {
		menuButton.click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		
		String expectedPage = "https://www.saucedemo.com/";
		System.out.println(expectedPage);
		String actualPage = driver.getCurrentUrl();
		System.out.println(actualPage);
		
		softAssert.assertEquals(expectedPage, actualPage);
		softAssert.assertAll();
	}
	
	@Test // TC_LMN_05: Verify if reset app state is working
	void TC_LMN_05() {
		// add items in the cart
		driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']")).click();
		driver.findElement(By.xpath("//button[@id='remove-sauce-labs-bike-light']")).click();
		driver.findElement(By.xpath("//button[@id='remove-sauce-labs-bolt-t-shirt']")).click();
		driver.findElement(By.xpath("//button[@id='remove-sauce-labs-fleece-jacket']")).click();
		
		// check the number of items in cart icon (current: 4 items)
		String initialAppState = cartIcon.findElement(By.tagName("span")).getText();	
		
		// click the reset app state option
		menuButton.click();
		driver.findElement(By.id("reset_sidebar_link")).click();
		
		softAssert.assertEquals(initialAppState, "");
		softAssert.assertAll();
	}
	
	@Test // TC_LMN_06: Verify if the ekis button is presented
	void TC_LMN_06() throws InterruptedException {
		menuButton.click();
		Thread.sleep(2000);
		softAssert.assertTrue(closeMenuButton.isDisplayed());
		softAssert.assertAll();
	}
	
	

}
