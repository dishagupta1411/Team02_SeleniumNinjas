@login
Feature: LMS Login Page

As an Admin
I want to access the LMS login page
So that I can verify its UI and login functionality

# ============================================================

# Login Page - UI Verification

# ============================================================

@ui1
Scenario: Login page is displayed successfully
When Admin enters the valid LMS app URL
Then Admin should land on the login page

@ui2
Scenario: Access app with invalid URL
When Admin enters the invalid LMS app URL
Then Admin should receive application error

@ui3
Scenario: Broken link verification
When Admin enters the valid LMS app URL
Then HTTP response should be greater than 400

@ui4
Scenario: Application title is displayed
When Admin enters the valid LMS app URL
Then Admin should see LMS - Learning Management System

@ui5
Scenario: Application Logo is displayed
When Admin enters the valid LMS app URL
Then Admin should see Application Logo

@ui6
Scenario: Company name is displayed
When Admin enters the valid LMS app URL
Then Admin should see company name below the app name

@ui7
Scenario: Login instruction message is displayed
When Admin enters the valid LMS app URL
Then Admin should see Please login to LMS application

@ui8
Scenario: Input field is displayed
When Admin enters the valid LMS app URL
Then Admin should see two text fields

@ui9
Scenario: Role Dropdown is displayed
When Admin enters the valid LMS app URL
Then Admin should see one dropdown

@ui10
Scenario: Text presence on the first field
When Admin enters the valid LMS app URL
Then Admin should see User in the first text field

@ui11
Scenario: Text presence on the second field
When Admin enters the valid LMS app URL
Then Admin should see Password in the second text field

@ui12
Scenario: Asterisk is displayed for user field
When Admin enters the valid LMS app URL
Then Admin should see asterisk mark  next to text for user field

@ui13
Scenario: Asterisk is displayed for password field
When Admin enters the valid LMS app URL
Then Admin should see asterisk mark  next to password text

@ui14
Scenario: Placeholder presence in dropdown
When Admin enters the valid LMS app URL
Then Admin should see select the role placeholder in dropdown

@ui15
Scenario: Dropdown options to select role
When Admin enters the valid LMS app URL
Then Admin should see Admin, staff, student options in dropdown

@ui16
Scenario: Alignment of the login form
When Admin enters the valid LMS app URL
Then Admin should see login form in the centre of the page

@ui17
Scenario: Input field label alignment
When Admin enters the valid LMS app URL
Then Admin should see Username, Password and select the role labels left-aligned above their respective input fields

@ui18
Scenario: Login button is displayed
When Admin enters the valid LMS app URL
Then Admin should see login button

@ui19
Scenario: User field Placeholder text colour
When Admin enters the valid LMS app URL
Then Admin should see user text in gray color

@ui20
Scenario: Password field Placeholder text colour
When Admin enters the valid LMS app URL
Then Admin should see password text in gray color

# ============================================================

# Login Page - Functional Verification

# ============================================================

@functional1
Scenario: Successful login with valid credentials
Given Admin is on login Page
When Admin clicks login in button after entering valid credentials
Then Admin should land on home page

@functional2
Scenario: Login with special character in username
Given Admin is on login Page
When Admin clicks login in button after entering special character in username
Then Admin should see Error message for Invalid username 

@functional3
Scenario: Login attempt with empty username
Given Admin is on login Page
When Admin enters only the password and selects a role
Then Admin should see Error message Please enter your user name

@functional4 @negative
Scenario: Login attempt with empty password
Given Admin is on login Page
When Admin enters only the username and selects a role
Then Admin should see Error message Please enter your password

@functional5 @negative
Scenario: Login attempt with wrong password
Given Admin is on login Page
When Admin clicks login in button after entering valid username , role , wrong password
Then Admin should see Error message Invalid username and password Please try again

@functional6 @negative
Scenario: Login attempt without selecting any role
Given Admin is on login Page
When Admin enters valid username and password without selecting a role
Then Admin should see Error Message Please select your role

@functional7 @negative
Scenario: Login Attempt with invalid role
Given Admin is on login Page
When Admin clicks login button after entering valid username and password with an invalid role
Then Admin should see Error Message Please select correct role

@functional8
Scenario: Login Attempt using Keyboard
Given Admin is on login Page
When Admin clicks login in button after entering  a valid credential through keyboard
Then Admin should land on home page

@functional9
Scenario: Login Attempt using Mouse
Given Admin is on login Page
When Admin clicks login in button after entering  a valid credential through mouse
Then Admin should land on home page
