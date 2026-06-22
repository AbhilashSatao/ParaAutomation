package com.qa.testscripts;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class TestBase 
{
	WebDriver driver;
	
	
	JavascriptExecutor js;
	
	
	@Parameters({"Url"})
	@BeforeClass
	public void setup(String Url)
	{
	//System.setProperty("webdriver.edge.driver", "C:\\Users\\Abhi\\Desktop\\Automation Testing\\edgedriver_win64\\msedgedriver.exe");
	driver = new EdgeDriver();
	
	driver.manage().window().maximize();
	driver.get(Url);
	
	//JavascriptExecutor js = (JavascriptExecutor)driver;
	js = (JavascriptExecutor) driver;
	

	
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}
	
	public void CaptureScreenshot(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+ tname+ ".png");
		FileUtils.copyFile(src, target);
	}
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}
	
}
