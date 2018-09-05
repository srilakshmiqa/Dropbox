package com.dropbox.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
protected WebDriver driver =null;
	
	public HomePage(WebDriver driver) {
		this.driver =driver;
	}
	
	//Use case 2 Upload File
	
	@FindBy(className="mc-button-content")
	public WebElement btnUpload;
	
	@FindBy(className="action-upload-files mc-popover-content-item")
	public WebElement btnFiles;
	
	//Opens local to upload a file
	
	
	
	
	@FindBy(className="maestro-nav__features-header-link")
	public WebElement lnkFiles;

	@FindBy(className="ue-effect-container uee-AppActionsView-SecondaryActionMenu-text-new-folder")
	public WebElement txtNewFolder;
		
		// Need to click Enter key
	
	
        //Use Case 3 : Logout
		
		@FindBy(className="mc-avatar")
		public WebElement lnkOption;
		
		@FindBy(className="mc-account-menu-item")
		public WebElement lnkLogout;
		
		
		//Use Case 4 : Deleting the file
		
		@FindBy(className="mc-icon-template-actionable mc-overflow-button-icon")
		public WebElement lnkActionmenu;
		
		@FindBy(className="action-delete mc-popover-content-item")
		public WebElement lnkDelete;
		
		//@FindBy(className="")
		//public WebElement lnkConfirmdelete;
		
		
		public void userHome(String filename) {
			txtNewFolder.clear();
			txtNewFolder.sendKeys(filename);	
			
	 
		
	}
}
