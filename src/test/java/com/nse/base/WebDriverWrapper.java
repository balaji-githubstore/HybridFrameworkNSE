package com.nse.base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.nse.utilities.PropUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWrapper {
	protected WebDriver driver;

	private static ExtentReports extent;
	protected static ExtentTest extentTest;

	@BeforeSuite
	public void init() {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
	}

	@AfterSuite
	public void end() {
		extent.flush();
	}

	@BeforeMethod
	@Parameters({ "browser", "url", "headless" })
	public void setup(@Optional("ch") String browserName,@Optional("https://opensource-demo.orangehrmlive.com/") String url,@Optional("false") String headless, Method method) throws IOException {

		extentTest = extent.createTest(method.getName());
		
		if(PropUtils.getPropertiesValue("properties_preference").equalsIgnoreCase("no"))
		{
			browserName=PropUtils.getPropertiesValue("browser");
			url=PropUtils.getPropertiesValue("url");
		}

		if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if (browserName.equalsIgnoreCase("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			
			ChromeOptions options=new ChromeOptions();
			if(headless.equalsIgnoreCase("true"))
			{
				options.addArguments("--headless");
			}
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/");
	
	}

	@AfterMethod
	public void teardown(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
			extentTest.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
		} else {
			extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
			extentTest.skip(result.getThrowable());
		}

		TakesScreenshot ts = (TakesScreenshot) driver;
		String base64String = ts.getScreenshotAs(OutputType.BASE64);
		extentTest.addScreenCaptureFromBase64String(base64String, result.getName());

		driver.quit();
	}

}
