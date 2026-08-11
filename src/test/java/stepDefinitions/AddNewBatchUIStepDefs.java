package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import driver.Passing_Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BatchDetailsPage;
import pages.BatchPage;

public class AddNewBatchUIStepDefs {

	BatchPage batchPage;
	BatchDetailsPage batchDetailsPage;

	public AddNewBatchUIStepDefs(Passing_Driver passdr) throws IOException {
		batchPage = new BatchPage(passdr);
		batchDetailsPage = new BatchDetailsPage(passdr);
	}

	@Given("Admin is on the Manage Batch page - Batch")
	public void admin_is_on_the_manage_batch_page_batch() {
		batchPage.navigateToHomePageAfterLogin();
		batchPage.navigateToBatchPage();

	}

	@When("Admin opens the Add New Batch dialog - Batch")
	public void admin_opens_the_add_new_batch_dialog_batch() {
		batchPage.clickAddNewBatchMenuItem();
	}

	@Then("Admin should see the batch name field - Batch")
	public void admin_should_see_the_batch_name_field_batch() {
		Assert.assertTrue(batchDetailsPage.isBatchNameFieldDisplayed());
	}

	@Then("Admin should see the number of classes field - Batch")
	public void admin_should_see_the_number_of_classes_field_batch() {
		Assert.assertTrue(batchDetailsPage.isNumberOfClassesFieldDisplayed());
	}

	@Then("Admin should see the description field - Batch")
	public void admin_should_see_the_description_field_batch() {
		Assert.assertTrue(batchDetailsPage.isDescriptionFieldDisplayed());
	}

	@Then("Admin should see the program name field with dropdown - Batch")
	public void admin_should_see_the_program_name_field_with_dropdown_batch() {
		Assert.assertTrue(batchDetailsPage.isProgramNameDropdownDisplayed());
	}

	@Then("Admin should see the status radio button - Batch")
	public void admin_should_see_the_status_radio_button_batch() {
		Assert.assertTrue(batchDetailsPage.isStatusRadioButtonDisplayed());
	}

}
