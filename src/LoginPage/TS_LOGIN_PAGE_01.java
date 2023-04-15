package LoginPage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TS_LOGIN_PAGE_01 {
	
	SoftAssert softAssert = new SoftAssert(); //Soft Assertion
	
	@Test // TC_LP_00: Verify the URl
	void TC_LP_00() {
		System.setProperty("webdriver.edge.driver", "D:\\Projects\\Test Automation\\Swag Labs\\drivers\\Edge\\edgedriver_win64\\msedgedriver.exe");
		
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.saucedemo.com");
		
		String expectedURL = "https://www.saucedemo.com/";
		String actualURL = driver.getCurrentUrl();
		
		softAssert.assertEquals(expectedURL, actualURL);
		driver.quit();
		
		if (expectedURL.equals(actualURL)) {
			System.out.println("TC_LP_00 ---------- Passed");
		}		
		else {
			System.out.println("TC_LP_00 ---------- Failed");
		}
		
		softAssert.assertAll();
	}
	
	@Test // TC_LP_01: Verify the Title Page
	void TC_LP_01() {
		System.setProperty("webdriver.edge.driver", "D:\\Projects\\Test Automation\\Swag Labs\\drivers\\Edge\\edgedriver_win64\\msedgedriver.exe");
		
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.saucedemo.com");
		
		String expectedTitle = "Swag Labs";
		String actualTitle = driver.getTitle();
		
		softAssert.assertEquals(expectedTitle, actualTitle);
		driver.quit();
		
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("TC_LP_01 ---------- Passed");
		}		
		else {
			System.out.println("TC_LP_01 ---------- Failed");
		}
		
		softAssert.assertAll();
	}

}
