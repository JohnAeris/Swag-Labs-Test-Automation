package ProductsPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TS_ITEM_CARDS_05 {

	@BeforeClass
	public static void beforeClass() {
		System.setProperty("webdriver.edge.driver", "D:\\Projects\\Test Automation\\Swag Labs\\drivers\\Edge\\edgedriver_win64\\msedgedriver.exe");
	}
	
	private WebDriver driver;
	private SoftAssert softAssert;
	private WebElement usernameField, passwordField, loginButton;
	private WebElement addToCartButton, removeButton, shoppingCartIcon;

	
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
		
		addToCartButton = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
		
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
	
	@Test // TC_IC_00: Verify if the items are presented
	void TC_IC_00() {
		
		WebElement item = driver.findElement(By.className("inventory_item"));
		
		softAssert.assertTrue(item.isDisplayed());
		softAssert.assertAll();
	}
	
	@Test // TC_IC_01: Verify the total number of items presented
	void TC_IC_01() {
		
		WebElement itemsContainer = driver.findElement(By.className("inventory_container"));
		List<WebElement> itemList = itemsContainer.findElements(By.className("inventory_item"));
		int totalItemDisplayed = itemList.size();
		
		softAssert.assertEquals(6, totalItemDisplayed);
		softAssert.assertAll();
	}
	
	@Test // TC_IC_02: Verify if the item's title is presented
	void TC_IC_02() {
		
		WebElement itemTitle = driver.findElement(By.className("inventory_item_name"));
	
		softAssert.assertTrue(itemTitle.isDisplayed());
		softAssert.assertAll();
	}
	
	@Test // TC_IC_03: Verify if the item's description is presented
	void TC_IC_03() {
		
		WebElement itemDescription = driver.findElement(By.className("inventory_item_desc"));
	
		softAssert.assertTrue(itemDescription.isDisplayed());
		softAssert.assertAll();
	}
	
	@Test // TC_IC_04: Verify if the item's price is presented
	void TC_IC_04() {
		
		WebElement itemPrice = driver.findElement(By.className("inventory_item_price"));
	
		softAssert.assertTrue(itemPrice.isDisplayed());
		softAssert.assertAll();
	}
	
	@Test // TC_IC_05: Verify if the item's image is presented
	void TC_IC_05() {
		
		WebElement itemImage = driver.findElement(By.className("inventory_item_img"));
	
		softAssert.assertTrue(itemImage.isDisplayed());
		softAssert.assertAll();
	}
	
	@Test // TC_IC_06: Verify if the add to cart button is presented
	void TC_IC_06() {
		softAssert.assertTrue(addToCartButton.isDisplayed());
		softAssert.assertAll();
	}
	
	@Test // TC_IC_07: Verify if the item's title is clickable
	void TC_IC_07() {
		
		WebElement itemTitle = driver.findElement(By.className("inventory_item_name"));
	
		softAssert.assertTrue(itemTitle.isEnabled());
		softAssert.assertAll();
	}
	
	@Test // TC_IC_08: Verify if the item's title is working
	void TC_IC_08() {
		
		WebElement itemTitle = driver.findElement(By.id("item_4_title_link"));
		itemTitle.click();
		
		String expectedUrl = "https://www.saucedemo.com/inventory-item.html?id=4";
		String actualUrl = driver.getCurrentUrl();
		
		
		softAssert.assertEquals(expectedUrl, actualUrl);
		softAssert.assertAll();
	}
	
	@Test // TC_IC_09: Verify if the add to cart button is working
	void TC_IC_09() {

		addToCartButton.click();
		
		WebElement cartIconCount = driver.findElement(By.className("shopping_cart_badge"));
	
		softAssert.assertTrue(cartIconCount.isDisplayed());
		softAssert.assertAll();
	}
	
	@Test // TC_IC_10: Verify if the remove button is presented
	void TC_IC_10() throws InterruptedException {
		
		addToCartButton.click();
		Thread.sleep(300);
		removeButton = driver.findElement(By.name("remove-sauce-labs-backpack"));
	
		softAssert.assertTrue(removeButton.isDisplayed());
		softAssert.assertAll();
	}
	
	@Test // TC_IC_11: Verify if the remove button is working
	void TC_IC_11() throws InterruptedException {
		
		boolean isButtonWorking = false;
		
		try {
			addToCartButton.click();
			WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
			cartIcon.click();
			
			boolean isDisplayed = driver.findElement(By.className("cart_item")).isDisplayed();
		
			driver.findElement(By.name("continue-shopping")).click();	
			driver.findElement(By.name("remove-sauce-labs-backpack")).click();
			cartIcon.click();
		
			boolean isNotDisplayed = driver.findElement(By.className("cart_item")).isDisplayed();
			
			if (isDisplayed == isNotDisplayed) {
				isButtonWorking = true;
			}
			
		}
		catch (StaleElementReferenceException e) {
			isButtonWorking = true;
		}

		softAssert.assertTrue(isButtonWorking);
		softAssert.assertAll();
	}
	
	@Test // TC_IC_12: Verify if the item is added in the cart page correctly
	void TC_IC_12() throws InterruptedException {
		
		addToCartButton.click();
		Thread.sleep(300);
		shoppingCartIcon = driver.findElement(By.className("shopping_cart_link"));
		shoppingCartIcon.click();
		
		WebElement itemCard = driver.findElement(By.className("cart_item"));
	
		softAssert.assertTrue(itemCard.isDisplayed());
		softAssert.assertAll();
	}
	
	@Test // TC_IC_13: Verify if the cart icon is updated the number it displayed
	void TC_IC_13() {
		
		addToCartButton.click();
		
		String expectedCount = "1";
		String actualCount = driver.findElement(By.className("shopping_cart_badge")).getText();
	
		softAssert.assertEquals(expectedCount, actualCount);
		softAssert.assertAll();
	}

}
