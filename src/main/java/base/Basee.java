package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Basee {
	
	public WebDriver driver;
	 ExtentHtmlReporter report;
	protected ExtentTest tests;
	protected ExtentReports extent;
	
	String url="https://jpetstore.aspectran.com/";
	
	@BeforeTest
	public void start() {
		
		report=new ExtentHtmlReporter("./Report/JPetStoreReport.html");
		report.config().setDocumentTitle("JPetStore Report");
		report.config().setReportName("Automation Report");
		report.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Tester", "Ayishath Rajna");
		
	}
	
	@BeforeMethod
	public void base() {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		
	}
	
	@AfterMethod 
	public void report(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			tests.log(Status.FAIL, "Test failed : "+ result.getName());
			tests.log(Status.FAIL,"Test failed : " + result.getThrowable());
			
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			tests.log(Status.SKIP, "Test skipped : " +result.getName());
			tests.log(Status.SKIP, "Test skipped : "+result.getThrowable());
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			tests.log(Status.PASS, "Test passed : "+result.getName());
		}
		//driver.quit();
	}

}