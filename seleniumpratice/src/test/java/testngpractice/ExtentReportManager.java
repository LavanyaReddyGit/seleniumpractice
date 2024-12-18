package testngpractice;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{
	
	ExtentSparkReporter sparkreporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void onStart(ITestContext context)
	{
		sparkreporter=new ExtentSparkReporter(System.getProperty("user.dir")+"//reports//myreports.html");
		
		sparkreporter.config().setDocumentTitle("Automation Testing");
		sparkreporter.config().setReportName("Functional Testing");
		sparkreporter.config().setTheme(Theme.STANDARD);
		
		reports=new ExtentReports();
		reports.attachReporter(sparkreporter);
		
		reports.setSystemInfo("ComputerName", "LocalHost");
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("TesterName", "Lavanya");
		reports.setSystemInfo("Browser", "chrome");
		reports.setSystemInfo("os", "window10");
	}
	
	
	public void onTestSuccess(ITestResult result)
	{
		test=reports.createTest(result.getName());
		test.log(Status.PASS, "testcase  passed"+result.getName());
	}
	
	public void onTestFailure(ITestResult result)
	{
		test=reports.createTest(result.getName());
		test.log(Status.FAIL, "testcase  failed"+result.getName());
		test.log(Status.FAIL, "testcase  failed"+result.getThrowable());
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test=reports.createTest(result.getName());
		test.log(Status.SKIP, "testcase  skipped"+result.getName());
		
	}
	
	public void onFinish(ITestContext context)
	{
		
		reports.flush();
	}
	
	

}
