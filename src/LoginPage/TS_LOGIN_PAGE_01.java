package LoginPage;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TS_LOGIN_PAGE_01 {
	
	@BeforeClass
	public static void beforeClass() {
		System.setProperty("webdriver.edge.driver", "D:\\Projects\\Test Automation\\Swag Labs\\drivers\\Edge\\edgedriver_win64\\msedgedriver.exe");
	}
	
	private WebDriver driver;
	private SoftAssert softAssert;
	
	@BeforeMethod
	public void beforeTest() {
		driver = new EdgeDriver();
		softAssert = new SoftAssert();
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
		driver.get("https://www.saucedemo.com");
		
		String expectedURL = "https://www.saucedemo.com/";
		String actualURL = driver.getCurrentUrl();
		
		softAssert.assertEquals(expectedURL, actualURL);
		
		softAssert.assertAll();
	}
	
	@Test // TC_LP_01: Verify the Title Page
	void TC_LP_01() {
		driver.get("https://www.saucedemo.com");
		
		String expectedTitle = "Swag Labs";
		String actualTitle = driver.getTitle();
		
		softAssert.assertEquals(expectedTitle, actualTitle);
		softAssert.assertAll();
	}


}
