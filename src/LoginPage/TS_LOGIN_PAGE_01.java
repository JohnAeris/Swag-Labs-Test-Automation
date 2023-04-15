package LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TS_LOGIN_PAGE_01 {
	
	//"D:\Projects\Test Automation\Swag Labs\drivers\Edge\edgedriver_win64\msedgedriver.exe"
	
	@Test
	void TC_LP_00() {
		System.setProperty("webdriver.edge.driver", "D:\\Projects\\Test Automation\\Swag Labs\\drivers\\Edge\\edgedriver_win64\\msedgedriver.exe");
		
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.saucedemo.com");
		
		String expectedURL = "https://www.saucedemo.com/";
		String actualURL = driver.getCurrentUrl().toString();
		System.out.println(actualURL);
		
		Assert.assertEquals(expectedURL, actualURL);
		
		driver.quit();
	}

}
