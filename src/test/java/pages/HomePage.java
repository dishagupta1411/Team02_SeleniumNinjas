package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import driver.Passing_Driver;
import java.util.List;
import org.openqa.selenium.By;

public class HomePage extends CommonMethod {

    public HomePage(Passing_Driver passdr) throws IOException {
        super(passdr);
    }
	
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
	
	@FindBy(tagName = "mat-toolbar")
    private WebElement navigationBar;
	
	@FindBy(xpath = "//mat-toolbar/div")
	private WebElement navigationMenu;
	
	@FindBy(xpath = "//app-admindata//div[@class='top']//strong")
	private WebElement welcomeMessage;

	@FindBy(xpath = "//app-admindata//div[@class='bottom']")
	private WebElement userRole;
	
	@FindBy(css = "canvas[basechart]")
	private List<WebElement> charts;
	
	@FindBy(xpath = "//div[@routerlink='/user' and contains(@class,'value')]")
	private WebElement userCountCard;
	
	@FindBy(xpath = "//div[@routerlink='/program' and contains(@class,'value')]")
	private WebElement programCountCard;
	
	@FindBy(xpath = "//div[contains(@class,'value')]/div[@class='bottom' and normalize-space()='Staff']/parent::div")
	private WebElement staffCountCard;
	
	@FindBy(xpath = "//div[@routerlink='/batch' and contains(@class,'value')]")
	private WebElement batchCountCard;
	
	@FindBy(xpath = "//app-staffdata//mat-table")
	private WebElement staffDataTable;
	
	@FindBy(xpath = "//app-staffdata//mat-header-cell[contains(@class,'mat-column-userId')]")
	private WebElement staffTableNumberHeader;
	
	@FindBy(xpath = "//app-staffdata//mat-header-cell[contains(@class,'mat-column-userFirstName')]")
	private WebElement staffTableFirstNameHeader;
	
	@FindBy(xpath = "//app-staffdata//mat-header-cell[contains(@class,'mat-column-userLastName')]")
	private WebElement staffTableLastNameHeader;
	
	@FindBy(xpath = "//app-staffdata//mat-header-cell[contains(@class,'mat-column-userPhoneNumber')]")
	private WebElement staffTablePhoneHeader;
	
	//For Batch 
	@FindBy(xpath = "//button/span[contains(text(),'Batch')]")
    WebElement batchNavLink;
   

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
	
	public boolean isLoginPageDisplayed() {
	    return driver.getCurrentUrl().contains("login");
	}
    
	public boolean isApplicationTitleAtTopLeft() {

	    int titleX = applicationTitle.getLocation().getX();
	    int titleY = applicationTitle.getLocation().getY();

	    int toolbarX = navigationBar.getLocation().getX();
	    int toolbarY = navigationBar.getLocation().getY();

	    return titleX <= toolbarX + 50 &&
	           titleY <= toolbarY + 50;
	}
	
	public boolean isNavigationBarAtTopRight() {

	    int toolbarWidth = navigationBar.getSize().getWidth();

	    int navigationX = navigationMenu.getLocation().getX();
	    int navigationWidth = navigationMenu.getSize().getWidth();

	    int navigationRightEdge = navigationX + navigationWidth;

	    int toolbarRightEdge =
	            navigationBar.getLocation().getX() + toolbarWidth;

	    return navigationRightEdge >= toolbarRightEdge - 50;
	}
	

	
	public boolean isNavigationBarTextCorrect() {

	    return homeButton.getText().trim().equals("Home")
	            && programButton.getText().trim().equals("Program")
	            && batchButton.getText().trim().equals("Batch")
	            && logoutButton.getText().trim().equals("Logout");
	}
	
	public String getApplicationTitleText() {
	    return applicationTitle.getText().trim();
	}
	
	public boolean isHomeFirstInNavigationBar() {

	    return homeButton.getLocation().getX()
	            < programButton.getLocation().getX()
	            && homeButton.getLocation().getX()
	            < batchButton.getLocation().getX()
	            && homeButton.getLocation().getX()
	            < logoutButton.getLocation().getX();
	}
	
	public boolean isProgramSecondInNavigationBar() {

	    List<WebElement> navigationButtons =
	            navigationBar.findElements(By.tagName("button"));

	    return navigationButtons.size() >= 2
	            && navigationButtons.get(1).getText().trim().equals("Program");
	}
	
	public boolean isBatchThirdInNavigationBar() {

	    List<WebElement> navigationButtons =
	            navigationBar.findElements(By.tagName("button"));

	    return navigationButtons.size() >= 3
	            && navigationButtons.get(2).getText().trim().equals("Batch");
	}
	
	public void printNavigationButtons() {

	    List<WebElement> navigationButtons =
	            navigationBar.findElements(By.tagName("button"));

	    for (int i = 0; i < navigationButtons.size(); i++) {
	        System.out.println(
	                "Position " + (i + 1) + ": "
	                + navigationButtons.get(i).getText().trim()
	        );
	    }
	}
	
	public boolean isLogoutInFifthPosition() {

	    List<WebElement> navButtons = navigationBar.findElements(By.tagName("button"));

	    if (navButtons.size() < 5) {
	        return false;
	    }

	    return navButtons.get(4).getText().trim().equals("Logout");
	}
	
	public boolean isWelcomeMessageWithUserNameAndRoleDisplayed() {

	    String welcomeText = welcomeMessage.getText().trim();
	    String roleText = userRole.getText().trim();

	    return welcomeText.contains("Welcome")
	            && welcomeText.contains("Lmshackathon@gmail.com")
	            && roleText.equalsIgnoreCase("ADMIN");
	}
	
	public boolean isBarChartDisplayed() {
	    return charts.stream().anyMatch(WebElement::isDisplayed);
	}
	
	public boolean isUserCountDisplayed() {
	    return userCountCard.isDisplayed();
	}
	
	public boolean isProgramCountDisplayed() {
	    return programCountCard.isDisplayed();
	}
	
	public boolean isStaffCountDisplayed() {
	    return staffCountCard.isDisplayed();
	}
	
	public boolean isBatchCountDisplayed() {
	    return batchCountCard.isDisplayed();
	}
	
	public boolean isStaffDataTableDisplayed() {
	    return staffDataTable.isDisplayed();
	}
	
	public boolean isStaffTableNumberHeaderDisplayed() {
	    return staffTableNumberHeader.isDisplayed()
	            && staffTableNumberHeader.getText().trim().equals("#");
	}
	
	public boolean isStaffTableFirstNameHeaderDisplayed() {
	    return staffTableFirstNameHeader.isDisplayed()
	            && staffTableFirstNameHeader.getText().trim().equals("First Name");
	}
	
	public boolean isStaffTableLastNameHeaderDisplayed() {
	    return staffTableLastNameHeader.isDisplayed()
	            && staffTableLastNameHeader.getText().trim().equals("Last Name");
	}
	
	public boolean isStaffTablePhoneHeaderDisplayed() {
	    return staffTablePhoneHeader.isDisplayed()
	            && staffTablePhoneHeader.getText().trim().equals("Phone");
	}
	
	public void clickLogout() {
	    safeClick(logoutButton);
	}
	
	//For Batch page
	 public void clickBatchInNavBar() {
	        safeClick(batchNavLink);
	    }

}
