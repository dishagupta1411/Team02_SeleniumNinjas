Feature: Program Module

  Background: Admin is logged in to LMS Portal
   Given Admin is in login Page to test Program module
   When Admin enter valid credentials  and clicks login button through keyboard for Program module
   
 
 
    
    Scenario: Column header name of data table
    Given Admin is on home page after Login
    When Admin clicks Program on the navigation bar
    Then Admin should see data table with column header on the Manage Program Page as Program Name, Program Description, Program Status, Edit/Delete
