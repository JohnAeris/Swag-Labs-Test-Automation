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
	
	@Test // TC_SH_05: Verify if the price from low to high filter is working
	void TC_SH_05() {
		filter.selectByVisibleText("Price (low to high)"); // select the Price (low to high) filter
		
		List<Double> itemPriceList = new ArrayList<>(); // create new itemPriceList
		List<WebElement> itemPrices = driver.findElements(By.className("inventory_item_price")); // get all the item prices
		
		for (WebElement price : itemPrices) { // iterate each item price
			String itemPrice = price.getText(); // convert the item from WebElement to String
			if (itemPrice.startsWith("$")) { // implement this condition for all item prices starts with dollar sign
				itemPrice = itemPrice.replace("$", "").trim(); // cut and remove the Sauce Labs
				Double itemPriceVal = Double.parseDouble(itemPrice); // convert the string into double
				itemPriceList.add(itemPriceVal); // add the item price in the itemPriceList
			}
			else { // implement this condition for all item prices that is not started with a dollar sign
				Double itemPriceVal = Double.parseDouble(itemPrice); // convert the string into double
				itemPriceList.add(itemPriceVal); // add the item price in the itemPriceList
			}
		}
		
		int listSize = itemPriceList.size(); // get the total count of the list
		
		boolean isAscending = true; // true if the list is in ascending order else false
		for (int i = 0; i < listSize - 1; i++) { // iterate from first item name to the last item name
			if (itemPriceList.get(i) > itemPriceList.get(i + 1)) { // compare the first price if it is greater than to next price
				isAscending = false; // if condition is true, the list is not low to high order
				break;
			}
			else {
				isAscending = true; // else, the list is in low to high order
			}
		}
		
		softAssert.assertTrue(isAscending);
		softAssert.assertAll();
	}
	
	@Test // TC_SH_06: Verify if the price from high to low filter is working
	void TC_SH_06() {
		filter.selectByVisibleText("Price (high to low)"); // select the Price (low to high) filter
		
		List<Double> itemPriceList = new ArrayList<>(); // create new itemPriceList
		List<WebElement> itemPrices = driver.findElements(By.className("inventory_item_price")); // get all the item prices
		
		for (WebElement price : itemPrices) { // iterate each item price
			String itemPrice = price.getText(); // convert the item from WebElement to String
			if (itemPrice.startsWith("$")) { // implement this condition for all item prices starts with dollar sign
				itemPrice = itemPrice.replace("$", "").trim(); // cut and remove the Sauce Labs
				Double itemPriceVal = Double.parseDouble(itemPrice); // convert the string into double
				itemPriceList.add(itemPriceVal); // add the item price in the itemPriceList
			}
			else { // implement this condition for all item prices that is not started with a dollar sign
				Double itemPriceVal = Double.parseDouble(itemPrice); // convert the string into double
				itemPriceList.add(itemPriceVal); // add the item price in the itemPriceList
			}
		}
		
		System.out.println(itemPriceList);
		int listSize = itemPriceList.size(); // get the total count of the list
		
		boolean isAscending = true; // true if the list is in ascending order else false
		for (int i = 0; i < listSize - 1; i++) { // iterate from first item name to the last item name
			if (itemPriceList.get(i) < itemPriceList.get(i + 1)) { // compare the first price if it is greater than to next price
				isAscending = false; // if condition is true, the list is not low to high order
				break;
			}
			else {
				isAscending = true; // else, the list is in low to high order
			}
		}
		
		softAssert.assertTrue(isAscending);
		softAssert.assertAll();
	}
	
	@Test // TC_SH_07: Verify the spelling of all filter options
	void TC_SH_07() {
		WebElement filterOptions = driver.findElement(By.className("product_sort_container")); // find the dropdown element
		List<WebElement> listFilterOptions = filterOptions.findElements(By.tagName("option")); // get the option tagname
		List<String> listOptions = new ArrayList<>(); // create new list for the container
		
		for (WebElement filter : listFilterOptions) { // iterate to each filter option
			String option = filter.getText(); // get the filter option name
			listOptions.add(option); // add the filter option in the listOptions
		}
		
		String option1 = listOptions.get(0); // store the filter option 1 in option1 variable
		String option2 = listOptions.get(1); // store the filter option 2 in option1 variable
		String option3 = listOptions.get(2); // store the filter option 3 in option1 variable
		String option4 = listOptions.get(3); // store the filter option 4 in option1 variable
		
		softAssert.assertEquals("Name (A to Z)", option1); // compare the filter option 1 to the expected spelling
		softAssert.assertEquals("Name (Z to A)", option2); // compare the filter option 2 to the expected spelling
		softAssert.assertEquals("Price (low to high)", option3); // compare the filter option 3 to the expected spelling
		softAssert.assertEquals("Price (high to low)", option4); // compare the filter option 4 to the expected spelling
		softAssert.assertAll();
	}
	
	@Test // TC_SH_08: Verify the spelling of all filter options
	void TC_SH_08() {
		WebElement filterOptions = driver.findElement(By.className("product_sort_container")); // find the dropdown element
		List<WebElement> listFilterOptions = filterOptions.findElements(By.tagName("option")); // get the option tagname
		List<String> listOptions = new ArrayList<>(); // create new list for the container
		
		for (WebElement filter : listFilterOptions) { // iterate to each filter option
			String option = filter.getText(); // get the filter option name
			listOptions.add(option); // add the filter option in the listOptions
		}
		
		softAssert.assertEquals(4, listOptions.size()); // compare the expected total options and actual number of filter options
		softAssert.assertAll();
	}

}
