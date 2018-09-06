package com.dropbox.testcases;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dropbox.pageobjects.BasePage;

public class VerifyLogin extends TestBase{
	BasePage basePage;
	@BeforeClass
	public void objectsIntialization() {
		basePage = PageFactory.initElements(driver, BasePage.class);
		wait = new WebDriverWait(driver,50);
	}
	@Parameters({"usrName","usrPassword"})
	@Test
	public void verifyLogin(@Optional("dropbox.subscription@gmail.com")String uname, @Optional("Password@123")String pwd) throws InterruptedException {
		
		basePage.userLogin(uname, pwd);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(basePage.lnkUsrProfile));
		Assert.assertTrue(basePage.lnkUsrProfile.isDisplayed());
	}
}
