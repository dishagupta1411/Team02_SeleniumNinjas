package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import driver.Passing_Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BatchDetailsPage;
import pages.BatchPage;
import pages.HomePage;

public class EditBatchValidationStepDefs {

	BatchPage batchPage;
	HomePage homepage;
	BatchDetailsPage batchDetailsPage;

	public EditBatchValidationStepDefs(Passing_Driver passdr) throws IOException {
		batchPage = new BatchPage(passdr);
		homepage = new HomePage(passdr);
		batchDetailsPage = new BatchDetailsPage(passdr);
	}

	@Given("Admin is on the Batch page - Batch")
	public void admin_is_on_the_batch_page_batch() {
		batchPage.navigateToHomePageAfterLogin();
		batchPage.navigateToBatchPage();
	}

	@When("Admin clicks the edit icon on a Batch row - Batch")
	public void admin_clicks_the_edit_icon_on_a_batch_row_batch() throws InterruptedException {

		batchPage.clickEditIconOnFirstRow();
	}

	@Then("Admin should see the Batch Details dialog box appears - Batch")
	public void admin_should_see_the_batch_details_dialog_box_appears_batch() {
		Assert.assertTrue(batchDetailsPage.isBatchDetailsHeadingDisplayed());
	}

	@When("Admin clicks the edit icon - Batch")
	public void admin_clicks_the_edit_icon_batch() {
		batchPage.clickEditIconOnFirstRow();
	}

	@Then("Admin should see the batch name field is disabled for editing - Batch")
	public void admin_should_see_the_batch_name_field_is_disabled_for_editing_batch() {
		Assert.assertTrue(batchDetailsPage.isBatchNameFieldDisabled());
	}

	@When("Admin updates the {string} field with invalid data and clicks save button - Batch")
	public void admin_updates_the_field_with_invalid_data_and_clicks_save_button_batch(String field)
			throws IOException {
		batchPage.clickEditIconOnFirstRow();
		batchDetailsPage.updateFieldWithInvalidData(field);
	}

	@Then("Admin should see {string} for the {string} field - Batch")
	public void admin_should_see_for_the_field_batch(String errorType, String field) {
		Assert.assertTrue(batchDetailsPage.isErrorDisplayed(errorType));
	}

	@When("Admin clicks save button after updating with valid data - Batch")
	public void admin_clicks_save_button_after_updating_with_valid_data_batch()
			throws IOException, InterruptedException {
		batchPage.clickAddNewBatchMenuItem();
		batchDetailsPage.createBatchForEditingScenario();
		batchPage.clickEditIconForBatchName(batchDetailsPage.getLastCreatedBatchSuffix());
		batchDetailsPage.updateWithValidDataAndSave();
	}

	@Then("Admin should get a successful message for editing the batch - Batch")
	public void admin_should_get_a_successful_message_for_editing_the_batch_batch() {
		Assert.assertTrue(batchDetailsPage.isBatchUpdateSuccessMessageDisplayed());
	}

	@When("Admin clicks cancel button after updating with valid data - Batch")
	public void admin_clicks_cancel_button_after_updating_with_valid_data_batch()
			throws IOException, InterruptedException {
		batchPage.clickAddNewBatchMenuItem();
		batchDetailsPage.createBatchForEditingScenario();

		batchPage.clickEditIconForBatchName(batchDetailsPage.getLastCreatedBatchSuffix());
		batchDetailsPage.updateWithValidDataAndCancel();
	}

	@Then("Admin should see the batch details popup closes without editing the batch - Batch")
	public void admin_should_see_the_batch_details_popup_closes_without_editing_the_batch_batch() throws IOException {
		Assert.assertTrue(batchDetailsPage.isDialogClosedWithoutEditing());
	}

}
