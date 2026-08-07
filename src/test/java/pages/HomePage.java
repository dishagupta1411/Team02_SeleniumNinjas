package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	 // =========== HOME PAGE ELEMENTS ============

    @FindBy(xpath = "//span[normalize-space()='LMS - Learning Management System']")
    private WebElement applicationTitle;

    @FindBy(xpath = "//img[@src='assets/img/LMS-logo.jpg']")
    private WebElement applicationLogo;

    // =========== HOME PAGE VERIFICATIONS ============

    public boolean isApplicationTitleDisplayed() {
        return applicationTitle.isDisplayed();
    }

    public boolean isApplicationLogoDisplayed() {
        return applicationLogo.isDisplayed();
    }
    

}
