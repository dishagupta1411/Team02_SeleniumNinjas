package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import driver.Passing_Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginStepDef {

    private final LoginPage loginPage;

    public LoginStepDef(Passing_Driver passdr) throws IOException {
        this.loginPage = new LoginPage(passdr);
    }
    
    @When("Admin enters the valid LMS app URL")
	public void admin_enters_the_valid_lms_app_url() {
		loginPage.navigateToApplication();
	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {
		Assert.assertTrue(
	            loginPage.isApplicationLogoDisplayed(),
	            "Application logo is not displayed"
	    );

	    Assert.assertTrue(
	            loginPage.isLoginInstructionDisplayed(),
	            "Login instruction is not displayed"
	    );
	}


    @When("Admin enters the invalid LMS app URL")
    public void admin_enters_the_invalid_lms_app_url() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should receive application error")
    public void admin_should_receive_application_error() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("HTTP response should be less than {int}")
    public void http_response_should_be_less_than(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see LMS - Learning Management System")
    public void admin_should_see_lms_learning_management_system() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see Application Logo")
    public void admin_should_see_application_logo() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see company name below the app name")
    public void admin_should_see_company_name_below_the_app_name() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see Please login to LMS application")
    public void admin_should_see_please_login_to_lms_application() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see two text fields")
    public void admin_should_see_two_text_fields() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see one dropdown")
    public void admin_should_see_one_dropdown() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see User in the first text field")
    public void admin_should_see_user_in_the_first_text_field() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see Password in the second text field")
    public void admin_should_see_password_in_the_second_text_field() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see asterisk mark  next to text for user field")
    public void admin_should_see_asterisk_mark_next_to_text_for_user_field() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see asterisk mark  next to password text")
    public void admin_should_see_asterisk_mark_next_to_password_text() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see select the role placeholder in dropdown")
    public void admin_should_see_select_the_role_placeholder_in_dropdown() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see Admin, staff, student options in dropdown")
    public void admin_should_see_admin_staff_student_options_in_dropdown() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see login form in the centre of the page")
    public void admin_should_see_login_form_in_the_centre_of_the_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see Username, Password and select the role labels left-aligned above their respective input fields")
    public void admin_should_see_username_password_and_select_the_role_labels_left_aligned_above_their_respective_input_fields() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see login button")
    public void admin_should_see_login_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see user text in gray color")
    public void admin_should_see_user_text_in_gray_color() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see password text in gray color")
    public void admin_should_see_password_text_in_gray_color() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("Admin is on login Page")
    public void admin_is_on_login_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Admin clicks login in button after entering valid credentials")
    public void admin_clicks_login_in_button_after_entering_valid_credentials() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should land on home page")
    public void admin_should_land_on_home_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Admin clicks login in button after entering special character in username")
    public void admin_clicks_login_in_button_after_entering_special_character_in_username() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see Error message Invalid username and password Please try again")
    public void admin_should_see_error_message_invalid_username_and_password_please_try_again() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Admin enters only the password and selects a role")
    public void admin_enters_only_the_password_and_selects_a_role() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see Error message Please enter your user name")
    public void admin_should_see_error_message_please_enter_your_user_name() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Admin enters only the username and selects a role")
    public void admin_enters_only_the_username_and_selects_a_role() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see Error message Please enter your password")
    public void admin_should_see_error_message_please_enter_your_password() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Admin clicks login in button after entering valid username , role , wrong password")
    public void admin_clicks_login_in_button_after_entering_valid_username_role_wrong_password() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Admin enters valid username and password without selecting a role")
    public void admin_enters_valid_username_and_password_without_selecting_a_role() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see Error Message Please select your role")
    public void admin_should_see_error_message_please_select_your_role() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Admin clicks login button after entering valid username and password with an invalid role")
    public void admin_clicks_login_button_after_entering_valid_username_and_password_with_an_invalid_role() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see Error Message Please select correct role")
    public void admin_should_see_error_message_please_select_correct_role() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Admin clicks login in button after entering  a valid credential through keyboard")
    public void admin_clicks_login_in_button_after_entering_a_valid_credential_through_keyboard() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Admin clicks login in button after entering  a valid credential through mouse")
    public void admin_clicks_login_in_button_after_entering_a_valid_credential_through_mouse() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
	

}
