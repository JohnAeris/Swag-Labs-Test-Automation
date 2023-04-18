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
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.Collections;

public class TS_SUB_HEADER_04 {

	@BeforeClass
	public static void beforeClass() {
		System.setProperty("webdriver.edge.driver", "D:\\Projects\\Test Automation\\Swag Labs\\drivers\\Edge\\edgedriver_win64\\msedgedriver.exe");
	}
	
	private WebDriver driver;
	private SoftAssert softAssert;
	private WebElement usernameField, passwordField, loginButton;
	private WebElement filterButton;
	private Select filter;
	
	@BeforeMethod
	public void beforeTest() {
		driver = new EdgeDriver();
		driver.get("https://www.saucedemo.com");
		
		softAssert = new SoftAssert();
		
		usernameField = driver.findElement(By.name("user-name"));
		passwordField = driver.findElement(By.name("password"));
		loginButton = driver.findElement(By.name("login-button"));
		
		usernameField.sendKeys("standard_user");
		passwordField.sendKeys("secret_sauce");
		loginButton.click();
		
		filterButton = driver.findElement(By.className("product_sort_container"));
		filter = new Select(filterButton);
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
	
	@Test // TC_SH_00: Verify the sub-header title 
	void TC_SH_00() {
		
		String expectedSubHeader = "Products";
		String actualSubHeader = driver.findElement(By.className("title")).getText();
		
		softAssert.assertEquals(expectedSubHeader, actualSubHeader);
		softAssert.assertAll();
	}
	
	@Test // TC_SH_01: Verify if the filter button is presented
	void TC_SH_01() {
		softAssert.assertTrue(filterButton.isDisplayed());
		softAssert.assertAll();
	}
	
	@Test // TC_SH_02: Verify if the filter button is working
	void TC_SH_02() {
		int filterOptions = filter.getOptions().size();
		softAssert.assertEquals(4, filterOptions);
		softAssert.assertAll();
	}
	
	@Test // TC_SH_03: Verify if the ascending name filter is working
	void TC_SH_03() {
		filter.selectByVisibleText("Name (A to Z)"); // select the Name (A to Z) filter
		
		List<String> itemNamesList = new ArrayList<>(); // create new itemNameList
		List<WebElement> itemNames = driver.findElements(By.className("inventory_item_name")); // get all the item names
		
		for (WebElement name : itemNames) { // iterate each item name
			String itemName = name.getText(); // convert the item from WebElement to String
			itemNamesList.add(itemName); // add this item in the itemNameList
		}
		
		int listSize = itemNamesList.size(); // get the total count of the list
		
		boolean isAscending = true; // true if the list is in ascending order else false
		for (int i = 0; i < listSize - 1; i++) { // iterate from first item name to the last item name
			if (itemNamesList.get(i).compareTo(itemNamesList.get(i+1)) > 0) { // compare the current item name to its next item name
				isAscending = false; // if the two item names are not sorted, make the isSorted false
				break; // stop the loop
			} 
		}
		
		softAssert.assertTrue(isAscending);
		softAssert.assertAll();
	}
	
	@Test // TC_SH_04: Verify if the descending name filter is working
	void TC_SH_04() {
		filter.selectByVisibleText("Name (Z to A)"); // select the Name (Z to A) filter
		
		List<String> itemNamesList = new ArrayList<>(); // create new itemNameList
		List<WebElement> itemNames = driver.findElements(By.className("inventory_item_name")); // get all the item names
		
		for (WebElement name : itemNames) { // iterate each item name
			String itemName = name.getText(); // convert the item from WebElement to String
			if (itemName.startsWith("Sauce Labs ")) { // implement this condition for all items start with Sauce Labs
				itemName = itemName.replace("Sauce Labs ", "".trim()); // cut and remove the Sauce Labs
				itemNamesList.add(itemName); // add the item in itemNamesList
			}
			else {
				itemNamesList.add(itemName); // add this item in the itemNameList
			}
			
		}
		
		int listSize = itemNamesList.size(); // get the total count of the list
		
		
		boolean isDescending = true; // true if the list is in descending order else false
		for (int i = 0; i < listSize - 1; i++) { // iterate from first item name to the last item name
			if (itemNamesList.get(i).compareTo(itemNamesList.get(i+1)) < 0) { // compare the current item name to its next item name
				isDescending = false; // if the two item names are sorted, make the isDescendingOrder false
				break; // stop the loop
			}
		}
		
		softAssert.assertTrue(isDescending);
		softAssert.assertAll();
	}
	

	

	

	


}
