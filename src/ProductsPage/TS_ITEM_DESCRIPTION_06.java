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

public class TS_ITEM_DESCRIPTION_06 {

	@BeforeClass
	public static void beforeClass() {
		System.setProperty("webdriver.edge.driver", "D:\\Projects\\Test Automation\\Swag Labs\\drivers\\Edge\\edgedriver_win64\\msedgedriver.exe");
	}

	private WebDriver driver;
	private SoftAssert softAssert;
	private WebElement usernameField, passwordField, 
	loginButton, title, description, price, addToCartBtn,
	removeBtn, cartBtn, cartItem;
	
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
	
	@Test
	void TC_ID_00() {
		title = driver.findElement(By.className("inventory_item_name"));
		softAssert.assertTrue(title.isDisplayed());
		softAssert.assertAll();
	}
	
	@Test
	void TC_ID_01() {
		description = driver.findElement(By.className("inventory_item_desc"));
		softAssert.assertTrue(description.isDisplayed());
		softAssert.assertAll();
	}
	
	@Test
	void TC_ID_02() {
		price = driver.findElement(By.className("inventory_item_price"));
		softAssert.assertTrue(price.isDisplayed());
		softAssert.assertAll();
	}
	
	@Test
	void TC_ID_03() {
		addToCartBtn = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
		softAssert.assertTrue(addToCartBtn.isDisplayed());
		softAssert.assertAll();
	}
	
	@Test
	void TC_ID_04() {
		addToCartBtn = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
		softAssert.assertTrue(addToCartBtn.isEnabled());
		softAssert.assertAll();
	}
	
	@Test
	void TC_ID_05() {
		addToCartBtn = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
		addToCartBtn.click();
		
		removeBtn = driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']"));
		
		softAssert.assertTrue(removeBtn.isDisplayed());
		softAssert.assertAll();
	}
	
	@Test
	void TC_ID_06() {
		addToCartBtn = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
		addToCartBtn.click();
		
		removeBtn = driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']"));
		
		softAssert.assertTrue(removeBtn.isEnabled());
		softAssert.assertAll();
	}
	
	@Test
	void TC_ID_07() {
		addToCartBtn = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
		addToCartBtn.click();
		
		cartBtn = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/a[1]"));
		cartBtn.click();
		
		cartItem = driver.findElement(By.className("cart_item"));
		softAssert.assertTrue(cartItem.isEnabled());
		softAssert.assertAll();
	}
	
	@Test
	void TC_ID_08() {
		String itemAdded = driver.findElement(By.className("shopping_cart_badge")).getText();
		softAssert.assertEquals(itemAdded, "1");
		softAssert.assertAll();
	}
	
	
}
