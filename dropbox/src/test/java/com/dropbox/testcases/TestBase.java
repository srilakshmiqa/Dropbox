package com.dropbox.testcases;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class TestBase {
	
	WebDriver driver;
	@Parameters({"browserName"})
  @BeforeSuite
  public void driveSetup(@Optional("chrome")String  bname) {
		
		switch(bname.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "E:\\AutomationWorkSpace\\chromedriver.exe");
			driver = new ChromeDriver();
		case "ie":
			System.setProperty("webdriver.ie.driver", "/home/user/bin");
			driver = new FirefoxDriver();
			default:
				driver = new FirefoxDriver();
		}
	  
  }

		@AfterMethod()
		public void captureScreenShots(ITestResult result) throws Exception {
			
			String screenShotName = null;

			try {
				if (ITestResult.FAILURE == result.getStatus()) {
					if (result.getParameters() != null && result.getParameters().length > 0) {
						screenShotName = (String) result.getMethod().getXmlTest().getName() + "_"
								+ result.getMethod().getMethodName() + "_" + (String) result.getParameters()[0];
					} else {
						screenShotName = (String) result.getMethod().getXmlTest().getName() + "_"
								+ result.getMethod().getMethodName();
					}
					takeScreenshot(screenShotName);
				}

			} catch (Exception e) {

				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		
	}
	@AfterSuite
	public void tearDown() {
		driver.quit();
		
	}
	
	public  boolean takeScreenshot(final String name) throws Exception {

		String destDir = "";
		//destDir = "screenshots/failed";
		destDir = "target/surefire-reports/screenshots";
		new File(destDir).mkdirs();
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		System.out.println("Taken Screenshot");
		return screenshot.renameTo(new File(destDir, String.format("%s.png", name)));


	}
}
