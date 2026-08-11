package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import driver.Passing_Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BatchDetailsPage;
import pages.BatchPage;

public class DeleteBatchValidationStepDefs {

	BatchPage batchPage;
	BatchDetailsPage batchDetailsPage;

	public DeleteBatchValidationStepDefs(Passing_Driver passdr) throws IOException {
		batchPage = new BatchPage(passdr);
		batchDetailsPage = new BatchDetailsPage(passdr);
	}

	@Given("Admin is on the Batch page for batch deletion- Batch")
	public void admin_is_on_the_batch_page_for_batch_deletion_batch() {
		batchPage.navigateToHomePageAfterLogin();
		batchPage.navigateToBatchPage();
	}

	@When("Admin clicks the delete icon on a Batch row - Batch")
	public void admin_clicks_the_delete_icon_on_a_batch_row_batch() throws IOException, InterruptedException {
		batchPage.clickAddNewBatchMenuItem();
		batchDetailsPage.createBatchForEditingScenario();

		batchPage.clickDeleteIconForBatchName(batchDetailsPage.getLastCreatedBatchSuffix());
	}

	@Then("Admin should see the confirm alert box with yes and no button - Batch")
	public void admin_should_see_the_confirm_alert_box_with_yes_and_no_button_batch() {
		Assert.assertTrue(batchPage.isDeleteConfirmationDisplayedWithButtons());
	}

	@When("Admin clicks yes button after clicking delete icon on a Batch row - Batch")
	public void admin_clicks_yes_button_after_clicking_delete_icon_on_a_batch_row_batch()
			throws IOException, InterruptedException {
		batchPage.clickAddNewBatchMenuItem();
		batchDetailsPage.createBatchForEditingScenario();

		batchPage.clickDeleteIconForBatchName(batchDetailsPage.getLastCreatedBatchSuffix());

		batchPage.clickYesOnDeleteConfirmation();

	}

	@Then("Admin should see the successful message and the Batch should be deleted - Batch")
	public void admin_should_see_the_successful_message_and_the_batch_should_be_deleted_batch() {
		Assert.assertTrue(batchPage.isDeleteSuccessToastDisplayed());
		Assert.assertTrue(batchPage.isBatchDeleted(batchDetailsPage.getLastCreatedBatchSuffix()));
	}

	@When("Admin clicks no button after clicking delete icon on a Batch row - Batch")
	public void admin_clicks_no_button_after_clicking_delete_icon_on_a_batch_row_batch()
			throws IOException, InterruptedException {
		batchPage.clickAddNewBatchMenuItem();
		batchDetailsPage.createBatchForEditingScenario();

		batchPage.clickDeleteIconForBatchName(batchDetailsPage.getLastCreatedBatchSuffix());

		batchPage.clickNoOnDeleteConfirmation();

	}

	@Then("Admin should see the alert box closed and the Batch is not deleted - Batch")
	public void admin_should_see_the_alert_box_closed_and_the_batch_is_not_deleted_batch() {
		Assert.assertTrue(batchPage.isDeleteConfirmationClosed());
		Assert.assertTrue(batchPage.isBatchStillPresent(batchDetailsPage.getLastCreatedBatchSuffix()));
	}

	@When("Admin clicks on the close icon on the Batch confirm popup - Batch")
	public void admin_clicks_on_the_close_icon_on_the_batch_confirm_popup_batch()
			throws IOException, InterruptedException {

		batchPage.clickAddNewBatchMenuItem();
		batchPage.waitForDialogVisible(); // instead of Thread.sleep(2000)

		batchDetailsPage.createBatchForEditingScenario();
		batchPage.waitForTableRowsRefresh(); // instead of Thread.sleep(2000)

		batchPage.clickDeleteIconForBatchName(batchDetailsPage.getLastCreatedBatchSuffix());
		batchPage.waitForDeleteConfirmationVisible(); // instead of Thread.sleep(2000)

		batchPage.clickCloseOnDeleteConfirmation();
	}

	@Then("Admin should see the alert box closed - Batch")
	public void admin_should_see_the_alert_box_closed_batch() {
		Assert.assertTrue(batchPage.isDeleteConfirmationClosed());
	}

}
