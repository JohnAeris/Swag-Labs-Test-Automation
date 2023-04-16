package ProductsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public class TS_PRODUCTS_PAGE_01 {

	@BeforeClass
	public static void beforeClass() {
		System.setProperty("webdriver.edge.driver", "D:\\Projects\\Test Automation\\Swag Labs\\drivers\\Edge\\edgedriver_win64\\msedgedriver.exe");
	}
	
	private WebDriver driver;
	private SoftAssert softAssert;
	private WebElement usernameField, passwordField, loginButton;
	
	

}
