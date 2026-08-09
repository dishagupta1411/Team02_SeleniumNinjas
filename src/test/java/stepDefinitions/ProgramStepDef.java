package stepDefinitions;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import driver.Passing_Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProgramPage;

public class ProgramStepDef {
	
	private final ProgramPage program;
	public SoftAssert softAssert = new SoftAssert();

	public ProgramStepDef(Passing_Driver passdr) throws IOException {
		this.program = new ProgramPage(passdr);
	}
	
	
	@Given("Admin is in login Page to test Program module")
	public void admin_is_in_login_page_to_test_program_module() {
	    program.navigateToHomePage();
	}

	@When("Admin enter valid credentials  and clicks login button through keyboard for Program module")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard_for_program_module()  {
	  program.addUserNameAndPassword();
	  program.selectRole();	  
		program.loginIntoApp();
		
	}

		
	@Given("Admin is on home page after Login")
	public void admin_is_on_home_page_after_login() {
		Assert.assertTrue(program.isDashboardDisplayed(), "Admin is not navigated to HomePage after login");
	}
	   
	
	@When("Admin clicks Program on the navigation bar")
	public void admin_clicks_on_the_navigation_bar() {
		program.clickOnProgramBtn();
	    
	}
	
	@Then("Admin should be navigated to Program page")
	public void admin_should_be_navigated_to_program_page() {
		Assert.assertTrue(program.isOnProgramPage(), "Admin is not on Program Page");
	    
	}
	
	@Then("Admin should see sub menu in menu bar as {string}")
	public void admin_should_see_sub_menu_in_menu_bar_as(String string) {
	    Assert.assertEquals(program.isAddNewProgramDisplayed(),string,"Add new Program is not there");
	}
	
	@Then("Admin should see the heading {string}")
	public void admin_should_see_the_heading(String string) {
		 Assert.assertEquals(program.isManageProgramDisplayed(),string,"Admin is not on manage program page");
	   
	}
	
	@Then("Admin should see manage program heading aligned on the left side")
	public void admin_should_see_manage_program_heading_aligned_on_the_left_side() {
		softAssert.assertEquals(program.getManageProgramHeading()-16,program.getProgramPanel(), "Manage Program heading is not left aligned.");
	    
	}
	
	@Then("Admin should see a Delete button in left top is disabled")
	public void admin_should_see_a_delete_button_in_left_top_is_disabled() {
	    softAssert.assertTrue(!(program.isMultipleDeleteButtonDisabled()), "Multiple delete button is not disabled");
	    softAssert.assertEquals(program.getDeleteBtnPx(),program.getProgramPanel()+16, "Manage Program heading is not left aligned.");
	    
	}
	
	@Then("Admin should see Search bar")
	public void admin_should_see_search_bar() {
	    softAssert.assertTrue(program.isSearchBarDisplayed(),"Search bar is not displayed");
	}
	
	@Then("Admin should see {string} placeholder text")
	public void admin_should_see_Search_placeholder_text(String text) {
		softAssert.assertEquals(program.getSearchPlaceholder(),text,"Search placeholder text doesn't match");
		
	}
	
	@Then("Admin should see data table with column header on the Manage Program Page as Program Name, Program Description, Program Status, Edit\\/Delete")
public void admin_should_see_data_table_with_column_header_on_the_manage_program_page_as_program_name_program_description_program_status_edit_delete() {
		 List<String> actualHeaders = program.testManageProgramMenu();

		 List<String> expectedHeaders = Arrays.asList("Program Name","Program Description","Program Status","Edit / Delete");
		    Assert.assertEquals(actualHeaders, expectedHeaders);
		}
			
	@Then("Admin should see checkbox default state as unchecked beside Program Name column header")
	public void admin_should_see_checkbox_default_state_as_unchecked_beside_program_name_column_header() {
		 Assert.assertTrue(program.ischeckBoxDisplayed(),"Checkbox is not unchecked");
	    
	}
	
	@Then("Admin should see check box default state as unchecked on the left side in all rows against program name")
	public void admin_should_see_check_box_default_state_as_unchecked_on_the_left_side_in_all_rows_against_program_name() {
		Assert.assertTrue(program.testAreUnchecked(),"Checkbox is checked when it should be unchecked"
		    );
	   
	}
	
	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
		softAssert.assertTrue(program.testSortArrowsVisibility(),"Sort arrow visibility is not as expected");
	    
	}
	
	@Then("Admin should see the Edit and Delete buttons on each row of the data table")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
		 softAssert.assertTrue(program.testEditDeleteButtonsPresence(),"Edit and Delete buttons should be visible in every row");
	    
	}
	
	@Then("Admin should see the text as Showing x to y of z entries along with Pagination icon below the table.")
	public void admin_should_see_the_text_as_along_with_Pagination_icon_below_the_table() {
		
		program.testPaginationTextIcons();
	}

	@Then("Admin should see the footer as {string}.")
	public void admin_should_see_the_footer_as(String string) {
		
		program.testPaginationFooter();
		
	    	}
	
	//----------------------------------------Add New Program UI-------------------------------------------------------
	
	@Given("Admin is on Program page")
	public void admin_is_on_program_page() {
		program.clickOnProgramBtn();	    
	}
	
	@When("Admin clicks on {string} under the {string} menu bar")
	public void admin_clicks_on_under_the_menu_bar(String string, String string2) {
		program.clickAddNewProgram();
	}

	@Then("Admin should see Program Details dialog")
	public void admin_should_see_program_details_dialog() {
		Assert.assertTrue(program.isProgramDetailsDialogDisplayed(),"Program Details dialog should be displayed");
	    
	}
	
	@Then("Admin should see title as {string}")
	public void admin_should_see_title_as(String string) {
		 softAssert.assertEquals(program.getProgramDetailsTitle(),string,"Program Details title is incorrect");
	    
	}

	@Then("Admin should see red asterisk mark beside mandatory field {string} and {string}")
	public void admin_should_see_red_asterisk_mark_beside_mandatory_field_and(String string, String string2) {
	    
	}

	@Then("Admin should see the Name text box")
	public void admin_should_see_the_name_text_box() {
		   Assert.assertTrue(program.isNameTextBoxDisplayed(),"Program Name text box should be displayed");
	    
	}

	@Then("Admin should see the Description text box")
	public void admin_should_see_the_description_text_box() {
		 Assert.assertTrue(program.isDescriptionTextBoxDisplayed(),"Program Description text box should be displayed");
	    
	}

	@Then("Admin should see Active and Inactive radio buttons")
	public void admin_should_see_active_and_inactive_radio_buttons() {
		//Assert.assertTrue(program.areStatusRadioButtonsDisplayed(),"Active and Inactive radio buttons should be displayed");
	    
	}

	@Given("Admin is on Program details dialog box")
	public void admin_is_on_program_details_dialog_box() {
		program.clickOnProgramBtn();
		 program.clickAddNewProgram();
		 Assert.assertTrue(program.isProgramDetailsDialogDisplayed(),"Admin should be on Program Details dialog");
	    
	}
	
	@When("Admin clicks save button without entering mandatory")
	public void admin_clicks_save_button_without_entering_mandatory() {
		program.clickSaveButton();
	}
	
	
	
	@Then("Admin gets message {string}")
	public void admin_gets_message(String expectedMessage) {
		String actualMessage;


	    if (expectedMessage.equals("Program name is required.")) {
	        actualMessage = program.getRequiredProgramNameMsg();
	    } else if (expectedMessage.equals("Status is required.")) {
	        actualMessage = program.getRequiredProgramStatusMsg();
	    } else {
	        throw new IllegalArgumentException("Unknown expected message: " + expectedMessage);
	    }
	    Assert.assertEquals(actualMessage, expectedMessage, "Message not found");
	
	}

	
	@When("Admin clicks Cancel button")
	public void admin_clicks_cancel_button() {
		program.clickCancelButton();
	    
	}

	@Then("Admin can see Program Details form disappears")
	public void admin_can_see_program_details_form_disappears() {
		Assert.assertTrue(program.isOnProgramPage(), "Admin is not on Program Page");
		
	    
	}

	@When("Admin clicks X button")
	public void admin_clicks_x_button() {
		
		program.clickXButton();
	    
	}
	
	@When("Admin enter valid details for mandatory fields and Click on save button")
	public void admin_enter_valid_details_for_mandatory_fields_and_click_on_save_button()  {
	    program.mandotaryFieldName();
	    program.FieldDescription();
	    program.mandotaryFieldStatus();
	    program.clickSaveButton();
	}
	
	 

	 @Then("Admin gets success message {string}")
		public void admin_gets_success_message(String field) throws InterruptedException {
			softAssert.assertEquals(program.getSuccessMessage(),field,"Message not found");
			    
		}
	 
		@When("Admin searches with newly created {string}")
		public void admin_searches_with_newly_created(String string) {
		   program.searchForProgram();
		}

		@Then("Admin should see the Records of the newly created Program details")
		public void admin_should_see_the_records_of_the_newly_created_program_details() {
			String searchText=program.searchForProgram();
			String expected="SitaLmsApp";
			softAssert.assertEquals(expected,searchText);
			softAssert.assertAll();
		}
	
	@Then("Admin gets message {string} is required")
	public void admin_gets_message_is_required(String field) {
		//softAssert.assertEquals(program.getSuccessMessage(),field,"Message not found");
	    
	}
	
	@When("Admin enters a numeric value as the Program Name")
	public void admin_enters_a_numeric_value_as_the_program_name() {
	    
	}

	@Then("Admin should see error message {string}")
	public void admin_should_see_error_message(String string) {
	    
	}
	
	
	@When("Admin clicks on Edit option for particular program")
	public void admin_clicks_on_edit_option_for_particular_program() {
		program.clickOnEditButton();
	   
	}
	
	@When("Admin clicks save button after editing the program name")
	public void admin_clicks_save_button_after_editing_the_program_name() {
		program.searchForProgram();
		program.clickOnEditButton();
		program.editProgramName();
		program.clickSaveProgramButton();
	  
	}
	
	@When("Admin clicks save button after editing the description")
	public void admin_clicks_save_button_after_editing_the_description() {
		program.searchForProgramDescription();
		program.clickOnEditButton();
		program.editProgramName();
		program.clickSaveProgramButton();
	    
	}
	
	
	@When("Admin searches with newly updated {string}")
	public void admin_searches_with_newly_updated(String string) {
		program.searchForUpdatedProgram();
	   
	}

	@Then("Admin verifies that the details are correctly updated.")
	public void admin_verifies_that_the_details_are_correctly_updated() {
		String searchText=program.searchForProgram();
		String expected="Javasaa";
		softAssert.assertEquals(expected,searchText);
		softAssert.assertAll();
	}
	   
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Then("Admin should see {string} message")
	public void admin_should_see_message(String string) {
	    
	}
	
	
	
	
	
	
	
	
	
	//Pagination
	@When("^Admin clicks the (Next|Last|Previous|First) link on the data table in program page$")
	public void adminClicksPageLink_program(String pageLink) throws InterruptedException {

		program.clickOnProgramBtn();	

	    switch (pageLink.toLowerCase()) {
	        case "next":
	            program.clickNextPage();
	            break;
	        case "last":
	            program.clickLastPage();
	            break;
	        case "previous":
	            program.clickPreviousPage();
	            break;
	        case "first":
	            program.clickFirstPage();
	            break;
	        default:
	            Assert.fail("Unexpected page link: " + pageLink);
	    }
	}
			@Then("^Admin should see the (.*) on the data table in program module$")
			public void adminShouldSeeResults_program(String expectedResult) {

				switch (expectedResult.toLowerCase().trim()) {

			    case "next enabled link":
			        Assert.assertTrue(program.isNextButtonEnabled(),"Expected Next button to be enabled.");
			        break;
			    case "next button disabled":
			        Assert.assertFalse(program.isNextButtonEnabled(),"Expected Next button to be disabled.");
			        break;
			    case "first page reached":
			        Assert.assertFalse(program.isPrevButtonEnabled(),"Expected Previous button to be disabled on first page.");
			        break;
			    case "previous button disabled":
			        Assert.assertFalse(program.isPrevButtonEnabled(),"Expected Previous button to be disabled.");
			        break;
			    case "next page reached":
			    	Assert.assertTrue(program.isPrevButtonEnabled(),"Expected Previous button to be enabled after moving to next page.");
			        break;
			    default:
			        Assert.fail("Unexpected result description: " + expectedResult);
			}}
}


