package stepDefinitions;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import driver.Passing_Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProgramPage;

public class ProgramStepDef {
	
	private final ProgramPage program;

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
		  Assert.assertEquals(program.getManageProgramHeading()-16,program.getProgramPanel(), "Manage Program heading is not left aligned.");
	    
	}
	
	@Then("Admin should see a Delete button in left top is disabled")
	public void admin_should_see_a_delete_button_in_left_top_is_disabled() {
	    Assert.assertTrue(!(program.isMultipleDeleteButtonDisabled()), "Multiple delete button is not disabled");
	    Assert.assertEquals(program.getDeleteBtnPx(),program.getProgramPanel()+16, "Manage Program heading is not left aligned.");
	    
	}
	
	@Then("Admin should see Search bar")
	public void admin_should_see_search_bar() {
	    Assert.assertTrue(program.isSearchBarDisplayed(),"Search bar is not displayed");
	}
	
	@Then("Admin should see {string} placeholder text")
	public void admin_should_see_Search_placeholder_text(String text) {
		Assert.assertEquals(program.getSearchPlaceholder(),text,"Search placeholder text doesn't match");
		
	}
	
	@Then("Admin should see data table with column header on the Manage Program Page as Program Name, Program Description, Program Status, Edit\\/Delete")
public void admin_should_see_data_table_with_column_header_on_the_manage_program_page_as_program_name_program_description_program_status_edit_delete() {
		 List<String> actualHeaders = program.testManageProgramMenu();

		  List<String> expectedHeaders = Arrays.asList("Program Name ","Program Description ","Program Status "," Edit / Delete ");

		    Assert.assertEquals(actualHeaders, expectedHeaders);
		}
			
	
}


