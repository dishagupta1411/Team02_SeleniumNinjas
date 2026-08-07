package stepDefinitions;

import java.io.IOException;

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
	   
	
	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String string) {
	    
	}
	
	@Then("Admin should be navigated to Program page")
	public void admin_should_be_navigated_to_program_page() {
	    
	}
	@Then("Admin should see the Edit and Delete buttons on each row of the data table")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
	    
	}
}


