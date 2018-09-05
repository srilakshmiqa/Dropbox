package com.dropbox.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dropbox.pageobjects.BasePage;
import com.dropbox.pageobjects.HomePage;

public class VerifyFileUpload extends TestBase{
	BasePage basePage;
	HomePage homePage;
	@BeforeClass
	public void objectsIntialization() {
		basePage = PageFactory.initElements(driver, BasePage.class);
		homePage = PageFactory.initElements(driver, HomePage.class); 
		
		basePage.userLogin("username","password");
	}
	
	
  @Test
  public void verifyUploadFile() {
	  homePage.btnUpload.click();
	 homePage.lnkFiles.sendKeys("D:\\filenam");
	 
	
  }
}
