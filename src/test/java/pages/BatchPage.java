package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import driver.Passing_Driver;

public class BatchPage extends CommonMethod {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public BatchPage(Passing_Driver passdr) throws IOException {
	super(passdr); 
	loginPage = new LoginPage(passdr);
	homePage = new HomePage(passdr);
}

	// =========== BATCH PAGE ELEMENTS ============
	
	@FindBy(xpath = "//div[normalize-space()='Manage Batch']")
	WebElement manageBatchTitle;
	
	@FindBy(xpath = "//button[contains(text(),'Add New Batch')]")
	WebElement addNewBatch;
	
	@FindBy(css = "div[class='box'] button[class*='p-button-danger']")
	WebElement multiDeleteButton;
	
	@FindBy(css = "button [class*='p-paginator-icon']")
	List<WebElement> paginatorControls;
	
	@FindBy(css = "[class='p-datatable-tbody'] tr")
	List<WebElement> tableRows;
	
	@FindBy(css = "[class='p-datatable-tbody'] tr [class*='pi-pencil']")
	List<WebElement> editIcons;
	
	@FindBy(css = "[class='p-datatable-tbody'] tr [class*='pi-trash']")
	List<WebElement> deleteIcons;
	
	@FindBy(css = "tbody [role='checkbox']")
	List<WebElement> rowCheckboxes;
	
	@FindBy(css = "table th:not(:has([role='checkbox']))")
	List<WebElement> tableHeaders;
	
	@FindBy(css = "table th [role='checkbox']")
	WebElement headerCheckbox;
	
	@FindBy(css = "[class*='p-sortable-column-icon']")
	List<WebElement> sortIcons;
	
	@FindBy(css = "[role='dialog']")
	WebElement dialog;
	
	@FindBy(css = "table th[role='columnheader']")
	List<WebElement> sortableColumnHeaders;
	
	
	// =========== BATCH PAGE VERIFICATIONS ============
	
	
	public void navigateToHomePageAfterLogin() {
	    navigateToApplication();
	    loginPage.enterUsername(config.getProperty("username"));
	    loginPage.enterPassword(config.getProperty("password"));
	    loginPage.selectRole("Admin");
	    loginPage.clickLoginButton();
	}
	
    public void navigateToBatchPage() {
        homePage.clickBatchInNavBar();
    }
    
    public boolean isOnManageBatchPage() {
        return isDisplayed(manageBatchTitle);
    }
    
    public String getSubMenuText() {
        return getText(addNewBatch);
    }
    
    public String getPageHeadingText() {
        return getText(manageBatchTitle);
    }
	
    public boolean isMultiDeleteButtonDisabled() {
        String disabledAttr = multiDeleteButton.getAttribute("disabled");
        return disabledAttr != null;
    }
    
    public boolean isPaginationControlsDisplayed() {
        return paginatorControls.size() > 0;
    }
	
    public boolean isEditIconDisplayedInEachRow() {
        return editIcons.size() == tableRows.size() && tableRows.size() > 0;
    }
    
    public boolean isDeleteIconDisplayedInEachRow() {
        return editIcons.size() == tableRows.size() && tableRows.size() > 0;
    }
    
    public boolean isCheckboxDisplayedInEachRow() {
        return rowCheckboxes.size() == tableRows.size() && tableRows.size() > 0;
    }
    
    public boolean areDatatableHeadersDisplayed() {
        List<String> expectedHeaders = Arrays.asList(
            "Batch Name",
            "Batch Description",
            "Batch Status",
            "No Of Classes",
            "Program Name",
            "Edit / Delete"
        );
        
        List<String> actualHeaders = new ArrayList<>();
        for (WebElement header : tableHeaders) {
            actualHeaders.add(header.getText().trim());
        }
        System.out.println("Actual headers: " + actualHeaders);
        return actualHeaders.containsAll(expectedHeaders);
    }
    
    public boolean isHeaderCheckboxDisplayed() {
        return isDisplayed(headerCheckbox);
    }
    
    public boolean areSortIconsDisplayedForAllHeaders() {
        return sortIcons.size() > 0 && sortIcons.size() == sortableColumnHeaders.size();
    }
    
    public void clickAddNewBatchMenuItem() {
    	homePage.clickBatchInNavBar();
        safeClick(addNewBatch);
    }

    public boolean isBatchDetailsDialogDisplayed() {
        return isDisplayed(dialog);
    }

}
