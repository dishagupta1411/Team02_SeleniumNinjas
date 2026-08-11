package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import driver.Passing_Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class HomeStepDef {

    private final HomePage homePage;

    public HomeStepDef(Passing_Driver passdr) throws IOException {
        this.homePage = new HomePage(passdr);
    }
	
    @Then("Admin should see LMS - Learning Management System as title")
    public void admin_should_see_lms_learning_management_system_as_title() {
    	Assert.assertTrue(
    	        homePage.isApplicationTitleDisplayed(),
    	        "LMS - Learning Management System title is not displayed"
    	    );
        
    }

    @Then("LMS title should be on the top left corner of page")
    public void lms_title_should_be_on_the_top_left_corner_of_page() {
    	Assert.assertTrue(
                homePage.isApplicationTitleAtTopLeft(),
                "LMS title is not aligned to the top left corner"
        );
    	//homePage.printApplicationTitlePosition();
    }

    @Then("Admin should see correct spelling in navigation bar text")
    public void admin_should_see_correct_spelling_in_navigation_bar_text() {
    	Assert.assertTrue(
                homePage.isNavigationBarTextCorrect(),
                "Navigation bar text is incorrect"
        );
    }

    @Then("Admin should see correct spelling and space in LMS title")
    public void admin_should_see_correct_spelling_and_space_in_lms_title() {
    	String actualTitle = homePage.getApplicationTitleText();

        Assert.assertEquals(
                actualTitle,
                "LMS - Learning Management System",
                "LMS title spelling or spacing is incorrect"
        );
    }

    @Then("Admin should see the navigation bar text on the top right side")
    public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
    	Assert.assertTrue(
                homePage.isNavigationBarAtTopRight(),
                "Navigation bar is not aligned to the top right side"
        );
    }

    @Then("Admin should see home in the 1st place")
    public void admin_should_see_home_in_the_1st_place() {
    	Assert.assertTrue(
                homePage.isHomeFirstInNavigationBar(),
                "Home is not in the 1st position in the navigation bar"
        );
    }

    @Then("Admin should see program in the 2nd place")
    public void admin_should_see_program_in_the_2nd_place() {
    	Assert.assertTrue(
                homePage.isProgramSecondInNavigationBar(),
                "Program is not in the 2nd place in the navigation bar"
        );
    }

    @Then("Admin should see batch in the 3rd place")
    public void admin_should_see_batch_in_the_3rd_place() {
    	Assert.assertTrue(
                homePage.isBatchThirdInNavigationBar(),
                "Batch is not in the 3rd place in the navigation bar"
        );
    }

    @Then("Admin should see logout in the 5th place")
    public void admin_should_see_logout_in_the_5th_place() {
    	homePage.printNavigationButtons();

        Assert.assertTrue(
            homePage.isLogoutInFifthPosition(),
            "Expected Logout in 5th position, but Logout is actually in 4th position"
        );

    }

    @Then("Admin should see welcome message with user name and role")
    public void admin_should_see_welcome_message_with_user_name_and_role() {
    	 Assert.assertTrue(
    		        homePage.isWelcomeMessageWithUserNameAndRoleDisplayed(),
    		        "Welcome message with username and role is not displayed correctly"
    		    );
    }

    @Then("Admin should see bar chart for Active and inactive user")
    public void admin_should_see_bar_chart_for_active_and_inactive_user() {
    	Assert.assertTrue(
    	        homePage.isBarChartDisplayed(),
    	        "Bar chart is not displayed on the Home page"
    	    );
    }

    @Then("Admin should see user count")
    public void admin_should_see_user_count() {
    	 Assert.assertTrue(
    		        homePage.isUserCountDisplayed(),
    		        "User count card is not displayed on the Home page"
    		    );
    }

    @Then("Admin should see Program count")
    public void admin_should_see_program_count() {
    	 Assert.assertTrue(
    		        homePage.isProgramCountDisplayed(),
    		        "Program count card is not displayed on the Home page"
    		    );
    }

    @Then("Admin should see Staff count")
    public void admin_should_see_staff_count() {
    	Assert.assertTrue(
    	        homePage.isStaffCountDisplayed(),
    	        "Staff count card is not displayed on the Home page"
    	    );
    }

    @Then("Admin should see batch count")
    public void admin_should_see_batch_count() {
    	Assert.assertTrue(
    	        homePage.isBatchCountDisplayed(),
    	        "Batch count card is not displayed on the Home page"
    	    );
    }

    @Then("Admin should see the Staff Data table")
    public void admin_should_see_the_staff_data_table() {
    	Assert.assertTrue(
    	        homePage.isStaffDataTableDisplayed(),
    	        "Staff Data table is not displayed"
    	    );
    }

    @Then("Admin should see the # header in the Staff Data table")
    public void admin_should_see_the_header_in_the_staff_data_table() {
    	Assert.assertTrue(
    	        homePage.isStaffTableNumberHeaderDisplayed(),
    	        "The # header is not displayed in the Staff Data table"
    	    );
    }

    @Then("Admin should see the First Name header in the Staff Data table")
    public void admin_should_see_the_first_name_header_in_the_staff_data_table() {
    	Assert.assertTrue(
    	        homePage.isStaffTableFirstNameHeaderDisplayed(),
    	        "First Name header is not displayed in the Staff Data table"
    	    );
    }

    @Then("Admin should see the Last Name header in the Staff Data table")
    public void admin_should_see_the_last_name_header_in_the_staff_data_table() {
    	Assert.assertTrue(
    	        homePage.isStaffTableLastNameHeaderDisplayed(),
    	        "Last Name header is not displayed in the Staff Data table"
    	    );
    }

    @Then("Admin should see the Phone header in the Staff Data table")
    public void admin_should_see_the_phone_header_in_the_staff_data_table() {
    	Assert.assertTrue(
    	        homePage.isStaffTablePhoneHeaderDisplayed(),
    	        "Phone header is not displayed in the Staff Data table"
    	    );
    }
    
    @When("Admin clicks on the logout in the menu bar")
    public void admin_clicks_on_the_logout_in_the_menu_bar() {
    	homePage.clickLogout();
    }

    @Then("Admin should be redirected to the login page")
    public void admin_should_be_redirected_to_the_login_page() {
    	Assert.assertTrue(
                homePage.isLoginPageDisplayed(),
                "Admin was not redirected to the Login Page"
        );
    }


	
}