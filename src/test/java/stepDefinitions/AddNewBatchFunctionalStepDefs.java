package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import driver.Passing_Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BatchDetailsPage;
import pages.BatchPage;

public class AddNewBatchFunctionalStepDefs {

	BatchDetailsPage batchDetailsPage;
	BatchPage batchPage;

	public AddNewBatchFunctionalStepDefs(Passing_Driver passdr) throws IOException {
		batchDetailsPage = new BatchDetailsPage(passdr);
		batchPage = new BatchPage(passdr);
	}

	@Given("Admin is on the Batch Details dialog box - Batch")
	public void admin_is_on_the_batch_details_dialog_box_batch() {
		batchPage.navigateToHomePageAfterLogin();
		batchPage.navigateToBatchPage();
		batchPage.clickAddNewBatchMenuItem();
	}

	@When("Admin selects a program name from the dropdown - Batch")
	public void admin_selects_a_program_name_from_the_dropdown_batch() {
		batchDetailsPage.selectProgramName();
	}

	@Then("Admin should see the selected program name in the batch name prefix box - Batch")
	public void admin_should_see_the_selected_program_name_in_the_batch_name_prefix_box_batch()
			throws InterruptedException {
		// Assert.assertEquals(batchDetailsPage.getBatchNamePrefixText(),
		// batchDetailsPage.getSelectedProgramName());
		Thread.sleep(1500);
		String prefixText = batchDetailsPage.getBatchNamePrefixText();
		String selectedProgram = batchDetailsPage.getSelectedProgramName();
		System.out.println("Prefix text: [" + prefixText + "]");
		System.out.println("Selected program: [" + selectedProgram + "]");
		Assert.assertEquals(prefixText, selectedProgram);
	}

	@When("Admin enters alphabets in the batch name suffix box - Batch")
	public void admin_enters_alphabets_in_the_batch_name_suffix_box_batch() throws IOException {
		batchDetailsPage.enterInvalidAlphabeticBatchSuffix();
	}

	@Then("Admin should get an error message below the respective field - Batch")
	public void admin_should_get_an_error_message_below_the_respective_field_batch() {
		Assert.assertTrue(batchDetailsPage.isBatchNameSuffixErrorDisplayed(),
				"Batch name suffix error message was not displayed");
	}

	@When("Admin enters alphabets in the batch name prefix box - Batch")
	public void admin_enters_alphabets_in_the_batch_name_prefix_box_batch() throws IOException {
		batchDetailsPage.enterAlphabetsInPrefixBox();
	}

	@Then("Admin should see the prefix box remains empty - Batch")
	public void admin_should_see_the_prefix_box_remains_empty_batch() {
		Assert.assertTrue(batchDetailsPage.isPrefixBoxEmpty());
	}

	@When("Admin enters data only in the mandatory fields and clicks save - Batch")
	public void admin_enters_data_only_in_the_mandatory_fields_and_clicks_save_batch() throws IOException {
		batchDetailsPage.enterMandatoryFieldsAndSave();
	}

	@Then("Admin should get a successful message - Batch")
	public void admin_should_get_a_successful_message_batch() {
		Assert.assertTrue(batchDetailsPage.isSuccessMessageDisplayed());
	}

	@When("Admin leaves one mandatory field blank and clicks save - Batch")
	public void admin_leaves_one_mandatory_field_blank_and_clicks_save_batch() throws IOException {
		batchDetailsPage.leaveMandatoryFieldBlankAndSave();
	}

	@Then("Admin should get an error message on the respective mandatory field - Batch")
	public void admin_should_get_an_error_message_on_the_respective_mandatory_field_batch() {
		Assert.assertTrue(batchDetailsPage.isMandatoryFieldErrorDisplayed());
	}

	@When("Admin enters valid data in all mandatory fields and clicks cancel - Batch")
	public void admin_enters_valid_data_in_all_mandatory_fields_and_clicks_cancel_batch() throws IOException {
		batchDetailsPage.enterValidDataAndCancel();
	}

	@Then("the batch details popup should close without creating any batch - Batch")
	public void the_batch_details_popup_should_close_without_creating_any_batch_batch() {
		Assert.assertTrue(batchDetailsPage.isDialogClosed());
	}

	@When("Admin clicks the close icon on the batch details popup - Batch")
	public void admin_clicks_the_close_icon_on_the_batch_details_popup_batch() {
		batchDetailsPage.clickCloseIcon();
	}

	@Then("the batch details popup should close - Batch")
	public void the_batch_details_popup_should_close_batch() {
		Assert.assertTrue(batchPage.isOnManageBatchPage());
	}

}
