@home
Feature: LMS Home Page

As an Admin
I want to access the LMS home page
So that I can verify its UI elements and information

Background:
Given Admin is on login Page
When Admin clicks login in button after entering valid credentials

# ============================================================

# Home Page - UI Verification

# ============================================================

@h1
Scenario: LMS title is displayed
Then Admin should see LMS - Learning Management System as title

@h2
Scenario: LMS title is aligned to the top left
Then LMS title should be on the top left corner of page

@h3
Scenario: Navigation bar text spelling is correct
Then Admin should see correct spelling in navigation bar text

@h4
Scenario: LMS title spelling and space is correct
Then Admin should see correct spelling and space in LMS title

@h5
Scenario: Navigation bar is aligned to the top right
Then Admin should see the navigation bar text on the top right side

@h6
Scenario: Home is first in navigation bar
Then Admin should see home in the 1st place

@h7
Scenario: Program is second in navigation bar
Then Admin should see program in the 2nd place

@h8
Scenario: Batch is third in navigation bar
Then Admin should see batch in the 3rd place

@h9
Scenario: Logout is fifth in navigation bar
Then Admin should see logout in the 5th place

@h10
Scenario: Welcome message is displayed
Then Admin should see welcome message with user name and role

@h11
Scenario: Bar chart is displayed
Then Admin should see bar chart for Active and inactive user

@h12
Scenario: User count card is displayed
Then Admin should see user count

@h13
Scenario: Program count card is displayed
Then Admin should see Program count

@h14
Scenario: Staff count card is displayed
Then Admin should see Staff count

@h15
Scenario: Batch count card is displayed
Then Admin should see batch count

@h16
Scenario: Staff data table is displayed
Then Admin should see the Staff Data table

@h17
Scenario: Staff table number header is displayed
Then Admin should see the # header in the Staff Data table

@h18
Scenario: Staff table first name header is displayed
Then Admin should see the First Name header in the Staff Data table

@h19
Scenario: Staff table last name header is displayed
Then Admin should see the Last Name header in the Staff Data table

@h20
Scenario: Staff table phone header is displayed
Then Admin should see the Phone header in the Staff Data table

@h21
Scenario: Admin is redirected to login page after logout
When Admin clicks on the logout in the menu bar
Then Admin should be redirected to the login page