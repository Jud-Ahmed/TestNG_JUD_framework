package neotech.testbases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import neotech.utilities.ConfigsReader;
import neotech.utilities.Constants;

public class BaseClass {

	public static WebDriver driver;
	//extent report objects 
	public static ExtentSparkReporter sparkReport;
	public static ExtentReports report;
	public static ExtentTest test;
	
	
	
	/**
	 * This will start the report creation process.
	 * 
	 */
	@BeforeTest(alwaysRun=true)
	public void generateReport()
	{
		sparkReport = new ExtentSparkReporter(Constants.REPORT_FILEPATH);
		sparkReport.config().setDocumentTitle("My Document Title");
		sparkReport.config().setReportName("My Report Name");
		sparkReport.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(sparkReport);
	}
	
	/**
	 * This method will write the report once the tests are done.
	 */
	@AfterTest(alwaysRun=true)
	public void writeReport()
	{
		report.flush();
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public static void setUp() {
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		String browser = ConfigsReader.getProperty("browser");

		// System.out.println(browser);
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		default:
			break;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
		String url = ConfigsReader.getProperty("url");
		driver.get(url);
		
		
		PageInitializer.initialize();
	}

	@AfterMethod(alwaysRun=true)
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
