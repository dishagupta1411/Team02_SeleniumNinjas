package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import driver.Passing_Driver;



public class ProgramPage extends CommonMethod {
	
	
	@FindBy(id = "username")
	private WebElement userName;
	@FindBy(id = "password")
	private WebElement password;
	@FindBy(xpath = "//span[text()='Select the role']")
	private WebElement role;
	@FindBy(xpath="//span[text()='Login']")
	private WebElement loginBtn;
	@FindBy(xpath="//span[text()=' Admin ']")
	private WebElement admin;
	
	@FindBy(xpath="//div[text()=' Dashboard']")
	WebElement dashboardHeader;
	
		public ProgramPage(Passing_Driver driver) throws IOException {
		super(driver); 
	}
		public void navigateToHomePage() {
			driver.get(config.getProperty("baseUrl"));
		}
	
		public void addUserNameAndPassword() {
			safeType(userName, "Lmshackathon@gmail.com");
			safeType(password, "lmsAug@2026");
			
		}
		
		public void selectRole() {
			safeClick(role);
			safeClick(admin);
		}
		public void loginIntoApp() {		
		safeClick(loginBtn);
	}
		
		public Boolean isDashboardDisplayed() {
			return dashboardHeader.isDisplayed();
		}
		
}
