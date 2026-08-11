package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import driver.Passing_Driver;



public class ProgramPage extends CommonMethod {
	
	
	
	 List<WebElement> manageProgramMenuItems=new ArrayList<>();
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
	@FindBy(xpath="//div[@class='p-checkbox p-component']")
	private WebElement checkBoxWithManageProgram;
	@FindBy(css = "p-tablecheckbox")
	private List<WebElement> tableCheckbox;
	@FindBy(css = "p-sorticon")
	private List<WebElement> tableSorticon;
	@FindBy(css = ".p-datatable-tbody")
	private List<WebElement> tablebody;
	@FindBy(css = "#editProgram")
	private List<WebElement> editPrograms;
	@FindBy(css = "#deleteProgram")
	private List<WebElement> deletePrograms;
	@FindBy(xpath= "//p-table/div/div[2]/div")
	private WebElement paginationfooter;
	@FindBy(xpath = "//p-table/div/p-paginator/div/span[1]")
	private WebElement paginationInfoUI;
	@FindBy(xpath = "//p-table/div/p-paginator/div/button[1]/span")
	private WebElement doubleLeftIcon;
	@FindBy(xpath = "//p-table/div/p-paginator/div/button[4]/span")
	private WebElement doubleRightIcon;
	@FindBy(xpath = "//p-table/div/p-paginator/div/button[2]")
	private WebElement leftIcon;
	@FindBy(xpath = "//p-table/div/p-paginator/div/button[3]")
	private WebElement rightIcon;
	
	//--------------------Add New Program----------------------------------------
	
	@FindBy(xpath = "//app-program/p-dialog/div/div")
	private WebElement popUp;
	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement cancelButton;
	@FindBy(xpath = "//span[text()='Program Details']")
	private WebElement titlePopUp;
	@FindBy(xpath = "//label[text()='Name']")
	private WebElement programName;
	@FindBy(xpath = "//span[text()='*']")
	private WebElement astreik;
	@FindBy(id = "saveProgram")
	private WebElement saveProgram;
	@FindBy(xpath = "//app-program/p-dialog/div/div/div[2]/div[1]/small")
	private WebElement requiredText;
	@FindBy(id = "programName")
	private WebElement pname;
	@FindBy(xpath = "//Label[@for='programDescription']")
	private WebElement pDescription;
	@FindBy(xpath = "//p-radiobutton[@id='category']//input[@value='Active']")
	private WebElement active;
	@FindBy(xpath = "//p-radiobutton[@id='category']//input[@value='Inactive']")
	private WebElement inActive;
	@FindBy(xpath = "//*[@id='saveProgram']/span[2]")
	private WebElement save;
	@FindBy(xpath = "//app-program/p-toast/div/p-toastitem/div/div/div/div[2]")
	private WebElement successMsg;
	@FindBy(xpath = "//div[text()='Program Created Successfully']")
	private WebElement enteredPName;
	@FindBy(css = "button.p-dialog-header-close")
	private WebElement xButton;
	@FindBy(xpath="//small[text()='Program name is required.']")
	private WebElement pNameRequired;
	@FindBy(xpath="//small[text()='Status is required.']")
	private WebElement pStatusRequired;
	@FindBy(xpath="//input[@id='programName']")
	private WebElement programNameTextBox;
	@FindBy(xpath="//input[@id='programDescription']")
	private WebElement programDescTextBox;
	@FindBy(xpath="//div[@class='p-radiobutton-box']")
	private WebElement activeradiobutton;
	@FindBy(xpath="//app-program/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[1]/td[2]")
	private WebElement enteredProgramName;
	@FindBy(xpath="//input[@id='programDescription']")
	private WebElement enteredDescription;
	@FindBy(xpath= "//button[@id='editProgram']")
	private WebElement editButton;
	@FindBy(xpath="//small[@class='p-invalid ng-star-inserted']")
	private WebElement errorMsgUnderPname;
	
	// Pagination frame locators
	@FindBy(xpath = "//span[contains(@class, 'p-paginator-current')]")
	private WebElement currentEntriesText;
	@FindBy(xpath = "//button[contains(@class, 'p-paginator-first')]")
	private WebElement firstButton;
	@FindBy(xpath = "//button[contains(@class, 'p-paginator-prev')]")
	private WebElement prevButton;
	@FindBy(xpath = "//button[contains(@class, 'p-paginator-next')]")
	private WebElement nextButton;
	@FindBy(xpath = "//button[contains(@class, 'p-paginator-last')]")
	private WebElement lastButton;
	
	// Deletion locators
	@FindBy(xpath="//span[@class='p-button-icon pi pi-trash']")
	private WebElement deleteBtn;
	@FindBy(xpath = "//div[contains(@class,'p-dialog-header')]")
	private WebElement deleteDialogBox;
	@FindBy(xpath="//button[.//span[normalize-space()='Yes']]")
	private WebElement confirmationDelete;
	@FindBy(xpath = "//p-toastitem//*[contains(normalize-space(),'Program Deleted')]")
	private WebElement successDeletionMessage;
	// delete multiple program locators
	@FindBy(xpath = "//div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[1]/td[1]/p-tablecheckbox/div/div[2]")
	private WebElement checkbox1;
	@FindBy(xpath = "//div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[3]/td[1]/p-tablecheckbox/div/div[2]")
	private WebElement checkbox2;
	@FindBy(xpath = "//div/mat-card/mat-card-title/div[2]/div[1]/button/span[1]")
	private WebElement dubdelete_icon;
	@FindBy(xpath = "//button//span[text()='Yes']")
	private WebElement dubdelete_yes;
	@FindBy(xpath = "//div/p-toastitem/div/div/div/div[2]")
	private WebElement success_dbdelete;

	
	//Search locators
	@FindBy(xpath = "//tbody//td[2]")
	List<WebElement> listOfProgramNames;
	@FindBy(xpath = "//tbody//td[3]")
	List<WebElement> listOfDescription;
	@FindBy(xpath="//span[text()='Showing 0 to 0 of 0 entries']")
	private WebElement msgShowing0Entries;

	//Sorting locators
	// sort icons
	@FindBy(xpath = "//thead//tr//th[2]//i")
	private WebElement programNameSort;
	@FindBy(xpath = "//thead//tr//th[3]//i")
	private WebElement programDescriptionSort;
	@FindBy(xpath = "//thead//tr//th[4]//i")
	private WebElement programStatusSort;
	// list
	@FindBy(xpath = "//tbody//td[2]")
	private List<WebElement> programNameList;
	@FindBy(xpath = "//tbody//td[3]")
	private List<WebElement> programDescriptionList;
	@FindBy(xpath = "//tbody//td[4]")
	private List<WebElement> programStatusList;
	
	

	
	
	
		public ProgramPage(Passing_Driver driver) throws IOException {
		super(driver); 
	}
		public void navigateToHomePage() {
			driver.get(config.getProperty("baseUrl"));
		}
	
				
		public void loginIntoApp() throws IOException {		
		loginAsAdmin();
	}
		
		public Boolean isDashboardDisplayed() {
			return dashboardHeader.isDisplayed();
		}
		
		public void clickOnProgramBtn() {
			safeClick(programBtn);
		}
		
		public String isOnProgramPage() {
			return manageProgram.getText();	}
		
		
		
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
		    List<WebElement> manageProgramMenuItems = driver.findElements(
		        By.xpath("//tr[th[contains(normalize-space(), 'Program Name')]]/th[position() > 1]"));

		    List<String> itemTextList = new ArrayList<>();
		    for (WebElement item : manageProgramMenuItems) {
		        itemTextList.add(item.getText().trim());
		    }

		    return itemTextList;
		}
		
		public boolean ischeckBoxDisplayed() {
			return !(searchBox.isSelected());
		}
		
		public boolean testAreUnchecked() {
		    for (WebElement checkbox : tableCheckbox) {
		        if (checkbox.isSelected()) {
		            return false;
		        }
		    }
		    return true;
		}
		
		public boolean testSortArrowsVisibility() {
		    for (WebElement item : manageProgramMenuItems) {
		        String itemText = item.getText().trim();
		        boolean hasSortArrow = false;

		        for (WebElement sortIcon : tableSorticon) {
		            if (item.findElements(By.xpath(".//p-sorticon")).contains(sortIcon)) {
		                hasSortArrow = true;
		                break;
		            }}
		          if ("Edit / Delete".equals(itemText) || itemText.isEmpty()) {
		            if (hasSortArrow) {
		                return false;
		            }
		        } else {
		            if (!hasSortArrow) {
		                return false;
		            }     }	    }
		    return true;
		}
		
		public boolean testEditDeleteButtonsPresence() {

		    for (WebElement editButton : editPrograms) {
		        if (!editButton.isDisplayed()) {
		            return false;
		        }
		    }
		    for (WebElement deleteButton : deletePrograms) {
		        if (!deleteButton.isDisplayed()) {
		            return false;
		        }	    }
		    return true;
		}

		public boolean testPaginationTextIcons() {

		    String paginationText = paginationInfoUI.getText().trim();
		    String expectedPattern = "Showing \\d+ to \\d+ of \\d+ entries";

		    if (!paginationText.matches(expectedPattern)) {
		        return false;
		    }
		    if (!doubleLeftIcon.isDisplayed()) {
		        return false;
		    }
		    if (!doubleRightIcon.isDisplayed()) {
		        return false;
		    }
		    if (!leftIcon.isDisplayed()) {
		        return false;
		    }
		    if (!rightIcon.isDisplayed()) {
		        return false;
		    }
		    return true;
		}
		
		public boolean testPaginationFooter() {

		    String paginationTextFooter = paginationfooter.getText().trim();
		    String expectedPatternFooter = "In total there are \\d+ programs.";
		    return paginationTextFooter.matches(expectedPatternFooter);
		}
		
		
		
	
		
		
		public void clickAddNewProgram() {
		    safeClick(addNewProgram); ;
		}

		public boolean isProgramDetailsDialogDisplayed() {
		    return isDisplayed(popUp);
		}

		public String getProgramDetailsTitle() {
		    return titlePopUp.getText().trim();
		}

		public boolean isMandatoryFieldAsteriskDisplayed() {
		    return isDisplayed(astreik);
		}

		public String getRequiredFieldMessage() {
		    return requiredText.getText().trim();
		}

		public boolean isNameTextBoxDisplayed() {
		    return isDisplayed(pname);
		}

		public boolean isDescriptionTextBoxDisplayed() {
		    return isDisplayed(pDescription);
		}

		public boolean areStatusRadioButtonsDisplayed() {
		    return isDisplayed(active) && isDisplayed(inActive);
		}

		public void clickCancelButton() {
		    		    safeClick(cancelButton);
		}

		public void clickSaveProgramButton() {
		    		    safeClick(saveProgram);
		}

		public void enterProgramName(String name) {
		    pname.sendKeys(name);
		}

		public String getEnteredProgramName() {
		    return pname.getAttribute("ng-reflect-model");
		}

		public void enterDescription(String description) {
		    pDescription.sendKeys(description);
		}

		public String getEnteredDescription() {
		    return pDescription.getAttribute("ng-reflect-model");
		}

		public void clickActiveStatus() {
		        safeClick(active);
		}

		public boolean isActiveStatusSelected() {
		    return active.isSelected();
		}

		public void clickSaveButton() {
		        safeClick(saveProgram);
		}

		public String getSuccessMessage() {
		    return successMsg.getText().trim();
		}

		public void clickSearch() {
		        safeClick(searchBox);
		}

		public void enterSearchText(String programName) {
		    searchBox.sendKeys(programName);
		}

		public String getSearchResultProgramName() {
		    return enteredPName.getText().trim();
		}

		public void clickXButton() {
		       safeClick(xButton);
		}

		public boolean isProgramDetailsDialogClosed() {
		    return !isDisplayed(popUp);
		}
		
		public String getRequiredProgramNameMsg() {
			return getText(pNameRequired);		
			
		}
		
		public String getRequiredProgramStatusMsg() {
			return getText(pStatusRequired);		
			
		}
		
		public void mandotaryFieldName() throws IOException {
			programNameTextBox.sendKeys(excelReader.getData("Program", "CreateProgram", "Program Name"));
			programDescTextBox.sendKeys(excelReader.getData("Program", "CreateProgram", "Program Description"));
		 	safeClick(activeradiobutton);
			
		}
		
        public void enterProgramNameInSearchBox(String programName) {
        	   getText(enteredProgramName);
        	   
        }

        public String searchForProgram() throws IOException {  	   
        	searchBox.sendKeys(excelReader.getData("Program", "Search Program Name", "Program Name"));
        	String searchText =	getText(enteredProgramName);
	    	return searchText;
	    		    	
	    }
        
      
        
        
        public String searchForProgramDescription() throws IOException {  	   
        	searchBox.sendKeys(excelReader.getData("Program", "Search Program Description ", "Program Description"));
        	String searchText =	getText(enteredDescription);
	    	return searchText;
	    		    	
	    }
		
        public void clickOnEditButton() {
            clickOnButton(editButton);
        }

        public void editProgramName() throws IOException {
            programNameTextBox.clear();
            programNameTextBox.sendKeys(excelReader.getData("Program", "Edit Program Name ", "Program Name"));
        }
		
        public void editProgramDescription() throws IOException {
            programDescTextBox.clear();
            programDescTextBox.sendKeys(excelReader.getData("Program", "Edit Program Description ", "Program Description"));
        }
		
        public String searchForUpdatedProgram() throws IOException {  	   
        	searchBox.sendKeys(excelReader.getData("Program", "Search Updated Program", "Program Name"));
        	String searchText =	getText(enteredProgramName);
	    	return searchText;
	    		    	
	    }
        
        public void invalidProgramName() throws IOException {
            programNameTextBox.clear();
            programNameTextBox.sendKeys(excelReader.getData("Program", "Invalid Program Name ", "Program Name"));
        }
        
        public String errorMsg() {
        	return getText(errorMsgUnderPname);
        }
        
        
     //---------------------------------------------------------------------------------------
        public void clickOnDeletionBtn() {
        	clickOnButton(deleteBtn);
        }
        
        public boolean isDeleteDialogBoxDisplayed() {
        	return isDisplayed(deleteDialogBox);
        }
        
        public void clickOnSearchBox() {
        	clickOnButton(searchBox);
        }
        
                    
        public String getSuccessDeletionMessage() {
            return successDeletionMessage.getText();
        }
        
        public void clickXButton1() {
            wait.until(ExpectedConditions.visibilityOf(xButton));

            wait.until(driver -> {
                try {
                    return xButton.isDisplayed() && xButton.isEnabled();
                } catch (Exception e) {
                    return false;
                }
            });

            new Actions(driver).moveToElement(xButton).pause(Duration.ofMillis(500)).click().perform();
        }
        
        public void SelectCheckBoxes() {
    		actions.doubleClick(checkbox1).perform();
    		checkbox2.click();
    		System.out.println("this function executed:");

    	}

    	public void MultipleDelete() {
    		wait.until(ExpectedConditions.elementToBeClickable(dubdelete_icon)).click();

    	}

    	public void DeleteSuccess() {
    		clickOnButton(dubdelete_yes);//.click();
    		String text2;
    		text2 = success_dbdelete.getText();
    		System.out.println(text2);
    	}
    	
    	public void multipleDeleteButtonEnabled() {
    		dubdelete_icon.isEnabled();
    	}
    
    //----------------------------------------------------------------------------------------------
    	public void searhBoxValidation(String field, String value) throws InterruptedException {
    		js.executeScript("arguments[0].click();", searchBox);
    		//boolean found = false;
    		switch (field) {
    		case "Program Name":
    			searchBox.sendKeys(value);
    			logicForValidatingSearch(listOfProgramNames, value);
    			break;
    		case "Description":
    			searchBox.sendKeys(value);
    			logicForValidatingSearch(listOfDescription, value);
    			break;
    		 		}
    	}

    	public void logicForValidatingSearch(List<WebElement> searchedValues, String value) {
    		boolean found = false;
    		for (WebElement v : searchedValues) {
    			if (v.getText().equalsIgnoreCase(value)) {
    				System.out.println("Search is success for value: " + value);
    				found = true;
    				break;
    			}  		}
    		if (!found) {
    			System.out.println("Search is not success for value: " + value);
    		}
    	}
        
    	
    	public void invalidSearch() {
    		searchBox.sendKeys("Dona");
    	}
    	
    	public String zeroEntriesMsg() {
    		return getText(msgShowing0Entries);
    	}
    	
    	
    	//--------------------------------------------------------------------------------------------
    	
    	public void clickProgramNameSort() {
    	    clickSortArrow(programNameSort, programNameList);
    	    clickSortArrow(programNameSort, programNameList);
    	}

    	public void clickProgramNameSortDec() {
    	    clickSortArrow(programNameSort, programNameList);
    	    clickSortArrow(programNameSort, programNameList);
    	    clickSortArrow(programNameSort, programNameList);
    	}

    	public void clickProgramDescriptionSort() {
    	    clickSortArrow(programDescriptionSort, programDescriptionList);
    	    clickSortArrow(programDescriptionSort, programDescriptionList);
    	}

    	public void clickProgramDescriptionSortDec() {
    	    clickSortArrow(programDescriptionSort, programDescriptionList);
    	    clickSortArrow(programDescriptionSort, programDescriptionList);
    	    clickSortArrow(programDescriptionSort, programDescriptionList);
    	}

    	public void clickProgramStatusSort() {
    	    clickSortArrow(programStatusSort, programStatusList);
    	    clickSortArrow(programStatusSort, programStatusList);
    	}

    	public void clickProgramStatusSortDec() {
    	    clickSortArrow(programStatusSort, programStatusList);
    	    clickSortArrow(programStatusSort, programStatusList);
    	    clickSortArrow(programStatusSort, programStatusList);
    	}

    	private void clickSortArrow(WebElement sortArrow, List<WebElement> columnList) {
    	    wait.until(ExpectedConditions.elementToBeClickable(sortArrow));
    	    actions.click(sortArrow).perform();
    	    wait.until(ExpectedConditions.visibilityOfAllElements(columnList));
    	}

    	public List<String> getOriginalList(String type) {
    	    List<String> originalList = null;

    	    if (type.equals("ProgramName")) {
    	        originalList = printWebElements(programNameList);
    	    } else if (type.equals("Description")) {
    	        originalList = printWebElements(programDescriptionList);
    	    } else {
    	        originalList = printWebElements(programStatusList);
    	    }
    	    return originalList;
    	}

    	public boolean isColumnSortedAscending(String type) {
    	    List<String> actual = getOriginalList(type).stream()
    	            .filter(s -> s != null && !s.trim().isEmpty())
    	            .collect(Collectors.toList());

    	    List<String> expected = new ArrayList<>(actual);
    	    expected.sort(String.CASE_INSENSITIVE_ORDER);

    	    return actual.equals(expected);
    	}

    	public boolean isColumnSortedDescending(String type) {
    	    List<String> actual = getOriginalList(type).stream()
    	            .filter(s -> s != null && !s.trim().isEmpty())
    	            .collect(Collectors.toList());

    	    List<String> expected = new ArrayList<>(actual);
    	    expected.sort(String.CASE_INSENSITIVE_ORDER.reversed());

    	    return actual.equals(expected);
    	}

    	private List<String> printWebElements(List<WebElement> options) {
    	    List<String> texts = new ArrayList<>();
    	    for (WebElement option : options) {
    	        texts.add(option.getText().trim());
    	    }
    	    return texts;
    	}
    	
    	
    	
    	
    	
    	
    	
   //---------------------------------------------------------------------------------------------     
        public boolean isNextButtonEnabled() {
            return !nextButton.getAttribute("class").contains("p-disabled");
        }

        public boolean isPrevButtonEnabled() {
            return !prevButton.getAttribute("class").contains("p-disabled");
        }

        public boolean isFirstButtonEnabled1() {
            return !firstButton.getAttribute("class").contains("p-disabled");
        }
        
        public boolean isFirstButtonEnabled() {

            String className = firstButton.getAttribute("class");

            System.out.println("FIRST button class: " + className);

            return !className.contains("p-disabled");
        }
        
        public void clickNextPage1() {
            if (isNextButtonEnabled()) {
           clickOnButton(nextButton);
            }
        }
        
        public void clickNextPage() {

            System.out.println("NEXT class BEFORE click: "
                    + nextButton.getAttribute("class"));

            System.out.println("NEXT enabled BEFORE click: "
                    + isNextButtonEnabled());

            if (isNextButtonEnabled()) {
                clickOnButton(nextButton);
            }
        }

        public void clickPreviousPage1() {
            if (isPrevButtonEnabled()) {
            	clickOnButton(prevButton);
            }
        }
        public void clickPreviousPage() {

            System.out.println("PREVIOUS class BEFORE click: "
                    + prevButton.getAttribute("class"));

            System.out.println("PREVIOUS enabled BEFORE click: "
                    + isPrevButtonEnabled());

            if (isPrevButtonEnabled()) {
                clickOnButton(prevButton);
            }
        }

        public void clickFirstPage() {           
            clickOnButton(firstButton);
        }

        public void clickLastPage() {            
            clickOnButton(lastButton);
        }

        public String getCurrentEntriesText() {
            return currentEntriesText.getText().trim();
}
}
