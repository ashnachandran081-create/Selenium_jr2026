package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import utils.ExtentReportManager;
import utils.Log;

public class Base_class {
	protected WebDriver driver;
	protected static ExtentReports extent;
	protected ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        extent = ExtentReportManager.getReportInstance();
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }
	
	@BeforeMethod
	public void setup() {
	    Log.info("Starting the browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Log.info("Going to open url");
		driver.get("https://demo.automationtesting.in/Register.html");
	   
	}
	
	@AfterMethod
	public void teardown(ITestResult result) {
	    if (result.getStatus() == ITestResult.FAILURE && test != null) {
	        String screenshotPath =
	                ExtentReportManager.captureScreenshot(driver, "failure");

	        test.fail("Test failed:: Check screenshots",
	                MediaEntityBuilder
	                        .createScreenCaptureFromPath(screenshotPath)
	                        .build());
	    }

	    if (driver != null) {
	        driver.quit();
	    }
	}
	
	

}
