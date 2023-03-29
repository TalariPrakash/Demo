package march24;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AdvanceReports
{
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	@BeforeTest
	public void generateReport()
	{
		report = new ExtentReports("./ExtentReports/Demo.html");
	}
    @BeforeMethod
    public void Steup()
    {
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get("http://google.com");
    	
    }
    @Test 
    public void testcase1()
    {
    	test=report.startTest("pass Test");
    	test.assignAuthor("prakash");
    	test.assignCategory("Functional");
    	String Expected_Title ="Google";
    	String Acctual_Title = driver.getTitle();
    	if (Expected_Title.equalsIgnoreCase(Acctual_Title)) 
    	{
			test.log(LogStatus.PASS,"Title is Matching:::"+Expected_Title+"         "+Acctual_Title);
		}
    	else 
		{
			test.log(LogStatus.FAIL,"Title is not Matching:::"+Expected_Title+"      "+Acctual_Title);
		}
    	
    }
    @Test
    public void testcase2()
    {
    	test=report.startTest("Fail Test");
    	test.assignCategory("Functional");
    	String Expected_Title ="Gmail";
    	String Acctual_Title = driver.getTitle();
    	if (Expected_Title.equalsIgnoreCase(Acctual_Title))
    	{
			test.log(LogStatus.PASS, "Title Is Matching :::"+Expected_Title+"       "+Acctual_Title);
		}else 
		{
			test.log(LogStatus.FAIL,"Title is notMatching :::"+Expected_Title+"        "+Acctual_Title);
		}
    	
    }
    @AfterMethod
    public void tearDown()
    {
    	report.endTest(test);
    	report.flush();
    	driver.quit();
    	
    }
    
    
    
    
}
