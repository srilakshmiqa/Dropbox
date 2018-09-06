package com.dropbox.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dropbox.pageobjects.BasePage;

public class VerifyLogout extends TestBase{
	BasePage basePage;
	@BeforeClass
	public void objectsIntialization() {
		basePage = PageFactory.initElements(driver, BasePage.class);
		basePage.userLogin("username","password");
	}
	
  @Test
  public void verifyUsrLogout() {
	 basePage.userLogout();
	 Assert.assertTrue(basePage.lnkSigin.isDisplayed(), "User may have logged out succesfully");
  }
}
