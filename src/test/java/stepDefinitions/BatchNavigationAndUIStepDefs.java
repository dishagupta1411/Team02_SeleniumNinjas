package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import driver.Passing_Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BatchPage;

public class BatchNavigationAndUIStepDefs {
	
	BatchPage batchPage;
	
    public BatchNavigationAndUIStepDefs(Passing_Driver passdr) throws IOException {
        batchPage = new BatchPage(passdr);
    }
	
	@Given("Admin is on home page after Login - Batch")
	public void admin_is_on_home_page_after_login_batch() {
		batchPage.navigateToHomePageAfterLogin();
	}

	@When("Admin clicks {string} on the navigation bar - Batch")
	public void admin_clicks_on_the_navigation_bar_batch(String string) {
		batchPage.navigateToBatchPage();
	}

	@Then("Admin should be in the Manage Batch Page - Batch")
	public void admin_should_be_in_the_manage_batch_page_batch() {
		Assert.assertTrue(batchPage.isOnManageBatchPage());
	    
	}

	@Then("Admin should see sub menu in menu bar as {string} - Batch")
	public void admin_should_see_sub_menu_in_menu_bar_as_batch(String string) {
		Assert.assertEquals(batchPage.getSubMenuText(), string);
	}

	@Then("Admin should see the {string} Heading - Batch")
	public void admin_should_see_the_heading_batch(String string) {
		Assert.assertEquals(batchPage.getPageHeadingText(), string);   
	}

	@Then("Admin should see the disabled {string} under the header - Batch")
	public void admin_should_see_the_disabled_under_the_header_batch(String string) {
		Assert.assertTrue(batchPage.isMultiDeleteButtonDisabled());
	}

	@Then("Admin should see the pagination controls under the data table - Batch")
	public void admin_should_see_the_pagination_controls_under_the_data_table_batch() {
		Assert.assertTrue(batchPage.isPaginationControlsDisplayed());
	}

	@Then("Admin should see the edit icon in each row - Batch")
	public void admin_should_see_the_edit_icon_in_each_row_batch() {
		Assert.assertTrue(batchPage.isEditIconDisplayedInEachRow());
	}

	@Then("Admin should see the delete icon in each row - Batch")
	public void admin_should_see_the_delete_icon_in_each_row_batch() {
		Assert.assertTrue(batchPage.isDeleteIconDisplayedInEachRow());
	}

	@Then("Admin should see the checkbox in each row - Batch")
	public void admin_should_see_the_checkbox_in_each_row_batch() {
		Assert.assertTrue(batchPage.isCheckboxDisplayedInEachRow());
	}

	@Then("Admin should see the datatable headers Batch name, Batch Description, Batch Status, No Of classes, Program Name, Edit\\/Delete - Batch")
	public void admin_should_see_the_datatable_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete_batch() {
		Assert.assertTrue(batchPage.areDatatableHeadersDisplayed());
	}

	@Then("Admin should see the checkbox in the datatable header row - Batch")
	public void admin_should_see_the_checkbox_in_the_datatable_header_row_batch() {
		Assert.assertTrue(batchPage.isHeaderCheckboxDisplayed());
	}

	@Then("Admin should see the sort icon next to all Datatable headers - Batch")
	public void admin_should_see_the_sort_icon_next_to_all_datatable_headers_batch() {
		Assert.assertTrue(batchPage.areSortIconsDisplayedForAllHeaders());
	}

	@When("Admin clicks on {string} under the {string} menu bar - Batch")
	public void admin_clicks_on_under_the_menu_bar_batch(String string, String string2) {
		batchPage.clickAddNewBatchMenuItem();
	}

	@Then("Admin should see the Batch Details dialog box - Batch")
	public void admin_should_see_the_batch_details_dialog_box_batch() {
		Assert.assertTrue(batchPage.isBatchDetailsDialogDisplayed());
	}

}
