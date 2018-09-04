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
	
	@FindBy(id="sign-in")
	public WebElement linkSigin;
	
	
}
