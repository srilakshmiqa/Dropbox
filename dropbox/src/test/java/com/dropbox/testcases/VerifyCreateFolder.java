package com.dropbox.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dropbox.pageobjects.BasePage;

public class VerifyCreateFolder extends TestBase{
	BasePage basePage;
	@BeforeClass
	public void objectsIntialization() {
		basePage = PageFactory.initElements(driver, BasePage.class);
	}
	
  @Test
  public void f() {
	  System.out.println("test");
	  basePage.userLogin("test", "test");
  }
}
