package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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
	private WebElement dashboardHeader;
	@FindBy(xpath="//span[text()='Program']")
	private WebElement programBtn;
	@FindBy(xpath="//button[text()='Add New Program']")
	private WebElement addNewProgram;
	@FindBy(xpath="//div[text()=' Manage Program']")
	private WebElement manageProgram;
	@FindBy(xpath = "//mat-card")
	private WebElement programPanel;
	@FindBy(xpath = "//button[@icon='pi pi-trash']")
	private WebElement multipleDeletetn;
	@FindBy(xpath="//input[@placeholder='Search...']")
	private WebElement searchBox;
	@FindBy(xpath=("//*[@class='p-datatable-thead']/tr"))
	private WebElement manageprogramTable;
	
	
	
	
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
		
		public void clickOnProgramBtn() {
			safeClick(programBtn);
		}
		
		public boolean isOnProgramPage() {
			return waitForUrlContains("program");
		}
		
		public String isAddNewProgramDisplayed() {
			return getText(addNewProgram);
		}
		
		public String isManageProgramDisplayed() {
			return getText(manageProgram);
			
		}
		
		public int getManageProgramHeading() {
			return manageProgram.getLocation().getX();
		}
		
		public int getProgramPanel() {
			return programPanel.getLocation().getX();
		}
		
		
		public int getDeleteBtnPx() {
			return multipleDeletetn.getLocation().getX();
		}
		
		public boolean isMultipleDeleteButtonDisabled() {
			return multipleDeletetn.isEnabled();
		}
		
		public boolean isSearchBarDisplayed() {
			return searchBox.isDisplayed();
		}
		
		public String getSearchPlaceholder() {
		    return searchBox.getAttribute("placeholder");
		}
		
		public List<String> testManageProgramMenu() {

		//	List<WebElement> manageProgramMenuItems = manageProgram.findElements(By.tagName("th"));
			 List<WebElement> manageProgramMenuItems = driver.findElements(
				        By.xpath("//tr[th[contains(normalize-space(), 'Program Name')]]/th[position() > 1]")
				    );
		    List<String> itemTextList = new ArrayList<>();

		    for (WebElement item : manageProgramMenuItems) {
		        itemTextList.add(item.getText().trim());
		    }

		    return itemTextList;
		}
		
		
}
