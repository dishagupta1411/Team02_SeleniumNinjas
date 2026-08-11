package stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;

import driver.Passing_Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BatchPage;

public class BatchSortingStepDefs {

	BatchPage batchPage;

	List<String> beforeSortValues;

	public BatchSortingStepDefs(Passing_Driver passdr) throws IOException {
		batchPage = new BatchPage(passdr);
	}

	@Given("Admin is on the Batch page to sort - Batch")
	public void admin_is_on_the_batch_page_to_sort_batch() {
		batchPage.navigateToHomePageAfterLogin();
		batchPage.navigateToBatchPage();
	}

	@When("Admin clicks the sort arrow next to {string} for sorting - Batch")
	public void admin_clicks_the_sort_arrow_next_to_for_sorting_batch(String column) {
		beforeSortValues = batchPage.getColumnValues(column);
		batchPage.clickSortIconForColumn(column);
	}

	@Then("Admin should see the batch details sorted by {string} in ascending order - Batch")
	public void admin_should_see_the_batch_details_sorted_by_in_ascending_order_batch(String column) {
		Assert.assertTrue(batchPage.isColumnSortedAscending(column));
	}

	@Given("Admin is on the Batch page where {string} is sorted in ascending order - Batch")
	public void admin_is_on_the_batch_page_where_is_sorted_in_ascending_order_batch(String column) {
		batchPage.navigateToHomePageAfterLogin();
		batchPage.navigateToBatchPage();
		batchPage.clickSortIconForColumn(column);
	}

	@Then("Admin should see the {string} sorted in descending order - Batch")
	public void admin_should_see_the_sorted_in_descending_order_batch(String column) {
		Assert.assertTrue(batchPage.isColumnSortedDescending(column));
	}

}
