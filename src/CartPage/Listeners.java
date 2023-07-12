package CartPage;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listeners extends TestListenerAdapter{

	/*
	 * public void onTestStart(ITestResult result) {
	 * System.out.println(result.getName() + "---------- Test Started"); }
	 */
	
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName() + " ---------- Test Passed");
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName() + " ---------- Test Failed");
	}
	 

}
