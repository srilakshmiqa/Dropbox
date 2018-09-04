package com.dropbox.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author srilakshmik
 *
 */
public class BasePage {

	protected WebDriver driver =null;
	
	public BasePage(WebDriver driver) {
		this.driver =driver;
	}
	
	@FindBy(linkText="Sign in")
	public WebElement lnkSigin;
	
	@FindBy(name="login_email")
	public WebElement txtUserName;
	
	@FindBy(name="login_password")
	public WebElement txtPassword;
	
	@FindBy(className="signin-text")
	public WebElement btnLogin;
	
	
	
	public void userLogin(String name, String password) {
		txtUserName.clear();
		txtUserName.sendKeys(name);
		txtPassword.clear();
		txtPassword.sendKeys(password);
		btnLogin.click();
	}
}
