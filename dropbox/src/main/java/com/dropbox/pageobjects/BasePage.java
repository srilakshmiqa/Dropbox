package com.dropbox.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author srilakshmik
 *
 */
public class BasePage {

	protected WebDriver driver =null;
	protected WebDriverWait wait = null;
	public BasePage(WebDriver driver) {
		this.driver =driver;
	}
	
	@FindBy(partialLinkText="Sign in")
	public WebElement lnkSigin;
	
	@FindBy(xpath="//div[@id='outer-frame']//input[@name='login_email']")
	public WebElement txtUserName;
	
	@FindBy(xpath="//div[@id='outer-frame']//input[@name='login_password']")
	public WebElement txtPassword;
	
	@FindBy(className="login-button signin-button button-primary")
	public WebElement btnLogin;
	
	@FindBy(className="mc-avatar")
	public WebElement lnkUsrProfile;
	
	@FindBy(className="mc-account-menu-item")
	public WebElement lnkLogout;
	
	public void userLogin(String name, String password) {
		boolean isSigninLinkDisplayed = false;
		try {
			isSigninLinkDisplayed=btnLogin.isDisplayed();
		}catch(Exception e) {
			isSigninLinkDisplayed =false;
		}
		if(isSigninLinkDisplayed) {
			txtUserName.clear();
			txtUserName.sendKeys(name);
			txtPassword.clear();
			txtPassword.sendKeys(password);
			//btnLogin.click();
			btnLogin.submit();
		}
		
	}
	
	public void userLogout() {
		lnkUsrProfile.click();
		wait.until(ExpectedConditions.elementToBeClickable(lnkLogout)).click();
		//lnkLogout.click();
	}
}
