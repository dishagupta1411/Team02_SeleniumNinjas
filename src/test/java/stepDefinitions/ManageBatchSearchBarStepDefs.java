package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import driver.Passing_Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BatchDetailsPage;
import pages.BatchPage;

public class ManageBatchSearchBarStepDefs {

	BatchPage batchPage;
	BatchDetailsPage batchDetailsPage;
	String currentSearchValue;
	int totalCountBefore;

	public ManageBatchSearchBarStepDefs(Passing_Driver passdr) throws IOException {
		batchPage = new BatchPage(passdr);
		batchDetailsPage = new BatchDetailsPage(passdr);
	}

	@Given("Admin is on the batch page - Batch")
	public void admin_is_on_the_batch_page_batch() throws IOException, InterruptedException {
		batchPage.navigateToHomePageAfterLogin();
		batchPage.navigateToBatchPage();
		batchDetailsPage.createBatchForSearchTesting();
		totalCountBefore = batchPage.extractTotalCount(batchPage.getTotalEntriesText());
	}

	@When("Admin enters the {string} in the search box - Batch")
	public void admin_enters_the_in_the_search_box_batch(String searchType) throws InterruptedException {
		currentSearchValue = batchDetailsPage.getSearchValueForType(searchType);

		batchPage.searchInBox(currentSearchValue);

		batchPage.waitForToastToDisappear();
	}

	@Then("Admin should see the filtered batch details based on {string} in the data table - Batch")
	public void admin_should_see_the_filtered_batch_details_based_on_in_the_data_table_batch(String string) {
		Assert.assertTrue(batchPage.areFilteredResultsDisplayed(currentSearchValue, totalCountBefore));
	}

	@When("Admin enters the non existing batch name - Batch")
	public void admin_enters_the_non_existing_batch_name_batch() throws IOException, InterruptedException {
		String nonExistingName = batchDetailsPage.getNonExistingBatchName();
		batchPage.searchInBox(nonExistingName);

	}

	@Then("Admin should see no results displayed - Batch")
	public void admin_should_see_no_results_displayed_batch() {
		Assert.assertTrue(batchPage.isNoResultsDisplayed());
	}

}
