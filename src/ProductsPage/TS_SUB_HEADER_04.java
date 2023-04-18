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
	


	

	

	

	

	


}
