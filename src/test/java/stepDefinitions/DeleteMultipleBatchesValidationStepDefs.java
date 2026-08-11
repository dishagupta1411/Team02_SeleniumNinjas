package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import driver.Passing_Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BatchPage;

public class DeleteMultipleBatchesValidationStepDefs {

	BatchPage batchPage;

	public DeleteMultipleBatchesValidationStepDefs(Passing_Driver passdr) throws IOException {
		batchPage = new BatchPage(passdr);
	}

	@Given("Admin is on the Batch page for bulk deletion - Batch")
	public void admin_is_on_the_batch_page_for_bulk_deletion_batch() {

		batchPage.navigateToHomePageAfterLogin();
		batchPage.navigateToBatchPage();
	}

	@When("Admin selects more than one batch by clicking on the checkbox - Batch")
	public void admin_selects_more_than_one_batch_by_clicking_on_the_checkbox_batch() {
		batchPage.selectMultipleBatchCheckboxes();

	}

	@Then("Admin should see the Multiple Delete button enabled under Manage Batch - Batch")
	public void admin_should_see_the_multiple_delete_button_enabled_under_manage_batch_batch() {
		Assert.assertTrue(batchPage.isMultiDeleteButtonEnabled());
	}

	@When("Admin clicks on the delete button on the top left of the Batch page - Batch")
	public void admin_clicks_on_the_delete_button_on_the_top_left_of_the_batch_page_batch() {
		batchPage.selectTwoBatchesAndClickMultiDelete();
	}

	@Then("Admin should land on the Confirmation form - Batch")
	public void admin_should_land_on_the_confirmation_form_batch() {
		Assert.assertTrue(batchPage.isConfirmationFormDisplayed());
	}

}
