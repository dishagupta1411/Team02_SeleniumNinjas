package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	// =========== HOME PAGE ELEMENTS ============

	@FindBy(xpath = "//span[normalize-space()='LMS - Learning Management System']")
	private WebElement applicationTitle;

	@FindBy(xpath = "//span[normalize-space()='Home']")
	private WebElement homeButton;

	@FindBy(xpath = "//span[normalize-space()='Program']")
	private WebElement programButton;

	@FindBy(xpath = "//span[normalize-space()='Batch']")
	private WebElement batchButton;

	@FindBy(xpath = "//span[normalize-space()='Logout']")
	private WebElement logoutButton;
	
	@FindBy(xpath = "//div[@class='box' and normalize-space()='Dashboard']")
	private WebElement dashboardTitle;

   

	// =========== HOME PAGE VERIFICATIONS ============

	public boolean isApplicationTitleDisplayed() {
	    return applicationTitle.isDisplayed();
	}

	public boolean isHomeButtonDisplayed() {
	    return homeButton.isDisplayed();
	}

	public boolean isProgramButtonDisplayed() {
	    return programButton.isDisplayed();
	}

	public boolean isBatchButtonDisplayed() {
	    return batchButton.isDisplayed();
	}

	public boolean isLogoutButtonDisplayed() {
	    return logoutButton.isDisplayed();
	}
	
	public boolean isDashboardDisplayed() {
	    return dashboardTitle.isDisplayed();
	}
    

}
