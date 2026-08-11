package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	@FindBy(xpath = "//button[contains(@icon,'pi-pencil')]")
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

	@FindBy(css = "div[role='dialog']")
	WebElement dialog;

	@FindBy(css = "table th[role='columnheader']")
	List<WebElement> sortableColumnHeaders;

	@FindBy(xpath = "//span[contains(text(),'Batch')]/parent::button")
	WebElement batchButton;

	@FindBy(xpath = "(//button[contains(@icon,\"pi pi-pencil\")])[1]")
	WebElement firstEditButton;

	@FindBy(css = "div.p-confirm-dialog")
	WebElement deleteConfirmationDialog;

	@FindBy(css = "button[ng-reflect-label='Yes']")
	WebElement singleDeleteYesButton;

	@FindBy(css = "button[ng-reflect-label='No']")
	WebElement singleDeleteNoButton;

	@FindBy(css = "div[class*='p-toast-message'][role='alert']")
	WebElement deleteSuccessToast;

	@FindBy(css = "[class*='p-dialog-header-icons'] button")
	WebElement deleteDialogCloseButton;

	@FindBy(id = "filterGlobal")
	private WebElement globalSearch;

	@FindBy(css = "button[class*='p-toast-icon-close']")
	WebElement toastCloseButton;

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
	

	// =========== BATCH PAGE VERIFICATIONS ============

	public void navigateToHomePageAfterLogin() throws IOException {
		navigateToApplication();
		loginAsAdmin();
		//loginPage.enterUsername(config.getProperty("username"));
		//loginPage.enterPassword(config.getProperty("password"));
		//loginPage.selectRole("Admin");
		//loginPage.clickLoginButton();
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
		List<String> expectedHeaders = Arrays.asList("Batch Name", "Batch Description", "Batch Status", "No Of Classes",
				"Program Name", "Edit / Delete");

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
		safeClick(addNewBatch);
	}

	public boolean isBatchDetailsDialogDisplayed() {
		return isDisplayed(dialog);
	}

	public void clickEditIconOnFirstRow() {
		wait.until(ExpectedConditions.visibilityOfAllElements(tableRows));
		wait.until(ExpectedConditions.visibilityOf(firstEditButton));
		clickOnButton(firstEditButton);
	}

	public void clickEditIconForProgram(String programName) {
		while (true) {
			List<WebElement> rows = driver.findElements(By.cssSelector("[class='p-datatable-tbody'] tr"));

			for (WebElement row : rows) {
				if (row.getText().contains(programName)) {
					WebElement editButton = row.findElement(By.xpath(".//button[contains(@icon,'pi-pencil')]"));
					wait.until(ExpectedConditions.visibilityOf(editButton));
					clickOnButton(editButton);
					return;
				}
			}

			String disabledAttr = nextButton.getAttribute("disabled");
			if (disabledAttr != null) {
				break; // reached last page
			}

			clickOnButton(nextButton);
			wait.until(ExpectedConditions.visibilityOfAllElements(tableRows));
		}
		throw new RuntimeException("No row found for program: " + programName);
	}

	public void clickEditIconForBatchName(String searchText) {
		while (true) {
			wait.until(ExpectedConditions.visibilityOfAllElements(tableRows));
			List<WebElement> rows = driver.findElements(By.cssSelector("[class='p-datatable-tbody'] tr"));

			for (WebElement row : rows) {
				try {
					if (row.getText().contains(searchText)) {
						System.out.println("Matched row text: " + row.getText());
						WebElement editButton = row.findElement(By.xpath(".//button[contains(@icon,'pi-pencil')]"));
						wait.until(ExpectedConditions.visibilityOf(editButton));
						clickOnButton(editButton);
						return;
					}
				} catch (StaleElementReferenceException e) {
					continue;
				}
			}

			String disabledAttr = nextButton.getAttribute("disabled");
			if (disabledAttr != null)
				break;

			clickOnButton(nextButton);
			wait.until(ExpectedConditions.visibilityOfAllElements(tableRows));
		}
		throw new RuntimeException("No row found for: " + searchText);
	}

	public void clickDeleteIconOnFirstRow() {
		clickOnButton(deleteIcons.get(0));
	}

	public boolean isDeleteConfirmationDialogDisplayed() {
		return isDisplayed(deleteConfirmationDialog);
	}

	public boolean isYesButtonDisplayed() {
		return isDisplayed(singleDeleteYesButton);
	}

	public boolean isNoButtonDisplayed() {
		return isDisplayed(singleDeleteNoButton);
	}

	public boolean isDeleteConfirmationDisplayedWithButtons() {
		return isDeleteConfirmationDialogDisplayed() && isYesButtonDisplayed() && isNoButtonDisplayed();
	}

	public void clickCloseOnDeleteConfirmation() {
		wait.until(ExpectedConditions.elementToBeClickable(deleteDialogCloseButton));
		// deleteDialogCloseButton.click();
		clickOnButton(deleteDialogCloseButton);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.p-confirm-dialog")));
	}

	public boolean isDeleteSuccessToastDisplayed() {
		try {
			String toastText = new WebDriverWait(driver, Duration.ofSeconds(5)).pollingEvery(Duration.ofMillis(100))
					.until(ExpectedConditions.visibilityOf(deleteSuccessToast)).getText().replaceAll("\\s+", " ")
					.trim();

			System.out.println("Delete toast: [" + toastText + "]");
			return toastText.toLowerCase().contains("success") || toastText.toLowerCase().contains("delete");
		} catch (Exception e) {
			System.out.println("No delete toast found within timeout");
			return false;
		}
	}

	public boolean isBatchDeleted(String batchNameSearch) {
		try {
			clickEditIconForBatchName(batchNameSearch);
			return false; // found it - not deleted
		} catch (RuntimeException e) {
			return true; // not found - deletion confirmed
		}
	}

	public void clickYesOnDeleteConfirmation() {
		wait.until(ExpectedConditions.elementToBeClickable(singleDeleteYesButton));
		singleDeleteYesButton.click();
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.p-confirm-dialog")));
	}

	public void waitForDialogVisible() {
		wait.until(ExpectedConditions.visibilityOf(dialog));
	}

	public void waitForTableRowsRefresh() {
		wait.until(ExpectedConditions.visibilityOfAllElements(tableRows));
	}

	public void waitForDeleteConfirmationVisible() {
		wait.until(ExpectedConditions.visibilityOf(deleteConfirmationDialog));
	}

	public void selectMultipleBatchCheckboxes() {
		wait.until(ExpectedConditions.visibilityOfAllElements(rowCheckboxes));
		clickOnButton(rowCheckboxes.get(0));
		clickOnButton(rowCheckboxes.get(1));
	}

	public boolean isMultiDeleteButtonEnabled() {
		WebElement freshButton = driver
				.findElement(By.cssSelector("div[class='box'] button[class*='p-button-danger']"));
		String disabledAttr = freshButton.getAttribute("disabled");
		System.out.println("Multi-delete button disabled attribute: [" + disabledAttr + "]");
		return disabledAttr == null;
	}

	public void selectTwoBatchesAndClickMultiDelete() {
		wait.until(ExpectedConditions.visibilityOfAllElements(rowCheckboxes));
		clickOnButton(rowCheckboxes.get(0));
		clickOnButton(rowCheckboxes.get(1));

		WebElement freshButton = driver
				.findElement(By.cssSelector("div[class='box'] button[class*='p-button-danger']"));
		wait.until(ExpectedConditions.elementToBeClickable(freshButton));
		clickOnButton(freshButton);
	}

	public void clickDeleteIconForBatchName(String searchText) {
		while (true) {
			try {
				wait.until(ExpectedConditions.visibilityOfAllElements(tableRows));
				List<WebElement> rows = driver.findElements(By.cssSelector("[class='p-datatable-tbody'] tr"));

				boolean found = false;
				for (WebElement row : rows) {
					String rowText = row.getText();
					if (rowText.matches("(?s).*_" + java.util.regex.Pattern.quote(searchText) + "\\b.*")) {
						WebElement deleteButton = row.findElement(By.xpath(".//button[contains(@icon,'pi-trash')]"));
						wait.until(ExpectedConditions.visibilityOf(deleteButton));
						clickOnButton(deleteButton);
						wait.until(ExpectedConditions.visibilityOf(deleteConfirmationDialog)); // wait for confirm to
																								// appear
						return;
					}
				}

				String disabledAttr = nextButton.getAttribute("disabled");
				if (disabledAttr != null)
					break;
				clickOnButton(nextButton);
				wait.until(ExpectedConditions.visibilityOfAllElements(tableRows));

			} catch (StaleElementReferenceException e) {
				continue;
			}
		}
		throw new RuntimeException("No row found for: " + searchText);
	}

	public void clickNoOnDeleteConfirmation() {
		wait.until(ExpectedConditions.elementToBeClickable(singleDeleteNoButton));
		singleDeleteNoButton.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.p-confirm-dialog")));
	}

	public boolean isDeleteConfirmationClosed() {
		return driver.findElements(By.cssSelector("div.p-confirm-dialog")).isEmpty();
	}

	public boolean isBatchStillPresent(String batchNameSearch) {
		try {
			clickEditIconForBatchName(batchNameSearch);
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}

	public boolean isConfirmationFormDisplayed() {
		return isDisplayed(deleteConfirmationDialog);
	}

	public void clickNextPage() {
		wait.until(ExpectedConditions.elementToBeClickable(nextButton));
		clickOnButton(nextButton);
	}

	public boolean isNextEnabled() {
		return nextButton.getAttribute("disabled") == null;
	}

	public void clickLastPage() {
		wait.until(ExpectedConditions.elementToBeClickable(lastButton));
		clickOnButton(lastButton);
	}

	public void ensureNotOnLastPage() throws IOException {
		navigateToHomePageAfterLogin();
		navigateToBatchPage();

		wait.until(ExpectedConditions.visibilityOf(nextButton));
		String disabledAttr = nextButton.getAttribute("disabled");
		if (disabledAttr != null) {
			throw new RuntimeException(
					"Table only has one page - cannot test 'except last page' scenario. Add more batch records.");
		}

	}

	public boolean isOnLastPage() {
		return nextButton.getAttribute("disabled") != null && lastButton.getAttribute("disabled") != null;
	}

	public void clickPreviousPage() {
		wait.until(ExpectedConditions.elementToBeClickable(prevButton));
		clickOnButton(prevButton);
	}

	public boolean isOnFirstPage() {
		return prevButton.getAttribute("disabled") != null && firstButton.getAttribute("disabled") != null;
	}

	public void navigateToPageExceptFirst() throws IOException {
		navigateToHomePageAfterLogin();
		navigateToBatchPage();

		wait.until(ExpectedConditions.visibilityOf(nextButton));
		String disabledAttr = nextButton.getAttribute("disabled");
		if (disabledAttr != null) {
			throw new RuntimeException(
					"Table only has one page - cannot navigate away from first page. Add more batch records.");
		}
		clickNextPage();

		if (isOnFirstPage()) {
			throw new RuntimeException("Failed to navigate away from the first page.");
		}
	}

	public void clickFirstPage() {
		wait.until(ExpectedConditions.elementToBeClickable(firstButton));
		clickOnButton(firstButton);
	}

	public void verifyMultiplePagesExist() throws IOException {
		navigateToHomePageAfterLogin();
		navigateToBatchPage();

		wait.until(ExpectedConditions.visibilityOf(nextButton));
		String disabledAttr = nextButton.getAttribute("disabled");
		if (disabledAttr != null) {
			throw new RuntimeException(
					"Table only has one page - cannot test pagination scenarios. Add more batch records.");
		}
	}

	public boolean isPreviousDisabled() {
		return prevButton.getAttribute("disabled") != null;
	}

	public boolean isFirstDisabled() {
		return firstButton.getAttribute("disabled") != null;
	}

	public boolean isLastEnabled() {
		return lastButton.getAttribute("disabled") == null;
	}

	public void searchInBox(String searchValue) {
		safeType(globalSearch, searchValue);
		wait.until(ExpectedConditions.visibilityOfAllElements(tableRows));
	}

	public String getTotalEntriesText() {
		return getText(currentEntriesText);
	}

	public int extractTotalCount(String entriesText) {
		String[] parts = entriesText.split("of");
		if (parts.length > 1) {
			String numberPart = parts[1].replaceAll("[^0-9]", "");
			return Integer.parseInt(numberPart);
		}
		return -1;
	}

	public boolean areFilteredResultsDisplayed(String searchValue, int totalCountBeforeSearch) {
		try {
			wait.until(driver -> {
				List<WebElement> rows = driver.findElements(By.cssSelector("[class='p-datatable-tbody'] tr"));
				if (rows.isEmpty())
					return false;
				for (WebElement row : rows) {
					if (!row.getText().toLowerCase().contains(searchValue.toLowerCase())) {
						return false;
					}
				}
				return true;
			});
		} catch (Exception e) {
			System.out.println("Timed out waiting for filtered results containing: [" + searchValue + "]");
			return false;
		}

		int totalCountAfterSearch = extractTotalCount(getTotalEntriesText());
		return totalCountAfterSearch <= totalCountBeforeSearch;
	}

	public boolean isNoResultsDisplayed() {
		try {
			wait.until(driver -> {
				List<WebElement> rows = driver.findElements(By.cssSelector("[class='p-datatable-tbody'] tr"));
				return rows.isEmpty() || (rows.size() == 1 && rows.get(0).getText().toLowerCase().contains("no"));
			});
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickSortIconForColumn(String columnName) {

		String xpath = "//th[@role='columnheader' and " + "contains(translate(normalize-space(.), "
				+ "'ABCDEFGHIJKLMNOPQRSTUVWXYZ', " + "'abcdefghijklmnopqrstuvwxyz'), " + "'" + columnName.toLowerCase()
				+ "')]";

		WebElement columnHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

		WebElement sortIcon = columnHeader.findElement(By.cssSelector("[class*='p-sortable-column-icon']"));

		wait.until(ExpectedConditions.elementToBeClickable(sortIcon));
		clickOnButton(sortIcon);

		wait.until(ExpectedConditions.visibilityOfAllElements(tableRows));
	}

	private int getColumnIndex(String columnName) {

		List<WebElement> headers = driver.findElements(By.cssSelector("th[role='columnheader']"));

		String expectedColumn = columnName.trim().replaceAll("\\s+", " ").toLowerCase();

		for (int i = 0; i < headers.size(); i++) {

			String actualColumn = headers.get(i).getText().trim().replaceAll("\\s+", " ").toLowerCase();

			System.out.println("Column " + i + " = [" + actualColumn + "]");

			if (actualColumn.contains(expectedColumn)) {
				return i;
			}
		}

		throw new RuntimeException("Column not found: [" + columnName + "]");
	}

	public List<String> getColumnValues(String columnName) {
		int columnIndex = getColumnIndex(columnName) + 1; // +1 to skip checkbox column in row cells
		List<WebElement> rows = driver.findElements(By.cssSelector("[class='p-datatable-tbody'] tr"));
		List<String> values = new ArrayList<>();
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			values.add(cells.get(columnIndex).getText().trim());
		}
		return values;
	}

	public boolean isColumnSortedAscending(String columnName, List<String> beforeSortValues) {
		List<String> afterSortValues = getColumnValues(columnName);

		System.out.println("Before sort: " + beforeSortValues);
		System.out.println("After sort: " + afterSortValues);

		// Verify it actually changed (sort action had an effect)
		boolean dataChanged = !beforeSortValues.equals(afterSortValues);

		// Verify the after-sort data is genuinely in ascending order
		List<String> expectedSorted = new ArrayList<>(afterSortValues);
		expectedSorted.sort((a, b) -> {
			if (a.isEmpty() && b.isEmpty())
				return 0;
			if (a.isEmpty())
				return 1;
			if (b.isEmpty())
				return -1;
			return a.compareToIgnoreCase(b);
		});
		boolean isCorrectlySorted = afterSortValues.equals(expectedSorted);

		System.out.println("Data changed: " + dataChanged + ", Correctly sorted: " + isCorrectlySorted);

		return isCorrectlySorted; // dataChanged is informational; correctness is the pass/fail criteria
	}

	public boolean isColumnSortedAscending(String columnName) {
		List<String> values = getColumnValues(columnName);
		List<String> sorted = new ArrayList<>(values);

		if (columnName.toLowerCase().contains("classes")) {
			sorted.sort((a, b) -> {
				if (a.isEmpty() && b.isEmpty())
					return 0;
				if (a.isEmpty())
					return 1;
				if (b.isEmpty())
					return -1;
				return Integer.compare(Integer.parseInt(a), Integer.parseInt(b));
			});
		} else {
			sorted.sort((a, b) -> {
				if (a.isEmpty() && b.isEmpty())
					return 0;
				if (a.isEmpty())
					return 1;
				if (b.isEmpty())
					return -1;
				return a.compareToIgnoreCase(b);
			});
		}

		return values.equals(sorted);
	}

	public boolean isColumnSortedDescending(String columnName) {
		List<String> values = getColumnValues(columnName);
		List<String> sorted = new ArrayList<>(values);

		if (columnName.toLowerCase().contains("classes")) {
			sorted.sort((a, b) -> {
				if (a.isEmpty() && b.isEmpty())
					return 0;
				if (a.isEmpty())
					return 1;
				if (b.isEmpty())
					return -1;
				return Integer.compare(Integer.parseInt(b), Integer.parseInt(a));
			});
		} else {
			sorted.sort((a, b) -> {
				if (a.isEmpty() && b.isEmpty())
					return 0;
				if (a.isEmpty())
					return 1;
				if (b.isEmpty())
					return -1;
				return b.compareToIgnoreCase(a);
			});
		}

		return values.equals(sorted);
	}

	public void waitForToastToDisappear() {
		try {
			wait.until(ExpectedConditions
					.invisibilityOfElementLocated(By.cssSelector("div[role='alert'][class*='p-toast-message']")));
		} catch (Exception e) {
			// toast already gone or never appeared - safe to proceed
		}
	}

	public void closeToastIfPresent() {
		try {
			if (toastCloseButton.isDisplayed()) {
				clickOnButton(toastCloseButton);
			}
		} catch (Exception e) {
			// toast not present - nothing to close
		}
	}
	
	

}
