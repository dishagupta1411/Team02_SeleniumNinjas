package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import driver.Passing_Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BatchPage;

public class BatchPagePaginationStepDefs {

	BatchPage batchPage;

	public BatchPagePaginationStepDefs(Passing_Driver passdr) throws IOException {
		batchPage = new BatchPage(passdr);
	}

	@Given("Admin is on the Batch page with multiple batch records - Batch")
	public void admin_is_on_the_batch_page_with_multiple_batch_records_batch() throws IOException {
		batchPage.navigateToHomePageAfterLogin();
		batchPage.navigateToBatchPage();
	}

	@When("Admin clicks the next page option \\(>) in the pagination control - Batch")
	public void admin_clicks_the_next_page_option_in_the_pagination_control_batch() {
		batchPage.clickNextPage();
	}

	@Then("Admin should see the Next page enabled link - Batch")
	public void admin_should_see_the_next_page_enabled_link_batch() {
		Assert.assertTrue(batchPage.isNextEnabled());
	}

	@Given("Admin is on the Batch page except the last page - Batch")
	public void admin_is_on_the_batch_page_except_the_last_page_batch() throws IOException {
		batchPage.ensureNotOnLastPage();
	}

	@When("Admin clicks the last page option \\(>>) in the pagination control - Batch")
	public void admin_clicks_the_last_page_option_in_the_pagination_control_batch() {
		batchPage.clickLastPage();

	}

	@Then("Admin should see the last page with Next page link disabled on the table - Batch")
	public void admin_should_see_the_last_page_with_next_page_link_disabled_on_the_table_batch() {
		Assert.assertFalse(batchPage.isNextEnabled());
		Assert.assertTrue(batchPage.isOnLastPage());
	}

	@Given("Admin is on the Batch table on any page except the first page - Batch")
	public void admin_is_on_the_batch_table_on_any_page_except_the_first_page_batch() throws IOException {
		batchPage.navigateToPageExceptFirst();
	}

	@When("Admin clicks the previous page option \\(<) in the pagination control - Batch")
	public void admin_clicks_the_previous_page_option_in_the_pagination_control_batch() {
		batchPage.clickPreviousPage();
	}

	@Then("Admin should see the previous page on the table - Batch")
	public void admin_should_see_the_previous_page_on_the_table_batch() {
		Assert.assertTrue(batchPage.isOnFirstPage());
	}

	@Given("Admin is on any page except the first page of Batch table - Batch")
	public void admin_is_on_any_page_except_the_first_page_of_batch_table_batch() throws IOException {
		batchPage.navigateToPageExceptFirst();
	}

	@When("Admin clicks the first page option \\(<<) in the pagination control - Batch")
	public void admin_clicks_the_first_page_option_in_the_pagination_control_batch() {
		batchPage.clickFirstPage();
	}

	@Then("Admin should see the very first page on the data table - Batch")
	public void admin_should_see_the_very_first_page_on_the_data_table_batch() {
		Assert.assertTrue(batchPage.isOnFirstPage());
	}

	@Given("Admin is on the Batch page with multiple pages of batch records - Batch")
	public void admin_is_on_the_batch_page_with_multiple_pages_of_batch_records_batch() throws IOException {
		batchPage.verifyMultiplePagesExist();
	}

	@When("Admin clicks the first page link on the Batch data table - Batch")
	public void admin_clicks_the_first_page_link_on_the_batch_data_table_batch() {
		// Already on first page after Given - no click needed, this step is effectively
		// a no-op
		// but we keep it to match the Gherkin wording
	}

	@Then("Admin should see the Previous arrow \\(<) disabled - Batch")
	public void admin_should_see_the_previous_arrow_disabled_batch() {
		Assert.assertTrue(batchPage.isPreviousDisabled());
	}

	@Then("Admin should see the First page arrow \\(<<) disabled - Batch")
	public void admin_should_see_the_first_page_arrow_disabled_batch() {
		Assert.assertTrue(batchPage.isFirstDisabled());
	}

	@Then("Admin should see the Next arrow \\(>) enabled - Batch")
	public void admin_should_see_the_next_arrow_enabled_batch() {
		Assert.assertTrue(batchPage.isNextEnabled());
	}

	@Then("Admin should see the Last page arrow \\(>>) enabled - Batch")
	public void admin_should_see_the_last_page_arrow_enabled_batch() {
		Assert.assertTrue(batchPage.isLastEnabled());
	}
}
