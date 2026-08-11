package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import driver.Passing_Driver;
import utilities.ExcelReaderFile;

public class BatchDetailsPage extends CommonMethod {

	BatchPage batchPage;

	public BatchDetailsPage(Passing_Driver passdr) throws IOException {
		super(passdr);
		batchPage = new BatchPage(passdr);
	}

	//private ExcelReaderFile excelReader = new ExcelReaderFile(config.getProperty("loginTestDataPath"));

	private String getBatchData(String testCaseName, String columnName) throws IOException {
		return excelReader.getData("Batch", testCaseName, columnName);
	}

	// =========== BATCH DETAILS PAGE ELEMENTS ============

	@FindBy(css = "input[id='batchName']")
	WebElement batchNameSuffix;

	@FindBy(css = "#batchNoOfClasses")
	WebElement numberOfClassesField;

	@FindBy(css = "#batchDescription")
	WebElement descriptionField;

	@FindBy(css = "input[role='searchbox']")
	WebElement programNameField;

	@FindBy(css = "button[class*='p-autocomplete']")
	WebElement programNameDropdownButton;

	@FindBy(css = "[class*='p-radiobutton-box']")
	List<WebElement> statusRadioButtons;

	@FindBy(css = "[role='option']")
	List<WebElement> programNameOptions;

	@FindBy(css = "#batchProg")
	WebElement batchNamePrefix;

	@FindBy(css = "#text-danger")
	WebElement batchNameSuffixError;

	@FindBy(xpath = "//button[.//span[normalize-space()='Save']]")
	WebElement saveButton;

	@FindBy(css = "div[role='alert'][class*='p-toast-message']")
	WebElement successMessage;

	@FindBy(css = "[id='batchStatus'][ng-reflect-input-id='Active']")
	WebElement activeRadioButtonInput;

	@FindBy(css = "#Inactive")
	WebElement inactiveRadioButtonInput;

	@FindBy(css = "button[label='Cancel']")
	WebElement cancelButton;

	@FindBy(css = "button.p-dialog-header-close")
	WebElement closeButton;

	@FindBy(xpath = "//span[text()='Batch Details']")
	WebElement batchDetailsHeading;

	@FindBy(id = "batchName")
	WebElement editBatchNameField;

	@FindBy(css = "[class*='p-toast-message-content']")
	WebElement batchUpdateErrortoastMessage;

	@FindBy(xpath = "//*[@id='text-danger'][contains(., 'Number of classes is required.')]")
	WebElement numberOfClassesError;
	
	// =========== BATCH PAGE VERIFICATIONS ============

	public boolean isBatchNameFieldDisplayed() {
		return isDisplayed(batchNameSuffix);
	}

	public boolean isNumberOfClassesFieldDisplayed() {
		return isDisplayed(numberOfClassesField);
	}

	public boolean isDescriptionFieldDisplayed() {
		return isDisplayed(descriptionField);
	}

	public boolean isProgramNameDropdownDisplayed() {
		boolean fieldVisible = isDisplayed(programNameField);
		boolean buttonVisible = isDisplayed(programNameDropdownButton);
		return fieldVisible && buttonVisible;
	}

	public boolean isStatusRadioButtonDisplayed() {
		return statusRadioButtons.size() == 2;
	}

	private String selectedProgramName;

	public void selectProgramName() {
		safeClick(programNameDropdownButton);
		wait.until(ExpectedConditions.visibilityOfAllElements(programNameOptions));
		WebElement firstOption = programNameOptions.get(0);
		selectedProgramName = firstOption.getText().trim();
		safeClick(firstOption);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public void waitForPrefixToPopulate() {
		wait.until(driver -> {
			try {
				return !batchNamePrefix.getText().trim().isEmpty();
			} catch (Exception e) {
				return false;
			}
		});
	}

	public String getSelectedProgramName() {
		return selectedProgramName;
	}

	public String getBatchNamePrefixText() {
		return getText(batchNamePrefix);
	}

	public void enterInvalidAlphabeticBatchSuffix() throws IOException {
		String invalidInput = getBatchData("BatchSuffix_InvalidAlphabeticInput", "Batch Name Suffix");
		safeType(batchNameSuffix, invalidInput);
	}

	public boolean isBatchNameSuffixErrorDisplayed() {
		return isDisplayed(batchNameSuffixError);
	}

	public void enterAlphabetsInPrefixBox() throws IOException {
		String invalidInput = getBatchData("BatchPrefix_InvalidAlphabeticInput", "Batch Name Prefix");

		try {
			batchNamePrefix.clear();
			batchNamePrefix.sendKeys(invalidInput);
		} catch (Exception e) {

		}
	}

	public boolean isPrefixBoxEmpty() {
		return getText(batchNamePrefix).isEmpty();
	}

	public void selectSpecificProgramName(String programName) {

		safeType(programNameField, programName);

		wait.withTimeout(Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfAllElements(programNameOptions));

		for (WebElement option : programNameOptions) {
			if (option.getText().trim().equalsIgnoreCase(programName)) {
				safeClick(option);
				selectedProgramName = programName;
				break;
			}
		}
	}

	public void selectStatus(String status) {
		if (status.equalsIgnoreCase("Active")) {
			safeClick(activeRadioButtonInput);
		} else {
			safeClick(inactiveRadioButtonInput);
		}
	}

	public void enterMandatoryFieldsAndSave() throws IOException {
		String programName = getBatchData("BatchAdd_MandatoryFieldsOnly", "Program Name").trim();
		String rawSuffix = getBatchData("BatchAdd_MandatoryFieldsOnly", "Batch Name Suffix").trim();
		String status = getBatchData("BatchAdd_MandatoryFieldsOnly", "Status").trim();
		String rawNumClasses = getBatchData("BatchAdd_MandatoryFieldsOnly", "Number of Classes").trim();

		System.out.println("Program Name: [" + programName + "]");
		System.out.println("Raw Suffix: [" + rawSuffix + "]");
		System.out.println("Status: [" + status + "]");
		System.out.println("Raw Number of Classes: [" + rawNumClasses + "]");

		// Batch Name Suffix - digits only, kept as String
		String suffixDigitsOnly = rawSuffix.replaceAll("[^0-9]", "");
		String baseSuffix = suffixDigitsOnly.isEmpty() ? "1" : suffixDigitsOnly;

		// Number of Classes - digits only, parsed as int for validation, back to String
		String classesDigitsOnly = rawNumClasses.replaceAll("[^0-9]", "");
		int numClassesInt;
		try {
			numClassesInt = classesDigitsOnly.isEmpty() ? 1 : Integer.parseInt(classesDigitsOnly);
		} catch (NumberFormatException e) {
			numClassesInt = 1;
		}
		String numClasses = String.valueOf(numClassesInt);

		selectSpecificProgramName(programName);

		String combinedSuffix = baseSuffix + (System.currentTimeMillis() % 100);
		String finalSuffix = combinedSuffix.length() > 5 ? combinedSuffix.substring(0, 5) : combinedSuffix;

		System.out.println("Final suffix to type: [" + finalSuffix + "]");
		safeType(batchNameSuffix, finalSuffix);
		System.out
				.println("Batch Name Suffix field value after typing: [" + batchNameSuffix.getAttribute("value") + "]");

		selectStatus(status);

		safeType(numberOfClassesField, numClasses);
		System.out.println(
				"Number of Classes field value after typing: [" + numberOfClassesField.getAttribute("value") + "]");

		clickOnButton(saveButton);
		batchPage.closeToastIfPresent();
	}

	public boolean isSuccessMessageDisplayed() {
		String toastText = successMessage.getText().replaceAll("\\s+", " ").trim();
		return toastText.equals("Successful Batch Created Successfully");
	}

	public void leaveMandatoryFieldBlankAndSave() throws IOException {
		String programName = getBatchData("BatchAdd_MandatoryFieldBlank", "Program Name");
		String status = getBatchData("BatchAdd_MandatoryFieldBlank", "Status");
		String numClasses = getBatchData("BatchAdd_MandatoryFieldBlank", "Number of Classes");

		selectSpecificProgramName(programName);
		selectStatus(status);
		safeType(numberOfClassesField, numClasses);
		safeClick(saveButton);
	}

	public boolean isMandatoryFieldErrorDisplayed() {
		return isDisplayed(batchNameSuffixError);
	}

	public void enterValidDataAndCancel() throws IOException {
		String programName = getBatchData("BatchAdd_MandatoryFieldsOnly", "Program Name");
		String suffix = getBatchData("BatchAdd_MandatoryFieldsOnly", "Batch Name Suffix");
		String status = getBatchData("BatchAdd_MandatoryFieldsOnly", "Status");
		String numClasses = getBatchData("BatchAdd_MandatoryFieldsOnly", "Number of Classes");

		selectSpecificProgramName(programName);
		safeType(batchNameSuffix, suffix);
		selectStatus(status);
		safeType(numberOfClassesField, numClasses);

		System.out.println("About to click Cancel button. Displayed: " + cancelButton.isDisplayed() + ", Enabled: "
				+ cancelButton.isEnabled());
		safeClick(cancelButton);
		System.out.println("Cancel button clicked");
	}

	public void clickCloseIcon() {
		safeClick(closeButton);
	}

	public boolean isDialogClosed() {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[role='dialog']")));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean doesPrefixContainSelectedProgramName() {
		String prefixText = getBatchNamePrefixText();
		String selected = getSelectedProgramName();
		return prefixText.contains(selected);
	}

	public boolean isBatchDetailsHeadingDisplayed() {
		return isDisplayed(batchDetailsHeading);
	}

	public boolean isBatchNameFieldDisabled() {
		String disabledAttr = editBatchNameField.getAttribute("disabled");
		return disabledAttr != null;
	}

	public void updateFieldWithInvalidData(String field) throws IOException {
		if (field.equalsIgnoreCase("Description")) {
			String invalidDescription = getBatchData("EditBatch_InvalidDescription", "Description").trim();
			safeType(descriptionField, invalidDescription);
		} else if (field.equalsIgnoreCase("Number of Classes")) {
			numberOfClassesField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			numberOfClassesField.sendKeys(Keys.DELETE);
		}
		clickOnButton(saveButton);
	}

	public boolean isNumberOfClassesErrorDisplayed() {
		return isDisplayed(numberOfClassesError);
	}

	public boolean isBatchUpdateFailedMessageDisplayed() {
		try {
			String toastText = wait.until(ExpectedConditions.visibilityOf(batchUpdateErrortoastMessage)).getText()
					.replaceAll("\\s+", " ").trim();

			System.out.println("Batch update error toast: " + toastText);

			return toastText.contains("Failed Batch Update Failed");

		} catch (TimeoutException e) {
			return false;
		}
	}

	public boolean isErrorDisplayed(String errorType) {
		if (errorType.equalsIgnoreCase("toast error")) {
			return isBatchUpdateFailedMessageDisplayed();
		} else {
			return isNumberOfClassesErrorDisplayed();
		}
	}

	public String fillValidDescriptionAndClasses(String testCaseName) throws IOException {
		wait.until(ExpectedConditions.visibilityOf(batchDetailsHeading));
		wait.until(ExpectedConditions.visibilityOf(descriptionField));

		String rawDescription = getBatchData(testCaseName, "Description").trim();
		String validDescription = rawDescription.length() > 20 ? rawDescription.substring(0, 20) : rawDescription;

		String rawClasses = getBatchData(testCaseName, "Number of Classes").trim();
		String digitsOnly = rawClasses.replaceAll("[^0-9]", "");
		String validClasses = digitsOnly.isEmpty() ? "1" : digitsOnly;

		safeType(descriptionField, validDescription);
		numberOfClassesField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		numberOfClassesField.sendKeys(validClasses);

		return validDescription;
	}

	public void updateWithValidDataAndSave() throws IOException, InterruptedException {
		fillValidDescriptionAndClasses("EditBatch_ValidUpdate");
		Thread.sleep(1000);
		WebElement freshSaveButton = driver.findElement(By.cssSelector("button[label='Save']"));
		freshSaveButton.click();
	}

	public boolean isBatchUpdateSuccessMessageDisplayed() {
		try {
			Thread.sleep(500);
			WebElement freshToast = driver.findElement(By.cssSelector("div[role='alert'][class*='p-toast-message']"));
			String toastText = freshToast.getText().replaceAll("\\s+", " ").trim();
			System.out.println("Batch update toast: [" + toastText + "]");
			return toastText.toLowerCase().contains("success");
		} catch (Exception e) {
			System.out.println("Toast check failed: " + e.getMessage());
			return false;
		}
	}

	private String searchTestSuffix;
	private String searchTestDescription;
	private String searchTestProgramName;
	private String searchTestNumClasses;

	public void createBatchForSearchTesting() throws IOException {
		batchPage.clickAddNewBatchMenuItem();

		String programName = getBatchData("BatchSearch_TestData", "Program Name").trim();
		String suffix = getBatchData("BatchSearch_TestData", "Batch Name Suffix").trim();
		String rawDescription = getBatchData("BatchSearch_TestData", "Description").trim();
		String description = rawDescription.length() > 20 ? rawDescription.substring(0, 20) : rawDescription;
		String status = getBatchData("BatchSearch_TestData", "Status").trim();
		String numClasses = getBatchData("BatchSearch_TestData", "Number of Classes").trim();

		selectSpecificProgramName(programName);

		String uniqueSuffix = suffix + (System.currentTimeMillis() % 1000);
		safeType(batchNameSuffix, uniqueSuffix);
		safeType(descriptionField, description);
		selectStatus(status);
		safeType(numberOfClassesField, numClasses);
		clickOnButton(saveButton);

		batchPage.closeToastIfPresent();

		// Store the FULL batch name (program prefix + suffix), not just the number
		searchTestSuffix = getBatchNamePrefixText() + "_" + uniqueSuffix;
		searchTestDescription = description;
		searchTestProgramName = programName;
		searchTestNumClasses = numClasses;
	}

	public String getNonExistingBatchName() throws IOException {
		return getBatchData("BatchSearch_NonExisting", "Batch Name Suffix").trim();
	}

	public String getSearchTestSuffix() {
		return searchTestSuffix;
	}

	public String getSearchTestDescription() {
		return searchTestDescription;
	}

	public String getSearchTestProgramName() {
		return searchTestProgramName;
	}

	public String getSearchTestNumClasses() {
		return searchTestNumClasses;
	}

	private String lastCreatedBatchSuffix;

	public void createBatchForEditingScenario() throws IOException {
		String programName = getBatchData("BatchAdd_MandatoryFieldsOnly", "Program Name");
		String suffix = getBatchData("BatchAdd_MandatoryFieldsOnly", "Batch Name Suffix");
		String status = getBatchData("BatchAdd_MandatoryFieldsOnly", "Status");
		String numClasses = getBatchData("BatchAdd_MandatoryFieldsOnly", "Number of Classes");

		selectSpecificProgramName(programName);
		String uniqueSuffix = suffix + (System.currentTimeMillis() % 1000);
		safeType(batchNameSuffix, uniqueSuffix);
		selectStatus(status);
		safeType(numberOfClassesField, numClasses);
		clickOnButton(saveButton);
		batchPage.closeToastIfPresent();
		lastCreatedBatchSuffix = uniqueSuffix;
	}

	public String getLastCreatedBatchSuffix() {
		return lastCreatedBatchSuffix;
	}

	public String getSearchValueForType(String searchType) {
		switch (searchType.toLowerCase()) {
		case "batch name":
			return searchTestSuffix;
		case "batch description":
			return searchTestDescription;
		case "program name":
			return searchTestProgramName;
		case "number of classes":
			return searchTestNumClasses;
		case "batch status":
			return "Active";
		default:
			throw new RuntimeException("Unknown search type: " + searchType);
		}
	}

	public void updateWithValidDataAndCancel() throws IOException, InterruptedException {
		fillValidDescriptionAndClasses("EditBatch_CancelUpdate");
		Thread.sleep(1000);
		WebElement freshCancelButton = driver.findElement(By.cssSelector("button[label='Cancel']"));
		freshCancelButton.click();
		Thread.sleep(1000);
	}

	public boolean isDialogClosedWithoutEditing() {
		try {
			Thread.sleep(500);
			return driver.findElements(By.cssSelector("[role='dialog']")).isEmpty();
		} catch (Exception e) {
			return true;
		}
	}

}